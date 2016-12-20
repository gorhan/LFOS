from FMTranslator.Composite.Composite import *


class Feature(Composite):
    VISITED = []
    def __init__(self, name, instance=None):
        Composite.__init__(self)

        self.name = name
        self.callback_func = '%s_cb' % self.name
        self.instance = instance
        self.__parent = None

    def visit(self, host):
        if self not in Feature.VISITED:
            LOG(msg='Not visited. F=%s(%s)' % (self.name, self.instance))
            Feature.VISITED.append(self)
            return getattr(host, self.callback_func)(self.instance, self.__parent, self._container)

        LOG(msg='Visited already. F=%s(%s)' % (self.name, self.instance))
        return getattr(host, 'not_implemented')()

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
        print '%s%s(%r), CB=%s' % ('\t' * indent, self.name, self.instance, self.callback_func)
        self._pretty_print(indent+1)

    def traverse(self):
        return [self] + self._traverse()