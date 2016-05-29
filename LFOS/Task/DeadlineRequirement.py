from LFOS.Log import LOG, Logs


class AbstractTaskDeadlineRequirement(object):
    def __init__(self, _type, deadline):
        self.deadline_requirement = _type
        self.deadline = deadline

        self.penalty_per_unit_time = 0
        self.penalty_duration = 0

    def get_deadline_requirement(self):
        return self.deadline_requirement

    def set_deadline(self, deadline):
        self.deadline = deadline

    def get_deadline(self):
        return self.deadline

    def calculate_penalty(self, current_time):
        penalty = None
        threshold_time_exceeded = False

        if current_time < self.deadline:
            penalty = 0
        elif self.deadline <= current_time <= (self.deadline + self.penalty_duration):
            penalty = (current_time - self.deadline) * self.penalty_per_unit_time
        else:
            penalty = self.penalty_duration * self.penalty_per_unit_time
            threshold_time_exceeded = True
            LOG(msg='End time for deadline penalty has been exceeded. Current Time: %2.f, End Time: %.2f' % (current_time, self.get_penalty_end_time()))

        return penalty, threshold_time_exceeded

    def get_penalty_per_unit_time(self):
        return self.penalty_per_unit_time

    def set_penalty_duration(self, duration):
        self.penalty_duration = duration

    def get_penalty_duration(self):
        return self.penalty_duration

    def get_penalty_end_time(self):
        return self.deadline + self.penalty_duration

    def set_penalty_per_unit_time(self, duration, penalty):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)


class HardDeadlineRequirement(AbstractTaskDeadlineRequirement):
    def __init__(self, _type, deadline):
        super(HardDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For hard deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()), log=Logs.INFO)


class FirmDeadlineRequirement(AbstractTaskDeadlineRequirement):
    def __init__(self, _type, deadline):
        super(FirmDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty=0):
        self.penalty_per_unit_time = penalty
        self.penalty_duration = duration
        LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()), log=Logs.INFO)


class SoftDeadlineRequirement(AbstractTaskDeadlineRequirement):
    def __init__(self, _type, deadline):
        super(SoftDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For soft deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = -abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()), log=Logs.INFO)


class DeadlineRequirementFactory:
    TYPES = {
        'hard': HardDeadlineRequirement,
        'firm': FirmDeadlineRequirement,
        'soft': SoftDeadlineRequirement
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, deadline=-1):
        if _type in cls.TYPES:
            return cls.TYPES[_type](_type, deadline)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)