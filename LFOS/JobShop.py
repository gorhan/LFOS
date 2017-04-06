import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from macros import *

resource_t = Type(ResourceTypeList.ACTIVE, 'ResourceType')

jobs = [
    [(0, 3), (1, 2), (2, 2)],
    [(0, 2), (2, 1), (1, 4)],
    [(1, 4), (2, 3)]
]

num_resources = 3
resources = []
for i in range(num_resources):
    resource = ResourceFactory.create_instance(resource_t, 'Resource_%02d' % i)
    resource.set_capacity(1)
    resource_pc = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 200)
    resource.set_power_consumption(resource_pc)
    System.add(resource)
    resources.append(resource)

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(20))

for j, prec in enumerate(jobs):
    for o, (m, wcet) in enumerate(prec):
        task_name = 'Task_%02d_%02d' % (j, o)
        token_name = 'Token_%02d_%02d' % (j, o)

        job = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type='T', phase=Time(0),
                                          deadline=Time(20), periodicity=PeriodicityTypeList.APERIODIC, token_name=[token_name],
                                          preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)

        job.add_resource_requirement(resource_type=resource_t, eligible_resources={resources[m]: Time(wcet)}, capacity=1)

        if o > 0:
            required_token = 'Token_%02d_%02d' % (j, o-1)
            job.add_dependency(AND(), required_token, 1)

        print job.info(True)
        scheduler.add_task(job)

scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.LJF, scheduler.get_taskset())

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()