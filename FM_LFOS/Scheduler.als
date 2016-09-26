/*
All clafers: 152 | Abstract: 18 | Concrete: 134 | Reference: 5
Constraints: 31
Goals: 0
Global scope: 1..*
Can skip name resolver: no
*/
open util/integer
pred show {}
run show for 1 but 11 c0_algorithm, 2 c0_centering, 2 c0_earliness, 2 c0_lateness, 2 c0_makespan, 3 c0_maxi, 3 c0_mini, 11 c0_name, 3 c0_objective_purpose, 2 c0_power_consumption, 2 c0_resource_related_objective_criteria, 3 c0_resource_related_user_defined_criteria, 2 c0_tardiness, 3 c0_task_related_user_defined_criteria, 2 c0_throughput, 2 c0_time_related_objective_criteria, 3 c0_user_defined_objective_criteria, 2 c0_utilization

abstract sig c0_objective_purpose
{ r_c0_maxi : lone c0_maxi
, r_c0_mini : lone c0_mini }

sig c0_maxi
{}
{ one @r_c0_maxi.this }

sig c0_mini
{}
{ one @r_c0_mini.this }

abstract sig c0_time_related_objective_criteria
{ r_c0_makespan : lone c0_makespan
, r_c0_tardiness : lone c0_tardiness
, r_c0_earliness : lone c0_earliness
, r_c0_lateness : lone c0_lateness
, r_c0_centering : lone c0_centering }

sig c0_makespan
{}
{ one @r_c0_makespan.this }

sig c0_tardiness
{}
{ one @r_c0_tardiness.this }

sig c0_earliness
{}
{ one @r_c0_earliness.this }

sig c0_lateness
{}
{ one @r_c0_lateness.this }

sig c0_centering
{}
{ one @r_c0_centering.this }

abstract sig c0_resource_related_objective_criteria
{ r_c0_power_consumption : lone c0_power_consumption
, r_c0_utilization : lone c0_utilization
, r_c0_throughput : lone c0_throughput }

sig c0_power_consumption
{}
{ one @r_c0_power_consumption.this }

sig c0_utilization
{}
{ one @r_c0_utilization.this }

sig c0_throughput
{}
{ one @r_c0_throughput.this }

abstract sig c0_user_defined_objective_criteria
{ r_c0_task_related_user_defined_criteria : lone c0_task_related_user_defined_criteria
, r_c0_resource_related_user_defined_criteria : lone c0_resource_related_user_defined_criteria }

sig c0_task_related_user_defined_criteria
{}
{ one @r_c0_task_related_user_defined_criteria.this }

sig c0_resource_related_user_defined_criteria
{}
{ one @r_c0_resource_related_user_defined_criteria.this }

abstract sig c0_task_related_objective
{ r_c0_purpose : one c0_purpose
, r_c0_criteria : one c0_criteria }

sig c0_purpose extends c0_objective_purpose
{}
{ one @r_c0_purpose.this
  let children = (r_c0_maxi + r_c0_mini) | one children }

sig c0_criteria
{ r_c1_time_related_objective_criteria : lone c1_time_related_objective_criteria
, r_c1_user_defined_objective_criteria : lone c1_user_defined_objective_criteria }
{ one @r_c0_criteria.this
  let children = (r_c1_time_related_objective_criteria + r_c1_user_defined_objective_criteria) | some children }

sig c1_time_related_objective_criteria extends c0_time_related_objective_criteria
{}
{ one @r_c1_time_related_objective_criteria.this
  let children = (r_c0_makespan + r_c0_tardiness + r_c0_earliness + r_c0_lateness + r_c0_centering) | some children }

sig c1_user_defined_objective_criteria extends c0_user_defined_objective_criteria
{}
{ one @r_c1_user_defined_objective_criteria.this
  let children = (r_c0_task_related_user_defined_criteria + r_c0_resource_related_user_defined_criteria) | some children
  (some this.@r_c0_task_related_user_defined_criteria) && (no this.@r_c0_resource_related_user_defined_criteria) }

abstract sig c0_resource_related_objective
{ r_c1_purpose : one c1_purpose
, r_c1_criteria : one c1_criteria }

sig c1_purpose extends c0_objective_purpose
{}
{ one @r_c1_purpose.this
  let children = (r_c0_maxi + r_c0_mini) | one children }

sig c1_criteria
{ r_c1_resource_related_objective_criteria : lone c1_resource_related_objective_criteria
, r_c2_user_defined_objective_criteria : lone c2_user_defined_objective_criteria }
{ one @r_c1_criteria.this
  let children = (r_c1_resource_related_objective_criteria + r_c2_user_defined_objective_criteria) | some children }

sig c1_resource_related_objective_criteria extends c0_resource_related_objective_criteria
{}
{ one @r_c1_resource_related_objective_criteria.this
  let children = (r_c0_power_consumption + r_c0_utilization + r_c0_throughput) | some children }

sig c2_user_defined_objective_criteria extends c0_user_defined_objective_criteria
{}
{ one @r_c2_user_defined_objective_criteria.this
  let children = (r_c0_task_related_user_defined_criteria + r_c0_resource_related_user_defined_criteria) | some children
  (no this.@r_c0_task_related_user_defined_criteria) && (some this.@r_c0_resource_related_user_defined_criteria) }

abstract sig c0_global_objective
{ r_c2_purpose : one c2_purpose
, r_c2_criteria : one c2_criteria }

sig c2_purpose extends c0_objective_purpose
{}
{ one @r_c2_purpose.this
  let children = (r_c0_maxi + r_c0_mini) | one children }

sig c2_criteria
{ r_c2_time_related_objective_criteria : lone c2_time_related_objective_criteria
, r_c2_resource_related_objective_criteria : lone c2_resource_related_objective_criteria
, r_c3_user_defined_objective_criteria : lone c3_user_defined_objective_criteria }
{ one @r_c2_criteria.this
  let children = (r_c2_time_related_objective_criteria + r_c2_resource_related_objective_criteria + r_c3_user_defined_objective_criteria) | some children }

sig c2_time_related_objective_criteria extends c0_time_related_objective_criteria
{}
{ one @r_c2_time_related_objective_criteria.this
  let children = (r_c0_makespan + r_c0_tardiness + r_c0_earliness + r_c0_lateness + r_c0_centering) | some children }

sig c2_resource_related_objective_criteria extends c0_resource_related_objective_criteria
{}
{ one @r_c2_resource_related_objective_criteria.this
  let children = (r_c0_power_consumption + r_c0_utilization + r_c0_throughput) | some children }

sig c3_user_defined_objective_criteria extends c0_user_defined_objective_criteria
{}
{ one @r_c3_user_defined_objective_criteria.this
  let children = (r_c0_task_related_user_defined_criteria + r_c0_resource_related_user_defined_criteria) | some children }

abstract sig c0_resource
{ r_c0_granularity : one c0_granularity
, r_c0_type : one c0_type
, r_c0_dedicated : lone c0_dedicated
, r_c0_capacity : one c0_capacity
, r_c0_mutual_exclusion : lone c0_mutual_exclusion
, r_c1_power_consumption : one c1_power_consumption
, r_c0_objective : lone c0_objective }

sig c0_granularity
{ r_c0_composite : lone c0_composite
, r_c0_actual : lone c0_actual }
{ one @r_c0_granularity.this
  let children = (r_c0_composite + r_c0_actual) | one children }

sig c0_composite
{}
{ one @r_c0_composite.this }

sig c0_actual
{}
{ one @r_c0_actual.this }

sig c0_type
{ r_c0_active : lone c0_active
, r_c0_passive : lone c0_passive
, r_c1_composite : lone c1_composite }
{ one @r_c0_type.this
  let children = (r_c0_active + r_c0_passive + r_c1_composite) | one children
  ((some this.@r_c0_active) || (some this.@r_c0_passive)) => (some ((this.~@r_c0_type).@r_c0_granularity).@r_c0_actual) }

sig c0_active
{}
{ one @r_c0_active.this }

sig c0_passive
{}
{ one @r_c0_passive.this }

sig c1_composite
{}
{ one @r_c1_composite.this }

sig c0_dedicated
{}
{ one @r_c0_dedicated.this }

sig c0_capacity
{}
{ one @r_c0_capacity.this }

sig c0_mutual_exclusion
{ r_c0_self : lone c0_self }
{ one @r_c0_mutual_exclusion.this }

sig c0_self
{}
{ one @r_c0_self.this }

sig c1_power_consumption
{ r_c0_scalable : lone c0_scalable }
{ one @r_c1_power_consumption.this
  (some this.@r_c0_scalable) => (some ((this.~@r_c1_power_consumption).@r_c0_type).@r_c0_active) }

sig c0_scalable
{ r_c0_discrete : lone c0_discrete
, r_c0_continuous : lone c0_continuous }
{ one @r_c0_scalable.this
  let children = (r_c0_discrete + r_c0_continuous) | one children }

sig c0_discrete
{}
{ one @r_c0_discrete.this }

sig c0_continuous
{}
{ one @r_c0_continuous.this }

sig c0_objective extends c0_resource_related_objective
{}
{ one @r_c0_objective.this }

abstract sig c0_timing
{ r_c0_release_time : one c0_release_time
, r_c0_execution_time : one c0_execution_time
, r_c0_deadline : lone c0_deadline
, r_c0_periodicity : one c0_periodicity }

sig c0_release_time
{}
{ one @r_c0_release_time.this }

sig c0_execution_time
{}
{ one @r_c0_execution_time.this }

sig c0_deadline
{}
{ one @r_c0_deadline.this }

sig c0_periodicity
{ r_c0_periodic : lone c0_periodic
, r_c0_aperiodic : lone c0_aperiodic }
{ one @r_c0_periodicity.this
  let children = (r_c0_periodic + r_c0_aperiodic) | one children }

sig c0_periodic
{}
{ one @r_c0_periodic.this }

sig c0_aperiodic
{ r_c0_sporadic : lone c0_sporadic }
{ one @r_c0_aperiodic.this }

sig c0_sporadic
{}
{ one @r_c0_sporadic.this }

abstract sig c0_requirement
{ r_c1_deadline : one c1_deadline
, r_c0_required_resource : some c0_required_resource }
{ all disj x, y : this.@r_c0_required_resource | (x.@c0_required_resource_ref) != (y.@c0_required_resource_ref)  }

sig c1_deadline
{ r_c0_hard : lone c0_hard
, r_c0_soft : lone c0_soft
, r_c0_firm : lone c0_firm }
{ one @r_c1_deadline.this
  let children = (r_c0_hard + r_c0_soft + r_c0_firm) | one children }

sig c0_hard
{}
{ one @r_c0_hard.this }

sig c0_soft
{}
{ one @r_c0_soft.this }

sig c0_firm
{}
{ one @r_c0_firm.this }

sig c0_required_resource
{ c0_required_resource_ref : one c0_resource }
{ one @r_c0_required_resource.this
  some  r : c0_resource | some (r.@r_c0_type).@r_c0_active }

abstract sig c0_task
{ r_c1_granularity : one c1_granularity
, r_c1_timing : one c1_timing
, r_c1_objective : lone c1_objective
, r_c0_dependency : lone c0_dependency
, r_c0_preemptable : lone c0_preemptable
, r_c1_requirement : one c1_requirement
, r_c0_priority : one c0_priority }
{ (some ((this.@r_c1_requirement).@r_c1_deadline).@r_c0_hard) => (some (this.@r_c1_timing).@r_c0_deadline) }

sig c1_granularity
{ r_c2_composite : lone c2_composite
, r_c1_actual : lone c1_actual }
{ one @r_c1_granularity.this
  let children = (r_c2_composite + r_c1_actual) | one children }

sig c2_composite
{}
{ one @r_c2_composite.this }

sig c1_actual
{}
{ one @r_c1_actual.this }

sig c1_timing extends c0_timing
{}
{ one @r_c1_timing.this }

sig c1_objective extends c0_task_related_objective
{}
{ one @r_c1_objective.this }

sig c0_dependency
{ r_c0_data_dependency : one c0_data_dependency
, r_c0_task_dependency : one c0_task_dependency
, r_c0_interval : lone c0_interval }
{ one @r_c0_dependency.this
  !((some this.@r_c0_data_dependency) <=> (some this.@r_c0_task_dependency)) }

sig c0_data_dependency
{}
{ one @r_c0_data_dependency.this }

sig c0_task_dependency
{}
{ one @r_c0_task_dependency.this }

sig c0_interval
{}
{ one @r_c0_interval.this }

sig c0_preemptable
{ r_c0_partial : lone c0_partial }
{ one @r_c0_preemptable.this }

sig c0_partial
{}
{ one @r_c0_partial.this }

sig c1_requirement extends c0_requirement
{}
{ one @r_c1_requirement.this }

sig c0_priority
{}
{ one @r_c0_priority.this }

abstract sig c0_scheduling_policy
{ r_c0_grouping : lone c0_grouping
, r_c0_ranking : one c0_ranking }

sig c0_grouping
{}
{ one @r_c0_grouping.this }

sig c0_ranking
{ r_c0_user_defined : lone c0_user_defined
, r_c0_integrated : lone c0_integrated }
{ one @r_c0_ranking.this
  let children = (r_c0_user_defined + r_c0_integrated) | one children }

sig c0_user_defined
{}
{ one @r_c0_user_defined.this }

sig c0_integrated
{ r_c0_ERT : lone c0_ERT
, r_c0_ED : lone c0_ED
, r_c0_RM : lone c0_RM
, r_c0_SJF : lone c0_SJF
, r_c0_FIFO : lone c0_FIFO }
{ one @r_c0_integrated.this
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

abstract sig c0_scheduling_characteristic
{ r_c1_type : one c1_type
, r_c0_task_filtering : lone c0_task_filtering
, r_c0_policy : one c0_policy
, r_c0_preemption : lone c0_preemption
, r_c0_priority_assignment : one c0_priority_assignment
, r_c0_migration : lone c0_migration
, r_c0_scheduling_window : one c0_scheduling_window
, r_c0_time_resolution : one c0_time_resolution
, r_c2_objective : some c2_objective }
{ all disj x, y : this.@r_c2_objective | (x.@c2_objective_ref) != (y.@c2_objective_ref)  }

sig c1_type
{ r_c0_online : lone c0_online
, r_c0_offline : lone c0_offline }
{ one @r_c1_type.this
  let children = (r_c0_online + r_c0_offline) | one children }

sig c0_online
{}
{ one @r_c0_online.this }

sig c0_offline
{}
{ one @r_c0_offline.this }

sig c0_task_filtering
{}
{ one @r_c0_task_filtering.this }

sig c0_policy extends c0_scheduling_policy
{}
{ one @r_c0_policy.this }

sig c0_preemption
{}
{ one @r_c0_preemption.this }

sig c0_priority_assignment
{ r_c0_fixed : lone c0_fixed
, r_c0_dynamic : lone c0_dynamic }
{ one @r_c0_priority_assignment.this
  let children = (r_c0_fixed + r_c0_dynamic) | one children }

sig c0_fixed
{}
{ one @r_c0_fixed.this }

sig c0_dynamic
{}
{ one @r_c0_dynamic.this }

sig c0_migration
{ r_c0_task_level : lone c0_task_level
, r_c0_job_level : lone c0_job_level }
{ one @r_c0_migration.this
  let children = (r_c0_task_level + r_c0_job_level) | one children }

sig c0_task_level
{}
{ one @r_c0_task_level.this }

sig c0_job_level
{}
{ one @r_c0_job_level.this }

sig c0_scheduling_window
{ r_c1_fixed : lone c1_fixed
, r_c1_dynamic : lone c1_dynamic }
{ one @r_c0_scheduling_window.this
  let children = (r_c1_fixed + r_c1_dynamic) | one children }

sig c1_fixed
{}
{ one @r_c1_fixed.this }

sig c1_dynamic
{}
{ one @r_c1_dynamic.this }

sig c0_time_resolution
{}
{ one @r_c0_time_resolution.this }

sig c2_objective
{ c2_objective_ref : one c0_global_objective }
{ one @r_c2_objective.this }

abstract sig c0_algorithm
{ r_c0_name : one c0_name }

sig c0_name
{ c0_name_ref : one Int }
{ one @r_c0_name.this }

abstract sig c0_scheduling_algorithm
{ r_c0_CP : lone c0_CP
, r_c0_CIP : lone c0_CIP
, r_c0_MILP : lone c0_MILP
, r_c0_LBBD : lone c0_LBBD
, r_c0_GA : lone c0_GA
, r_c0_KS : lone c0_KS
, r_c0_WIS : lone c0_WIS
, r_c0_SA : lone c0_SA
, r_c0_B_BS : lone c0_B_BS
, r_c0_HA : lone c0_HA
, r_c0_KBS : lone c0_KBS }

sig c0_CP extends c0_algorithm
{}
{ one @r_c0_CP.this
  ((this.@r_c0_name).@c0_name_ref) = 0 }

sig c0_CIP extends c0_algorithm
{}
{ one @r_c0_CIP.this
  ((this.@r_c0_name).@c0_name_ref) = 1 }

sig c0_MILP extends c0_algorithm
{}
{ one @r_c0_MILP.this
  ((this.@r_c0_name).@c0_name_ref) = 2 }

sig c0_LBBD extends c0_algorithm
{}
{ one @r_c0_LBBD.this
  ((this.@r_c0_name).@c0_name_ref) = 3 }

sig c0_GA extends c0_algorithm
{}
{ one @r_c0_GA.this
  ((this.@r_c0_name).@c0_name_ref) = 4 }

sig c0_KS extends c0_algorithm
{}
{ one @r_c0_KS.this
  ((this.@r_c0_name).@c0_name_ref) = 5 }

sig c0_WIS extends c0_algorithm
{}
{ one @r_c0_WIS.this
  ((this.@r_c0_name).@c0_name_ref) = 6 }

sig c0_SA extends c0_algorithm
{}
{ one @r_c0_SA.this
  ((this.@r_c0_name).@c0_name_ref) = 7 }

sig c0_B_BS extends c0_algorithm
{}
{ one @r_c0_B_BS.this
  ((this.@r_c0_name).@c0_name_ref) = 8 }

sig c0_HA extends c0_algorithm
{}
{ one @r_c0_HA.this
  ((this.@r_c0_name).@c0_name_ref) = 9 }

sig c0_KBS extends c0_algorithm
{}
{ one @r_c0_KBS.this
  ((this.@r_c0_name).@c0_name_ref) = 10 }

abstract sig c0_scheduling_solver
{ r_c0_IBM_ILOG_CPLEX : lone c0_IBM_ILOG_CPLEX
, r_c0_IBM_ILOG_CP_Optimizer : lone c0_IBM_ILOG_CP_Optimizer
, r_c0_SCIP_SoPlex : lone c0_SCIP_SoPlex
, r_c0_GA_solver : lone c0_GA_solver
, r_c0_KS_solver : lone c0_KS_solver
, r_c0_WIS_solver : lone c0_WIS_solver
, r_c0_SA_solver : lone c0_SA_solver
, r_c0_B_BS_solver : lone c0_B_BS_solver
, r_c0_HA_solver : lone c0_HA_solver
, r_c0_KBS_solver : lone c0_KBS_solver }

sig c0_IBM_ILOG_CPLEX
{}
{ one @r_c0_IBM_ILOG_CPLEX.this }

sig c0_IBM_ILOG_CP_Optimizer
{}
{ one @r_c0_IBM_ILOG_CP_Optimizer.this }

sig c0_SCIP_SoPlex
{}
{ one @r_c0_SCIP_SoPlex.this }

sig c0_GA_solver
{}
{ one @r_c0_GA_solver.this }

sig c0_KS_solver
{}
{ one @r_c0_KS_solver.this }

sig c0_WIS_solver
{}
{ one @r_c0_WIS_solver.this }

sig c0_SA_solver
{}
{ one @r_c0_SA_solver.this }

sig c0_B_BS_solver
{}
{ one @r_c0_B_BS_solver.this }

sig c0_HA_solver
{}
{ one @r_c0_HA_solver.this }

sig c0_KBS_solver
{}
{ one @r_c0_KBS_solver.this }

abstract sig c0_scheduling_adapter
{ r_c0_IBM_ILOG_CPLEX_adapter : lone c0_IBM_ILOG_CPLEX_adapter
, r_c0_IBM_ILOG_CP_Optimizer_adapter : lone c0_IBM_ILOG_CP_Optimizer_adapter
, r_c0_SCIP_SoPlex_adapter : lone c0_SCIP_SoPlex_adapter
, r_c0_GA_adapter : lone c0_GA_adapter
, r_c0_KS_adapter : lone c0_KS_adapter
, r_c0_WIS_adapter : lone c0_WIS_adapter
, r_c0_SA_adapter : lone c0_SA_adapter
, r_c0_B_BS_adapter : lone c0_B_BS_adapter
, r_c0_HA_adapter : lone c0_HA_adapter
, r_c0_KBS_adapter : lone c0_KBS_adapter }

sig c0_IBM_ILOG_CPLEX_adapter
{}
{ one @r_c0_IBM_ILOG_CPLEX_adapter.this }

sig c0_IBM_ILOG_CP_Optimizer_adapter
{}
{ one @r_c0_IBM_ILOG_CP_Optimizer_adapter.this }

sig c0_SCIP_SoPlex_adapter
{}
{ one @r_c0_SCIP_SoPlex_adapter.this }

sig c0_GA_adapter
{}
{ one @r_c0_GA_adapter.this }

sig c0_KS_adapter
{}
{ one @r_c0_KS_adapter.this }

sig c0_WIS_adapter
{}
{ one @r_c0_WIS_adapter.this }

sig c0_SA_adapter
{}
{ one @r_c0_SA_adapter.this }

sig c0_B_BS_adapter
{}
{ one @r_c0_B_BS_adapter.this }

sig c0_HA_adapter
{}
{ one @r_c0_HA_adapter.this }

sig c0_KBS_adapter
{}
{ one @r_c0_KBS_adapter.this }

abstract sig c0_scheduler
{ r_c0_taskset : some c0_taskset
, r_c0_system : some c0_system
, r_c0_properties : one c0_properties
, r_c1_algorithm : one c1_algorithm
, r_c0_solver : one c0_solver
, r_c0_adapter : one c0_adapter }
{ all disj x, y : this.@r_c0_taskset | (x.@c0_taskset_ref) != (y.@c0_taskset_ref) 
  all disj x, y : this.@r_c0_system | (x.@c0_system_ref) != (y.@c0_system_ref) 
  ((((((((some (this.@r_c1_algorithm).@r_c0_GA) <=> (some (this.@r_c0_solver).@r_c0_GA_solver)) && ((some (this.@r_c1_algorithm).@r_c0_GA) <=> (some (this.@r_c0_adapter).@r_c0_GA_adapter))) && (((some (this.@r_c1_algorithm).@r_c0_KS) <=> (some (this.@r_c0_solver).@r_c0_KS_solver)) && ((some (this.@r_c1_algorithm).@r_c0_KS) <=> (some (this.@r_c0_adapter).@r_c0_KS_adapter)))) && (((some (this.@r_c1_algorithm).@r_c0_WIS) <=> (some (this.@r_c0_solver).@r_c0_WIS_solver)) && ((some (this.@r_c1_algorithm).@r_c0_WIS) <=> (some (this.@r_c0_adapter).@r_c0_WIS_adapter)))) && (((some (this.@r_c1_algorithm).@r_c0_SA) <=> (some (this.@r_c0_solver).@r_c0_SA_solver)) && ((some (this.@r_c1_algorithm).@r_c0_SA) <=> (some (this.@r_c0_adapter).@r_c0_SA_adapter)))) && (((some (this.@r_c1_algorithm).@r_c0_B_BS) <=> (some (this.@r_c0_solver).@r_c0_B_BS_solver)) && ((some (this.@r_c1_algorithm).@r_c0_B_BS) <=> (some (this.@r_c0_adapter).@r_c0_B_BS_adapter)))) && (((some (this.@r_c1_algorithm).@r_c0_HA) <=> (some (this.@r_c0_solver).@r_c0_HA_solver)) && ((some (this.@r_c1_algorithm).@r_c0_HA) <=> (some (this.@r_c0_adapter).@r_c0_HA_adapter)))) && (((some (this.@r_c1_algorithm).@r_c0_KBS) <=> (some (this.@r_c0_solver).@r_c0_KBS_solver)) && ((some (this.@r_c1_algorithm).@r_c0_KBS) <=> (some (this.@r_c0_adapter).@r_c0_KBS_adapter)))
  (some (this.@r_c1_algorithm).@r_c0_MILP) => ((some (this.@r_c0_solver).@r_c0_IBM_ILOG_CPLEX) && (some (this.@r_c0_adapter).@r_c0_IBM_ILOG_CPLEX_adapter))
  (some (this.@r_c1_algorithm).@r_c0_LBBD) => ((((some (this.@r_c0_solver).@r_c0_SCIP_SoPlex) && (some (this.@r_c0_solver).@r_c0_IBM_ILOG_CP_Optimizer)) && (some (this.@r_c0_adapter).@r_c0_SCIP_SoPlex_adapter)) && (some (this.@r_c0_adapter).@r_c0_IBM_ILOG_CP_Optimizer_adapter))
  (some (this.@r_c1_algorithm).@r_c0_CIP) => ((some (this.@r_c0_solver).@r_c0_SCIP_SoPlex) && (some (this.@r_c0_adapter).@r_c0_SCIP_SoPlex_adapter)) }

sig c0_taskset
{ c0_taskset_ref : one c0_task }
{ one @r_c0_taskset.this }

sig c0_system
{ c0_system_ref : one c0_resource }
{ one @r_c0_system.this }

sig c0_properties extends c0_scheduling_characteristic
{}
{ one @r_c0_properties.this }

sig c1_algorithm extends c0_scheduling_algorithm
{}
{ one @r_c1_algorithm.this
  let children = (r_c0_CP + r_c0_CIP + r_c0_MILP + r_c0_LBBD + r_c0_GA + r_c0_KS + r_c0_WIS + r_c0_SA + r_c0_B_BS + r_c0_HA + r_c0_KBS) | one children }

sig c0_solver extends c0_scheduling_solver
{}
{ one @r_c0_solver.this
  let children = (r_c0_IBM_ILOG_CPLEX + r_c0_IBM_ILOG_CP_Optimizer + r_c0_SCIP_SoPlex + r_c0_GA_solver + r_c0_KS_solver + r_c0_WIS_solver + r_c0_SA_solver + r_c0_B_BS_solver + r_c0_HA_solver + r_c0_KBS_solver) | some children }

sig c0_adapter extends c0_scheduling_adapter
{}
{ one @r_c0_adapter.this
  let children = (r_c0_IBM_ILOG_CPLEX_adapter + r_c0_IBM_ILOG_CP_Optimizer_adapter + r_c0_SCIP_SoPlex_adapter + r_c0_GA_adapter + r_c0_KS_adapter + r_c0_WIS_adapter + r_c0_SA_adapter + r_c0_B_BS_adapter + r_c0_HA_adapter + r_c0_KBS_adapter) | some children }

one sig c0_r1 extends c0_resource
{}

fact { (((some (c0_resource.@r_c1_power_consumption).@r_c0_scalable) && (no c0_resource.@r_c0_dedicated)) && (no c0_resource.@r_c0_mutual_exclusion)) && (no ((c0_r1.@r_c0_objective).@r_c1_criteria).@r_c2_user_defined_objective_criteria) }
one sig c0_t1 extends c0_task
{}

fact { (((((((c0_t1.@r_c1_requirement).@r_c0_required_resource).@c0_required_resource_ref) = c0_r1) && (no c0_t1.@r_c1_objective)) && (some ((c0_t1.@r_c1_timing).@r_c0_periodicity).@r_c0_periodic)) && (some (c0_t1.@r_c1_granularity).@r_c1_actual)) && (no c0_t1.@r_c0_preemptable) }
fact { no c0_r1.@r_c0_objective }
one sig c0_objective_gl extends c0_global_objective
{}

fact { some ((c0_objective_gl.@r_c2_criteria).@r_c2_time_related_objective_criteria).@r_c0_tardiness }
one sig c0_sched extends c0_scheduler
{}

fact { ((c0_sched.@r_c0_taskset).@c0_taskset_ref) = c0_t1 }
fact { ((c0_sched.@r_c0_system).@c0_system_ref) = c0_r1 }
fact { (((c0_sched.@r_c0_properties).@r_c2_objective).@c2_objective_ref) = c0_objective_gl }
fact { some (c0_sched.@r_c1_algorithm).@r_c0_LBBD }
fact { ((((((no (c0_sched.@r_c0_solver).@r_c0_GA_solver) && (no (c0_sched.@r_c0_solver).@r_c0_KS_solver)) && (no (c0_sched.@r_c0_solver).@r_c0_WIS_solver)) && (no (c0_sched.@r_c0_solver).@r_c0_SA_solver)) && (no (c0_sched.@r_c0_solver).@r_c0_B_BS_solver)) && (no (c0_sched.@r_c0_solver).@r_c0_HA_solver)) && (no (c0_sched.@r_c0_solver).@r_c0_KBS_solver) }
