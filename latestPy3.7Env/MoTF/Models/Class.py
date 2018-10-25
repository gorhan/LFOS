from ..ModelDecorator import *

__types__ = {
    UML.PrimitiveType,
    UML.Class,
    UML.Generalization,
    UML.Operation,
    UML.Property,
    UML.LiteralBoolean,
    UML.LiteralInteger,
    UML.LiteralReal,
    UML.LiteralString,
    UML.LiteralUnlimitedNatural
}


class ClassModel(Model):

    def __init__(self, *args):
        Model.__init__(self, *args)
        self._model = self.getModel()
        self.name = self._model.name

        self._hierarchies = {}
        self._operations_table = {}
        # self._getContents(_cls, UML.Generalization, key="general")[0]

    def __str__(self):
        return "\n".join([f"{cls} --> {', '.join(ops)}" for cls, ops in self._operations_table.items()])

    def _getContents(self, _container, _type, key=None):
        return [(getattr(content, key) if key else content) for content in _container.eContents if isinstance(content, _type)]

    def _updateUpperHierarchy(self, cls, sub_classes):
        if cls in self._hierarchies:
            sub_classes = sub_classes.union(self._hierarchies[cls])
        self._hierarchies[cls] = sub_classes

        for super_cls in self._getContents(cls, UML.Generalization, key="general"):
            self._updateUpperHierarchy(super_cls, {cls}.union(self._hierarchies[cls]))

    def _createHierarchy(self, classes):
        for cls in classes:
            if cls not in self._hierarchies:
                self._hierarchies[cls] = set()

            inherited_classes = self._getContents(cls, UML.Generalization, key="general")

            for inherited_cls in inherited_classes:
                self._updateUpperHierarchy(inherited_cls, {cls}.union(self._hierarchies[cls]))

    def _createOperationsTable(self, classes):
        for cls in classes:
            self._operations_table[cls.name] = set()
            operations = self._getContents(cls, UML.Operation)

            for operation in operations:
                self._operations_table[cls.name] = self._operations_table[cls.name].union({operation.name})

        for cls in classes:
            for sub_class in self._hierarchies[cls]:
                self._operations_table[sub_class.name] = self._operations_table[cls.name].union(self._operations_table[sub_class.name])

    @identifier_required
    def gatherRequiredInfo(self):
        return self._operations_table

    @pointcut("after")
    def interpret(self, input=None):
        classes = self._getContents(self._model, UML.Class)
        self._createHierarchy(classes)
        self._createOperationsTable(classes)

        # for req in self._required_models:
        #     self.processRequiredInfo(req.gatherRequiredInfo())

        # print(f"Number of tasks={len(self._allTasks)}")
        return input
