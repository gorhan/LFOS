from LFOS.Log import LOG, Logs
from LFOS.Resource.Resource import System
from LFOS.Resource.Type import Type, ResourceTypeList


class DeadlineRequirementInterface(object):
    def __init__(self, _type):
        self.deadline_requirement = _type

        self.penalty_per_unit_time = 0
        self.penalty_duration = 0

    def get_deadline_requirement(self):
        return self.deadline_requirement

    def get_extended_deadline(self, deadline):
        return deadline + self.penalty_duration

    def calculate_penalty(self, current_time, deadline):
        penalty = None
        threshold_time_exceeded = False

        if current_time < deadline:
            penalty = 0
        elif deadline <= current_time <= (deadline + self.penalty_duration):
            penalty = (current_time - deadline) * self.penalty_per_unit_time
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

    def get_penalty_end_time(self, deadline):
        return deadline + self.penalty_duration

    def set_penalty_per_unit_time(self, duration, penalty):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)


class HardDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type):
        super(HardDeadlineRequirement, self).__init__(_type)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For hard deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


class FirmDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type):
        super(FirmDeadlineRequirement, self).__init__(_type)

    def set_penalty_per_unit_time(self, duration, penalty=0):
        self.penalty_per_unit_time = penalty
        self.penalty_duration = duration
        LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


class SoftDeadlineRequirement(DeadlineRequirementInterface):
    def __init__(self, _type):
        super(SoftDeadlineRequirement, self).__init__(_type)

    def set_penalty_per_unit_time(self, duration, penalty):
        if penalty == 0:
            LOG(msg='Wrong penalty value. For soft deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
        else:
            self.penalty_per_unit_time = -abs(penalty)
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))


'''
    Capacity, Time, ResourceList, ResourceType
'''


class ResourceRequirementItem(object):
    def __init__(self):
        self.__type = None
        self.__eligible_resources = None
        self.__required_capacity = 1

    def set_resource_requirement(self, update=None, **kwargs):
        if kwargs.has_key('resource_type'):
            self.__set_type(kwargs['resource_type'])
        elif self.__type is None:
            LOG(msg='The resource type has to be specified before other parameters.', log=Logs.ERROR)
            return False

        if kwargs.has_key('eligible_resources'):
            if self.__type.same_abstraction(ResourceTypeList.ACTIVE):
                if not isinstance(kwargs['eligible_resources'], dict):
                    LOG(msg='Eligible Resources have to be defined as dict structure whose keys are resources and values are execution time.', log=Logs.ERROR)
                    return False

                if not update:
                    self.__eligible_resources = dict()
                for resource, exec_time in kwargs['eligible_resources'].items():
                    if resource.get_type() == self.__type:
                        self.__eligible_resources[resource] = exec_time
                    else:
                        LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.__type.get_identifier()), log=Logs.WARN)

            elif self.__type.same_abstraction(ResourceTypeList.PASSIVE):
                if not isinstance(kwargs['eligible_resources'], list):
                    LOG(msg='Eligible Resources have to be defined as list structure including resources.', log=Logs.ERROR)
                    return False

                if not update:
                    self.__eligible_resources = list()
                for resource in kwargs['eligible_resources']:
                    try:
                        if resource.get_type() == self.__type and self.__eligible_resources.index(resource):
                            LOG(msg='%s is already in the Eligible Resources. IGNORED...' % resource.info(), log=Logs.WARN)
                        else:
                            LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.__type.get_identifier()), log=Logs.WARN)
                    except ValueError:
                        self.__eligible_resources.append(resource)
        else:
            if self.__type.same_abstraction(ResourceTypeList.ACTIVE):
                LOG(msg='Eligible Resources have to be defined with actual execution times on the resources.', log=Logs.ERROR)
                return False
            elif self.__type.same_abstraction(ResourceTypeList.PASSIVE):
                self.__eligible_resources = list()
                System.search_resources(self.__eligible_resources, type=self.__type)

        if kwargs.has_key('capacity'):
            self.__required_capacity = kwargs['capacity']
        else:
            self.__required_capacity = 1
            LOG(msg='Required capacity for the resource requirement has been set to 1.')

        return True

    def uodate_resource_requirement(self, **kwargs):
        return self.set_resource_requirement(True, kwargs)

    def __set_type(self, _type):
        if not Type.check(_type):
            LOG(msg='Given resource type is invalid.', log=Logs.ERROR)
            return False

        self.__type = _type
        return True

    def __eq__(self, other):
        return (isinstance(other, ResourceRequirementItem) and self.__type == other.__type) or\
               (isinstance(other, Type) and self.__type == other)

    def __str__(self):
        return '(%s)::%s -- Required Capacity=%d' % (', '.join(map(lambda r: r.get_resource_name(), self.__eligible_resources)), self.__type, self.__required_capacity)


class ResourceRequirement(list):
    def __init__(self):
        list.__init__([])

    def add_resource_requirement(self, **kwargs):
        new_req = ResourceRequirementItem()
        if new_req.set_resource_requirement(**kwargs) and new_req not in self:
            self.append(new_req)
            LOG(msg='New ResourceRequirement has been added to the ResourceRequirementList.')
        elif new_req in self:
            pos = self.index(new_req)
            self[pos].update_resource_requirement(**kwargs)
            LOG(msg='ResourceRequirementList has been updated.')
        else:
            return False

        return True

    def remove_resource_requirement(self, _type):
        return self.remove(_type)

    def get_required_resources(self):
        return self


class DeadlineRequirementTypeList:
    HARD = 'Task.Requirement.DeadReq.HARD'
    FIRM = 'Task.Requirement.DeadReq.FIRM'
    SOFT = 'Task.Requirement.DeadReq.SOFT'


class RequirementFactory:
    TYPES = {
        DeadlineRequirementTypeList.HARD: HardDeadlineRequirement,
        DeadlineRequirementTypeList.FIRM: FirmDeadlineRequirement,
        DeadlineRequirementTypeList.SOFT: SoftDeadlineRequirement
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type):
        if _type in cls.TYPES:
            return type('Requirement', (cls.TYPES[_type], ResourceRequirement), {})(_type)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)