import sys, os
pyEnv = os.getenv("LFOS_DIR")
if pyEnv:
    sys.path.insert(0, pyEnv)

import abc
from ..IO import *
from LFOS.Scheduler.Scheduler import Scheduler


def pointcut(pos):
    def wrapper(fn):
        def decorator(self, *args):
            if pos == "before":
                for req in self._required_models:
                    self.processRequiredInfo(req.gatherRequiredInfo())
            return_val = fn(self, *args)
            if pos == "after":
                for req in self._required_models:
                    self.processRequiredInfo(req.gatherRequiredInfo())
            return return_val
        return decorator
    return wrapper


def identifier_required(fn):
    def wrapper(self, *args):
        cls_name = self.__class__.__name__
        print("WRAPPER", cls_name, args)
        return cls_name, fn(self, *args)
    return wrapper


class ModelDecorator(metaclass=abc.ABCMeta):
    """
        Decorator class utilizing decorator pattern to initialize input models and modify scheduler(s).
    """

    def __init__(self, *args):
        pass

    @abc.abstractmethod
    def interpret(self, input: Scheduler=None) -> Scheduler:
        print("Invalid procedure call!", file=sys.stderr)


class Model(IO, ModelDecorator):
    __ALL__ = {}

    @classmethod
    def generateID(cls, _len: int = 3):
        from random import choice
        from string import ascii_letters, digits
        return ''.join(choice(ascii_letters + digits) for _ in range(_len))

    def ID(self):
        for key, decorator in Model.__ALL__.items():
            if self == decorator:
                return key

        return None

    def register(self, object):
        key = Model.generateID()
        while key in Model.__ALL__:
            key = Model.generateID()
        Model.__ALL__[key] = object

    def __init__(self, *args):
        if len(args) > 2:
            IO.__init__(self, *args[-2:])
        else:
            IO.__init__(self, *args[-2:])

        # print(f'Derived Class Name = {self.__class__.__name__}')
        # print(f'__ALL__ =', Model.__ALL__)
        self.register(self)

        self._required_models = []
        self._output = None
        self._cls = None
        self._args = None

    def createInputTemplate(self):
        return self._cls(**self._args)

    def requires(self, model):
        self._required_models.append(Model.__ALL__[model.ID()])

    def gatherRequiredInfo(self):
        raise NotImplementedError("Invalid procedure call!")

    def processRequiredInfo(self, info):
        raise NotImplementedError("Invalid procedure call!")

    def interpret(self, input=None) -> Scheduler:
        raise NotImplementedError("Invalid procedure call!")

    def setInputTemplate(self, cls, args):
        self._cls = cls
        self._args = args
