import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.macros import *

# Initialize resource types
memory_t = Type(ResourceTypeList.PASSIVE, 'Memory')
antenna_t = Type(ResourceTypeList.PASSIVE, 'Antenna')
bus_t = Type(ResourceTypeList.PASSIVE, 'Bus')
sensor_t = Type(ResourceTypeList.PASSIVE, 'Sensor')
proc_t = Type(ResourceTypeList.ACTIVE, 'CPU')
composite_t = Type(ResourceTypeList.COMPOSITE, 'Composite')

# Initialize resources
# antenna = ResourceFactory.create_instance(antenna_t, 'Antenna')
# proc_block = ResourceFactory.create_instance(composite_t, 'PROCs')
# memory_1 = ResourceFactory.create_instance(memory_t, 'Memory_1')
# memory_2 = ResourceFactory.create_instance(memory_t, 'Memory_2')
# bus = ResourceFactory.create_instance(bus_t, 'Bus')
# prox_sensor = ResourceFactory.create_instance(sensor_t, 'ProximitySensor')
# temp_sensor = ResourceFactory.create_instance(sensor_t, 'TemperatureSensor')
#
# cpu_block = ResourceFactory.create_instance(composite_t, 'CPU')
# gpu_block = ResourceFactory.create_instance(composite_t, 'GPUs')

cpu1 = ResourceFactory.create_instance(proc_t, 'CPU1')
cpu2 = ResourceFactory.create_instance(proc_t, 'CPU2')

cpu1.set_mode(ModeTypeList.CB_AND_SB_EXCLUSIVE)
cpu1.add_exclusive_resource(cpu2)
# cpu_cache_block = ResourceFactory.create_instance(composite_t, 'CPU Cache')
# gpu1_block = ResourceFactory.create_instance(composite_t, 'GPU1')
# gpu2_block = ResourceFactory.create_instance(composite_t, 'GPU2')
#
# cpu_cache_memory_1 = ResourceFactory.create_instance(memory_t, 'CPU Cache Memory 1')
# cpu_cache_memory_2 = ResourceFactory.create_instance(memory_t, 'CPU Cache Memory 2')
# gpu1 = ResourceFactory.create_instance(proc_t, 'GPU1 Core')
# gpu1_cache_memory = ResourceFactory.create_instance(memory_t, 'GPU1 Core Cache')
# gpu2 = ResourceFactory.create_instance(proc_t, 'GPU2 Core')
# gpu2_cache_memory = ResourceFactory.create_instance(memory_t, 'GPU2 Core Cache')

# Construct resource structure
# System.add(antenna)
# System.add(proc_block)
# System.add(memory_1)
# System.add(memory_2)
# System.add(bus)
# System.add(prox_sensor)
# System.add(temp_sensor)

System.add(cpu1)
System.add(cpu2)
# cpu_cache_block.add(cpu_cache_memory_1)
# cpu_cache_block.add(cpu_cache_memory_2)
# cpu_block.add(cpu_cache_block)
#
# gpu1_block.add(gpu1)
# gpu1_block.add(gpu1_cache_memory)
# gpu_block.add(gpu1_block)
#
# gpu2_block.add(gpu2)
# gpu2_block.add(gpu2_cache_memory)
# gpu_block.add(gpu2_block)
#
# proc_block.add(cpu_block)
# proc_block.add(gpu_block)

# Set resource capacities
cpu1.set_capacity(1)
cpu2.set_capacity(1)
# memory_1.set_capacity(512)
# memory_2.set_capacity(512)

# Initialize power consumption
proc_power_consumption = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, 0.3, 50, 1.0, 200)
proc_power_consumption.add_state(0.65, 100)

# mem_power_consumption = PowerFactory.create_instance('FSPC', 1.0, 75)
# Error-1
# mem_power_consumption.add_state(0.5, 35)

# Set power consumptions
cpu1.set_power_consumption(proc_power_consumption)
cpu2.set_power_consumption(proc_power_consumption)
# memory_1.set_power_consumption(mem_power_consumption)
# memory_2.set_power_consumption(mem_power_consumption)

print cpu1.get_power().get_power_states()
print cpu2.get_power().get_power_states()
# print memory_1.get_power().get_power_states()
# print memory_2.get_power().get_power_states()

System.pretty_print()
System.print_accessibilites()

Time.set_time_resolution(0)

task_1 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_1', type='DGD', phase=Time(0), deadline=Time(5), periodicity=PeriodicityTypeList.PERIODIC)
task_1.set_period(Time(6))
task_1.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(3), cpu2: Time(3)}, capacity=1)
# task_1.add_dependency('__Task_2__', 1)
print task_1.info(True)
task_2 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_2', type='DGD', phase=Time(2), deadline=Time(4), token_num=[3], periodicity=PeriodicityTypeList.APERIODIC)
task_2.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(1), cpu2: Time(1)}, capacity=1)
print task_2.info(True)
task_3 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_3', type='DGD', phase=Time(3), deadline=Time(14), periodicity=PeriodicityTypeList.APERIODIC)
task_3.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(4), cpu2: Time(4)}, capacity=1)
# task_3.add_dependency('__Task_1__', 1, Time(2))
task_3.add_dependency('__Task_1__', 1, Time(3))
task_3.add_dependency('__Task_2__', 1, Time(1))
print task_3.info(True)
task_4 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Task_4', type='DGD', phase=Time(8), deadline=Time(11), periodicity=PeriodicityTypeList.APERIODIC)
task_4.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu1: Time(1), cpu2: Time(1)}, capacity=1)
print task_4.info(True)

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)

scheduler.add_task_in_bundle(task_1, task_2, task_3, task_4)

scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(17))

schedule = scheduler.schedule_tasks()
schedule.plot_schedule()

# print '1'
# task_1 = TaskFactory.create_instance('Terminal', 0, 50, 'hard', 'Task_1', 'DGD')
# task_2 = TaskFactory.create_instance('Terminal', 10, 80, 'hard', 'Task_2', 'DGD')
# print '2'
#
# task_1.set_periodicity(PeriodicityTypeList.PERIODIC)
# task_1.set_period(150)
# task_1.set_preemption(PreemptionTypeList.PARTIALLY_PREEMPTABLE)
# task_1.set_non_preemptable_exec_duration(20)
#
# task_2.set_periodicity(PeriodicityTypeList.PERIODIC)
# task_2.set_period(100)
#
# task_1.add_eligible_resource(proc_1, 30)
# task_2.add_eligible_resource(proc_1, 20)
#
# task_1.add_resource_request(proc_t, 1)
# task_1.add_resource_request(memory_t, 368)
#
# task_2.add_resource_request(proc_t, 1)
# task_2.add_resource_request(memory_t, 368)
#
# scheduler = Scheduler()
# scheduler.add_task_in_bulk([task_1, task_2])
# scheduler.set_scheduler_offline()
# scheduler.set_time_resolution(1.0)
# scheduler.set_scheduling_policy(SchedulingPolicyList.RM)
#
#
# schedule = scheduler.schedule(0, 200)
#
# print schedule