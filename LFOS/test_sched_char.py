import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Scheduling.Characteristic.Policy import SchedulingPolicy, SchedulingPolicyRankingTypes

# class Temp:
#     COUNTER = 1
#     def __init__(self):
#         self.name = 'TEMP_%03d' % Temp.COUNTER
#         Temp.COUNTER += 1
#
#         self.levels = list()
#
#     def add_importance_level(self, level):
#         self.levels.append(level)
#
#     def get_importance_levels(self):
#         return self.levels
#
#
# temps = list()
#
# for _ in range(200):
#     tmp = Temp()
#     tmp.add_importance_level(randint(0, 9))
#     tmp.add_importance_level(randint(0, 9))
#     tmp.add_importance_level(randint(0, 9))
#     temps.append(tmp)
#
# pol = SchedulingPolicy(SchedulingPolicyRankingTypes.FIFO, True)
#
# pol.sort_tasks(temps)
#
# for temp in temps:
#     print '%s --> %r' % (temp.name, temp.levels)