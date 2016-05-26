from LFOS.Log import Logs, LOG


class TaskPriority(object):
    RANGE_MIN = 0
    RANGE_MAX = 100
    UNDEFINED = -1

    def __init__(self):
        self.priority = TaskPriority.UNDEFINED

    def set_priority(self, value):
        if TaskPriority.range_check(value):
            self.priority = value
            LOG(msg='The priority is set to %d' % self.priority, log=Logs.INFO)
            return True

        LOG('The priority value is not in the range [%d %d]' % (TaskPriority.RANGE_MIN, TaskPriority.RANGE_MAX), log=Logs.ERROR)
        return False

    def get_priority(self):
        return self.priority

    def is_defined(self):
        return self.priority != TaskPriority.UNDEFINED

    @classmethod
    def range_check(cls, value):
        return cls.RANGE_MIN <= value <= cls.RANGE_MAX

    @classmethod
    def change_range(cls, range_min, range_max):
        if type(range_min) is int and type(range_max) is int and range_min < range_max:
            cls.RANGE_MIN = range_min
            cls.RANGE_MAX = range_max
            return True

        LOG(msg='Given range parameters are not appropriate [%s %s].' % (str(range_min), str(range_max)), log=Logs.ERROR)
        return False