from .Models.Platform import *


class Transform:
    def __init__(self, **kwargs):
        self._inputs = kwargs['inputs'] if 'inputs' in kwargs else []
        self._outputs = kwargs['output'] if 'output' in kwargs else []

    def addModel(self, model: Model):
        self._inputs.append(model)

    def getModels(self):
        return self._inputs

    def postProcess(self, schedulers):
        return schedulers

    def iterateModels(self):
        for model in self._inputs:
            for output in self._outputs:
                schedulers = model.interpret(self.output)

        self.postProcess(self._outputs)