import os
import sys
sys.path.insert(0, os.path.abspath('..'))

import Tkinter as tk

from ElevatorParameters import *
from LFOS.Resource.Resource import ResourceFactory, Type, ResourceTypeList, System
from LFOS.Resource.Power import PowerFactory, PowerTypeList


class MetaController:
    def __init__(self, num_cars):
        self.num_cars = num_cars
        self.params = {}

        elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')
        for elevator_id in range(self.num_cars):
            elevator = ResourceFactory.create_instance(elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)
            System.add(elevator) # Not Necessary
            self.params[elevator] = ElevatorParameters(elevator)

        System.pretty_print()


class MetaControllerGUI(MetaController):
    def __init__(self, num_cars):
        MetaController.__init__(self, num_cars)

        self.frame = tk.Tk()
        self.master = self.frame.master
        self.__create_widgets()

    def __create_widgets(self):
