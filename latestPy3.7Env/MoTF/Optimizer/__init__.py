
from .Search import FirstOptimalResult, StopSearch, SearchStrategy, ResultsExceedingThreshold
from .. import LOG, Logs


class GlobalOptimizer:

    def __init__(self, threshold, maxNIters, search=None, _instances=[]):
        self._search = search if search and isinstance(search, SearchStrategy) else ResultsExceedingThreshold(maxNIters, threshold)
        self._instances = _instances

        self._localOptimizer = None

    def setInstances(self, instances):
        self._instances = instances

    def optimize(self, _cb):
        sorted_instances = sorted(self._instances, key=lambda item: item["fitness"])
        self._localOptimizer = LocalOptimizer(_cb)

        for instance in sorted_instances:

            fitness = instance["fitness"]
            o_instance = instance["instance"]
            try:
                schedules = self._localOptimizer.doSchedule(o_instance)
                # schedules = ""
                successResult = "SUCCESSFUL"
                if schedules:
                    schedules[0].plot_schedule(False, True)
                else:
                    successResult = "UNSUCCESSFUL"

                self._search.success(fitness, (fitness, o_instance, successResult))
            except StopSearch as s:
                return s.object
            except SystemExit:
                LOG(msg=f"Time limit exceeded!!")
                return None


class LocalOptimizer:
    def __init__(self, _cb):
        self.__cb = _cb
        self.__scheduler = None

    def doSchedule(self, instance, ):
        scheduler = self.__cb(instance)
        return scheduler.schedule_tasks()
