from LFOS.Resource.Type import *
from LFOS.Resource.Mode import *
from LFOS.Resource.Power import *

from copy import copy

ROOT_TYPE = Type(ResourceTypeList.COMPOSITE, 'ROOT')


class ResourceInterface(object):
    ACCESSIBILITY = dict()
    ROOT = None

    def __init__(self, res_type, res_name, parent):
        assert isinstance(res_type, Type)

        self.type = res_type
        self.name = res_name
        self.parent = parent

        if not self.type.same_abstraction(ResourceTypeList.COMPOSITE):
            ResourceInterface.ACCESSIBILITY[self] = set()

    def get_credential(self):
        return '%s [%s, %s]' % (self.name, self.type.get_abstraction(), self.type.get_identifier())

    def get_type(self):
        return self.type

    def get_resource_name(self):
        return self.name

    def change_resource_name(self, new_res_name):
        self.name = new_res_name

    def set_parent_resource(self, new_parent):
        self.parent = new_parent

    def get_parent_resource(self):
        return self.parent

    def get_root_resource(self):
        resource_ptr = self
        while resource_ptr.parent:
            resource_ptr = resource_ptr.parent

        return resource_ptr

    def print_accessibilites(self):
        for resource, resource_set in ResourceInterface.ACCESSIBILITY.items():
            print '%s:' % resource.info()
            for accessible_resource in resource_set:
                print '\t%s' % accessible_resource.info()

    @staticmethod
    def get_root():
        return ResourceInterface.ROOT

    def is_running(self):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def add(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_sibling_resources(self, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_child_resources(self, self_resource=None, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    # def request(self, task, excluding_tasks=[]):
    #     LOG(msg='Invalid procedure call', log=Logs.ERROR)
    #
    # def alloc(self, requester, resources):
    #     LOG(msg='Invalid procedure call', log=Logs.ERROR)
    #
    # def free(self, running_task):
    #     LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def search_resources(self, response, **kwargs):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def info(self, detailed=False):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def pretty_print(self, indent=0):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def update_resource_accessibilities(self, flag):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class TerminalResource(ResourceInterface, Mode):
    def __init__(self, type, res_name, parent):
        ResourceInterface.__init__(self, type, res_name, parent)
        Mode.__init__()

        self.__capacity = 0.0
        self.__running_tasks = dict()

        self.__power = None

        self.__renewable = True
        self.__resource_objectives = None

    def is_running(self):
        return True if self.__running_tasks else False

    def set_capacity(self, new_capacity):
        if sum(self.__running_tasks.values()) > new_capacity:
            LOG(msg='Running task is utilizing more capacity than the desired capacity.', log=Logs.WARN)
            return False

        self.__capacity = new_capacity
        LOG(msg='New capacity is set. Capacity:%.2f' % self.__capacity)
        return True

    def set_power_consumption(self, pc_instance):
        if not isinstance(pc_instance, Power):
            LOG(msg='Given parameter is NOT an instance of PowerConsumption module', log=Logs.ERROR)
            return None

        self.__power = pc_instance
        LOG(msg='Power consumption has been specified.', log=Logs.INFO)

    def get_power(self):
        return self.__power

    def get_capacity(self):
        return self.__capacity

    def get_available_capacity(self):
        if self.__mode.is_mode(ModeTypeList.SHARED):
            return self.__capacity
        elif self.__mode.is_mode(ModeTypeList.CB_EXCLUSIVE):
            return self.__capacity - sum(self.__running_tasks.values())
        else:
            for exc_resource in self.__mode.get_exclusive_resources():
                if exc_resource.is_running():
                    LOG(msg='Exclusive resource is running. Resource=%s Mode=%s' % (exc_resource.get_credential(), ModeTypeList.SB_EXCLUSIVE))
                    return 0

            return self.__capacity - sum(self.__running_tasks.values())

    def get_running_tasks(self):
        return self.__running_tasks

    def get_utilized_capacity(self, by_task):
        return self.__running_tasks[by_task] if by_task in self.__running_tasks else 0.0

    def search_resources(self, response, **kwargs):
        if (kwargs.has_key('abstraction') and self.type.same_abstraction(kwargs['abstraction'])) or \
                (kwargs.has_key('identifier') and self.type.same_identifier(kwargs['identifier'])) or \
                (kwargs.has_key('type') and self.type == kwargs['type']) or \
                (kwargs.has_key('name') and self.name == kwargs['name']):
            response.append(self)

    # def alloc(self, requester, resources):
    #     if self in resources:
    #         alloc_capacity = resources.pop(self)
    #         self.__running_tasks[requester] = alloc_capacity
    #         LOG(msg='Resource is allocated. Resource=%s, Task=%s, Amount=%.2f' % (self.name, requester.name, alloc_capacity), log=Logs.INFO)
    #
    # def free(self, running_task):
    #     if running_task in self.__running_tasks:
    #         freed_capacity = self.__running_tasks.pop(running_task)
    #         LOG(msg='Resource is freed. Resource=%s, Task=%s, Amount=%.2f' % (self.name, running_task.name, freed_capacity), log=Logs.INFO)
    #         return freed_capacity
    #
    #     return None

    '''
        flag is True if update is because of ADDITION of self
        otherwise, self is removed from composite resource
    '''
    def update_resource_accessibilities(self, flag):
        if flag:
            resource_ptr = self.parent
            while resource_ptr:
                resources = resource_ptr.get_child_resources(self)
                for resource in resources:
                    if resource.type.same_abstraction(ResourceTypeList.COMPOSITE):
                        for sub_resource in resource.for_each_sub_terminal_resource():
                            ResourceInterface.ACCESSIBILITY[self].add(sub_resource)
                    else:
                        ResourceInterface.ACCESSIBILITY[resource].add(self)
                        ResourceInterface.ACCESSIBILITY[self].add(resource)

                resource_ptr = resource_ptr.parent
        else:
            list_accessible_resources = copy(ResourceInterface.ACCESSIBILITY[self])
            ResourceInterface.ACCESSIBILITY[self] = set()

            for accessible_resource in list_accessible_resources:
                ResourceInterface.ACCESSIBILITY[accessible_resource].remove(self)

    def info(self, detailed=False):
        if detailed:
            return '%s --> Capacity=%.2f, Available Capacity=%.2f' % (self.get_credential(), self.get_capacity(), self.get_available_capacity())

        return '%s' % self.get_credential()

    def pretty_print(self, indent=0):
        print '%s%s' % ('\t'*indent, self.info())


class CompositeResource(ResourceInterface, list):
    def __init__(self, res_type, res_name, parent):
        ResourceInterface.__init__(self, res_type, res_name, parent)
        list.__init__([])

    def add(self, resource):
        if resource in self:
            LOG(msg='The resource is already in the scope of the composite resource %s' % self.name, log=Logs.WARN)
            return None
        else:
            self.append(resource)
            resource.set_parent_resource(self)
            resource.update_resource_accessibilities(True)
            LOG(msg='[ADD]: %s --> %s' % (self.info(), resource.info()), log=Logs.INFO)
            ResourceInterface.ROOT.print_accessibilites()
        return self

    def remove(self, resource):
        if resource in self:
            self.pop(self.index(resource))
            resource.set_parent_resource(None)
            resource.update_resource_accessibilities(False)
            LOG(msg='[REMOVE]: %s --> %s' % (self.info(), resource.info()), log=Logs.INFO)
            ResourceInterface.ROOT.print_accessibilites()
            return resource

        LOG(msg='The resource is NOT in the scope of the composite resource %s' % self.name, log=Logs.WARN)
        return None

    def get_sibling_resources(self, resource_type=None):
        return self.parent.get_child_resources(resource_type) if self.parent else None

    def get_child_resources(self, self_resource=None, resource_type=None):
        if resource_type:
            return [resource for resource in self if self.type == resource_type and (not self_resource or self_resource != resource)]

        return [resource for resource in self if not self_resource or self_resource != resource]

    def search_resources(self, response, **kwargs):
        for resource in self.get_child_resources():
            resource.search_resources(response, **kwargs)

    def for_each_sub_terminal_resource(self):
        stack = [self]
        terminal_resources = list()

        while len(stack) != 0:
            comp_resource = stack.pop(0)
            child_resources = comp_resource.get_child_resources()

            for resource in child_resources:
                if resource.type.same_abstraction(ResourceTypeList.COMPOSITE):
                    stack.append(resource)
                else:
                    terminal_resources.append(resource)

        return terminal_resources

    def update_resource_accessibilities(self, flag):
        if flag:
            resource_ptr = self.parent
            while resource_ptr:
                resources = resource_ptr.get_child_resources(self)
                for resource in resources:
                    if not resource.type.same_abstraction(ResourceTypeList.COMPOSITE):
                        for sub_resource in self.for_each_sub_terminal_resource():
                            ResourceInterface.ACCESSIBILITY[resource].add(sub_resource)
                            ResourceInterface.ACCESSIBILITY[sub_resource].add(resource)

                resource_ptr = resource_ptr.parent
        else:
            for removed_resource in self.for_each_sub_terminal_resource():
                list_accessible_resources = copy(ResourceInterface.ACCESSIBILITY[removed_resource])
                terminal_resources_in_system = ResourceInterface.ROOT.for_each_sub_terminal_resource()
                intersected_resources = list_accessible_resources.intersection(set(terminal_resources_in_system))

                for intersected_resource in intersected_resources:
                    ResourceInterface.ACCESSIBILITY[intersected_resource].remove(removed_resource)
                    ResourceInterface.ACCESSIBILITY[removed_resource].remove(intersected_resource)

    def info(self, detailed=False):
        return '%s' % (self.get_credential())

    def pretty_print(self, indent=0):
        print '%s%s' % ('\t'*indent, self.info())
        for resource in self.get_child_resources():
            resource.pretty_print(indent+1)
        

class ResourceFactory:
    TYPES = {
        ResourceTypeList.ACTIVE: TerminalResource,
        ResourceTypeList.PASSIVE: TerminalResource,
        ResourceTypeList.COMPOSITE: CompositeResource
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, res_name, parent=None):
        if _type.get_abstraction() in cls.TYPES:
            return cls.TYPES[_type.get_abstraction()](_type, res_name, parent)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None

System = CompositeResource(ROOT_TYPE, 'SYSTEM', None)
ResourceInterface.ROOT = System