from . import ModelOptimizationInterface

from .Adapter import Adapter
from .ValueProcessor import ValueProcessor
from .Optimizer import Optimizer


class ModelOptimization(ModelOptimizationInterface):
    def __init__(self, pipeline_data=[]):
        ModelOptimizationInterface.__init__(self, pipeline_data)

    def setPipelineData(self, _data):
        self._input_data = _data

    def perform(self, **kwargs):
        adapter_data = Adapter(self._input_data).perform(**kwargs)
        value_processor_data = ValueProcessor(adapter_data).perform(**kwargs)
        optimal_model = Optimizer(value_processor_data).perform(**kwargs)
        return optimal_model