import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.test_resource import *
from LFOS.Task.Task import TaskFactory
from LFOS.Task.Dependency import DependencyItem
from LFOS.Data.Token import Token

task1 = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='task1', type='DGD', phase=0, deadline=100, periodicity=PeriodicityTypeList.PERIODIC)
task1.set_deadline(50)
task1.add_dependency(DependencyItem(Token('__A__', 1), 2))
task1.add_resource_requirement(resource_type=proc_t, eligible_resources=[cpu, gpu1, memory_1], capacity=1)
task1.add_resource_requirement(resource_type=proc_t, eligible_resources={cpu:35, gpu1:60, memory_1:80}, capacity=1)
task1.add_resource_requirement(resource_type=memory_t, capacity=256)

task1.info(True)