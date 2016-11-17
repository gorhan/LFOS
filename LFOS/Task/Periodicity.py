from LFOS.Log import LOG, Logs
from enum import Enum


class PeriodicityTypeList(Enum):
    APERIODIC = 'Aperiodic'
    SPORADIC = 'Sporadic'
    PERIODIC = 'Periodic'


class Periodicity(object):
    TYPES = [PeriodicityTypeList.APERIODIC, PeriodicityTypeList.SPORADIC, PeriodicityTypeList.PERIODIC]

    def __init__(self, _type):
        self.period = -1
        self.type = _type

    def set_period(self, new_period):
        if self.type == PeriodicityTypeList.PERIODIC:
            self.period = new_period
        else:
            LOG(msg='Invalid request. Sporadic tasks cannot have a specific period time.', log=Logs.ERROR)

    def set_periodicity(self, _type):
        if _type in Periodicity.TYPES:
            self.type = _type

    def get_period(self):
        return self.period

    def get_period_type(self):
        return self.type
