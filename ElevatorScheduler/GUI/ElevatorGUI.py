
import Tkinter as tk
import tkFileDialog
from PIL import Image, ImageTk
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
        self._label_frame_text.grid(row=0, column=0, columnspan=7, padx=10, pady=10)
        self._scroll_bar = tk.Scrollbar(self._label_frame_text)
        self._scroll_bar.grid(row=0, column=6, sticky=tk.N+tk.W+tk.E+tk.S)
        self._text_log = tk.Text(self._label_frame_text, state=tk.DISABLED, wrap=tk.NONE, width=150, height=60, yscrollcommand=self._scroll_bar.set,
                                 font=('Courier', 12, 'bold'),
                                 bg='#1e263f')
        self._text_log.grid(row=0, column=0, columnspan=7)
        self._scroll_bar.config(command=self._text_log.yview)

        self._text_log.tag_configure('request', foreground='#13f128')
        self._text_log.tag_configure('continue', foreground='#d5f90b')

        self._button_cnt = tk.Button(self, text='Continue', command=self._continue)
        self._button_cnt.grid(row=1, column=0, columnspan=2, sticky=tk.N + tk.W + tk.E + tk.S, padx=5, pady=5)
        self._button_add = tk.Button(self, text='Request', command=self._update_taskset)
        self._button_add.grid(row=1, column=2, columnspan=2,  sticky=tk.N + tk.W + tk.E + tk.S, padx=5, pady=5)
        self._button_save = tk.Button(self, text='Save', command=self._save_file)
        self._button_save.grid(row=1, column=4, columnspan=2,  sticky=tk.N + tk.W + tk.E + tk.S, padx=5, pady=5)

        self._logo = ImageTk.PhotoImage(Image.open('GUI/images/ut_logo_ds.jpg'))
        self._logo_label = tk.Label(self, image=self._logo, height=40, width=100)
        self._logo_label.grid(row=1, column=6, columnspan=1, padx=5, pady=5, sticky=tk.N+tk.E)

        # self.grid_propagate(False)

    def set_params(self, params):
        self._params = params
        if self._invoker:
            log = self._invoker.publish_task(params, self._clock)
            self.__set_text(log, 'request')

    def _update_taskset(self):
        master = tk.Toplevel(self.master)
        spec_gui = TaskSpecUI(self, master)

    def __set_text(self, text, tag, pos=tk.END):
        self._text_log.config(state=tk.NORMAL)
        self._text_log.insert(pos, text, tag)
        self._text_log.see(tk.END) # to auto-scroll down the scrollbar
        self._text_log.config(state=tk.DISABLED)

    def log(self, text):
        self.__set_text(text)

    def _continue(self):
        log = self._invoker.monitor(self._clock, self._clock+1)
        self.__set_text(log, 'continue')
        self._clock+=1

    def _save_file(self):
        save_file = tkFileDialog.asksaveasfile()
        if save_file is None:
            return

        save_file.write(str(self._text_log.get('1.0', tk.END)))
        save_file.close()