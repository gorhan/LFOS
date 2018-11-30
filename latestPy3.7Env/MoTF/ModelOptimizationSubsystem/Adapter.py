
from . import ModelOptimizationInterface


class Parser(ModelOptimizationInterface):
    def __init__(self, pipeline_data):
        ModelOptimizationInterface.__init__(self, pipeline_data)

    def perform(self, **kwargs):
        for tu_output in self._input_data:
            self._output_data[tu_output["owner"]] = tu_output["data"]
        return self._output_data


class Extractor(ModelOptimizationInterface):
    def __init__(self, interested_data):
        ModelOptimizationInterface.__init__(self, interested_data)

    def perform(self, **kwargs):
        data = self._input_data[kwargs["extractor_owner"]]
        self._output_data = []

        for data_dict in data:
            data = data_dict["data"]
            if "fitness" not in kwargs or kwargs["fitness"]:
                fitness_values = data_dict["fitness"]
            else:
                fitness_values = [0]
            self._output_data.append({"data": data, "fitness": fitness_values})

        return self._output_data


class Adapter(ModelOptimizationInterface):
    def __init__(self, input):
        ModelOptimizationInterface.__init__(input)

    def perform(self, **kwargs):
        model_instances = Parser(self._input_data).perform(**kwargs)
        conf_values = Extractor(model_instances).perform(**kwargs)
        return conf_values