from LFOS.Log import *
from ResourceTypes import *


class ResourceRequests(dict):
    def __init__(self):
        super(ResourceRequests, self).__init__({})

    def add_request(self, resource_type, required_capacity):
        if not self.__type_check(resource_type, ResourceType):
            return None

        if resource_type in self:
            LOG(msg='Given resource type is in the list of required resources.', log=Logs.WARN)
        else:
            self[resource_type] = required_capacity

    def remove_request(self, resource_type):
        if not self.__type_check(resource_type, ResourceType):
            return None

        if self.has_key(resource_type):
            return self.pop(resource_type)

        LOG(msg='Given resource_type object is not in the resource requests.', log=Logs.WARN)
        return None

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

    def __type_check(self, obj, cls):
        try:
            assert isinstance(obj, cls)
            return True
        except AssertionError:
            LOG(msg='Invalid procedure call. Given parameter is not an instance of %s class.' % cls.__name__,
                log=Logs.ERROR)

        return False
