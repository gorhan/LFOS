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
        self._allClasses = self._getContents(self._model, UML.Class)
        self._classHierarchy = {}

    def _getContents(self, _container, _type, key=None):
        return [(getattr(content, key) if key else content) for content in _container.eContents if isinstance(content, _type)]

    def _getHierarchicalClasses(self, _cls):

        for supercls in self._getContents(_cls, UML.Generalization, key="general"):
            if supercls not in self._classHierarchy:
                self._classHierarchy[supercls] = set()

            self._classHierarchy[supercls] = self._classHierarchy[supercls].union(self._classHierarchy[_cls])
            self._classHierarchy[supercls].add(_cls)

            self._getHierarchicalClasses(supercls)

    def __str__(self):
        return '\n'.join([f"Root = {root.name} --> {', '.join([_cls.name for _cls in sub_clses]) if sub_clses else None}" for root, sub_clses in self._classHierarchy.items()])

    def gatherRequiredInfo(self):
        return self._unbound_classes

    def getClass(self, name):
        for _cls in self._classHierarchy.keys():
            if _cls.name == name:
                return _cls
        return None

    def getRelevantClasses(self, _cls):
        return self._classHierarchy[_cls].union(set([_cls]))

    def processRequiredInfo(self, info):
        relevant_classes = set()
        for operation_specs in info:
            namespace = operation_specs["namespace"]

            _cls = self.getClass(namespace.split("::")[-1])
            if _cls in relevant_classes:
                supercls = self._getContents(_cls, UML.Generalization, key="general")[0]
                relevant_classes = relevant_classes.difference(self._classHierarchy[_cls].intersection(self._classHierarchy[supercls]))
                relevant_classes.add(supercls)

            relevant_classes = relevant_classes.union(self.getRelevantClasses(_cls))
            print("Relevant Classes:", ", ".join([_cls.name for _cls in relevant_classes]))

        self._unbound_classes = list(set(self._classHierarchy.keys()).difference(relevant_classes))
        print("Irrelevant Classes =", [_cls.name for _cls in self._unbound_classes])

    @pointcut("after")
    def interpret(self, input=None):
        for _cls in self._allClasses:
            if _cls not in self._classHierarchy:
                self._classHierarchy[_cls] = set()
            self._getHierarchicalClasses(_cls)

        # for req in self._required_models:
        #     self.processRequiredInfo(req.gatherRequiredInfo())

        # print(f"Number of tasks={len(self._allTasks)}")
        return input
