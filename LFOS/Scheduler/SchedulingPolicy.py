from enum import Enum


def compareFIFO(task1, task2):
    return task1.get_phase() - task2.get_phase()


def compareEDF(task1, task2):
    return task1.get_deadline() - task2.get_deadline()


def compareRM(task1, task2):
    return task1.get_period() - task2.get_period()


def compareSJF(task1, task2):
    return task1.get_wcet() - task2.get_wcet()


def compareERT(task1, task2):
    return task1.get_release_time() - task2.get_release_time()


def compareGROUP(task1, task2):
    return task1.get_task_type_importance().get_priority() - task2.get_task_type_importance().get_priority()


class SchedulingPolicyList(Enum):
    FIFO = 'First-In-First-Out'
    RM = 'Rate Monotonic'
    EDF = 'Earliest Deadline First'
    SJF = 'Shortest Job First'
    ERT = 'Earliest Release Time'
    GROUP = 'Task Type Grouping'


SchedulingPolicy2OrderFunctionTable = {
    SchedulingPolicyList.FIFO: compareFIFO,
    SchedulingPolicyList.RM: compareRM,
    SchedulingPolicyList.EDF: compareEDF,
    SchedulingPolicyList.SJF: compareSJF,
    SchedulingPolicyList.ERT: compareERT,
    SchedulingPolicyList.GROUP: compareGROUP
}


class SchedulingPolicy(object):
    def __init__(self, policy):
        self.__policy = policy
        self.__grouping_flag = False

    def set_policy(self, policy):
        self.__policy = policy

    def get_policy(self):
        return self.__policy

    def grouping_active(self):
        return self.__grouping_flag

    def set_grouping(self, flag):
        self.__grouping_flag = flag

    @staticmethod
    def cmp_grouping():
        return SchedulingPolicy2OrderFunctionTable[SchedulingPolicyList.GROUP]

    def cmp_ranking(self):
        return SchedulingPolicy2OrderFunctionTable[self.__policy]
