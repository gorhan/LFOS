from LFOS.Log import LOG, Logs


class Priority(object):
    class Ranking:
        ASCENDING = 'Priority.Ranking.ASCENDING'
        DESCENDING = 'Priority.Ranking.DESCENDING'

    MIN_PRIORITY = 0
    MAX_PRIORITY = 100
    IMPORTANCE_RANKING = Ranking.ASCENDING

    def __init__(self, _priority):
        self.__priority = _priority

    def set_priority(self, new_prio):
        if Priority.MIN_PRIORITY <= new_prio <= Priority.MAX_PRIORITY:
            self.__priority = new_prio
            LOG(msg='New priority value has been assigned. Priority=%d' % self.__priority)
            return True

        LOG(msg='Given priority value is not within the range of [%d, %d].' % (Priority.MIN_PRIORITY, Priority.MAX_PRIORITY), log=Logs.ERROR)
        return False

    def get_priority(self):
        return self.__priority

    @classmethod
    def define_priority_levels(cls, min_prio, max_prio, ranking=None):
        if min_prio > cls.MIN_PRIORITY:
            LOG(msg='Given new minimum priority value is higher than the current one. New=%d - Current=%d' % (min_prio, cls.MIN_PRIORITY), log=Logs.WARN)
            cls.MIN_PRIORITY = min_prio

        if max_prio > cls.MAX_PRIORITY:
            LOG(msg='Given new maximum priority value is lower than the current one. New=%d - Current=%d' % (max_prio, cls.MAX_PRIORITY), log=Logs.WARN)
            cls.MAX_PRIORITY = max_prio

        if ranking and (ranking == cls.Ranking.ASCENDING or  ranking == cls.Ranking.DESCENDING):
            LOG(msg='New ranking criteria = %s' % ranking)
            cls.IMPORTANCE_RANKING = ranking