from LFOS.Log import LOG, Logs
from Types import *
from Interface import Objective


class ResourceObjective(Objective):
    OBJ_SETS = [ObjectivePowerConsumption()]

    def __init__(self, purpose, criteria):
        if criteria not in self.__class__.OBJ_SETS:
            LOG(msg='Impossible to create an instance for given criteria. Possible criteria: %s' % (', '.join('%s' % obj for obj in self.__class__.OBJ_SETS)), log=Logs.ERROR)
            return None

        Objective.__init__(self, purpose, criteria)

    def __str__(self):
        return 'ResourceObjective'

    def set_criteria(self, _fp):
        if _fp in self.__class__.OBJ_SETS:
            self._criteria_fp = _fp
            return True

        LOG(msg='Impossible to set to given objective. Possible set of criteria: %s' % (', '.join('%s' % obj for obj in self.__class__.OBJ_SETS)), log=Logs.WARN)
        return False


class TaskObjective(Objective):
    OBJ_SETS = [ObjectiveLateness(),
                ObjectiveTardiness(),
                ObjectiveEarliness(),
                ObjectiveMakespan(),
                ObjectiveCentering(),
                ObjectiveMaxLateness()
                ]

    def __init__(self, purpose, criteria):
        if criteria not in self.__class__.OBJ_SETS:
            LOG(msg='Impossible to create an instance for given criteria. Possible criteria: %s' % (', '.join('%s' % obj for obj in self.__class__.OBJ_SETS)), log=Logs.ERROR)
            return None

        Objective.__init__(self, purpose, criteria)

    def __str__(self):
        return 'TaskObjective'

    def set_criteria(self, _fp):
        if _fp in self.__class__.OBJ_SETS:
            self._criteria_fp = _fp
            return True

        LOG(msg='Impossible to set to given objective. Possible set of criteria: %s' % (', '.join('%s' % obj for obj in self.__class__.OBJ_SETS)), log=Logs.WARN)
        return False


class OverallObjective(Objective):
    def __init__(self, purpose, criteria):
        Objective.__init__(self, purpose, criteria)

    def __str__(self):
        return 'OverallObjective'


class ObjectiveFactory:
    TYPES = [
        TaskObjective,
        ResourceObjective,
        OverallObjective
    ]

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, *args):
        if _type in cls.TYPES:
            return _type(*args)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES)), log=Logs.ERROR)
            return None