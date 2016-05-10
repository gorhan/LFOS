from LFOS.Log import Logs, LOG
from copy import copy


class StateGranularity:
    CONT = True
    DISC = False

class AbstractPowerConsumption:
    def __init__(self, scale, pow_cons):
        self._active_power_state = (scale, pow_cons)
        self._min_state = (scale, pow_cons)
        self._max_state = (scale, pow_cons)

    def get_power_scale(self):
        return self._active_power_state[0]

    def get_power_consumption(self):
        return self._active_power_state[1]

    def get_power_state(self):
        return self._active_power_state

    def get_max_state(self):
        return self._max_state

    def get_min_state(self):
        return self._min_state

    def range_check(self, scale):
        return self._min_state[0] <= scale <= self._max_state[0]

    def get_power_consumption_w_scale(self, scale):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_power_mode(self, scale):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def add_state(self, scale, pow_cons):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove_state(self, scale):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_min_state(self, scale, pow_cons):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_max_state(self, scale, pow_cons):
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

class FixedPowerConsumption(AbstractPowerConsumption):
    def __init__(self, scale, pow_cons):
        AbstractPowerConsumption.__init__(scale, pow_cons)


class DiscreteStatePowerConsumption(AbstractPowerConsumption, dict):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):
        dict.__init__({})
        self[min_scale] = min_pow_cons
        self[max_scale] = max_pow_cons

        AbstractPowerConsumption.__init__(max_scale, max_pow_cons)
        self.set_min_state(min_scale, min_pow_cons)

    def get_power_consumption_w_scale(self, scale):
        if scale in self:
            return self[scale]
        else:
            LOG(msg='Given scale is not in the list of power states.', log=Logs.WARN)

    def set_power_mode(self, scale):
        if scale in self:
            self._active_power_state = (scale, self[scale])

    def add_state(self, scale, pow_cons):
        if not scale in self and self.range_check(scale):
            self[scale] = pow_cons
        elif scale in self:
            LOG(msg='Given power scale is already in the list of power states.', log=Logs.WARN)
        else:
            LOG(msg='Given power scale is not within min and max power state scope.', log=Logs.WARN)

    def remove_state(self, scale):
        try:
            return self.pop(scale)
        except KeyError:
            LOG(msg='Given scale is not in the list of power states.')
            return None

    def set_max_state(self, scale, pow_cons):
        if scale > self.get_max_state():
            self._max_state = (scale, pow_cons)
            self[scale] = pow_cons
        else:
            LOG(msg='Current max power state is already higher.', log=Logs.WARN)

    def set_min_state(self, scale, pow_cons):
        if scale < self.get_min_state():
            self._min_state = (scale, pow_cons)
            self[scale] = pow_cons
        else:
            LOG(msg='Current min power state is already lower.', log=Logs.WARN)

class ContinuousStatePowerConsumption(AbstractPowerConsumption):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):