import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

# Initialize resource types
memory_t = Type(ResourceTypeList.PASSIVE, 'Memory')
antenna_t = Type(ResourceTypeList.PASSIVE, 'Antenna')
bus_t = Type(ResourceTypeList.PASSIVE, 'Bus')
sensor_t = Type(ResourceTypeList.PASSIVE, 'Sensor')
proc_t = Type(ResourceTypeList.ACTIVE, 'CPU')
composite_t = Type(ResourceTypeList.COMPOSITE, 'Composite')

# Initialize resources
memory1 = ResourceFactory.create_instance(memory_t, 'Memory1')
memory2 = ResourceFactory.create_instance(memory_t, 'Memory2')


cpu1 = ResourceFactory.create_instance(proc_t, 'CPU1')
cpu2 = ResourceFactory.create_instance(proc_t, 'CPU2')

cpu1.set_mode(ModeTypeList.CB_AND_SB_EXCLUSIVE)
System.add(memory1)
System.add(memory2)

System.add(cpu1)
System.add(cpu2)

# Set resource capacities
cpu1.set_capacity(1)
cpu2.set_capacity(1)
memory1.set_capacity(512)
memory2.set_capacity(512)

# Initialize power consumption
proc_power_consumption = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, 0.5, 50, 1.0, 200)
mem_power_consumption = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 75)

# Set power consumptions
cpu1.set_power_consumption(proc_power_consumption)
cpu2.set_power_consumption(proc_power_consumption)
memory1.set_power_consumption(mem_power_consumption)
memory2.set_power_consumption(mem_power_consumption)

print cpu1.get_power_consumption().get_power_states()
print cpu2.get_power_consumption().get_power_states()

System.pretty_print()
System.print_accessibilites()

Time.set_time_resolution(0)

task_1 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_1_1', type='Default', phase=Time(0), deadline=Time(6), periodicity=PeriodicityTypeList.PERIODIC, preemptability=PreemptionTypeList.NOT_PPREEMPTABLE)
task_1.set_period(Time(6))
task_1.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(3), cpu2: Time(3)}, capacity=1)
task_1.add_resource_requirement(resource_type=memory_t, capacity=650)
# task_1.add_dependency('__Task_2__', 1)
print task_1.info(True)
task_2 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_1_2', type='Default', phase=Time(2), deadline=Time(4), periodicity=PeriodicityTypeList.PERIODIC, preemtability=PreemptionTypeList.NOT_PPREEMPTABLE)
task_2.set_period(Time(4))
task_2.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(1), cpu2: Time(1)}, capacity=1)
print task_2.info(True)
task_3 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2_1', type='Default', phase=Time(3), deadline=Time(14), periodicity=PeriodicityTypeList.APERIODIC)
task_3.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(4), cpu2: Time(4)}, capacity=1)
task_3.add_resource_requirement(resource_type=memory_t, capacity=140)
# task_3.add_dependency('__Task_1__', 1, Time(2))
task_3.add_dependency('__Task_1_1__', 1, Time(3))
task_3.add_dependency('__Task_1_2__', 1, Time(2))
print task_3.info(True)
task_4 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2_2', type='Default', phase=Time(8), deadline=Time(11), periodicity=PeriodicityTypeList.APERIODIC)
task_4.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(1), cpu2: Time(1)}, capacity=1)
task_4.add_dependency('__Task_1_1__', 1, Time(1))
task_4.add_dependency('__Task_1_2__', 1, Time(2))
print task_4.info(True)

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)

scheduler.add_task_in_bundle(task_1, task_2, task_3, task_4)

scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.FIFO)

scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(18))

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()