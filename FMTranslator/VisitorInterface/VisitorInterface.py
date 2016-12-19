from LFOS.Log import LOG, Logs

class VisitorInterface:
    def __init__(self):
        pass

    def open(self):
        NotImplementedError('You should implement this function.')

    def close(self):
        NotImplementedError('You should implement this function.')

    def __getattr__(self, item):
        return getattr(self, 'not_implemented')

    def not_implemented(self):
        pass