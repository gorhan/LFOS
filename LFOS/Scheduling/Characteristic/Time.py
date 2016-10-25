from __future__ import division
from LFOS.Log import LOG, Logs


class TimeResolution(object):
    def __init__(self, _res):
        self.__time_resolution = _res

    def set_time_resolution(self, new_time_resolution):
        if self.__time_resolution > new_time_resolution:
            LOG(msg='Please be sure about time resolution parameter. The resolution has been decreased. %d --> %d floating precision.' % (self.__time_resolution, new_time_resolution), log=Logs.ERROR)

        LOG(msg='The time resolution has been increased. %d --> %d' % (self.__time_resolution, new_time_resolution))
        self.__time_resolution = new_time_resolution
        return True

    def get_time_resolution(self):
        return self.__time_resolution


class Time(float):
    TIME_RESOLUTION = TimeResolution(3)
    TIME_UNIT = 'msec'

    def __new__(cls, _time=0.0):
        tm_resolution = cls.TIME_RESOLUTION.get_time_resolution()
        if not cls.is_compatible(_time):
            LOG(msg='Unable to instantiate the object due to the time resolution. %d' % tm_resolution, log=Logs.ERROR)
            return None
        
        return super(Time, cls).__new__(cls, _time)

    def __init__(self, _time=0.0):
        float.__init__(_time)

    def __add__(self, other):
        if isinstance(other, Time):
            return Time(super(Time, self).__add__(other))
        elif isinstance(other, float) or isinstance(other, int):
            if not Time.is_compatible(other):
                LOG(msg='Time resolution does not allow the operation.', log=Logs.ERROR)
                return self
            else:
                return Time(super(Time, self).__add__(other))
        else:
            raise TypeError

    def __radd__(self, other):
        return self.__add__(other)

    def __sub__(self, other):
        if isinstance(other, Time):
            return Time(super(Time, self).__sub__(other))
        elif isinstance(other, float) or isinstance(other, int):
            if not Time.is_compatible(other):
                LOG(msg='Time resolution does not allow the operation.', log=Logs.ERROR)
                return self
            else:
                return Time(super(Time, self).__sub__(other))
        else:
            raise TypeError

    def __rsub__(self, other):
        return self.__add__(other)

    def __repr__(self):
        return '%.*f %s' % (Time.TIME_RESOLUTION.get_time_resolution(), self, Time.TIME_UNIT)

    @classmethod
    def set_time_resolution(cls, new_time_resolution):
        return cls.TIME_RESOLUTION.set_time_resolution(new_time_resolution)

    @classmethod
    def set_time_unit(cls, new_time_unit):
        cls.TIME_UNIT = new_time_unit

    @classmethod
    def get_time_resolution(cls):
        return cls.TIME_RESOLUTION

    @classmethod
    def get_time_unit(cls):
        return cls.TIME_UNIT

    @classmethod
    def get_precision(cls, _time):
        return

    @classmethod
    def is_compatible(cls, _time):
        _res = cls.TIME_RESOLUTION.get_time_resolution()
        float_n_digits = len(str(_time).split('.')[-1] if '.' in str(_time) else '')
        return _res >= float_n_digits