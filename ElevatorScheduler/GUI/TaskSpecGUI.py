import Tkinter as tk

# from ElevatorScheduler import elevator_params as params
from ..ElevatorParameters import CarCall, HallCall, UP, DOWN

class TaskSpecUI:
    def __init__(self, invoker, master=None):
        self.master = master
        self.frame = tk.Frame(self.master)
        self.master.title('Task Specification GUI')
        self._invoker = invoker
        self.frame.grid()

        self._request = None
        self._direction = None
        self._floor = None
        self._priority = None

        self._create_widgets()

    def _create_widgets(self):
        self._label_frame_task = tk.LabelFrame(self.frame, text='Task', padx=5, pady=5, labelanchor='n')
        self._label_frame_task.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._request = tk.StringVar()
        self._request.set(HallCall())
        self._radio_bt_tasks = [None, None]
        self._radio_bt_tasks[0] = tk.Radiobutton(self._label_frame_task, text='Hall Call', variable=self._request, value=HallCall(), command=self._activate_widgets)
        self._radio_bt_tasks[0].pack(anchor=tk.CENTER)
        self._radio_bt_tasks[1] = tk.Radiobutton(self._label_frame_task, text='Car Call', variable=self._request, value=CarCall(), command=self._deactivate_widgets)
        self._radio_bt_tasks[1].pack(anchor=tk.CENTER)

        self._label_frame_dir = tk.LabelFrame(self.frame, text='Direction', padx=5, pady=5, labelanchor='n')
        self._label_frame_dir.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        self._direction = tk.StringVar()
        self._direction.set(UP())
        self._radio_bt_directions = [None] * 2
        self._radio_bt_directions[0] = tk.Radiobutton(self._label_frame_dir, text='Up', variable=self._direction, value=UP())
        self._radio_bt_directions[0].pack(anchor=tk.CENTER)
        self._radio_bt_directions[1] = tk.Radiobutton(self._label_frame_dir, text='Down', variable=self._direction, value=DOWN())
        self._radio_bt_directions[1].pack(anchor=tk.CENTER)

        self._label_frame_floor = tk.LabelFrame(self.frame, text='Floor', padx=5, pady=5, labelanchor='n')
        self._label_frame_floor.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        floors = ['Floor %02d' % floor for floor in range(params.number_of_floors)]
        self._floor = tk.StringVar()
        self._floor.set(floors[0])
        self._option_floor = tk.OptionMenu(self._label_frame_floor, self._floor, *floors)
        self._option_floor.pack()

        self._label_frame_passengers = tk.LabelFrame(self.frame, text='Number of Passengers', padx=5, pady=5, labelanchor='n')
        self._label_frame_passengers.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)
        passengers = [passenger+1 for passenger in range(params.number_of_passengers_per_car)]
        self._passengers = tk.IntVar()
        self._passengers.set(passengers[0])
        self._option_passengers = tk.OptionMenu(self._label_frame_passengers, self._passengers, *passengers)
        self._option_passengers.pack()
        self._option_passengers.config(state=tk.DISABLED)

        self._label_frame_priority = tk.LabelFrame(self.frame, text='Priority', padx=5, pady=5, labelanchor='n')
        self._priority = tk.StringVar()
        self._priority.set(params.PassengerPriority.NORMAL)
        self._radio_bt_priority = [None] * params.num_class_vars(params.PassengerPriority)
        self._radio_bt_priority[0] = tk.Radiobutton(self._label_frame_priority, text='Normal', variable=self._priority, value=params.PassengerPriority.NORMAL)
        self._radio_bt_priority[1] = tk.Radiobutton(self._label_frame_priority, text='High', variable=self._priority, value=params.PassengerPriority.HIGH)
        self._radio_bt_priority[2] = tk.Radiobutton(self._label_frame_priority, text='Urgent', variable=self._priority, value=params.PassengerPriority.URGENT)
        self._radio_bt_priority[0].pack(anchor=tk.CENTER)
        self._radio_bt_priority[1].pack(anchor=tk.CENTER)
        self._radio_bt_priority[2].pack(anchor=tk.CENTER)
        self._label_frame_priority.pack(padx=10, pady=10, ipadx=100, anchor=tk.CENTER, fill=tk.BOTH)

        self._button_add = tk.Button(self.frame, text='Add', command=self._terminate)
        self._button_add.pack(fill=tk.X)

    def run(self):
        self.frame.mainloop()

    def _deactivate_widgets(self):
        self._radio_bt_directions[0].config(state=tk.DISABLED)
        self._radio_bt_directions[1].config(state=tk.DISABLED)
        self._option_passengers.config(state=tk.NORMAL)

    def _activate_widgets(self):
        self._radio_bt_directions[0].config(state=tk.NORMAL)
        self._radio_bt_directions[1].config(state=tk.NORMAL)
        self._option_passengers.config(state=tk.DISABLED)

    def _terminate(self):
        self._invoker.set_params([self._request.get(), self._direction.get(), self._floor.get(), self._passengers.get(), self._priority.get()])
        self.master.destroy()