from LFOS.Log import Logs, LOG
from LFOS.Resource.Resource import ResourceInterface


class ObjectivePurpose:
    MAXIMIZE = "Resource.Objective.ObjectivePurpose.Maximize"
    MINIMIZE = "Resource.Objective.ObjectivePurpose.Minimize"


class ObjectiveInterface(object):
    def __init__(self, aim, obj_criteria, resource):
        self.__purpose = aim
        self.__criteria_fp = obj_criteria
        self.__me = resource

    def set_purpose(self, desc):
        if desc == ObjectivePurpose.MAXIMIZE or desc == ObjectivePurpose.MINIMIZE:
            self.__purpose = desc
            LOG(msg='New resource objective is set to %s.' ('MAX' if desc==ObjectivePurpose.MAXIMIZE else 'MIN'))
            return True

        LOG(msg='Invalid Resource Objective purpose given.', log=Logs.ERROR)
        return False

    def get_purpose(self):
        return self.__purpose

    def set_criteria(self, _fp):
        self.__criteria_fp = _fp
