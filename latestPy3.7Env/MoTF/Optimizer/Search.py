

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


class FirstOptimalResult(SearchStrategy):
    def __init__(self, *args):
        SearchStrategy.__init__(self, *args)

    @SearchStrategy.iterate
    def success(self, fitness, object):
        print("Executed when fitness value is greater than threshold")
        self._results.append(object)
        raise StopSearch(self._results)


class ResultsExceedingThreshold(SearchStrategy):
    def __init__(self, *args):
        SearchStrategy.__init__(self, *args)

    @SearchStrategy.iterate
    def success(self, fitness, object):
        print("Executed when fitness value is greater than threshold")
        self._results.append(object)