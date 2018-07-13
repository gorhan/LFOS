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
        self._classHierarchy = dict.fromkeys(self._allClasses)

        for _cls in self._allClasses:
            self._getHierarchicalClasses(_cls)

    def _getContents(self, _container, _type, key=None):
        return [(getattr(content, key) if key else content) for content in _container.eContents if isinstance(content, _type)]

    def _getHierarchicalClasses(self, _cls):
        if self._classHierarchy[_cls] is None:
            self._classHierarchy[_cls] = set()

        for supercls in self._getContents(_cls, UML.Generalization, key="general"):
            if self._classHierarchy[supercls] is None:
                self._classHierarchy[supercls] = set()

            self._classHierarchy[supercls] = self._classHierarchy[supercls].union(self._classHierarchy[_cls])
            self._classHierarchy[supercls].add(_cls)

            self._getHierarchicalClasses(supercls)

    def __str__(self):
        return '\n'.join([f"Root = {root.name} --> {', '.join([_cls.name for _cls in sub_clses]) if sub_clses else None}" for root, sub_clses in self._classHierarchy.items()])

    def interpret(self, input=None):
        return [Ellipsis]