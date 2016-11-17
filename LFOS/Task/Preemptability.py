from LFOS.Log import LOG, Logs
from exceptions import Exception
from enum import Enum


class PreemptionError(Exception):
    pass

class PreemptionTypeList:
    NOT_PPREEMPTABLE = 'Task.Preemptability.NP'
    COOPERATIVELY_PREEMPTABLE = 'Task.Preemptability.CP'
    FULLY_PREEMPTABLE = 'Task.Preemptability.FP'


class Preemption(object):
    TYPES = [PreemptionTypeList.NOT_PPREEMPTABLE,
             PreemptionTypeList.COOPERATIVELY_PREEMPTABLE,
             PreemptionTypeList.FULLY_PREEMPTABLE]

    def __init__(self, _type):
        if _type not in Preemption.TYPES:
            LOG(msg='Invalid Preemption Type. Available=%s' % ', '.join(Preemption.TYPES))
            exit(1)

        self.preemption_type = _type
        self.non_preemptable_execution_duration = 0

    def is_preemptable(self, init_time=0.0, current_time=0.0):
        return True if self.preemption_type == PreemptionTypeList.FULLY_PREEMPTABLE or \
                       (self.preemption_type == PreemptionTypeList.COOPERATIVELY_PREEMPTABLE and (current_time - init_time >= self.non_preemptable_execution_duration)) \
                       else False

    def get_preemption_type(self):
        return self.preemption_type

    def get_non_preemtable_execution_duration(self):
        return self.non_preemptable_execution_duration

    def set_non_preemptable_exec_duration(self, duration):
        LOG(msg='Invalid procedure call.', log=Logs.ERROR)

    def preempt(self, init_time_last_fragment, current_time):
        if self.preemption_type == PreemptionTypeList.NOT_PPREEMPTABLE:
            raise PreemptionError('Non-Praemptable Task')
        elif self.preemption_type == PreemptionTypeList.FULLY_PREEMPTABLE:
            return True
        elif self.preemption_type == PreemptionTypeList.COOPERATIVELY_PREEMPTABLE:
            if current_time - init_time_last_fragment >= self.non_preemptable_execution_duration:
                return True

            raise PreemptionError('Partially Preemptable Task. Non-interruptable for %.2f unit. Init Fragment=%.2f, Current Time=%.2f' %
                (self.non_preemptable_execution_duration, init_time_last_fragment, current_time))

#
# class NonPreemptable(PreemptionInterface):
#     def __init__(self, _type):
#         super(NonPreemptable, self).__init__(_type)
#         self.non_preemptable_execution_duration = -1
#
#     def preempt(self, init_time_last_fragment, current_time):
#         raise PreemptionError('Non-Praemptable Task')
#
#
# class FullyPreemptable(PreemptionInterface):
#     def __init__(self, _type):
#         super(FullyPreemptable, self).__init__(_type)
#
#     def preempt(self, init_time_last_fragment, current_time):
#         return True
#
#
# class PartiallyPreemptable(PreemptionInterface):
#     def __init__(self, _type):
#         super(PartiallyPreemptable, self).__init__(_type)
#
#     def set_non_preemptable_exec_duration(self, duration):
#         self.non_preemptable_execution_duration = duration
#
#     def preempt(self, init_time_last_fragment, current_time):
#         if current_time - init_time_last_fragment >= self.non_preemptable_execution_duration:
#             return True
#
#         raise PreemptionError('Partially Preemptable Task. Non-interruptable for %.2f unit. Init Fragment=%.2f, Current Time=%.2f' %
#                               (self.non_preemptable_execution_duration, init_time_last_fragment, current_time))
#
#
#
#
#
# class PreemptionFactory:
#     TYPES = {
#         PreemptionTypeList.NOT_PPREEMPTABLE: NonPreemptable,
#         PreemptionTypeList.COOPERATIVELY_PREEMPTABLE: PartiallyPreemptable,
#         PreemptionTypeList.FULLY_PREEMPTABLE: FullyPreemptable
#     }
#
#     def __init__(self):
#         pass
#
#     @classmethod
#     def create_instance(cls, _type):
#         if _type in cls.TYPES:
#             return cls.TYPES[_type](_type)
#         else:
#             LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
#             LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
#             return None