from LFOS.Log import LOG, Logs


class TimeResolution(object):
    def __init__(self, _res):
        self.__time_resolution = _res

    def set_time_resolution(self, new_time_resolution):
        if self.__time_resolution < new_time_resolution:
            LOG(msg='Please be sure about time resolution parameter. The resolution has been decreased. %.3f --> %.3f' % (self.__time_resolution, new_time_resolution), log=Logs.ERROR)
            return False

        self.__time_resolution = new_time_resolution
        LOG(msg='The time resolution has been increased. %.3f --> %.3f' % (self.__time_resolution, new_time_resolution))
        return True

    def get_time_resolution(self):
        return self.__time_resolution


class Time(float):
    TIME_RESOLUTION = TimeResolution(0.01)
    TIME_UNIT = 'msec'

    def __init__(self, _time=0.0):
        float.__init__(_time)

    def __add__(self, other):
        if isinstance(other, Time):
            return self + other
        elif isinstance(other, float) or isinstance(other, int):
            if other % Time.TIME_RESOLUTION.get_time_resolution() != 0.0:
                LOG(msg='', log=Logs.ERROR)
                return self
            else:
                return self + other
        else:
            raise TypeError

    def __radd__(self, other):
        if isinstance(other, Time):
            return self + other
        elif isinstance(other, float) or isinstance(other, int):
            if other % Time.TIME_RESOLUTION.get_time_resolution() != 0.0:
                LOG(msg='', log=Logs.ERROR)
                return self
            else:
                return self + other
        else:
            raise TypeError

    def __repr__(self):
        return '%.4f %s' % (self, Time.TIME_UNIT)

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