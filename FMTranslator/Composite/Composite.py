from LFOS.Log import LOG, Logs

class Composite:
    def __init__(self):

        self._container = []

    def add(self, feature_or_instance):
        self._container.append(feature_or_instance)
        feature_or_instance.set_parent(self)

    def remove(self, feature_or_instance):
        if feature_or_instance in self._container:
            self._container.remove(feature_or_instance)
            LOG(msg='The instance of %s is removed from ')

    def __getitem__(self, item):
        # LOG(msg='item=%d, #container=%d' % (item, len(self._container)))
        if self._container:
            id = item + (len(self._container) if item < 0 else 0)
            if id >= 0:
                return self._container[id]

        return None

    def _search_feature(self, feature, found):
        for in_feature in self._container:
            in_feature.search_feature(feature, found)

    def _pretty_print(self, indent):
        for item in self._container:
            item.pretty_print(indent)