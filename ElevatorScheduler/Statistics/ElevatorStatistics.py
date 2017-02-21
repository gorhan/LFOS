from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Log import Logs, LOG

class ElevatorStatistics:
    def __init__(self, num_floors, base_floor=0):
        self._num_floor = num_floors
        self._base_floor = base_floor
        self._occurrence = {floor: [] for floor in range(self._base_floor, self._num_floor + self._base_floor)}
        self._earliest_call = None
        self._latest_call = None
        self._empty_stats = True

    def reset(self, num_floors, base_floor=0):
        self._num_floor = num_floors
        self._base_floor = base_floor
        self._occurrence = {floor:[] for floor in range(self._base_floor, self._num_floor + self._base_floor)}
        self._earliest_call = None
        self._latest_call = None
        self._empty_stats = True

    def set_num_floors(self, new_num_floors):
        if new_num_floors > self._num_floor:
            self._occurrence = dict(self._occurrence, **{floor:[] for floor in range(self._num_floor + self._base_floor + 1, new_num_floors + self._base_floor)})
            self._num_floor = new_num_floors
            LOG(msg='New floors have been appended to the statistics...')
            return True

        LOG(msg='Invalid request. The given number of floors is less than the current number of floors. To do that please reset the stats with new number of floors.', log=Logs.ERROR)
        return False

    def get_num_floors(self):
        return self._num_floor

    def get_earliest_call(self):
        return self._earliest_call

    def get_latest_call(self):
        return self._latest_call

    def call(self, floor, _time):
        if floor not in self._occurrence:
            LOG(msg='Given floor is not in the list of available floors...', log=Logs.ERROR)
            return False

        if self._empty_stats:
            self._empty_stats = False
            self._earliest_call = [floor, Time(_time)]

        self._latest_call = [floor, Time(_time)]
        self._occurrence[floor].append(Time(_time))
        LOG(msg='%r' % self._occurrence)
        return True

    def get_num_calls(self, floor, begin, end):
        if floor in self._occurrence:
            total_call = sum(map(lambda tm: 1 if begin <= tm <= end else 0, self._occurrence[floor]))
            return [floor, total_call]
        return None

    def get_most_frequent_floor(self, **kwargs):
        begin = self._earliest_call[1] if self._earliest_call else Time(0)
        end = self._latest_call[1] if self._latest_call else Time(0)

        if 'begin' in kwargs:
            begin = Time(kwargs['begin'])
        if 'end' in kwargs:
            end = Time(kwargs['end'])

        total_calls_for_each_floor = [self.get_num_calls(floor, begin, end) for floor in self._occurrence.keys()]
        most_frequent_floor = reduce(lambda floor1, floor2: floor1 if floor1[1] > floor2[1] else floor2, total_calls_for_each_floor)
        return most_frequent_floor if most_frequent_floor[1] != 0 else [self._base_floor, 0]