from LFOS.Scheduling.Characteristic.Policy import SchedulingPolicy, SchedulingPolicyRankingTypes
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduling.Characteristic.Type import SchedulingTypes
from LFOS.Scheduling.Characteristic.Migration import MigrationTypes
from LFOS.Scheduling.Characteristic.PriorityAssigment import PriorityAssignmentTypes
from LFOS.Scheduling.Characteristic.SchedWindow import SchedulingWindow


class SchedulingCharacteristic(SchedulingPolicy, SchedulingWindow, Time):
    def __init__(self):
        SchedulingPolicy.__init__(self)
        Time.__init__(self)
        SchedulingWindow.__init__(self)

        self.__type = SchedulingTypes.OFFLINE
        self.__preemptive = True
        self.__migration = MigrationTypes.JOB_LEVEL_MIGRATION
        self.__priority_assignment = PriorityAssignmentTypes.FIXED
