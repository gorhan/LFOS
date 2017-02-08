
class Tasks:
    HallCall = 'Tasks.HallCall'
    CarCall = 'Tasks.CarCall'

class Direction:
    UP = 'Direction.UP'
    DOWN = 'Direction.DOWN'

def reverse_direction(_direction):
    return Direction.UP if _direction == Direction.DOWN else Direction.DOWN

number_of_floors=16