import sys, os
pyEnv = os.getenv("LFOS_DIR")
if pyEnv:
    sys.path.insert(0, pyEnv)

import abc
from ..IO import *
from LFOS.Scheduler.Scheduler import Scheduler


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

    def register(self, object):
        key = Model.generateID()
        while key in Model.__ALL__:
            key = Model.generateID()
        Model.__ALL__[key] = object

    def __init__(self, *args):
        IO.__init__(self, *args)

        # print(f'Derived Class Name = {self.__class__.__name__}')
        # print(f'__ALL__ =', Model.__ALL__)
        self.register(self)
        self._output = None

    def interpret(self, input=None) -> Scheduler:
        print("Invalid procedure call!", file=sys.stderr)
