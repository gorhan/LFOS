from LFOS.Log import *
from ResourceTypes import *
from sys import exit

class ResourceTypeCapacityPair(dict):
    def __init__(self, resource_type, capacity):
        try:
            assert isinstance(resource_type, ResourceType)
        except AssertionError:
            LOG(msg='Given parameter resource_type has to be an instance of ResourceType class', log=Logs.ERROR)
            exit(-1)

        self.resource_type = resource_type
        self.capacity = capacity

    def __repr__(self):
        return '%s:%d-%s' % (self.resource_type.get_resource_type_id(), self.capacity, self.resource_type.get_resource_type_name())

    def __eq__(self, other):
        return self.resource_type == other.resource_type


class ResourceRequest(list):
    def __init__(self):
        super(ResourceRequest, self).__init__([])

    def append(self, resource_type, required_capacity):
        if resource_type in self:
            LOG(msg='Given resource type is in the list of required resources.', log=Logs.WARN)
        else:
            self.append(ResourceTypeCapacityPair(resource_type, required_capacity))

    def get_pairs(self):
        return self

    def get_pairs_w_type_names(self, resource_type_names):
        return [requirement for requirement in self if requirement.resource_type.get_resource_type_name() in resource_type_names]

    def get_resource_type_ids(self, resource_type_ids):
        return [requirement for requirement in self if requirement.resource_type.get_resource_type_id() in resource_type_ids]

    def get_resources_w_id(self, resource_id):
        return [resource for resource in self if resource_id == resource.resource_type.get_resource_type_id()]
