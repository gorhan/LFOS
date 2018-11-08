import sys, os
pyEnv = os.getenv("LFOS_DIR")
if pyEnv:
    sys.path.insert(0, pyEnv)

import abc
from ..IO import *
from LFOS.Scheduler.Scheduler import Scheduler


from .. import Logs,LOG


def pointcut(fn):
    def decorator(self, *args):
        return_val = fn(self, *args)
        getattr(self, "markInterpreted").__call__()
        return return_val
    return decorator


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
    __ALL__ = []

    @classmethod
    def generateID(cls, object):
        cls_name = object.__class__.__name__
        index = 0
        for elem in cls.__ALL__:
            if elem["object"] == object:
                LOG(msg=f"The object of Class {cls_name} has been already registered!!")
                return False

            if elem["class"] == cls_name:
                index += 1

        return {"class": cls_name, "index": index, "object": object}

    def register(self, object):
        Model.__ALL__.append(Model.generateID(object))

    def ID(self):
        for elem in Model.__ALL__:
            if elem["object"] == self:
                return elem["class"], elem["index"]

    def __init__(self, *args):
        if len(args) > 2:
            IO.__init__(self, *args[-2:])
        else:
            IO.__init__(self, *args[-2:])

        # print(f'Derived Class Name = {self.__class__.__name__}')
        # print(f'__ALL__ =', Model.__ALL__)
        self.register(self)

        self._output = None
        self._cls = None
        self._args = None
        self._interpreted = False

    def getRegisteredModel(self, _id):
        return Model.__ALL__[_id]

    def createInputTemplate(self):
        return self._cls(**self._args)

    def markInterpreted(self):
        self._interpreted = True
        LOG(msg=f"The model {self.__class__.__name__} has been interpreted!!")

    def interpreted(self):
        return self._interpreted

    def gatherRequiredInfo(self):
        raise NotImplementedError("Invalid procedure call!")

    def processRequiredInfo(self, info):
        raise NotImplementedError("Invalid procedure call!")

    @pointcut
    def interpret(self, input) -> Scheduler:
        raise NotImplementedError("Invalid procedure call!")

    def setInputTemplate(self, cls, args):
        self._cls = cls
        self._args = args
