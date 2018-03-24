

class SchedulingTypes:
    OFFLINE = 'SchedulingTypes.OFFLINE'
    ONLINE = 'SchedulingTypes.ONLINE'

    @classmethod
    def is_class_var(cls, _var):
        return _var in [cls.OFFLINE, cls.ONLINE]