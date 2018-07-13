from ..ModelDecorator import *

import os
from importlib.util import spec_from_file_location, module_from_spec
venv = os.getenv("VIRTUAL_ENV")
moduleFile = os.path.join(venv, "FeatureModel", "__init__.py")
spec = spec_from_file_location("FeatureModel", moduleFile)
FM = module_from_spec(spec)
spec.loader.exec_module(FM)

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *


class FModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self._model = self.getModel()

    def _feature2_FeatureObject(self, _parent, group):
        self._fModelObject.add_feature(parent=_parent.name, children=[feature.name for feature in group.features],
                                       max=self.getProcessedValue(group, "upper"),
                                       min=self.getProcessedValue(group, "lower"))

        for _feature in group.features:
            self._group2_GroupObject(_feature, _feature.children)

    def _group2_GroupObject(self, _feature, _groups):
        for group in _groups:
            self._feature2_FeatureObject(_feature, group)

    def transform2FeatureModelObject(self):
        root = self._model.root

        self._fModelObject = FM.FeatureModel(root.name)
        self._group2_GroupObject(root, root.children)
        # self._fModelObject.pretty_print()

        return self._fModelObject

    def interpret(self, input=None):
        for inp in input:
            self._fmodelObject = self.transform2FeatureModelObject()

        instances = self._fModelObject.instantiate(debug=False)
        print(f"# instances={len(instances)}")
        return [instances]
