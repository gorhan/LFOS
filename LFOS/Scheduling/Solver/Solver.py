from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Schedule.Schedule import ScheduleItem, Schedule
from LFOS.Task.Task import TaskInterface
from LFOS.Resource.Resource import TerminalResource
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Data.TokenPool import Token, TokenPool
from Numberjack import *


class SolverAdapter(object):
    def __init__(self, **kwargs):
        self.__model = Model()

        self.__solver = None
        self.__optimized = False
        self.__solver_type = kwargs['solver'] if 'solver' in kwargs else 'SCIP'
        self.__verbose = kwargs['verbose'] if 'verbose' in kwargs else 10
        self.__time_cutoff = kwargs['time_cutoff'] if 'time_cutoff' in kwargs else 3


        self.__jobs = None
        self.__resources = None
        self.__token_pool = None
        self.__last_optimized_schedule = None

        '''
            Solver variables are defined from here to the end of this function
        '''
        # Actual variables to hold the schedule
        self.__Allocation = None

        # Start and End times of the jobs
        self.__Start = None
        self.__AuxS = None
        self.__End = None
        self.__AuxE = None

        # Objectives to be satisfied
        self.__Lateness = None
        self.__Earliness = None
        self.__Centering = None

        # Token pool
        self.__TokenPool = None

        self.__latest_deadline = 0

    def set_solver_type(self, new_solver_type):
        if new_solver_type not in available_solvers():
            LOG(msg='Invalid solver type. Possible Solver Types= %s' % (', '.join(available_solvers())), log=Logs.ERROR)
            return False

        self.__solver_type = new_solver_type
        self.__optimized = False
        LOG(msg='New solver type has been set. Solver Type=%s' % self.__solver_type)
        return True

    def get_solver_type(self):
        return self.__solver_type

    @classmethod
    def get_solver_types(cls):
        return available_solvers()

    def _define_variables(self, jobs, resources, token_pool):
        assert isinstance(token_pool, TokenPool)
        self.__optimized = False
        self.__jobs = jobs
        self.__resources = resources
        self.__token_pool = token_pool

        self.__latest_deadline = self.__get_latest_deadline()

        self.__Allocation = {(resource, job): VarArray(self.__latest_deadline, 0, resource.get_capacity()) for resource in self.__resources for job in self.__jobs}

        self.__Start = {job: Variable(job.get_release_time(), job.get_extended_deadline() - job.get_execution_time()) for job in self.__jobs}
        self.__End = {job: Variable(job.get_release_time() + job.get_execution_time(), job.get_extended_deadline()) for job in self.__jobs}
        self.__AuxS = {job: VarArray(self.__latest_deadline, 0, job.get_extended_deadline()) for job in self.__jobs}
        self.__AuxE = {job: VarArray(self.__latest_deadline, 0, job.get_extended_deadline()) for job in self.__jobs}

        self.__TokenPool = dict()

        self.__init()

    def __init(self):
        # Initialize initial tokens with the corresponding amount of tokens in the object
        for token, amount in self.__token_pool:
            self.__TokenPool[token] = VarArray(self.__latest_deadline, 0, TokenPool.MAX_TOKEN_AMOUNT)
            self.__model += (self.__TokenPool[token][0] == amount)

    def __get_latest_deadline(self):
        return max(job.get_extended_deadline() for job in self.__jobs)

    def _optimize(self):
        self.__solver = self.__model.load(self.__solver_type)

        self.__solver.setVerbosity(self.__verbose)
        self.__solver.setTimeLimit(self.__time_cutoff)

        self.__solver.solve()
        self.__optimized = True

        if self.__solver.is_sat():
            self.__create_schedule()
            return True

        LOG(msg='SCHEDULING FAILED!!! Unable to obtain optimal solution with given scheduling parameters.', log=Logs.ERROR)
        return False

    def __create_schedule(self):
        self.__last_optimized_schedule = Schedule()

        for job in self.__jobs:
            for t in range(job.get_release_time(), job.get_extended_deadline()):
                reserved_resources = {resource: self.__Allocation[job, resource][t] for resource in self.__resources if self.__Allocation[job, resource][t] > 0}
                self.__last_optimized_schedule.append_item(job, Time.decode(t), Time.decode(t+1), reserved_resources)

    def get_last_schedule(self):
        return self.__last_optimized_schedule if self.__optimized else None
