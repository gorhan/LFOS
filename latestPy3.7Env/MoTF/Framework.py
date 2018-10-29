
from .ModelProcPipeline import MoPP
from .Optimizer import GlobalOptimizer, LocalOptimizer

class OptMLFramework:
    def __init__(self, mopp, globOpt):
        self.__mopp = mopp
        self.__optimizer = globOpt

    def