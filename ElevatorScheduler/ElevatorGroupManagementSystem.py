import os
import sys
sys.path.insert(0, os.path.abspath('..'))

import Tkinter as tk
from PIL import Image, ImageTk
import tkFileDialog
from functools import reduce

from ElevatorParameters import *
from ElevatorController import ElevatorController
from LFOS.Resource.Resource import ResourceFactory, Type, ResourceTypeList, System
from LFOS.Resource.Power import PowerFactory, PowerTypeList


class ElevatorGroupManagementSystem:
    def __init__(self, num_cars, num_floors):
        self.num_cars = num_cars
        self.num_floors = num_floors
        self.params = {}
        self.controllers = {}
        self.clock = 0

        if Time.get_time_resolution() != 0:
            Time.set_time_resolution(0)

        elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')
        for elevator_id in range(self.num_cars):
            elevator = ResourceFactory.create_instance(elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)
            System.add(elevator) # Not Necessary
            self.params[elevator_id] = ElevatorParameters(elevator, num_floors=self.num_floors, verbose=10)
            self.controllers[elevator_id] = ElevatorController(self.params[elevator_id])

        System.pretty_print()

    def _dispatch(self, bundle, high_level_strategy):
        import numpy, random

        ch_elevator_id = None

        if bundle[0] == HallCall():
            relevant_elevators = numpy.array([elevator_id for elevator_id in range(self.num_cars) if
                                              bundle[2] in self.params[elevator_id].get_available_floors()])
            # if sector strategy is chosen and there exists more than one car which are eligible to move to the specified floor, one of them is supposed to be determined to
            # respond the current request. If there exists only one, the request immediately sent to the corresponding elevator controller.
            if high_level_strategy == Sectors():
                if len(relevant_elevators) == 1:
                    ch_elevator_id = relevant_elevators[0]
                    return ch_elevator_id, self.controllers[ch_elevator_id].publish_task(bundle, self.clock)

            elevators_not_running = numpy.array([elevator_id for elevator_id in relevant_elevators if
                                                 not self.controllers[elevator_id].is_running()])
            elevators_w_same_direction = numpy.array([elevator_id for elevator_id in relevant_elevators if
                                                      self.controllers[elevator_id].direction == bundle[1]])
            LOG(msg='ELEVATORS WITH SAME DIRECTION=%r' % elevators_w_same_direction)
            if elevators_w_same_direction.size == 0:
                elevators_w_same_direction = numpy.array([elevator_id for elevator_id in range(self.num_cars) if bundle[2] in self.params[elevator_id].get_available_floors()])

            distances = numpy.array([abs(bundle[2] - self.controllers[elevator_id].current_floor) for elevator_id in
                                     elevators_w_same_direction])
            if elevators_not_running.size != 0:
                distances_not_running = numpy.array([abs(bundle[2] - self.controllers[elevator_id].current_floor) for elevator_id in elevators_not_running])
                LOG(msg='DISTANCES not running=%r' % distances_not_running)
            LOG(msg='DISTANCES=%r' % distances)
            nearest_elevators = elevators_w_same_direction[numpy.where(distances == distances.min())[0]]

            nearest_elevators_not_running = numpy.array([])
            if elevators_not_running.size != 0:
                nearest_elevators_not_running = elevators_not_running[
                    numpy.where(distances_not_running == distances_not_running.min())[0]]
                LOG(msg='NEAREST ELEVATORS not running=%r' % nearest_elevators_not_running)
            LOG(msg='NEAREST ELEVATORS=%r' % nearest_elevators)
            ch_elevator_id = nearest_elevators[random.randint(0, len(nearest_elevators) - 1)]
            if high_level_strategy == NEwCC():
                n_passengers = numpy.array(
                    [self.controllers[elevator_id].current_passengers for elevator_id in nearest_elevators])
                LOG(msg='NUMBER OF PASSENGERS=%r' % n_passengers)
                nearest_elevators = nearest_elevators[numpy.where(n_passengers == n_passengers.min())[0]]
                LOG(msg='NEAREST ELEVATORS=%r' % nearest_elevators)
                ch_elevator_id = nearest_elevators[random.randint(0, len(nearest_elevators) - 1)]
            LOG(msg='ELEVATOR CHOICE=%r' % self.controllers[ch_elevator_id].car.get_resource_name())
            if self.controllers[ch_elevator_id].is_running() and nearest_elevators_not_running.size != 0:
                ch_elevator_id = nearest_elevators_not_running[random.randint(0, len(nearest_elevators_not_running) - 1)]
                LOG(msg='ELEVATOR CHOICE not running=%r' % self.controllers[ch_elevator_id].car.get_resource_name())
        elif bundle[0] == CarCall():
            ch_elevator_id = bundle[5]

        # self.__set_text(ch_elevator_id, self.controllers[ch_elevator_id].publish_task(bundle, self.clock),
        #                 'request')
        return ch_elevator_id, self.controllers[ch_elevator_id].publish_task(bundle, self.clock)

    def _continue(self):
        msgs = {elevator_id:self.controllers[elevator_id].monitor(self.clock, self.clock+Time(1)) for elevator_id in range(self.num_cars)}
        self.clock += Time(1)
        return msgs


class ElevatorGroupManagementSystemGUI(ElevatorGroupManagementSystem):
    def __init__(self, num_cars, num_floors):
        ElevatorGroupManagementSystem.__init__(self, num_cars, num_floors)

        self._elevator_spec_widgets = {}
        self.master = tk.Tk()
        self.frame =  tk.Frame(self.master, padx=10, pady=10)
        self.master.title('Elevator Group Management System')
        self.frame.grid()
        self.__create_widgets()
        self.frame.mainloop()

    def __create_widgets(self):
        self._label_frame_first_col = tk.LabelFrame(self.frame, relief=tk.FLAT)
        self._label_frame_logos = tk.LabelFrame(self._label_frame_first_col, relief=tk.FLAT)
        self._fmt_logo = Image.open('GUI/images/fmt_logo.jpg')
        self._fmt_logo = self._fmt_logo.resize((200, 200), Image.ANTIALIAS)
        self._fmt_logo = ImageTk.PhotoImage(self._fmt_logo)
        self._fmt_logo_label = tk.Label(self._label_frame_logos, image=self._fmt_logo, height=200, width=200)
        self._fmt_logo_label.grid(row=0, column=0, sticky=tk.N + tk.S)

        self._ut_logo = Image.open('GUI/images/ut_logo.jpg')
        self._ut_logo = self._ut_logo.resize((200, 100), Image.ANTIALIAS)
        self._ut_logo = ImageTk.PhotoImage(self._ut_logo)
        self._ut_logo_label = tk.Label(self._label_frame_logos, image=self._ut_logo, height=100, width=200)
        self._ut_logo_label.grid(row=0, column=1, sticky=tk.N + tk.S)
        self._label_frame_logos.pack(fill=tk.X)

        self._label_frame_high_level_dispatch_strategy = tk.LabelFrame(self._label_frame_first_col,
                                                                       text='Passenger-2-Car Assignment Strategy',
                                                                       pady=10, labelanchor='n')
        self._high_level_strategy = tk.Variable()
        self._high_level_strategy.set(Sectors())
        self._radio_bt_high_level_strategy = [None] * 3
        self._radio_bt_high_level_strategy[0] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(Sectors()), variable=self._high_level_strategy,
                                                               value=Sectors(), command=lambda :self._create_sector_frame(2))
        self._radio_bt_high_level_strategy[0].pack(anchor=tk.CENTER)
        self._radio_bt_high_level_strategy[1] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(NEwCC()),
                                                               variable=self._high_level_strategy,
                                                               value=NEwCC(), command=self._reset_disabled_floors)
        self._radio_bt_high_level_strategy[1].pack(anchor=tk.CENTER)
        self._radio_bt_high_level_strategy[2] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(NEwoutCC()),
                                                               variable=self._high_level_strategy,
                                                               value=NEwoutCC(), command=self._reset_disabled_floors)
        self._radio_bt_high_level_strategy[2].pack(anchor=tk.CENTER)
        self._label_frame_high_level_dispatch_strategy.pack(fill=tk.X)

        self._label_frame_request = tk.LabelFrame(self._label_frame_first_col, text='Elevator Request Controller', pady=10, labelanchor='n')
        self.__create_task_spec_widgets(self._label_frame_request)
        self._label_frame_request.pack(fill=tk.X)
        self._label_frame_first_col.grid(row=0, column=0, sticky=tk.N+tk.E+tk.W)

        self._label_frame_second_col = tk.LabelFrame(self.frame, relief=tk.FLAT)
        self._label_frame_elevator_status = tk.LabelFrame(self._label_frame_second_col, text='Elevator Status Information', padx=10, pady=10, labelanchor='n')
        for elevator_id in range(self.num_cars):
            self.__create_elevator_widgets(elevator_id, self.params[elevator_id], self._label_frame_elevator_status, elevator_id, 0)
        self._label_frame_elevator_status.grid(row=0, column=0, padx=10, pady=10, sticky=tk.N)
        self._label_frame_second_col.grid(row=0, column=1, sticky=tk.N+tk.E+tk.W)

    def __create_task_spec_widgets(self, frame):
        self._label_frame_task = tk.LabelFrame(frame, text='Task', padx=5, labelanchor='n')
        self._label_frame_task.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)
        self._request = tk.Variable()
        self._request.set(HallCall())
        self._radio_bt_tasks = [None, None]
        self._radio_bt_tasks[0] = tk.Radiobutton(self._label_frame_task, text='Hall Call', variable=self._request, value=HallCall(), command=self._activate_widgets)
        self._radio_bt_tasks[0].pack(anchor=tk.CENTER)
        self._radio_bt_tasks[1] = tk.Radiobutton(self._label_frame_task, text='Car Call', variable=self._request, value=CarCall(), command=self._deactivate_widgets)
        self._radio_bt_tasks[1].pack(anchor=tk.CENTER)

        self._label_frame_floor = tk.LabelFrame(frame, text='Floor', padx=5, pady=5, labelanchor='n')
        self._label_frame_floor.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)
        floors = ['Floor %02d' % floor for floor in range(self.num_floors)]
        self._floor = tk.StringVar()
        self._floor.set(floors[0])
        self._option_floor = tk.OptionMenu(self._label_frame_floor, self._floor, *floors)
        self._option_floor.pack()

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
        self._label_frame_priority.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)

        self._label_frame_attrs = tk.LabelFrame(frame, pady=10, relief=tk.FLAT)
        self._label_frame_hall_call = tk.LabelFrame(self._label_frame_attrs, text='HallCall Attributes', padx=5, labelanchor='n', width=100)
        self._label_frame_dir = tk.LabelFrame(self._label_frame_hall_call, text='Direction', padx=5, pady=5, labelanchor='n')
        self._label_frame_dir.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)
        self._direction = tk.Variable()
        self._direction.set(UP())
        self._radio_bt_directions = [None] * 2
        self._radio_bt_directions[0] = tk.Radiobutton(self._label_frame_dir, text='Up', variable=self._direction, value=UP())
        self._radio_bt_directions[0].pack(anchor=tk.CENTER)
        self._radio_bt_directions[1] = tk.Radiobutton(self._label_frame_dir, text='Down', variable=self._direction, value=DOWN())
        self._radio_bt_directions[1].pack(anchor=tk.CENTER)
        self._label_frame_attrs.grid_columnconfigure(0, weight=1)
        self._label_frame_hall_call.grid(row=0, column=0, sticky=tk.N + tk.W + tk.E)

        self._label_frame_car_call = tk.LabelFrame(self._label_frame_attrs, text='CarCall Attributes', padx=5, labelanchor='n', width=100)
        self._label_frame_passengers = tk.LabelFrame(self._label_frame_car_call, text='Number of Passengers', padx=5, pady=5, labelanchor='n')
        self._label_frame_passengers.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)
        passengers = [passenger for passenger in range(11)]
        self._passengers = tk.IntVar()
        self._passengers.set(passengers[0])
        self._option_passengers = tk.OptionMenu(self._label_frame_passengers, self._passengers, *passengers)
        self._option_passengers.pack()
        self._option_passengers.config(state=tk.DISABLED)

        self._label_frame_elevator = tk.LabelFrame(self._label_frame_car_call, text='From Elevator', padx=5, pady=5, labelanchor='n')
        elevators = ['Elevator_%02d' % elevator_id for elevator_id in range(self.num_cars)]
        self._requested_elevator = tk.StringVar()
        self._requested_elevator.set(elevators[0])
        self._option_elevator = tk.OptionMenu(self._label_frame_elevator, self._requested_elevator, *elevators)
        self._option_elevator.config(state=tk.DISABLED)
        self._option_elevator.pack(anchor=tk.CENTER)
        self._label_frame_elevator.pack(padx=10, pady=5, ipadx=10, anchor=tk.CENTER, fill=tk.X)

        self._label_frame_attrs.grid_columnconfigure(1, weight=1)
        self._label_frame_car_call.grid(row=0, column=1, sticky=tk.N + tk.W + tk.E)
        self._label_frame_attrs.pack(anchor=tk.CENTER, fill=tk.BOTH, ipadx=10)

        self._label_frame_action = tk.LabelFrame(frame, pady=10, relief=tk.FLAT)
        self._button_add = tk.Button(self._label_frame_action, text='Add', command=self._dispatch_self)
        self._button_continue = tk.Button(self._label_frame_action, text='Continue', command=self._continue_self)
        self._button_save = tk.Button(self._label_frame_action, text='Save', command=self._save_file)
        self._button_add.pack(fill=tk.X)
        self._button_continue.pack(fill=tk.X)
        self._button_save.pack(fill=tk.X)
        self._label_frame_action.pack(anchor=tk.CENTER, fill=tk.X)

    def __create_elevator_widgets(self, elevator_id, params, frame, row, col):
        label_frame_elevator_status = tk.LabelFrame(frame, text=params.car.get_resource_name(), padx=10, pady=10, labelanchor='n')

        assert isinstance(params, ElevatorParameters)
        for row_id, param_name in enumerate(parameters_table.keys()):
            value = getattr(params, param_name)

            label_param_name = tk.Label(label_frame_elevator_status, text=param_name.upper(), padx=5, pady=5)
            label_param_name.grid(row=row_id, column=0, sticky=tk.N + tk.E + tk.S)
            self._elevator_spec_widgets[elevator_id, param_name] = tk.Entry(label_frame_elevator_status, disabledbackground='#303030', disabledforeground='#eeeeee')
            self.__set_entry(elevator_id, param_name, value)
            self._elevator_spec_widgets[elevator_id, param_name].grid(row=row_id, column=1, sticky=tk.N + tk.W + tk.S+ tk.E)

        self._scroll_bar = tk.Scrollbar(label_frame_elevator_status)
        self._scroll_bar.grid(row=0, column=2, rowspan=len(parameters_table), sticky=tk.N + tk.W + tk.E + tk.S)
        self._elevator_spec_widgets[elevator_id, 'LOG'] = tk.Text(label_frame_elevator_status, padx=5, state=tk.DISABLED, wrap=tk.NONE, width=130, height=30,
                                 yscrollcommand=self._scroll_bar.set,
                                 font=('Courier', 11),
                                 bg='#1e263f')
        self._elevator_spec_widgets[elevator_id, 'LOG'].grid(row=0, column=2, rowspan=len(parameters_table), sticky=tk.N + tk.W + tk.E)
        self._scroll_bar.config(command=self._elevator_spec_widgets[elevator_id, 'LOG'].yview)

        self._elevator_spec_widgets[elevator_id, 'LOG'].tag_configure('request', foreground='#13f128')
        self._elevator_spec_widgets[elevator_id, 'LOG'].tag_configure('continue', foreground='#d5f90b')
        label_frame_elevator_status.grid(row=row, column=col, columnspan=3, padx=10, pady=10, sticky=tk.N + tk.W + tk.E)

    def _create_sector_frame(self, column_size=4):
        master = tk.Toplevel()
        frame = tk.Frame(master)
        master.title('Sectors')
        frame.grid()

        self._listbox_sectors = []
        num_floors_height = self.num_floors
        num_floors_height = num_floors_height if num_floors_height < 10 else 10
        for elevator_id in range(self.num_cars):
            floors = tuple(map(str, range(self.params[elevator_id].num_floors)))
            floors = tk.StringVar(value=floors)

            tk.Label(frame, text='Elevator_%02d' % elevator_id).grid(row=int(elevator_id/column_size)*num_floors_height, column=elevator_id%column_size, sticky=tk.W + tk.E)

            self._listbox_sectors.append(tk.Listbox(frame, listvariable=floors, selectmode=tk.EXTENDED, height=num_floors_height, exportselection=0))
            map(lambda floor: self._listbox_sectors[-1].selection_set(floor), self.params[elevator_id].get_available_floors())
            self._listbox_sectors[-1].grid(row=int(elevator_id/column_size)*num_floors_height+1, column=elevator_id%column_size, sticky=tk.W + tk.E)

        tk.Button(frame, text='SET', command=lambda :self.__listbox_cb(master)).grid(row=int(self.num_cars/column_size)*num_floors_height+2, column=0, columnspan=column_size, sticky=tk.W+tk.E)

    def __listbox_cb(self, master):
        for elevator_id in range(self.num_cars):
            selections = set(map(int, self._listbox_sectors[elevator_id].curselection()))
            all_floors = set(range(self.params[elevator_id].num_floors))
            disabled_floors = list(all_floors.difference(selections))
            # print selections, all_floors, disabled_floors
            self.params[elevator_id].disabled_floors = disabled_floors

        self.__update_widget_parameters()
        master.destroy()

    def __update_widget_parameters(self):
        for elevator_id in range(self.num_cars):
            for param_name in parameters_table.keys():
                self.__set_entry(elevator_id, param_name, getattr(self.params[elevator_id], param_name))

    def _reset_disabled_floors(self):
        for elevator_id in range(self.num_cars):
            self.params[elevator_id].disabled_floors = []

        self.__update_widget_parameters()

    def _deactivate_widgets(self):
        LOG(msg='==CarCall:%r, ==HallCall:%r' % (self._request.get() == CarCall(), self._request.get() == HallCall()))
        self._radio_bt_directions[0].config(state=tk.DISABLED)
        self._radio_bt_directions[1].config(state=tk.DISABLED)
        self._option_passengers.config(state=tk.NORMAL)
        self._option_elevator.config(state=tk.NORMAL)

    def _activate_widgets(self):
        LOG(msg='==CarCall:%r, ==HallCall:%r' % (self._request.get() == CarCall(), self._request.get() == HallCall()))
        self._radio_bt_directions[0].config(state=tk.NORMAL)
        self._radio_bt_directions[1].config(state=tk.NORMAL)
        self._option_passengers.config(state=tk.DISABLED)
        self._option_elevator.config(state=tk.DISABLED)

    def __set_text(self, elevator_id, text, tag, pos=tk.END):
        self._elevator_spec_widgets[elevator_id, 'LOG'].config(state=tk.NORMAL)
        self._elevator_spec_widgets[elevator_id, 'LOG'].insert(pos, text, tag)
        self._elevator_spec_widgets[elevator_id, 'LOG'].see(tk.END) # to auto-scroll down the scrollbar
        self._elevator_spec_widgets[elevator_id, 'LOG'].config(state=tk.DISABLED)

    def __set_entry(self, elevator_id, param_name, text, pos=tk.END):
        self._elevator_spec_widgets[elevator_id, param_name].config(state=tk.NORMAL)
        self._elevator_spec_widgets[elevator_id, param_name].delete(0, pos)
        self._elevator_spec_widgets[elevator_id, param_name].insert(0, str(text))
        self._elevator_spec_widgets[elevator_id, param_name].config(state=tk.DISABLED)

    def _dispatch_self(self):
        bundle = [
            self._request.get(),  # --> index=0
            UP() if self._direction.get() == UP() else DOWN(),  # --> index=1
            int(self._floor.get().split(' ')[-1]),  # --> index=2
            int(self._passengers.get()),  # --> index=3
            self._priority.get(),  # --> index=4
            int(self._requested_elevator.get().split('_')[-1])  # --> index=5
        ]
        elevator_id, msg = self._dispatch(bundle, self._high_level_strategy.get())
        self.__set_text(elevator_id, msg, 'request')

    def _continue_self(self):
        text_msgs = self._continue()
        for elevator_id, msg in text_msgs.items():
            self.__set_text(elevator_id, msg, 'continue')
        self.__update_widget_parameters()

    def _save_file(self):
        save_filename = tkFileDialog.asksaveasfilename()
        if save_filename is None:
            return False

        for elevator_id in range(self.num_cars):
            save_file = open('%s_Elevator_%02d.txt' % (save_filename, elevator_id), 'w')
            if save_file is None:
                LOG(msg='Unexpected event has occured while opening log file.', log=Logs.ERROR)
                return False

            save_file.write(str(self._elevator_spec_widgets[elevator_id, 'LOG'].get('1.0', tk.END)))
            save_file.close()
        LOG(msg='Log files have been successfully generated.')
        return True

if __name__ == '__main__':
    n_elevator, n_floor = 2, 16
    if len(sys.argv) == 3:
        n_elevator = int(sys.argv[1])
        n_floor = int(sys.argv[2])

    ElevatorGroupManagementSystemGUI(n_elevator, n_floor)