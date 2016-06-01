from LFOS.Resource.Resource import System, ResourceRequestResponseFactory, AdvancedResourceRequestResponse, BasicResourceRequestResponse
from LFOS.Resource.ResourceTypes import ACTIVE, PASSIVE, COMPOSITE
from LFOS.Scheduler.SchedulingPolicy import SchedulingPolicy, SchedulingPolicyList
from LFOS.Scheduler.SchedulingTypes import SchedulingType
from LFOS.Scheduler.Schedule import Schedule
from LFOS.Task.Timing import Timing
from LFOS.Data.TokenPool import TokenPool
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

        SchedulingPolicy.__init__(self, SchedulingPolicyList.FIFO)
        TokenPool.__init__(self)

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
            while current_time < end_tm:
                self.__schedule_ready_tasks(schedule, current_time)
                current_time += self.time_resolution

        return schedule

    # Internal private methods
    def __schedule_ready_tasks(self, schedule, current_time):
        scheduled_flag = False
        for task in self.taskset:
            status = task.is_running(current_time)

            if not task.is_running(current_time) and task.ready_to_execute(self, current_time):
                response = self.system.request(task)
                response_type = self.system.get_resource_request_type()

                # print 'Task', task.get_credential(), 'is NOT running and ready to execute at', current_time
                available_resources = response.get_resources_list(AdvancedResourceRequestResponse.AVAILABLE)
                inuse_resources = response.get_resources_list(AdvancedResourceRequestResponse.INUSE)
                if response_type == 'advanced' and available_resources:
                    allocated_resources = self.__allocate_available_resource_set(task, available_resources, current_time)
                    scheduled_flag = True

                    # print 'ALLOCATEDDD:', allocated_resources
                    schedule.append_item(task, current_time, current_time + self.time_resolution, allocated_resources)
                elif inuse_resources:
                    allocated_resources = self.__allocate_inuse_resource_set(task, inuse_resources, current_time)
                    if allocated_resources:
                        scheduled_flag = True
                        schedule.append_item(task, current_time, current_time + self.time_resolution, allocated_resources)

            elif task.is_running(current_time):
                if task.is_finished():
                    task.stop_task(current_time)
                    self.system.free(task)
                else:
                    schedule.append_item(task, current_time, current_time+self.time_resolution)
                    scheduled_flag = True

        if not scheduled_flag:
            schedule.append_empty_slot(current_time, current_time + self.time_resolution)

    def __allocate_available_resource_set(self, task, available_resources, current_time):

        for resource_dict in available_resources:
            allocate_resources = dict()
            active_resource = None
            allocate_flag = False

            for resource_type, resources in resource_dict.items():
                allocated_capacity = 0
                required_capacity = task.get_required_capacity(resource_type)

                if resource_type.get_resource_type_name() == ACTIVE:
                    active_resource = resources[0]

                for resource in resources:
                    resource_capacity = resource.get_available_capacity()
                    if resource_capacity + allocated_capacity >= required_capacity:
                        allocate_resources[resource] = required_capacity - allocated_capacity
                        allocate_flag = True
                        break
                    else:
                        allocate_resources[resource] = resource_capacity
                        allocated_capacity += resource_capacity

            if allocate_flag:
                self.system.alloc(task, allocate_resources.copy())
                task.execute_on_active_resource(active_resource, current_time)
                # print 'INSIDER, ALLOCATED', allocate_resources
                return allocate_resources

        return {}

    def __allocate_inuse_resource_set(self, task, inuse_resources, current_time):
        from itertools import combinations

        print 'INUSE', task.get_credential(), 'AT', current_time
        for resource_dict in inuse_resources:
            common_tasks = set(self.taskset)
            all_tasks = set()

            for resource_type, resources in resource_dict.items():
                available_capacity = sum([resource.get_available_capacity() for resource in resources])
                required_capacity = task.get_required_capacity(resource_type)
                missing_capacity = required_capacity - available_capacity

                if missing_capacity > 0:
                    collected_tasks = reduce(lambda x,y: x+y, [resource.get_running_tasks() for resource in resources])
                    print 'CHANGED', missing_capacity, 'COLLECTED', collected_tasks
                    common_tasks = common_tasks.intersection(set(collected_tasks))
                    all_tasks = all_tasks.union(collected_tasks)

            print 'COMMON', common_tasks, 'PRIO', list(common_tasks)[0].get_priority(), task.get_priority()
            common_tasks = [c_task for c_task in common_tasks if c_task.get_priority() > task.get_priority()]
            print 'COMMON', common_tasks
            if common_tasks:

                selection_task_set = reduce(lambda x, y: x + y, [list(combinations(common_tasks, r)) for r in range(1, len(common_tasks) + 1)])
                selection_task_set.sort(key=lambda s: max(task.get_priority() for task in s))
                for excluded_tasks in selection_task_set:
                    available_resources = self.system.request(task, excluded_tasks).get_resources_list(AdvancedResourceRequestResponse.AVAILABLE)

                    if available_resources:
                        for exc_task in excluded_tasks:
                            exc_task.stop_task(current_time)
                            self.system.free(exc_task)

                        return self.__allocate_available_resource_set(task, available_resources, current_time)

            all_tasks = [a_task for a_task in all_tasks if a_task.get_priority() > task.get_priority()]
            if all_tasks:
                all_task_set = reduce(lambda x, y: x + y, [list(combinations(all_tasks, r)) for r in range(1, len(all_tasks) + 1)])
                all_task_set.sort(key=lambda s: max(task.get_priority() for task in s))

                for excluded_tasks in selection_task_set:
                    available_resources = self.system.request(task, excluded_tasks).get_resources_list(AdvancedResourceRequestResponse.AVAILABLE)

                    if available_resources:
                        for exc_task in excluded_tasks:
                            exc_task.stop_task(current_time)
                            self.system.free(exc_task)

                        return self.__allocate_available_resource_set(task, available_resources, current_time)

        return {}

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

    def set_scheduling_policy(self, policy):
        self._set_policy(policy)
        self.__order_tasks()

