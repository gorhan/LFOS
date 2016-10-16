from LFOS.Log import *
from ResourceTypes import *


class ResourceRequests(object):
    def __init__(self):
        self.requests = dict()

    def add_resource_request(self, resource_type, required_capacity):
        if not self.__type_check(resource_type, ResourceType):
            return None

        if resource_type in self.requests:
            LOG(msg='Given resource type is in the list of required resources.', log=Logs.WARN)
        else:
            self.requests[resource_type] = required_capacity

    def remove_resource_request(self, resource_type):
        if not self.__type_check(resource_type, ResourceType):
            return None

        if self.requests.has_key(resource_type):
            return self.requests.pop(resource_type)

        LOG(msg='Given resource_type object is not in the resource requests.', log=Logs.WARN)
        return None

    def get_resource_requests(self):
        return self

    def get_required_capacity(self, resource_type):
        try:
            return self.requests[resource_type]
        except KeyError:
            LOG(msg='Given resource type object is not in the resource requests.')
            return None

    def get_required_resources_w_type_id(self, type_id):
        response = dict()
        for resource_type, capacity in self.requests.items():
            if resource_type.get_resource_type_id() == type_id:
                response[resource_type] = capacity

        return response

    def get_required_resources_w_type_name(self, type_name):
        response = dict()
        for resource_type, capacity in self.requests.items():
            if resource_type.get_resource_type_name() == type_name:
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
