from LFOS.Log import LOG, Logs
from copy import copy
from operator import methodcaller, itemgetter

def compareFIFO(task1, task2):
    return -1

def compareEDF(task1, task2):
    return task1.get_deadline() - task2.get_deadline()

def compareSJF(task1, task2):
    return task1.get_execution_time() - task2.get_execution_time()

def compareRM(task1, task2):
    return task1.get_period() - task2.get_period()

def compareERT(task1, task2):
    return task1.get_release_time() - task2.get_release_time()


class SchedulingPolicyRankingTypes:
    FIFO = 'Scheduling.Characteristic.Policy.Ranking.FIFO'
    EDF = 'Scheduling.Characteristic.Policy.Ranking.EDF'
    SJF = 'Scheduling.Characteristic.Policy.Ranking.SJF'
    RM = 'Scheduling.Characteristic.Policy.Ranking.RM'
    ERT = 'Scheduling.Characteristic.Policy.Ranking.ERT'


class SchedulingPolicy:
    RANKING_COMPARE={
        SchedulingPolicyRankingTypes.FIFO: compareFIFO,
        SchedulingPolicyRankingTypes.EDF: compareEDF,
        SchedulingPolicyRankingTypes.SJF: compareSJF,
        SchedulingPolicyRankingTypes.RM: compareRM,
        SchedulingPolicyRankingTypes.ERT: compareERT
    }

    def __init__(self, ranking=SchedulingPolicyRankingTypes.FIFO, grouping=False):
        self.__ranking = ranking
        self.__grouping = grouping

    def set_ranking_policy(self, new_policy):
        if new_policy in SchedulingPolicy.RANKING_COMPARE:
            self.__ranking = new_policy
            LOG(msg='New Scheduling Ranking Policy has been set. Policy=%s' % self.__ranking)
            return True

        return False

    def activate_grouping(self):
        self.__grouping = True

    def deactivate_grouping(self):
        self.__grouping = False

    def is_grouping_activated(self):
        return self.__grouping

    @staticmethod
    def determine_intervals(taskset, level, index_list, begin):
        interval_begin = begin
        curr_importance = taskset[0].get_importance_levels()[level]
        for id, task in enumerate(taskset):
            if curr_importance != task.get_importance_levels()[level]:
                curr_importance = task.get_importance_levels()[level]
                index_list.append((interval_begin, id + begin + 1))
                interval_begin = id + begin + 1

        if interval_begin != len(taskset) + begin:
            index_list.append((interval_begin, len(taskset) + begin))

    def __group_tasks(self, taskset):
        if taskset and taskset[0].get_importance_levels():
            num_levels = len(taskset[0].get_importance_levels())
        else:
            num_levels = 0

        for task in taskset:
            num_levels = min(len(task.get_importance_levels()), num_levels)

        LOG(msg='Number of importance levels=%d' % num_levels)

        intervals = [(0, len(taskset))]
        sub_intervals = []
        for level in range(num_levels):
            while intervals:
                begin, end = intervals.pop(0)
                print 'Start', begin, 'End', end, 'Level', level
                taskset[begin:end] = sorted(taskset[begin:end], key=lambda task: task.get_importance_levels()[level])
                for temp in taskset[begin:end]:
                    print '%s --> %r' % (temp.name, temp.levels)
                SchedulingPolicy.determine_intervals(taskset[begin:end], level, sub_intervals, begin)

            intervals = copy(sub_intervals)
            sub_intervals = []

    def sort_tasks(self, taskset):
        assert type(taskset) is list

        if self.__grouping:
            self.__group_tasks(taskset)

        taskset.sort(cmp=SchedulingPolicy.RANKING_COMPARE[self.__ranking])
