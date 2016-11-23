from LFOS.Log import Logs, LOG
import numpy as np


class Power(object):

    def __init__(self, scale, pow_cons):
        self._active_power_state = {scale: pow_cons}
        self._min_state = (scale, pow_cons)
        self._max_state = (scale, pow_cons)

    def get_power_scale(self):
        return self._active_power_state[0]

    def get_power_consumption(self):
        return self._active_power_state[1]

    def get_power_states(self):
        return np.array([self._max_state[0]]).tolist()

    def get_active_power_state(self):
        return self._active_power_state

    def get_max_power_state(self):
        return self._max_state

    def get_min_power_state(self):
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


class FixedStatePowerConsumption(Power):
    def __init__(self, scale, pow_cons, dump1=None, dump2=None):
        super(FixedStatePowerConsumption, self).__init__(scale, pow_cons)


class DiscreteStatePowerConsumption(Power, dict):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):
        super(DiscreteStatePowerConsumption, self).__init__(max_scale, max_pow_cons)
        self.set_min_state(min_scale, min_pow_cons)

        dict.__init__({})
        self[min_scale] = min_pow_cons
        self[max_scale] = max_pow_cons

    def get_power_consumption_w_scale(self, scale):
        if scale in self:
            return self[scale]
        else:
            LOG(msg='Given scale is not in the list of power states.', log=Logs.WARN)

    def set_power_mode(self, scale):
        if scale in self:
            self._active_power_state = (scale, self[scale])

    def add_state(self, scale, pow_cons):
        if scale not in self and self.range_check(scale):
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
        if scale > self.get_max_power_state():
            self._max_state = (scale, pow_cons)
            self[scale] = pow_cons
        else:
            LOG(msg='Current max power state is already higher.', log=Logs.WARN)

    def set_min_state(self, scale, pow_cons):
        if scale < self.get_min_power_state():
            self._min_state = (scale, pow_cons)
            self[scale] = pow_cons
        else:
            LOG(msg='Current min power state is already lower.', log=Logs.WARN)

    def get_power_states(self):
        return np.array([float(1.0/scale) for scale in self.keys()]).tolist()


class ContinuousStatePowerConsumption(Power):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):
        super(ContinuousStatePowerConsumption, self).__init__(max_scale, max_pow_cons)
        self.set_min_state(min_scale, min_pow_cons)

        self.__calculate_power_consumption_slope()
        self.__power_scale_precision = 0.1

    def __calculate_power_consumption_slope(self):
        self.__slope = (self._max_state[1] - self._min_state[1]) / (self._max_state[0] - self._min_state[0])
        self.__offset = self._min_state[1] - self.__slope * self._min_state[0]

    def __calculate_power_consumption(self, scale):
        return self.__slope * scale + self.__offset

    def get_power_consumption_w_scale(self, scale):
        if self.range_check(scale):
            return self.__slope * scale + self.__offset
        else:
            LOG(msg='Given scale is not within the range of minimum and maximum power scales.', log=Logs.WARN)
        return None

    def set_power_scale_precision(self, precision):
        self.__power_scale_precision = precision

    def get_power_scale_precision(self):
        return self.__power_scale_precision

    def set_power_mode(self, scale):
        if self.range_check(scale):
            self._active_power_state = (scale, self.__calculate_power_consumption(scale))
        else:
            LOG(msg='Given scale is not within the range of minimum and maximum power scales.', log=Logs.WARN)

    def set_max_state(self, scale, pow_cons):
        if scale > self._max_state[0]:
            self._max_state = (scale, pow_cons)
            self.__calculate_power_consumption_slope()
        else:
            LOG(msg='Current max power state is already higher.', log=Logs.WARN)

    def set_min_state(self, scale, pow_cons):
        if scale < self._min_state[0]:
            self._min_state = (scale, pow_cons)
            self.__calculate_power_consumption_slope()
        else:
            LOG(msg='Current min power state is already lower.', log=Logs.WARN)

    def get_power_states(self):
        return np.concatenate((np.arange(self._min_state[0], self._max_state[0], self.__power_scale_precision), np.array(self._max_state[0]))).tolist()


class PowerTypeList:
    FIXED_STATE_POWER_CONSUMPTION = 'Resource.Power.FSPC'
    DISCRETE_STATE_POWER_CONSUMPTION = 'Resource.Power.DSPC'
    CONTINUOUS_STATE_POWER_CONSUMPTION = 'Resource.Power.CSPC'


class PowerFactory:
    TYPES = {
        PowerTypeList.FIXED_STATE_POWER_CONSUMPTION: FixedStatePowerConsumption,
        PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION: DiscreteStatePowerConsumption,
        PowerTypeList.CONTINUOUS_STATE_POWER_CONSUMPTION: ContinuousStatePowerConsumption
    }

    def __init__(self):
        pass

    @classmethod
    def create_instance(cls, _type, min_scale, min_pow_cons, max_scale=None, max_pow_cons=None):
        if _type in cls.TYPES:
            return cls.TYPES[_type](min_scale, min_pow_cons, max_scale, max_pow_cons)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
