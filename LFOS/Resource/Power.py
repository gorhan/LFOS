from LFOS.Log import Logs, LOG
import numpy as np


class Power(object):

    def __init__(self, scale, pow_cons):
        self._active_power_state = [scale, pow_cons]
        self._min_state = [scale, pow_cons]
        self._max_state = [scale, pow_cons]

    def get_power_scale(self):
        """
        get_power_scale() -> float

        Returns power scale for active power state
        """
        return self._active_power_state[0]

    def get_power_consumption(self):
        """
        get_power_consumption() -> float

        Returns power consumption for active power state.
        """
        return self._active_power_state[1]

    def get_power_states(self):
        """
        get_power_states() -> Numpy.array

        Returns the power state for active power states
        """
        return np.array([self._max_state[0]]).tolist()

    def get_active_power_state(self):
        """
        get_active_power_state() -> dict

        Returns the active power state. The key of active state is power scale and the value is power consumption.
        """
        return self._active_power_state

    def get_max_power_state(self):
        """
        get_max_power_state() -> list

        Returns the maximum power state.

        :return: list
        """
        return self._max_state

    def get_min_power_state(self):
        """
        get_min_power_state() -> list

        Returns the minimum power state.

        :return: list
        """
        return self._min_state

    def range_check(self, scale):
        """
        range_check(scale) -> boolean

        Returns True if the power scale within the range of minimum and maximum power scales. Otherwise, it returns False.

        :param scale: float -> the power scale
        :return: boolean
        """
        return self._min_state[0] <= scale <= self._max_state[0]

    def max_range_check(self, scale):
        """
        max_range_check(scale) -> boolean

        Returns True if the power scale within [0.0, 1.0]. Otherwise, it returns False.

        :param scale: float -> the power scale
        :return: boolean
        """
        return 0.0 <= scale <= 1.0

    def get_power_consumption_w_scale(self, scale):
        """
        get_power_consumption_w_scale(scale) -> float (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_power_mode(self, scale):
        """
        set_power_mode(scale) -> boolean (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def add_state(self, scale, pow_cons):
        """
        add_state(self, scale, pow_cons) -> boolean (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def remove_state(self, scale):
        """
        remove_state(scale) -> boolean (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_min_state(self, scale, pow_cons):
        """
        set_min_state(scale, pow_cons) -> boolean (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)

    def set_max_state(self, scale, pow_cons):
        """
        set_max_state(self, scale, pow_cons) -> boolean (Interface Function)

        Interface function -> it should be re-implemented for the child classes.
        """
        LOG(msg='Invalid procedure call', log=Logs.ERROR)


class FixedStatePowerConsumption(Power):
    def __init__(self, scale, pow_cons, dump1=None, dump2=None):
        super(FixedStatePowerConsumption, self).__init__(scale, pow_cons)

    def set_power_consumption(self, consumption):
        """
        set_power_consumption(consumption) -> None

        Updates the power consumption values for all mininimum, maximum and active power states.

        :param consumption: float -> the power consumption value
        :return: None
        """
        self._min_state[1] = self._max_state[1] = self._active_power_state[1] = consumption


class DiscreteStatePowerConsumption(Power, dict):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):
        super(DiscreteStatePowerConsumption, self).__init__(max_scale, max_pow_cons)
        self.set_min_state(min_scale, min_pow_cons)

        dict.__init__({})
        self[min_scale] = min_pow_cons
        self[max_scale] = max_pow_cons

    def get_power_consumption_w_scale(self, scale):
        """
        get_power_consumption_w_scale(scale) -> float

        :param scale: float -> requested power scale value
        :return: float -> desired power consumption value for a given scale

        Interface function -> it should be re-implemented for the child classes.
        """
        if scale in self:
            return self[scale]
        else:
            LOG(msg='Given scale is not in the list of power states.', log=Logs.WARN)

    def set_power_mode(self, scale):
        """
        set_power_mode(scale) -> list

        Updates the active power states and returns it if given scale is one of the scales in the list of power states.
        Otherwise, it returns empty list.

        :param scale: float -> requested power scale value to be set for active power state
        :return: list
        """
        if scale in self:
            self._active_power_state = [scale, self[scale]]
            return self._active_power_state

        return []

    def add_state(self, scale, pow_cons):
        """
        add_state(scale, pow_cons) -> boolean

        Returns True if the given power scale is not in the list of power states and range_check is valid. Otherwise, it returns False.

        :param scale: float -> power scale of the resource
        :param pow_cons: float -> power consumption value for one-capacity utilization of the resource per time unit
        :return: boolean
        """
        if scale not in self and self.range_check(scale):
            self[scale] = pow_cons
            return True

        if scale in self:
            LOG(msg='Given power scale is already in the list of power states.', log=Logs.WARN)
        else:
            LOG(msg='Given power scale is not within min and max power state scope.', log=Logs.WARN)

        return False

    def remove_state(self, scale):
        """
        remove_state(scale) -> float | None

        :param scale: float -> power scale of the resource meant to be removed
        :return: float -> power consumption value if it includes given power scale in the list of power states
                 None -> Otherwise
        """
        try:
            return self.pop(scale)
        except KeyError:
            LOG(msg='Given scale is not in the list of power states.')
            return None

    def set_max_state(self, scale, pow_cons):
        """
        set_max_state(scale, pow_cons) -> boolean

        Returns if given scale is higher than the current maximum power scale. Otherwise, it returns False.

        :param scale: float -> power scale value meant to be set
        :param pow_cons: float -> power consumption value belonging to given power scale
        :return: True if given scale is higher than the current maximum power scale. Otherwise, False.
        """
        if scale > self.get_max_power_state():
            self._max_state = [scale, pow_cons]
            self[scale] = pow_cons
            return True
        elif self.max_range_check(scale):
            LOG(msg='Current max power state is already higher.', log=Logs.WARN)
        else:
            LOG(msg='Given scale is not within the range [0.0, 1.0]', log=Logs.WARN)
        return False

    def set_min_state(self, scale, pow_cons):
        """
        set_min_state(scale, pow_cons) -> boolean

        Returns if given scale is less than the current minimum power scale. Otherwise, it returns False.

        :param scale: float -> power scale value meant to be set
        :param pow_cons: float -> power consumption value belonging to given power scale
        :return: True if given scale is less than the current minimum power scale. Otherwise, False.
        """
        if scale < self.get_min_power_state():
            self._min_state = [scale, pow_cons]
            self[scale] = pow_cons
            return True
        elif self.max_range_check(scale):
            LOG(msg='Current min power state is already lower.', log=Logs.WARN)
        else:
            LOG(msg='Given scale is not within the range [0.0, 1.0]', log=Logs.WARN)
        return False

    def get_power_states(self):
        """
        get_power_states() -> Numpy.array

        Returns the array of the list of power states.

        :return: array of scale^(-1) of power states.
        """
        return np.array([float(1.0/scale) for scale in self.keys()]).tolist()


class ContinuousStatePowerConsumption(Power):
    def __init__(self, min_scale, min_pow_cons, max_scale, max_pow_cons):
        super(ContinuousStatePowerConsumption, self).__init__(max_scale, max_pow_cons)
        self.set_min_state(min_scale, min_pow_cons)

        self.__calculate_power_consumption_slope()
        self.__power_scale_precision = 0.1

    def __calculate_power_consumption_slope(self):
        """
        __calculate_power_consumption_slope()

        Calculates the slope and offset for a linear power consumption based on minimum and maximum power states.

        :return: None
        """
        self.__slope = (self._max_state[1] - self._min_state[1]) / (self._max_state[0] - self._min_state[0])
        self.__offset = self._min_state[1] - self.__slope * self._min_state[0]

    def get_power_consumption_w_scale(self, scale):
        """
        get_power_consumption_w_scale(scale) -> float

        Returns power consumption value if the given scale within minimum and maximum scale. Otherwise, it
        returns -1.0.

        :param scale: float -> the power scale at which the power consumption value is needed.
        :return: float ->
        """
        if self.range_check(scale):
            return self.__slope * scale + self.__offset

        LOG(msg='Given scale is not within the range of minimum and maximum power scales.', log=Logs.WARN)
        return -1.0

    def set_power_scale_precision(self, precision):
        """
        set_power_scale_precision(precision) -> None

        Sets the power scale precision. It is important for solving scheduling problem using solver. It is impossible to
        define scheduling problem without discritizing the continuous power scales.

        :param precision: float -> power scale discritization value
        :return: None
        """
        self.__power_scale_precision = precision

    def get_power_scale_precision(self):
        """
        get_power_scale_precision() -> float

        :return: float -> power scale discritization value
        """
        return self.__power_scale_precision

    def set_power_mode(self, scale):
        """
        set_power_mode(scale) -> list(scale, power consumption)

        Updates the active power state and returns it if given scale within the range of minimum and
        maximum power scales. Otherwise, it returns empty list.

        :param scale: float -> the power scale value
        :return: list -> updates the active power state and returns it if given scale within the range of minimum and
                         maximum power scales. Otherwise, it returns empty list.
        """
        if self.range_check(scale):
            self._active_power_state = [scale, self.get_power_consumption_w_scale(scale)]
            return self._active_power_state
        LOG(msg='Given scale is not within the range of minimum and maximum power scales.', log=Logs.WARN)
        return []

    def set_max_state(self, scale, pow_cons):
        """
        set_max_state(scale, pow_cons) -> boolean

        Returns True if the given power scale is more than the current maximum power scale, and it updates the slope and
        offset of a linear power consumption equation. Otherwise, it returns False.

        :param scale: float -> the power scale
        :param pow_cons: float -> the power consumption for 'scale'
        :return: boolean
        """
        if scale > self._max_state[0]:
            self._max_state = [scale, pow_cons]
            self.__calculate_power_consumption_slope()
            return True

        LOG(msg='Current max power state is already higher.', log=Logs.WARN)
        return False

    def set_min_state(self, scale, pow_cons):
        """
        set_min_state(scale, pow_cons) -> boolean

        Returns True if the given power scale is less than the current minimum power scale, and it updates the slope and
        offset of a linear power consumption equation. Otherwise, it returns False.

        :param scale: float -> the power scale
        :param pow_cons: float -> the power consumption for 'scale'
        :return: boolean
        """
        if scale < self._min_state[0]:
            self._min_state = [scale, pow_cons]
            self.__calculate_power_consumption_slope()
        else:
            LOG(msg='Current min power state is already lower.', log=Logs.WARN)

    def get_power_states(self):
        """
        get_power_states() -> Numpy.array

        Returns all power scales based on power scale precision.

        :return: Numpy.array
        """
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
        """
        create_instance(_type, min_scale, min_pow_cons, max_scale=None, max_pow_cons=None) -> FixedStatePowerConsumption | DiscreteStatePowerConsumption | ContinuousStatePowerConsumption

        Returns the corresponding instance for given _type.

        :param _type:
            PowerTypeList.FIXED_STATE_POWER_CONSUMPTION |
            PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION |
            PowerTypeList.CONTINUOUS_STATE_POWER_CONSUMPTION
        :param min_scale: float -> minimum power scale
        :param min_pow_cons: float -> minimum power consumption
        :param max_scale: float -> maximum power scale
        :param max_pow_cons: float -> maximum power consumption
        :return: FixedStatePowerConsumption | DiscreteStatePowerConsumption | ContinuousStatePowerConsumption
        """
        if _type in cls.TYPES:
            return cls.TYPES[_type](min_scale, min_pow_cons, max_scale, max_pow_cons)
        else:
            LOG(msg='Invalid factory construction request.', log=Logs.ERROR)
            LOG(msg='Valid types: %s' % (', '.join(cls.TYPES.keys())), log=Logs.ERROR)
