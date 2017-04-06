from LFOS.Log import LOG, Logs
from LFOS.Task.Priority import Priority, PriorityRanking
from copy import copy

def compareFIFO(task1, task2):
    return -1

def compareEDF(task1, task2):
    return task1.get_deadline() - task2.get_deadline()

def compareSJF(task1, task2):
    return task1.get_execution_time() - task2.get_execution_time()

def compareLJF(task1, task2):
    return -compareSJF(task1, task2)

def compareRM(task1, task2):
    return task1.get_period() - task2.get_period()

def compareERT(task1, task2):
    return task1.get_release_time() - task2.get_release_time()


class SchedulingPolicyRankingTypes:
    FIFO = 'Scheduling.Characteristic.Policy.Ranking.FIFO'
    EDF = 'Scheduling.Characteristic.Policy.Ranking.EDF'
    SJF = 'Scheduling.Characteristic.Policy.Ranking.SJF'
    LJF = 'Scheduling.Characteristic.Policy.Ranking.LJF'
    RM = 'Scheduling.Characteristic.Policy.Ranking.RM'
    ERT = 'Scheduling.Characteristic.Policy.Ranking.ERT'


class SchedulingPolicy:
    RANKING_COMPARE={
        SchedulingPolicyRankingTypes.FIFO: compareFIFO,
        SchedulingPolicyRankingTypes.EDF: compareEDF,
        SchedulingPolicyRankingTypes.SJF: compareSJF,
        SchedulingPolicyRankingTypes.LJF: compareLJF,
        SchedulingPolicyRankingTypes.RM: compareRM,
        SchedulingPolicyRankingTypes.ERT: compareERT
    }

    def __init__(self, taskset=[], ranking=SchedulingPolicyRankingTypes.FIFO, grouping=False):
        self.__ranking = ranking
        self.__grouping = grouping
        self.__taskset = taskset

    def set_ranking_policy(self, new_policy, taskset):
        if new_policy in SchedulingPolicy.RANKING_COMPARE:
            self.__ranking = new_policy
            self.__taskset = taskset
            LOG(msg='New Scheduling Ranking Policy has been set. Policy=%s' % self.__ranking)
            self.sort_tasks()
            return True

        return False

    def activate_grouping(self):
        self.__grouping = True

    def deactivate_grouping(self):
        self.__grouping = False

    def is_grouping_activated(self):
        return self.__grouping

    def update_taskset(self, taskset):
        self.__taskset = taskset

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

    def __group_tasks(self):
        if self.__taskset and self.__taskset[0].get_importance_levels():
            num_levels = len(self.__taskset[0].get_importance_levels())
        else:
            num_levels = 0

        for task in self.__taskset:
            num_levels = min(len(task.get_importance_levels()), num_levels)

        LOG(msg='Number of importance levels=%d' % num_levels)

        intervals = [(0, len(self.__taskset))]
        sub_intervals = []
        for level in range(num_levels):
            while intervals:
                begin, end = intervals.pop(0)
                print 'Start', begin, 'End', end, 'Level', level
                self.__taskset[begin:end] = sorted(self.__taskset[begin:end], key=lambda task: task.get_importance_levels()[level])
                for temp in self.__taskset[begin:end]:
                    print '%s --> %r' % (temp.name, temp.levels)
                SchedulingPolicy.determine_intervals(self.__taskset[begin:end], level, sub_intervals, begin)

            if level == num_levels - 1:
                for begin, end in sub_intervals:
                    self.__taskset[begin:end] = sorted(self.__taskset[begin:end], cmp=SchedulingPolicy.RANKING_COMPARE[self.__ranking])

            intervals = copy(sub_intervals)
            sub_intervals = []

    @staticmethod
    def prioritize_taskset(taskset):
        Priority.set_class_vars(0, len(taskset), PriorityRanking.ASCENDING)
        for priority, task in enumerate(taskset):
            LOG(msg='Task=%r' % task.get_credential())
            task.set_priority(priority)


    def sort_tasks(self):
        if self.__grouping:
            self.__group_tasks()
        else:
            self.__taskset = sorted(self.__taskset, cmp=SchedulingPolicy.RANKING_COMPARE[self.__ranking])

        SchedulingPolicy.prioritize_taskset(self.__taskset)
