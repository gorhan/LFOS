from LFOS.Log import LOG, Logs


class ObjectivePurposes:
    MINIMIZE = 'ObjectivePurposes.MINIMIZE'
    MAXIMIZE = 'ObjectivePurposes.MAXIMIZE'


class CriteriaTypeList:
    DEFAULT = 'CriteriaTypeList.DEFAULT'
    USER_DEF = 'CriteriaTypeList.USER_DEF'


class ObjectiveTypeList:
    RESOURCE_RELATED = 'ObjectiveTypeList.RESOURCE_RELATED'
    TASK_RELATED = 'ObjectiveTypeList.TASK_RELATED'
    ABSTRACT = 'ObjectiveTypeList.ABSTRACT'


class ResourceRelatedObjectiveCriteria:
    POWER_CONSUMPTION = 'ResourceRelatedObjectiveCriteria.POWER_CONSUMPTION'
    THROUGHPUT = 'ResourceRelatedObjectiveCriteria.THROUGHPUT'
    UTILIZATION = 'ResourceRelatedObjectiveCriteria.UTILIZATION'


class TaskRelatedObjectiveCriteria:
    EARLINESS = 'TaskRelatedObjectiveCriteria.EARLINESS'
    CENTERING = 'TaskRelatedObjectiveCriteria.CENTERING'
    LATENESS = 'TaskRelatedObjectiveCriteria.LATENESS'
    TARDINESS = 'TaskRelatedObjectiveCriteria.TARDINESS'
    MAKESPAN = 'TaskRelatedObjectiveCriteria.MAKESPAN'


class ObjectiveItem:
    TYPES = [getattr(CriteriaTypeList, attr) for attr in dir(CriteriaTypeList) if attr.isupper()]

    def __new__(cls, **kwargs):
        if kwargs['type'] not in cls.TYPES:
            LOG(msg='Given parameter type is not valid.', log=Logs.ERROR)
            return None

        return super(ObjectiveItem, cls).__new__(cls, **kwargs)

    def __init__(self, **kwargs):
        self.__type = kwargs['type']
        self.__purpose = kwargs['purpose'] if 'purpose' in kwargs else ObjectivePurposes.MINIMIZE
        self.__criteria = kwargs['criteria']
        self.__rhs = {}

        if 'rhs' in kwargs:
            self.__rhs = kwargs['rhs']

    def get_type(self):
        return self.__type

    def __repr__(self):
        return '%s --> %s %s' % (self.__type.split('.')[-1], self.__purpose.split('.')[-1], self.__criteria)


class Objectives:
    def __init__(self):
        self.__objectives = {}

    # def set_purpose(self, new_purpose):
    #     if new_purpose == ObjectivePurposes.MINIMIZE or new_purpose == ObjectivePurposes.MAXIMIZE:
    #         self.__purpose = new_purpose
    #         LOG(msg='New purpose for objective is %s' % self.__purpose)
    #         return True
    #
    #     LOG(msg='New purpose is not valid.', log=Logs.ERROR)
    #     return False
    #
    # def get_purpose(self):
    #     return self.__purpose

    def add_item(self, **kwargs):
        if 'item' in kwargs:
            if isinstance(kwargs['item'], ObjectiveItem):
                if kwargs['item'] not in self.__objectives:
                    identifier = 'ObjectiveItemId_%02d' % len(self.__objectives)
                    self.__objectives[identifier](kwargs['item'])
                    return identifier
                else:
                    LOG(msg='Given ObjectiveItem object is already in the list.', log=Logs.WARN)
            else:
                LOG(msg='Given ObjectiveItem object is invalid.', log=Logs.ERROR)
        else:
            objective = ObjectiveItem(**kwargs)
            if objective:
                identifier = 'ObjectiveItemId_%03d' % len(self.__objectives)
                self.__objectives[identifier](objective)
                LOG(msg='New objective has been successfuly added to the list.')
                return True

        return None

    def pop_item(self, identifier):
        if identifier in self.__objectives:
            objective_item = self.__objectives[identifier]
            self.__objectives[identifier] = None
            LOG(msg='ObjectiveItem has been popped. Identifier=%s' % identifier)
            return objective_item

        LOG(msg='Given identifier for ObjectItem instance is not valid. Identifier=%s' % identifier)
        return None

    def __repr__(self):
        r_str = ''
        for id, item in self.__objectives.items():
            r_str += '%s --> %r\n' % (id, item)
        return r_str


class ResourceRelatedObjectives(Objectives):
    def __init__(self):
        Objectives.__init__(self)


class TaskRelatedObjectives(Objectives):
    def __init__(self):
        Objectives.__init__(self)

class AbstractObjectives(Objectives):
    def __init__(self):
        Objectives.__init__(self)


class ObjectiveFactory:
    TYPES = {
        ObjectiveTypeList.RESOURCE_RELATED: ResourceRelatedObjectives,
        ObjectiveTypeList.TASK_RELATED: TaskRelatedObjectives,
        ObjectiveTypeList.ABSTRACT: AbstractObjectives
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