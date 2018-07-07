import os
import sys
sys.path.insert(0, os.path.abspath('..'))

from LFOS.Scheduler.Scheduler import Scheduler
from LFOS.Resource.Resource import *
from LFOS.Task.Task import *
from LFOS.Scheduling.Characteristic.Time import Time
from LFOS.macros import *

cpu_t = Type(ResourceTypeList.ACTIVE, "CPU_t")
memory_t = Type(ResourceTypeList.PASSIVE, "Memory_t")
distributed_t = Type(ResourceTypeList.COMPOSITE, "Distributed_t")

num_distributed = 2
num_resources = 2
resources = {"Node":[],
             "CPU":[],
             "MEM":[]}
memory_capacities = [2048, 1024]
for node_id in range(num_distributed):
    dist_r = ResourceFactory.create_instance(distributed_t, "Node_%02d" % (node_id+1))
    System.add(dist_r)
    resources["Node"].append(dist_r)
    for resource_id in range(num_resources):
        cpu_r = ResourceFactory.create_instance(cpu_t, "CPU_%02d::%s" % (resource_id+1, "Node_%02d" % (node_id+1)))
        cpu_r.set_capacity(1)

        dist_r.add(cpu_r)
        resources["CPU"].append(cpu_r)

    # Add memory
    mem_r = ResourceFactory.create_instance(memory_t, "Memory::Node_%02d" % (node_id+1))
    mem_r.set_capacity(memory_capacities.pop(0))
    dist_r.add(mem_r)
    resources["MEM"].append(mem_r)

# System.pretty_print()
end = 20

scheduler = Scheduler(solver='SCIP', verbose=1, time_cutoff=10000)
scheduler.set_scheduling_window_start_time(Time(0))
scheduler.set_scheduling_window_duration(Time(end))

# Task generation
calibrate = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Calibrate', type='Input',
                                        phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                        preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['Calibrated'], token_num=[100])
calibrate.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu:Time(1) for cpu in resources["CPU"]}, capacity=1)
# calibrate.add_resource_requirement(resource_type=memory_t, capacity=640)

get_data_cb = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='GetData', type='Input',
                                        phase=Time(0), deadline=Time(3), periodicity=PeriodicityTypeList.PERIODIC,
                                        preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['Data'])
get_data_cb.set_period(Time(3))
get_data_cb.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu:Time(1) for cpu in resources["CPU"]}, capacity=1)
get_data_cb.set_logical_relation(AND())
get_data_cb.add_dependency("Calibrated", 1)

scheduler.add_tasks_in_bundle(calibrate, get_data_cb)
scheduler.set_ranking_policy(SchedulingPolicyRankingTypes.LJF, scheduler.get_taskset())

for i in range(3):
    sid = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputData_%02d' % (i+1), type='Filter',
                                        phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                        preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['DataSet_F_%02d' % (i+1)])
    sid.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]}, capacity=1)
    sid.add_resource_requirement(resource_type=memory_t, capacity=1024)
    sid.set_logical_relation(AND())
    sid.add_dependency("Data", 1)

    sfp = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetFilteringParams_%02d' % (i + 1), type='Filter',
                                      phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=["ParamSet_%02d" %(i+1)])
    sfp.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]}, capacity=1)
    sfp.add_resource_requirement(resource_type=memory_t, capacity=1024)
    sfp.set_logical_relation(AND())
    sfp.add_dependency('DataSet_F_%02d' % (i+1), 1)

    filter = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='filter_%02d' % (i + 1), type='Filter',
                                      phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['Filtered_%02d' % (i+1)])
    filter.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]}, capacity=1)
    filter.add_resource_requirement(resource_type=memory_t, capacity=1024)
    filter.set_logical_relation(AND())
    filter.add_dependency("ParamSet_%02d" %(i+1), 1)

    sid_f = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputData_%02d' % (i + 1), type='FExtracting',
                                         phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                         preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['DataSet_E_%02d' % (i+1)])
    sid_f.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]}, capacity=1)
    sid_f.add_resource_requirement(resource_type=memory_t, capacity=1024)
    sid_f.set_logical_relation(AND())
    sid_f.add_dependency('Filtered_%02d' % (i+1), 1)

    extract = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='Extract_%02d' % (i + 1), type='FExtracting',
                                        phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                        preemptability=PreemptionTypeList.NOT_PPREEMPTABLE, token_name=['Extract_%02d' % (i+1)], token_num=[10])
    extract.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]}, capacity=1)
    extract.add_resource_requirement(resource_type=memory_t, capacity=1024)
    extract.set_logical_relation(AND())
    extract.add_dependency('DataSet_E_%02d' % (i+1), 1)

    scheduler.add_tasks_in_bundle(sid, sfp, filter, sid_f, extract)

for i in range(2):
    sid_m_src = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputSrcData_%02d' % (i + 1), type='Matching',
                                          phase=Time(0), deadline=Time(end), periodicity=PeriodicityTypeList.APERIODIC,
                                          preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                          token_name=['DataSetMatchingSrc_%02d' % (i + 1)])
    sid_m_src.add_resource_requirement(resource_type=cpu_t, eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                     capacity=1)
    sid_m_src.add_resource_requirement(resource_type=memory_t, capacity=1024)
    sid_m_src.set_logical_relation(AND())
    sid_m_src.add_dependency('Extract_%02d' % (i+1), 1)

    sid_m_dst = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputDstData_%02d' % (i + 1),
                                            type='Matching',
                                            phase=Time(0), deadline=Time(end),
                                            periodicity=PeriodicityTypeList.APERIODIC,
                                            preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                            token_name=['DataSetMatchingDst_%02d' % (i + 1)])
    sid_m_dst.add_resource_requirement(resource_type=cpu_t,
                                       eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                       capacity=1)
    sid_m_dst.add_resource_requirement(resource_type=memory_t, capacity=1024)
    sid_m_dst.set_logical_relation(AND())
    sid_m_dst.add_dependency('Extract_%02d' % (i+2), 1)

    smp = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='setMatchingParams_%02d' % (i + 1),
                                              type='Matching',
                                              phase=Time(0), deadline=Time(end),
                                              periodicity=PeriodicityTypeList.APERIODIC,
                                              preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                              token_name=['SetDataMatching_%02d' % (i + 1)])
    smp.add_resource_requirement(resource_type=cpu_t,
                                         eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                         capacity=1)
    smp.add_resource_requirement(resource_type=memory_t, capacity=2048)
    smp.set_logical_relation(OR())
    smp.add_dependency('DataSetMatchingSrc_%02d' % (i + 1), 1)
    smp.add_dependency('DataSetMatchingDst_%02d' % (i + 1), 1)

    gtransform = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='getTransformation_%02d' % (i + 1),
                                      type='Matching',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['Transformed_%02d' % (i + 1)])
    gtransform.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
    gtransform.add_resource_requirement(resource_type=memory_t, capacity=2048)
    gtransform.set_logical_relation(AND())
    gtransform.add_dependency('SetDataMatching_%02d' % (i + 1), 1)

    scheduler.add_tasks_in_bundle(sid_m_src, sid_m_dst, smp, gtransform)


multiply = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='multiply_T12_T23',
                                      type='FN',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['Multiplied'], token_num=[5])
multiply.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
multiply.set_logical_relation(AND())
multiply.add_dependency('SetDataMatching_%02d' % 1, 1)
multiply.add_dependency('SetDataMatching_%02d' % 2, 1)

sisrc = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputSrcData_%02d' % 1,
                                      type='Matching2',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['SetInputSrcData_M_%02d' % 1])
sisrc.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
sisrc.add_resource_requirement(resource_type=memory_t, capacity=1024)
sisrc.set_logical_relation(AND())
sisrc.add_dependency("Data", 1)
sisrc.add_dependency("Multiplied", 1)

sidst = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='SetInputDstData_%02d' % 1,
                                      type='Matching2',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['SetInputDstData_M_%02d' % 1])
sidst.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
sidst.add_resource_requirement(resource_type=memory_t, capacity=1024)
sidst.set_logical_relation(AND())
sidst.add_dependency("Data", 1)
sidst.add_dependency("Multiplied", 1)

setm_param = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='setMatchingParams_M_%02d' % 1,
                                      type='Matching2',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['TransformationMSet'])
setm_param.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
setm_param.add_resource_requirement(resource_type=memory_t, capacity=2048)
setm_param.set_logical_relation(OR())
setm_param.add_dependency('SetInputSrcData_M_%02d' % 1, 1)
setm_param.add_dependency('SetInputDstData_M_%02d' % 1, 1)

ltransform = TaskFactory.create_instance(TaskTypeList.TERMINAL, name='setMatchingParams_M_%02d' % 1,
                                      type='Matching2',
                                      phase=Time(0), deadline=Time(end),
                                      periodicity=PeriodicityTypeList.APERIODIC,
                                      preemptability=PreemptionTypeList.NOT_PPREEMPTABLE,
                                      token_name=['TransformedCloud'])
ltransform.add_resource_requirement(resource_type=cpu_t,
                                 eligible_resources={cpu: Time(1) for cpu in resources["CPU"]},
                                 capacity=1)
ltransform.add_resource_requirement(resource_type=memory_t, capacity=2048)
ltransform.set_logical_relation(AND())
ltransform.add_dependency('TransformationMSet', 1)

scheduler.add_tasks_in_bundle(multiply, sisrc, sidst, setm_param, ltransform)

schedules = scheduler.schedule_tasks()
for schedule in schedules:
    schedule.plot_schedule()
