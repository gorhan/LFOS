from LFOS.Log import LOG, Logs

class AbstractPeriodicity(object):
    def __init__(self):
        self.period = None

    def set_period(self, new_period):
        self.period = new_period

    def get_period(self):
        return self.period


class Periodic(AbstractPeriodicity):
    def __init__(self):
        super(Periodic, self).__init__()


class Aperiodic(AbstractPeriodicity):
    def __init__(self):
        super(Aperiodic, self).__init__()


class Sporadic(AbstractPeriodicity):
    def __init__(self):
        super(Sporadic, self).__init__()

    def set_period(self, new_period):
        LOG(msg='Invalid request. Sporadic tasks cannot have a specific period time.', log=Logs.ERROR)


class PeriodicityFactory:
    TYPES = {
        'periodic': Periodic,
        'aperiodic': Aperiodic,
        'sporadic': Sporadic
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type):
        if _type in cls.TYPES:
            return cls.TYPES[_type]()
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)