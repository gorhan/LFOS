import os
import sys
sys.path.insert(0, os.path.abspath('..'))
from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Characteristic.Time import Time


class Singleton(type):
    _instances = {}
    def __call__(cls, *args):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args)
        return cls._instances[cls]


class Task:
    __metaclass__ = Singleton
    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class CarCall(Task):
    def __eq__(self, other):
        return isinstance(other, CarCall) or (isinstance(other, str) and other == str(self))
class HallCall(Task):
    def __eq__(self, other):
        return isinstance(other, HallCall) or (isinstance(other, str) and other == str(self))


class Direction:
    __metaclass__ = Singleton
    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class UP(Direction):
    def __neg__(self):
        return DOWN()
    def __eq__(self, other):
        return isinstance(other, UP) or (isinstance(other, str) and other == str(self))
class DOWN(Direction):
    def __neg__(self):
        return UP()
    def __eq__(self, other):
        return isinstance(other, DOWN) or (isinstance(other, str) and other == str(self))


class PassengerPriority:
    __metaclass__ = Singleton
    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class NORMAL(PassengerPriority):
    def __eq__(self, other):
        return isinstance(other, NORMAL) or (isinstance(other, str) and other == str(self))
class HIGH(PassengerPriority):
    def __eq__(self, other):
        return isinstance(other, HIGH) or (isinstance(other, str) and other == str(self))
class URGENT(PassengerPriority):
    def __eq__(self, other):
        return isinstance(other, URGENT) or (isinstance(other, str) and other == str(self))


class HLDS:
    __metaclass__ = Singleton
    def __str__(self):
        return '%s.%s' % (self.__class__.__bases__[0].__name__, self.__class__.__name__)
    def __hash__(self):
        return id(self)
class Sectors(HLDS):
    def __eq__(self, other):
        return isinstance(other, NORMAL) or (isinstance(other, str) and other == str(self))
class NEwoutCC(HLDS):
    def __eq__(self, other):
        return isinstance(other, NORMAL) or (isinstance(other, str) and other == str(self))
class NEwCC(HLDS):
    def __eq__(self, other):
        return isinstance(other, NORMAL) or (isinstance(other, str) and other == str(self))


parameters_table = {
    'current_floor': {
        'Explanation': 'The floor where the car is standing.',
        'Type'       : int,
        'Default'    : 0
    },
    'num_floors': {
        'Explanation': 'The number of floors in the building.',
        'Type'       : int,
        'Default'    : 16
    },
    'disabled_floors': {
        'Explanation': 'The floors to which the car is eligible to move.',
        'Type'       : list,
        'Default'    : []
    },
    'direction': {
        'Explanation': 'The direction of the car.',
        'Type'       : Direction,
        'Default'    : UP()
    },
    'target_direction': {
        'Explanation': 'The target direction of the car with respect to the request of a passenger.',
        'Type'       : Direction,
        'Default'    : UP()
    },
    'current_passengers': {
        'Explanation': 'The number of passengers inside the car',
        'Type'       : int,
        'Default'    : 0
    },
    'max_passengers': {
        'Explanation': 'Maximum number of passengers that the car is able to lift.',
        'Type'       : int,
        'Default'    : 8
    },
    'solver': {
        'Explanation': 'The name of the solver.',
        'Type'       : str,
        'Default'    : 'Mistral2'
    },
    'verbose': {
        'Explanation': 'The level of information printed during solver execution.',
        'Type'       : int,
        'Default'    : 1
    },
    'time_cutoff': {
        'Explanation': 'Time bound for a solver to find an optimal solution.',
        'Type'       : int,
        'Default'    : 25
    },
    'start_time': {
        'Explanation': 'The initial time of the scheduling window.',
        'Type'       : Time,
        'Default'    : Time(0)
    },
    'executing': {
        'Explanation': 'The credential of currently executing task.',
        'Type'       : str,
        'Default'    : 'EMPTY'
    },
    'wait_time': {
        'Explanation': 'The duration when the elevator does not get any request to move the car to the specific floor.',
        'Type'       : Time,
        'Default'    : Time(5)
    }
}


class ElevatorParameters:
    def __init__(self, car, **kwargs):
        specified = set(kwargs.keys())
        for param, value in kwargs.items():
            if param in parameters_table and isinstance(value, parameters_table[param]['Type']):
                if param == 'num_floors':
                    self.__dict__['available_floors'] = range(value)
                    specified.add('available_floors')
                    LOG(msg='Parameter (%s): %r' % ('available_floors'.upper(), self.__dict__['available_floors']), log=Logs.INFO)

                self.__dict__[param] = value
                LOG(msg='Parameter (%s): %r' % (param.upper(), self.__dict__[param]), log=Logs.INFO)
        n_specified = set(parameters_table.keys()).difference(specified)
        for param in n_specified:
            self.__dict__[param] = parameters_table[param]['Default']

            LOG(msg='Parameter (%s): %r' % (param.upper(), self.__dict__[param]), log=Logs.INFO)

        LOG(msg='    SPECIFIED PARAMETERS: %s' % ', '.join(specified))
        LOG(msg='NON-SPECIFIED PARAMETERS: %s' % ', '.join(n_specified))
        self.__dict__['car'] = car

    def set_parameter(self, param, value):
        if param in parameters_table and isinstance(value, parameters_table[param]['Type']) and self.__dict__[param] != value:
            self.__dict__[param] = value
            LOG(msg='Parameter (%s): %r' % (param.upper(), self.__dict__[param]), log=Logs.INFO)
            return True

        return False

    def get_available_floors(self):
        disabled_floors = set(self.__dict__['disabled_floors'])
        all_floors = set(range(self.__dict__['num_floors']))
        return list(all_floors.difference(disabled_floors))

    @classmethod
    def help(cls):
        LOG(msg='PARAMETERS:\n%s' % ('\n'.join(['\t%s --> %s' % (param, desc['Explanation']) for param, desc in parameters_table.items()])))