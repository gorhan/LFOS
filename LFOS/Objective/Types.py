from LFOS.Singleton import Singleton


class Criteria:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class ObjectivePowerConsumption(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveLateness(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveTardiness(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveEarliness(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveCentering(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveMakespan(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class ObjectiveMaxLateness(Criteria):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))

#class Logical:
#    __metaclass__ = Singleton
#    
#    def __str__(self):
#        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
#class AND(Logical):
#    def __eq__(self, other):
#        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
#class OR(Logical):
#    def __eq__(self, other):
#        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
#class XOR(Logical):
#    def __eq__(self, other):
#        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))


class Purpose:
    __metaclass__ = Singleton

    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class Mini(Purpose):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class Maxi(Purpose):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
