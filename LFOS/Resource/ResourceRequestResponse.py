from LFOS.Resource.ResourceRequest import *


class ResourceRequestResponse:
    AVAILABLE = 0
    INUSE = 1

    def __init__(self):
        self.resources = dict()
        self.resources[ResourceRequestResponse.AVAILABLE] = list()
        self.resources[ResourceRequestResponse.INUSE] = list()

    def add_resources(self, to_where, active_resource, related_passive_resources):
        item = dict()
        item[ACTIVE] = active_resource
        item[PASSIVE] = related_passive_resources
        self.resources[to_where].append(item)

    def get_resources(self, from_where):
        return self.resources[from_where]
