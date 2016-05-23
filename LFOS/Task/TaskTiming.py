from LFOS.Task.Periodicity import PeriodicityFactory
from LFOS.Log import LOG, Logs
from LFOS.Task.TaskCredential import TaskCredential
from LFOS.Task.TaskDeadlineRequirement import TaskDeadlineRequirementFactory

class TaskTiming(TaskCredential):
    def __init__(self, arr_time, wcet, deadline, deadline_type, task_name, task_type):
        self.phase = arr_time
        self.release_time = arr_time
        self.wcet = wcet
        self.wcet_completed = 0

        # set getattr method to delegate the other function calls to object methods.
        self.deadline = TaskDeadlineRequirementFactory.create_instance(deadline_type)
        self.deadline.set_deadline(deadline)

        #Initialize inherited class
        super(TaskTiming, self).__init__(task_name, task_type)

        # DEFAULT = Sporadic -- the interleaving time between consecutive jobs are not known
        self.periodicity = PeriodicityFactory.create_instance('sporadic')

    def set_release_time(self, rel_time):
        self.release_time = rel_time

    def get_release_time(self):
        return self.release_time

    def get_WCET(self):
        return self.wcet

    def get_remaining_WCET(self):
        return self.wcet - self.wcet_completed

    def get_completed_WCET(self):
        return self.wcet_completed

    def update_job(self, current_time):
        if current_time < self.deadline:
            self.__iterate_release_time(current_time)

            if self.wcet != self.wcet_completed:
                return False

        elif current_time + self.get_remaining_WCET() < self.deadline:
            LOG(msg='Unable to update job. %s' % (self.get_credential()), log=Logs.ERROR)

    def __iterate_release_time(self, time):
        while self.release_time < time:
            self.release_time += self.periodicity.get_period()

    # delegation of misc. method calls to self.deadline object
    def __getattr__(self, item):
        import inspect

        deadline_methods = inspect.getmembers(self.deadline, predicate=inspect.ismethod)
        deadline_methods = [method_name for method_name, _ in deadline_methods]

        if item in deadline_methods:
            return getattr(self.deadline, item)
        else:
            LOG(msg='Invalid method call. There is no method %s.' % item, log=Logs.ERROR)