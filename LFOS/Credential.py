from LFOS.Log import LOG, Logs


class Credential(object):
    def __init__(self, **kwargs):
        self.__cred_table = {}

        for key, value in kwargs.items():
            self.__cred_table[key] = value

    def areyou(self, **kwargs):
        for key, value in kwargs.items():
            if key not in self.__cred_table:
                return False
            if value != self.__cred_table[key]:
                return False

        return True

    def add_attrs(self, **kwargs):
        self.__cred_table = dict(self.__cred_table, **kwargs)

    def get_attr(self, key):
        try:
            return self.__cred_table[key]
        except KeyError as err:
            LOG(msg=err.message, log=Logs.ERROR)
            return None

    def __getattr__(self, item):
        if item in self.__cred_table:
            return self.__cred_table[item]

        raise AttributeError('%s object has no attribute named %r' % (self.__class__, item))

    def del_attr(self, key):
        try:
            return self.__cred_table.pop(key)
        except KeyError as err:
            LOG(msg=err.message, log=Logs.ERROR)
            return None

    def get_attr_keys(self):
        return self.__cred_table.keys()

    def introduce(self):
        return '{' + ', '.join('%s=%r' % (key, value) for key, value in self.__cred_table.items()) + '}'
