from LFOS.Resource.Type import *


class ResourceRequests(object):
    def __init__(self):
        self.requests = dict()

    def add_resource_request(self, resource_type, required_capacity):
        if not Type.check(resource_type):
            return None

        if resource_type in self.requests:
            LOG(msg='Given resource type is in the list of required resources.', log=Logs.WARN)
        else:
            self.requests[resource_type] = required_capacity

    def remove_resource_request(self, resource_type):
        if not Type.check(resource_type):
            return None

        if self.requests.has_key(resource_type):
            return self.requests.pop(resource_type)

        LOG(msg='Given resource_type object is not in the resource requests.', log=Logs.WARN)
        return None

    def get_resource_requests(self):
        return self.requests

    def get_required_capacity(self, resource_type):
        try:
            return self.requests[resource_type]
        except KeyError:
            LOG(msg='Given resource type object is not in the resource requests.')
            return None

    def get_required_resources(self, **kwargs):
        response = dict()

        for resource_type, capacity in self.requests.items():
            if kwargs.has_key('abstraction') and resource_type.same_abstraction(kwargs['abstraction']):
                response[resource_type] = capacity
            if kwargs.has_key('identifier') and resource_type.same_identifier(kwargs['identifier']):
                response[resource_type] = capacity

        return response
