from LFOS.Log import LOG, Logs

class VisitorInterface:
    def __init__(self):
        pass

    def open(self):
        NotImplementedError('You should implement this function.')

    def close(self):
        NotImplementedError('You should implement this function.')

    def __getattr__(self, item):
        return getattr(self, '__not_implemented')

    def __not_implemented(self):
        LOG(msg='Not Implemented')