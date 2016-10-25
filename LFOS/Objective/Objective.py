from LFOS.Log import LOG, Logs


class ObjectivePurposes:
    MINIMIZE = 'ObjectivePurposes.MIN'
    MAXIMIZE = 'ObjectivePurposes.MAX'

class ParameterTypes:
    FUNCTION = 'ParameterTypes.FUNC'
    CONSTANT = 'ParameterTypes.CONS'


class Parameter:
    def __new__(cls, **kwargs):
        if kwargs['type'] != ParameterTypes.CONSTANT and kwargs['type'] != ParameterTypes.FUNCTION:
            LOG(msg='Given parameter type is not valid.', log=Logs.ERROR)
            return None

        return super(Parameter, cls).__new__(cls, **kwargs)

    def __init__(self, **kwargs):
        self.__type = kwargs['type']
        self.__rhs = kwargs['rhs']
        if 'kwargs' not in kwargs:
            self.__kwargs = {}
        else:
            self.__kwargs = kwargs['kwargs']

    def eval(self):
        if self.__type == ParameterTypes.FUNCTION:
            return self.__rhs(**self.__kwargs)
        else:
            return self.__rhs

    def get_type(self):
        return self.__type

    def get_kwargs(self):
        return self.__kwargs


class ObjectiveInterface(dict):
    def __init__(self):
        dict.__init__({})

        self.__purpose = ObjectivePurposes.MINIMIZE

    def set_purpose(self, new_purpose):
        if new_purpose == ObjectivePurposes.MINIMIZE or new_purpose == ObjectivePurposes.MAXIMIZE:
            self.__purpose = new_purpose
            LOG(msg='New purpose for objective is %s' % self.__purpose)
            return True

        LOG(msg='New purpose is not valid.', log=Logs.ERROR)
        return False

    def get_purpose(self):
        return self.__purpose

    def add_parameter(self, **kwargs):
        parameter = Parameter(**kwargs)
        if parameter:
            self[kwargs['name']] = parameter
            return True

        return parameter

    def evaluate_parameters(self):
        return sum(value.eval() for param_name, value in self.items())

    def evaluate_parameter(self, param_name):
        return self[param_name].eval()

    def __repr__(self):
        return '%s --> %s' % (self.__purpose.split('.')[-1], ' + '.join([name if param.get_type() == ParameterTypes.CONSTANT else '%s(kwargs=%r)' % (name, param.get_kwargs()) for name, param in self.items()]))
