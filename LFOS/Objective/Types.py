from LFOS.Singleton import Singleton


class Criteria:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
class ObjectivePowerConsumption(Criteria):
    pass
class ObjectiveLateness(Criteria):
    pass
class ObjectiveTardiness(Criteria):
    pass
class ObjectiveEarliness(Criteria):
    pass
class ObjectiveCentering(Criteria):
    pass
class ObjectiveMakespan(Criteria):
    pass
class ObjectiveMaxLateness(Criteria):
    pass


class Purpose:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
class Mini(Purpose):
    pass
class Maxi(Purpose):
    pass
