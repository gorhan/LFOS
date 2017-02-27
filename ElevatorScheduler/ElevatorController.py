import os
import sys

sys.path.insert(0, os.path.abspath('..'))

from GUI.ElevatorGUI import ElevatorUI
from ElevatorScheduler.elevator_params import number_of_floors, number_of_passengers_per_car, Tasks, Direction, PassengerPriority
from ElevatorStatistics import ElevatorStatistics
from WaitingQueue import WaitingQueue

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


class ElevatorController:
    def __init__(self, **kwargs):
        self._num_elevator = kwargs['num_elevator'] if 'num_elevator' in kwargs else 1
        self._current_floors = {}
        self._elevator_directions = {}
        self._elevator_weights = {}

        self.__initialize_env()
        self.__initialize_GUI()

    def __initialize_GUI(self):
        self._gui = ElevatorUI(self)

    def __initialize_env(self):
        Time.set_time_resolution(0)

        self._stat = ElevatorStatistics(number_of_floors)
        self._waiting_q = WaitingQueue()
        self._updated_taskset_flag = False
        self._wait_for = Time(5)
        self._waited = Time(0)

        self._elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')

        for elevator_id in range(self._num_elevator):
            elevator = ResourceFactory.create_instance(self._elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            self._current_floors[elevator] = 0
            self._elevator_directions[elevator] = Direction.UP
            self._elevator_weights[elevator] = 0

            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)

            System.add(elevator)

        System.pretty_print()
        System.print_accessibilites()

        self._scheduler = Scheduler(solver='Mistral2', verbose=0, time_cutoff=35)
        self._scheduler.set_scheduling_window_start_time(Time(0))
        self._scheduler.set_scheduling_window_duration(Time(2*number_of_floors))
        self._do_schedule()

    def _identify_task(self, raw_task_name, floor, direction, n_passengers, passenger_priority):
        return '%s_%02d_%d_%s' % (raw_task_name, int(floor), n_passengers, passenger_priority.upper()), direction

    def _get_target_floor(self, _task):
        return int(_task.get_name().split('_')[1])

    def _get_n_passengers(self, _task):
        return int(_task.get_name().split('_')[2])

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
            task.add_resource_requirement(resource_type=self._elevator_t,
                                          eligible_resources=self._update_resource_requirements(task),
                                          capacity=1)

        # the deadlines have to be determined after updating the execution time of the tasks.
        LOG(msg='Worst-Case Execution Time Total: %d' % sum([t.get_max_wcet_time() for t in _tasks]))
        for task in _tasks:
            task.set_deadline(Time(_time + sum([t.get_max_wcet_time() for t in _tasks]) + 3))
            print task.info(True)

        self._scheduled_flag = False
        self._updated_taskset_flag = True

    def _create_task(self, task_t, direction, target_floor, n_passengers, passenger_priority, _time):
        the_resource = System.for_each_sub_terminal_resource()[0]
        if task_t == Tasks.CarCall:
            direction = Direction.UP if target_floor > self._current_floors[the_resource] else Direction.DOWN
        elif task_t == Tasks.HallCall:
            n_passengers = 0 # hallcalls are requested otuside an elevator.

        new_task_name, new_task_type = self._identify_task(task_t, target_floor, direction, n_passengers, passenger_priority)
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

    def _move_elevator(self, resource, target_floor):
        if self._current_floors[resource] < target_floor:
            self._current_floors[resource] += 1
            self._elevator_directions[resource] = Direction.UP
        else:
            self._current_floors[resource] -= 1
            self._elevator_directions[resource] = Direction.DOWN

    def _eliminate_task_from_taskset(self, task, current_floor):
        target_floor = self._get_target_floor(task)
        the_resource = System.for_each_sub_terminal_resource()[0]
        if target_floor == current_floor:
            # Remove the tasks in the taskset and waiting list with the same semantic. CarCall_XX == HallCall_XX
            eliminated_list = []
            for _task in self._scheduler.get_taskset():
                if target_floor == self._get_target_floor(_task):
                    LOG(msg='The task has been removed from the taskset. Task=%s' % task.get_credential())
                    eliminated_list.append(_task)
                    self._elevator_weights[the_resource] -= self._get_n_passengers(_task)
                    # reduce the elevator weight here
            map(lambda _task: self._scheduler.remove_task(_task), eliminated_list)
            eliminated_list = []
            for _task in self._waiting_q.iter():
                if target_floor == self._get_target_floor(_task):
                    LOG(msg='The task has been removed from the waiting list. Task=%s' % task.get_credential())
                    eliminated_list.append(_task)
                    self._elevator_weights[the_resource] -= self._get_n_passengers(_task)
                    # reduce the elevator weight here
            map(lambda _task: self._waiting_q.remove(_task), eliminated_list)
            return True
        return False

    def generate_task(self, task_t, direction, target_floor, n_passengers, passenger_priority, _time):
        target_floor = int(target_floor)

        new_task = self._create_task(task_t, direction, target_floor, n_passengers, passenger_priority, _time)
        taskset = self._scheduler.get_taskset()
        the_resource = System.for_each_sub_terminal_resource()[0]
        new_task_dir = self._get_direction(new_task)
        new_n_passengers = self._get_n_passengers(new_task)

        LOG(msg='ELEVATOR DIRECTION=%s' % self._elevator_directions[the_resource])
        LOG(msg='ELEVATOR WEIGHT=%d' % self._elevator_weights[the_resource])
        log = '%12s[FLOOR:%02d TIME:%03d]\tTask=%18s, Direction=%15s, Target Floor=%02d\n' % ('REQUEST =>', self._current_floors[the_resource], Time(_time), new_task.get_name(), new_task_dir, target_floor)
        if not self._current_floors[the_resource] == target_floor:
            self._stat.call(target_floor, _time)
            LOG(msg='Elevator:%s, Task:%s, Passengers:%d' % (self._elevator_directions[the_resource], new_task_dir, new_n_passengers))

            if self._elevator_weights[the_resource] + new_n_passengers < number_of_passengers_per_car or task_t == Tasks.CarCall:
                if (not taskset) or self._elevator_directions[the_resource] == new_task_dir:
                    self._scheduler.add_task(new_task)
                    self._elevator_directions[the_resource] = new_task_dir
                    self._updated_taskset_flag = True
                else:
                    self._waiting_q.add(new_task, new_task_dir)
                self._elevator_weights[the_resource] += new_n_passengers
            elif task_t == Tasks.HallCall:
                # self._waiting_q.add(new_task, new_task_dir)
                LOG(msg='New HallCall requests have been ignored due to excessive weight of the elevator.', log=Logs.WARN)

        self._scheduler.set_scheduling_window_start_time(Time(_time))
        self._update_time_attrs(self._scheduler.get_taskset(), Time(_time))

        self._scheduled_flag = False

        return log

    def publish_task(self, params, current_tm):
        task_t = params[0]
        direction = params[1]
        target_floor = int(params[2].split(' ')[-1])
        n_passengers = params[3]
        passenger_priority = params[4]
        return self.generate_task(task_t, direction, target_floor, n_passengers, passenger_priority, current_tm)

    def monitor(self, _begin, _end):
        log = 'BEGIN:%03d END:%03d]' % (_begin, _end)
        the_resource = System.for_each_sub_terminal_resource()[0]
        LOG(msg='ELEVATOR DIRECTION=%s' % self._elevator_directions[the_resource])
        LOG(msg='ELEVATOR WEIGHT=%d' % self._elevator_weights[the_resource])
        LOG(msg='scheduled_flag=%r, updated_taskset_flag=%r' % (self._scheduled_flag, self._updated_taskset_flag))
        taskset = self._scheduler.get_taskset()
        if not self._scheduled_flag:
            if taskset:
                if self._updated_taskset_flag:
                    self._scheduler.set_scheduling_window_start_time(Time(_begin))
                    self._scheduler.add_task_in_bundle(*self._waiting_q.fetch_tasks_wrt_direction(self._elevator_directions[the_resource]))
                    self._update_time_attrs(self._scheduler.get_taskset(), Time(_begin))
                    self._do_schedule()
            else:
                if not self._waiting_q.empty():
                    ready_list = self._waiting_q.fetch()
                    self._scheduler.add_task_in_bundle(*ready_list)
                    self._update_time_attrs(ready_list, _begin)
                    self._elevator_directions[the_resource] = ready_list[0].get_type() # update elevator direction based on the tasks in the waiting list.
                    LOG(msg='The waiting list tasks has been added to the taskset. Tasks=%s' % ', '.join(task.get_name() for task in ready_list))
                    self._do_schedule()

        if not taskset and self._waiting_q.empty():
            # Goto the most frequently called floor have to be inserted at this point.
            self._waited += 1
            print '#############', self._waited
            print '#############', self._wait_for
            if self._waited >= self._wait_for:
                task_t = Tasks.CarCall
                target_floor = self._stat.get_most_frequent_floor()[0]
                _time = _end

                print '#############', target_floor
                self.generate_task(task_t, None, target_floor, 0, PassengerPriority.NORMAL, _time)
                self._waited = Time(0)
                self._do_schedule()

        for resource in System.for_each_sub_terminal_resource():
            self._reservation_slot = self._schedule.get_partial_schedule(resource, _begin, _end) if self._schedule else []

            log += '\t%15s --> %s' % (resource.get_resource_name(), '' if self._reservation_slot else 'EMPTY')
            multiple_reservation_flag = True
            for reservation in self._reservation_slot:
                self._waited = Time(0)
                log += 'Task=%33s, Capacity=%d' % (reservation[0].get_credential(), reservation[3])
                target_floor = self._get_target_floor(reservation[0])

                if multiple_reservation_flag:
                    self._move_elevator(resource, target_floor)
                    multiple_reservation_flag = False

                self._eliminate_task_from_taskset(reservation[0], self._current_floors[resource])
                self._update_time_attrs(self._scheduler.get_taskset(), _end)

            log = '%12s[FLOOR:%02d ' % ('SCHEDULE =>', self._current_floors[resource]) + log + '\n'

        return log

if __name__ == '__main__':
    elevator_ctrl = ElevatorController()