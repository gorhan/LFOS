import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Resource.Resource import *
from LFOS.macros import *

'''
Create Type object with the corresponding resource type and name
>>> Type(abstraction, identifier)

abstraction :
	ResourceTypeList.ACTIVE,
	ResourceTypeList.PASSIVE,
	ResourceTypeList.COMPOSITE
identifier : str
'''
proc_t = Type(ResourceTypeList.ACTIVE, 'CPU_T')
mem_t = Type(ResourceTypeList.PASSIVE, 'MEMORY_T')
'''
Create Resource object using defined Type object and resource name.
>>> ResourceFactory.create_instance(_type, res_name, parent=None)

_type :
	ResourceTypeList.ACTIVE,
	ResourceTypeList.PASSIVE,
	ResourceTypeList.COMPOSITE
res_name : str
parent : Resource
'''
cpu_1 = ResourceFactory.create_instance(proc_t, 'CPU_1')
mem_1 = ResourceFactory.create_instance(mem_t, 'Memory_1')

'''
Create PowerConsumption object using PowerFactory class with the parameters:
>>> PowerFactory.create_instance(_type, min_scale, min_pow_cons, max_scale=None, max_pow_cons=None)

_type :
	PowerTypeList.FIXED_STATE_POWER_CONSUMPTION,
	PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION,
	PowerTypeList.CONTINUOUS_STATE_POWER_CONSUMPTION
min_scale : float
min_power_consumption : float
max_scale : float
max_power_consumption : float
'''
pow_cpu_1 = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, 0.3, 50, 1.0, 200)
pow_mem_1 = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 35)

# Add new power state to the object
pow_cpu_1.add_state(0.6, 132)
pow_mem_1.add_state(0.7, 123) # gives error

# Set the power consumption of Resource object
cpu_1.set_power_consumption(pow_cpu_1)
mem_1.set_power_consumption(pow_mem_1)

cpu_1.set_mode(ModeTypeList.CB_AND_SB_EXCLUSIVE)
mem_1.set_mode(ModeTypeList.SHARED)

cpu_1.add_exclusive_resource(mem_1)
mem_1.add_exclusive_resource(cpu_1) # gives warning, has no effect

# Set the capacity of Resource object
cpu_1.set_capacity(1)
mem_1.set_capacity(4096)

# Add the resource to the root container named 'System', which is composite resource.
System.add(cpu_1)
System.add(mem_1)
System.pretty_print()
