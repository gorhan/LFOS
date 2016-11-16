from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class SchedulingWindow:

    def __init__(self, _begin=Time(), _duration=Time()):
        assert isinstance(_begin, Time)
        assert isinstance(_duration, Time)

        self.__begin = _begin
        self.__duration = _duration

    def set_scheduling_window_start_time(self, new_begin):
        assert isinstance(new_begin, Time)

        self.__begin = new_begin
        LOG(msg='New start time for the scheduling window is %.3f' % self.__begin)

    def get_scheduling_window_start_time(self):
        return self.__begin

    def set_scheduling_window_duration(self, new_duration):
        assert isinstance(new_duration, Time)

        self.__duration = new_duration
        LOG(msg='New duration for the scheduling window is %.3f' % self.__duration)

    def get_scheduling_window_duration(self):
        return self.__duration

    def get_scheduling_window_boundaries(self):
        return self.__begin, self.__begin + self.__duration

