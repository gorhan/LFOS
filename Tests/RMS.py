import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

def generate_timing_attributes(n_tasks):
    from random import randint
    timing_attrs = []

    for task in range(n_tasks):
        release_time = randint(0, 10)
        exec_time = randint(3, 8)
        deadline = randint(release_time+exec_time+5, 40)
        period = randint(exec_time+5, 20)
        # print 'Release_time=%d, Execution_time=%d, Deadline=%d, Period=%d' % (release_time, exec_time, deadline, period)
        timing_attrs.append([release_time, exec_time, deadline, period])

    return timing_attrs

cpu_t = Type(ResourceTypeList.ACTIVE, 'CPU_t')
cpu = ResourceFactory.create_instance(cpu_t, 'CPU')

cpu.set_mode(ModeTypeList.CB_EXCLUSIVE)

pow_cons = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 152)
cpu.set_power_consumption(pow_cons)
cpu.set_capacity(1)

System.add(cpu)

Time.set_time_resolution(0)

tasks = generate_timing_attributes(4)

tasks = [
    [0, 7, 26, 29],
    [3, 3, 32, 28],
    [2, 2, 23, 22],
    [1, 4, 27, 25]
]

task_instances = []
for ind, task in enumerate(tasks):
    task_ins = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_%02d' % (ind+1), type='Default', phase=Time(task[0]), deadline=Time(task[2]), periodicity=PeriodicityTypeList.PERIODIC)
    task_ins.set_period(Time(task[3]))
    task_ins.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu:Time(task[1])}, capacity=1)

    # print task_ins.info(True)

    task_instances.append(task_ins)


scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
scheduler.add_tasks_in_bundle(*task_instances)

scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.RM, scheduler.get_taskset())

scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(40))

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()

new_cpu = ResourceFactory.create_instance(cpu_t, 'N_CPU')
new_cpu.set_mode(ModeTypeList.CB_EXCLUSIVE)
new_cpu.set_power_consumption(pow_cons)
new_cpu.set_capacity(1)

System.add(new_cpu)

for task in task_instances:
    task.add_resource_requirement(resource_type=cpu_t, eligible_resources={new_cpu:task.get_execution_time()})

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()