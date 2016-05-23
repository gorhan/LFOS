from LFOS.Task.TaskTiming import TaskTiming
from LFOS.Task.Preemption import PreemptionFactory
from LFOS.Log import LOG, Logs


class AbstractTask(TaskTiming):
    def __init__(self, arr_time, wcet, deadline, deadline_type, task_name, task_type):
        # initialize timing attributes of task
        super(AbstractTask, self).__init__(arr_time, wcet, deadline, deadline_type, task_name, task_type)

        self.preemption = PreemptionFactory.create_instance('Preemptable')

        self.parent = None

    def set_parent(self, parent):
        self.parent = parent

    def add_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def remove_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def get_sub_task_w_name(self, task_name):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def __getattr__(self, item):
        return getattr(self.preemption, item)


class TerminalTask(AbstractTask):
    def __init__(self, arr_time, wcet, deadline, deadline_type, task_name, task_type):
        super(TerminalTask, self).__init__(arr_time, wcet, deadline, deadline_type, task_name, task_type)


class CompositeTask(AbstractTask, list):
    def __init__(self, arr_time, wcet, deadline, deadline_type, task_name, task_type):
        super(CompositeTask, self).__init__(arr_time, wcet, deadline, deadline_type, task_name, task_type)
        list.__init__([])

    def add_task(self, task):
        if task not in self:
            task.set_parent(self)
            self.append(task)
            LOG(msg='Task %s is added to the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.INFO)
            return self[-1]

        LOG(msg='Task %s is already under the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
        return None

    def remove(self, task):
        if task not in self:
            LOG(msg='Task %s is not under the composite task %s.' (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
            return None

        index = self.index(task)
        return self.pop(index)

class TaskFactory:
    TYPES = {
        'Composite': CompositeTask,
        'Terminal': TerminalTask
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, arr_time, wcet, deadline, deadline_type, task_name, task_type=None):
        if _type in cls.TYPES:
            return cls.TYPES[_type](arr_time, wcet, deadline, deadline_type, task_name, task_type=None)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None