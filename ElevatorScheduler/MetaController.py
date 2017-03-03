import os
import sys
sys.path.insert(0, os.path.abspath('..'))

import Tkinter as tk
from PIL import Image, ImageTk

from ElevatorParameters import *
from ElevatorController import ElevatorController
from LFOS.Resource.Resource import ResourceFactory, Type, ResourceTypeList, System
from LFOS.Resource.Power import PowerFactory, PowerTypeList


class MetaController:
    def __init__(self, num_cars, num_floors):
        self.num_cars = num_cars
        self.num_floors = num_floors
        self.params = {}
        self.controllers = {}

        if Time.get_time_resolution() != 0:
            Time.set_time_resolution(0)

        elevator_t = Type(ResourceTypeList.ACTIVE, 'Elevator')
        for elevator_id in range(self.num_cars):
            elevator = ResourceFactory.create_instance(elevator_t, 'Elevator_%02d' % elevator_id)
            elevator.set_capacity(1)
            elevator_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 100)
            elevator.set_power_consumption(elevator_power_consumption)
            System.add(elevator) # Not Necessary
            self.params[elevator_id] = ElevatorParameters(elevator, num_floors=self.num_floors)
            self.controllers[elevator_id] = ElevatorController(self.params[elevator_id])

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
        self._label_frame_logos = tk.LabelFrame(self.frame, relief=tk.FLAT)
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
        self._label_frame_logos.grid(row=0, column=0, sticky=tk.N)

        self._label_frame_request = tk.LabelFrame(self.frame, text='Elevator Request Controller', pady=10, labelanchor='n')
        self.__create_task_spec_widgets(self._label_frame_request)
        self._label_frame_request.grid(row=1, column=0, padx=10, pady=10, sticky=tk.S + tk.E + tk.W)

        self._label_frame_high_level_dispatch_strategy = tk.LabelFrame(self.frame,
                                                                       text='Passenger-to-car Assignment Strategy',
                                                                       padx=10, pady=10, labelanchor='n')
        self._high_level_strategy = tk.Variable()
        self._high_level_strategy.set(Sectors())
        self._radio_bt_high_level_strategy = [None] * 3
        self._radio_bt_high_level_strategy[0] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(Sectors()), variable=self._high_level_strategy,
                                                               value=Sectors(), command=self._create_sector_frame)
        self._radio_bt_high_level_strategy[0].grid(row=0, column=0)
        self._radio_bt_high_level_strategy[1] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(NEwCC()),
                                                               variable=self._high_level_strategy,
                                                               value=NEwCC())
        self._radio_bt_high_level_strategy[1].grid(row=0, column=1)
        self._radio_bt_high_level_strategy[2] = tk.Radiobutton(self._label_frame_high_level_dispatch_strategy,
                                                               text=str(NEwoutCC()),
                                                               variable=self._high_level_strategy,
                                                               value=NEwoutCC())
        self._radio_bt_high_level_strategy[2].grid(row=0, column=2)
        self._label_frame_high_level_dispatch_strategy.grid(row=2, column=0, sticky=tk.S + tk.E + tk.W)

        self._label_frame_elevator_status = tk.LabelFrame(self.frame, text='Elevator Status Information', padx=10, pady=10, labelanchor='n')
        for elevator_id in range(self.num_cars):
            self.__create_elevator_widgets(elevator_id, self.params[elevator_id], self._label_frame_elevator_status, elevator_id, 0)
        self._label_frame_elevator_status.grid(row=0, column=1, rowspan=3, padx=10, pady=10, sticky=tk.N)

    def __create_task_spec_widgets(self, frame):
        self._label_frame_task = tk.LabelFrame(frame, text='Task', padx=5, labelanchor='n')
        self._label_frame_task.pack(padx=10, pady=5, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._request = tk.Variable()
        self._request.set(HallCall())
        self._radio_bt_tasks = [None, None]
        self._radio_bt_tasks[0] = tk.Radiobutton(self._label_frame_task, text='Hall Call', variable=self._request, value=HallCall(), command=self._activate_widgets)
        self._radio_bt_tasks[0].pack(anchor=tk.CENTER)
        self._radio_bt_tasks[1] = tk.Radiobutton(self._label_frame_task, text='Car Call', variable=self._request, value=CarCall(), command=self._deactivate_widgets)
        self._radio_bt_tasks[1].pack(anchor=tk.CENTER)

        self._label_frame_dir = tk.LabelFrame(frame, text='Direction', padx=5, pady=5, labelanchor='n')
        self._label_frame_dir.pack(padx=10, pady=5, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._direction = tk.Variable()
        self._direction.set(UP())
        self._radio_bt_directions = [None] * 2
        self._radio_bt_directions[0] = tk.Radiobutton(self._label_frame_dir, text='Up', variable=self._direction, value=UP())
        self._radio_bt_directions[0].pack(anchor=tk.CENTER)
        self._radio_bt_directions[1] = tk.Radiobutton(self._label_frame_dir, text='Down', variable=self._direction, value=DOWN())
        self._radio_bt_directions[1].pack(anchor=tk.CENTER)

        self._label_frame_floor = tk.LabelFrame(frame, text='Floor', padx=5, pady=5, labelanchor='n')
        self._label_frame_floor.pack(padx=10, pady=5, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        floors = ['Floor %02d' % floor for floor in range(self.num_floors)]
        self._floor = tk.StringVar()
        self._floor.set(floors[0])
        self._option_floor = tk.OptionMenu(self._label_frame_floor, self._floor, *floors)
        self._option_floor.pack()

        self._label_frame_passengers = tk.LabelFrame(frame, text='Number of Passengers', padx=5, pady=5, labelanchor='n')
        self._label_frame_passengers.pack(padx=10, pady=5, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
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
        self._label_frame_priority.pack(padx=10, pady=5, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)

        self._button_add = tk.Button(frame, text='Add', command=self._dispatch)
        self._button_add.pack(fill=tk.X)

        self._label_frame_action = tk.LabelFrame(frame, pady=5, relief=tk.FLAT)
        self._button_request = tk.Button(self._label_frame_action, text='Request', command=self._request_task)
        self._button_continue = tk.Button(self._label_frame_action, text='Continue', command=self._continue)
        self._button_request.pack(fill=tk.BOTH)
        self._button_continue.pack(fill=tk.BOTH)
        self._label_frame_action.pack(anchor=tk.CENTER, fill=tk.BOTH)

    def __create_elevator_widgets(self, elevator_id, params, frame, row, col):
        label_frame_elevator_status = tk.LabelFrame(frame, text=params.car.get_resource_name(), padx=10, pady=10, labelanchor='n')
        # label_frame_elevator_status.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        label_frame_elevator_status.grid(row=row, column=col, columnspan=2, padx=10, pady=10, sticky=tk.N + tk.W + tk.S + tk.E)
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
        self._elevator_spec_widgets[elevator_id, 'LOG'] = tk.Text(label_frame_elevator_status, padx=5, state=tk.DISABLED, wrap=tk.NONE, width=100, height=23,
                                 yscrollcommand=self._scroll_bar.set,
                                 font=('Courier', 14, 'bold'),
                                 bg='#1e263f')
        self._elevator_spec_widgets[elevator_id, 'LOG'].grid(row=0, column=2, rowspan=len(parameters_table), sticky=tk.N + tk.W + tk.E)
        self._scroll_bar.config(command=self._elevator_spec_widgets[elevator_id, 'LOG'].yview)

        self._elevator_spec_widgets[elevator_id, 'LOG'].tag_configure('request', foreground='#13f128')
        self._elevator_spec_widgets[elevator_id, 'LOG'].tag_configure('continue', foreground='#d5f90b')

    def _create_sector_frame(self):
        master = tk.Toplevel()
        frame = tk.Frame(master)
        master.title('Sectors')
        frame.grid()

        self._listbox_sectors = []
        num_floors_height = self.num_floors
        num_floors_height = num_floors_height if num_floors_height < 20 else 20
        for elevator_id in range(self.num_cars):
            floors = tuple(map(str, range(self.params[elevator_id].num_floors)))
            floors = tk.StringVar(value=floors)

            tk.Label(frame, text='Elevator_%02d' % elevator_id).grid(row=0, column=elevator_id, sticky=tk.W)

            self._listbox_sectors.append(tk.Listbox(frame, listvariable=floors, selectmode=tk.MULTIPLE, height=num_floors_height, exportselection=0))
            self._listbox_sectors[-1].grid(row=1, column=elevator_id, sticky=tk.W)

        tk.Button(frame, text='SET').grid(row=2, column=0, columnspan=num_floors_height, sticky=tk.W+tk.E, command=self.__listbox_cb)

    def __listbox_cb(self):
        for elevator_id in range(self.num_cars):
            selections = set(self._listbox_sectors[elevator_id].curselection())
            all_floors = set(range(self.params[elevator_id].num_floors))
            disabled_floors = list(all_floors.difference(selections))


    def _deactivate_widgets(self):
        LOG(msg='==CarCall:%r, ==HallCall:%r' % (self._request.get() == CarCall(), self._request.get() == HallCall()))
        self._radio_bt_directions[0].config(state=tk.DISABLED)
        self._radio_bt_directions[1].config(state=tk.DISABLED)
        self._option_passengers.config(state=tk.NORMAL)

    def _activate_widgets(self):
        LOG(msg='==CarCall:%r, ==HallCall:%r' % (self._request.get() == CarCall(), self._request.get() == HallCall()))
        self._radio_bt_directions[0].config(state=tk.NORMAL)
        self._radio_bt_directions[1].config(state=tk.NORMAL)
        self._option_passengers.config(state=tk.DISABLED)

    def _request_task(self):
        LOG(msg='TODO')

    def _continue(self):
        LOG(msg='TODO')

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

    def _dispatch(self):
        print ''

if __name__ == '__main__':
    MetaControllerGUI(2, 20)