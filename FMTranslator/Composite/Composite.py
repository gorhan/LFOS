from LFOS.Log import LOG, Logs

class Composite:
    def __init__(self, name):
        self.name = name
        self.callback_func = '%s_cb' % self.name
        self._container = []

    def visit(self, operator):
        return getattr(operator, self.callback_func)

    def add(self, feature_or_instance):
        self._container.append(feature_or_instance)

    def remove(self, feature_or_instance):
        if feature_or_instance in self._container:
            self._container.remove(feature_or_instance)
            LOG(msg='The instance of %s is removed from ')