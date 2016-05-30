from LFOS.Resource.ResourceRequestResponse import *
from LFOS.Resource.ResourcePower import *

SYSTEM_NAME = 'System'


class AbstractResource(object):
    def __init__(self, res_type, res_name, parent):
        self.type = res_type
        self.name = res_name
        self.parent = parent

        self.request_type = 'advanced'

    def set_resource_name(self, res_name):
        self.name = res_name

    def set_resource_type(self, res_type):
        self.type = res_type

    def get_resource_type_name(self):
        return self.type.get_resource_type_name()

    def get_credential(self):
        return '%s [%s, %s]' % (self.name, self.type.get_resource_type_id(), self.type.get_resource_type_name())

    def set_parent(self, resource):
        self.parent = resource

    def set_resource_request_type(self, _type):
        self.request_type = _type

    def get_resource_request_type(self):
        return self.request_type

    def get_parent(self):
        return self.parent

    def get_system(self):
        root = self
        while root.parent:
            root = root.parent

        return root

    def add(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove(self, resource):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_sibling_resources(self, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_child_resources(self, resource_type=None):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def request(self, task):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def alloc(self, requester, resources):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def free(self, running_task, resources):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def search_resources_w_resource_type(self, resource_type, response):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def pretty_print(self, indent=0):
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
        if not isinstance(pc_instance, PowerConsumption):
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
        from LFOS.Task.Task import AbstractTask, Credential
        if isinstance(task_or_type, Credential):
            if task_or_type in self.__dedicated_task_types:
                LOG(msg='The given task type for dedicated resource is already in the list')
                return task_or_type
            else:
                self.__dedicated_task_types.append(task_or_type)
        elif isinstance(task_or_type, AbstractTask):
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
        from LFOS.Task.Task import AbstractTask, Credential
        deleted = None
        if isinstance(task_or_type, Credential):
            try:
                index = self.__dedicated_task_types.index(task_or_type)
                deleted = self.__dedicated_task_types.index(index)
                LOG(msg='Task type %s is deleted from the list of dedicated task types.' % task_or_type.type_name)
            except ValueError:
                LOG(msg='Resource %s is not in the list of dedicated task types.' % task_or_type.type_name, log=Logs.WARN)
        elif isinstance(task_or_type, AbstractTask):
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

    def is_task_eligible(self, task):
        dedicated_list = self.__dedicated_task_types + self.__dedicated_tasks
        if dedicated_list:
            if task not in dedicated_list:
                return False

        return True

    def search_resources_w_resource_type(self, resource_type, response):
        if self.type == resource_type and self not in response:
            response.append(self)

    def __top_relevant_resources(self, requester, requested_resource_types):
        resource_it = self.parent
        found = dict()
        while resource_it:
            children = resource_it.get_child_resources()
            for resource in children:
                if resource.type in requested_resource_types and resource.is_task_eligible(requester):
                    if resource.type in found:
                        found[resource.type].append(resource)
                    else:
                        found[resource.type] = [resource]
            resource_it = resource_it.parent
        return found

    def __bottom_relevant_resources(self, requester, requested_resource_types, response):
        children = self.parent.get_child_resources()
        for resource in children:
            if resource.type in requested_resource_types and resource not in response and resource.is_task_eligible(
                    requester):
                if resource.type in response:
                    response[resource.type].append(resource)
                else:
                    response[resource.type] = [resource]
            elif resource.type.get_resource_type_name() == COMPOSITE:
                resource.__bottom_relevant_resources(requested_resource_types, response)

    def get_accessible_passive_resources(self, requester, requested_resource_types):
        response = self.__top_relevant_resources(requester, requested_resource_types)
        self.__bottom_relevant_resources(requester, requested_resource_types, response)

        # Given resource type list is completely found
        if set(requested_resource_types) == set(response.keys()):
            return response

        return None

    def alloc(self, requester, resources):
        if self in resources:
            alloc_capacity = resources.pop(self)
            self.__running_tasks[requester] = alloc_capacity
            LOG(msg='Resource is allocated. Resource=%s, Task=%s, Amount=%.2f' % (self.name, requester.name, alloc_capacity), log=Logs.INFO)

    def free(self, running_task, resources):
        if self in resources and running_task in self.__running_tasks:
            freed_capacity = self.__running_tasks.pop(running_task)
            LOG(msg='Resource is freed. Resource=%s, Task=%s, Amount=%.2f' % (self.name, running_task.name, freed_capacity), log=Logs.INFO)
            return freed_capacity
        elif self in resources:
            LOG(msg='Given task pointer is not running on the resource. Resource=%s, Task=%s' % (self.name, running_task.name), log=Logs.ERROR)
            return None

        return None

    def pretty_print(self, indent=0):
        print '%s%s' % ('\t'*indent, self.get_credential())


class CompositeResource(AbstractResource, list):
    def __init__(self, res_type, res_name, parent):
        super(CompositeResource, self).__init__(res_type, res_name, parent)
        list.__init__([])

    def add(self, resource):
        if resource.type.get_resource_type_id() == SYSTEM_NAME:
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

    def request(self, task):
        requirements = task.get_resource_requests()
        active_resource_requests = requirements.get_required_resources_w_type_name(ACTIVE)
        passive_resource_requests = requirements.get_required_resources_w_type_name(PASSIVE)

        print active_resource_requests, passive_resource_requests
        response = ResourceRequestResponseFactory.create_instance(self.request_type)

        for active_resource_type, req_capacity in active_resource_requests.items():
            desired_active_resources = list()

            self.search_resources_w_resource_type(active_resource_type, desired_active_resources)
            print 'Desiredddd', desired_active_resources
            for active_resource in desired_active_resources:
                desired_passive_resources = active_resource.get_accessible_passive_resources(task, passive_resource_requests.keys())

                print 'Resourcesssss', active_resource, passive_resource_requests
                if self.request_type == 'basic':
                    if desired_passive_resources:
                        response.add_resources(active_resource, desired_passive_resources)
                    else:
                        LOG(msg='At least one of the resources requested cannot be access via active resource: %s' % active_resource.name)

                elif self.request_type == 'advanced':
                    to_where = AdvancedResourceRequestResponse.AVAILABLE

                    if desired_passive_resources:
                        if active_resource.get_available_capacity() >= req_capacity:

                            for resource_type, resources in desired_passive_resources:
                                total_available_capacity = sum([resource.get_available_capacity() for resource in resources])
                                total_all_capacity = sum([resource.get_total_capacity() for resource in resources])

                                if total_available_capacity < passive_resource_requests[resource_type]:
                                    to_where = AdvancedResourceRequestResponse.INUSE
                                    break

                                elif total_all_capacity < passive_resource_requests[resource_type]:
                                    LOG(msg='The total capacity of the requested passive resource type cannot be '
                                            'supplied by accessible resources. Active Resource: %s - Passive Resources: %s' %
                                            (active_resource.name,
                                             ', '.join( ['%s[%.2f / %.2f]' % (resource.name, resource.get_available_capacity(), resource.get_total_capacity()) for resource in resources])),
                                            log=Logs.ERROR)
                                    to_where = AdvancedResourceRequestResponse.DUMP
                                    break

                        else:
                            to_where = AdvancedResourceRequestResponse.INUSE

                        response.add_resources(active_resource, desired_passive_resources, to_where)

                    else:
                        LOG(msg='At least one of the resources requested cannot be access via active resource: %s' % active_resource.name)

                else:
                    LOG(msg='Invalid ResourceRequestResponse type.', log=Logs.ERROR)

        return response


    '''
        Assumption: Scheduler will allocate the relevant resources. Therefore, it is not necessary to check any conflict at this procedure.
        requester --> Pointer to requesting task
        resources --> Dictionary holding resource pointers as keys and required capacities as values.
    '''
    def alloc(self, requester, resources):
        root = self.get_system()

        for resource in root.get_child_resources():
            resource.alloc(requester, resources)

    '''
        Assumption: Scheduler will free the relevant resources. Therefore, it is not necessary to check any conflict at this procedure.
        running_task --> Pointer to the task
        resources --> List of pointers to the resources from which running_task will be freed. (Noting that unlike
                      alloc method, resources parameter is not a dictionary, since it is impossible to partially free the resource.)
    '''
    def free(self, running_task, resources) :
        root = self.get_system()

        for resource in root.get_child_resources():
            resource.free(running_task, resources)

    def search_resources_w_resource_type(self, resource_type, response):
        # reach to the system
        root = self.get_system()

        children = root.get_child_resources()
        for resource in children:
            resource.search_resources_w_resource_type(resource_type, response)

    def pretty_print(self, indent=0):
        print '%s%s' % ('\t'*indent, self.get_credential())
        for resource in self.get_child_resources():
            resource.pretty_print(indent+1)


class ResourceFactory:
    TYPES = {
        ACTIVE: TerminalResource,
        PASSIVE: TerminalResource,
        COMPOSITE: CompositeResource
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, res_name, parent=None):
        if _type.get_resource_type_name() in cls.TYPES:
            return cls.TYPES[_type.get_resource_type_name()](_type, res_name, parent)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None


# the root of all resource models
System_type = ResourceType(SYSTEM_NAME, COMPOSITE)
System = ResourceFactory.create_instance(System_type, 'ComputingSystem')