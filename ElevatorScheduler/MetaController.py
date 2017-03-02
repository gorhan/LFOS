import os
import sys
sys.path.insert(0, os.path.abspath('..'))

import Tkinter as tk

from ElevatorParameters import *
from LFOS.Resource.Resource import ResourceFactory, Type, ResourceTypeList, System
from LFOS.Resource.Power import PowerFactory, PowerTypeList


class MetaController:
    def __init__(self, num_cars, num_floors):
        self.num_cars = num_cars
        self.num_floors = num_floors
        self.params = {}

        elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')
        for elevator_id in range(self.num_cars):
            elevator = ResourceFactory.create_instance(elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)
            System.add(elevator) # Not Necessary
            self.params[elevator_id] = ElevatorParameters(elevator, num_floors=self.num_floors)

        System.pretty_print()


class MetaControllerGUI(MetaController):
    def __init__(self, num_cars, num_floors):
        MetaController.__init__(self, num_cars, num_floors)

        self._elevator_spec_widgets = {}
        self.master = tk.Tk()
        self.frame =  tk.Frame(self.master, padx=10, pady=10)
        self.master.title('META CONTROLLER INTERFACE')
        self.frame.grid()
        self.__create_widgets()
        self.frame.mainloop()

    def __create_widgets(self):
        self._label_frame_request = tk.LabelFrame(self.frame, text='Elevator Request Controller', padx=10, pady=10, labelanchor='n')
        self.__create_task_spec_widgets(self._label_frame_request)
        self._label_frame_request.grid(row=0, column=0, rowspan=self.num_cars, padx=10, pady=10)

        self._label_frame_elevator_status = tk.LabelFrame(self.frame, text='Elevator Status Information', padx=10, pady=10, labelanchor='n')
        for elevator_id in range(self.num_cars):
            self.__create_elevator_widgets(self.params[elevator_id], self._label_frame_elevator_status, elevator_id, 0)
        self._button_update_params = tk.Button(self._label_frame_elevator_status, text='Update', command=self.__update_parameters)
        self._button_reset_params = tk.Button(self._label_frame_elevator_status, text='Reset', command=self.__reset_parameters)
        self._button_update_params.grid(row=self.num_cars, column=0, sticky=tk.N + tk.W + tk.E + tk.S)
        self._button_reset_params.grid(row=self.num_cars, column=1, sticky=tk.N + tk.W + tk.E + tk.S)
        self._label_frame_elevator_status.grid(row=0, column=1, padx=10, pady=10)

    def __create_task_spec_widgets(self, frame):
        self._label_frame_task = tk.LabelFrame(frame, text='Task', padx=5, pady=5, labelanchor='n')
        self._label_frame_task.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._request = tk.StringVar()
        self._request.set(HallCall())
        self._radio_bt_tasks = [None, None]
        self._radio_bt_tasks[0] = tk.Radiobutton(self._label_frame_task, text='Hall Call', variable=self._request, value=HallCall(), command=self._activate_widgets)
        self._radio_bt_tasks[0].pack(anchor=tk.CENTER)
        self._radio_bt_tasks[1] = tk.Radiobutton(self._label_frame_task, text='Car Call', variable=self._request, value=CarCall(), command=self._deactivate_widgets)
        self._radio_bt_tasks[1].pack(anchor=tk.CENTER)

        self._label_frame_dir = tk.LabelFrame(frame, text='Direction', padx=5, pady=5, labelanchor='n')
        self._label_frame_dir.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._direction = tk.StringVar()
        self._direction.set(UP())
        self._radio_bt_directions = [None] * 2
        self._radio_bt_directions[0] = tk.Radiobutton(self._label_frame_dir, text='Up', variable=self._direction, value=UP())
        self._radio_bt_directions[0].pack(anchor=tk.CENTER)
        self._radio_bt_directions[1] = tk.Radiobutton(self._label_frame_dir, text='Down', variable=self._direction, value=DOWN())
        self._radio_bt_directions[1].pack(anchor=tk.CENTER)

        self._label_frame_floor = tk.LabelFrame(frame, text='Floor', padx=5, pady=5, labelanchor='n')
        self._label_frame_floor.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        floors = ['Floor %02d' % floor for floor in range(self.num_floors)]
        self._floor = tk.StringVar()
        self._floor.set(floors[0])
        self._option_floor = tk.OptionMenu(self._label_frame_floor, self._floor, *floors)
        self._option_floor.pack()

        self._label_frame_passengers = tk.LabelFrame(frame, text='Number of Passengers', padx=5, pady=5, labelanchor='n')
        self._label_frame_passengers.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        passengers = [passenger + 1 for passenger in range(10)]
        self._passengers = tk.IntVar()
        self._passengers.set(passengers[0])
        self._option_passengers = tk.OptionMenu(self._label_frame_passengers, self._passengers, *passengers)
        self._option_passengers.pack()
        self._option_passengers.config(state=tk.DISABLED)

        self._label_frame_priority = tk.LabelFrame(frame, text='Priority', padx=5, pady=5, labelanchor='n')
        self._priority = tk.StringVar()
        self._priority.set(NORMAL())
        self._radio_bt_priority = [None] * 3
        self._radio_bt_priority[0] = tk.Radiobutton(self._label_frame_priority, text='Normal', variable=self._priority, value=NORMAL())
        self._radio_bt_priority[1] = tk.Radiobutton(self._label_frame_priority, text='High', variable=self._priority, value=HIGH())
        self._radio_bt_priority[2] = tk.Radiobutton(self._label_frame_priority, text='Urgent', variable=self._priority, value=URGENT())
        self._radio_bt_priority[0].pack(anchor=tk.CENTER)
        self._radio_bt_priority[1].pack(anchor=tk.CENTER)
        self._radio_bt_priority[2].pack(anchor=tk.CENTER)
        self._label_frame_priority.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)

        self._button_add = tk.Button(frame, text='Add', command=self._dispatch)
        self._button_add.pack(fill=tk.X)

    def __create_elevator_widgets(self, params, frame, row, col):
        label_frame_elevator_status = tk.LabelFrame(frame, text=params.car.get_resource_name(), padx=10, pady=10, labelanchor='n')
        # label_frame_elevator_status.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        label_frame_elevator_status.grid(row=row, column=col, columnspan=2, padx=10, pady=10, sticky=tk.N + tk.W + tk.S + tk.E)
        assert isinstance(params, ElevatorParameters)
        for row_id, param_name in enumerate(parameters_table.keys()):
            value = getattr(params, param_name)
            print param_name, value
            # raw_input('Enter:::')
            label_param_name = tk.Label(label_frame_elevator_status, text=param_name, padx=5, pady=5)
            label_param_name.grid(row=row_id, column=0, sticky=tk.N + tk.E + tk.S+ tk.E)
            self._elevator_spec_widgets[param_name] = tk.Entry(label_frame_elevator_status)
            self._elevator_spec_widgets[param_name].delete(0, tk.END)
            self._elevator_spec_widgets[param_name].insert(0, str(value))
            self._elevator_spec_widgets[param_name].grid(row=row_id, column=1, sticky=tk.N + tk.W + tk.S+ tk.E)

    def _deactivate_widgets(self):
        self._radio_bt_directions[0].config(state=tk.DISABLED)
        self._radio_bt_directions[1].config(state=tk.DISABLED)
        self._option_passengers.config(state=tk.NORMAL)

    def _activate_widgets(self):
        self._radio_bt_directions[0].config(state=tk.NORMAL)
        self._radio_bt_directions[1].config(state=tk.NORMAL)
        self._option_passengers.config(state=tk.DISABLED)

    def __reset_parameters(self):
        print 'TODO'

    def __update_parameters(self):
        print 'TODO'

    def _dispatch(self):
        print ''

if __name__ == '__main__':
    MetaControllerGUI(2, 20)