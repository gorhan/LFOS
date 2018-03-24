import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.macros import *


def read_from_file(filename):
    fp = open(filename, 'r')
    jobs = []
    if fp:
        data = [map(int, row.split(' ')) for row in fp.read().strip().split('\n')]
        # print data
        for job in data:
            num_operations = len(job)/2
            pairs = []
            for op in range(num_operations):
                pairs.append(job[op*2:(op+1)*2])
            jobs.append(pairs)

    return jobs

if __name__ == '__main__':

    resource_t = Type(ResourceTypeList.ACTIVE, 'ResourceType')
    jobs = None
    if len(sys.argv) == 2:
        jobs = read_from_file(sys.argv[1])
        # print jobs
        # raw_input('Wait')
    else:
        jobs = [
            [(0, 3), (1, 2), (2, 2)],
            [(0, 2), (2, 1), (1, 4)],
            [(1, 4), (2, 3)]
        ]

    num_resources = 4
    resources = []
    tasks = {}
    for i in range(num_resources):
        resource = ResourceFactory.create_instance(resource_t, 'Resource_%02d' % (i+1))
        resource.set_capacity(1)
        resource_pc = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 200)
        resource.set_power_consumption(resource_pc)
        System.add(resource)
        resources.append(resource)

    scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
    scheduler.set_scheduling_window_start_time(Time(0))
    scheduler.set_scheduling_window_duration(Time(35))

    for j, prec in enumerate(jobs):
        job_name = 'Job_%02d' % (j+1)
        for o, (m, wcet) in enumerate(prec):
            task_name = 'Task_%02d' % (o+1)
            token_name = 'Token_%02d_%02d' % (j+1, o+1)

            job = TaskFactory.create_instance(TaskTypeList.TERMINAL, name=task_name, type=job_name, phase=Time(0),
                                              deadline=Time(35), periodicity=PeriodicityTypeList.APERIODIC, token_name=[token_name],
                                              preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)

            job.add_resource_requirement(resource_type=resource_t, eligible_resources={resources[m]: Time(wcet)}, capacity=1)

            if o > 0:
                required_token = 'Token_%02d_%02d' % (j+1, o)
                job.set_logical_relation(AND())
                job.add_dependency(required_token, 1)

            print job.info(True)
            scheduler.add_task(job)
            tasks[o+1, j+1] = job

    scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.LJF, scheduler.get_taskset())

    schedules = scheduler.schedule_tasks()
    for schedule in schedules:
        schedule.plot_schedule()

    tasks[1,1].set_release_time(Time(2))
    tasks[2,3].set_release_time(Time(21))

    schedules = scheduler.schedule_tasks()
    for schedule in schedules:
        schedule.plot_schedule()