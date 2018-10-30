
from .ModelProcPipeline import MoPP
from .Optimizer import GlobalOptimizer, LocalOptimizer
from . import LOG, Logs

class OptMLFramework:
    PROCESS_MODEL_ID = None
    PROCESS_MODEL_CB = None

    @classmethod
    def registerProcessModel(cls, model_id, model_cb):
        cls.PROCESS_MODEL_ID = model_id
        cls.PROCESS_MODEL_CB = model_cb

    @classmethod
    def getProcessModelCallback(cls):
        return cls.PROCESS_MODEL_ID, cls.PROCESS_MODEL_CB

    def __init__(self, mopp, globOpt):
        self.__mopp = mopp
        self.__optimizer = globOpt

    def displayResults(self):
        LOG(msg=f"{'#' * 20} RESULTS {'#' * 20}")
        for index, (fitness, instance, success) in enumerate(self.__results):
            LOG(msg=f"{'<' * 10} RESULT-{index} {'>' * 10}")
            LOG(msg=f"Fitness Value={fitness}")
            LOG(msg=f"Configuration={', '.join(feature.name for feature in instance)} --> {success}")
            LOG(msg=f"{'<' * 10} RESULT-{index} {'>' * 10}")
            LOG(msg="\n")

        LOG(msg=f"{'#' * 20} RESULTS {'#' * 20}")

    def exec(self):
        isinstance(self.__mopp, MoPP)
        self.__mopp.run()
        instances = self.__mopp.output
        self.__optimizer.setInstances(instances)
        self.__results = self.__optimizer.optimize(self.__mopp.command(*self.getProcessModelCallback()))

        self.displayResults()