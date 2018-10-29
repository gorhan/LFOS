
from ..Models.Optimization import Optimization
from .Search import FirstOptimalResult, StopSearch, SearchStrategy
from .. import LOG, Logs


class GlobalOptimizer:
    def __init__(self, optModel, threshold, maxNIters, search=None, _instances=[]):
        self._optimalM = optModel
        self._search = search if search and isinstance(search, SearchStrategy) else FirstOptimalResult(maxNIters, threshold)
        self._instances = self.assignFitnesses(_instances)

        self._localOptimizer = None

    def setOptimizationModel(self, model):
        if isinstance(model, Optimization):
            self._optimalM = model
            LOG(msg=f"New Search Strategy is set.")
        LOG(msg=f"Invalid set option for optimization model!", log=Logs.ERROR)

    def setInstances(self, instances):
        self._instances = self.assignFitnesses(instances)

    def assignFitnesses(self, instances):
        _instances = []
        for instance in self._instances:
            _instances.append({"instance": instance, "fitness": self._optimalM.evaluate(instance)})

        return _instances

    def optimize(self):
        sorted_instances = sorted(self._instances, key=lambda item: item["fitness"])
        for instance in sorted_instances:

            fitness = instance["fitness"]
            try:
                self._search.success(fitness, instance)
            except StopSearch as s:
                return s.object


class LocalOptimizer:
    def __init__(self, scheduler):