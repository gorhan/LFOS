
class ResourceTypeCapacityPair:
    def __init__(self, resource_type, capacity):
        self.resource_type = resource_type
        self.capacity = capacity

    def __repr__(self):
        return '%s:%d-%s' % (self.resource_type.get_resource_type_id(), self.capacity, self.resource_type.get_resource_type())


class ResourceTypeCapacityPairList(list):
    def __init__(self, *args):
        super(ResourceTypeCapacityPairList, self).__init__(args)
        
    def append(self, resource_type, capacity):
        super(ResourceTypeCapacityPairList, self).append(ResourceTypeCapacityPair(resource_type, capacity))