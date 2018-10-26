
from .Search import FirstOptimalResult, StopSearch


class GlobalOpt:
    def __init__(self, mopp, _threshold, max_iter, opt_model=None):
        self._mopp = mopp
        self._search = FirstOptimalResult(max_iter, _threshold)
        self._optimal = opt_model
        self._instances = []

    def setOptimizationModel(self, model):
        self._optimal = model

    def optimize(self):
        for instance in self._instances:
            fitness = instance.operate()

            if fitness:
                try:
                    self._search.success(fitness, instance)
                except StopSearch as s:
                    return s.object