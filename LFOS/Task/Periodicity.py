from LFOS.Log import LOG, Logs
from enum import Enum


class PeriodicityInterface(object):
    def __init__(self, _type):
        self.period = None
        self.type = _type

    def set_period(self, new_period):
        self.period = new_period

    def get_period(self):
        return self.period

    def get_period_type(self):
        return self.type


class Periodic(PeriodicityInterface):
    def __init__(self, _type):
        super(Periodic, self).__init__(_type)


class Aperiodic(PeriodicityInterface):
    def __init__(self, _type):
        super(Aperiodic, self).__init__(_type)


class Sporadic(PeriodicityInterface):
    def __init__(self, _type):
        super(Sporadic, self).__init__(_type)

    def set_period(self, new_period):
        LOG(msg='Invalid request. Sporadic tasks cannot have a specific period time.', log=Logs.ERROR)


class PeriodicityTypeList(Enum):
    APERIODIC = 'Aperiodic'
    SPORADIC = 'Sporadic'
    PERIODIC = 'Periodic'


class PeriodicityFactory:
    TYPES = {
        PeriodicityTypeList.APERIODIC: Aperiodic,
        PeriodicityTypeList.SPORADIC: Sporadic,
        PeriodicityTypeList.PERIODIC: Periodic
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type):
        if _type in cls.TYPES:
            return cls.TYPES[_type](_type)
        else:
            LOG(msg='Invalid factory construction request. %s' % _type, log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None
