import os
import sys
sys.path.insert(0, os.path.abspath('..'))
from LFOS.Log import LOG, Logs
from LFOS.Scheduling.Characteristic.Time import Time

class Task:
    pass
class CarCall(Task):
    def __eq__(self, other):
        return isinstance(other, CarCall)
class HallCall(Task):
    def __eq__(self, other):
        return isinstance(other, HallCall)

class Direction:
    pass
class UP(Direction):
    def __neg__(self):
        return DOWN()
    def __eq__(self, other):
        return isinstance(other, UP)
    def __str__(self):
        return 'Direction.UP'
class DOWN(Direction):
    def __neg__(self):
        return UP()
    def __eq__(self, other):
        return isinstance(other, DOWN)
    def __str__(self):
        return 'Direction.DOWN'


class PassengerPriority:
    pass
class NORMAL(PassengerPriority):
    def __str__(self):
        return 'PassengerPriority.NOMAL'
class HIGH(PassengerPriority):
    def __str__(self):
        return 'PassengerPriority.HIGH'
class URGENT(PassengerPriority):
    def __str__(self):
        return 'PassengerPriority.URGENT'


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
    'direction': {
        'Explanation': 'The direction of the car.',
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
        'Default'    : 'Mistral'
    },
    'verbose': {
        'Explanation': 'The level of information printed during solver execution.',
        'Type'       : int,
        'Default'    : 0
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
    }
}


class ElevatorParameters:
    def __init__(self, car, **kwargs):
        for param, desc in parameters_table.items():
            if param in kwargs and isinstance(kwargs[param], desc['Type']):
                self.__dict__[param] = kwargs[param]
            else:
                self.__dict__[param] = desc['Default']

            LOG(msg='Parameter (%s): %r' % (param, self.__dict__[param]), log=Logs.INFO)

        self.__dict__['car'] = car

    @classmethod
    def help(cls):
        LOG(msg='PARAMETERS:\n%s' % ('\n'.join(['\t%s --> %s' % (param, desc['Explanation']) for param, desc in parameters_table.items()])))