
from . import ModelOptimizationInterface

from .. import Logs, LOG

class Error(Exception):
    def __init__(self, msg, obj=None):
        self.message = msg
        self.object = obj


class StopSearch(Error):
    def __init__(self, object):
        Error.__init__(self, msg="Termination with Success!!!", obj=object)


class SearchStrategy:
    def __init__(self, n_iter, threshold=0):
        self._threshold = threshold
        self._n_iteration = n_iter
        self._curr_iter = 0
        self._results = []
        self._terminated = False

    @property
    def threshold(self):
        return self._threshold

    @threshold.setter
    def threshold(self, n_thres):
        self._threshold = n_thres

    def iterate(f):
        def wrapper(me, fitness, object):
            print(f"Terminated={me.terminated()}, Fitness={fitness} - Threshold={me._threshold}")
            if fitness <= me._threshold:
                f(me, fitness, object)

            me._curr_iter += 1
            if me._curr_iter >= me._n_iteration:
                me._terminated = True
                raise StopSearch(me._results)

            return True
        return wrapper

    def terminated(self):
        return self._terminated

    def success(self, fitness, object):
        raise NotImplementedError("The function MUST be implemented inside the derived class.")


class FirstFitSearch(SearchStrategy):
    def __init__(self, *args):
        SearchStrategy.__init__(self, *args)

    @SearchStrategy.iterate
    def success(self, fitness, object):
        print("Executed when fitness value is greater than threshold")
        self._results.append(object)
        raise StopSearch(self._results)


class NthFitSearch(SearchStrategy):
    def __init__(self, *args):
        SearchStrategy.__init__(self, *args)

    @SearchStrategy.iterate
    def success(self, fitness, object):
        print("Executed when fitness value is greater than threshold")
        self._results.append(object)


class GlobalOptimizer(ModelOptimizationInterface):
    SEARCH_OPTS = {"first-fit": FirstFitSearch,
                   "Nth-fit": NthFitSearch}

    def __init__(self, _instances):
        ModelOptimizationInterface.__init__(self, _instances)
        self._search = NthFitSearch(10, 100)
        self._instances = _instances

        self._localOptimizer = None

    def setInstances(self, instances):
        self._input_data = instances

    def perform(self, **kwargs):
        self._localOptimizer = LocalOptimizer(kwargs["callback"])
        if "search" in kwargs and isinstance(kwargs["search"]) and isinstance(kwargs["search"][0], str) and \
            len(kwargs["search"]) == 3 and kwargs["search"].lower() in GlobalOptimizer.SEARCH_OPTS:
            self._search = GlobalOptimizer.SEARCH_OPTS[kwargs["search"]](*kwargs["search"][1:])

        for instance in self._input_data:
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

    def doSchedule(self, instance):
        scheduler = self.__cb(instance)
        return scheduler.schedule_tasks()


class Optimizer(ModelOptimizationInterface):
    def __init__(self, ranked_confs):
        ModelOptimizationInterface.__init__(ranked_confs)

    def perform(self, **kwargs):
        optimal_model = GlobalOptimizer(self._input_data).perform(**kwargs)
        return optimal_model