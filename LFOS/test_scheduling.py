import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *

# Initialize resource types
memory_t = Type(PASSIVE, 'Memory')
antenna_t = Type(PASSIVE, 'Antenna')
bus_t = Type(PASSIVE, 'Bus')
sensor_t = Type(PASSIVE, 'Sensor')
proc_t = Type(ACTIVE, 'CPU')
composite_t = Type(COMPOSITE, 'Composite')

# Initialize resources
antenna = ResourceFactory.create_instance(antenna_t, 'Antenna')
proc_block = ResourceFactory.create_instance(composite_t, 'PROCs')
memory_1 = ResourceFactory.create_instance(memory_t, 'Memory_1')
memory_2 = ResourceFactory.create_instance(memory_t, 'Memory_2')
bus = ResourceFactory.create_instance(bus_t, 'Bus')
prox_sensor = ResourceFactory.create_instance(sensor_t, 'ProximitySensor')
temp_sensor = ResourceFactory.create_instance(sensor_t, 'TemperatureSensor')

cpu_block = ResourceFactory.create_instance(composite_t, 'CPU')
gpu_block = ResourceFactory.create_instance(composite_t, 'GPUs')

cpu = ResourceFactory.create_instance(proc_t, 'CPU')
cpu_cache_block = ResourceFactory.create_instance(composite_t, 'CPU Cache')
gpu1_block = ResourceFactory.create_instance(composite_t, 'GPU1')
gpu2_block = ResourceFactory.create_instance(composite_t, 'GPU2')

cpu_cache_memory_1 = ResourceFactory.create_instance(memory_t, 'CPU Cache Memory 1')
cpu_cache_memory_2 = ResourceFactory.create_instance(memory_t, 'CPU Cache Memory 2')
gpu1 = ResourceFactory.create_instance(proc_t, 'GPU1 Core')
gpu1_cache_memory = ResourceFactory.create_instance(memory_t, 'GPU1 Core Cache')
gpu2 = ResourceFactory.create_instance(proc_t, 'GPU2 Core')
gpu2_cache_memory = ResourceFactory.create_instance(memory_t, 'GPU2 Core Cache')

# Construct resource structure
System.add(antenna)
System.add(proc_block)
System.add(memory_1)
System.add(memory_2)
System.add(bus)
System.add(prox_sensor)
System.add(temp_sensor)

cpu_block.add(cpu)
cpu_cache_block.add(cpu_cache_memory_1)
cpu_cache_block.add(cpu_cache_memory_2)
cpu_block.add(cpu_cache_block)

gpu1_block.add(gpu1)
gpu1_block.add(gpu1_cache_memory)
gpu_block.add(gpu1_block)

gpu2_block.add(gpu2)
gpu2_block.add(gpu2_cache_memory)
gpu_block.add(gpu2_block)

proc_block.add(cpu_block)
proc_block.add(gpu_block)

# Set resource capacities
cpu.set_capacity(1)
memory_1.set_capacity(512)
memory_2.set_capacity(512)

# Initialize power consumption
proc_power_consumption = PowerFactory.create_instance('DSPC', 0.3, 50, 1.0, 200)
proc_power_consumption.add_state(0.65, 100)

mem_power_consumption = PowerFactory.create_instance('FSPC', 1.0, 75)
# Error-1
mem_power_consumption.add_state(0.5, 35)

# Set power consumptions
cpu.set_power_consumption(proc_power_consumption)
memory_1.set_power_consumption(mem_power_consumption)
memory_2.set_power_consumption(mem_power_consumption)

print cpu.get_power().get_power_states()
print memory_1.get_power().get_power_states()
print memory_2.get_power().get_power_states()

System.pretty_print()
System.print_accessibilites()

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