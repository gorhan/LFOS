from LFOS.Log import *

class ResourceType:
    ACTIVE = 0
    PASSIVE = 1
    COMPOSITE = 2
    UNDEFINED = -1

    def __init__(self, resource_type_id, resource_type):
        self.__resource_type_id = resource_type_id
        self.__resource_type = self.__assign_resource_type(resource_type)

    def set_resource_type(self, resource_type):
        self.__resource_type = self.__assign_resource_type(resource_type)

    def get_resource_type(self):
        return self.__resource_type

    def set_resource_type_id(self, resource_type_id):
        self.__resource_type_id = resource_type_id

    def get_resource_type_id(self):
        return self.__resource_type_id

    def __assign_resource_type(self, resource_type):
        if resource_type in [ResourceType.ACTIVE, ResourceType.PASSIVE, ResourceType.COMPOSITE]:
            return resource_type

        LOG(msg='Specified resource type is UNDEFINED', log=Logs.ERROR)
        return ResourceType.UNDEFINED
