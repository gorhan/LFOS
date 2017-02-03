import os
import sys
import time
sys.path.insert(0, os.path.abspath('..'))

from GUI.ElevatorGUI import ElevatorUI
from GUI.elevator_params import number_of_floors, Tasks, Direction

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
        self._elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')

        for elevator_id in range(self._num_elevator):
            elevator = ResourceFactory.create_instance(self._elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(8)
            self._current_floors[elevator] = 0
            self._elevator_directions[elevator] = Direction.UP

            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)

            System.add(elevator)

        System.pretty_print()
        System.print_accessibilites()

        Time.set_time_resolution(0)

        self._scheduler = Scheduler(solver='Mistral2', verbose=4, time_cutoff=10000)
        self._scheduler.set_scheduling_window_start_time(Time(0))
        self._scheduler.set_scheduling_window_duration(Time(2*number_of_floors))
        self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF)
        self._schedules = self._scheduler.schedule_tasks()
        self._schedule = self._schedules[0] if self._schedules else []

    def publish_task(self, params, current_tm):
        task_t = params[0]
        direction = params[1]
        target_floor = int(params[2].split(' ')[-1])
        LOG(msg='task_t=%s, direction=%s, Target=%d' % (task_t, direction, target_floor))
        self.generate_task(task_t, direction, target_floor, current_tm)

    def generate_task(self, task_t, direction, floor, tm):
        LOG(msg='Time=%d' % (tm))

        for resource in System.for_each_sub_terminal_resource():
            executed = Time(tm) - self._scheduler.get_scheduling_window_start_time()
            prev_schedule = self._schedule.get_partial_schedule(resource, self._scheduler.get_scheduling_window_start_time(), Time(tm)) if self._schedule else []
            for reservation in prev_schedule:
                if Time(tm) <= reservation[2]:
                    obsolete_job = self._scheduler.remove_task(reservation[0])
                    obsolete_job.set_release_time(Time(tm))
                    obsolete_job.add_resource_requirement(resource_type=self._elevator_t, eligible_resources={resource:Time(abs(obsolete_job.get_max_wcet_time()-executed)) for resource in System.for_each_sub_terminal_resource()}, capacity=1)
                    print obsolete_job.info(True)

                    self._scheduler.add_token(obsolete_job.get_type(), Time(tm), 1)
                    self._scheduler.add_task(obsolete_job)

        self._scheduler.set_scheduling_window_start_time(Time(tm))

        task_name = '%s_%02d' % (task_t.split('.')[-1], floor)
        if task_t == Tasks.CarCall:
            task_type_name = Direction.UP if self._current_floors < floor else Direction.DOWN
        else:
            task_type_name = direction
        task = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type=task_type_name, phase=Time(tm), deadline=Time(tm+2*number_of_floors), periodicity=PeriodicityTypeList.APERIODIC, token_name=[task_type_name])
        task.add_resource_requirement(resource_type=self._elevator_t, eligible_resources={resource:Time(abs(floor-self._current_floors[resource])) for resource in System.for_each_sub_terminal_resource()}, capacity=1)
        task.add_dependency(task_type_name, 1)
        print task.info(True)
        self._scheduler.add_task(task)
        self._scheduler.add_token(task_type_name, Time(tm), 1)
        self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF)
        self._schedules = self._scheduler.schedule_tasks()
        self._schedule = self._schedules[0] if self._schedules else []

    def get_schedule(self, begin, end):
        log = '[%02d %02d]\n' % (begin, end)
        for resource in System.for_each_sub_terminal_resource():
            self._partial_schedule = self._schedule.get_partial_schedule(resource, begin, end) if self._schedule else []
            print self._partial_schedule

            log += '\t{%s} == %s' % (resource.get_credential(), '' if self._partial_schedule else 'EMPTY')
            multiple_reservation_flag = True
            for reservation in self._partial_schedule:
                log += '%s-%d, ' % (reservation[0].get_credential(), reservation[3])
                task_name, target_floor = reservation[0].get_name().split('_')

                if multiple_reservation_flag:
                    if self._current_floors[resource] < int(target_floor):
                        self._elevator_directions[resource] = Direction.UP
                        self._current_floors[resource] += 1
                    else:
                        self._elevator_directions[resource] = Direction.DOWN
                        self._current_floors[resource] -= 1
                    multiple_reservation_flag = False

                if int(target_floor) == self._current_floors[resource]:
                    self._scheduler.remove_task(reservation[0])

            log += ' Floor=%d\n' % self._current_floors[resource]
        return log

if __name__ == '__main__':
    elevator_ctrl = ElevatorController()