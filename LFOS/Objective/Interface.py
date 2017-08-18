from Types import *
from LFOS.Log import Logs, LOG

ALL = [
    ObjectiveLateness(),
    ObjectiveTardiness(),
    ObjectiveEarliness(),
    ObjectiveMakespan(),
    ObjectiveCentering(),
    ObjectiveMaxLateness(),
    ObjectivePowerConsumption()
]


class Objective(object):
    OBJ_SETS = ALL

    def __init__(self, aim, obj_criteria):
        assert isinstance(aim, Purpose)
        assert isinstance(obj_criteria, Criteria)

        self._purpose = aim
        self._criteria_fp = obj_criteria

    def __eq__(self, other):
        return isinstance(other, Objective) and self._criteria_fp == other._criteria_fp and self._purpose == other._putpose

    def set_purpose(self, desc):
        try:
            assert isinstance(desc, Purpose)
            self._purpose = desc
            LOG(msg='New objective purpose is set to %s.' % desc)
            return True
        except AssertionError:
            LOG(msg='Invalid objective purpose given.', log=Logs.ERROR)
            return False

    def get_purpose(self):
        return self._purpose

    def set_criteria(self, _fp):
        if _fp in self.__class__.OBJ_SETS:
            self._criteria_fp = _fp
            return True

        LOG(msg='Impossible to set to given objective. Possible set of criteria: %s' % (
        ', '.join('%s' % obj for obj in self.__class__.OBJ_SETS)), log=Logs.WARN)
        return False

    def get_criteria(self):
        return self._criteria_fp
