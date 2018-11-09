from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

from .. import LOG, Logs

PurposeLiterals = None


class Criteria:
    def __init__(self, name, purpose, default, coefficient):
        self.name = name

        self._default = default
        self._purpose = purpose
        self._coefficient = coefficient
        self._single_features = []
        self._multip_features = []

    def add_feature(self, feature, bound_value, unbound_value):
        if feature not in self._single_features:
            self._single_features.append({"feature": feature, "bound": bound_value, "unbound": unbound_value})

    def get_multiple_features(self):
        features = []
        for item in self._multip_features:
            features.append(([feature.name for feature in item["features"]], item["contrib"]))

        return features

    def getBasicValue(self):
        return self._default

    def get_single_features(self):
        return [(item["feature"].name, item["bound"], item['unbound']) for item in self._single_features]

    def add_cooccurrences(self, value, *others):
        self._multip_features.append({"features": others, "contrib": value})

    def pretty_print(self):
        print(f"Default={self._default}")
        print(f"Purpose={self._purpose}")
        print(f"Coefficient={self._coefficient}")
        print("Single Features:")
        for item in self._single_features:
            print(f"\tFeature Name={item['feature'].name}")
            print(f"\tOptimization Value: IN={item['bound']} OUT={item['unbound']}")

        print("\tMultiple Features:")
        for item in self._multip_features:
            print(f"\t\tOptimization Effect={item['contrib']}")
            print(f"\t\tRelevant Features: {', '.join([feature.name for feature in item['features']])}")
        print("-"*60)


class OptimizationModel(Model):
    def __init__(self, *args):
        global PurposeLiterals
        Model.__init__(self, *args)
        PurposeLiterals = self.getMetaModel().getEClassifier('Purpose').eContents

        self._model = self.getModel()
        self._features = [feature.name for feature in self._model.features]
        self._criteria = []
        self._input_data = None
        self._output_data = []

    def define_criteria(self):

        for cri in self._model.criteria:

            LOG(msg=f"{cri.name} {cri.purpose} {cri.default} {cri.percentage}")
            cri_o = Criteria(self.getProcessedValue(cri, "name"),
                             self.getProcessedValue(cri, "purpose"),
                             self.getProcessedValue(cri, "default"),
                             self.getProcessedValue(cri, "percentage"))

            for utility in self.getProcessedValue(cri, "singleutility"):
                cri_o.add_feature(self.getProcessedValue(utility, "points"), self.getProcessedValue(utility, "bound"), self.getProcessedValue(utility, "unbound"))

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

        # LOG(msg=f"Instances={', '.join([feature.name for feature in instance])}")
        instance_names = [feature.name for feature in instance]
        fitness = 0.0
        for criteria in self._criteria:
            criteria_sign = 1
            perc = criteria._coefficient

            single_features = criteria.get_single_features()
            for feature, bound, unbound in single_features:
                prev_fitness = fitness
                contribution = unbound

                if feature in instance_names:
                    fitness += perc * criteria_sign * bound

                fitness += perc * criteria_sign * contribution


            multiple_features = criteria.get_multiple_features()
            for features, contribution in multiple_features:
                if not set(features).difference(set(instance_names)):
                    prev_fitness = fitness
                    fitness += perc * criteria_sign * contribution
                    # LOG(msg=f"Multiple Features={features}, Previous Fitness={prev_fitness}, Next Fitness={fitness}")

                    # LOG(msg=f"Single Feature={feature}, Previous Fitness={prev_fitness}, Next Fitness={fitness}")


        return fitness

    def calculate_fitness_values(self):
        for instance in self._input_data:
            fitness = self.evaluate(instance)
            self._output_data.append({"instance": instance, "fitness": fitness})
            # LOG(msg=f"Instance = {[feature.name for feature in instance]} --> Fitness = {fitness}")

    def interpret(self, input):
        self._input_data = input[("ProcessModel", 0)][1]
        self.define_criteria()
        self.pretty_print()
        self.calculate_fitness_values()
        input.append(MoPP_D(*self.ID(), self._output_data))
        return input
