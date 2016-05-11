from LFOS.Log import LOG, Logs
from LFOS.Resource.ResourceTypes import *
from LFOS.Resource.ResourceRequirement import *

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
        # utilizing tasks are dictionary type variable which holds the pointer to tasks as a key and reserved capacity.
        self.__total_capacity = 0.0
        self.__utilizing_tasks = dict()

        self.__power_consumption = None
        self.__mutually_exclusive_resources = list()

        # shared property can be directly related with task type or task instance
        self.__shared_task_types = list()
        self.__shared_tasks = list()

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

    def get_available_capacity(self):
        return self.__total_capacity - sum(self.__utilizing_tasks.values())


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