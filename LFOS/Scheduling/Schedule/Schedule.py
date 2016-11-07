from LFOS.Log import LOG, Logs


class ScheduleItem:
    def __init__(self, task=None, reserved={}, begin_tm=0.0, end_tm=0.0):
        self.reserved_task = task
        self.reserved_resources = reserved
        self.begin = begin_tm
        self.end = end_tm

    def extend(self, duration):
        try:
            assert duration > 0
        except AssertionError:
            LOG(msg='AssertionError: Specified time duration must be greater than zero (duration > 0)', log=Logs.ERROR)
            return None
        self.end += duration

    def extend_to(self, tm):
        try:
            assert tm > self.end
        except AssertionError:
            LOG(msg='AssertionError: Specified finish time to extend must be greater than current finish time (newFinish > currentFinish)', log=Logs.ERROR)
            return None
        self.end = tm

    def __str__(self):
        return '[%.3f %.3f] - %s ON %s' % (self.begin, self.end,
                                           self.reserved_task.get_credential() if self.reserved_task else 'EMPTY',
                                           ', '.join(['%s [%d]' % (resource.get_credential(), capacity) for resource, capacity in self.reserved_resources.items()]))

    def __repr__(self):
        return '[%.3f %.3f] - %s ON %s' % (self.begin, self.end,
                                           self.reserved_task.get_credential() if self.reserved_task else 'EMPTY',
                                           ', '.join(['%s [%d]' % (resource.get_credential(), capacity) for resource, capacity in self.reserved_resources.items()]))


class Schedule(list):
    def __init__(self):
        super(Schedule, self).__init__([])

    def append(self, p_object):
        last_instance = self.get_last_instance(p_object.reserved_task)
        if last_instance and last_instance.end == p_object.begin and not p_object.reserved_resources:
            last_instance.extend_to(p_object.end)
        else:
            super(Schedule, self).append(p_object)
            self.sort(key=lambda sc_it: sc_it.begin)

    def append_item(self, task, begin_tm, end_tm, reserved={}):
        self.append(ScheduleItem(task, reserved, begin_tm, end_tm))

    def append_empty_slot(self, begin_tm, end_tm):
        self.append(ScheduleItem(None, {}, begin_tm, end_tm))

    def get_last_instance(self, task):
        for schedule_item in reversed(self):
            if schedule_item.reserved_task == task:
                return schedule_item

        return None

    def __str__(self):
        return '\n'.join([str(sched_item) for sched_item in self])

    def __repr__(self):
        return '\n'.join([str(sched_item) for sched_item in self])