from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class PeriodicityTypeList:
    APERIODIC = 'PeriodicityTypeList.APERIODIC'
    SPORADIC = 'PeriodicityTypeList.SPORADIC'
    PERIODIC = 'PeriodicityTypeList.PERIODIC'


class Periodicity:
    TYPES = [getattr(PeriodicityTypeList, attr) for attr in dir(PeriodicityTypeList) if attr.isupper()]

    def __init__(self, _type):
        self.period = Time(-1)
        self.type = _type

    def set_period(self, new_period):
        """
        set_period(new_period) -> boolean

        Sets the new period value returns True if its type is PERIODIC. Otherwise, it returns False. Noting that the new
        value for period is supposed to be the instance of Time class, otherwise it raises AssertionError.

        :param new_period: the new value for period
        :return: boolean
        """
        if self.type == PeriodicityTypeList.PERIODIC:
            assert isinstance(new_period, Time)
            self.period = new_period
            return True

        LOG(msg='Invalid request. Sporadic tasks cannot have a specific period time.', log=Logs.ERROR)
        return False

    def set_periodicity(self, _type):
        """
        set_periodicity(_type) -> None

        Sets the periodicity type to the new value if it is one of the defined attributes in TYPES class variable.

        :param _type: the new type of the instance
        :return: None
        """
        if _type in Periodicity.TYPES:
            self.type = _type

    def get_period(self):
        """
        get_period() -> LFOS.Scheduling.Characteristic.Time

        Returns the period value.

        :return: LFOS.Scheduling.Characteristic.Time
        """
        return self.period

    def get_period_type(self):
        """
        get_period_type() -> LFOS.Scheduling.Characteristic.Time

        Returns the periodicity type value.

        :return: LFOS.Scheduling.Characteristic.Time
        """
        return self.type
