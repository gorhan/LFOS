
import abc


class IOStrategyInterface:
    def __init__(self, name):
        self.name = name

    @abc.abstractmethod
    def getModel(self, model):
        return model


class NewStrategy(IOStrategyInterface):
    def __init__(self, name):
        IOStrategyInterface.__init__(self, name)
