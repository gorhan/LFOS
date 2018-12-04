

class ModelOptimizationInterface:
    INTERESTED_TUs = []

    def __init__(self, data):
        self._input_data = data
        self._output_data = {}

    @classmethod
    def addInterestedTU(cls, owner):
        cls.INTERESTED_TUs.append(owner)

    def perform(self, **kwargs):
        NotImplemented("The operation has not been implemented!!")
