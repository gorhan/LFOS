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
        mn_val = self.getProcessedValue(group, "lower")
        mx_val = self.getProcessedValue(group, "upper")
        self._fModelObject.add_feature(parent=_parent.name, children=[feature.name for feature in group.features],
                                       max=mx_val,
                                       min=mn_val)

        print("Feature=", _parent.name, ", LOWER=", mn_val, ", UPPER=", mx_val)

        for _feature in group.features:
            self._group2_GroupObject(_feature, _feature.children)

    def _group2_GroupObject(self, _feature, _groups):
        for group in _groups:
            self._feature2_FeatureObject(_feature, group)

    def transform2FeatureModelObject(self):
        root = self._model.root

        self._fModelObject = FM.FeatureModel(root.name)
        self._group2_GroupObject(root, root.children)

    @identifier_required
    def gatherRequiredInfo(self):
        return self._instances

    def processRequiredInfo(self, info):
        print(info)

    @pointcut("after")
    def interpret(self, input=None):
        self.transform2FeatureModelObject()

        self._instances = self._fModelObject.instantiate(debug=False)
        print(f"#instances={len(self._instances)}")
        return input
