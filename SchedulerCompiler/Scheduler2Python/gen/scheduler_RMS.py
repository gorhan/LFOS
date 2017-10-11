from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

COMP_t = Type(COMPOSITE, "COMP_t")
MEM_t = Type(PASSIVE, "MEM_t")
CPU_t = Type(ACTIVE, "CPU_t")

resource_0 = ResourceFactory.create_instance(COMP_t, "System")
resource_0.set_capacity(0)
resource_0.set_mode(ModeTypeList.SHARED)


resource_1 = ResourceFactory.create_instance(CPU_t, "CPU_1")
resource_1.set_capacity(1)
resource_1.set_mode(ModeTypeList.CB_EXCLUSIVE)
pow_resource_1 = PowerFactory.create_instance(PowerTypeList.DISCRETE_STATE_POWER_CONSUMPTION, 0.5, 120.0, 1.0, 250.0)
pow_resource_1.add_state(0.7, 175.0)
pow_resource_1.add_state(0.8, 190.0)
resource_1.set_power_consumption(pow_resource_1)

resource_2 = ResourceFactory.create_instance(MEM_t, "Memory_1")
resource_2.set_capacity(1024)
resource_2.set_mode(ModeTypeList.SHARED)
pow_resource_2 = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 125.0)
resource_2.set_power_consumption(pow_resource_2)

resource_3 = ResourceFactory.create_instance(COMP_t, "Sensors")
resource_3.set_capacity(0)
resource_3.set_mode(ModeTypeList.SHARED)


resource_4 = ResourceFactory.create_instance(SENSOR_t, "temperatureSensor")
resource_4.set_capacity(5)
resource_4.set_mode(ModeTypeList.SHARED)
pow_resource_4 = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 150.0)
resource_4.set_power_consumption(pow_resource_4)

resource_5 = ResourceFactory.create_instance(SENSOR_t, "HumiditySensor")
resource_5.set_capacity(5)
resource_5.set_mode(ModeTypeList.SHARED)
pow_resource_5 = PowerFactory.create_instance(PowerTypeList.FIXED_STATE_POWER_CONSUMPTION, 1.0, 150.0)
resource_5.set_power_consumption(pow_resource_5)


resource_1.add_exclusive_resource(resource_5)




resource_0.add(resource_1)
resource_0.add(resource_2)
resource_0.add(resource_3)
resource_3.add(resource_4)
resource_3.add(resource_5)

