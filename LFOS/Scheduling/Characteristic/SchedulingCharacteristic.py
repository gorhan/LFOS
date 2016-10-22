from LFOS.Scheduling.Characteristic.Policy import SchedulingPolicy, SchedulingPolicyRankingTypes

class SchedulingTypes:
    OFFLINE = 'Scheduling.Characteristic.Type.OFFLINE'
    ONLINE = 'Scheduling.Characteristic.Type.ONLINE'


class MigrationTypes:
    NO_MIGRATION = 'Scheduling.Characteristic.Migration.NoMigration'
    TASK_LEVEL_MIGRATION = 'Scheduling.Characteristic.Migration.TaskLevelMigration'
    JOB_LEVEL_MIGRATION = 'Scheduling.Characteristic.Migration.JobLevelMigration'


class SchedulingCharacteristic(SchedulingPolicy):
    def __init__(self):
        SchedulingPolicy.__init__(self)

        self.__type = SchedulingTypes.ONLINE
        self.__preemptive = True
        self.__migration = MigrationTypes.JOB_LEVEL_MIGRATION