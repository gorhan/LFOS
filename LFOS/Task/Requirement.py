from LFOS.Log import LOG, Logs
from LFOS.Resource.Resource import System
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Resource.Type import Type, ResourceTypeList


'''
    Capacity, Time, ResourceList, ResourceType
'''


class ResourceRequirementItem(object):
    def __init__(self):
        self.resource_type = None
        self.eligible_resources = None
        self.required_capacity = 1

    def set_resource_requirement(self, update=None, **kwargs):
        if 'resource_type' in kwargs:
            self.__set_type(kwargs['resource_type'])
        elif self.resource_type is None:
            LOG(msg='The resource type has to be specified before other parameters.', log=Logs.ERROR)
            return False

        if 'eligible_resources' in kwargs:
            if self.resource_type.same_abstraction(ResourceTypeList.ACTIVE):
                if not isinstance(kwargs['eligible_resources'], dict):
                    LOG(msg='Eligible Resources have to be defined as dict structure whose keys are resources and values are execution time.', log=Logs.ERROR)
                    return False

                if not update:
                    self.eligible_resources = dict()
                for resource, exec_time in kwargs['eligible_resources'].items():
                    if resource.get_type() == self.resource_type:
                        self.eligible_resources[resource] = exec_time
                    else:
                        LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.resource_type.get_identifier()), log=Logs.WARN)

            elif self.resource_type.same_abstraction(ResourceTypeList.PASSIVE):
                if not isinstance(kwargs['eligible_resources'], list):
                    LOG(msg='Eligible Resources have to be defined as list structure including resources.', log=Logs.ERROR)
                    return False

                if not update:
                    self.eligible_resources = list()
                for resource in kwargs['eligible_resources']:
                    try:
                        if resource.get_type() == self.resource_type and self.eligible_resources.index(resource):
                            LOG(msg='%s is already in the Eligible Resources. IGNORED...' % resource.info(), log=Logs.WARN)
                        else:
                            LOG(msg='%s is not in the type %s. IGNORED...' % (resource.info(), self.resource_type.get_identifier()), log=Logs.WARN)
                    except ValueError:
                        self.eligible_resources.append(resource)
        else:
            if self.resource_type.same_abstraction(ResourceTypeList.ACTIVE):
                LOG(msg='Eligible Resources have to be defined with actual execution times on the resources.', log=Logs.ERROR)
                return False
            elif self.resource_type.same_abstraction(ResourceTypeList.PASSIVE):
                self.eligible_resources = System.search_resources(type=self.resource_type)

        if 'capacity' in kwargs:
            self.required_capacity = kwargs['capacity']
        else:
            self.required_capacity = 1
            LOG(msg='Required capacity for the resource requirement has been set to 1.')

        return True

    def update_resource_requirement(self, **kwargs):
        return self.set_resource_requirement(True, **kwargs)

    def __set_type(self, _type):
        if not Type.check(_type):
            LOG(msg='Given resource type is invalid.', log=Logs.ERROR)
            return False

        self.resource_type = _type
        return True

    def __eq__(self, other):
        return (isinstance(other, ResourceRequirementItem) and self.resource_type == other.resource_type) or\
               (isinstance(other, Type) and self.resource_type == other)

    def __str__(self):
        return '(%s)::%s -- Required Capacity=%d' % (', '.join(map(lambda r: '%s [%d]' % (r.get_resource_name(), self.eligible_resources[r] if self.resource_type.get_abstraction() == ResourceTypeList.ACTIVE else 0), self.eligible_resources)), self.resource_type, self.required_capacity)


class ResourceRequirement:
    def __init__(self):

        self.__dict = {}
        self.__dict[ResourceTypeList.ACTIVE] = list()
        self.__dict[ResourceTypeList.PASSIVE] = list()
        self.__dict[ResourceTypeList.COMPOSITE] = list()

    def add_resource_requirement(self, **kwargs):
        new_req = ResourceRequirementItem()
        if not new_req.set_resource_requirement(**kwargs):
            return False

        resource_abs = new_req.resource_type.get_abstraction()

        if new_req not in self.__dict[resource_abs]:
            self.__dict[resource_abs].append(new_req)
            LOG(msg='New ResourceRequirement: %s --> %s' % (resource_abs, new_req))
        else:
            pos = self.__dict[resource_abs].index(new_req)
            self.__dict[resource_abs][pos].update_resource_requirement(**kwargs)
            LOG(msg='ResourceRequirementList has been updated.')

        return True

    def get_max_wcet_time(self):
        return max([wcet for item in self.__dict[ResourceTypeList.ACTIVE] for wcet in item.eligible_resources.values()])

    def remove_resource_requirement(self, _type):
        return self.__dict[_type.get_abstraction()].remove(_type)

    def get_required_resources(self, _abstraction=None):
        return self.__dict[_abstraction] if _abstraction else self.__dict


class DeadlineRequirementTypeList:
    HARD = 'Task.Requirement.DeadReq.HARD'
    FIRM = 'Task.Requirement.DeadReq.FIRM'
    SOFT = 'Task.Requirement.DeadReq.SOFT'


class DeadlineRequirement(ResourceRequirement):
    TYPES = [DeadlineRequirementTypeList.HARD,
             DeadlineRequirementTypeList.FIRM,
             DeadlineRequirementTypeList.SOFT]

    def __init__(self, _type):
        ResourceRequirement.__init__(self)

        if not _type in DeadlineRequirement.TYPES:
            LOG(msg='Invalid Deadline Requirement Type. Available=%s' % ', '.join(DeadlineRequirement.TYPES))
            exit(1)
        self.deadline_requirement = _type

        self.penalty_per_unit_time = 0.0
        self.penalty_duration = Time(0)

    def get_deadline_requirement(self):
        return self.deadline_requirement

    def get_extended_deadline(self, deadline):
        return deadline + self.penalty_duration

    def calculate_penalty(self, current_time, deadline):
        penalty = None
        threshold_time_exceeded = False

        if current_time < deadline:
            penalty = 0.0
        elif deadline <= current_time <= (deadline + self.penalty_duration):
            penalty = (current_time - deadline) * self.penalty_per_unit_time
        else:
            penalty = self.penalty_duration * self.penalty_per_unit_time
            threshold_time_exceeded = True
            LOG(msg='End time for deadline penalty has been exceeded. Current Time: %.2f, End Time: %.2f' % (current_time, self.get_penalty_end_time()))

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
        if self.deadline_requirement == DeadlineRequirementTypeList.HARD:
            if penalty == Time(0):
                LOG(msg='Wrong penalty value. For hard deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
            else:
                self.penalty_per_unit_time = abs(penalty)
                self.penalty_duration = duration
                LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (
                self.get_penalty_per_unit_time(), self.get_penalty_duration()))
        elif self.deadline_requirement == DeadlineRequirementTypeList.FIRM:
            self.penalty_per_unit_time = penalty
            self.penalty_duration = duration
            LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))
        elif self.deadline_requirement == DeadlineRequirementTypeList.SOFT:
            if penalty == Time(0):
                LOG(msg='Wrong penalty value. For soft deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
            else:
                self.penalty_per_unit_time = -abs(penalty)
                self.penalty_duration = duration
                LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (
                self.get_penalty_per_unit_time(), self.get_penalty_duration()))

#
# class RequirementsWHardDeadline(DeadlineRequirementInterface, ResourceRequirement):
#     def __init__(self, _deadline_type):
#         DeadlineRequirementInterface.__init__(self, _deadline_type)
#         ResourceRequirement.__init__(self)
#
#     def set_penalty_per_unit_time(self, duration, penalty):
#         if penalty == Time(0):
#             LOG(msg='Wrong penalty value. For hard deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
#         else:
#             self.penalty_per_unit_time = abs(penalty)
#             self.penalty_duration = duration
#             LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))
#
#
# class RequirementsWFirmDeadline(DeadlineRequirementInterface, ResourceRequirement):
#     def __init__(self, _deadline_type):
#         DeadlineRequirementInterface.__init__(self, _deadline_type)
#         ResourceRequirement.__init__(self)
#
#     def set_penalty_per_unit_time(self, duration, penalty=0):
#         self.penalty_per_unit_time = penalty
#         self.penalty_duration = duration
#         LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))
#
#
# class RequirementsWSoftDeadline(DeadlineRequirementInterface, ResourceRequirement):
#     def __init__(self, _deadline_type):
#         DeadlineRequirementInterface.__init__(self, _deadline_type)
#         ResourceRequirement.__init__(self)
#
#     def set_penalty_per_unit_time(self, duration, penalty):
#         if penalty == Time(0):
#             LOG(msg='Wrong penalty value. For soft deadline requirement, the penalty cannot be zero. Value: %d' % penalty, log=Logs.ERROR)
#         else:
#             self.penalty_per_unit_time = -abs(penalty)
#             self.penalty_duration = duration
#             LOG(msg='Deadline Penalty is set: %.2f. Duration: %.2f' % (self.get_penalty_per_unit_time(), self.get_penalty_duration()))
#
#
# class RequirementFactory:
#     TYPES = {
#         DeadlineRequirementTypeList.HARD: RequirementsWHardDeadline,
#         DeadlineRequirementTypeList.FIRM: RequirementsWFirmDeadline,
#         DeadlineRequirementTypeList.SOFT: RequirementsWSoftDeadline
#     }
#
#     def __init__(self):
#         pass
#
#     @classmethod
#     def create_instance(cls, _type):
#         if _type in cls.TYPES:
#             return cls.TYPES[_type](_type)
#         else:
#             LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
#             LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
