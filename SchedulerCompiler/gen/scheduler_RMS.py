from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

CPU_t = Type(ResourceTypeList.ACTIVE, "CPU_t")
MEM_t = Type(ResourceTypeList.PASSIVE, "MEM_t")
COM_t = Type(ResourceTypeList.COMPOSITE, "COM_t")
SEN_t = Type(ResourceTypeList.PASSIVE, "SEN_t")

cpu_1_A = ResourceFactory.create_instance(CPU_t, "CPU_1")
cpu_1_A.set_capacity(1)
cpu_1_A.set_mode(ModeTypeList.CB_EXCLUSIVE)
pow_cpu_1_A = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, 0.5, 120.0, 1.0, 250.0)
pow_cpu_1_A.add_state(0.7, 175.0)
pow_cpu_1_A.add_state(0.8, 190.0)
cpu_1_A.set_power_consumption(pow_cpu_1_A)

memory_1_P = ResourceFactory.create_instance(MEM_t, "Memory_1")
memory_1_P.set_capacity(1024)
memory_1_P.set_mode(ModeTypeList.SHARED)
pow_memory_1_P = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 125.0)
memory_1_P.set_power_consumption(pow_memory_1_P)

sensors_C = ResourceFactory.create_instance(COM_t, "Sensors")
sensors_C.set_capacity(0)
sensors_C.set_mode(ModeTypeList.SHARED)

temperaturesensor_P = ResourceFactory.create_instance(SEN_t, "temperatureSensor")
temperaturesensor_P.set_capacity(5)
temperaturesensor_P.set_mode(ModeTypeList.SHARED)
pow_temperaturesensor_P = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 150.0)
temperaturesensor_P.set_power_consumption(pow_temperaturesensor_P)

humiditysensor_P = ResourceFactory.create_instance(SEN_t, "HumiditySensor")
humiditysensor_P.set_capacity(5)
humiditysensor_P.set_mode(ModeTypeList.SHARED)
pow_humiditysensor_P = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 150.0)
humiditysensor_P.set_power_consumption(pow_humiditysensor_P)


cpu_1_A.add_exclusive_resource(humiditysensor_P)





System.add(cpu_1_A)
System.add(memory_1_P)
System.add(sensors_C)
sensors_C.add(temperaturesensor_P)
sensors_C.add(humiditysensor_P)

Task_1_NA = TaskFactory.create_instance(name="Task_1", type"NA", phase=Time(0), phase=Time(6), periodicity=PeriodicityTypeList.PERIODIC, deadline_type=DeadlineRequirementTypeList.HARD, preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=["__Task_1_b__", "__Task_1_a__"], token_number=[2, 1])
Task_1_NA.add_resource_requirement(resource_type=CPU_t, eligible_resources={cpu_1_A:Time(4)}, capacity=1)
Task_1_NA.add_resource_requirement(resource_type=MEM_t, eligible_resources=[memory_1_P], capacity=640)

