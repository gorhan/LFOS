from LFOS.Log import *

ACTIVE = 0
PASSIVE = 1
COMPOSITE = 2
UNDEFINED = -1


class ResourceType:
    def __init__(self, resource_type_id, resource_type):
        self.__resource_type_id = resource_type_id
        self.__resource_type = resource_type

    def set_resource_type(self, resource_type):
        self.__resource_type = resource_type

    def get_resource_type(self):
        return self.__resource_type

    def set_resource_type_id(self, resource_type_id):
        self.__resource_type_id = resource_type_id

    def get_resource_type_id(self):
        return self.__resource_type_id
