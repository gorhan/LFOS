
from .Search import FirstOptimalResult, StopSearch


class GlobalOpt:
    def __init__(self, _instances, _threshold):
        self._instances = _instances
        self._search = FirstOptimalResult(len(_instances), _threshold)

    def optimize(self):
        for instance in self._instances:
            fitness = instance.operate()

            if fitness:
                try:
                    self._search.success(fitness, instance)
                except StopSearch as s:
                    if s.object:
                        return s.object