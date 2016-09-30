from LFOS.Log import Logs, LOG


SHARED = 'Resource.Mode.SHARED'
CB_EXCLUSIVE = 'Resource.Mode.CAPACITY_EXCLUSIVE'
SB_EXCLUSIVE = 'Resource.Mode.SEMANTIC_EXCLUSIVE'


class Mode(object):
    MODES = [SHARED, CB_EXCLUSIVE, SB_EXCLUSIVE]

    def __init__(self):
        self.__property = CB_EXCLUSIVE
        self.__exclusive_resources = list()

    def is_mode(self, mode):
        return mode == self.__property if mode in Mode.MODES else False

    def set_mode(self, mode):
        if mode not in Mode.MODES:
            LOG(msg='Given mode is not available. Modes=%s' % (', '.join(Mode.MODES)), log=Logs.ERROR)
            return False

        self.__property = mode
        return True

    def add_exclusive_resource(self, resource):
        if resource not in self.__exclusive_resources:
            self.__exclusive_resources.append(resource)
            LOG(msg='Exclusive resource is added to the list. Resource=%s' % (resource.get_credential()))

    def remove_exclusive_resource(self, resource):
        if resource in self.__exclusive_resources:
            self.__exclusive_resources.pop(resource)
            LOG(msg='Exclusive resource is removed from the list. Resource=%s' % (resource.get_credential()))

    def get_exclusive_resources(self):
        return self.__exclusive_resources
