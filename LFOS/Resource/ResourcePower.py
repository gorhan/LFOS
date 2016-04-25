from LFOS.Log import Logs, LOG
from copy import copy


class StateGranularity:
    CONT = True
    DISC = False


class PowerState:
    def __init__(self, scale, pow_cons):
        self.scale = scale
        self.pow_cons = pow_cons

    def __eq__(self, other):
        return (type(other) is PowerState and self.scale == other.scale) or (other == self.scale)

    def __repr__(self):
        return LOG(msg='Scale: %.2f, PowerConsumption: %.2f' % (self.scale, self.pow_cons), n_print=None)


class ResourcePower:
    params = [
        'scalable',
        'granularity'
    ]
    opt_params = [
        'max_state',
        'min_state'
    ]

    def __init__(self, **kwargs):
        max_state = kwargs['max_state'] if 'max_state' in kwargs else None
        min_state = kwargs['min_state'] if 'min_state' in kwargs else None

        if max_state is None and min_state is None:
            LOG(msg='Max and Min states are not defined', log=Logs.ERROR)
            exit(-1)
        elif max_state is None:
            max_state = min_state
        elif min_state is None:
            min_state = max_state

        self.__states = list()
        self.__max_state = self.__min_state = None
        self.__n_states = 0
        self.__granularity = kwargs['granularity']
        self.__active_state = None

        self.__power_derivative = 0.0
        self.__power_offset = 0.0

        if kwargs['scalable']:
            self.__scalable = True
            self.__max_state = PowerState(max_state[0], max_state[1])
            self.__min_state = PowerState(min_state[0], min_state[1])
            self.__states.append(copy(self.__max_state))
            self.__states.append(copy(self.__min_state))
            self.__active_state = copy(self.__max_state)
            self.__n_states = len(self.__states)

            self.__power_derivative = float(self.__max_state.pow_cons - self.__min_state.pow_cons) / (self.__max_state.scale - self.__min_state.scale)
            self.__power_offset = self.__min_state.pow_cons - (self.__power_derivative * self.__min_state.scale)
        else:
            self.__scalable = False
            self.__max_state = self.__min_state = PowerState(max_state[0], max_state[1])
            self.__states.append(copy(self.__max_state))
            self.__active_state = copy(self.__max_state)
            self.__n_states = len(self.__states)

    # Internal functions
    def __has_scale(self, scale):
        return [state.scale for state in self.__states].count(scale) == 1

    def __range_check(self, scale, range_min=0.0, range_max=1.0):
        return scale <= range_max and scale > range_min

    def __compute_power_consumption(self, scale):
        return self.__power_derivative * scale + self.__power_offset

    def __get_power_consumption(self, scale):
        consumption = None
        if self.__scalable and self.__granularity == StateGranularity.CONT:
            consumption = self.__compute_power_consumption(scale)
        elif self.__has_scale(scale):
            consumption = self.__states[scale]
        else:
            LOG(msg='Invalid request. Scale: %.3f' % (scale), log=Logs.WARN)

        return consumption

    # public functions
    def add_state(self, scale, pow_cons):
        if self.__scalable and \
                self.__granularity == StateGranularity.DISC and \
                self.__range_check(scale) and \
                not self.__has_scale(scale):
            self.__states.append(PowerState(scale, pow_cons))
            self.__n_states = len(self.__states)
            LOG(msg='The state is added to power consumption: Scale: %.2f, Power: %.2f' % (scale, pow_cons), log=Logs.INFO)
        else:
            LOG(msg='Invalid procedure call: %.2f' % (scale), log=Logs.ERROR)

    def add_scale(self, scale):
        self.add_state(scale, self.__compute_power_consumption(scale))

    def set_power_mode(self, scale):
        if self.__range_check(scale):
            if self.__granularity == StateGranularity.CONT and self.__range_check(scale, self.__min_state.scale, self.__max_state.scale):
                self.__active_state = PowerState(scale, self.__get_power_consumption(scale))
                LOG(msg='Power is set. Scale: %.2f' % scale)
                return True
            elif self.__granularity == StateGranularity.DISC and self.__has_scale(scale):
                self.__active_state = self.__states[self.__states.index(scale)]
                LOG(msg='Power is set. Scale: %.2f' % scale)
                return True

        LOG(msg='Invalid scale. Scale: %.3f' % scale, log=Logs.WARN)
        return False

    def get_power_mode(self):
        return self.__active_state

    def get_power_consumption(self):
        return self.__active_state.pow_cons