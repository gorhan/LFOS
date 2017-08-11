from LFOS.Log import Logs, LOG
from LFOS.Singleton import Singleton


class Objectives:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
class ObjectivePowerConsumption(Objectives):
    def __eq__(self, other):
        return isinstance(other, ObjectivePowerConsumption) or (isinstance(other, str) and other == str(self))
class ObjectiveLateness(Objectives):
    def __eq__(self, other):
        return isinstance(other, ObjectiveLateness) or (isinstance(other, str) and other == str(self))
class ObjectiveMakespan(Objectives):
    def __eq__(self, other):
        return isinstance(other, ObjectiveMakespan) or (isinstance(other, str) and other == str(self))


class ObjectivePurposes:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
class Minimize(ObjectivePurposes):
    def __eq__(self, other):
        return isinstance(other, Minimize) or (isinstance(other, str) and other == str(self))
class Maximize(ObjectivePurposes):
    def __eq__(self, other):
        return isinstance(other, Maximize) or (isinstance(other, str) and other == str(self))


class ObjectiveInterface(object):
    def __init__(self, aim, obj_criteria, resource):
        assert isinstance(aim, ObjectivePurposes)
        assert isinstance(obj_criteria, Objectives)

        self.__purpose = aim
        self.__criteria_fp = obj_criteria
        self.__me = resource

    def set_purpose(self, desc):
        try:
            assert isinstance(desc, ObjectivePurposes)
            self.__purpose = desc
            LOG(msg='New objective purpose is set to %s.' % desc)
            return True
        except AssertionError:
            LOG(msg='Invalid objective purpose given.', log=Logs.ERROR)
            return False

    def get_purpose(self):
        return self.__purpose

    def set_criteria(self, _fp):
        try:
            assert isinstance(_fp, Objectives)
            self.__criteria_fp = _fp
            LOG(msg='New objective criteria is set to %s.' % _fp)
            return True
        except AssertionError:
            LOG(msg='Invalid objective criteria given.', log=Logs.ERROR)
            return False