from LFOS.Task.Periodicity import PeriodicityTypeList, Periodicity
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import LOG, Logs


class Timing(Periodicity):

    def __init__(self, arr_time, deadline):
        Periodicity.__init__(self, PeriodicityTypeList.SPORADIC)

        self.__execution_time = Time(-1)
        self.__release_time = arr_time
        self.__deadline = deadline

        # Default periodicity = SPORADIC
        # self.__periodicity = PeriodicityFactory.create_instance(PeriodicityTypeList.SPORADIC)

    def set_execution_time(self, new_exec_time):
        self.__execution_time = new_exec_time

    def get_execution_time(self):
        return self.__execution_time

    def set_release_time(self, new_release_time):
        self.__release_time = new_release_time

    def get_release_time(self):
        return self.__release_time

    def set_deadline(self, new_deadline):
        self.__deadline = new_deadline

    def get_deadline(self):
        return self.__deadline
