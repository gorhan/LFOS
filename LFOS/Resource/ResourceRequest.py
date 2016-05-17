from LFOS.Log import *
from ResourceTypes import *
from sys import exit


class ResourceRequests(dict):
    def __init__(self):
        super(ResourceRequests, self).__init__({})

    def append(self, resource_type, required_capacity):
        if resource_type in self:
            LOG(msg='Given resource type is in the list of required resources.', log=Logs.WARN)
        else:
            self[resource_type] = required_capacity

    def get_required_capacity(self, resource_type):
        try:
            return self[resource_type]
        except KeyError:
            LOG(msg='Given resource type object is not in the resource requests.')
            return None

    def get_required_resources_w_type_name(self, type_name):
        response = dict()
        for resource_type, capacity in self.items():
            if resource_type == type_name:
                response[resource_type] = capacity

        return response
