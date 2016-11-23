import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.Task.Task import TaskFactory, TaskTypeList
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.macros import *

city_t = Type(ResourceTypeList.ACTIVE, 'CityType')
city_r = ResourceFactory.create_instance(city_t, 'City')
city_r.set_capacity(1)

city_pc = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 200)
city_r.set_power_consumption(city_pc)

System.add(city_r)

System.pretty_print()
System.print_accessibilites()

Time.set_time_resolution(0)


cities = ['A', 'B', 'C', 'D']
Distances = [
    [ 0,  2, 10,  9],
    [ 2,  0,  5,  5],
    [10,  5,  0,  8],
    [ 9,  5,  8,  0]
]

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
scheduler.add_token('__Init__', Time(0), 1)
scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(40))

Cs = list()

start_city = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='City_S', type='TSP', phase=Time(0), deadline=Time(40), periodicity=PeriodicityTypeList.APERIODIC, token_name=['__City_A__'])
start_city.add_resource_requirement(resource_type=city_t, eligible_resources={city_r: Time(1)}, capacity=1)
start_city.add_dependency('__Init__', 1)
print start_city.info(True)
Cs.append(start_city)

scheduler.add_task(start_city)

for i1, city1 in enumerate(cities):
    Cs.append(TaskFactory.create_instance(TaskTypeList.TERMINAL, name='City_%s' % city1, type='TSP', phase=Time(0), deadline=Time(40), periodicity=PeriodicityTypeList.APERIODIC))
    Cs[-1].add_resource_requirement(resource_type=city_t, eligible_resources={city_r: Time(1)}, capacity=1)

    for i2, city2 in enumerate(cities):
        if i1 == i2:
            continue
        Cs[-1].add_dependency('__City_%s__' % city2, 1, Time(Distances[i1][i2]))

    print Cs[-1].info(True)
    scheduler.add_task(Cs[-1])

finish_city = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='City_F', type='TSP', phase=Time(0), deadline=Time(40), periodicity=PeriodicityTypeList.APERIODIC, token_name=['__City_F__'])
finish_city.add_resource_requirement(resource_type=city_t, eligible_resources={city_r: Time(1)}, capacity=1)
finish_city.add_dependency('__City_A__', 1)

scheduler.add_task(finish_city)

print scheduler.schedule_tasks()