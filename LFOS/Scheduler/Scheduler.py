from LFOS.Resource.Resource import System, ResourceRequestResponseFactory, AdvancedResourceRequestResponse, BasicResourceRequestResponse
from LFOS.Scheduler.SchedulingPolicy import SchedulingPolicy, SchedulingPolicyList
from LFOS.Scheduler.SchedulingTypes import SchedulingType
from LFOS.Scheduler.Schedule import Schedule
from LFOS.Data.TokenPool import TokenPool
from LFOS.Task.Task import AbstractTask
from LFOS.Log import LOG, Logs


class Scheduler(SchedulingPolicy, TokenPool):
    def __init__(self):

        self.taskset = list()
        self.system = System

        self.time_resolution = 0.5
        self.schedule_begin = 0
        self.schedule_end = 0

        self.preemptable = True

        self.scheduling_type = SchedulingType.OFFLINE

        SchedulingPolicy.__init__(SchedulingPolicyList.FIFO)
        TokenPool.__init__()

    def set_preemptable_flag(self, flag):
        self.preemptable = flag

    def is_preemptable(self):
        return self.preemptable

    def set_scheduler_online(self):
        self.scheduling_type = SchedulingType.ONLINE

    def set_scheduler_offline(self):
        self.scheduling_type = SchedulingType.OFFLINE

    def get_scheduler_type(self):
        return self.scheduling_type

    def add_task(self, task):
        if task in self.taskset:
            LOG(msg='%s is already in the task set.' % task.get_credential(), log=Logs.WARN)
            return False

        self.taskset.append(task)
        self.__order_tasks()

        LOG(msg='%s is added to the task set.' % task.get_credential(), log=Logs.INFO)
        return True

    def remove_task(self, task):
        if task in self.taskset:
            index = self.taskset.index(task)
            self.taskset.pop(index)
            LOG(msg='%s is removed from the task set.' % task.get_credential(), log=Logs.INFO)
            return True

        LOG(msg='%s is not in the task set.' % task.get_credential(), log=Logs.WARN)
        return False

    def add_task_in_bulk(self, task_list):
        all_success = True
        for task in task_list:
            all_success = all_success and self.add_task(task)

        self.__order_tasks()
        if all_success:
            LOG(msg='All tasks have been added to the task set.', log=Logs.INFO)
            return True

        return False

    def remove_task_in_bulk(self, task_list):
        all_success = True
        for task in task_list:
            all_success = all_success and self.remove_task(task)

        if all_success:
            LOG(msg='All tasks have been removed to the task set.', log=Logs.INFO)
            return True

        return False

    def set_time_resolution(self, resolution):
        self.time_resolution = resolution

    def get_time_resolution(self):
        return self.time_resolution

    def schedule(self, begin_tm=0, end_tm=0):
        current_time = begin_tm
        schedule = Schedule()

        # Online scheduling
        if self.scheduling_type == SchedulingType.ONLINE:
            task = self.__get_ready_tasks(current_time)
            if task:
                response = self.system.request(task.get_resource_requests())
                running_task, reserved_resources = self.__decide_on_resource(task, response)
                schedule.append_item(running_task, reserved_resources, current_time, current_time+self.time_resolution)
            else:
                schedule.append_empty_slot(current_time, current_time+self.time_resolution)
        # Offline scheduling
        else:
            while current_time <= end_tm:
                ready_tasks_w_index = self.__get_ready_tasks(current_time)
                self.__schedule_ready_tasks(schedule, ready_tasks_w_index, current_time)
                current_time += self.time_resolution

        return schedule

    # Internal private methods
    def __schedule_ready_tasks(self, schedule, ready_tasks_w_index, current_time):
        if ready_tasks_w_index:
            for task, _ in ready_tasks_w_index:
                if task.is_running():
                    task.
                response = self.system.request(task.get_resource_requests())
                response_type = self.system.get_resource_request_type()

                if response_type == 'advanced':
                    available_resources = response.get_resources_list(AdvancedResourceRequestResponse.AVAILABLE)
                    if available_resources:
                        self.system.alloc(available_resources)
                        return True
                    else:
                        pass

                    schedule.append_item(task, available_resources, current_time, current_time + self.time_resolution)
                else:
                    pass
        else:
            schedule.append_empty_slot(current_time, current_time + self.time_resolution)

    def __get_ready_tasks(self, current_time):
        ready_tasks = []
        for index, task in enumerate(self.taskset):
            if task.ready_to_execute(self, current_time):
                ready_tasks.append([task, index])

        return ready_tasks

    def __get_same_type_range(self, init_index):
        type_value = self.taskset[init_index].get_task_type_importance()

        for end_index, task in enumerate(self.taskset[init_index:]):
            if task.get_task_type_importance() != type_value:
                return end_index + init_index

        return len(self.taskset)

    def __get_grouping_range(self):
        ranges = list()
        begin_index = 0
        end_index = 0

        while end_index != len(self.taskset):
            end_index = self.__get_same_type_range(begin_index)
            ranges.append((begin_index, end_index))

        return ranges

    def __rank_tasks(self):
        prio = 0
        for task in self.taskset:
            task.set_priority(prio)
            prio += 1

    def __order_tasks(self):
        if self.grouping_active():
            self.taskset.sort(cmp=self.cmp_grouping())
            group_ranges = self.__get_grouping_range()

            for begin, end in group_ranges:
                self.taskset[begin:end] = sorted(self.taskset[begin:end], cmp=self.cmp_ranking())

        self.taskset.sort(cmp=self.cmp_ranking())
        self.__rank_tasks()
