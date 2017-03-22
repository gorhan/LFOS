import os
import sys
sys.path.insert(0, os.path.abspath('..'))

# from ElevatorScheduler.elevator_params import Direction, reverse_direction
from ElevatorParameters import *
from LFOS.Log import LOG, Logs


class WaitingQueue:
    def __init__(self):
        self.__q = {UP():[], DOWN():[]}
        self.__first_dir = UP()

    def add(self, _task, _direction):
        if not self.__q[-_direction] and self.__first_dir != _direction:
            self.__first_dir = _direction
            LOG(msg='First Come Direction has been updated. Direction=%s' % (_direction))

        if _task in self.__q[_direction] or _task in self.__q[-_direction]:
            LOG(msg='The task has already been in the waiting list.')
            return False

        self.__q[_direction].append(_task)
        LOG(msg='The task has been appended to the waiting list. Direction=%s Content=%s' % (_direction, ', '.join(task.get_credential() for task in self.__q[_direction])))
        return True

    def add_all(self, task_list_w_dir):
        assert isinstance(task_list_w_dir, list)
        map(lambda item: self.add(*item), task_list_w_dir)

    def remove(self, _task):
        direction, index = self.search(_task)
        if direction:
            self.__q[direction].pop(index)
            if self.empty(direction):
                self.__first_dir = -direction
            return True

        return False

    def empty(self, _direction=None):
        if _direction is None:
            return not (self.__q[UP()] or self.__q[DOWN()])
        elif _direction == UP() or _direction == DOWN():
            return not self.__q[_direction]

        LOG(msg='Invalid argument has been given...')
        return False

    def fetch(self):
        ready_list = self.__q[self.__first_dir]
        self.__q[self.__first_dir] = []
        self.__first_dir = -self.__first_dir
        return ready_list

    def fetch_tasks_wrt_direction(self, _direction):
        task_list = self.__q[_direction]
        self.__q[_direction] = []
        self.__first_dir = -_direction
        return task_list

    def search(self, _task):
        if _task in self.__q[UP()]:
            return UP(), self.__q[UP()].index(_task)
        if _task in self.__q[DOWN()]:
            return DOWN(), self.__q[DOWN()].index(_task)

        LOG(msg='Given task is NOT in the waiting list...', log=Logs.ERROR)
        return None, -1

    def iter(self):
        for task in self.__q[self.__first_dir]:
            yield task
        for task in self.__q[-self.__first_dir]:
            yield task

    def __str__(self):
        out  = '%15s --> %s\n' % (UP(), ', '.join('%s' % item for item in self.__q[UP()]))
        out += '%15s --> %s\n' % (DOWN(), ', '.join('%s' % item for item in self.__q[DOWN()]))
        out += 'First Direction --> %15s' % (self.__first_dir)
        return out
