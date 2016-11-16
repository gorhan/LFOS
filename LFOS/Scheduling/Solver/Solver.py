from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Schedule.Schedule import ScheduleItem, Schedule
from LFOS.Task.Task import TaskInterface
from LFOS.Resource.Resource import TerminalResource
from LFOS.Resource.Type import Type, ResourceTypeList
from LFOS.Resource.Mode import ModeTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Data.TokenPool import TokenPool
from Numberjack import *


class SolverAdapter(object):
    def __init__(self, **kwargs):
        self.__model = Model()

        self.__solver = None
        self.__optimized = False
        self.__solver_type = None
        self.set_solver_type(kwargs['solver'] if 'solver' in kwargs else 'SCIP')
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
        # assert isinstance(token_pool, TokenPool)
        self.__optimized = False
        self.__jobs = jobs
        self.__resources = resources
        self.__token_pool = token_pool

        self.__latest_deadline = self.__get_latest_deadline()

        self.__Allocation = {(resource, job): VarArray(self.__latest_deadline, 0, resource.get_capacity()) for resource in self.__resources for job in self.__jobs}

        self.__Start = {job: Variable(int(job.get_release_time()), int(job.get_extended_deadline(job.get_deadline()))) for job in self.__jobs}
        self.__End = {job: Variable(int(job.get_release_time()), int(job.get_extended_deadline(job.get_deadline()))) for job in self.__jobs}
        # self.__End = {job: VarArray(self.__latest_deadline, 0, 1) for job in self.__jobs}
        self.__AuxS = {job: VarArray(self.__latest_deadline, 0, int(job.get_extended_deadline(job.get_deadline()))) for job in self.__jobs}
        self.__AuxE = {job: VarArray(self.__latest_deadline, 0, int(job.get_extended_deadline(job.get_deadline()))) for job in self.__jobs}

        self.__TokenPool = dict()

        self.__init()

    def __init(self):
        # Initialize initial tokens with the corresponding amount of tokens in the object
        # for token, amount in self.__token_pool:
        #     self.__TokenPool[token] = VarArray(self.__latest_deadline, 0, TokenPool.MAX_TOKEN_AMOUNT)
        #     self.__model += (self.__TokenPool[token][0] == amount)

        for job in self.__jobs:
            release_time = int(job.get_release_time())
            deadline = int(job.get_extended_deadline(job.get_deadline()))
            active_resource_requirements = job.get_required_resources(ResourceTypeList.ACTIVE)
            passive_resource_requirements = job.get_required_resources(ResourceTypeList.PASSIVE)

            for requirement_item in active_resource_requirements:
                resource_type, el_resources_dict, req_capacity = requirement_item.resource_type, requirement_item.eligible_resources, requirement_item.required_capacity
                resources = el_resources_dict.keys()
                exec_time = int(el_resources_dict[resources[0]])

                self.__model += (Sum(self.__Allocation[resource, job][release_time:deadline] for resource in resources) == exec_time * req_capacity)
                for t in range(release_time, deadline):
                    self.__model += (Sum(self.__Allocation[resource, job][t] for resource in resources) <= req_capacity)

                    self.__model += (t * Sum(self.__Allocation[resource, job][t] for resource in resources) == self.__AuxE[job][t] * req_capacity)
                    self.__model += ((deadline - t) * Sum(self.__Allocation[resource, job][t] for resource in resources) == self.__AuxS[job][t] * req_capacity)

                self.__model += (Max(self.__AuxE[job][release_time:deadline]) + 1 == self.__End[job])
                self.__model += (deadline - Max(self.__AuxS[job][release_time:deadline]) == self.__Start[job])

                if not job.is_preemptable():
                    self.__model += (self.__End[job] - self.__Start[job] == exec_time)

            # TODO: The constraints for passive resource requirements have to be implemented.

        for resource in self.__resources:
            if resource.is_mode(ModeTypeList.CB_EXCLUSIVE):
                for t in range(self.__latest_deadline):
                    self.__model += (Sum(self.__Allocation[resource, job][t] for job in self.__jobs) <= resource.get_capacity())
            elif resource.is_mode(ModeTypeList.SB_EXCLUSIVE):
                exclusive_resources = resource.get_exclusive_resources()
                for exc_resource in exclusive_resources:
                    for t in range(self.__latest_deadline):
                        self.__model += (Sum(self.__Allocation[resource, job][t] for job in self.__jobs) * Sum(self.__Allocation[exc_resource, job][t] for job in self.__jobs) == 0)


    def __get_latest_deadline(self):
        return max(int(job.get_extended_deadline(job.get_deadline())) for job in self.__jobs)

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
            print '%s --> Start=%d, End=%d' % (job.get_credential(), self.__Start[job].get_value(), self.__End[job].get_value())
            print [item.get_value() for item in self.__AuxS[job]]
            print [item.get_value() for item in self.__AuxE[job]]
            for t in range(job.get_release_time(), job.get_extended_deadline(job.get_deadline())):
                reserved_resources = {resource: self.__Allocation[resource, job][t].get_value() for resource in self.__resources if self.__Allocation[resource, job][t].get_value() > 0}
                print [t * sum([self.__Allocation[resource, job][t].get_value() for resource in self.__resources])]
                # print reserved_resources
                if reserved_resources:
                    self.__last_optimized_schedule.append_item(job, Time.decode(t), Time.decode(t+1), reserved_resources)

    def get_last_schedule(self):
        return self.__last_optimized_schedule if self.__optimized else None
