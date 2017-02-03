
import Tkinter as tk
import tkFont
from TaskSpecGUI import TaskSpecUI


class ElevatorUI(tk.Frame):
    def __init__(self, invoker, master=None):
        tk.Frame.__init__(self, master, width=1000, height=500)
        self.master.title('Elevator Scheduling GUI')
        self.grid()
        self._create_widgets()

        self._invoker = invoker
        self._clock = 0

        self.mainloop()

    def _create_widgets(self):
        self._label_frame_text = tk.LabelFrame(self, text='Output Console', labelanchor='n')
        self._label_frame_text.grid(row=0, column=0, columnspan=2, padx=10, pady=10)
        self._scroll_bar = tk.Scrollbar(self._label_frame_text)
        self._scroll_bar.grid(row=0, column=2, sticky=tk.N+tk.W+tk.E+tk.S)
        self._text_log = tk.Text(self._label_frame_text, state=tk.DISABLED, wrap=tk.NONE, width=200, height=50, yscrollcommand=self._scroll_bar.set,
                                 font=tkFont.Font(family='Courier', size=12),
                                 bg='#020202', fg='green')
        self._text_log.grid(row=0, column=0, columnspan=2)
        self._scroll_bar.config(command=self._text_log.yview)

        self._button_cnt = tk.Button(self, text='Continue', command=self._continue)
        self._button_cnt.grid(row=1, column=0, rowspan=3, sticky=tk.N+tk.W+tk.E+tk.S, padx=5, pady=5)
        self._button_add = tk.Button(self, text='Request', command=self._update_taskset)
        self._button_add.grid(row=1, column=1, rowspan=3, sticky=tk.N+tk.W+tk.E+tk.S, padx=5, pady=5)

        # self.grid_propagate(False)

    def set_params(self, params):
        self._params = params
        self.__set_text('New Task: {}, Direction: {}, Target: {}\n'.format(*self._params))
        if self._invoker:
            self._invoker.publish_task(params, self._clock)

    def _update_taskset(self):
        master = tk.Toplevel(self.master)
        spec_gui = TaskSpecUI(self, master)

    def __set_text(self, text, pos=tk.END):
        self._text_log.config(state=tk.NORMAL)
        self._text_log.insert(pos, text)
        self._text_log.see(tk.END) # to auto-scroll down the scrollbar
        self._text_log.config(state=tk.DISABLED)

    def log(self, text):
        self.__set_text(text)

    def _continue(self):
        log = self._invoker.get_schedule(self._clock, self._clock+1)
        self.__set_text(log)
        self._clock+=1