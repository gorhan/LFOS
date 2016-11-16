from LFOS.Log import Logs, LOG


class DependencyItem(object):
    def __init__(self, _token, _req, _time=0.0):
        self.__token = _token
        self.__n_tokens = _req
        self.__seq_dep_set_t = _time

    def set_token(self, new_token):
        self.__token = new_token

    def get_token(self):
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
        return isinstance(other, DependencyItem) and self.__token == other.__token

    def __repr__(self):
        return '%s[%d] -- t:%.2f' % (self.__token, self.__n_tokens, self.__seq_dep_set_t)

    def __str__(self):
        return '%s[%d] -- t:%.2f' % (self.__token, self.__n_tokens, self.__seq_dep_set_t)


class Dependency(list):
    def __init__(self):
        list.__init__([])

    def add_dependency(self, p_object):
        if not isinstance(p_object, DependencyItem):
            LOG(msg='Given parameter is not in the type of DependencyItem', log=Logs.ERROR)
            return False

        if p_object not in self:
            super(Dependency, self).append(p_object)
        else:
            pos = self.index(p_object)
            self[pos] = p_object

        return True

    def get_dependency_list(self):
        return self
