from LFOS.Resource.Resource import System
from LFOS.Scheduling.Characteristic.Time import Time, TimeResolution
from matplotlib import colors
import matplotlib.pyplot as plt
import matplotlib as mpl
from matplotlib.ticker import MultipleLocator
from random import shuffle
from LFOS.Log import LOG

class Schedule:
    def __init__(self, begin=None, end=None):
        self.__schedule = {resource:[] for resource in System.for_each_sub_terminal_resource()}
        self.__jobs = set()
        self.__begin , self.__end = begin, end

    def search_overlapping_jobs(self, on_resource, begin, end, job=None):
        return [reservation for reservation in self.__schedule[on_resource] if (reservation[1] <= begin < reservation[2] or
                                                                               (reservation[1] < end <= reservation[2]) or
                                                                               (reservation[1] >= begin and reservation[2] <= end)) and
                                                                               (job is None or job.get_credential() != reservation[0].get_credential())]

    def __append_slot(self, job, begin, end, on_resource, capacity):
        for reservation in self.__schedule[on_resource]:
            if reservation[1] >= end:
                break

            if reservation[2] == begin and job == reservation[0] and capacity == reservation[3]:
                reservation[2] = end
                return True

        print job, begin, end, capacity
        self.__schedule[on_resource].append([job, begin, end, capacity, False])
        self.__schedule[on_resource].sort(key=lambda slot: slot[1])

    def set_boundaries(self, begin, end):
        self.__begin, self.__end = begin, end

    def append_item(self, job, begin, end, reserved_resources_dict):
        for resource, capacity in reserved_resources_dict.items():
            self.__jobs.add(job.get_credential())
            self.__append_slot(job, begin, end, resource, capacity)

    def __str__(self):
        prnt_str = ''
        reserved = '#'
        n_reserved = ' '
        seperator = '|'

        import numpy as np

        tm_res = Time.get_time_resolution()
        l_time_slots = np.arange(self.__begin, self.__end + tm_res, tm_res)

        prnt_str += ' ' * 15
        prnt_str += ' '.join(['%10s' % tm for tm in l_time_slots]) + '\n'

        for resource, reservations in self.__schedule.items():
            prnt_str += '%15s: ' % resource.get_resource_name()
            for reservation in reservations:
                print 'TODO'

    def __reset_schedule_plot(self):
        for reservations in self.__schedule.values():
            for reservation in reservations:
                reservation[4] = False

    def plot_schedule(self):
        tm_res = 10 ** Time.get_time_resolution()
        major_grid_locator = MultipleLocator(tm_res)

        colors_ = colors.cnames.keys()
        shuffle(colors_)
        job2colors = {job_cred: colors_[i] for i, job_cred in enumerate(self.__jobs)}

        y_resource = 10.0
        y_margin = 1.0

        fig, ax = plt.subplots()

        for ind, (resource, reservations) in enumerate(self.__schedule.items()):
            y_capacity = y_resource / resource.get_capacity()

            import numpy as np

            time_slots = np.arange(self.__begin, self.__end + tm_res, tm_res).tolist()
            time_slots = zip(time_slots[:-1], time_slots[1:])

            for t_begin, t_end in time_slots:
                reservations = self.search_overlapping_jobs(resource, t_begin, t_end)
                y_start = (y_margin + y_resource) * ind + y_margin

                for reservation in reservations:
                    y_height = y_capacity * reservation[3]

                    ax.broken_barh([(t_begin, t_end - t_begin)],
                                   (y_start, y_height), facecolor=job2colors[reservation[0].get_credential()],
                                   label=reservation[0].get_name())

                    y_start += y_height

        handles, labels = ax.get_legend_handles_labels()
        print 'HANDLES, LABELS', handles, labels
        ax.legend(handles, labels)
        ax.xaxis.set_major_locator(major_grid_locator)
        ax.grid(b=True, which='major', linestyle='--')
        ax.set_ylim(0, y_start + y_resource + y_margin)
        ax.set_xlim(self.__begin, self.__end)
        ax.set_yticks([y_margin + ind * (y_resource + y_margin) + y_resource/2 for ind, resource in enumerate(self.__schedule.keys())])
        ax.set_yticklabels([resource.get_resource_name() for resource in self.__schedule.keys()])
        ax.set_xlabel('Time (%s)' % Time.get_time_unit())

        dpi = fig.get_dpi()
        LOG(msg='DPI=%d' % dpi)

        fig.set_size_inches((30 * (self.__end - self.__begin) * (tm_res))/float(dpi), (85.0 * len(self.__schedule))/float(dpi), forward=True)

        self.__reset_schedule_plot()
        plt.tight_layout()
        plt.show()
