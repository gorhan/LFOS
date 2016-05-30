import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Task.Task import *
from LFOS.Resource.Resource import *
from LFOS.Scheduler.Scheduler import *

# Initialize resource types
memory_t = ResourceType('Memory', PASSIVE)
proc_t = ResourceType('CPU', ACTIVE)

# Initialize resources
proc_1 = ResourceFactory.create_instance(proc_t, 'CPU_1')
mem_1 = ResourceFactory.create_instance(memory_t, 'MEM_1')

# Construct resource structure
System.add(proc_1)
System.add(mem_1)

# Set resource capacities
proc_1.set_total_capacity(1)
mem_1.set_total_capacity(4096)

# Initialize power consumption
proc_power_consumption = PowerConsumptionFactory.create_instance('DSPC', 0.3, 50, 1.0, 200)
proc_power_consumption.add_state(0.65, 100)

mem_power_consumption = PowerConsumptionFactory.create_instance('FSPC', 1.0, 75)
# Error-1
mem_power_consumption.add_state(0.5, 35)

# Set power consumptions
proc_1.set_power_consumption(proc_power_consumption)
mem_1.set_power_consumption(mem_power_consumption)

print proc_1.get_power_consumption().get_power_states()
print mem_1.get_power_consumption().get_power_states()

System.pretty_print()

print '1'
task_1 = TaskFactory.create_instance('Terminal', 0, 50, 'hard', 'Task_1', 'DGD')
task_2 = TaskFactory.create_instance('Terminal', 20, 80, 'hard', 'Task_2', 'DGD')
print '2'

task_1.set_periodicity('periodic')
task_1.set_period(70)

task_2.set_periodicity('periodic')
task_2.set_period(100)

task_1.add_eligible_resource(proc_1, 30)
task_2.add_eligible_resource(proc_1, 20)

task_1.add_resource_request(memory_t, 1)
task_1.add_resource_request(memory_t, 1024)

task_2.add_resource_request(proc_t, 1)
task_2.add_resource_request(memory_t, 1024)

scheduler = Scheduler()
scheduler.add_task_in_bulk([task_1, task_2])
scheduler.set_scheduler_offline()
schedule = scheduler.schedule(0, 1000)

print schedule