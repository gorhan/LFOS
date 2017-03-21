import os
import sys
from copy import deepcopy

sys.path.insert(0, os.path.abspath('..'))

from ElevatorParameters import *
from ElevatorStatistics import ElevatorStatistics
from WaitingQueue import WaitingQueue

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


class ElevatorController:
    def __init__(self, params):
        if Time.get_time_resolution() != 0:
            Time.set_time_resolution(0)

        if not isinstance(params, ElevatorParameters):
            LOG(tag=self._params.car.get_resource_name(), msg='Invalid type of parameters', log=Logs.ERROR)
            exit(0)

        self._params = params
        self._stat = ElevatorStatistics(self._params.num_floors)
        self._waiting_q = WaitingQueue()

        self._updated_taskset_flag = False
        self._scheduled_flag = False
        self._waited = Time(0)

        self._scheduler = Scheduler(solver=self._params.solver, verbose=self._params.verbose, time_cutoff=self._params.time_cutoff)
        self._scheduler.set_scheduling_window_start_time(self._params.start_time)
        self._scheduler.set_scheduling_window_duration(Time(2*self._params.num_floors))
        self._do_schedule()

    def _identify_task(self, raw_task_name, floor, direction, n_passengers, passenger_priority):
        return '%s_%02d_%d_%s' % (raw_task_name, int(floor), n_passengers, passenger_priority), direction

    def _get_target_floor(self, _task):
        return int(_task.get_name().split('_')[1])

    def _get_n_passengers(self, _task):
        return int(_task.get_name().split('_')[2])

    def _get_direction(self, _task):
        return _task.get_type()

    def get_parameter(self, param_name):
        return self._params[param_name]

    def _do_schedule(self):
        self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF, self._scheduler.get_taskset())
        self._schedules = self._scheduler.schedule_tasks()
        self._schedule = self._schedules[-1] if self._schedules else []
        self._scheduled_flag = True
        self._updated_taskset_flag = False

    def _update_resource_requirements(self, _task):
        return {self._params.car:abs(self._params.current_floor-self._get_target_floor(_task))}

    def _update_time_attrs(self, _tasks, _time):
        for task in _tasks:
            assert isinstance(task, TaskInterface)
            task.set_release_time(Time(_time))
            task.add_resource_requirement(resource_type=self._params.car.get_type(),
                                          eligible_resources=self._update_resource_requirements(task),
                                          capacity=1)

        # the deadlines have to be determined after updating the execution time of the tasks.
        LOG(tag=self._params.car.get_resource_name(), msg='Worst-Case Execution Time Total: %d' % sum([t.get_max_wcet_time() for t in _tasks]))
        for task in _tasks:
            task.set_deadline(Time(_time + sum([t.get_max_wcet_time() for t in _tasks]) ))
            print task.info(True)

        self._scheduled_flag = False
        self._updated_taskset_flag = True

    def _create_task(self, task_t, direction, target_floor, n_passengers, passenger_priority, _time):
        if isinstance(task_t, CarCall):
            direction = UP() if target_floor > self._params.current_floor else DOWN()
        elif isinstance(task_t, HallCall):
            n_passengers = 0 # hallcalls are requested otuside an elevator.

        new_task_name, new_task_type = self._identify_task(task_t, target_floor, direction, n_passengers, passenger_priority)
        new_task = TaskFactory.create_instance(TaskTypeList.TERMINAL,
                                               name=new_task_name,
                                               type=new_task_type,
                                               phase=Time(_time),
                                               deadline=Time(_time + 2 * self._params.num_floors),
                                               periodicity=PeriodicityTypeList.APERIODIC,
                                               preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                               token_name=[new_task_type])
        new_task.add_resource_requirement(resource_type=self._params.car.get_type(),
                                          eligible_resources=self._update_resource_requirements(new_task),
                                          capacity=1)

        return new_task

    def _move_elevator(self, resource, target_floor):
        if self._params.current_floor < target_floor:
            self._params.current_floor += 1
            self._params.direction = UP()
        else:
            self._params.current_floor -= 1
            self._params.direction = DOWN()

    def _eliminate_task_from_taskset(self, task, current_floor):
        target_floor = self._get_target_floor(task)
        if target_floor == current_floor:
            # Remove the tasks in the taskset and waiting list with the same semantic. CarCall_XX == HallCall_XX
            eliminated_list = []
            for _task in self._scheduler.get_taskset():
                if target_floor == self._get_target_floor(_task):
                    LOG(tag=self._params.car.get_resource_name(), msg='The task has been removed from the taskset. Task=%s' % task.get_credential())
                    eliminated_list.append(_task)
                    self._params.current_passengers -= self._get_n_passengers(_task)
                    # reduce the elevator weight here
            map(lambda _task: self._scheduler.remove_task(_task), eliminated_list)
            eliminated_list = []
            for _task in self._waiting_q.iter():
                if target_floor == self._get_target_floor(_task):
                    LOG(tag=self._params.car.get_resource_name(), msg='The task has been removed from the waiting list. Task=%s' % task.get_credential())
                    eliminated_list.append(_task)
                    self._params.current_passengers -= self._get_n_passengers(_task)
                    # reduce the elevator weight here
            map(lambda _task: self._waiting_q.remove(_task), eliminated_list)
            return True
        return False

    def is_running(self):
        return self._waited == Time(0)

    def generate_task(self, task_t, direction, target_floor, n_passengers, passenger_priority, _time):
        target_floor = int(target_floor)

        new_task = self._create_task(task_t, direction, target_floor, n_passengers, passenger_priority, _time)
        taskset = self._scheduler.get_taskset()
        new_task_dir = self._get_direction(new_task)
        new_n_passengers = self._get_n_passengers(new_task)

        LOG(tag=self._params.car.get_resource_name(), msg='ELEVATOR DIRECTION=%s' % self._params.direction)
        LOG(tag=self._params.car.get_resource_name(), msg='ELEVATOR WEIGHT=%d' % self._params.current_passengers)
        log = '%12s[FLOOR:%02d TIME:%03d]\tTask=%18s, Direction=%15s, Target Floor=%02d\n' % ('REQUEST =>', self._params.current_floor, Time(_time), new_task.get_name(), new_task_dir, target_floor)
        if not self._params.current_floor == target_floor:
            self._stat.call(target_floor, _time)
            LOG(tag=self._params.car.get_resource_name(), msg='Elevator:%s, Task:%s, Passengers:%d' % (self._params.direction, new_task_dir, new_n_passengers))

            if self._params.current_passengers + new_n_passengers < self._params.max_passengers or isinstance(task_t, CarCall):
                if (not taskset) or self._params.direction == new_task_dir:
                    self._scheduler.add_task(new_task)
                    self._params.direction = new_task_dir
                    self._updated_taskset_flag = True
                else:
                    self._waiting_q.add(new_task, new_task_dir)

                self._params.current_passengers += new_n_passengers
            elif isinstance(task_t, HallCall):
                # self._waiting_q.add(new_task, new_task_dir)
                LOG(tag=self._params.car.get_resource_name(), msg='New HallCall requests have been ignored due to excessive weight of the elevator.', log=Logs.WARN)

        self._scheduler.set_scheduling_window_start_time(Time(_time))
        self._update_time_attrs(self._scheduler.get_taskset(), Time(_time))

        self._scheduled_flag = False

        return log

    def publish_task(self, params, current_tm):
        task_t = params[0]
        direction = params[1]
        target_floor = params[2]
        n_passengers = params[3]
        passenger_priority = params[4]
        return self.generate_task(task_t, direction, target_floor, n_passengers, passenger_priority, current_tm)

    def monitor(self, _begin, _end):
        log = 'BEGIN:%03d END:%03d]' % (_begin, _end)
        LOG(tag=self._params.car.get_resource_name(), msg='ELEVATOR DIRECTION=%s' % self._params.direction)
        LOG(tag=self._params.car.get_resource_name(), msg='ELEVATOR WEIGHT=%d' % self._params.current_passengers)
        LOG(tag=self._params.car.get_resource_name(), msg='scheduled_flag=%r, updated_taskset_flag=%r' % (self._scheduled_flag, self._updated_taskset_flag))
        taskset = self._scheduler.get_taskset()
        if not self._scheduled_flag:
            if taskset:
                if self._updated_taskset_flag:
                    self._scheduler.set_scheduling_window_start_time(Time(_begin))
                    print '%r' % self._params.direction
                    self._scheduler.add_task_in_bundle(*self._waiting_q.fetch_tasks_wrt_direction(self._params.direction))
                    self._update_time_attrs(self._scheduler.get_taskset(), Time(_begin))
                    self._do_schedule()
            else:
                if not self._waiting_q.empty():
                    ready_list = self._waiting_q.fetch()
                    self._scheduler.add_task_in_bundle(*ready_list)
                    self._update_time_attrs(ready_list, _begin)
                    self._params.direction = ready_list[0].get_type() # update elevator direction based on the tasks in the waiting list.
                    LOG(tag=self._params.car.get_resource_name(), msg='The waiting list tasks has been added to the taskset. Tasks=%s' % ', '.join(task.get_name() for task in ready_list))
                    self._do_schedule()

        if not taskset and self._waiting_q.empty():
            # Goto the most frequently called floor have to be inserted at this point.
            self._waited += 1
            LOG(tag=self._params.car.get_resource_name(), msg='Elevator Waited=%d' % self._waited)
            LOG(tag=self._params.car.get_resource_name(), msg='Elevator Wait Time=%d' % self._params.wait_time)
            if self._waited >= self._params.wait_time:
                task_t = CarCall()
                target_floor = self._stat.get_most_frequent_floor()[0]
                _time = _end

                self.generate_task(task_t, None, target_floor, 0, NORMAL, _time)
                self._waited = Time(0)
                self._do_schedule()

        LOG(tag=self._params.car.get_resource_name(), msg='SCHEDULE=%r' % (self._schedule))
        self._reservation_slot = self._schedule.get_partial_schedule(self._params.car, _begin, _end) if self._schedule else []

        log += '\t%15s --> %s' % (self._params.car.get_resource_name(), '' if self._reservation_slot else 'EMPTY')
        for reservation in self._reservation_slot:
            self._waited = Time(0)
            log += 'Task=%33s, Capacity=%d' % (reservation[0].get_credential(), reservation[3])
            target_floor = self._get_target_floor(reservation[0])

            self._move_elevator(self._params.car, target_floor)

            self._eliminate_task_from_taskset(reservation[0], self._params.current_floor)
            self._update_time_attrs(self._scheduler.get_taskset(), _end)

        log = '%12s[FLOOR:%02d ' % ('SCHEDULE =>', self._params.current_floor) + log + '\n'

        return log

    def __getattr__(self, item):
        return getattr(self._params, item)

# if __name__ == '__main__':
#     elevator_ctrl = ElevatorController()