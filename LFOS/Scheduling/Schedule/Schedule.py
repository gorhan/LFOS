from LFOS.Resource.Resource import System, ResourceTypeList
from LFOS.Scheduling.Characteristic.Time import Time, TimeResolution
from matplotlib import colors
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
from matplotlib.ticker import MultipleLocator
from random import shuffle
from LFOS.Log import LOG
import numpy as np

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

    def get_partial_schedule(self, resource, begin, end):
        partial_schedule = []

        for reservation in self.__schedule[resource]:
            LOG(msg='Begin=%d, End=%d, reservation=%d,%d' % (begin, end, reservation[1], reservation[2]))
            if reservation[1] < end <= reservation[2]:
                partial_schedule.append(reservation)

        return partial_schedule

    def __str__(self):
        prnt_str = ''
        reserved = '#'
        n_reserved = ' '
        seperator = '|'

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

        colors_ = [
            'r',
            'g',
            'darkviolet',
            'navy',
            'gray',
            'brown',
            'b',
            'y'
        ]
        if len(self.__jobs) > len(colors_):
            LOG(msg='Color names have been extended to the larger set.')
            colors_ = colors.cnames.keys()
        # shuffle(colors_)
        job2colors = {job_cred: colors_[i] for i, job_cred in enumerate(self.__jobs)}

        y_resource = 10.0
        y_margin = 3.0

        fig = plt.figure(1)
        ax = fig.add_axes([0.1, 0.18, 0.65, 0.8])

        for ind, (resource, reservations) in enumerate(self.__schedule.items()):
            y_capacity = y_resource / resource.get_capacity()

            time_slots = np.arange(self.__begin, self.__end + tm_res, tm_res).tolist()
            time_slots = zip(time_slots[:-1], time_slots[1:])

            for t_begin, t_end in time_slots:
                reservations = self.search_overlapping_jobs(resource, t_begin, t_end)
                y_start = (y_margin + y_resource) * ind + y_margin

                for reservation in reservations:
                    y_height = y_capacity * reservation[3]

                    ax.broken_barh([(t_begin, t_end - t_begin)],
                                   (y_start, y_height), facecolor=job2colors[reservation[0].get_credential()])

                    y_start += y_height

        # ax_legend = fig.add_axes([0.75, 0.15, 0.25, 1.0])
        patches = [mpatches.Patch(color=job2colors[job_cred], label=job_cred) for job_cred in sorted(job2colors.keys())]
        ax.legend(handles=patches, loc='lower left', bbox_to_anchor=(1.01, -0.01))
        ax.xaxis.set_major_locator(major_grid_locator)
        ax.grid(b=True, which='major', linestyle='--')
        ax.set_ylim(0, y_start + y_resource + y_margin)
        ax.set_xlim(self.__begin, self.__end)
        ax.set_yticks([y_margin + ind * (y_resource + y_margin) + y_resource/2 for ind, resource in enumerate(self.__schedule.keys())])
        ax.set_yticklabels(['%s%s' % (resource.get_resource_name(), '*' if resource.get_type().get_abstraction() == ResourceTypeList.ACTIVE else '') for resource in self.__schedule.keys()])
        ax.set_xlabel('Time (%s)' % Time.get_time_unit())

        dpi = fig.get_dpi()
        LOG(msg='DPI=%d' % dpi)
        fig.set_size_inches((40 * (self.__end - self.__begin) * (tm_res))/float(dpi), (60.0 * len(self.__schedule))/float(dpi))
        # to know size of legend
        # plt.tight_layout()
        plt.show()
        # canvas = FigureCanvasTkAgg(fig, master=root)
        # canvas.show()

        # padLeft = ax.get_position().x0 * fig.get_size_inches()[0]
        # padBottom = ax.get_position().y0 * fig.get_size_inches()[1]
        # padTop = (1 - ax.get_position().y0 - ax.get_position().height) * fig.get_size_inches()[1]
        # padRight = (1 - ax.get_position().x0 - ax.get_position().width) * fig.get_size_inches()[0]
        # dpi = fig.get_dpi()
        # padLegend = ax.get_legend().get_frame().get_width() / dpi
        #
        # widthAx = 3  # inches
        # heightAx = 3  # inches
        # widthTot = widthAx + padLeft + padRight + padLegend
        # heightTot = heightAx + padTop + padBottom
        #
        # # resize ipython window (optional)
        # posScreenX = 1366 / 2 - 10  # pixel
        # posScreenY = 0  # pixel
        # canvasPadding = 6  # pixel
        # canvasBottom = 40  # pixel
        # ipythonWindowSize = '{0}x{1}+{2}+{3}'.format(int(round(widthTot * dpi)) + 2 * canvasPadding
        #                                              , int(round(heightTot * dpi)) + 2 * canvasPadding + canvasBottom
        #                                              , posScreenX, posScreenY)
        # canvas._tkcanvas.master.geometry(ipythonWindowSize)
        # plt.draw()  # to resize ipython window. Has to be done BEFORE figure resizing!
        #
        # # set figure size and ax position
        # fig.set_size_inches(widthTot, heightTot)
        # ax.set_position([padLeft / widthTot, padBottom / heightTot, widthAx / widthTot, heightAx / heightTot])
        # plt.draw()
        # plt.show()

        self.__reset_schedule_plot()
