from LFOS.Log import Logs, LOG


SHARED = 'Resource.Mode.SHARED'
CB_EXCLUSIVE = 'Resource.Mode.CAPACITY_EXCLUSIVE'
SB_EXCLUSIVE = 'Resource.Mode.SEMANTIC_EXCLUSIVE'


class Mode(object):
    MODES = [SHARED, CB_EXCLUSIVE, SB_EXCLUSIVE]

    def __init__(self):
        self._property = SHARED

    def is_mode(self, mode):
        return mode == self._property if mode in Mode.MODES else False

    def set_mode(self, mode):
        if mode not in Mode.MODES:
            LOG(msg='Given mode is not available. Modes=%s' % (', '.join(Mode.MODES)), log=Logs.ERROR)
            return False

        self._property = mode
        return True
