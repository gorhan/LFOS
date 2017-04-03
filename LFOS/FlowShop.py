import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from macros import *

resource_t = Type(ResourceTypeList.ACTIVE, 'ResourceType')

jobs = [ [5, 5, 3, 6, 3],
         [4, 4, 2, 4, 4],
         [4, 4, 3, 4, 1],
         [3, 6, 3, 2, 5] ]
jobs = [ [5, 5, 3, 6],
         [4, 4, 2, 4],
         [4, 4, 3, 4],
         [3, 6, 3, 2] ]

num_resources = len(jobs)
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
scheduler.set_scheduling_window_duration(Time(29))

for i, row in enumerate(jobs):
    for j, wcet in enumerate(row):
        task_name = 'Task_%02d_%02d' % (i, j)
        token_name = 'Token_%02d_%02d' % (i, j)

        required_tokens = []
        if i > 0:
            required_tokens.append('Token_%02d_%02d' % (i-1, j))
        if j > 0:
            required_tokens.append('Token_%02d_%02d' % (i, j-1))

        job = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type='T', phase=Time(0),
                                          deadline=Time(29), periodicity=PeriodicityTypeList.APERIODIC, token_name=[token_name], token_num=[2],
                                          preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)

        job.add_resource_requirement(resource_type=resource_t, eligible_resources={resources[i]: Time(wcet)}, capacity=1)
        for token in required_tokens:
            job.add_dependency(AND(), token, 1)
        print job.info(True)
        scheduler.add_task(job)

scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.SJF, scheduler.get_taskset())

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()