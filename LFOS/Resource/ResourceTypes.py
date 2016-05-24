
ACTIVE = 'active'
PASSIVE = 'passive'
COMPOSITE = 'composite'
UNDEFINED = 'UNDEF'

# resource_type_id is intended to specify the resource type name such as 'Memory', 'CPU', etc.
# resource_type is any one of the above static variables: ACTIVE, PASSIVE, COMPOSITE, otherwise.


class ResourceType:
    def __init__(self, resource_type_id, resource_type):
        self.__resource_type_id = resource_type_id
        self.__resource_type = resource_type

    def set_resource_type_name(self, resource_type):
        self.__resource_type = resource_type

    def get_resource_type_name(self):
        return self.__resource_type

    def set_resource_type_id(self, resource_type_id):
        self.__resource_type_id = resource_type_id

    def get_resource_type_id(self):
        return self.__resource_type_id
