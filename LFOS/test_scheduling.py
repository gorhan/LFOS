import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Task.Task import *
from LFOS.Task.Periodicity import PeriodicityTypeList
from LFOS.Task.Preemption import PreemptionTypeList
from LFOS.Resource.Resource import *
from LFOS.Scheduler.Scheduler import *

# Initialize resource types
memory_t = ResourceType('Memory', PASSIVE)
proc_t = ResourceType('CPU', ACTIVE)

# Initialize resources
proc_1 = ResourceFactory.create_instance(proc_t, 'CPU_1')
mem_1 = ResourceFactory.create_instance(memory_t, 'MEM_1')
mem_2 = ResourceFactory.create_instance(memory_t, 'MEM_2')

# Construct resource structure
System.add(proc_1)
System.add(mem_1)
System.add(mem_2)

# Set resource capacities
proc_1.set_total_capacity(1)
mem_1.set_total_capacity(512)
mem_2.set_total_capacity(512)

# Initialize power consumption
proc_power_consumption = PowerConsumptionFactory.create_instance('DSPC', 0.3, 50, 1.0, 200)
proc_power_consumption.add_state(0.65, 100)

mem_power_consumption = PowerConsumptionFactory.create_instance('FSPC', 1.0, 75)
# Error-1
mem_power_consumption.add_state(0.5, 35)

# Set power consumptions
proc_1.set_power_consumption(proc_power_consumption)
mem_1.set_power_consumption(mem_power_consumption)
mem_2.set_power_consumption(mem_power_consumption)

print proc_1.get_power_consumption().get_power_states()
print mem_1.get_power_consumption().get_power_states()

System.pretty_print()

print '1'
task_1 = TaskFactory.create_instance('Terminal', 0, 50, 'hard', 'Task_1', 'DGD')
task_2 = TaskFactory.create_instance('Terminal', 10, 80, 'hard', 'Task_2', 'DGD')
print '2'

task_1.set_periodicity(PeriodicityTypeList.PERIODIC)
task_1.set_period(150)
task_1.set_preemption(PreemptionTypeList.PARTIALLY_PREEMPTABLE)
task_1.set_non_preemptable_exec_duration(20)

task_2.set_periodicity(PeriodicityTypeList.PERIODIC)
task_2.set_period(100)

task_1.add_eligible_resource(proc_1, 30)
task_2.add_eligible_resource(proc_1, 20)

task_1.add_resource_request(proc_t, 1)
task_1.add_resource_request(memory_t, 368)

task_2.add_resource_request(proc_t, 1)
task_2.add_resource_request(memory_t, 368)

scheduler = Scheduler()
scheduler.add_task_in_bulk([task_1, task_2])
scheduler.set_scheduler_offline()
scheduler.set_time_resolution(1.0)
scheduler.set_scheduling_policy(SchedulingPolicyList.RM)


schedule = scheduler.schedule(0, 200)

print schedule