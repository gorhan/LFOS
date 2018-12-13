from . import ModelOptimizationInterface


class Parser(ModelOptimizationInterface):
    def __init__(self, pipeline_data):
        ModelOptimizationInterface.__init__(self, pipeline_data)

    def perform(self, **kwargs):
        for tu_output in self._input_data:
            self._output_data[tu_output.owner[0]] = tu_output.data[1]
        return self._output_data


class Extractor(ModelOptimizationInterface):
    def __init__(self, interested_data):
        ModelOptimizationInterface.__init__(self, interested_data)

    def perform(self, **kwargs):
        from collections import abc

        owners = kwargs["extractor_owner"]
        if not isinstance(owners, abc.Collection):
            owners = [owners]

        self._output_data = []

        for index in range(len(self._input_data[owners[0]])):
            if "fitness" not in kwargs or kwargs["fitness"]:
                data = self._input_data[owners[0]][index]["data"]
                fitness_values = []
                for owner in owners:
                    fitness_values.append(self._input_data[owner][index]["fitness"])
            else:
                data = self._input_data[index]
                fitness_values = [0]
            self._output_data.append({"data": data, "fitness": fitness_values})

        return self._output_data


class Adapter(ModelOptimizationInterface):
    def __init__(self, input):
        ModelOptimizationInterface.__init__(self, input)

    def perform(self, **kwargs):
        model_instances = Parser(self._input_data).perform(**kwargs)
        conf_values = Extractor(model_instances).perform(**kwargs)
        return conf_values