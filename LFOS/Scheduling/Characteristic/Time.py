from __future__ import division
from LFOS.Log import LOG, Logs


class TimeResolution:
    def __init__(self, _res):
        self.__time_resolution = _res

    def set_time_resolution(self, new_time_resolution):
        if type(new_time_resolution) is not int:
            LOG(msg='The given precision value must be integer.', log=Logs.ERROR)
            return False

        if self.__time_resolution > new_time_resolution:
            LOG(msg='Please be sure about time resolution parameter. The resolution has been decreased. %d --> %d floating precision.' % (self.__time_resolution, new_time_resolution), log=Logs.ERROR)

        LOG(msg='The time resolution has been increased. %d --> %d' % (self.__time_resolution, new_time_resolution))
        self.__time_resolution = new_time_resolution
        return True

    def get_time_resolution(self):
        return self.__time_resolution


class Time(int):
    TIME_RESOLUTION = TimeResolution(0)
    TIME_UNIT = 'msec'

    def __new__(cls, _time=0):
        return super(Time, cls).__new__(cls, Time.encode(_time))

    def __init__(self, _time=0):
        int.__init__(_time)

    def __add__(self, other):
        if isinstance(other, Time):
            return Time(Time.decode(self) + Time.decode(other))
        elif isinstance(other, float) or isinstance(other, int):
            return Time(Time.decode(self) + other)

        print(type(other), other)
        raise TypeError

    def __radd__(self, other):
        return self.__add__(other)

    def __sub__(self, other):
        if isinstance(other, Time):
            return Time(Time.decode(self) - Time.decode(other))
        elif isinstance(other, float) or isinstance(other, int):
            return Time(Time.decode(self) - other)

        raise TypeError

    def __rsub__(self, other):
        return self.__add__(other)

    def __repr__(self):
        return '%.*f %s' % (Time.get_time_resolution(), Time.decode(self), Time.TIME_UNIT)

    @classmethod
    def set_time_resolution(cls, new_time_resolution):
        return cls.TIME_RESOLUTION.set_time_resolution(new_time_resolution)

    @classmethod
    def get_time_resolution(cls):
        return cls.TIME_RESOLUTION.get_time_resolution()

    @classmethod
    def set_time_unit(cls, new_time_unit):
        cls.TIME_UNIT = new_time_unit

    @classmethod
    def get_time_unit(cls):
        return cls.TIME_UNIT

    @classmethod
    def encode(cls, val):
        # LOG(msg='ENCODE=%d' % int(val * (10 ** (cls.get_time_resolution()))))
        return int(val * (10 ** (cls.get_time_resolution())))

    @classmethod
    def decode(cls, val):
        return val * (10 ** (-Time.TIME_RESOLUTION.get_time_resolution()))
