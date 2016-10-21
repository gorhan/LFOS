
class Credential(object):
    CREDENTIAL_COUNTER = 0

    def __init__(self, _name, _type=None):
        if not _type:
            _type = 'CR_T_%02d' % Credential.CREDENTIAL_COUNTER
            Credential.CREDENTIAL_COUNTER += 1

        self.__type = _type
        self.__name = _name
        self.__importance_levels = list()

    def set_name(self, new_name):
        self.__name = new_name

    def get_name(self):
        return self.__name

    def set_type(self, new_type):
        self.__type = new_type

    def get_type(self):
        return self.__type

    def add_importance_level(self, new_level):
        self.__type_importance.append(new_level)

    def get_importance_levels(self):
        return self.__type_importance