from LFOS.Task.Periodicity import PeriodicityFactory, PeriodicityTypeList
from LFOS.Log import LOG, Logs

class Timing(object):

    def __init__(self, arr_time, deadline):
        self.__execution_time = -1.0
        self.__release_time = arr_time
        self.__deadline = deadline

        # Default periodicity = SPORADIC
        self.__periodicity = PeriodicityFactory.create_instance(PeriodicityTypeList.SPORADIC)

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

    '''
        For periodicity method calls
    '''
    def __getattr__(self, item):
        return getattr(self.__periodicity, item)