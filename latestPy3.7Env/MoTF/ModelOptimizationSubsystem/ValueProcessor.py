
from . import ModelOptimizationInterface

import numpy as np


class FNP(ModelOptimizationInterface):
    def __init__(self, fitness_data):
        ModelOptimizationInterface.__init__(self, fitness_data)

        self.__ninstances = len(self._input_data)
        self.__nfitnesses = len(self._input_data[0]["fitness"])

        self.__fitnesses = None
        self.__instance_indexes = np.arange(self.__ninstances)

        self.__filtering_opts = {}
        self.__priorities = [1.0] * self.__nfitnesses

    def __setConstraint(self, index, key, value):
        if index in self.__filtering_opts:
            self.__filtering_opts[index].append((key, value))
        else:
            self.__filtering_opts[index] = [(key, value)]

    def setLowerBound(self, index, value):
        self.__setConstraint(index, "LB", value)

    def setUpperBound(self, index, value):
        self.__setConstraint(index, "UB", value)

    def setPriorities(self, *args):
        if len(args) == self.__nfitnesses:
            self.__priorities = args

    def _pre_perform(self):
        self.__fitnesses = np.zeros((self.__ninstances, self.__nfitnesses))
        self.__fitnesses.dtype = np.float

        for x_ind in range(self.__ninstances):
            self.__fitnesses[x_ind] = self._input_data[x_ind]["fitness"]

    def _post_perform(self):
        self._output_data = []

        for fitness_index, instance_index in enumerate(self.__instance_indexes):
            instance = self._input_data[instance_index]["data"]
            fitness = self.__fitnesses[fitness_index]
            self._output_data.append({"data": instance, "fitness": fitness})

    def _filter(self, index):
        if index not in self.__filtering_opts:
            return True
        conds = self.__filtering_opts[index]

        valid_indexes = np.arange(self.__ninstances)
        if conds:
            for cond in conds:
                if cond[0] == "LB":
                    valid_indexes = np.where(self.__fitnesses[valid_indexes, index] >= cond[1])
                elif cond[0] == "UB":
                    valid_indexes = np.where(self.__fitnesses[valid_indexes, index] <= cond[1])

            self.__fitnesses = self.__fitnesses[valid_indexes, :]
            self.__instance_indexes = valid_indexes
            self.__ninstances = len(self.__fitnesses)

    def _normalize(self):
        maxs, mins = self.__fitnesses.max(0), self.__fitnesses.min(0)
        self.__fitnesses = (self.__fitnesses - mins) / (maxs - mins)

    def _prioritize(self):
        self.__fitnesses = np.dot(self.__fitnesses, np.array(self.__priorities))

    def perform(self, **kwargs):
        self._pre_perform()

        for index in range(self.__nfitnesses):
            self._filter(index)

        self._normalize()
        self._prioritize()
        self._post_perform()

        return self._output_data


class RankStrategy:
    def __init__(self):
        pass

    def rank(self, lst):
        NotImplemented("The operation has not been implemented!!")


class AscendingOrder(RankStrategy):
    def __init__(self):
        RankStrategy.__init__(self)

    def rank(self, lst):
        return sorted(lst, key=lambda dct: dct["fitness"])


class DescendingOrder(RankStrategy):
    def __init__(self):
        RankStrategy.__init__(self)

    def rank(self, lst):
        return sorted(lst, key=lambda dct: dct["fitness"], reverse=True)


class Ranker(ModelOptimizationInterface):
    OPTIONS = {"ascending": AscendingOrder,
               "descending": DescendingOrder}

    def __init__(self, conf_fitness_data, _strategy=None):
        ModelOptimizationInterface.__init__(self, conf_fitness_data)

        self.__rank_strategy = Ranker.OPTIONS[_strategy]() if _strategy and isinstance(_strategy, str) else AscendingOrder()

    def perform(self, **kwargs):
        if "ranking_strategy" in kwargs:
            if kwargs["ranking_strategy"].lower() in Ranker.OPTIONS:
                self.__rank_strategy = Ranker.OPTIONS[kwargs["ranking_strategy"]]()

        return self.__rank_strategy.rank(self._input_data)


class ValueProcessor(ModelOptimizationInterface):
    def __init__(self, conf_values):
        ModelOptimizationInterface.__init__(self, conf_values)

    def perform(self, **kwargs):
        conf_value = FNP(self._input_data).perform(**kwargs)
        ranked_confs = Ranker(conf_value).perform(**kwargs)
        return ranked_confs
