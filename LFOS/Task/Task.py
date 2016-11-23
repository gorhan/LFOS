
from LFOS.Task.Credential import Credential
from LFOS.Task.Timing import Timing
from LFOS.Task.Priority import Priority
from LFOS.Task.Dependency import Dependency
from LFOS.Task.Preemptability import PreemptionTypeList, Preemption
from LFOS.Task.Requirement import DeadlineRequirementTypeList, DeadlineRequirement
from LFOS.Task.Periodicity import PeriodicityTypeList

from LFOS.Log import LOG, Logs
from copy import copy, deepcopy


class TaskInterface(Credential, Timing, Priority, Dependency, Preemption, DeadlineRequirement):
    PRE_CHECKLIST = ['name', 'type', 'phase', 'deadline', 'periodicity']

    def __init__(self, **kwargs):
        Credential.__init__(self, kwargs['name'], kwargs['type'])
        Timing.__init__(self, kwargs['phase'], kwargs['deadline'])
        Priority.__init__(self, kwargs['priority'] if 'priority' in kwargs else 0)
        Dependency.__init__(self)
        DeadlineRequirement.__init__(self, kwargs['deadline_type'] if 'deadline_type' in kwargs else DeadlineRequirementTypeList.HARD)
        Preemption.__init__(self, kwargs['preemptability'] if 'preemptability' in kwargs else PreemptionTypeList.FULLY_PREEMPTABLE)

        self.set_periodicity(kwargs['periodicity'])

        self.firing_tokens = kwargs['token_name'] if 'token_name' in kwargs else ['__%s__' % self.get_name()]
        self.num_firing_tokens = kwargs['token_num'] if 'token_num' in kwargs else [1] * len(self.firing_tokens)

    def get_output_tokens(self):
        return [[token, self.num_firing_tokens[i]] for i, token in enumerate(self.firing_tokens)]

    def get_token_number_wrt_token(self, token):
        if token in self.firing_tokens:
            pos = self.firing_tokens.index(token)
            return self.num_firing_tokens[pos]

        return 0

    def get_relevant_token_types(self):
        output_tokens = self.firing_tokens
        dependency_tokens = [dep_item.get_token_type() for dep_item in self.get_dependency_list()]
        return output_tokens + dependency_tokens

    def info(self, detailed=False):
        credential_detail = '%s %s::%s %s' % ('#' * 20, self.get_name(), self.get_type(), '#' * 20)
        header_length = len(credential_detail)
        if detailed:
            timing_detail = '\n\tTIMING:\n'
            timing_detail += '%sRelease Time=%.2f\n' % ('\t'*2, self.get_release_time())
            timing_detail += '%sDeadline=%.2f\n' % ('\t'*2, self.get_deadline())
            timing_detail += '%sWCET=%.2f\n' % ('\t' * 2, self.get_execution_time())
            timing_detail += '%sPeriodicty Type=%s\n' % ('\t' * 2, self.get_period_type())
            timing_detail += '%sPeriod=%.2f\n' % ('\t' * 2, self.get_period())

            priority_detail = '\tPRIORITY:\n'
            priority_detail += '%sPriority=%d [%d %d]\n' % ('\t'*2, self.get_priority(), Priority.MIN_PRIORITY, Priority.MAX_PRIORITY)

            dependency_detail = '\tDEPENDENCY:\n'
            dependency_detail += '%s[%s]\n' % ('\t'*2, ('\n%s' % ('\t'*2)).join(map(str, self.get_dependency_list())) if self.get_dependency_list() else 'EMPTY')

            preemption_detail = '\tPREEMPTABILITY:\n'
            preemption_detail += '%s%s in every %.2f\n' % ('\t'*2, self.get_preemption_type(), self.get_non_preemtable_execution_duration())

            requirement_detail = '\tREQUIREMENT:\n'
            requirement_detail += '%sDeadline Requirement Type=%s\n' % ('\t'*2, self.get_deadline_requirement())
            requirement_detail += '%sPenalty (per unit time)=%.2f\n' % ('\t'*2, self.get_penalty_per_unit_time())
            requirement_detail += '%sPenalty Duration=%.2f\n' % ('\t' * 2, self.get_penalty_duration())
            requirement_detail += '%sRequired Resources:\n\t\t\t%s\n' % ('\t' * 2, '\n\t\t\t'.join(map(str, reduce(lambda r_l, r_r: r_l + r_r, self.get_required_resources().values()))) if self.get_required_resources() else 'EMPTY')

            granularity_detail ='\tGRANULARITY:%s\n' % (self.granularity())

            return credential_detail\
                  + timing_detail\
                  + priority_detail\
                  + dependency_detail\
                  + preemption_detail\
                  + requirement_detail\
                  + granularity_detail\
                  + '#' * header_length
        else:
            return credential_detail

    def granularity(self):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class TaskTypeList:
    TERMINAL = 'Task.Terminal'
    COMPOSITE = 'Task.Composite'


class TerminalTask(TaskInterface):
    def __init__(self, **kwargs):
        TaskInterface.__init__(self, **kwargs)

    def granularity(self):
        return TaskTypeList.TERMINAL

    def next_look(self):
        job = copy(self)
        new_release_time = job.get_release_time() + self.get_period()
        new_deadline = job.get_deadline() + self.get_period()

        job.set_release_time(new_release_time)
        job.set_deadline(new_deadline)

        return job

    def get_jobs(self, begin_tm, end_tm):
        periodicity_type = self.get_period_type()
        if periodicity_type == PeriodicityTypeList.APERIODIC or periodicity_type == PeriodicityTypeList.SPORADIC:
            return [self]

        job = copy(self)
        while job.get_release_time() < begin_tm:
            job = job.next_look()

        jobs = []
        release_time = job.get_release_time()
        deadline = job.get_extended_deadline(job.get_deadline())

        while begin_tm <= release_time < deadline and begin_tm <= deadline < end_tm:
            jobs += [job]
            # print '%r' % job, job.get_release_time()
            job = job.next_look()
            release_time = job.get_release_time()
            deadline = job.get_deadline()

        return jobs


class CompositeTask(TaskInterface, list):
    def __init__(self, **kwargs):
        TaskInterface.__init__(self, **kwargs)
        list.__init__([])

    def granularity(self):
        return TaskTypeList.COMPOSITE


class TaskFactory:
    TYPES = {
        TaskTypeList.TERMINAL: TerminalTask,
        TaskTypeList.COMPOSITE: CompositeTask
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, **kwargs):
        if _type in cls.TYPES:
            return cls.TYPES[_type](**kwargs)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None