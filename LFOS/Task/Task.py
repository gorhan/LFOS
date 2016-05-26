from LFOS.Resource.Resource import AbstractResource, ResourceRequests
from LFOS.Task.TaskTiming import TaskTiming
from LFOS.Task.Preemption import PreemptionFactory
from LFOS.Task.TaskDependency import TaskDependency
from LFOS.Task.TaskPriority import TaskPriority
from LFOS.Log import LOG, Logs


class AbstractTask(TaskTiming, ResourceRequests, TaskDependency, TaskPriority):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        # initialize attributes of task
        TaskTiming.__init__(arr_time, deadline, deadline_type, task_name, task_type)
        ResourceRequests.__init__()
        TaskDependency.__init__()
        TaskPriority.__init__()

        # To provide whether task is sporadic or not.
        self.active = True

        self.parent = None

        # eligible resources contains the resource pointers as keys and worst-case execution times of a task on the
        # resource at maximum voltage scale as values.
        self.eligible_resources = dict()

        self.dependent_data = dict()

    def set_parent(self, parent):
        self.parent = parent

    def add_eligible_resource(self, resource, wcet_max_scale):
        if not isinstance(resource, AbstractResource):
            LOG(msg='Given parameter is not a resource.', log=Logs.ERROR)
            return False

        if resource.get_resource_type_name() == 'active' and resource not in self.eligible_resources:
            self.eligible_resources[resource] = wcet_max_scale
            LOG(msg='%s is added to the list of eligible resources of %s' % (resource.get_credential(), self.get_credential()), log=Logs.INFO)
            return True
        elif resource not in self.eligible_resources:
            LOG(msg='%s is already in the list of eligible resources of %s' % (resource.get_credential(), self.get_credential()), log=Logs.INFO)
        else:
            LOG(msg='Given resource is not at the type of active.', log=Logs.WARN)

        return False

    def remove_eligible_resource(self, resource):
        if resource in self.eligible_resources:
            self.eligible_resources.pop(resource)
            LOG(msg='%s is removed from the list of eligible resources of %s' % (resource.get_credential(), self.get_credential()), log=Logs.INFO)
            return True

        LOG(msg='%s is not in the list of eligible resources of %s' % (resource.get_credential(), self.get_credential()), log=Logs.INFO)
        return False

    def execute_on_active_resource(self, resource):
        if resource in self.eligible_resources:
            self.set_wcet(self.eligible_resources[resource])
            return True

        LOG(msg='Given active resource %s is not in the list of eligible resource of %s' % (resource.get_credential(), self.get_credential()), log=Logs.ERROR)
        return False

    def ready_to_execute(self, current_time):

    def add_data_dependency(self, token_type, required):
        if self.dependent_data.has_key(token_type):
            self.dependent_data[token_type] += required
        else:
            self.dependent_data[token_type] = required

    def get_dependent_data(self):
        return self.dependent_data

    def add_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def remove_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def get_sub_task_w_name(self, task_name):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)


class TerminalTask(AbstractTask):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        super(TerminalTask, self).__init__(arr_time, deadline, deadline_type, task_name, task_type)
        self.preemption = PreemptionFactory.create_instance('preemptable')

    def __getattr__(self, item):
        return getattr(self.preemption, item)

    def get_sub_task_w_name(self, task_name):
        return self if self.get_task_name() == task_name else None


class CompositeTask(AbstractTask, list):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        super(CompositeTask, self).__init__(arr_time, deadline, deadline_type, task_name, task_type)
        list.__init__([])
        self.preemption = PreemptionFactory.create_instance('nonPreemptable')

    def add_task(self, task):
        if task not in self:
            task.set_parent(self)
            self.append(task)
            LOG(msg='Task %s is added to the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.INFO)
            return self[-1]

        LOG(msg='Task %s is already under the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
        return None

    def remove_task(self, task):
        if task not in self:
            LOG(msg='Task %s is not under the composite task %s.' (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
            return None

        index = self.index(task)
        return self.pop(index)

    def __getattr__(self, item):
        return getattr(self.preemption, item)

    def get_sub_task_w_name(self, task_name):
        for task in self:
            ptr = task.get_sub_task_w_name(task_name)
            if ptr:
                break

        return ptr


class TaskFactory:
    TYPES = {
        'Composite': CompositeTask,
        'Terminal': TerminalTask
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, arr_time, deadline, deadline_type, task_name, task_type=None):
        if _type in cls.TYPES:
            return cls.TYPES[_type](arr_time, deadline, deadline_type, task_name, task_type=None)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None