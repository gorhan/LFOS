from LFOS.Log import LOG, Logs
from LFOS.Resource.Resource import ROOT
from LFOS.Resource.Type import Type, ACTIVE, PASSIVE


class DeadlineRequirementInterface(object):
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

    def get_extended_deadline(self):
        return self.deadline + self.penalty_duration

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


class HardDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type, deadline):
        super(HardDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For hard deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


class FirmDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type, deadline):
        super(FirmDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty=0):
        self.penalty_per_unit_time = penalty
        self.penalty_duration = duration
        LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


class SoftDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type, deadline):
        super(SoftDeadlineRequirement, self).__init__(_type, deadline)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For soft deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = -abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


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


'''
    Capacity, Time, ResourceList, ResourceType
'''


class ResourceRequirement(object):
    def __init__(self):
        self.__type = None
        self.__eligible_resources = None
        self.__required_capacity = 1

    def set_resource_requirement(self, **kwargs):
        if kwargs.has_key('type'):
            self.__set_type(kwargs['type'])
        elif self.__type is None:
            LOG(msg='The resource type has to be specified before other parameters.', log=Logs.ERROR)
            return False

        if kwargs.has_key('eligible_resources'):
            if self.__type.same_abstraction(ACTIVE):
                if not isinstance(kwargs['eligible_resources'], dict):
                    LOG(msg='Eligible Resources have to be defined as dict structure whose keys are resources and values are execution time.', log=Logs.ERROR)
                    return False

                self.__eligible_resources = dict()
                for resource, exec_time in kwargs['eligible_resources'].items():
                    if resource.get_type() == self.__type:
                        self.__eligible_resources[resource] = exec_time
                    else:
                        LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.__type.get_identifier()), log=Logs.WARN)

            elif self.__type.same_abstraction(PASSIVE):
                if not isinstance(kwargs['eligible_resources'], list):
                    LOG(msg='Eligible Resources have to be defined as list structure including resources.', log=Logs.ERROR)
                    return False

                self.__eligible_resources = list()
                for resource in kwargs['eligible_resources']:
                    try:
                        if resource.get_type() == self.__type:
                            self.__eligible_resources.index(resource)
                            self.__eligible_resources.append(resource)
                        else:
                            LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.__type.get_identifier()), log=Logs.WARN)
                    except ValueError:
                        LOG(msg='%s is already in the Eligible Resources. IGNORED...' % (resource.info(), self.__type.get_identifier()), log=Logs.WARN)

        else:
            if self.__type.same_abstraction(ACTIVE):
                LOG(msg='Eligible Resources have to be defined with actual execution times on the resources.', log=Logs.ERROR)
                return False
            elif self.__type.same_abstraction(PASSIVE):
                self.__eligible_resources = list()
                ROOT.search_resources(self.__eligible_resources, type=self.__type)

        if kwargs.has_key('capacity'):
            self.__required_capacity = kwargs['capacity']
        else:
            LOG(msg='Required capacity for the resource requirement has been set to 1.')

        return True


    def __set_type(self, _type):
        if not Type.check(_type):
            LOG(msg='Given resource type is invalid.', log=Logs.ERROR)
            return False

        self.__type = _type
        return True


class ResourceRequirementList(list):
    def __init__(self):
        list.__init__([])

    def add_resource_requirement(self, _type):