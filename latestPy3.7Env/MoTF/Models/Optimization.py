from ..ModelDecorator import *

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


PurposeLiterals = None


class Criteria:
    def __init__(self, name, purpose, default, coefficient):
        self.name = name

        self._default = default
        self._purpose = purpose
        self._coefficient = coefficient
        self._single_features = []
        self._multip_features = []

    def add_feature(self, feature, value):
        if feature not in self._single_features:
            self._single_features.append({"feature": feature, "contrib": value})

    def get_multiple_features(self):
        features = []
        for item in self._multip_features:
            features.append(([feature.name for feature in item["features"]], item["contrib"]))

        return features

    def get_single_features(self):
        return [(item["feature"].name, item["contrib"]) for item in self._single_features]

    def add_cooccurrences(self, value, *others):
        self._multip_features.append({"features": others, "contrib": value})

    def pretty_print(self):
        print(f"Default={self._default}")
        print(f"Purpose={self._purpose}")
        print(f"Coefficient={self._coefficient}")
        print("Single Features:")
        for item in self._single_features:
            print(f"\tFeature Name={item['feature'].name}")
            print(f"\tOptimization Value={item['contrib']}")

        print("\tMultiple Features:")
        for item in self._single_features:
            print(f"\t\tOptimization Effect={item['contrib']}")
            print(f"\t\tRelevant Features: {', '.join([feature.name for feature in item['features']])}")
        print("-"*60)


class Optimization(Model):
    def __init__(self, *args):
        global PurposeLiterals
        Model.__init__(self, *args)
        PurposeLiterals = self.getMetaModel().getEClassifier('Purpose').eContents

        self._model = self.getModel()
        self._criteria = []

    def define_criteria(self):

        for cri in self._model.criteria:
            cri_o = Criteria(self.getProcessedValue(cri, "name"),
                             self.getProcessedValue(cri, "purpose"),
                             self.getProcessedValue(cri, "default"),
                             self.getProcessedValue(cri, "percentage"))
            self._criteria.append(cri_o)

            for utility in self.getProcessedValue(cri, "singleutility"):
                cri_o.add_feature(self.getProcessedValue(utility, "points"), self.getProcessedValue(utility, "contribution"))

            for utility in self.getProcessedValue(cri, "multiutility"):
                cri_o.add_cooccurrences(self.getProcessedValue(utility, "contribution"),
                                        *self.getProcessedValue(utility, "features"))

            self._criteria.append(cri_o)

    def pretty_print(self):
        for ind, cri in enumerate(self._criteria):
            print(f"{'#'*10} Criteria-{ind+1:02d} --> {cri.name} {'#'*10}")
            cri.pretty_print()
            print(f"{'#'*60}", end="\n\n")

    def evaluate(self, instance):
        global PurposeLiterals

        if not self.interpreted():
            self.interpret()

        fitness = 0.0
        for criteria in self._criteria:
            criteria_sign = 1
            perc = criteria._coefficient

            multiple_features = criteria.get_multiple_features()
            for features, contribution in multiple_features:
                if not set(features).difference(set(instance)):
                    prev_fitness = fitness
                    fitness += perc * criteria_sign * contribution
                    LOG(msg=f"Instances={instance}, Multiple Features={features}, Previous Fitness={prev_fitness}, Next Fitness={fitness}")

            single_features = criteria.get_single_features()
            for feature, contribution in single_features:
                if feature in instance:
                    prev_fitness = fitness
                    fitness += perc * criteria_sign * contribution
                    LOG(msg=f"Instances={instance}, Single Feature={feature}, Previous Fitness={prev_fitness}, Next Fitness={fitness}")

        return fitness

    @pointcut("before")
    def interpret(self, input=None):
        self.define_criteria()
        self.pretty_print()
        return input
