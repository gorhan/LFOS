import os
import sys
import time
sys.path.insert(0, os.path.abspath('..'))

from GUI.ElevatorGUI import ElevatorUI
from GUI.elevator_params import number_of_floors, Tasks, Direction

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


class ElevatorController:
    def __init__(self, **kwargs):
        self._num_elevator = kwargs['num_elevator'] if 'num_elevator' in kwargs else 1

        self.__initialize_env()
        self.__initialize_GUI()

    def __initialize_GUI(self):
        self._gui = ElevatorUI(self)

    def __initialize_env(self):
        elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')

        for elevator_id in range(self._num_elevator):
            elevator = ResourceFactory.create_instance(elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(8)

            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)

            System.add(elevator)

        System.pretty_print()
        System.print_accessibilites()

        Time.set_time_resolution(0)

        self._scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
        # self._scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF)

    def publish_task(self, params):
        LOG(msg='New Task: {}, Direction: {}, Target: {}\n'.format(*params))


if __name__ == '__main__':
    elevator_ctrl = ElevatorController()