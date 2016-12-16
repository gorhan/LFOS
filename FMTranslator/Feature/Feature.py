from FMTranslator.Composite.Composite import Composite


class Feature(Composite):
    def __init__(self, name, instance=None):
        Composite.__init__(self)

        self.name = name
        self.callback_func = '%s_cb' % self.name
        self.instance = instance
        self.__parent = None

    def visit(self, operator):
        return getattr(operator, self.callback_func)()

    def set_parent(self, parent):
        assert isinstance(parent, Feature)
        self.__parent = parent

    def get_parent(self):
        return self.__parent

    def search_feature(self, name, instance, found=[]):
        if instance is not None and self.instance == instance and self.name == name:
            found.append(self)
        else:
            self._search_feature(name, instance, found)

    def pretty_print(self, indent=0):
        print '%s%s(%r), F=%s' % ('\t' * indent, self.name, self.instance, self.callback_func)
        self._pretty_print(indent+1)