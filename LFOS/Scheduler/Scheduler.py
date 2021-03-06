from LFOS.Task.Task import TaskFactory, TaskInterface
from LFOS.Resource.Resource import ResourceTypeList, ResourceFactory, System
from LFOS.Data.TokenPool import TokenPool
from LFOS.Log import Logs, LOG
from LFOS.Scheduling.Characteristic.SchedulingCharacteristic import SchedulingCharacteristic
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduling.Strategy.SchedulingStrategy import SchedulingStrategy


class Scheduler(SchedulingCharacteristic, SchedulingStrategy, TokenPool):
    def __new__(cls, **kwargs):
        return super(Scheduler, cls).__new__(cls)

    def __init__(self, **kwargs):
        SchedulingCharacteristic.__init__(self)
        SchedulingStrategy.__init__(self, **kwargs)
        TokenPool.__init__(self)

        self.__taskset = list()
        self.__system = System

    def add_task(self, task):
        if isinstance(task, TaskInterface) and task not in self.__taskset:
            self.__taskset.append(task)
            tokens = task.get_relevant_token_types()
            self.add_token_list(tokens)
            LOG(msg='New task is added to the taskset. Task=%s' % task.info())
            return True

        LOG(msg='Given parameter is not a task or already in the taskset.', log=Logs.ERROR)
        return False

    def add_tasks_in_bundle(self, *task_list):
        for task in task_list:
            self.add_task(task)
        self.update_taskset(self.__taskset)

    def get_taskset(self):
        return self.__taskset

    def remove_task(self, task):
        if isinstance(task, TaskInterface) and task in self.__taskset:
            index = self.__taskset.index(task)
            self.__taskset.pop(index)
            LOG(msg='The task is removed from the taskset. Task=%s' % task.info(False))
            self.update_taskset(self.__taskset)
            return task

        LOG(msg='Given parameter is not task or not in the taskset.', log=Logs.ERROR)
        return False

    def schedule_tasks(self):
        begin, end = self.get_scheduling_window_boundaries()
        jobs = []
        for task in self.__taskset:
            LOG(msg="I am here!")
            jobs += task.get_jobs(begin, end)
            LOG(msg="I am here!")
            print(begin, end)
            print(jobs)
        if not jobs:
            LOG(msg='There is no jobs within [%r %r]' % (begin, end), log=Logs.ERROR)
            return None
        resources = self.__system.for_each_sub_terminal_resource()
        if not resources:
            LOG(msg='There is no resources under System composite resource.', log=Logs.ERROR)
            return None

        token_pool = self.get_tokens_as_dict()

        self._define_variables(jobs, self.__system, token_pool, self._overall_objective, begin, end)
        return self._optimize()
