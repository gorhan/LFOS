from GUI.elevator_params import Tasks, Direction, reverse_direction
from LFOS.Log import LOG, Logs


class WaitingQueue:
    def __init__(self):
        self.__q = {Direction.UP:[], Direction.DOWN:[]}
        self.__first_dir = Direction.UP

    def add(self, _task, _direction):
        if (_direction == Direction.UP and not self.__q[Direction.DOWN]) or\
           (_direction == Direction.DOWN and not self.__q[Direction.UP]):
            self.__first_dir = _direction
            LOG(msg='First Come Direction has been updated. Direction=%s' % (_direction))

        if _task in self.__q[_direction]:
            LOG(msg='The task has already been in the waiting list.')
            return False

        self.__q[_direction].append(_task)
        LOG(msg='The task has been appended to the waiting list. Direction=%s Content=%s' % (_direction, ', '.join(task.get_credential() for task in self.__q[_direction])))
        return True

    def delete(self, _task):
        direction, index = self.search(_task)
        if direction:
            self.__q[direction].pop(index)
            if self.empty(direction):
                self.__first_dir = reverse_direction(direction)


    def empty(self, _direction=None):
        if _direction is None:
            return not (self.__q[Direction.UP] or self.__q[Direction.DOWN])
        elif _direction == Direction.UP or _direction == Direction.DOWN:
            return not self.__q[_direction]

        LOG(msg='Invalid argument has been given...')
        return False

    def fetch(self):
        ready_list = self.__q[self.__first_dir]
        self.__q[self.__first_dir] = []
        self.__first_dir = reverse_direction(self.__first_dir)
        return ready_list

    def fetch_tasks_wrt_direction(self, _direction):
        task_list = self.__q[_direction]
        self.__q[_direction] = []
        self.__first_dir = reverse_direction(_direction)
        return task_list

    def search(self, _task):
        if _task in self.__q[Direction.UP]:
            return Direction.UP, self.__q[Direction.UP].index(_task)
        if _task in self.__q[Direction.DOWN]:
            return Direction.DOWN, self.__q[Direction.DOWN].index(_task)

        LOG(msg='Given task is NOT in the waiting list...', log=Logs.ERROR)
        return None, -1

    def iter(self):
        for task in self.__q[self.__first_dir]:
            raise task
        for task in self.__q[reverse_direction(self.__first_dir)]:
            raise task

