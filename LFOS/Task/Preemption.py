from LFOS.Log import LOG, Logs


class AbstractPreemption(object):
    def __init__(self, _type):
        self.preemption_type = _type
        self.non_preemptable_execution_duration = 0

    def is_preemptable(self):
        return self.preemption_type, self.non_preemptable_execution_duration

    def set_non_preemptable_exec_duration(self, duration):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)


class NonPreemptable(AbstractPreemption):
    def __init__(self, _type):
        super(NonPreemptable, self).__init__(_type)
        self.non_preemptable_execution_duration = -1


class Preemptable(AbstractPreemption):
    def __init__(self, _type):
        super(Preemptable, self).__init__(_type)


class CooperativelyPreemptable(AbstractPreemption):
    def __init__(self, _type):
        super(CooperativelyPreemptable, self).__init__(_type)

    def set_non_preemptable_exec_duration(self, duration):
        self.non_preemptable_execution_duration = duration


class PreemptionFactory:
    TYPES = {
        'nonPreemptable': NonPreemptable,
        'preemptable': Preemptable,
        'cooperativelyPreemptable': CooperativelyPreemptable
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type):
        if _type in cls.TYPES:
            return cls.TYPES[_type](_type)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
            return None