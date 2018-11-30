
from .ModelProcPipeline import MoPP
from .ModelOptimizationSubsystem import ModelOptimization
from . import LOG, Logs


class OptMLFramework:
    PROCESS_MODEL_ID = None
    PROCESS_MODEL_CB = None

    RELEVANT_TUs = []
    RELEVANT_KEYs = []
    RELEVANT_CMPs = []

    @classmethod
    def registerProcessModel(cls, model_id, model_cb):
        cls.PROCESS_MODEL_ID = model_id
        cls.PROCESS_MODEL_CB = model_cb

    @classmethod
    def getProcessModelCallback(cls):
        return cls.PROCESS_MODEL_ID, cls.PROCESS_MODEL_CB

    @classmethod
    def addInterestedPipelineData(cls, model_TU, key=None, cmp=None):
        cls.RELEVANT_TUs.append(model_TU)

        if key:
            cls.RELEVANT_KEYs.append(key)
        if cmp:
            cls.RELEVANT_CMPs.append(cmp)

    def __init__(self, mopp, search):
        assert isinstance(mopp, MoPP)

        self.__mopp = mopp
        self.__model_optimization_subsystem = ModelOptimization()

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

    # def configureInterestedData(self):
    #     process_configs = {}
    #
    #     cmps = self.__class__.RELEVANT_CMPs if len(self.__class__.RELEVANT_CMPs) == len(self.__class__.RELEVANT_KEYs) else None
    #
    #     for model_tu in self.__class__.RELEVANT_TUs:
    #         pipeline_data = self.__mopp.output[self.__mopp.findModelIndex(model_tu)][1]

    def exec(self, **kwargs):
        self.__mopp.run()
        self.__model_optimization_subsystem.setPipelineData(self.__mopp.output)

        kwargs.update(callback=self.__mopp.command(*self.getProcessModelCallback()))

        self.__results = self.__model_optimization_subsystem.perform(**kwargs)

        self.displayResults()
