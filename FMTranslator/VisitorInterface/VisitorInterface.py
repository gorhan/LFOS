

class VisitorInterface:
    def __init__(self):
        pass

    def __getattr__(self, item):
        return getattr(self, '__not_implemented')

    def __not_implemented(self):
        pass