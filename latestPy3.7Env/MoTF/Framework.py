
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

    def __init__(self, mopp):
        self.__mopp = mopp
        self.__optimizer = GlobalOptimizer(100, 5)

    def displayResults(self):
        print(self.__results)
        LOG(msg=f"{'#' * 20} RESULTS {'#' * 20}")
        for index, (fitness, instance, success) in enumerate(self.__results):
            LOG(msg=f"{'<' * 10} RESULT-{index} {'>' * 10}")
            LOG(msg=f"Fitness Value={fitness}")
            LOG(msg=f"Configuration={', '.join(feature.name for feature in instance)} --> {success}")
            LOG(msg=f"{'<' * 10} RESULT-{index} {'>' * 10}")
            LOG(msg="\n")

        LOG(msg=f"{'#' * 20} RESULTS {'#' * 20}")

    def exec(self):
        self.__mopp.run()

        self.__optimizer.setInstances(self.__mopp.output[("OptimizationModel", 0)][1])
        self.__results = self.__optimizer.optimize(self.__mopp.command(*self.getProcessModelCallback()))

        self.displayResults()
