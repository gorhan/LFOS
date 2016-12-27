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


class ResourceRelatedCriteriaList:
    POWER_CONSUMPTION = 'ResourceRelatedCriteriaList.POWER_CONSUMPTION'
    THROUGHPUT = 'ResourceRelatedCriteriaList.THROUGHPUT'
    UTILIZATION = 'ResourceRelatedCriteriaList.UTILIZATION'


class TaskRelatedCriteriaList:
    EARLINESS = 'TaskRelatedCriteriaList.EARLINESS'
    CENTERING = 'TaskRelatedCriteriaList.CENTERING'
    LATENESS = 'TaskRelatedCriteriaList.LATENESS'
    TARDINESS = 'TaskRelatedCriteriaList.TARDINESS'
    MAKESPAN = 'TaskRelatedCriteriaList.MAKESPAN'


class ObjectiveItem:
    TYPES = [getattr(CriteriaTypeList, attr) for attr in dir(CriteriaTypeList) if attr.isupper()]

    def __new__(cls, **kwargs):
        if kwargs['type'] not in cls.TYPES:
            LOG(msg='Given parameter type is not valid.', log=Logs.ERROR)
            return None

        return super(ObjectiveItem, cls).__new__(cls, **kwargs)

    def __init__(self, **kwargs):
        self.__attrs = {}
        self.__attrs['type'] = kwargs['type']
        self.__attrs['purpose'] = kwargs['purpose'] if 'purpose' in kwargs else ObjectivePurposes.MINIMIZE
        self.__attrs['criteria'] = kwargs['criteria']
        self.__attrs['contribution'] = {'raw': kwargs['contribution'], 'norm': 0.0}
        self.__attrs['rhs'] = {}

        if 'rhs' in kwargs:
            self.__attrs['rhs'] = kwargs['rhs']

    def __getattr__(self, key):
        if key not in self.__attrs:
            LOG(msg='Invalid attribute name.', log=Logs.ERROR)
            return None

        return getattr(self.__attrs, key)

    def __repr__(self):
        return '%s --> %s %s' % (self.__attrs['type'].split('.')[-1], self.__attrs['purpose'].split('.')[-1], self.__attrs['criteria'])


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
                    identifier = self.id()
                    self.__objectives[identifier] = kwargs['item']
                    return identifier
                else:
                    LOG(msg='Given ObjectiveItem object is already in the list.', log=Logs.WARN)
            else:
                LOG(msg='Given ObjectiveItem object is invalid.', log=Logs.ERROR)
        else:
            objective = ObjectiveItem(**kwargs)
            if objective:
                identifier = self.id()
                self.__objectives[identifier] = objective
                LOG(msg='New objective has been successfully added to the list.')
                return identifier

        return None

    def id(self):
        return 'ObjectiveItemId_%02d' % len(self.__objectives)

    def pop_item(self, identifier):
        if identifier in self.__objectives:
            objective_item = self.__objectives[identifier]
            self.__objectives[identifier] = None
            LOG(msg='ObjectiveItem has been popped. Identifier=%s' % identifier)
            return objective_item

        LOG(msg='Given identifier for ObjectItem instance is not valid. Identifier=%s' % identifier)
        return None

    def normalize(self):
        sum_contributions = sum([obj.contribution['raw'] for obj in self.__objectives.values()])
        if sum_contributions == 0:
            return False

        mult_ = 1.0 / float(sum_contributions)
        for obj in self.__objectives.values():
            obj.contribution['norm'] = float(obj.contribution['raw']) * mult_
        return True

    def __iter__(self):
        for identifier, objective in self.__objectives.items():
            yield identifier, objective

    def __repr__(self):
        r_str = ''
        for id, item in self.__objectives.items():
            r_str += '%s --> %r\n' % (id, item)
        return r_str


class ResourceRelatedObjectives(Objectives):
    TYPES = [getattr(ResourceRelatedCriteriaList, attr) for attr in dir(ResourceRelatedCriteriaList) if attr.isupper()]

    def __init__(self):
        Objectives.__init__(self)

    def add_item(self, **kwargs):
        if 'item' in kwargs:
            if isinstance(kwargs['item'], ObjectiveItem):
                item = kwargs['item']
                if item.type == ObjectiveTypeList.RESOURCE_RELATED and item.criteria in ResourceRelatedObjectives.TYPES:
                    return Objectives.add_item(**kwargs)
            else:
                LOG(msg='Given ObjectiveItem object is invalid.', log=Logs.ERROR)
        else:
            if 'type' not in kwargs:
                kwargs['type'] = ObjectiveTypeList.RESOURCE_RELATED

            if kwargs['type'] == ObjectiveTypeList.RESOURCE_RELATED and kwargs['criteria'] in ResourceRelatedObjectives.TYPES:
                return Objectives.add_item(**kwargs)

        LOG(msg='Impossible to add an objective other than Resource-related objectives.', log=Logs.WARN)
        return None


class TaskRelatedObjectives(Objectives):
    TYPES = [getattr(TaskRelatedCriteriaList, attr) for attr in dir(TaskRelatedCriteriaList) if attr.isupper()]

    def __init__(self):
        Objectives.__init__(self)

    def add_item(self, **kwargs):
        if 'item' in kwargs:
            if isinstance(kwargs['item'], ObjectiveItem):
                item = kwargs['item']
                if item.type == ObjectiveTypeList.TASK_RELATED and item.criteria in TaskRelatedObjectives.TYPES:
                    return Objectives.add_item(**kwargs)
            else:
                LOG(msg='Given ObjectiveItem object is invalid.', log=Logs.ERROR)
        else:
            if kwargs['type'] == ObjectiveTypeList.TASK_RELATED and kwargs['criteria'] in TaskRelatedObjectives.TYPES:
                return Objectives.add_item(**kwargs)

        LOG(msg='Impossible to add an objective other than Task-related objectives.', log=Logs.WARN)
        return None


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