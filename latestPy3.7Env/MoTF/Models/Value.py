
from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D
from .. import LOG, Logs


class OperationProto:
    def __init__(self, name, contribution=(None, None), return_type="void", args=["void"]):
        self.name = name
        self.included, self.excluded = contribution
        self.return_t = return_type
        self.args = args

    def __eq__(self, other):
        if isinstance(other, OperationProto):
            return other.name == self.name and \
                   other.return_t == self.return_t and \
                   other.args == self.args
        elif isinstance(other, str):
            return other == self.name

        raise False

class ClassProto:
    def __init__(self, name, contribution=(None, None)):
        self.name = name
        self.included, self.excluded = contribution
        self.__inherits = []
        self.__operations = []
        # self.__attributes = []

    def set_included_value(self, inc_value):
        self.included = inc_value
        LOG(msg=f"Class {self.name} --> Included Value={self.included}.")

    def set_excluded_value(self, exc_value):
        self.excluded = exc_value
        LOG(msg=f"Class {self.name} --> Excluded Value={self.excluded}.")

    def set_contribution(self, inc_value, exc_value):
        self.set_included_value(inc_value)
        self.set_excluded_value(exc_value)

    def get_contribution(self):
        return self.included, self.excluded

    def get_operation(self, operation_name, return_type=None, args=None):
        if operation_name in self.__operations:
            index = None
            if return_type is None and args is None:
                index = self.__operations.index(operation_name)
            else:
                index = self.__operations.index(OperationProto(operation_name, (None, None), return_type, args))

            return self.__operations[index]

        return None

    def add_operation(self, name, contribution=(None, None), return_type="void", args=["void"]):
        operation = OperationProto(name, contribution, return_type, args)
        if operation not in self.__operations:
            self.__operations.append(operation)
            LOG(msg=f"New operation has been added: def {name}({', '.join(args)}) --> (INCLUDED, EXCLUDED)={contribution}.")

    def remove_operation(self, name, return_type=None, args=None):
        try:
            if return_type is None and args is None:
                self.__operations.remove(name)
            else:
                self.__operations.remove(OperationProto(name, (None, None), return_type, args))
        except ValueError:
            LOG(
                msg=f"Given operation does not belong to Class {self.name}.")

        LOG(msg=f"New operation has been added: def {name}({', '.join(args)}) --> (INCLUDED, EXCLUDED)={contribution}.")

    def add_inheritence(self, _clsProto):
        self.__inherits.append(_clsProto)

    def __eq__(self, other):
        if isinstance(other, ClassProto):
            return self.name == other.name
        elif isinstance(other, str):
            return self.name == other

        return False

    def get_value(self, operation_name, included=True):
        value = self.__get_value_helper(operation_name, included)
        if value:
            return value

        for inherited_class in self.__inherits:
            value = self.included if included else self.excluded
            if value:
                # LOG(msg=f"The value for {'INCLUDED' if included else 'EXCLUDED'} has been gathered from Class {inherited_class.name}!")
                return value

        # LOG(msg=f"The value for {'INCLUDED' if included else 'EXCLUDED'} of the operation {operation_name} has not been found so default value has been assigned from Class {self.name}!")
        return self.included if included else self.excluded

    def __get_value_helper(self, operation_name, included):
        operation = self.get_operation(operation_name)

        if operation:
            value = operation.included if included else operation.excluded
            if value:
                # LOG(msg=f"The value for {'INCLUDED' if included else 'EXCLUDED'} of the operation {operation_name} has been gathered from Class {self.name}!")
                return value

        for inherited_class in self.__inherits:
            value = inherited_class.__get_value_helper(operation_name, included)
            if value:
                # LOG(msg=f"The value for {'INCLUDED' if included else 'EXCLUDED'} of the operation {operation_name} has been gathered from Class {inherited_class.name}!")
                return value

        return None


class ValueModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self._model = self.getModel()

        self.name = self._model.name
        self._classes = []

        self._value_table = {}

    def extract_contribution(self, eobject):
        if hasattr(eobject, "contributes") and getattr(eobject, "contributes"):
            contribution = self.getProcessedValue(eobject, "contributes")
            included_value = self.getProcessedValue(contribution, "included") if hasattr(contribution, "included")  else 0.0
            excluded_value = self.getProcessedValue(contribution, "excluded") if hasattr(contribution, "excluded") else 0.0
            contribution = (included_value, excluded_value)
        else:
            contribution = (None, None)

        return contribution

    def addTUClasses(self):
        for _class in self._model.classes:
            class_o = ClassProto(_class.name, self.extract_contribution(_class))
            # LOG(msg=f"Class {class_o.name} has been created with contribution={class_o.get_contribution()}.")

            for _operation in _class.operations:
                operation_contribution = self.extract_contribution(_operation)
                class_o.add_operation(_operation.name, operation_contribution)
                # LOG(msg=f"The operation def {_operation.name}(void): return void [{operation_contribution}] has been added to Class {class_o.name}!")

            for _class_inh in _class.inherits:
                index = self._classes.index(_class_inh.name)
                class_inh_o = self._classes[index]
                class_o.add_inheritence(class_inh_o)
                # LOG(msg=f"Class {class_o.name} inherits Class {class_inh_o.name}!")

            self._classes.append(class_o)

    def feature2name(self, process_model):
        return [list(map(lambda feature: feature.name, configuration)) for configuration in process_model]

    def calculate_fitness_values(self, configuration):
        fitness = 0.0
        for class_o in self._classes:
            included = False
            if class_o.name in configuration:
                included = True
            fitness += class_o.get_value("DUMMY", included)
        return fitness

    def interpret(self, input):
        configurations = self.feature2name(input[("ProcessModel", 0)][1])
        self.addTUClasses()
        fitness_table = []
        for configuration in configurations:
            data = {"data": configuration, "fitness": self.calculate_fitness_values(configuration)}
            LOG(msg=data)
            fitness_table.append(data)

        input.append(MoPP_D(*self.ID(), fitness_table))
        return input


class EnergyModel(ValueModel):
    def __init__(self, *args):
        ValueModel.__init__(self, *args)


class PrecisionModel(ValueModel):
    def __init__(self, *args):
        ValueModel.__init__(self, *args)