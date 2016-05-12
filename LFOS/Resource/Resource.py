from LFOS.Log import LOG, Logs
from LFOS.Resource.ResourceTypes import *
from LFOS.Resource.ResourceRequirement import *
from LFOS.Task import Task, TaskType

SYSTEM_NAME = 'System'

class AbstractResource(object):
    def __init__(self, res_type, res_name, parent):
        self.type = res_type
        self.name = res_name
        self.parent = parent

    def set_resource_name(self, res_name):
        self.name = res_name

    def set_resource_type(self, res_type):
        self.type = res_type

    def get_resource_type_name(self):
        return self.type.get_resource_type_name()

    def set_parent(self, resource):
        self.parent = resource

    def get_parent(self):
        return self.parent

    def add(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_sibling_resources(self, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_child_resources(self, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def request(self, requirements):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def alloc(self, requester, resources):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def free(self, running_task):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class TerminalResource(AbstractResource):
    def __init__(self, res_type, res_name, parent):
        super(TerminalResource, self).__init__(res_type, res_name, parent)

        # total capacity is float
        # running tasks are dictionary type variable which holds the pointer to tasks as a key and reserved capacity.
        self.__total_capacity = 0.0
        self.__running_tasks = dict()

        self.__power_consumption = None
        self.__mutually_exclusive_resources = list()

        # dedicated property can be directly related with task type or task instance
        self.__dedicated_task_types = list()
        self.__dedicated_tasks = list()

        # Resource-based objectives will be determined in the next phases.
        self.__resource_objectives = None

    def get_sibling_resources(self, resource_type=None):
        return self.parent.get_child_resources(resource_type)

    def request(self, requirements):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def alloc(self, requester, resources):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def free(self, running_task):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_total_capacity(self, capacity):
        self.__total_capacity = capacity

    def get_total_capacity(self):
        return self.__total_capacity

    def get_utilized_capacity(self):
        return sum(self.__running_tasks.values())

    def get_available_capacity(self):
        return self.__total_capacity - self.get_utilized_capacity()

    def get_running_tasks(self):
        return self.__running_tasks

    def set_power_consumption(self, pc_instance):
        if not isinstance(pc_instance, AbstractResource):
            LOG(msg='Given parameter is NOT an instance of PowerConsumption module', log=Logs.ERROR)
            return None

        self.__power_consumption = pc_instance
        LOG(msg='Power consumption has been specified.', log=Logs.INFO)

    def get_power_consumption(self):
        return self.__power_consumption

    def add_mutually_exclusive_resources(self, resource_or_list):
        if type(resource_or_list) is list:
            self.__mutually_exclusive_resources += resource_or_list
        elif isinstance(resource_or_list, AbstractResource):
            self.__mutually_exclusive_resources.append(resource_or_list)
        else:
            LOG(msg='Invalid parameter. The parameter is not the list or any instance of Resources.')
            return False

        # to eliminate the duplicates
        self.__mutually_exclusive_resources = list(set(self.__mutually_exclusive_resources))
        return True

    def delete_mutually_exclusive_resource(self, resource_or_list):
        deleted = None
        if type(resource_or_list) is list:
            deleted = list()
            for resource in resource_or_list:
                try:
                    index = self.__mutually_exclusive_resources.index(resource)
                    deleted.append(self.__mutually_exclusive_resources.pop(index))
                    LOG(msg='Resource %s is deleted from the list of mutually exclusive resources.' % deleted.name)
                except ValueError:
                    LOG(msg='Resource %s is not in the list of mutually exclusive resources.' % resource.name, log=Logs.WARN)
        elif isinstance(resource_or_list, AbstractResource):
            try:
                index = self.__mutually_exclusive_resources.index(resource_or_list)
                deleted = self.__mutually_exclusive_resources.pop(index)
                LOG(msg='Resource %s is deleted from the list of mutually exclusive resources.' % deleted.name)
            except ValueError:
                LOG(msg='Resource %s is not in the list of mutually exclusive resources.' % resource_or_list.name, log=Logs.WARN)
        else:
            LOG(msg='Invalid parameter. The parameter is not the list or any instance of Resources.', log=Logs.ERROR)

        return deleted

    def get_mutually_exclusive_resources(self):
        return self.__mutually_exclusive_resources

    # TODO: the Task type has to be modified when Task module implemented
    def dedicate_resource(self, task_or_type):
        if isinstance(task_or_type, TaskType):
            if task_or_type in self.__dedicated_task_types:
                LOG(msg='The given task type for dedicated resource is already in the list')
                return task_or_type
            else:
                self.__dedicated_task_types.append(task_or_type)
        elif isinstance(task_or_type, Task):
            if task_or_type in self.__dedicated_tasks:
                LOG(msg='The given task for dedicated resource is already in the list')
                return task_or_type
            else:
                self.__dedicated_tasks.append(task_or_type)
        else:
            LOG(msg='Invalid parameter. The parameter is not an instance of Task or Task Types modules.', log=Logs.ERROR)
            return None
        return task_or_type

    def remove_from_dedicated(self, task_or_type):
        deleted = None
        if isinstance(task_or_type, TaskType):
            try:
                index = self.__dedicated_task_types.index(task_or_type)
                deleted = self.__dedicated_task_types.index(index)
                LOG(msg='Task type %s is deleted from the list of dedicated task types.' % task_or_type.type_name)
            except ValueError:
                LOG(msg='Resource %s is not in the list of dedicated task types.' % task_or_type.type_name, log=Logs.WARN)
        elif isinstance(task_or_type, Task):
            try:
                index = self.__dedicated_tasks.index(task_or_type)
                deleted = self.__dedicated_tasks.index(index)
                LOG(msg='Task %s is deleted from the list of dedicated task types.' % deleted.name)
            except ValueError:
                LOG(msg='Task %s is not in the list of dedicated tasks.' % deleted.name, log=Logs.WARN)
        else:
            LOG(msg='Invalid parameter. The parameter is not an instance of Task or TaskType modules.', log=Logs.ERROR)

        return deleted

    def make_shared(self):
        self.__dedicated_task_types = list()
        self.__dedicated_tasks = list()

    def get_dedicated_tasks_or_types(self, _type):
        if _type is TaskType:
            return self.__dedicated_task_types
        elif _type is Task:
            return self.__dedicated_tasks

        LOG(msg='Invalid type requested.', log=Logs.ERROR)
        return None


class CompositeResource(AbstractResource, list):
    def __init__(self, res_type, res_name, parent):
        super(CompositeResource, self).__init__(res_type, res_name, parent)
        list.__init__([])

    def add(self, resource):
        if resource.get_resource_type_id() == SYSTEM_NAME:
            LOG(msg='Invalid procedure call. System cannot be add any other composite resource', log=Logs.ERROR)
            return None

        if resource in self:
            LOG(msg='The resource is already in the scope of the composite resource %s' % self.name, log=Logs.WARN)
            return None
        else:
            self.append(resource)
            resource.set_parent(self)

        return self

    def remove(self, resource):
        if resource in self:
            self.pop(resource)
            resource.set_parent(None)
        else:
            LOG(msg='The resource is NOT in the scope of the composite resource %s' % self.name, log=Logs.WARN)

    def get_sibling_resources(self, resource_type=None):
        return self.parent.get_child_resources(resource_type) if self.parent else None

    def get_child_resources(self, resource_type=None):
        if resource_type:
            return [resource for resource in self if resource_type.get_resource_type_name() == resource.get_resource_type_name()]

        return self

    def request(self, requirements):
        try:
            assert isinstance(requirements, ResourceRequirement)
        except AssertionError:
            LOG(msg='Given parameter must be an instance of ResourceRequirement class', log=Logs.ERROR)
            return None

        active_requirement = requirements.get_resources(ACTIVE)
        passive_requirement = requirements.get_resources(PASSIVE)

        # TODO: find eligible active resource to proceed


    def alloc(self, requester, resources):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def free(self, running_task):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class ResourceFactory:
    RESOURCE_TYPES = {
        ACTIVE: TerminalResource,
        PASSIVE: TerminalResource,
        COMPOSITE: CompositeResource
    }

    # resource_type is an object of ResourceType class.
    @staticmethod
    def create_resource(resource_type, res_name, parent=None):
        try:
            assert isinstance(resource_type, ResourceType)
        except AssertionError:
            LOG(msg='Invalid construction request for Resource object.', log=Logs.ERROR)
            return None

        return ResourceFactory.RESOURCE_TYPES[resource_type.get_resource_type_name()](resource_type, res_name, parent)


# the root of all resource models
System_type = ResourceType(SYSTEM_NAME, COMPOSITE)
System = ResourceFactory.create_resource(System_type, 'ComputingSystem')