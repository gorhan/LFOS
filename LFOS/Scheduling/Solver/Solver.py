from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Schedule.Schedule import ScheduleItem, Schedule
from LFOS.Task.Task import TaskInterface
from LFOS.Resource.Resource import TerminalResource
from LFOS.Data.TokenPool import Token, TokenPool
from Numberjack import *


class SolverAdapter(object):
    def __init__(self, **kwargs):
        self.__model = Model()

        self.__solver = None
        self.__solver_type = kwargs['solver'] if 'solver' in kwargs else 'SCIP'
        self.__verbose = kwargs['verbose'] if 'verbose' in kwargs else 10
        self.__time_cutoff = kwargs['time_cutoff'] if 'time_cutoff' in kwargs else 3

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
        LOG(msg='New solver type has been set. Solver Type=%s' % self.__solver_type)
        return True

    def get_solver_type(self):
        return self.__solver_type

    @classmethod
    def get_solver_types(cls):
        return available_solvers()

    def _define_variables(self, jobs, resources, token_pool):
        assert isinstance(token_pool, TokenPool)

        self.__latest_deadline = self.__get_latest_deadline(jobs)

        self.__Allocation = {(resource, job): VarArray(self.__latest_deadline, 0, resource.get_capacity()) for resource in resources for job in jobs}

        self.__Start = {job: Variable(job.get_release_time(), job.get_extended_deadline() - job.get_execution_time()) for job in jobs}
        self.__End = {job: Variable(job.get_release_time() + job.get_execution_time(), job.get_extended_deadline()) for job in jobs}
        self.__AuxS = {job: VarArray(self.__latest_deadline, 0, job.get_extended_deadline()) for job in jobs}
        self.__AuxE = {job: VarArray(self.__latest_deadline, 0, job.get_extended_deadline()) for job in jobs}

        self.__TokenPool = dict()

        self.__init(token_pool)

    def __init(self, token_pool):
        # Initialize initial tokens with the corresponding amount of tokens in the object
        for token, amount in token_pool:
            self.__TokenPool[token] = VarArray(self.__latest_deadline, 0, TokenPool.MAX_TOKEN_AMOUNT)
            self.__model += (self.__TokenPool[token][0] == amount)

    def __get_latest_deadline(self, jobs):
        return max(job.get_extended_deadline() for job in jobs)

    def _optimize(self):
        self.__solver = self.__model.load(self.__solver_type)

        self.__solver.setVerbosity(self.__verbose)
        self.__solver.setTimeLimit(self.__time_cutoff)

        self.__solver.solve()