from LFOS.Task.Task import TaskFactory, TaskInterface
from LFOS.Resource.Resource import ResourceTypeList, ResourceFactory, System
from LFOS.Data.TokenPool import TokenPool, Token
from LFOS.Log import Logs, LOG
from LFOS.Scheduling.Characteristic.SchedulingCharacteristic import SchedulingCharacteristic
from LFOS.Scheduling.Strategy.SchedulingStrategy import SchedulingStrategy


class Scheduler(SchedulingCharacteristic, SchedulingStrategy):
    def __init__(self, **kwargs):
        SchedulingCharacteristic.__init__(self)
        SchedulingStrategy.__init__(self, **kwargs)

        self.__taskset = list()
        self.__system = System
        self.__token_pool = TokenPool()

    def add_task(self, task):
        if isinstance(task, TaskInterface) and task not in self.__taskset:
            self.__taskset.append(task)
            LOG(msg='New task is added to the taskset. Task:%s' % task.info(False))
            return True

        LOG(msg='Given parameter is not task or already in the taskset.', log=Logs.ERROR)
        return False

    def remove_task(self, task):
        if isinstance(task, TaskInterface) and task in self.__taskset:
            index = self.__taskset.index(task)
            self.__taskset.pop(index)
            LOG(msg='The task is removed from the taskset. Task=%s' % task.info(False))
            return task

        LOG(msg='Given parameter is not task or not in the taskset.', log=Logs.ERROR)
        return False

    def schedule_tasks(self):
        begin, end = self.get_scheduling_window_boundaries()
        jobs = [job for job in self.__taskset if begin <= job.get_release_time() and job.get_extended_deadline() < end]
        resources = self.__system.for_each_sub_terminal_resource()