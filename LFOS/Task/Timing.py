from LFOS.Task.Periodicity import *
from LFOS.Log import LOG, Logs
from LFOS.Task.Credential import Credential
from LFOS.Task.DeadlineRequirement import DeadlineRequirementFactory
from LFOS.Task.Preemption import *


class Timing(Credential):
    N_RUNNING = 'stopped'
    RUNNING = 'running'

    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        self.phase = arr_time
        self.release_time = arr_time
        self.wcet = 0
        self.status = Timing.N_RUNNING

        self.fragments = list()

        # set getattr method to delegate the other function calls to object methods.
        self.deadline = DeadlineRequirementFactory.create_instance(deadline_type, deadline)

        #Initialize inherited class
        Credential.__init__(self, task_name, task_type)

        # DEFAULT = Sporadic -- the interleaving time between consecutive jobs are not known
        self.periodicity = PeriodicityFactory.create_instance(PeriodicityTypeList.SPORADIC)
        self.preemption = PreemptionFactory.create_instance(PreemptionTypeList.FULLY_PREEMPTABLE)

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
        return sum(map(lambda frag: frag[1]-frag[0], self.fragments))

    def set_periodicity(self, _type):
        self.periodicity = PeriodicityFactory.create_instance(_type)

    def is_running(self, current_time):
        if self.status == Timing.RUNNING:
            self.update_time(current_time)
            return True

        return False

    def get_status(self):
        return self.status

    def set_status(self, stat):
        self.status = stat

    def is_finished(self, current_time):
        if self.status == Timing.RUNNING:
            self.update_time(current_time)

        return self.get_remaining_WCET() <= 0

    def get_last_fragment_start(self):
        # print '[%f, %f]' % (self.fragments[-1][0], self.fragments[-1][1])
        return self.fragments[-1][0] if self.fragments else None

    def start_task(self, current_time):
        if self.status == Timing.RUNNING:
            LOG(msg='%s is already executing at %.3f.' % (self.get_credential(), current_time), log=Logs.WARN)
            return False

        self.fragments.append([current_time, current_time])
        self.status = Timing.RUNNING
        LOG(msg='%s is started to execute at %.3f.' % (self.get_credential(), current_time), log=Logs.INFO)

        return True

    def stop_task(self, current_time):
        if self.status == Timing.N_RUNNING:
            LOG(msg='%s is not executing at %.3f.' % (self.get_credential(), current_time), log=Logs.WARN)
            return False

        if not self.is_finished(current_time):
            try:
                self.preemption.preempt(self.fragments[-1][0], current_time)
            except PreemptionError as p:
                LOG(msg='%s cannot be preempted. Reason: %s' % (self.get_credential(), p.message))
                return False

        self.fragments[-1][1] = current_time
        LOG(msg='%s is preempted%s at %.3f.' % (self.get_credential(), ' and finished' if self.is_finished(current_time) else '', current_time), log=Logs.INFO)
        self.status = Timing.N_RUNNING
        self.make_ready(current_time)

        return True

    def update_time(self, current_time):
        self.fragments[-1][1] = current_time

    def make_ready(self, current_time):
        return self.__next_job(current_time)

    def __next_job(self, current_time):
        if self.periodicity.get_period_type() != 'sporadic':
            iterated = list()
            lifecycle = self.deadline.get_deadline() - self.release_time
            while current_time > self.deadline.get_extended_deadline() or self.is_finished(current_time):
                self.release_time += self.periodicity.get_period()
                self.deadline.set_deadline(self.release_time + lifecycle)
                self.fragments = list()
                iterated.append('%.2f' % self.release_time)
            LOG(msg='%s is iterated %d times. %s' % (self.get_credential(), len(iterated), ' ,'.join(iterated)), log=Logs.INFO)
            return True

        LOG(msg='%s is sporadic. No next job.' % self.get_credential(), log=Logs.WARN)
        return False

    def set_preemption(self, _type):
        self.preemption = PreemptionFactory.create_instance(_type)

    # delegation of misc. method calls to self.deadline object
    def __getattr__(self, item):
        import inspect

        deadline_methods = inspect.getmembers(self.deadline, predicate=inspect.ismethod)
        deadline_methods = [method_name for method_name, _ in deadline_methods]

        periodicity_methods = inspect.getmembers(self.periodicity, predicate=inspect.ismethod)
        periodicity_methods = [method_name for method_name, _ in periodicity_methods]

        preemption_methods = inspect.getmembers(self.preemption, predicate=inspect.ismethod)
        preemption_methods = [method_name for method_name, _ in preemption_methods]

        if item in deadline_methods:
            return getattr(self.deadline, item)
        elif item in periodicity_methods:
            return getattr(self.periodicity, item)
        elif item in preemption_methods:
            return getattr(self.preemption, item)
        else:
            LOG(msg='Invalid method call. There is no method %s.' % item, log=Logs.ERROR)