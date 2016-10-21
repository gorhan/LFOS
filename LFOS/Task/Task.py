
from LFOS.Task.Credential import Credential
from LFOS.Task.Timing import Timing
from LFOS.Task.Priority import Priority
from LFOS.Task.Dependency import Dependency
from LFOS.Task.Preemptability import PreemptionFactory, PreemptionTypeList
from LFOS.Task.Requirement import RequirementFactory, DeadlineRequirementTypeList

from LFOS.Log import LOG, Logs

class TaskInterface(Credential, Timing, Priority):
    PRE_CHECKLIST = ['name', 'type', 'phase', 'deadline', 'periodicity']

    def __new__(cls, **kwargs):
        for key in cls.PRE_CHECKLIST:
            if key not in kwargs:
                LOG(msg='Invalid task instantiation. REASON: no \'%s\' in the arguments' % key, log=Logs.ERROR)
                return None

        return super(TaskInterface, cls).__new__(cls, kwargs)

    def __init__(self, **kwargs):
        Credential.__init__(self, kwargs['name'], kwargs['type'])
        Timing.__init__(self, kwargs['phase'], kwargs['deadline'])
        Priority.__init__(self, kwargs['priority'] if 'priority' in kwargs else 0)

        # Default parameters. They can be changed with their internal member functions
        self.__dependencies = Dependency()
        self.__preemptability = PreemptionFactory.create_instance(PreemptionTypeList.FULLY_PREEMPTABLE)
        self.__requirement = RequirementFactory.create_instance(DeadlineRequirementTypeList.SOFT)

        self.set_periodicity(kwargs['periodicity'])

    def __getattr__(self, item):
        import inspect

        dependency_methods = inspect.getmembers(self.__dependencies, predicate=inspect.ismethod)
        dependency_methods = [method_name for method_name, _ in dependency_methods]

        requirement_methods = inspect.getmembers(self.__requirement, predicate=inspect.ismethod)
        requirement_methods = [method_name for method_name, _ in requirement_methods]

        preemption_methods = inspect.getmembers(self.__preemptability, predicate=inspect.ismethod)
        preemption_methods = [method_name for method_name, _ in preemption_methods]

        if item in dependency_methods:
            return getattr(self.__dependencies, item)
        elif item in requirement_methods:
            return getattr(self.__requirement, item)
        elif item in preemption_methods:
            return getattr(self.__preemptability, item)
        else:
            return super(TaskInterface, self).__getattr__(item)

    def info(self, detailed=False):
        credential_detail = '%s %s::%s %s\n' % ('#' * 20, self.get_name(), self.get_type(), '#' * 20)
        header_length = len(credential_detail)
        if detailed:
            timing_detail = '\tTIMING:\n'
            timing_detail += '%sRelease Time=%.2f\n' % ('\t'*2, self.get_release_time())
            timing_detail += '%sDeadline=%.2f\n' % ('\t'*2, self.get_deadline())
            timing_detail += '%sWCET=%.2f\n' % ('\t' * 2, self.get_execution_time())
            timing_detail += '%sPeriodicty Type=%s\n' % ('\t' * 2, self.get_period_type())
            timing_detail += '%sPeriod=%.2f\n' % ('\t' * 2, self.get_period())

            priority_detail = '\tPRIORITY:\n'
            priority_detail += '%sPriority=%d [%d %d]\n' % ('\t'*2, self.get_priority(), Priority.MIN_PRIORITY, Priority.MAX_PRIORITY)

            dependency_detail = '\tDEPENDENCY:\n'
            dependency_detail += '%s[%s]\n' % ('\t'*2, '\n'.join(map(str, self.get_dependency_list())) if self.get_dependency_list() else 'EMPTY')

            preemption_detail = '\tPREEMPTABILITY:\n'
            preemption_detail += '%s%s in every %.2f\n' % ('\t'*2, self.get_preemption_type(), self.get_non_preemtable_execution_duration())

            requirement_detail = '\tREQUIREMENT:\n'
            requirement_detail += '%sDeadline Requirement Type=%s\n' % ('\t'*2, self.get_deadline_requirement())
            requirement_detail += '%sPenalty (per unit time)=%.2f\n' % ('\t'*2, self.get_penalty_per_unit_time())
            requirement_detail += '%sPenalty Duration=%.2f\n' % ('\t' * 2, self.get_penalty_duration())
            requirement_detail += '%sRequired Resources:\n\t\t\t%s\n' % ('\t' * 2, '\n\t\t\t'.join(map(str, self.get_required_resources())) if self.get_required_resources() else 'EMPTY')

            granularity_detail ='\tGRANULARITY:%s\n' % (self.granularity())

            print credential_detail\
                  + timing_detail\
                  + priority_detail\
                  + dependency_detail\
                  + preemption_detail\
                  + requirement_detail\
                  + granularity_detail
            print '#' * header_length
        else:
            print credential_detail

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