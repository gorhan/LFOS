from LFOS.Task.Periodicity import PeriodicityFactory
from LFOS.Log import LOG, Logs
from LFOS.Task.TaskCredential import TaskCredential
from LFOS.Task.TaskDeadlineRequirement import TaskDeadlineRequirementFactory


class TaskTiming(TaskCredential):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        self.phase = arr_time
        self.release_time = arr_time
        self.wcet = 0
        self.wcet_completed = 0

        self.fragments = list()

        # set getattr method to delegate the other function calls to object methods.
        self.deadline = TaskDeadlineRequirementFactory.create_instance(deadline_type, deadline)

        #Initialize inherited class
        super(TaskTiming, self).__init__(task_name, task_type)

        # DEFAULT = Sporadic -- the interleaving time between consecutive jobs are not known
        self.periodicity = PeriodicityFactory.create_instance('sporadic')

    def set_release_time(self, rel_time):
        self.release_time = rel_time

    def get_release_time(self):
        return self.release_time

    def set_wcet(self, wcet):
        self.wcet = wcet
        LOG(msg='New worst-case execution time is set to %.2f' % self.wcet, log=Logs.INFO)

    def get_WCET(self):
        return self.wcet

    def get_remaining_WCET(self):
        return self.wcet - self.wcet_completed

    def get_completed_WCET(self):
        return self.wcet_completed

    def is_running(self):
        if self.fragments and self.fragments[-1][1]:
            return True

        return False

    def get_last_fragment_start(self):
        return self.fragments[-1][0] if self.fragments else -1

    def start_task(self, current_tm):
        if self.is_running():
            LOG(msg='%s is already executing.' % self.get_credential(), log=Logs.WARN)
            return False

        self.fragments.append((current_tm, None))
        LOG(msg='%s is started to execute.' % self.get_credential(), log=Logs.INFO)
        return True

    def stop_task(self, current_tm):
        if self.is_running():
            self.fragments[-1][1] = current_tm
            last_fragment_duration = self.fragments[-1][1] - self.fragments[-1][0]
            self.wcet_completed += last_fragment_duration
            LOG(msg='%s is stopped.' % self.get_credential(), log=Logs.INFO)
            return self.wcet_completed

        LOG(msg='%s is not executing.' % self.get_credential(), log=Logs.WARN)
        return False

    def make_ready(self, current_time):
        return self.__next_job(current_time)

    def __next_job(self, current_time):
        if self.periodicity.get_period_type() != 'sporadic':
            iterated = list()
            while self.get_remaining_WCET() > (self.deadline.get_deadline() - current_time + self.deadline.get_penalty_duration()):
                self.release_time += self.periodicity.get_period()
                iterated.append('%.2f' % self.release_time)
            LOG(msg='%s is iterated %d times. %s' % (self.get_credential(), len(iterated), ' ,'.join(iterated)), log=Logs.INFO)
            return True

        LOG(msg='%s is sporadic. No next job.' % self.get_credential(), log=Logs.WARN)
        return False

    # delegation of misc. method calls to self.deadline object
    def __getattr__(self, item):
        import inspect

        deadline_methods = inspect.getmembers(self.deadline, predicate=inspect.ismethod)
        deadline_methods = [method_name for method_name, _ in deadline_methods]

        if item in deadline_methods:
            return getattr(self.deadline, item)
        else:
            LOG(msg='Invalid method call. There is no method %s.' % item, log=Logs.ERROR)