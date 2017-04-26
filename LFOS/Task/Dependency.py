from LFOS.Log import Logs, LOG
from LFOS.Scheduling.Characteristic.Time import Time


class Singleton(type):
    _instances = {}

    def __call__(cls, *args):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args)
        return cls._instances[cls]


class Logical:
    __metaclass__ = Singleton
    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class AND(Logical):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class OR(Logical):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))
class XOR(Logical):
    def __eq__(self, other):
        return isinstance(other, self.__class__) or (isinstance(other, str) and other == str(self))


class DependencyItem(object):
    def __init__(self, _token, _req, _time=Time(0)):
        self.__token = _token
        self.__n_tokens = _req
        self.__seq_dep_set_t = _time

    def set_token_type(self, new_token):
        self.__token = new_token

    def get_token_type(self):
        return self.__token

    def set_required_token_amount(self, new_req):
        self.__n_tokens = new_req

    def get_required_token_amount(self):
        return self.__n_tokens

    def set_sequence_dependent_setup_time(self, new_time):
        self.__seq_dep_set_t = new_time

    def get_sequence_dependent_setup_time(self):
        return self.__seq_dep_set_t

    def __eq__(self, other):
        return (isinstance(other, DependencyItem) and self.__token == other.__token) or (type(other) is str and self.__token == other)

    def __repr__(self):
        return '%s[%d] -- t:%.2f' % (self.__token, self.__n_tokens, self.__seq_dep_set_t)

    def __str__(self):
        return '%s[%d] -- t:%.2f' % (self.__token, self.__n_tokens, self.__seq_dep_set_t)


class Dependency:
    def __init__(self):
        self.__list = []
        self.__m_list = []
        self.__logical_relation = OR()

    def __getattr__(self, item):
        getattr(self.__list, item)()

    def add_dependency(self, relation, *p_object):
        assert isinstance(relation, Logical)
        self.__logical_relation = relation
        
        dep_item = None
        if len(p_object) == 2 or len(p_object) == 3:
            dep_item = DependencyItem(*p_object)
        elif len(p_object) == 1:
            dep_item = p_object[0]

        if dep_item not in self.__list:
            self.__list.append(dep_item)
            LOG(msg='New dependency item has been added. %s at pos=%d' % (dep_item, len(self.__list)-1))
        else:
            pos = self.__list.index(dep_item)
            self.__list[pos] = dep_item
            LOG(msg='Dependency item has been updated. %s at pos=%d' % (dep_item, pos))

        return True

    def add_m_exclusion(self, job):
        if job in self.__m_list:
            LOG(msg='Given job is already in the list of mutually exclusive jobs.')
            return False

        self.__m_list.append(job)

    def add_m_exclusion_list(self, jobs):
        for job in jobs:
            self.add_m_exclusion(job)

    def get_dependency_list(self):
        return self.__list

    def get_m_exclusion_list(self):
        return self.__m_list

    def get_required_token_number(self, token):
        try:
            pos = self.__list.index(token)
            item = self.__list[pos]
            return item.get_sequence_dependent_setup_time(), item.get_required_token_amount()
        except ValueError:
            # LOG(msg='There is no dependency related to Token %s' % token, log=Logs.ERROR)
            return Time(0), 0

    def get_required_tokens(self):
        return self.__logical_relation, [item.get_token_type() for item in self.__list]
