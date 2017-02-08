import os
import sys
import time
sys.path.insert(0, os.path.abspath('..'))

from GUI.ElevatorGUI import ElevatorUI
from GUI.elevator_params import number_of_floors, Tasks, Direction, reverse_direction

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Scheduling.Schedule.Schedule import Schedule
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


class ElevatorController:
    def __init__(self, **kwargs):
        self._num_elevator = kwargs['num_elevator'] if 'num_elevator' in kwargs else 1
        self._current_floors = {}
        self._elevator_directions = {}

        self.__initialize_env()
        self.__initialize_GUI()

    def __initialize_GUI(self):
        self._gui = ElevatorUI(self)

    def __initialize_env(self):
        self._waiting = {Direction.UP:[], Direction.DOWN:[], 'FirstCome':Direction.UP}
        self._updated_taskset_flag = False

        self._elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')

        for elevator_id in range(self._num_elevator):
            elevator = ResourceFactory.create_instance(self._elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            self._current_floors[elevator] = 0
            self._elevator_directions[elevator] = Direction.UP

            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)

            System.add(elevator)

        System.pretty_print()
        System.print_accessibilites()

        Time.set_time_resolution(0)

        self._scheduler = Scheduler(solver='Mistral2', verbose=0, time_cutoff=35)
        self._scheduler.set_scheduling_window_start_time(Time(0))
        self._scheduler.set_scheduling_window_duration(Time(2*number_of_floors))
        self._do_schedule()

    def _identify_task(self, raw_task_name, floor, direction):
        return '%s_%02d' % (raw_task_name, int(floor)), direction

    def _get_target_floor(self, _task):
        return int(_task.get_name().split('_')[-1])

    def _get_direction(self, _task):
        return _task.get_type()

    def _do_schedule(self):
        self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF, self._scheduler.get_taskset())
        self._schedules = self._scheduler.schedule_tasks()
        self._schedule = self._schedules[0] if self._schedules else []
        self._scheduled_flag = True
        self._updated_taskset_flag = False

    def _update_resource_requirements(self, _task):
        return {resource:abs(self._current_floors[resource]-self._get_target_floor(_task)) for resource in System.for_each_sub_terminal_resource()}

    def _update_time_attrs(self, _tasks, _time):
        for task in _tasks:
            assert isinstance(task, TaskInterface)
            task.set_release_time(Time(_time))
            task.set_deadline(Time(_time + 2 * number_of_floors))
            task.add_resource_requirement(resource_type=self._elevator_t,
                                          eligible_resources=self._update_resource_requirements(task),
                                          capacity=1)

            print task.info(True)
        self._scheduled_flag = False
        self._updated_taskset_flag = True


    def publish_task(self, params, current_tm):
        task_t = params[0]
        direction = params[1]
        target_floor = int(params[2].split(' ')[-1])
        LOG(msg='task_t=%s, direction=%s, Target=%d' % (task_t, direction, target_floor))
        self.generate_task(task_t, direction, target_floor, current_tm)

    def _create_task(self, task_t, direction, target_floor, _time):
        the_resource = System.for_each_sub_terminal_resource()[0]
        if task_t == Tasks.CarCall:
            direction = Direction.UP if target_floor > self._current_floors[the_resource] else Direction.DOWN

        new_task_name, new_task_type = self._identify_task(task_t, target_floor, direction)
        new_task = TaskFactory.create_instance(TaskTypeList.TERMINAL,
                                               name=new_task_name,
                                               type=new_task_type,
                                               phase=Time(_time),
                                               deadline=Time(_time + 2 * number_of_floors),
                                               periodicity=PeriodicityTypeList.APERIODIC,
                                               preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                               token_name=[new_task_type])
        new_task.add_resource_requirement(resource_type=self._elevator_t,
                                          eligible_resources=self._update_resource_requirements(new_task),
                                          capacity=1)

        return new_task

    def _add_waiting_list(self, _task, direction):
        if (direction == Direction.UP and not self._waiting[Direction.DOWN]) or (direction == Direction.DOWN and not self._waiting[Direction.UP]):
            self._waiting['FirstCome'] = direction
            LOG(msg='First Come Direction has been updated. Direction=%s' % (direction))

        if _task in self._waiting[direction]:
            LOG(msg='The task has already been in the waiting list.')
            return False

        self._waiting[direction].append(_task)
        LOG(msg='The task has been appended to the waiting list. Direction=%s Content=%s' % (direction, ', '.join(task.get_credential() for task in self._waiting[direction])))
        return True

    def _is_waiting_list_empty(self):
        return not (self._waiting[Direction.UP] or self._waiting[Direction.DOWN])

    def _fetch_tasks_from_waiting_list(self):
        ready_list = self._waiting[self._waiting['FirstCome']]
        self._waiting[self._waiting['FirstCome']] = []
        self._waiting['FirstCome'] = reverse_direction(self._waiting['FirstCome'])
        return ready_list

    def _search_waiting_list(self, _task):
        if _task in self._waiting[Direction.UP]:
            return Direction.UP, self._waiting[Direction.UP].index(_task)
        if _task in self._waiting[Direction.DOWN]:
            return Direction.DOWN, self._waiting[Direction.DOWN].index(_task)

        LOG(msg='Given task is NOT in the waiting list...', log=Logs.ERROR)
        return None, -1

    def _remove_from_waiting_list(self, _task):
        t_direction, t_index = self._search_waiting_list(_task)
        if t_direction:
            if not self._waiting[t_direction]:
                self._waiting['FirstCome'] = reverse_direction(t_direction)
            return self._waiting[t_direction].pop(t_index)

        return None

    def _waiting_list_iterator(self):
        for _task in self._waiting[self._waiting['FirstCome']]:
            yield _task
        for _task in self._waiting[reverse_direction(self._waiting['FirstCome'])]:
            yield _task

    def _move_elevator(self, resource, target_floor):
        if self._current_floors[resource] < target_floor:
            self._current_floors[resource] += 1
            self._elevator_directions[resource] = Direction.UP
        else:
            self._current_floors[resource] -= 1
            self._elevator_directions[resource] = Direction.DOWN

    def _eliminate_task_from_taskset(self, task, current_floor):
        target_floor = self._get_target_floor(task)
        if target_floor == current_floor:
            # Remove the tasks in the taskset and waiting list with the same semantic. CarCall_XX == HallCall_XX
            for _task in self._scheduler.get_taskset():
                if target_floor == self._get_target_floor(_task):
                    self._scheduler.remove_task(_task)
                    LOG(msg='The task has been removed from the taskset. Task=%s' % task.get_credential())
            for _task in self._waiting_list_iterator():
                if target_floor == self._get_target_floor(_task):
                    self._remove_from_waiting_list(_task)
                    LOG(msg='The task has been removed from the waiting list. Task=%s' % task.get_credential())
            return True
        return False

    def generate_task(self, task_t, direction, target_floor, _time):
        target_floor = int(target_floor)

        new_task = self._create_task(task_t, direction, target_floor, _time)
        taskset = self._scheduler.get_taskset()
        the_resource = System.for_each_sub_terminal_resource()[0]
        new_task_dir = self._get_direction(new_task)

        if not self._current_floors[the_resource] == target_floor:
            LOG(msg='Elevator:%s, Task:%s' % (self._elevator_directions[the_resource], new_task_dir))
            if (not taskset) or self._elevator_directions[the_resource] == new_task_dir:
                self._scheduler.add_task(new_task)
                self._elevator_directions[the_resource] = new_task_dir
                self._updated_taskset_flag = True
            else:
                self._add_waiting_list(new_task, new_task_dir)

        self._scheduler.set_scheduling_window_start_time(Time(_time))
        self._update_time_attrs(self._scheduler.get_taskset(), Time(_time))

        self._scheduled_flag = False

    def monitor(self, _begin, _end):
        log = 'BEGIN:%03d END:%03d]' % (_begin, _end)

        LOG(msg='scheduled_flag=%r, updated_taskset_flag=%r' % (self._scheduled_flag, self._updated_taskset_flag))
        if not self._scheduled_flag:
            taskset = self._scheduler.get_taskset()
            if taskset:
                if self._updated_taskset_flag:
                    self._scheduler.set_scheduling_window_start_time(Time(_begin))
                    self._update_time_attrs(self._scheduler.get_taskset(), Time(_begin))
                    self._do_schedule()
            else:
                if not self._is_waiting_list_empty():
                    ready_list = self._fetch_tasks_from_waiting_list()
                    self._update_time_attrs(ready_list, _begin)
                    self._scheduler.add_task_in_bundle(*ready_list)
                    LOG(msg='The waiting list tasks has been added to the taskset. Tasks=%s' % ', '.join(task.get_name() for task in ready_list))
                    self._do_schedule()

        for resource in System.for_each_sub_terminal_resource():
            self._reservation_slot = self._schedule.get_partial_schedule(resource, _begin, _end) if self._schedule else []

            log += '\t%15s --> %s' % (resource.get_resource_name(), '' if self._reservation_slot else 'EMPTY')
            multiple_reservation_flag = True
            for reservation in self._reservation_slot:
                log += 'Task=%33s, Capacity=%d' % (reservation[0].get_credential(), reservation[3])
                target_floor = self._get_target_floor(reservation[0])

                if multiple_reservation_flag:
                    self._move_elevator(resource, target_floor)
                    multiple_reservation_flag = False

                self._eliminate_task_from_taskset(reservation[0], self._current_floors[resource])
                self._update_time_attrs(self._scheduler.get_taskset(), _end)

            log = '[FLOOR:%02d ' % (self._current_floors[resource]) + log + '\n'

        return log

    # def get_schedule(self, begin, end):
    #     log = '[%02d %02d]\n' % (begin, end)
    #
    #     if not self._scheduled_flag:
    #         taskset = self._scheduler.get_taskset()
    #         if taskset:
    #             self._scheduler.clear_tokens()
    #             self._scheduler.add_token(taskset[0].get_type(), Time(begin), 1)
    #         else:
    #             if self._waiting_jobs:
    #                 self._target_dir = self._waiting_jobs[0].get_type()
    #                 self._scheduler.add_token(self._waiting_jobs[0].get_type(), Time(begin), len(self._waiting_jobs))
    #                 self._update_execution_times(self._waiting_jobs, Time(begin))
    #                 self._scheduler.add_task_in_bundle(*self._waiting_jobs)
    #                 self._waiting_jobs = []
    #
    #         self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF, taskset)
    #         self._schedules = self._scheduler.schedule_tasks()
    #         self._schedule = self._schedules[0] if self._schedules else []
    #         self._scheduled_flag = True
    #
    #     for resource in System.for_each_sub_terminal_resource():
    #         self._partial_schedule = self._schedule.get_partial_schedule(resource, begin, end) if self._schedule else []
    #         print self._partial_schedule
    #
    #         log += '\t{%s} == %s' % (resource.get_credential(), '' if self._partial_schedule else 'EMPTY')
    #         multiple_reservation_flag = True
    #         for reservation in self._partial_schedule:
    #             log += '%s-%d, ' % (reservation[0].get_credential(), reservation[3])
    #             task_name, target_floor = reservation[0].get_name().split('_')
    #
    #             if multiple_reservation_flag:
    #                 if self._current_floors[resource] < int(target_floor):
    #                     self._elevator_directions[resource] = Direction.UP
    #                     self._current_floors[resource] += 1
    #                 else:
    #                     self._elevator_directions[resource] = Direction.DOWN
    #                     self._current_floors[resource] -= 1
    #                 multiple_reservation_flag = False
    #
    #             if int(target_floor) == self._current_floors[resource]:
    #                 self._scheduler.remove_task(reservation[0])
    #                 self._update_execution_times(self._scheduler.get_taskset(), Time(end))
    #
    #         self._scheduled_flag = False
    #
    #         log += ' Floor=%d\n' % self._current_floors[resource]
    #     return log


    # def _update_execution_times(self, jobs, tm):
    #     for job in jobs:
    #         resource_requirements = {}
    #         for resource in System.for_each_sub_terminal_resource():
    #             current_floor = self._current_floors[resource]
    #             target_floor = int(job.get_name().split('_')[-1])
    #             resource_requirements[resource] = Time(abs(target_floor-current_floor))
    #
    #         job.set_release_time(Time(tm))
    #         job.add_resource_requirement(resource_type=self._elevator_t,
    #                                      eligible_resources=resource_requirements,
    #                                      capacity=1)
    #         self._scheduler.add_token(job.get_type(), Time(tm), 1)
    #
    #         print job.info(True)
    #
    # def search_waiting_jobs(self, dir):
    #     same_dir_jobs = []
    #     for job in self._waiting_jobs:
    #         if job.get_type() == dir:
    #             same_dir_jobs.append(job)
    #             self._waiting_jobs.remove(job)
    #
    #     return same_dir_jobs
    #
    # def generate_task(self, task_t, direction, floor, tm):
    #     LOG(msg='Time=%d' % (tm))
    #
    #     elevator_moving_flag = False
    #     self._update_execution_times(self._scheduler.get_taskset(), tm)
    #     # for resource in System.for_each_sub_terminal_resource():
    #     #     executed = Time(tm) - self._scheduler.get_scheduling_window_start_time()
    #     #     prev_schedule = self._schedule.get_partial_schedule(resource, self._scheduler.get_scheduling_window_start_time(), Time(tm)) if self._schedule else []
    #     #     for reservation in prev_schedule:
    #     #         print Time(tm), reservation[2]
    #     #         if Time(tm) <= reservation[2]:
    #     #             elevator_moving_flag = True
    #     #             obsolete_job = self._scheduler.remove_task(reservation[0])
    #     #             obsolete_job.set_release_time(Time(tm))
    #     #             obsolete_job.add_resource_requirement(resource_type=self._elevator_t, eligible_resources={resource:Time(abs(obsolete_job.get_max_wcet_time()-executed)) for resource in System.for_each_sub_terminal_resource()}, capacity=1)
    #     #             print obsolete_job.info(True)
    #     #
    #     #             self._scheduler.add_token(obsolete_job.get_type(), Time(tm), 1)
    #     #             self._scheduler.add_task(obsolete_job)
    #
    #     self._scheduler.set_scheduling_window_start_time(Time(tm))
    #
    #     same_floor_flag = False
    #     for resource in System.for_each_sub_terminal_resource():
    #         if floor - self._current_floors[resource] == 0:
    #             same_floor_flag = True
    #
    #     if not same_floor_flag:
    #         task_name = '%s_%02d' % (task_t.split('.')[-1], floor)
    #         self.the_resource = System.for_each_sub_terminal_resource()[0]
    #         if task_t == Tasks.CarCall:
    #             task_type_name = Direction.UP if self._current_floors[self.the_resource] < floor else Direction.DOWN
    #         else:
    #             task_type_name = direction
    #
    #         task = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type=task_type_name,
    #                                            phase=Time(tm), deadline=Time(tm + 2 * number_of_floors),
    #                                            periodicity=PeriodicityTypeList.APERIODIC, token_name=[task_type_name])
    #
    #         task.add_resource_requirement(resource_type=self._elevator_t,
    #                                       eligible_resources={resource: Time(abs(floor - self._current_floors[resource])) for resource in System.for_each_sub_terminal_resource()},
    #                                       capacity=1)
    #
    #         task.add_dependency(task_type_name, 1)
    #         print task.info(True)
    #
    #         if not self._scheduler.get_taskset():
    #             self._scheduler.clear_tokens()
    #             self._scheduler.add_task(task)
    #             self._scheduler.add_token(task_type_name, Time(tm), 1)
    #             same_dir_waiting_jobs = self.search_waiting_jobs(task.get_type())
    #             if same_dir_waiting_jobs:
    #                 print 'WAITING JOBS LIST: %s' % (', '.join(job.get_credential() for job in same_dir_waiting_jobs))
    #                 self._update_execution_times(same_dir_waiting_jobs, Time(tm))
    #                 self._scheduler.add_task_in_bundle(*same_dir_waiting_jobs)
    #                 self._scheduler.add_token(task_type_name, Time(tm), len(same_dir_waiting_jobs))
    #             self._target_dir = task_type_name
    #         else:
    #             if (task_type_name == self._target_dir == Direction.UP) or\
    #                (task_type_name == self._target_dir == Direction.DOWN):
    #                 self._scheduler.add_task(task)
    #                 self._scheduler.add_token(task_type_name, Time(tm), 1)
    #             else:
    #                 LOG(msg='A new job is added to the waiting list.')
    #                 self._waiting_jobs.append(task)
    #                 print 'WAITING JOBS LIST: %s' % (', '.join(job.get_credential() for job in self._waiting_jobs))
    #                 return
    #
    #         self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF, self._scheduler.get_taskset())
    #         self._schedules = self._scheduler.schedule_tasks()
    #         self._schedule = self._schedules[0] if self._schedules else []
    #         self._scheduled_flag = True

if __name__ == '__main__':
    elevator_ctrl = ElevatorController()