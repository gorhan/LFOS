/*
All clafers: 81 | Abstract: 7 | Concrete: 74 | Reference: 3
Constraints: 8
Goals: 0
Global scope: 1..*
Can skip name resolver: no
*/
open util/integer
pred show {}
run show for 1 but 2 c0_Aperiodic, 2 c0_Data, 2 c0_Deadline, 2 c0_Dependency, 2 c0_DependentTo, 2 c0_Dynamic, 2 c0_ExecutionTime, 2 c0_Firm, 2 c0_Fixed, 2 c0_Hard, 2 c0_Interval, 2 c0_Job, 2 c0_Partial, 2 c0_Periodic, 2 c0_Periodicity, 2 c0_Preemptable, 2 c0_Priority, 2 c0_ReleaseTime, 2 c0_Requirement, 2 c0_Soft, 2 c0_Source, 2 c0_Sporadic, 2 c0_Task, 2 c0_Timing, 2 c0_requirement, 2 c0_taskset, 2 c0_timing, 2 c0_which, 2 c1_Actual, 2 c1_Composite, 2 c1_Deadline, 2 c1_Granularity, 2 c1_Objective

abstract sig c0_Resource
{ r_c0_Granularity : one c0_Granularity
, r_c0_Type : one c0_Type
, r_c0_Dedicated : lone c0_Dedicated
, r_c0_Capacity : one c0_Capacity
, r_c0_MutualExclusion : lone c0_MutualExclusion
, r_c0_PowerConsumption : one c0_PowerConsumption
, r_c0_Objective : lone c0_Objective }

sig c0_Granularity
{ r_c0_Composite : lone c0_Composite
, r_c0_Actual : lone c0_Actual }
{ one @r_c0_Granularity.this
  let children = (r_c0_Composite + r_c0_Actual) | one children }

sig c0_Composite
{}
{ one @r_c0_Composite.this }

sig c0_Actual
{}
{ one @r_c0_Actual.this }

sig c0_Type
{ r_c0_Active : lone c0_Active
, r_c0_Passive : lone c0_Passive }
{ one @r_c0_Type.this
  let children = (r_c0_Active + r_c0_Passive) | one children }

sig c0_Active
{}
{ one @r_c0_Active.this }

sig c0_Passive
{}
{ one @r_c0_Passive.this }

sig c0_Dedicated
{}
{ one @r_c0_Dedicated.this }

sig c0_Capacity
{}
{ one @r_c0_Capacity.this }

sig c0_MutualExclusion
{ r_c0_SELF : lone c0_SELF }
{ one @r_c0_MutualExclusion.this }

sig c0_SELF
{}
{ one @r_c0_SELF.this }

sig c0_PowerConsumption
{ r_c0_Scalable : lone c0_Scalable }
{ one @r_c0_PowerConsumption.this }

sig c0_Scalable
{ r_c0_Discrete : lone c0_Discrete
, r_c0_Continuous : lone c0_Continuous }
{ one @r_c0_Scalable.this
  let children = (r_c0_Discrete + r_c0_Continuous) | one children
  (some this) => (some (((this.~@r_c0_Scalable).~@r_c0_PowerConsumption).@r_c0_Type).@r_c0_Active) }

sig c0_Discrete
{}
{ one @r_c0_Discrete.this }

sig c0_Continuous
{}
{ one @r_c0_Continuous.this }

sig c0_Objective
{}
{ one @r_c0_Objective.this }

abstract sig c0_Timing
{ r_c0_ReleaseTime : one c0_ReleaseTime
, r_c0_ExecutionTime : one c0_ExecutionTime
, r_c0_Deadline : lone c0_Deadline
, r_c0_Periodicity : one c0_Periodicity }

sig c0_ReleaseTime
{}
{ one @r_c0_ReleaseTime.this }

sig c0_ExecutionTime
{}
{ one @r_c0_ExecutionTime.this }

sig c0_Deadline
{}
{ one @r_c0_Deadline.this }

sig c0_Periodicity
{ r_c0_Periodic : lone c0_Periodic
, r_c0_Aperiodic : lone c0_Aperiodic }
{ one @r_c0_Periodicity.this
  let children = (r_c0_Periodic + r_c0_Aperiodic) | one children }

sig c0_Periodic
{}
{ one @r_c0_Periodic.this }

sig c0_Aperiodic
{ r_c0_Sporadic : lone c0_Sporadic }
{ one @r_c0_Aperiodic.this }

sig c0_Sporadic
{}
{ one @r_c0_Sporadic.this }

abstract sig c0_Requirement
{ r_c1_Deadline : one c1_Deadline
, r_c0_Source : one c0_Source }

sig c1_Deadline
{ r_c0_Hard : lone c0_Hard
, r_c0_Soft : lone c0_Soft
, r_c0_Firm : lone c0_Firm }
{ one @r_c1_Deadline.this
  let children = (r_c0_Hard + r_c0_Soft + r_c0_Firm) | one children }

sig c0_Hard
{}
{ one @r_c0_Hard.this
  (some this) => (some this.~@r_c0_Hard) }

sig c0_Soft
{}
{ one @r_c0_Soft.this }

sig c0_Firm
{}
{ one @r_c0_Firm.this }

sig c0_Source
{ r_c0_which : some c0_which }
{ one @r_c0_Source.this
  all disj x, y : this.@r_c0_which | (x.@ref) != (y.@ref)  }

sig c0_which
{ ref : one c0_Resource }
{ one @r_c0_which.this
  one  r : c0_Resource | some (r.@r_c0_Type).@r_c0_Active }

abstract sig c0_Task
{ r_c1_Granularity : one c1_Granularity
, r_c0_timing : one c0_timing
, r_c1_Objective : lone c1_Objective
, r_c0_Dependency : lone c0_Dependency
, r_c0_Preemptable : lone c0_Preemptable
, r_c0_requirement : one c0_requirement
, r_c0_Priority : one c0_Priority }

sig c1_Granularity
{ r_c1_Composite : lone c1_Composite
, r_c1_Actual : lone c1_Actual }
{ one @r_c1_Granularity.this
  let children = (r_c1_Composite + r_c1_Actual) | one children }

sig c1_Composite
{}
{ one @r_c1_Composite.this }

sig c1_Actual
{}
{ one @r_c1_Actual.this }

sig c0_timing extends c0_Timing
{}
{ one @r_c0_timing.this }

sig c1_Objective
{}
{ one @r_c1_Objective.this }

sig c0_Dependency
{ r_c0_DependentTo : one c0_DependentTo
, r_c0_Interval : lone c0_Interval }
{ one @r_c0_Dependency.this }

sig c0_DependentTo
{ r_c0_Job : lone c0_Job
, r_c0_Data : lone c0_Data }
{ one @r_c0_DependentTo.this
  let children = (r_c0_Job + r_c0_Data) | some children }

sig c0_Job
{}
{ one @r_c0_Job.this }

sig c0_Data
{}
{ one @r_c0_Data.this }

sig c0_Interval
{}
{ one @r_c0_Interval.this }

sig c0_Preemptable
{ r_c0_Partial : lone c0_Partial }
{ one @r_c0_Preemptable.this }

sig c0_Partial
{}
{ one @r_c0_Partial.this }

sig c0_requirement extends c0_Requirement
{}
{ one @r_c0_requirement.this }

sig c0_Priority
{ r_c0_Fixed : lone c0_Fixed
, r_c0_Dynamic : lone c0_Dynamic }
{ one @r_c0_Priority.this
  let children = (r_c0_Fixed + r_c0_Dynamic) | one children }

sig c0_Fixed
{}
{ one @r_c0_Fixed.this }

sig c0_Dynamic
{}
{ one @r_c0_Dynamic.this }

abstract sig c0_Algorithm
{ r_c1_Type : one c1_Type
, r_c0_Policy : one c0_Policy
, r_c0_Preemption : lone c0_Preemption
, r_c0_Migration : lone c0_Migration }

sig c1_Type
{ r_c0_Online : lone c0_Online
, r_c0_Offline : lone c0_Offline }
{ one @r_c1_Type.this
  let children = (r_c0_Online + r_c0_Offline) | one children }

sig c0_Online
{}
{ one @r_c0_Online.this }

sig c0_Offline
{}
{ one @r_c0_Offline.this }

sig c0_Policy
{ r_c0_Grouping : lone c0_Grouping
, r_c0_Ranking : one c0_Ranking }
{ one @r_c0_Policy.this }

sig c0_Grouping
{}
{ one @r_c0_Grouping.this }

sig c0_Ranking
{ r_c0_Integrated : lone c0_Integrated
, r_c0_UserDefined : lone c0_UserDefined }
{ one @r_c0_Ranking.this
  let children = (r_c0_Integrated + r_c0_UserDefined) | one children }

sig c0_Integrated
{ r_c0_ERT : lone c0_ERT
, r_c0_ED : lone c0_ED
, r_c0_RM : lone c0_RM
, r_c0_SJF : lone c0_SJF
, r_c0_FIFO : lone c0_FIFO }
{ one @r_c0_Integrated.this
  let children = (r_c0_ERT + r_c0_ED + r_c0_RM + r_c0_SJF + r_c0_FIFO) | one children }

sig c0_ERT
{}
{ one @r_c0_ERT.this }

sig c0_ED
{}
{ one @r_c0_ED.this }

sig c0_RM
{}
{ one @r_c0_RM.this }

sig c0_SJF
{}
{ one @r_c0_SJF.this }

sig c0_FIFO
{}
{ one @r_c0_FIFO.this }

sig c0_UserDefined
{}
{ one @r_c0_UserDefined.this }

sig c0_Preemption
{}
{ one @r_c0_Preemption.this }

sig c0_Migration
{ r_c0_TaskLevel : lone c0_TaskLevel
, r_c0_JobLevel : lone c0_JobLevel }
{ one @r_c0_Migration.this
  let children = (r_c0_TaskLevel + r_c0_JobLevel) | one children }

sig c0_TaskLevel
{}
{ one @r_c0_TaskLevel.this }

sig c0_JobLevel
{}
{ one @r_c0_JobLevel.this }

abstract sig c0_Scheduling
{ r_c0_Filetering : lone c0_Filetering
, r_c0_algorithm : one c0_algorithm
, r_c0_Window : one c0_Window
, r_c0_TimeResolution : one c0_TimeResolution }

sig c0_Filetering
{}
{ one @r_c0_Filetering.this }

sig c0_algorithm extends c0_Algorithm
{}
{ one @r_c0_algorithm.this }

sig c0_Window
{ r_c1_Fixed : lone c1_Fixed
, r_c1_Dynamic : lone c1_Dynamic }
{ one @r_c0_Window.this
  let children = (r_c1_Fixed + r_c1_Dynamic) | one children }

sig c1_Fixed
{}
{ one @r_c1_Fixed.this }

sig c1_Dynamic
{}
{ one @r_c1_Dynamic.this }

sig c0_TimeResolution
{}
{ one @r_c0_TimeResolution.this }

abstract sig c0_Scheduler
{ r_c0_taskset : some c0_taskset
, r_c0_system : some c0_system
, r_c0_scheduling : one c0_scheduling }
{ all disj x, y : this.@r_c0_taskset | (x.@ref) != (y.@ref) 
  all disj x, y : this.@r_c0_system | (x.@ref) != (y.@ref)  }

sig c0_taskset
{ ref : one c0_Task }
{ one @r_c0_taskset.this }

sig c0_system
{ ref : one c0_Resource }
{ one @r_c0_system.this
  some  r : c0_Resource | some (r.@r_c0_Type).@r_c0_Active }

sig c0_scheduling extends c0_Scheduling
{}
{ one @r_c0_scheduling.this }

one sig c0_scheduler extends c0_Scheduler
{}

one sig c0_t1 extends c0_Task
{}
{ (some ((this.@r_c0_timing).@r_c0_Periodicity).@r_c0_Periodic) && (some ((this.@r_c0_requirement).@r_c1_Deadline).@r_c0_Hard) }

one sig c0_t2 extends c0_Task
{}
{ some (((this.@r_c0_timing).@r_c0_Periodicity).@r_c0_Aperiodic).@r_c0_Sporadic }

one sig c0_r1 extends c0_Resource
{}
{ (some (this.@r_c0_Type).@r_c0_Active) && (some ((this.@r_c0_PowerConsumption).@r_c0_Scalable).@r_c0_Discrete) }

fact { (c0_scheduler.(@r_c0_taskset.@ref)) = (c0_t1 + c0_t2) }
