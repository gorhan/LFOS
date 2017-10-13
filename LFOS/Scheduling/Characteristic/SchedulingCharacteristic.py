from LFOS.Scheduling.Characteristic.Policy import SchedulingPolicy, SchedulingPolicyRankingTypes
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduling.Characteristic.Type import SchedulingTypes
from LFOS.Scheduling.Characteristic.Migration import MigrationTypes
from LFOS.Scheduling.Characteristic.PriorityAssigment import PriorityAssignmentTypes
from LFOS.Scheduling.Characteristic.SchedWindow import SchedulingWindow
from LFOS.Objective.Factory import *


class SchedulingCharacteristic(SchedulingPolicy, SchedulingWindow, Time):
    def __init__(self):
        SchedulingPolicy.__init__(self)
        Time.__init__(self)
        SchedulingWindow.__init__(self)

        self.__type = SchedulingTypes.OFFLINE
        self.__preemptive = True
        self.__migration = MigrationTypes.JOB_LEVEL_MIGRATION
        self.__priority_assignment = PriorityAssignmentTypes.FIXED
        self._overall_objective = ObjectiveFactory.create_instance(OverallObjective, Mini(), ObjectiveLateness())

    def set_scheduling_objective(self, *args):
        self._overall_objective = ObjectiveFactory.create_instance(OverallObjective, *args)

    def get_scheduling_objective(self):
        return self._overall_objective

    def set_migration(self, new_migration):
        if new_migration == MigrationTypes.JOB_LEVEL_MIGRATION or new_migration == MigrationTypes.TASK_LEVEL_MIGRATION or new_migration == MigrationTypes.NO_MIGRATION:
            self.__migration = new_migration

    def get_migration(self):
        return self.__migration

    def set_preemptive(self, preemptive_flag):
        assert isinstance(preemptive_flag, bool)
        self.__preemptive = preemptive_flag

    def is_preemptive(self):
        return self.__preemptive

    def set_priority_assignment(self, p_assign):
        if p_assign == PriorityAssignmentTypes.FIXED or p_assign == PriorityAssignmentTypes.DYNAMIC:
            self.__priority_assignment = p_assign