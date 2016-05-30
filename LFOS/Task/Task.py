from LFOS.Resource.Resource import AbstractResource, ResourceRequests
from LFOS.Task.Timing import Timing, Credential
from LFOS.Task.Preemption import PreemptionFactory
from LFOS.Task.Priority import Priority
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Log import LOG, Logs


class AbstractTask(Timing, ResourceRequests, Priority):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        # initialize attributes of task
        Timing.__init__(self, arr_time, deadline, deadline_type, task_name, task_type)
        ResourceRequests.__init__(self)
        Priority.__init__(self)

        # To provide whether task is sporadic or not.
        self.active = True

        self.parent = None

        # eligible resources contains the resource pointers as keys and worst-case execution times of a task on the
        # resource at maximum voltage scale as values.
        self.eligible_resources = dict()

        self.input_requirement = dict()
        self.output = dict()

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

    def execute_on_active_resource(self, resource, current_time):
        self.set_wcet(self.eligible_resources[resource])
        self.start_task(current_time)

    def ready_to_execute(self, scheduler, current_time):
        return self.__release_time_check(current_time) and \
                self.is_finished() and \
                self.__data_dependency_check(scheduler)

    def add_input_requirement(self, token_type, required):
        if self.input_requirement.has_key(token_type):
            self.input_requirement[token_type] += required
        else:
            self.input_requirement[token_type] = required

    def get_input_requirement(self):
        return self.input_requirement

    def add_output(self, token_type, amount):
        if self.input_requirement.has_key(token_type):
            self.input_requirement[token_type] += amount
        else:
            self.input_requirement[token_type] = amount

    def get_output(self):
        return self.output

    def __release_time_check(self, current_time):
        return self.get_release_time() >= current_time

    def __deadline_check(self, current_time):
        return current_time + self.get_remaining_WCET() <= self.deadline.get_deadline()

    def __data_dependency_check(self, scheduler):
        return scheduler.query(self.input_requirement)

    def add_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def remove_task(self, task):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def get_sub_task_w_name(self, task_name):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)


class TerminalTask(AbstractTask):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        AbstractTask.__init__(self, arr_time, deadline, deadline_type, task_name, task_type)
        self.preemption = PreemptionFactory.create_instance('preemptable')

    def get_sub_task_w_name(self, task_name):
        return self if self.get_task_name() == task_name else None


class CompositeTask(AbstractTask):
    def __init__(self, arr_time, deadline, deadline_type, task_name, task_type):
        AbstractTask.__init__(self, arr_time, deadline, deadline_type, task_name, task_type)
        self.tasks = list()
        self.preemption = PreemptionFactory.create_instance('nonPreemptable')

    def add_task(self, task):
        if task not in self.tasks:
            task.set_parent(self)
            self.tasks.append(task)
            LOG(msg='Task %s is added to the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.INFO)
            return self.tasks[-1]

        LOG(msg='Task %s is already under the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
        return None

    def remove_task(self, task):
        if task not in self.tasks:
            LOG(msg='Task %s is not under the composite task %s.' % (task.get_task_name(), self.get_task_name()), log=Logs.WARN)
            return None

        index = self.tasks.index(task)
        return self.tasks.pop(index)

    def get_sub_task_w_name(self, task_name):
        for task in self.tasks:
            ptr = task.get_sub_task_w_name(task_name)
            if ptr:
                break

        return ptr


class TaskFactory:
    TYPES = {
        'Composite': CompositeTask,
        'Terminal': TerminalTask
    }

    @classmethod
    def create_instance(cls, _type, arr_time, deadline, deadline_type, task_name, task_type=None):
        if _type in cls.TYPES:
            return cls.TYPES[_type](arr_time, deadline, deadline_type, task_name, task_type)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None