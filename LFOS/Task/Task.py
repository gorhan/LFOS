
from LFOS.Task.Credential import Credential
from LFOS.Task.Timing import Timing
from LFOS.Task.Priority import Priority
from LFOS.Task.Dependency import Dependency
from LFOS.Task.Preemptability import PreemptionFactory, PreemptionTypeList
from LFOS.Task.Requirement import RequirementFactory

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
        Credential.__init__(kwargs['name'], kwargs['type'])
        Timing.__init__(kwargs['phase'], kwargs['deadline'])
        Priority.__init__(kwargs['priority'] if 'priority' in kwargs else 0)

        # Default parameters. They can be changed with their internal member functions
        self.__dependencies = Dependency()
        self.__preemptability = PreemptionFactory.create_instance(PreemptionTypeList.FULLY_PREEMPTABLE)
        self.__requirement = RequirementFactory.create_instance()

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
            LOG(msg='Invalid method call. There is no method %s.' % item, log=Logs.ERROR)
            return False


class TerminalTask(TaskInterface):
    def __init__(self, **kwargs):
        TaskInterface.__init__(kwargs)


class CompositeTask(TaskInterface, list):
    def __init__(self, **kwargs):
        TaskInterface.__init__(kwargs)
        list.__init__([])


class TaskTypeList:
    TERMINAL = 'Task.Terminal'
    COMPOSITE = 'Task.Composite'


class TaskFactory:
    TYPES = {
        TaskTypeList.TERMINAL: TerminalTask,
        TaskTypeList.COMPOSITE: CompositeTask
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, **kwargs):
        if _type.get_abstraction() in cls.TYPES:
            return cls.TYPES[_type.get_abstraction()](kwargs)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None