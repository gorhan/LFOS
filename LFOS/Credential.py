from LFOS.Log import LOG, Logs


class Credential():
    def __init__(self, **kwargs):

        for key, value in kwargs.items():
            self.__dict__[key] = value

    def areyou(self, **kwargs):
        for key, value in kwargs.items():
            if key not in self.__dict__:
                return False
            if value != self.__dict__[key]:
                return False

        return True

    def add_attrs(self, **kwargs):
        self.__dict__ = dict(self.__dict__, **kwargs)

    def get_attr(self, key):
        try:
            return self.__dict__[key]
        except KeyError as err:
            LOG(msg=err.message, log=Logs.ERROR)
            return None

#   def __getattribute__(self, item):
#        if item in self:
#            return self.__dict__.get(item, None)
#
#        raise AttributeError('%s object has no attribute named %r' % (self.__class__, item))

    def del_attr(self, key):
        try:
            return self.__dict__.pop(key)
        except KeyError as err:
            LOG(msg=err.message, log=Logs.ERROR)
            return None

    def get_attr_keys(self):
        return self.__dict__.keys()

    def introduce(self):
        return '{' + ', '.join('%s=%r' % (key, value) for key, value in self.__dict__.items()) + '}'
