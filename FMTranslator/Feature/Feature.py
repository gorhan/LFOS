from FMTranslator.Composite.Composite import Composite


class Feature(Composite):
    def __init__(self, name):
        Composite.__init__(self)

        self.name = name
        self.callback_func = '%s_cb' % self.name
        self.base = None
        self.__parent = None

    def visit(self, operator):
        return getattr(operator, self.callback_func)()

    def set_parent(self, parent):
        assert isinstance(parent, Feature)
        self.__parent = parent

    def get_parent(self):
        return self.__parent

    def __eq__(self, other):
        return self.name == other.name if isinstance(other, Feature) else self.name == other

    def search_feature(self, feature, found=[]):
        if self == feature:
            found.append(self)
        else:
            self._search_feature(feature, found)

    def pretty_print(self, indent=0):
        print '%s%s, F=%s' % ('\t' * indent, self.name, self.callback_func)
        self._pretty_print(indent+1)