from ..ModelDecorator import *

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


PurposeLiterals = None


class Criteria:
    def __init__(self, name, default, purpose, coefficient):
        self.name = name

        self._default = default
        self._purpose = purpose
        self._coefficient = coefficient
        self._features = []

    def add_feature(self, feature, value):
        if feature not in self._features:
            self._features.append({"feature": feature, "contrib": value, "cooccurrences":[]})

    def get(self, feature_name):
        for item in self._features:
            if item["feature"].name == feature_name:
                return item["feature"]

        return None

    def add_cooccurrences(self, feature, value, *others):
        item = self.get(feature.name)
        if item:
            item["cooccurrences"].append({"contrib":value, "features":others})
            return True

        return False

    def pretty_print(self):
        print(f"Default={self._default}")
        print(f"Purpose={self._purpose}")
        print(f"Coefficient={self._coefficient}")
        print("Features:")
        for item in self._features:
            print(f"\tFeature Name={item['feature'].name}")
            print(f"\tOptimization Value={item['contrib']}")
            print("\tCo-occurrent Features:")
            for cooc in item["cooccurrences"]:
                print(f"\t\tOptimization Effect={cooc['contrib']}")
                print(f"\t\tRelevant Features: {', '.join([feature.name for feature in cooc['features']])}")
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
                             self.getProcessedValue(cri, "default"),
                             self.getProcessedValue(cri, "purpose"),
                             self.getProcessedValue(cri, "contribution"))

            for feature in self.getProcessedValue(cri, "features"):

                cri_o.add_feature(feature, self.getProcessedValue(feature, "value"))
                if hasattr(feature, "cooccurrences") and feature.cooccurrences:
                    for cooc in feature.cooccurrences:
                        cri_o.add_cooccurrences(feature,
                                                self.getProcessedValue(cooc, "value"),
                                                *self.getProcessedValue(cooc, "features"))

            self._criteria.append(cri_o)

    def pretty_print(self):
        for ind, cri in enumerate(self._criteria):
            print(f"{'#'*10} Criteria-{ind+1:02d} --> {cri.name} {'#'*10}")
            cri.pretty_print()
            print(f"{'#'*60}", end="\n\n")

    def processRequiredInfo(self, info):
        self._instances = info

    @pointcut("before")
    def interpret(self, input=None):
        self.define_criteria()
        self.pretty_print()
        return input
