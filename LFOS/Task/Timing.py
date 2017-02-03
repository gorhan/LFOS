from LFOS.Task.Periodicity import PeriodicityTypeList, Periodicity
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class Timing(Periodicity):

    def __init__(self, arr_time, deadline):
        Periodicity.__init__(self, PeriodicityTypeList.SPORADIC)
        assert isinstance(arr_time, Time)
        assert isinstance(deadline, Time)

        self.__execution_time = Time(-1)
        self.__release_time = arr_time
        self.__deadline = deadline

        # Default periodicity = SPORADIC
        # self.__periodicity = PeriodicityFactory.create_instance(PeriodicityTypeList.SPORADIC)

    def set_execution_time(self, new_exec_time):
        """
        set_execution_time(new_exec_time) -> None

        Sets the worst-case execution time to the new value if it is the instance of Time class.

        :param new_exec_time: the new worst-case execution time for a task
        :return: None
        """
        assert isinstance(new_exec_time, Time)
        self.__execution_time = new_exec_time

    def get_execution_time(self):
        """
        get_execution_time() -> LFOS.Scheduling.Characteristic.Time

        Returns the current worst-case execution time.

        :return: LFOS.Scheduling.Characteristic.Time
        """
        return self.get_max_wcet_time()

    def set_release_time(self, new_release_time):
        """
        set_release_time(new_release_time) -> None

        Sets the release time to the new value if it is the instance of Time class.

        :param new_release_time: the new release time for a task
        :return: None
        """
        assert isinstance(new_release_time, Time)
        self.__release_time = new_release_time

    def get_release_time(self):
        """
        get_release_time() -> LFOS.Scheduling.Characteristic.Time

        Returns the current release time.

        :return: LFOS.Scheduling.Characteristic.Time
        """
        return self.__release_time

    def set_deadline(self, new_deadline):
        """
        set_deadline(new_deadline) -> None

        Sets the deadline to the new value if it is the instance of Time class.

        :param new_deadline: the new deadline for a task
        :return: None
        """
        assert isinstance(new_deadline, Time)
        self.__deadline = new_deadline

    def get_deadline(self):
        """
        get_deadline() -> LFOS.Scheduling.Characteristic.Time

        Returns the current deadline.

        :return: LFOS.Scheduling.Characteristic.Time
        """
        return self.__deadline
