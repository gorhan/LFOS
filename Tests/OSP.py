import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.macros import *

resource_t = Type(ResourceTypeList.ACTIVE, 'ResourceType')

jobs = [ [1, 3, 2],
         [2, 1, 1],
         [2, 2, 1],
         [2, 2, 2],
         [3, 1, 1]
       ]
r = [1, 1, 3, 3, 3]
d = [11, 9, 8, 9, 11]

num_resources = len(jobs[0])
resources = []
for i in range(num_resources):
    resource = ResourceFactory.create_instance(resource_t, 'Resource_%02d' % (i+1))
    resource.set_capacity(1)
    resource_pc = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 200)
    resource.set_power_consumption(resource_pc)
    System.add(resource)
    resources.append(resource)

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(15))

for i, row in enumerate(jobs):
    job_name = 'Job_%02d' % (i+1)
    operations = []
    for j, wcet in enumerate(row):
        task_name = 'Task_%02d' % (j+1)

        job = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type=job_name, phase=Time(r[i]),
                                          deadline=Time(d[i]), periodicity=PeriodicityTypeList.APERIODIC,
                                          preemptability=PreemptionTypeList.FULLY_PREEMPTABLE)
        job.add_resource_requirement(resource_type=resource_t, eligible_resources={resources[j]: Time(wcet)},
                                     capacity=1)

        job.add_m_exclusion_list(operations)
        operations.append(job)
        print job.info(True)
        scheduler.add_task(job)

scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO, scheduler.get_taskset())

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()
