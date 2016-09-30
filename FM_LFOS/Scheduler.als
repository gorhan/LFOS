/*
All clafers: 141 | Abstract: 22 | Concrete: 119 | Reference: 7
Constraints: 20
Goals: 0
Global scope: 1..*
Can skip name resolver: no
*/
open util/integer
pred show {}
run show for 1 but 3 c0_ACTIVE, 3 c0_COMPOSITE, 2 c0_DSB, 2 c0_DSLB, 3 c0_PASSIVE, 6 c0_abstract_objective_criteria, 3 c0_abstraction, 2 c0_aperiodic, 3 c0_capacity, 3 c0_capacity_based, 3 c0_centering, 2 c0_composite, 3 c0_continuous, 2 c0_cooperative, 2 c0_criteria, 2 c0_data_dependency, 2 c0_deadline, 2 c0_dependency, 3 c0_discrete, 3 c0_earliness, 6 c0_eligible_resources, 3 c0_exclusive, 2 c0_execution_time, 2 c0_firm, 2 c0_granularity, 2 c0_hard, 3 c0_identifier, 3 c0_lateness, 3 c0_makespan, 6 c0_maxi, 6 c0_mini, 3 c0_mode, 2 c0_n_tokens, 2 c0_name, 3 c0_objective, 6 c0_objective_purpose, 2 c0_periodic, 2 c0_periodicity, 4 c0_power_consumption, 2 c0_preemptable, 2 c0_priority, 2 c0_purpose, 2 c0_release_time, 4 c0_required_resources, 2 c0_requirement, 3 c0_resource, 2 c0_resource_identifier, 3 c0_resource_related_objective, 4 c0_resource_related_objective_criteria, 6 c0_resource_related_user_defined_criteria, 2 c0_resource_requirement, 3 c0_resource_type, 3 c0_scalable, 3 c0_semantic_based, 2 c0_sequence_dependent_setup_time, 3 c0_shared, 2 c0_soft, 2 c0_sporadic, 3 c0_system, 3 c0_tardiness, 2 c0_task, 2 c0_task_related_objective, 6 c0_task_related_user_defined_criteria, 2 c0_taskset, 2 c0_terminal, 4 c0_throughput, 3 c0_time_related_objective_criteria, 2 c0_timing, 2 c0_token_type, 4 c0_utilization, 2 c1_abstract_objective_criteria, 3 c1_criteria, 2 c1_deadline, 2 c1_name, 2 c1_objective, 3 c1_power_consumption, 3 c1_purpose, 2 c1_requirement, 3 c1_resource_related_objective_criteria, 2 c1_time_related_objective_criteria, 2 c1_timing, 3 c2_abstract_objective_criteria

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

abstract sig c0_abstract_objective_criteria
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
, r_c1_abstract_objective_criteria : lone c1_abstract_objective_criteria }
{ one @r_c0_criteria.this
  let children = (r_c1_time_related_objective_criteria + r_c1_abstract_objective_criteria) | some children }

sig c1_time_related_objective_criteria extends c0_time_related_objective_criteria
{}
{ one @r_c1_time_related_objective_criteria.this
  let children = (r_c0_makespan + r_c0_tardiness + r_c0_earliness + r_c0_lateness + r_c0_centering) | some children }

sig c1_abstract_objective_criteria extends c0_abstract_objective_criteria
{}
{ one @r_c1_abstract_objective_criteria.this
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
, r_c2_abstract_objective_criteria : lone c2_abstract_objective_criteria }
{ one @r_c1_criteria.this
  let children = (r_c1_resource_related_objective_criteria + r_c2_abstract_objective_criteria) | some children }

sig c1_resource_related_objective_criteria extends c0_resource_related_objective_criteria
{}
{ one @r_c1_resource_related_objective_criteria.this
  let children = (r_c0_power_consumption + r_c0_utilization + r_c0_throughput) | some children }

sig c2_abstract_objective_criteria extends c0_abstract_objective_criteria
{}
{ one @r_c2_abstract_objective_criteria.this
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
, r_c3_abstract_objective_criteria : lone c3_abstract_objective_criteria }
{ one @r_c2_criteria.this
  let children = (r_c2_time_related_objective_criteria + r_c2_resource_related_objective_criteria + r_c3_abstract_objective_criteria) | some children }

sig c2_time_related_objective_criteria extends c0_time_related_objective_criteria
{}
{ one @r_c2_time_related_objective_criteria.this
  let children = (r_c0_makespan + r_c0_tardiness + r_c0_earliness + r_c0_lateness + r_c0_centering) | some children }

sig c2_resource_related_objective_criteria extends c0_resource_related_objective_criteria
{}
{ one @r_c2_resource_related_objective_criteria.this
  let children = (r_c0_power_consumption + r_c0_utilization + r_c0_throughput) | some children }

sig c3_abstract_objective_criteria extends c0_abstract_objective_criteria
{}
{ one @r_c3_abstract_objective_criteria.this
  let children = (r_c0_task_related_user_defined_criteria + r_c0_resource_related_user_defined_criteria) | some children }

abstract sig c0_resource
{ r_c0_capacity : one c0_capacity
, r_c0_resource_type : one c0_resource_type
, r_c0_mode : one c0_mode
, r_c1_power_consumption : one c1_power_consumption
, r_c0_objective : lone c0_objective }

sig c0_capacity
{}
{ one @r_c0_capacity.this }

sig c0_resource_type
{ r_c0_abstraction : one c0_abstraction
, r_c0_identifier : one c0_identifier }
{ one @r_c0_resource_type.this }

sig c0_abstraction
{ r_c0_ACTIVE : lone c0_ACTIVE
, r_c0_PASSIVE : lone c0_PASSIVE
, r_c0_COMPOSITE : lone c0_COMPOSITE }
{ one @r_c0_abstraction.this
  let children = (r_c0_ACTIVE + r_c0_PASSIVE + r_c0_COMPOSITE) | one children }

sig c0_ACTIVE
{}
{ one @r_c0_ACTIVE.this }

sig c0_PASSIVE
{}
{ one @r_c0_PASSIVE.this }

sig c0_COMPOSITE
{}
{ one @r_c0_COMPOSITE.this }

sig c0_identifier
{}
{ one @r_c0_identifier.this }

sig c0_mode
{ r_c0_shared : lone c0_shared
, r_c0_exclusive : lone c0_exclusive }
{ one @r_c0_mode.this
  let children = (r_c0_shared + r_c0_exclusive) | one children }

sig c0_shared
{}
{ one @r_c0_shared.this }

sig c0_exclusive
{ r_c0_capacity_based : lone c0_capacity_based
, r_c0_semantic_based : lone c0_semantic_based }
{ one @r_c0_exclusive.this
  let children = (r_c0_capacity_based + r_c0_semantic_based) | some children }

sig c0_capacity_based
{}
{ one @r_c0_capacity_based.this }

sig c0_semantic_based
{}
{ one @r_c0_semantic_based.this }

sig c1_power_consumption
{ r_c0_scalable : lone c0_scalable }
{ one @r_c1_power_consumption.this
  (some this.@r_c0_scalable) => (some (((this.~@r_c1_power_consumption).@r_c0_resource_type).@r_c0_abstraction).@r_c0_ACTIVE) }

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
, r_c0_deadline : one c0_deadline
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

abstract sig c0_resource_requirement
{ r_c0_eligible_resources : some c0_eligible_resources
, r_c0_resource_identifier : one c0_resource_identifier }
{ all disj x, y : this.@r_c0_eligible_resources | (x.@c0_eligible_resources_ref) != (y.@c0_eligible_resources_ref)  }

sig c0_eligible_resources
{ c0_eligible_resources_ref : one c0_resource }
{ one @r_c0_eligible_resources.this }

sig c0_resource_identifier
{}
{ one @r_c0_resource_identifier.this }

abstract sig c0_requirement
{ r_c1_deadline : one c1_deadline
, r_c0_required_resources : some c0_required_resources }
{ all disj x, y : this.@r_c0_required_resources | (x.@c0_required_resources_ref) != (y.@c0_required_resources_ref) 
  no  res : ((this.@r_c0_required_resources).@c0_required_resources_ref).@r_c0_eligible_resources | some (((res.@c0_eligible_resources_ref).@r_c0_resource_type).@r_c0_abstraction).@r_c0_COMPOSITE }

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

sig c0_required_resources
{ c0_required_resources_ref : one c0_resource_requirement }
{ one @r_c0_required_resources.this }

abstract sig c0_data_dependency
{ r_c0_token_type : one c0_token_type
, r_c0_n_tokens : one c0_n_tokens
, r_c0_sequence_dependent_setup_time : one c0_sequence_dependent_setup_time }

sig c0_token_type
{}
{ one @r_c0_token_type.this }

sig c0_n_tokens
{}
{ one @r_c0_n_tokens.this }

sig c0_sequence_dependent_setup_time
{}
{ one @r_c0_sequence_dependent_setup_time.this }

abstract sig c0_task
{ r_c1_timing : one c1_timing
, r_c0_priority : one c0_priority
, r_c0_preemptable : lone c0_preemptable
, r_c1_requirement : one c1_requirement
, r_c0_granularity : one c0_granularity
, r_c1_objective : lone c1_objective
, r_c0_dependency : set c0_dependency }

sig c1_timing extends c0_timing
{}
{ one @r_c1_timing.this }

sig c0_priority
{}
{ one @r_c0_priority.this }

sig c0_preemptable
{ r_c0_cooperative : lone c0_cooperative }
{ one @r_c0_preemptable.this }

sig c0_cooperative
{}
{ one @r_c0_cooperative.this }

sig c1_requirement extends c0_requirement
{}
{ one @r_c1_requirement.this }

sig c0_granularity
{ r_c0_terminal : lone c0_terminal
, r_c0_composite : lone c0_composite }
{ one @r_c0_granularity.this
  let children = (r_c0_terminal + r_c0_composite) | one children }

sig c0_terminal
{}
{ one @r_c0_terminal.this }

sig c0_composite
{}
{ one @r_c0_composite.this }

sig c1_objective extends c0_task_related_objective
{}
{ one @r_c1_objective.this }

sig c0_dependency extends c0_data_dependency
{}
{ one @r_c0_dependency.this }

abstract sig c0_scheduling_policy
{ r_c0_grouping : lone c0_grouping
, r_c0_ranking : one c0_ranking }

sig c0_grouping
{}
{ one @r_c0_grouping.this }

sig c0_ranking
{ r_c0_default : lone c0_default
, r_c0_user_defined : lone c0_user_defined }
{ one @r_c0_ranking.this
  let children = (r_c0_default + r_c0_user_defined) | one children }

sig c0_default
{ r_c0_ERT : lone c0_ERT
, r_c0_ED : lone c0_ED
, r_c0_RM : lone c0_RM
, r_c0_SJF : lone c0_SJF
, r_c0_FIFO : lone c0_FIFO }
{ one @r_c0_default.this
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

sig c0_user_defined
{}
{ one @r_c0_user_defined.this }

abstract sig c0_scheduling_characteristic
{ r_c0_scheduling_characteristic_type : one c0_scheduling_characteristic_type
, r_c0_preemptive : lone c0_preemptive
, r_c0_migration : lone c0_migration
, r_c0_policy : one c0_policy
, r_c0_time_resolution : one c0_time_resolution
, r_c0_priority_assignment : one c0_priority_assignment
, r_c0_scheduling_window : one c0_scheduling_window
, r_c2_objective : some c2_objective }
{ all disj x, y : this.@r_c2_objective | (x.@c2_objective_ref) != (y.@c2_objective_ref)  }

sig c0_scheduling_characteristic_type
{ r_c0_online : lone c0_online
, r_c0_offline : lone c0_offline }
{ one @r_c0_scheduling_characteristic_type.this
  let children = (r_c0_online + r_c0_offline) | one children }

sig c0_online
{}
{ one @r_c0_online.this }

sig c0_offline
{}
{ one @r_c0_offline.this }

sig c0_preemptive
{}
{ one @r_c0_preemptive.this }

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

sig c0_policy extends c0_scheduling_policy
{}
{ one @r_c0_policy.this }

sig c0_time_resolution
{}
{ one @r_c0_time_resolution.this }

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

sig c0_scheduling_window
{}
{ one @r_c0_scheduling_window.this }

sig c2_objective
{ c2_objective_ref : one c0_global_objective }
{ one @r_c2_objective.this }

abstract sig c0_solver
{ r_c0_IBM_ILOG_CPLEX_Optimizer : lone c0_IBM_ILOG_CPLEX_Optimizer
, r_c0_SCIP_SoPlex : lone c0_SCIP_SoPlex
, r_c0_Knapsack : lone c0_Knapsack
, r_c0_SAS_OR_R : lone c0_SAS_OR_R }

sig c0_IBM_ILOG_CPLEX_Optimizer
{}
{ one @r_c0_IBM_ILOG_CPLEX_Optimizer.this }

sig c0_SCIP_SoPlex
{}
{ one @r_c0_SCIP_SoPlex.this }

sig c0_Knapsack
{}
{ one @r_c0_Knapsack.this }

sig c0_SAS_OR_R
{}
{ one @r_c0_SAS_OR_R.this }

abstract sig c0_DSLB
{ r_c0_name : one c0_name }
{ ((this.@r_c0_name).@c0_name_ref) = 0 }

sig c0_name
{ c0_name_ref : one Int }
{ one @r_c0_name.this }

abstract sig c0_DSB
{ r_c1_name : one c1_name }
{ ((this.@r_c1_name).@c1_name_ref) = 1 }

sig c1_name
{ c1_name_ref : one Int }
{ one @r_c1_name.this }

abstract sig c0_input
{ r_c1_DSLB : lone c1_DSLB
, r_c1_DSB : lone c1_DSB }

sig c1_DSLB extends c0_DSLB
{}
{ one @r_c1_DSLB.this }

sig c1_DSB extends c0_DSB
{}
{ one @r_c1_DSB.this }

abstract sig c0_output
{ r_c2_DSLB : lone c2_DSLB
, r_c2_DSB : lone c2_DSB }

sig c2_DSLB extends c0_DSLB
{}
{ one @r_c2_DSLB.this }

sig c2_DSB extends c0_DSB
{}
{ one @r_c2_DSB.this }

abstract sig c0_scheduling_strategy
{ r_c1_solver : one c1_solver
, r_c0_solver_meta_knowledge : one c0_solver_meta_knowledge
, r_c1_input : one c1_input
, r_c1_output : one c1_output }

sig c1_solver extends c0_solver
{}
{ one @r_c1_solver.this
  let children = (r_c0_IBM_ILOG_CPLEX_Optimizer + r_c0_SCIP_SoPlex + r_c0_Knapsack + r_c0_SAS_OR_R) | some children }

sig c0_solver_meta_knowledge
{}
{ one @r_c0_solver_meta_knowledge.this }

sig c1_input extends c0_input
{}
{ one @r_c1_input.this
  let children = (r_c1_DSLB + r_c1_DSB) | some children }

sig c1_output extends c0_output
{}
{ one @r_c1_output.this
  let children = (r_c2_DSLB + r_c2_DSB) | some children }

abstract sig c0_scheduler
{ r_c0_taskset : some c0_taskset
, r_c0_system : some c0_system
, r_c0_properties : one c0_properties
, r_c0_strategy : one c0_strategy }
{ all disj x, y : this.@r_c0_taskset | (x.@c0_taskset_ref) != (y.@c0_taskset_ref) 
  all disj x, y : this.@r_c0_system | (x.@c0_system_ref) != (y.@c0_system_ref)  }

sig c0_taskset
{ c0_taskset_ref : one c0_task }
{ one @r_c0_taskset.this }

sig c0_system
{ c0_system_ref : one c0_resource }
{ one @r_c0_system.this }

sig c0_properties extends c0_scheduling_characteristic
{}
{ one @r_c0_properties.this }

sig c0_strategy extends c0_scheduling_strategy
{}
{ one @r_c0_strategy.this }

one sig c0_cpu1 extends c0_resource
{}

fact { (((some (c0_cpu1.@r_c1_power_consumption).@r_c0_scalable) && (some ((c0_cpu1.@r_c0_mode).@r_c0_exclusive).@r_c0_capacity_based)) && (some (((c0_cpu1.@r_c0_objective).@r_c1_criteria).@r_c1_resource_related_objective_criteria).@r_c0_power_consumption)) && (some ((c0_cpu1.@r_c0_objective).@r_c1_purpose).@r_c0_mini) }
fact { some ((c0_cpu1.@r_c0_resource_type).@r_c0_abstraction).@r_c0_ACTIVE }
one sig c0_cpu2 extends c0_resource
{}

fact { (((some (c0_cpu2.@r_c1_power_consumption).@r_c0_scalable) && (some ((c0_cpu2.@r_c0_mode).@r_c0_exclusive).@r_c0_capacity_based)) && (some (((c0_cpu2.@r_c0_objective).@r_c1_criteria).@r_c1_resource_related_objective_criteria).@r_c0_utilization)) && (some ((c0_cpu2.@r_c0_objective).@r_c1_purpose).@r_c0_maxi) }
fact { some ((c0_cpu2.@r_c0_resource_type).@r_c0_abstraction).@r_c0_ACTIVE }
one sig c0_CPUs extends c0_resource
{}

fact { ((no (c0_CPUs.@r_c1_power_consumption).@r_c0_scalable) && (some ((c0_CPUs.@r_c0_mode).@r_c0_exclusive).@r_c0_capacity_based)) && (some ((c0_CPUs.@r_c0_resource_type).@r_c0_abstraction).@r_c0_COMPOSITE) }
one sig c0_t1 extends c0_task
{}

one sig c0_req1 extends c0_resource_requirement
{}

fact { ((c0_req1.@r_c0_eligible_resources).@c0_eligible_resources_ref) = c0_cpu1 }
fact { (((((((c0_t1.@r_c1_requirement).@r_c0_required_resources).@c0_required_resources_ref) = c0_req1) && (no c0_t1.@r_c1_objective)) && (some ((c0_t1.@r_c1_timing).@r_c0_periodicity).@r_c0_periodic)) && (some (c0_t1.@r_c0_granularity).@r_c0_terminal)) && (no c0_t1.@r_c0_preemptable) }
one sig c0_t2 extends c0_task
{}

one sig c0_req2 extends c0_resource_requirement
{}

fact { ((c0_req2.@r_c0_eligible_resources).@c0_eligible_resources_ref) = c0_cpu2 }
fact { (((((((c0_t2.@r_c1_requirement).@r_c0_required_resources).@c0_required_resources_ref) = c0_req2) && (no c0_t2.@r_c1_objective)) && (some ((c0_t2.@r_c1_timing).@r_c0_periodicity).@r_c0_aperiodic)) && (some (c0_t2.@r_c0_granularity).@r_c0_terminal)) && (some c0_t2.@r_c0_preemptable) }
one sig c0_objective_gl extends c0_global_objective
{}

fact { some ((c0_objective_gl.@r_c2_criteria).@r_c2_time_related_objective_criteria).@r_c0_tardiness }
one sig c0_sched extends c0_scheduler
{}

fact { ((c0_sched.@r_c0_taskset).@c0_taskset_ref) = (c0_t1 + c0_t2) }
fact { ((c0_sched.@r_c0_system).@c0_system_ref) = ((c0_CPUs + c0_cpu1) + c0_cpu2) }
fact { (((c0_sched.@r_c0_properties).@r_c2_objective).@c2_objective_ref) = c0_objective_gl }
fact { ((((some ((c0_sched.@r_c0_strategy).@r_c1_solver).@r_c0_IBM_ILOG_CPLEX_Optimizer) && (some ((c0_sched.@r_c0_strategy).@r_c1_input).@r_c1_DSLB)) && (some ((c0_sched.@r_c0_strategy).@r_c1_input).@r_c1_DSB)) && (some ((c0_sched.@r_c0_strategy).@r_c1_output).@r_c2_DSLB)) && (some ((c0_sched.@r_c0_strategy).@r_c1_output).@r_c2_DSB) }
