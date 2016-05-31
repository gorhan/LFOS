from LFOS.Resource.ResourceRequest import *


class AbstractResourceRequestResponse(object):
    def __init__(self, cls):
        self.resources = cls()

    def add_resources(self, active_resource, related_passive_resources, to_where):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove_resources(self, active_resource, from_where):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_resources(self, from_where):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def get_resources_list(self, from_where):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def clear(self):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class AdvancedResourceRequestResponse(AbstractResourceRequestResponse):
    AVAILABLE = 1
    INUSE = 2
    DUMP = None

    def __init__(self):
        super(AdvancedResourceRequestResponse, self).__init__(dict)

        self.resources[AdvancedResourceRequestResponse.AVAILABLE] = list()
        self.resources[AdvancedResourceRequestResponse.INUSE] = list()

    def add_resources(self, active_resource, related_passive_resources, to_where=None):
        item = dict(active_resource, **related_passive_resources)
        if to_where:
            self.resources[to_where].append(item)

    def get_resources(self, from_where=None):
        if from_where:
            return self.resources[from_where]

    def get_resources_list(self, from_where=None):
        if from_where:
            return self.resources[from_where]

    def clear(self):
        self.resources[AdvancedResourceRequestResponse.AVAILABLE] = list()
        self.resources[AdvancedResourceRequestResponse.INUSE] = list()


class BasicResourceRequestResponse(AbstractResourceRequestResponse):
    def __init__(self):
        super(BasicResourceRequestResponse, self).__init__(list)

    def add_resources(self, active_resource, related_passive_resources, to_where=None):
        item = dict(active_resource, **related_passive_resources)
        self.resources.append(item)

    def get_resources(self, from_where=None):
        return self.resources

    def get_resources_list(self, from_where=None):
        return self.resources

    def clear(self):
        self.resources = list()


class ResourceRequestResponseFactory:
    TYPES = {
        'basic': BasicResourceRequestResponse,
        'advanced': AdvancedResourceRequestResponse
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type):
        if _type in cls.TYPES:
            return cls.TYPES[_type]()
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
