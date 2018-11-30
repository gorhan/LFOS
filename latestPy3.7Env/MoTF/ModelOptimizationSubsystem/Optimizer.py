
from . import ModelOptimizationInterface


class Optimizer(ModelOptimizationInterface):
    def __init__(self, ranked_confs):
        ModelOptimizationInterface.__init__(ranked_confs)

    def perform(self, **kwargs):
        pass