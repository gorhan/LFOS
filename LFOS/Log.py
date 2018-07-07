from __future__ import print_function

from time import localtime, strftime
from sys import stderr, stdout
from inspect import stack

class Logs:
    WARN='WARN'
    ERROR='ERROR'
    INFO='INFO'
    @classmethod
    def LOG2FP(cls, log):
        if log == Logs.WARN or log == Logs.INFO:
            return stdout
        elif log == Logs.ERROR:
            return stderr


def LOG(**kwargs):
    stck = stack()[1][0]
    # print stck.f_locals
    if 'cls' in stck.f_locals:
        caller_class = stck.f_locals['cls'].__name__
    elif 'self' in stck.f_locals:
        caller_class = stck.f_locals['self'].__class__.__name__
    else:
        caller_class = 'GLOBAL'
    caller_func = stck.f_code.co_name

    if 'log' not in kwargs:
        kwargs['log'] = Logs.INFO

    if 'tag' not in kwargs:
        kwargs['tag'] = 'NO_TAG'

    log = '%s From %50s[%s] %5s: %s' % (
        strftime('[%d-%m-%Y - %H:%M:%S]', localtime()),
        caller_class + '.' + caller_func,
        kwargs['tag'],
        kwargs['log'],
        kwargs['msg']
    )

    out = kwargs['fp'] if 'fp' in kwargs else Logs.LOG2FP(kwargs['log'])
    if not 'n_print' in kwargs:
        print(log, file=out)
        out.flush()

    return log
