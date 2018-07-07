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
    def __init__(self, *args):
        IO.__init__(self, *args)
        self._output = None

    def interpret(self, input=None) -> Scheduler:
        print("Invalid procedure call!", file=sys.stderr)
