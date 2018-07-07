from __future__ import print_function

BOUND = 0
UNBOUND = 1
FREE = 2
DESCRIPTION = ['BOUND', 'UNBOUND', 'FREE']


class Model:
    root = None

    def __init__(self, root_name):
        if Model.root is None:
            self.__name  = root_name
            Model.root = Model._Feature(root_name)

    def clear(self):
        Model.root = None

    def __getattr__(self, item):
        return getattr(Model.root, item)

    class _Feature:

        class _Group:
            def __init__(self):
                self.__cardinality = {'min': 0, 'max': 0}
                self.__features = []

            def get_features(self, bound=None):
                if bound is None:
                    return self.__features
                return [feature for feature in self.__features if feature.is_bound() == bound]

            def set_cardinality(self, _min, _max):
                self.__cardinality['min'] = _min
                self.__cardinality['max'] = _max

            def add_feature(self, _feature):
                self.__features.append(_feature)

            def get_cardinality(self):
                return [self.__cardinality['min'], self.__cardinality['max']]

            def variations(self):
                _vars = []
                bound_features = self.get_features(BOUND)
                unbound_features = self.get_features(UNBOUND)
                free_features = self.get_features(FREE)

                n_bound_features = len(unbound_features)

                for n in range(self.__cardinality['min']-n_bound_features, self.__cardinality['max'] - n_bound_features + 1):
                    from itertools import combinations, product
                    for combs in combinations(free_features, n):
                        sub_vars = []
                        combs = list(combs) + bound_features

                        for feature in combs:
                            sub_vars.append(feature.instantiate())

                        # print sub_vars
                        # raw_input('')
                        for prod in product(*sub_vars):
                            if prod:
                                _vars.append(reduce(lambda x, y: x + y, prod))

                return _vars

        def __init__(self, _name, _bound=FREE):
            self.name = _name
            self.__bound = _bound
            self.__groups = []

        def add_feature(self, **kwargs):
            assert kwargs.has_key('parent')
            assert kwargs.has_key('children')
            assert type(kwargs['children']) is list

            _found = Model.root._search(kwargs['parent'])
            if _found:
                _group = Model._Feature._Group()

                _min_cardinality = _max_cardinality = 0
                if kwargs.has_key('max'):
                    _max_cardinality = kwargs['max'] if kwargs['max'] <= len(kwargs['children']) else len(
                        kwargs['children'])
                if kwargs.has_key('min'):
                    _min_cardinality = kwargs['min'] if 0 < kwargs['min'] <= _max_cardinality else _max_cardinality

                _group.set_cardinality(_min_cardinality, _max_cardinality)
                _found._add_group(_group)

                bound = BOUND if _max_cardinality == _min_cardinality == len(kwargs['children']) else FREE

                for child in kwargs['children']:
                    _group.add_feature(Model._Feature(child, bound))

        def _add_group(self, _group):
            self.__groups.append(_group)

        def _search(self, feature_name):
            if self == feature_name:
                return self

            for group in self.__groups:
                _c_features = group.get_features()

                for feature in _c_features:
                    _found = feature._search(feature_name)
                    if _found:
                        return _found

            return None

        def __eq__(self, other):
            if isinstance(other, Model._Feature):
                return other.name == self.name
            elif isinstance(other, str):
                return other == self.name
            else:
                return False

        def __repr__(self):
            return self.name

        def pretty_print(self, indent=''):
            print('%s%s [%s]' % (indent, self.name, DESCRIPTION[self.__bound]))
            for group in self.__groups:
                print('{}\tGROUP: [Min={}, Max={}]'.format(indent, *group.get_cardinality()))
                for child in group.get_features():
                    child.pretty_print(indent+'\t\t')

        def bind(self, feature_name, bound=BOUND):
            self._search(feature_name).__bound = bound

        def clear_bindings(self, root=None):
            if root is None:
                root = Model.root

            for gr in root.__groups:
                for feature in gr.get_features():
                    feature.__bound = FREE
                    root.clear_bindings(feature)

        def is_bound(self):
            return self.__bound

        def instantiate(self):
            vars = []
            for group in self.__groups:
                vars.append(group.variations())

            from itertools import product
            sub_configurations = []
            for prod in product(*vars):
                if prod:
                    sub_configurations.append(reduce(lambda x,y: x+y, prod))

            if sub_configurations:
                return [[self] + sub_configuration for sub_configuration in sub_configurations]
            return [[self]]