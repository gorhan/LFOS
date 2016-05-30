from LFOS.Task.Periodicity import PeriodicityFactory
from LFOS.Log import LOG, Logs
from LFOS.Task.Credential import Credential
from LFOS.Task.DeadlineRequirement import DeadlineRequirementFactory


class Timing(Credential):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        self.phase = arr_time
        self.release_time = arr_time
        self.wcet = 0
        self.__running = False

        self.fragments = list()

        # set getattr method to delegate the other function calls to object methods.
        self.deadline = DeadlineRequirementFactory.create_instance(deadline_type, deadline)

        #Initialize inherited class
        super(Timing, self).__init__(task_name, task_type)

        # DEFAULT = Sporadic -- the interleaving time between consecutive jobs are not known
        self.periodicity = PeriodicityFactory.create_instance('sporadic')

    def set_phase(self, phase_time):
        self.phase = phase_time

    def get_phase(self):
        return self.phase

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
        return self.wcet - self.get_completed_WCET()

    def get_completed_WCET(self):
        return sum([map(lambda frag: frag[1]-frag[0], self.fragments)])

    def is_running(self, current_time):
        if self.fragments and self.__running:
            self.fragments[-1][1] = current_time
            if self.is_finished():
                self.stop_task(current_time)
                return False
            return True

        return False

    def is_finished(self):
        return self.get_remaining_WCET() <= 0

    def get_last_fragment_start(self):
        return self.fragments[-1][0] if self.fragments else -1

    def start_task(self, current_tm):
        if self.is_running(current_tm):
            LOG(msg='%s is already executing at %.3f.' % (self.get_credential(), current_tm), log=Logs.WARN)
            return False

        self.fragments.append((current_tm, current_tm))
        self.__running = True
        LOG(msg='%s is started to execute at %.3f.' % (self.get_credential(), current_tm), log=Logs.INFO)
        return True

    def stop_task(self, current_tm):
        self.fragments[-1][1] = current_tm
        LOG(msg='%s is stopped at %.3f.' % (self.get_credential(), current_tm), log=Logs.INFO)
        self.make_ready(current_tm)
        self.__running = False
        return self

    def make_ready(self, current_time):
        return self.__next_job(current_time)

    def __next_job(self, current_time):
        if self.periodicity.get_period_type() != 'sporadic':
            iterated = list()
            lifecycle = self.deadline.get_deadline() - self.release_time
            while current_time > self.deadline.get_extended_deadline() or self.is_finished():
                self.release_time += self.periodicity.get_period()
                self.deadline.set_deadline(self.release_time + lifecycle)
                self.fragments = list()
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