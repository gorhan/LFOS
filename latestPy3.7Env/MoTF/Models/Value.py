
from ..ModelDecorator import Model
from ..ModelProcPipeline import MoPP_D
from .. import LOG, Logs

NOT_A_VALUE = "NAV"

class TUOperation:
    def __init__(self, operation_name, included, excluded, tu_class):
        self.name = operation_name
        self.included = included
        self.excluded = excluded
        self.owner = tu_class

    def __eq__(self, other):
        if isinstance(other, TUOperation):
            return self.owner == other.owner and self.name == other.name
        elif isinstance(other, str):
            return self.name == other

        return False

class TUClass:
    __ALL__ = []

    @classmethod
    def isDefined(cls, class_name):
        for tu_class in cls.__ALL__:
            if tu_class.name == class_name:
                return tu_class

        return None

    @classmethod
    def from_class_name(cls, class_name, parent=None):
        found = cls.isDefined(class_name)
        return found if found else TUClass(class_name, parent)

    def __init__(self, class_name, included, excluded, parent_name=None):
        self.name = class_name
        self._inherits = []

        if parent_name:
            parent = TUClass.isDefined(parent_name)
            if parent is None:
                parent = TUClass(parent_name)
            self._inherits.append(parent)

        self._operations = []

        self._included = included
        self._excluded = excluded
        TUClass.__ALL__.append(self)

    def addInheritance(self, parent_name):
        parent = TUClass.isDefined(parent_name)
        if parent is None:
            parent = TUClass(parent_name)
        self._inherits.append(parent)

    def getInheritedClasses(self):
        return self._inherits

    def assignContribution(self, included, excluded):
        self._included = included
        self._excluded = excluded

    def addOperation(self, operation_name, included, excluded):
        self._operations.append(TUOperation(operation_name, included, excluded, self))

    def updateOperation(self, operation_name, included, excluded):
        if operation_name not in self._operations:
            LOG(msg=f"The operation {operation_name} is not an operation of Class {self.name}!", log=Logs.WARN)
            return False

        self.addOperation(operation_name, included, excluded)
        return True

    def _getInheritedOperationValue(self, key):


    def getOperationValue(self, operation_name, key="I"):
        if operation_name in self._operations:
            if self._operations[operation_name][key] == NOT_A_VALUE:
                return
            else:
                return self._operations[operation_name][key]

        LOG(msg=f"The operation {operation_name} is not an operation of Class {self.name}!", log=Logs.WARN)
        return None

    def getIterativeOperationValue(self, operation_name, key="I"):
        list_of_inherited_classes = [self]
        while list_of_inherited_classes[-1]:
            value = list_of_inherited_classes[-1].getOperationValue(operation_name, key)
            if value == NOT_A_VALUE:
                return value

            list_of_inherited_classes.append(list_of_inherited_classes[-1].getInheritedClass())
        list_of_inherited_classes.pop(-1)

        LOG(msg=f"The operation {operation_name} is not an operation of Class {', '.join(tu_class.name for tu_class in list_of_inherited_classes)}!", log=Logs.WARN)
        return None


class ValueModel(Model):
    def __init__(self, *args):
        Model.__init__(self, *args)
        self._model = self.getModel()

        self.name = self._model.name

    def addOperation2TUClass(self, class_name, operation_name, included=NOT_A_VALUE, excluded=NOT_A_VALUE):
        tu_class_o = TUClass.from_class_name(class_name)
        tu_class_o.addOperation(operation_name, included, excluded)

    def addTUClasses(self):
        for tu_class in self._model.classes:
            tu_class_o = TUClass.from_class_name(tu_class)
            if "inherits" in tu_class:
                for inherited_class in tu_class["inherits"]:
                    tu_class_o.addInheritance(self.getProcessedValue(inherited_class, "name"))


    def feature2name(self, process_model):
        return [list(map(lambda feature: feature.name, configuration)) for configuration in process_model]

    def interpret(self, input):
        process_model = input[("ProcessModel", 0)][1]

        return input.append(MoPP_D(*self.ID(), XXX))