
class Tasks:
    HallCall = 'Tasks.HallCall'
    CarCall = 'Tasks.CarCall'

class HallCall(Tasks):
    pass

class CarCall(Tasks):
    pass


class Direction:
    UP = 'Direction.UP'
    DOWN = 'Direction.DOWN'


class PassengerPriority:
    URGENT = 'PassengerPriority.URGENT'
    HIGH = 'PassengerPriority.HIGH'
    NORMAL = 'PassengerPriority.NORMAL'


def reverse_direction(_direction):
    return Direction.UP if _direction == Direction.DOWN else Direction.DOWN

def num_class_vars(cls):
    return len([var for var in cls.__dict__.keys() if not (var.startswith('__') and var.endswith('__'))])

# number_of_floors = 16
# number_of_passengers_per_car = 8