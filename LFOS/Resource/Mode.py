from LFOS.Log import Logs, LOG


class ModeTypeList:
    SHARED = 'Resource.Mode.SHARED'
    CB_EXCLUSIVE = 'Resource.Mode.CAPACITY_EXCLUSIVE'
    SB_EXCLUSIVE = 'Resource.Mode.SEMANTIC_EXCLUSIVE'
    CB_AND_SB_EXCLUSIVE = 'Resource.Mode.CB_AND_SB_EXCLUSIVE'


class Mode(object):
    MODES = [ModeTypeList.SHARED, ModeTypeList.CB_EXCLUSIVE, ModeTypeList.SB_EXCLUSIVE, ModeTypeList.CB_AND_SB_EXCLUSIVE]

    def __init__(self):
        self.__property = ModeTypeList.CB_EXCLUSIVE
        self.__exclusive_resources = list()

    def is_mode(self, mode):
        return (self.__property == ModeTypeList.CB_AND_SB_EXCLUSIVE and (mode == ModeTypeList.CB_AND_SB_EXCLUSIVE or mode == ModeTypeList.SB_EXCLUSIVE or mode == ModeTypeList.CB_EXCLUSIVE)) or\
                self.__property == mode

    def is_exclusive(self):
        return self.__property == ModeTypeList.CB_AND_SB_EXCLUSIVE or\
               self.__property == ModeTypeList.CB_EXCLUSIVE or\
               self.__property == ModeTypeList.SB_EXCLUSIVE

    def set_mode(self, mode):
        if mode not in Mode.MODES:
            LOG(msg='Given mode is not available. Modes=%s' % (', '.join(Mode.MODES)), log=Logs.ERROR)
            return False

        self.__property = mode
        return True

    def add_exclusive_resource(self, resource):
        if self.is_exclusive() and resource not in self.__exclusive_resources:
            self.__exclusive_resources.append(resource)
            LOG(msg='Exclusive resource is added to the list. Resource=%s' % (resource.get_credential()))
        elif self.is_exclusive():
            LOG(msg='Given exclusive resource is already in the list. Index=%d' % (self.__exclusive_resources.index(resource)), log=Logs.WARN)
        else:
            LOG(msg='The mode of resource is SHARED. Invalid operation.', log=Logs.WARN)

    def remove_exclusive_resource(self, resource):
        if self.is_exclusive() and resource in self.__exclusive_resources:
            self.__exclusive_resources.pop(resource)
            LOG(msg='Exclusive resource is removed from the list. Resource=%s' % (resource.get_credential()))
        elif self.is_exclusive():
            LOG(msg='Given exclusive resource is not in the list.', log=Logs.WARN)
        else:
            LOG(msg='The mode of resource is SHARED. Invalid operation.', log=Logs.WARN)

    def get_exclusive_resources(self):
        return self.__exclusive_resources if self.is_exclusive() else []
