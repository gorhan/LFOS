from FMTranslator.Composite.Composite import Composite


class Feature(Composite):
    def __init__(self, name):
        Composite.__init__(self, name)