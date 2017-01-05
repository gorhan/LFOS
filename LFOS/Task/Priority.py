from LFOS.Log import LOG, Logs


class PriorityRanking:
    ASCENDING = 'PriorityRanking.ASCENDING'
    DESCENDING = 'PriorityRanking.DESCENDING'


class Priority:
    MIN_PRIORITY = 0
    MAX_PRIORITY = 100
    IMPORTANCE_RANKING = PriorityRanking.ASCENDING

    def __init__(self, _priority):
        self.__priority = _priority

    def set_priority(self, new_prio):
        """
        set_priority(new_prio) -> boolean

        Sets the new priority value to the task if given value is between MIN_PRIORITY and MAX_PRIORITY boundaries and returns True.
        Otherwise, it returns False.

        :param new_prio: the new priority value for a task
        :return: boolean
        """
        if Priority.MIN_PRIORITY <= new_prio <= Priority.MAX_PRIORITY:
            self.__priority = new_prio
            LOG(msg='New priority value has been assigned. Priority=%d' % (self.__priority))
            return True

        LOG(msg='Given priority value is not within the range of [%d, %d].' % (Priority.MIN_PRIORITY, Priority.MAX_PRIORITY), log=Logs.ERROR)
        return False

    def get_priority(self):
        """
        get_priority() -> int

        Returns the current priority value of the task.

        :return: int
        """
        return self.__priority if Priority.IMPORTANCE_RANKING == PriorityRanking.DESCENDING else Priority.MAX_PRIORITY-self.__priority

    @classmethod
    def set_class_vars(cls, min_prio=None, max_prio=None, ranking=None):
        """
        set_class_vars(min_prio=None, max_prio=None, ranking=None) -> None (class method)

        Sets the class variables MIN_PRIORITY and MAX_PRIORITY, separately.
        If given min_prio is greater than the current value, it gives a warning.
        If given max_prio is less than the current value, it gives warning.
        If ranking is defined and either ASCENDING or DESCENDING, it sets the ranking cirteria with the given ranking argument.

        :param min_prio: the new minimum boundary for priority values
        :param max_prio: the new maximum boundary for priority values
        :param ranking: 'PriorityRanking.DESCENDING' | 'PriorityRanking.ASCENDING'
        :return: None
        """
        if min_prio and min_prio > cls.MIN_PRIORITY:
            LOG(msg='Given new minimum priority value is higher than the current one. New=%d - Current=%d' % (min_prio, cls.MIN_PRIORITY), log=Logs.WARN)
        elif min_prio:
            cls.MIN_PRIORITY = min_prio

        if max_prio and max_prio > cls.MAX_PRIORITY:
            LOG(msg='Given new maximum priority value is lower than the current one. New=%d - Current=%d' % (max_prio, cls.MAX_PRIORITY), log=Logs.WARN)
        elif min_prio:
            cls.MAX_PRIORITY = max_prio

        if ranking and ranking in [getattr(PriorityRanking, attr) for attr in dir(PriorityRanking) if attr.isupper()]:
            LOG(msg='New ranking criteria = %s' % ranking)
            cls.IMPORTANCE_RANKING = ranking