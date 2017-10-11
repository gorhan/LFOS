/**
 */
package scheduler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/scheduler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scheduler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulerPackage eINSTANCE = scheduler.impl.SchedulerPackageImpl.init();

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulingWindowImpl <em>Scheduling Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulingWindowImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingWindow()
	 * @generated
	 */
	int SCHEDULING_WINDOW = 28;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_WINDOW__BEGIN = 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_WINDOW__DURATION = 1;

	/**
	 * The number of structural features of the '<em>Scheduling Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_WINDOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Scheduling Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_WINDOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulingCharacteristicImpl <em>Scheduling Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulingCharacteristicImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingCharacteristic()
	 * @generated
	 */
	int SCHEDULING_CHARACTERISTIC = 24;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__BEGIN = SCHEDULING_WINDOW__BEGIN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__DURATION = SCHEDULING_WINDOW__DURATION;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__RANKING = SCHEDULING_WINDOW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grouping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__GROUPING = SCHEDULING_WINDOW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sched Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__SCHED_TYPE = SCHEDULING_WINDOW_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Preemptive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__PREEMPTIVE = SCHEDULING_WINDOW_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__MIGRATION = SCHEDULING_WINDOW_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Priority Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT = SCHEDULING_WINDOW_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Objectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC__OBJECTIVES = SCHEDULING_WINDOW_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Scheduling Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC_FEATURE_COUNT = SCHEDULING_WINDOW_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Scheduling Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_CHARACTERISTIC_OPERATION_COUNT = SCHEDULING_WINDOW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulerImpl <em>Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulerImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getScheduler()
	 * @generated
	 */
	int SCHEDULER = 0;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BEGIN = SCHEDULING_CHARACTERISTIC__BEGIN;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__DURATION = SCHEDULING_CHARACTERISTIC__DURATION;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__RANKING = SCHEDULING_CHARACTERISTIC__RANKING;

	/**
	 * The feature id for the '<em><b>Grouping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__GROUPING = SCHEDULING_CHARACTERISTIC__GROUPING;

	/**
	 * The feature id for the '<em><b>Sched Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SCHED_TYPE = SCHEDULING_CHARACTERISTIC__SCHED_TYPE;

	/**
	 * The feature id for the '<em><b>Preemptive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__PREEMPTIVE = SCHEDULING_CHARACTERISTIC__PREEMPTIVE;

	/**
	 * The feature id for the '<em><b>Migration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__MIGRATION = SCHEDULING_CHARACTERISTIC__MIGRATION;

	/**
	 * The feature id for the '<em><b>Priority Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__PRIORITY_ASSIGNMENT = SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT;

	/**
	 * The feature id for the '<em><b>Objectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__OBJECTIVES = SCHEDULING_CHARACTERISTIC__OBJECTIVES;

	/**
	 * The feature id for the '<em><b>Solvers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SOLVERS = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Taskset</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__TASKSET = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SYSTEM = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__NAME = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__RESOURCE_TYPES = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Token Pool</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__TOKEN_POOL = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_FEATURE_COUNT = SCHEDULING_CHARACTERISTIC_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_OPERATION_COUNT = SCHEDULING_CHARACTERISTIC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.PeriodicityImpl <em>Periodicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.PeriodicityImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getPeriodicity()
	 * @generated
	 */
	int PERIODICITY = 5;

	/**
	 * The feature id for the '<em><b>Period Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODICITY__PERIOD_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODICITY__PERIOD = 1;

	/**
	 * The number of structural features of the '<em>Periodicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODICITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Periodicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODICITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TimingImpl <em>Timing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TimingImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getTiming()
	 * @generated
	 */
	int TIMING = 4;

	/**
	 * The feature id for the '<em><b>Period Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING__PERIOD_TYPE = PERIODICITY__PERIOD_TYPE;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING__PERIOD = PERIODICITY__PERIOD;

	/**
	 * The feature id for the '<em><b>Release Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING__RELEASE_TIME = PERIODICITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING__EXECUTION_TIME = PERIODICITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING__DEADLINE = PERIODICITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_FEATURE_COUNT = PERIODICITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_OPERATION_COUNT = PERIODICITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.AbstractTask <em>Abstract Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.AbstractTask
	 * @see scheduler.impl.SchedulerPackageImpl#getAbstractTask()
	 * @generated
	 */
	int ABSTRACT_TASK = 1;

	/**
	 * The feature id for the '<em><b>Period Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__PERIOD_TYPE = TIMING__PERIOD_TYPE;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__PERIOD = TIMING__PERIOD;

	/**
	 * The feature id for the '<em><b>Release Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__RELEASE_TIME = TIMING__RELEASE_TIME;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__EXECUTION_TIME = TIMING__EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__DEADLINE = TIMING__DEADLINE;

	/**
	 * The feature id for the '<em><b>Ranking Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__RANKING_TYPE = TIMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__PRIORITY_VALUE = TIMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependency Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__DEPENDENCY_ITEM = TIMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__RELATION = TIMING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mutex Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__MUTEX_ITEMS = TIMING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pmtn Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__PMTN_TYPE = TIMING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>NInterruptable Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__NINTERRUPTABLE_DURATION = TIMING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Deadline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__DEADLINE_TYPE = TIMING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__RESOURCE_REQUIREMENT_ITEMS = TIMING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__NAME = TIMING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__TYPE = TIMING_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Fires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__FIRES = TIMING_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Abstract Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK_FEATURE_COUNT = TIMING_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Abstract Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK_OPERATION_COUNT = TIMING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TaskTImpl <em>Task T</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TaskTImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getTaskT()
	 * @generated
	 */
	int TASK_T = 2;

	/**
	 * The feature id for the '<em><b>Period Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__PERIOD_TYPE = ABSTRACT_TASK__PERIOD_TYPE;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__PERIOD = ABSTRACT_TASK__PERIOD;

	/**
	 * The feature id for the '<em><b>Release Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__RELEASE_TIME = ABSTRACT_TASK__RELEASE_TIME;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__EXECUTION_TIME = ABSTRACT_TASK__EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__DEADLINE = ABSTRACT_TASK__DEADLINE;

	/**
	 * The feature id for the '<em><b>Ranking Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__RANKING_TYPE = ABSTRACT_TASK__RANKING_TYPE;

	/**
	 * The feature id for the '<em><b>Priority Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__PRIORITY_VALUE = ABSTRACT_TASK__PRIORITY_VALUE;

	/**
	 * The feature id for the '<em><b>Dependency Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__DEPENDENCY_ITEM = ABSTRACT_TASK__DEPENDENCY_ITEM;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__RELATION = ABSTRACT_TASK__RELATION;

	/**
	 * The feature id for the '<em><b>Mutex Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__MUTEX_ITEMS = ABSTRACT_TASK__MUTEX_ITEMS;

	/**
	 * The feature id for the '<em><b>Pmtn Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__PMTN_TYPE = ABSTRACT_TASK__PMTN_TYPE;

	/**
	 * The feature id for the '<em><b>NInterruptable Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__NINTERRUPTABLE_DURATION = ABSTRACT_TASK__NINTERRUPTABLE_DURATION;

	/**
	 * The feature id for the '<em><b>Deadline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__DEADLINE_TYPE = ABSTRACT_TASK__DEADLINE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__RESOURCE_REQUIREMENT_ITEMS = ABSTRACT_TASK__RESOURCE_REQUIREMENT_ITEMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__TYPE = ABSTRACT_TASK__TYPE;

	/**
	 * The feature id for the '<em><b>Fires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T__FIRES = ABSTRACT_TASK__FIRES;

	/**
	 * The number of structural features of the '<em>Task T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Task T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_T_OPERATION_COUNT = ABSTRACT_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TaskCImpl <em>Task C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TaskCImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getTaskC()
	 * @generated
	 */
	int TASK_C = 3;

	/**
	 * The feature id for the '<em><b>Period Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__PERIOD_TYPE = ABSTRACT_TASK__PERIOD_TYPE;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__PERIOD = ABSTRACT_TASK__PERIOD;

	/**
	 * The feature id for the '<em><b>Release Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__RELEASE_TIME = ABSTRACT_TASK__RELEASE_TIME;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__EXECUTION_TIME = ABSTRACT_TASK__EXECUTION_TIME;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__DEADLINE = ABSTRACT_TASK__DEADLINE;

	/**
	 * The feature id for the '<em><b>Ranking Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__RANKING_TYPE = ABSTRACT_TASK__RANKING_TYPE;

	/**
	 * The feature id for the '<em><b>Priority Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__PRIORITY_VALUE = ABSTRACT_TASK__PRIORITY_VALUE;

	/**
	 * The feature id for the '<em><b>Dependency Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__DEPENDENCY_ITEM = ABSTRACT_TASK__DEPENDENCY_ITEM;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__RELATION = ABSTRACT_TASK__RELATION;

	/**
	 * The feature id for the '<em><b>Mutex Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__MUTEX_ITEMS = ABSTRACT_TASK__MUTEX_ITEMS;

	/**
	 * The feature id for the '<em><b>Pmtn Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__PMTN_TYPE = ABSTRACT_TASK__PMTN_TYPE;

	/**
	 * The feature id for the '<em><b>NInterruptable Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__NINTERRUPTABLE_DURATION = ABSTRACT_TASK__NINTERRUPTABLE_DURATION;

	/**
	 * The feature id for the '<em><b>Deadline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__DEADLINE_TYPE = ABSTRACT_TASK__DEADLINE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__RESOURCE_REQUIREMENT_ITEMS = ABSTRACT_TASK__RESOURCE_REQUIREMENT_ITEMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__NAME = ABSTRACT_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__TYPE = ABSTRACT_TASK__TYPE;

	/**
	 * The feature id for the '<em><b>Fires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__FIRES = ABSTRACT_TASK__FIRES;

	/**
	 * The feature id for the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C__SUB_TASKS = ABSTRACT_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_C_OPERATION_COUNT = ABSTRACT_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.PriorityImpl <em>Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.PriorityImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getPriority()
	 * @generated
	 */
	int PRIORITY = 6;

	/**
	 * The feature id for the '<em><b>Ranking Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__RANKING_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Priority Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY__PRIORITY_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIORITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.DependencyImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 7;

	/**
	 * The feature id for the '<em><b>Dependency Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__DEPENDENCY_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__RELATION = 1;

	/**
	 * The feature id for the '<em><b>Mutex Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__MUTEX_ITEMS = 2;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.DependencyItemImpl <em>Dependency Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.DependencyItemImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getDependencyItem()
	 * @generated
	 */
	int DEPENDENCY_ITEM = 8;

	/**
	 * The feature id for the '<em><b>Num Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ITEM__NUM_TOKENS = 0;

	/**
	 * The feature id for the '<em><b>Setup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ITEM__SETUP_TIME = 1;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ITEM__TOKEN = 2;

	/**
	 * The number of structural features of the '<em>Dependency Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ITEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Dependency Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.PreemptionImpl <em>Preemption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.PreemptionImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getPreemption()
	 * @generated
	 */
	int PREEMPTION = 9;

	/**
	 * The feature id for the '<em><b>Pmtn Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION__PMTN_TYPE = 0;

	/**
	 * The feature id for the '<em><b>NInterruptable Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION__NINTERRUPTABLE_DURATION = 1;

	/**
	 * The number of structural features of the '<em>Preemption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Preemption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREEMPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.DeadlineRequirementImpl <em>Deadline Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.DeadlineRequirementImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getDeadlineRequirement()
	 * @generated
	 */
	int DEADLINE_REQUIREMENT = 11;

	/**
	 * The feature id for the '<em><b>Deadline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_REQUIREMENT__DEADLINE_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Deadline Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_REQUIREMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deadline Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEADLINE_REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.RequirementImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 10;

	/**
	 * The feature id for the '<em><b>Deadline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DEADLINE_TYPE = DEADLINE_REQUIREMENT__DEADLINE_TYPE;

	/**
	 * The feature id for the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS = DEADLINE_REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = DEADLINE_REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = DEADLINE_REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceRequirementImpl <em>Resource Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceRequirementImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceRequirement()
	 * @generated
	 */
	int RESOURCE_REQUIREMENT = 12;

	/**
	 * The feature id for the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceRequirementItemImpl <em>Resource Requirement Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceRequirementItemImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceRequirementItem()
	 * @generated
	 */
	int RESOURCE_REQUIREMENT_ITEM = 13;

	/**
	 * The feature id for the '<em><b>Required Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY = 0;

	/**
	 * The feature id for the '<em><b>Eligible Resource Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Required Resource Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Resource Requirement Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_ITEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Resource Requirement Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REQUIREMENT_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.EligibleResourceImpl <em>Eligible Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.EligibleResourceImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getEligibleResource()
	 * @generated
	 */
	int ELIGIBLE_RESOURCE = 14;

	/**
	 * The feature id for the '<em><b>Wcet On Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIGIBLE_RESOURCE__WCET_ON_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Eligible Resource Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_POINTER = 1;

	/**
	 * The number of structural features of the '<em>Eligible Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIGIBLE_RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Eligible Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELIGIBLE_RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.MutualExclusionImpl <em>Mutual Exclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.MutualExclusionImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMutualExclusion()
	 * @generated
	 */
	int MUTUAL_EXCLUSION = 15;

	/**
	 * The feature id for the '<em><b>Mutex Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION__MUTEX_TASK = 0;

	/**
	 * The number of structural features of the '<em>Mutual Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Mutual Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ModeImpl <em>Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ModeImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMode()
	 * @generated
	 */
	int MODE = 19;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__EXCLUSIVE_RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Resource Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__RESOURCE_MODE = 1;

	/**
	 * The number of structural features of the '<em>Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.AbstractResource <em>Abstract Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.AbstractResource
	 * @see scheduler.impl.SchedulerPackageImpl#getAbstractResource()
	 * @generated
	 */
	int ABSTRACT_RESOURCE = 16;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__EXCLUSIVE_RESOURCES = MODE__EXCLUSIVE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Resource Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__RESOURCE_MODE = MODE__RESOURCE_MODE;

	/**
	 * The feature id for the '<em><b>Renewable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__RENEWABLE = MODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__NAME = MODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__CAPACITY = MODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE__BELONGS = MODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_FEATURE_COUNT = MODE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Abstract Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_OPERATION_COUNT = MODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceTImpl <em>Resource T</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceTImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceT()
	 * @generated
	 */
	int RESOURCE_T = 17;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__EXCLUSIVE_RESOURCES = ABSTRACT_RESOURCE__EXCLUSIVE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Resource Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__RESOURCE_MODE = ABSTRACT_RESOURCE__RESOURCE_MODE;

	/**
	 * The feature id for the '<em><b>Renewable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__RENEWABLE = ABSTRACT_RESOURCE__RENEWABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__NAME = ABSTRACT_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__CAPACITY = ABSTRACT_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__BELONGS = ABSTRACT_RESOURCE__BELONGS;

	/**
	 * The feature id for the '<em><b>Power</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T__POWER = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource T</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_T_OPERATION_COUNT = ABSTRACT_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceCImpl <em>Resource C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceCImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceC()
	 * @generated
	 */
	int RESOURCE_C = 18;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__EXCLUSIVE_RESOURCES = ABSTRACT_RESOURCE__EXCLUSIVE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Resource Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__RESOURCE_MODE = ABSTRACT_RESOURCE__RESOURCE_MODE;

	/**
	 * The feature id for the '<em><b>Renewable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__RENEWABLE = ABSTRACT_RESOURCE__RENEWABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__NAME = ABSTRACT_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__CAPACITY = ABSTRACT_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__BELONGS = ABSTRACT_RESOURCE__BELONGS;

	/**
	 * The feature id for the '<em><b>Sub Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C__SUB_RESOURCES = ABSTRACT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C_FEATURE_COUNT = ABSTRACT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_C_OPERATION_COUNT = ABSTRACT_RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.Power <em>Power</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.Power
	 * @see scheduler.impl.SchedulerPackageImpl#getPower()
	 * @generated
	 */
	int POWER = 20;

	/**
	 * The feature id for the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER__MAX_STATE = 0;

	/**
	 * The feature id for the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER__CURR_POWER_STATE = 1;

	/**
	 * The number of structural features of the '<em>Power</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Power</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.FixedStatePowerConsumptionImpl <em>Fixed State Power Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.FixedStatePowerConsumptionImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getFixedStatePowerConsumption()
	 * @generated
	 */
	int FIXED_STATE_POWER_CONSUMPTION = 21;

	/**
	 * The feature id for the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STATE_POWER_CONSUMPTION__MAX_STATE = POWER__MAX_STATE;

	/**
	 * The feature id for the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE = POWER__CURR_POWER_STATE;

	/**
	 * The number of structural features of the '<em>Fixed State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STATE_POWER_CONSUMPTION_FEATURE_COUNT = POWER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fixed State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STATE_POWER_CONSUMPTION_OPERATION_COUNT = POWER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.Scalable <em>Scalable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.Scalable
	 * @see scheduler.impl.SchedulerPackageImpl#getScalable()
	 * @generated
	 */
	int SCALABLE = 48;

	/**
	 * The feature id for the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE__MAX_STATE = POWER__MAX_STATE;

	/**
	 * The feature id for the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE__CURR_POWER_STATE = POWER__CURR_POWER_STATE;

	/**
	 * The feature id for the '<em><b>Min State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE__MIN_STATE = POWER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Runnable States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE__RUNNABLE_STATES = POWER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Scalable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE_FEATURE_COUNT = POWER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Scalable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALABLE_OPERATION_COUNT = POWER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.DiscreteStatePowerConsumptionImpl <em>Discrete State Power Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.DiscreteStatePowerConsumptionImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getDiscreteStatePowerConsumption()
	 * @generated
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION = 22;

	/**
	 * The feature id for the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION__MAX_STATE = SCALABLE__MAX_STATE;

	/**
	 * The feature id for the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION__CURR_POWER_STATE = SCALABLE__CURR_POWER_STATE;

	/**
	 * The feature id for the '<em><b>Min State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION__MIN_STATE = SCALABLE__MIN_STATE;

	/**
	 * The feature id for the '<em><b>Runnable States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION__RUNNABLE_STATES = SCALABLE__RUNNABLE_STATES;

	/**
	 * The number of structural features of the '<em>Discrete State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION_FEATURE_COUNT = SCALABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Discrete State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_STATE_POWER_CONSUMPTION_OPERATION_COUNT = SCALABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ContinuousStatePowerConsumptionImpl <em>Continuous State Power Consumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ContinuousStatePowerConsumptionImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getContinuousStatePowerConsumption()
	 * @generated
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION = 23;

	/**
	 * The feature id for the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE = SCALABLE__MAX_STATE;

	/**
	 * The feature id for the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE = SCALABLE__CURR_POWER_STATE;

	/**
	 * The feature id for the '<em><b>Min State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE = SCALABLE__MIN_STATE;

	/**
	 * The feature id for the '<em><b>Runnable States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES = SCALABLE__RUNNABLE_STATES;

	/**
	 * The feature id for the '<em><b>Scale Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION = SCALABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Continuous State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION_FEATURE_COUNT = SCALABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Continuous State Power Consumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_STATE_POWER_CONSUMPTION_OPERATION_COUNT = SCALABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ObjectiveImpl <em>Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ObjectiveImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getObjective()
	 * @generated
	 */
	int OBJECTIVE = 25;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__PURPOSE = 0;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__CRITERIA = 1;

	/**
	 * The number of structural features of the '<em>Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceObjectiveImpl <em>Resource Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceObjectiveImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceObjective()
	 * @generated
	 */
	int RESOURCE_OBJECTIVE = 26;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OBJECTIVE__PURPOSE = OBJECTIVE__PURPOSE;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OBJECTIVE__CRITERIA = OBJECTIVE__CRITERIA;

	/**
	 * The number of structural features of the '<em>Resource Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OBJECTIVE_FEATURE_COUNT = OBJECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OBJECTIVE_OPERATION_COUNT = OBJECTIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TaskObjectiveImpl <em>Task Objective</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TaskObjectiveImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getTaskObjective()
	 * @generated
	 */
	int TASK_OBJECTIVE = 27;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OBJECTIVE__PURPOSE = OBJECTIVE__PURPOSE;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OBJECTIVE__CRITERIA = OBJECTIVE__CRITERIA;

	/**
	 * The number of structural features of the '<em>Task Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OBJECTIVE_FEATURE_COUNT = OBJECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Task Objective</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OBJECTIVE_OPERATION_COUNT = OBJECTIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulingPolicyImpl <em>Scheduling Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulingPolicyImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingPolicy()
	 * @generated
	 */
	int SCHEDULING_POLICY = 29;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY__RANKING = 0;

	/**
	 * The feature id for the '<em><b>Grouping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY__GROUPING = 1;

	/**
	 * The number of structural features of the '<em>Scheduling Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Scheduling Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SolverAdapterImpl <em>Solver Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SolverAdapterImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSolverAdapter()
	 * @generated
	 */
	int SOLVER_ADAPTER = 31;

	/**
	 * The feature id for the '<em><b>Solvers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ADAPTER__SOLVERS = 0;

	/**
	 * The number of structural features of the '<em>Solver Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ADAPTER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Solver Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ADAPTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulingStrategyImpl <em>Scheduling Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulingStrategyImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingStrategy()
	 * @generated
	 */
	int SCHEDULING_STRATEGY = 30;

	/**
	 * The feature id for the '<em><b>Solvers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_STRATEGY__SOLVERS = SOLVER_ADAPTER__SOLVERS;

	/**
	 * The number of structural features of the '<em>Scheduling Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_STRATEGY_FEATURE_COUNT = SOLVER_ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Scheduling Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_STRATEGY_OPERATION_COUNT = SOLVER_ADAPTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.NumberJackImpl <em>Number Jack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.NumberJackImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getNumberJack()
	 * @generated
	 */
	int NUMBER_JACK = 32;

	/**
	 * The number of structural features of the '<em>Number Jack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_JACK_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Number Jack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_JACK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SCIPImpl <em>SCIP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SCIPImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSCIP()
	 * @generated
	 */
	int SCIP = 33;

	/**
	 * The number of structural features of the '<em>SCIP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIP_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>SCIP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIP_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.MiniSatImpl <em>Mini Sat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.MiniSatImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMiniSat()
	 * @generated
	 */
	int MINI_SAT = 34;

	/**
	 * The number of structural features of the '<em>Mini Sat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINI_SAT_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mini Sat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINI_SAT_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.MipWrapperImpl <em>Mip Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.MipWrapperImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMipWrapper()
	 * @generated
	 */
	int MIP_WRAPPER = 35;

	/**
	 * The number of structural features of the '<em>Mip Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIP_WRAPPER_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mip Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIP_WRAPPER_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.MistralImpl <em>Mistral</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.MistralImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMistral()
	 * @generated
	 */
	int MISTRAL = 36;

	/**
	 * The number of structural features of the '<em>Mistral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISTRAL_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mistral</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISTRAL_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.Mistral2Impl <em>Mistral2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.Mistral2Impl
	 * @see scheduler.impl.SchedulerPackageImpl#getMistral2()
	 * @generated
	 */
	int MISTRAL2 = 37;

	/**
	 * The number of structural features of the '<em>Mistral2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISTRAL2_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mistral2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISTRAL2_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.SatWrapperImpl <em>Sat Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SatWrapperImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSatWrapper()
	 * @generated
	 */
	int SAT_WRAPPER = 38;

	/**
	 * The number of structural features of the '<em>Sat Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAT_WRAPPER_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sat Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAT_WRAPPER_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.Toulbar2Impl <em>Toulbar2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.Toulbar2Impl
	 * @see scheduler.impl.SchedulerPackageImpl#getToulbar2()
	 * @generated
	 */
	int TOULBAR2 = 39;

	/**
	 * The number of structural features of the '<em>Toulbar2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOULBAR2_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Toulbar2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOULBAR2_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.WalksatImpl <em>Walksat</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.WalksatImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getWalksat()
	 * @generated
	 */
	int WALKSAT = 40;

	/**
	 * The number of structural features of the '<em>Walksat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WALKSAT_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Walksat</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WALKSAT_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.OtherImpl <em>Other</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.OtherImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getOther()
	 * @generated
	 */
	int OTHER = 41;

	/**
	 * The number of structural features of the '<em>Other</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_FEATURE_COUNT = NUMBER_JACK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Other</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_OPERATION_COUNT = NUMBER_JACK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.OutputImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 42;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TextualImpl <em>Textual</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TextualImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getTextual()
	 * @generated
	 */
	int TEXTUAL = 43;

	/**
	 * The number of structural features of the '<em>Textual</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_FEATURE_COUNT = OUTPUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Textual</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTUAL_OPERATION_COUNT = OUTPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.PlotImpl <em>Plot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.PlotImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getPlot()
	 * @generated
	 */
	int PLOT = 44;

	/**
	 * The number of structural features of the '<em>Plot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_FEATURE_COUNT = OUTPUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Plot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOT_OPERATION_COUNT = OUTPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.MatPlotLibImpl <em>Mat Plot Lib</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.MatPlotLibImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getMatPlotLib()
	 * @generated
	 */
	int MAT_PLOT_LIB = 45;

	/**
	 * The number of structural features of the '<em>Mat Plot Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAT_PLOT_LIB_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Mat Plot Lib</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAT_PLOT_LIB_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.ResourceTypeImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 46;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__HAS = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ABSTRACTION = 2;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.PowerStateImpl <em>Power State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.PowerStateImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getPowerState()
	 * @generated
	 */
	int POWER_STATE = 47;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_STATE__SCALE = 0;

	/**
	 * The feature id for the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_STATE__POWER_CONSUMPTION = 1;

	/**
	 * The number of structural features of the '<em>Power State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_STATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Power State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.TokenImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__AMOUNT = 1;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scheduler.PeriodicityType <em>Periodicity Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.PeriodicityType
	 * @see scheduler.impl.SchedulerPackageImpl#getPeriodicityType()
	 * @generated
	 */
	int PERIODICITY_TYPE = 50;

	/**
	 * The meta object id for the '{@link scheduler.PriorityRankingType <em>Priority Ranking Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.PriorityRankingType
	 * @see scheduler.impl.SchedulerPackageImpl#getPriorityRankingType()
	 * @generated
	 */
	int PRIORITY_RANKING_TYPE = 51;

	/**
	 * The meta object id for the '{@link scheduler.LogicalRelation <em>Logical Relation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.LogicalRelation
	 * @see scheduler.impl.SchedulerPackageImpl#getLogicalRelation()
	 * @generated
	 */
	int LOGICAL_RELATION = 52;

	/**
	 * The meta object id for the '{@link scheduler.PreemptionType <em>Preemption Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.PreemptionType
	 * @see scheduler.impl.SchedulerPackageImpl#getPreemptionType()
	 * @generated
	 */
	int PREEMPTION_TYPE = 53;

	/**
	 * The meta object id for the '{@link scheduler.DeadlineType <em>Deadline Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.DeadlineType
	 * @see scheduler.impl.SchedulerPackageImpl#getDeadlineType()
	 * @generated
	 */
	int DEADLINE_TYPE = 54;

	/**
	 * The meta object id for the '{@link scheduler.ResourceAbstraction <em>Resource Abstraction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.ResourceAbstraction
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceAbstraction()
	 * @generated
	 */
	int RESOURCE_ABSTRACTION = 55;

	/**
	 * The meta object id for the '{@link scheduler.ResourceMode <em>Resource Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.ResourceMode
	 * @see scheduler.impl.SchedulerPackageImpl#getResourceMode()
	 * @generated
	 */
	int RESOURCE_MODE = 56;

	/**
	 * The meta object id for the '{@link scheduler.SchedulingType <em>Scheduling Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.SchedulingType
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingType()
	 * @generated
	 */
	int SCHEDULING_TYPE = 57;

	/**
	 * The meta object id for the '{@link scheduler.MigrationType <em>Migration Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.MigrationType
	 * @see scheduler.impl.SchedulerPackageImpl#getMigrationType()
	 * @generated
	 */
	int MIGRATION_TYPE = 58;

	/**
	 * The meta object id for the '{@link scheduler.PriorityAssignmentType <em>Priority Assignment Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.PriorityAssignmentType
	 * @see scheduler.impl.SchedulerPackageImpl#getPriorityAssignmentType()
	 * @generated
	 */
	int PRIORITY_ASSIGNMENT_TYPE = 59;

	/**
	 * The meta object id for the '{@link scheduler.ObjectiveCriteria <em>Objective Criteria</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.ObjectiveCriteria
	 * @see scheduler.impl.SchedulerPackageImpl#getObjectiveCriteria()
	 * @generated
	 */
	int OBJECTIVE_CRITERIA = 60;

	/**
	 * The meta object id for the '{@link scheduler.ObjectivePurpose <em>Objective Purpose</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.ObjectivePurpose
	 * @see scheduler.impl.SchedulerPackageImpl#getObjectivePurpose()
	 * @generated
	 */
	int OBJECTIVE_PURPOSE = 61;

	/**
	 * The meta object id for the '{@link scheduler.SchedulingPolicyType <em>Scheduling Policy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.SchedulingPolicyType
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingPolicyType()
	 * @generated
	 */
	int SCHEDULING_POLICY_TYPE = 62;


	/**
	 * Returns the meta object for class '{@link scheduler.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler</em>'.
	 * @see scheduler.Scheduler
	 * @generated
	 */
	EClass getScheduler();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Scheduler#getTaskset <em>Taskset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Taskset</em>'.
	 * @see scheduler.Scheduler#getTaskset()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Taskset();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.Scheduler#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see scheduler.Scheduler#getSystem()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_System();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Scheduler#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.Scheduler#getName()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Scheduler#getResourceTypes <em>Resource Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Types</em>'.
	 * @see scheduler.Scheduler#getResourceTypes()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_ResourceTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Scheduler#getTokenPool <em>Token Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Token Pool</em>'.
	 * @see scheduler.Scheduler#getTokenPool()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_TokenPool();

	/**
	 * Returns the meta object for class '{@link scheduler.AbstractTask <em>Abstract Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Task</em>'.
	 * @see scheduler.AbstractTask
	 * @generated
	 */
	EClass getAbstractTask();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.AbstractTask#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.AbstractTask#getName()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.AbstractTask#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see scheduler.AbstractTask#getType()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.AbstractTask#getFires <em>Fires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fires</em>'.
	 * @see scheduler.AbstractTask#getFires()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EReference getAbstractTask_Fires();

	/**
	 * Returns the meta object for class '{@link scheduler.TaskT <em>Task T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task T</em>'.
	 * @see scheduler.TaskT
	 * @generated
	 */
	EClass getTaskT();

	/**
	 * Returns the meta object for class '{@link scheduler.TaskC <em>Task C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task C</em>'.
	 * @see scheduler.TaskC
	 * @generated
	 */
	EClass getTaskC();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.TaskC#getSubTasks <em>Sub Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Tasks</em>'.
	 * @see scheduler.TaskC#getSubTasks()
	 * @see #getTaskC()
	 * @generated
	 */
	EReference getTaskC_SubTasks();

	/**
	 * Returns the meta object for class '{@link scheduler.Timing <em>Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timing</em>'.
	 * @see scheduler.Timing
	 * @generated
	 */
	EClass getTiming();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Timing#getReleaseTime <em>Release Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Time</em>'.
	 * @see scheduler.Timing#getReleaseTime()
	 * @see #getTiming()
	 * @generated
	 */
	EAttribute getTiming_ReleaseTime();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Timing#getExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Time</em>'.
	 * @see scheduler.Timing#getExecutionTime()
	 * @see #getTiming()
	 * @generated
	 */
	EAttribute getTiming_ExecutionTime();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Timing#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see scheduler.Timing#getDeadline()
	 * @see #getTiming()
	 * @generated
	 */
	EAttribute getTiming_Deadline();

	/**
	 * Returns the meta object for class '{@link scheduler.Periodicity <em>Periodicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodicity</em>'.
	 * @see scheduler.Periodicity
	 * @generated
	 */
	EClass getPeriodicity();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Periodicity#getPeriodType <em>Period Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period Type</em>'.
	 * @see scheduler.Periodicity#getPeriodType()
	 * @see #getPeriodicity()
	 * @generated
	 */
	EAttribute getPeriodicity_PeriodType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Periodicity#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see scheduler.Periodicity#getPeriod()
	 * @see #getPeriodicity()
	 * @generated
	 */
	EAttribute getPeriodicity_Period();

	/**
	 * Returns the meta object for class '{@link scheduler.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Priority</em>'.
	 * @see scheduler.Priority
	 * @generated
	 */
	EClass getPriority();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Priority#getRankingType <em>Ranking Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ranking Type</em>'.
	 * @see scheduler.Priority#getRankingType()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_RankingType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Priority#getPriorityValue <em>Priority Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority Value</em>'.
	 * @see scheduler.Priority#getPriorityValue()
	 * @see #getPriority()
	 * @generated
	 */
	EAttribute getPriority_PriorityValue();

	/**
	 * Returns the meta object for class '{@link scheduler.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see scheduler.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Dependency#getDependencyItem <em>Dependency Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependency Item</em>'.
	 * @see scheduler.Dependency#getDependencyItem()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_DependencyItem();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Dependency#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation</em>'.
	 * @see scheduler.Dependency#getRelation()
	 * @see #getDependency()
	 * @generated
	 */
	EAttribute getDependency_Relation();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Dependency#getMutexItems <em>Mutex Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mutex Items</em>'.
	 * @see scheduler.Dependency#getMutexItems()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_MutexItems();

	/**
	 * Returns the meta object for class '{@link scheduler.DependencyItem <em>Dependency Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Item</em>'.
	 * @see scheduler.DependencyItem
	 * @generated
	 */
	EClass getDependencyItem();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.DependencyItem#getNumTokens <em>Num Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Tokens</em>'.
	 * @see scheduler.DependencyItem#getNumTokens()
	 * @see #getDependencyItem()
	 * @generated
	 */
	EAttribute getDependencyItem_NumTokens();

	/**
	 * Returns the meta object for the reference '{@link scheduler.DependencyItem#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Token</em>'.
	 * @see scheduler.DependencyItem#getToken()
	 * @see #getDependencyItem()
	 * @generated
	 */
	EReference getDependencyItem_Token();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.DependencyItem#getSetupTime <em>Setup Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Setup Time</em>'.
	 * @see scheduler.DependencyItem#getSetupTime()
	 * @see #getDependencyItem()
	 * @generated
	 */
	EAttribute getDependencyItem_SetupTime();

	/**
	 * Returns the meta object for class '{@link scheduler.Preemption <em>Preemption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preemption</em>'.
	 * @see scheduler.Preemption
	 * @generated
	 */
	EClass getPreemption();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Preemption#getPmtnType <em>Pmtn Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pmtn Type</em>'.
	 * @see scheduler.Preemption#getPmtnType()
	 * @see #getPreemption()
	 * @generated
	 */
	EAttribute getPreemption_PmtnType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Preemption#getNInterruptableDuration <em>NInterruptable Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NInterruptable Duration</em>'.
	 * @see scheduler.Preemption#getNInterruptableDuration()
	 * @see #getPreemption()
	 * @generated
	 */
	EAttribute getPreemption_NInterruptableDuration();

	/**
	 * Returns the meta object for class '{@link scheduler.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see scheduler.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for class '{@link scheduler.DeadlineRequirement <em>Deadline Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deadline Requirement</em>'.
	 * @see scheduler.DeadlineRequirement
	 * @generated
	 */
	EClass getDeadlineRequirement();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.DeadlineRequirement#getDeadlineType <em>Deadline Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline Type</em>'.
	 * @see scheduler.DeadlineRequirement#getDeadlineType()
	 * @see #getDeadlineRequirement()
	 * @generated
	 */
	EAttribute getDeadlineRequirement_DeadlineType();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceRequirement <em>Resource Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Requirement</em>'.
	 * @see scheduler.ResourceRequirement
	 * @generated
	 */
	EClass getResourceRequirement();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.ResourceRequirement#getResourceRequirementItems <em>Resource Requirement Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Requirement Items</em>'.
	 * @see scheduler.ResourceRequirement#getResourceRequirementItems()
	 * @see #getResourceRequirement()
	 * @generated
	 */
	EReference getResourceRequirement_ResourceRequirementItems();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceRequirementItem <em>Resource Requirement Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Requirement Item</em>'.
	 * @see scheduler.ResourceRequirementItem
	 * @generated
	 */
	EClass getResourceRequirementItem();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.ResourceRequirementItem#getRequiredCapacity <em>Required Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Capacity</em>'.
	 * @see scheduler.ResourceRequirementItem#getRequiredCapacity()
	 * @see #getResourceRequirementItem()
	 * @generated
	 */
	EAttribute getResourceRequirementItem_RequiredCapacity();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.ResourceRequirementItem#getEligibleResourceItem <em>Eligible Resource Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Eligible Resource Item</em>'.
	 * @see scheduler.ResourceRequirementItem#getEligibleResourceItem()
	 * @see #getResourceRequirementItem()
	 * @generated
	 */
	EReference getResourceRequirementItem_EligibleResourceItem();

	/**
	 * Returns the meta object for the reference '{@link scheduler.ResourceRequirementItem#getRequiredResourceType <em>Required Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Resource Type</em>'.
	 * @see scheduler.ResourceRequirementItem#getRequiredResourceType()
	 * @see #getResourceRequirementItem()
	 * @generated
	 */
	EReference getResourceRequirementItem_RequiredResourceType();

	/**
	 * Returns the meta object for class '{@link scheduler.EligibleResource <em>Eligible Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eligible Resource</em>'.
	 * @see scheduler.EligibleResource
	 * @generated
	 */
	EClass getEligibleResource();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.EligibleResource#getWcetOnResource <em>Wcet On Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wcet On Resource</em>'.
	 * @see scheduler.EligibleResource#getWcetOnResource()
	 * @see #getEligibleResource()
	 * @generated
	 */
	EAttribute getEligibleResource_WcetOnResource();

	/**
	 * Returns the meta object for the reference '{@link scheduler.EligibleResource#getEligibleResourcePointer <em>Eligible Resource Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eligible Resource Pointer</em>'.
	 * @see scheduler.EligibleResource#getEligibleResourcePointer()
	 * @see #getEligibleResource()
	 * @generated
	 */
	EReference getEligibleResource_EligibleResourcePointer();

	/**
	 * Returns the meta object for class '{@link scheduler.MutualExclusion <em>Mutual Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutual Exclusion</em>'.
	 * @see scheduler.MutualExclusion
	 * @generated
	 */
	EClass getMutualExclusion();

	/**
	 * Returns the meta object for the reference '{@link scheduler.MutualExclusion#getMutexTask <em>Mutex Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mutex Task</em>'.
	 * @see scheduler.MutualExclusion#getMutexTask()
	 * @see #getMutualExclusion()
	 * @generated
	 */
	EReference getMutualExclusion_MutexTask();

	/**
	 * Returns the meta object for class '{@link scheduler.AbstractResource <em>Abstract Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource</em>'.
	 * @see scheduler.AbstractResource
	 * @generated
	 */
	EClass getAbstractResource();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.AbstractResource#isRenewable <em>Renewable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Renewable</em>'.
	 * @see scheduler.AbstractResource#isRenewable()
	 * @see #getAbstractResource()
	 * @generated
	 */
	EAttribute getAbstractResource_Renewable();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.AbstractResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.AbstractResource#getName()
	 * @see #getAbstractResource()
	 * @generated
	 */
	EAttribute getAbstractResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.AbstractResource#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see scheduler.AbstractResource#getCapacity()
	 * @see #getAbstractResource()
	 * @generated
	 */
	EAttribute getAbstractResource_Capacity();

	/**
	 * Returns the meta object for the reference '{@link scheduler.AbstractResource#getBelongs <em>Belongs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Belongs</em>'.
	 * @see scheduler.AbstractResource#getBelongs()
	 * @see #getAbstractResource()
	 * @generated
	 */
	EReference getAbstractResource_Belongs();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceT <em>Resource T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource T</em>'.
	 * @see scheduler.ResourceT
	 * @generated
	 */
	EClass getResourceT();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.ResourceT#getPower <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Power</em>'.
	 * @see scheduler.ResourceT#getPower()
	 * @see #getResourceT()
	 * @generated
	 */
	EReference getResourceT_Power();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceC <em>Resource C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource C</em>'.
	 * @see scheduler.ResourceC
	 * @generated
	 */
	EClass getResourceC();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.ResourceC#getSubResources <em>Sub Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Resources</em>'.
	 * @see scheduler.ResourceC#getSubResources()
	 * @see #getResourceC()
	 * @generated
	 */
	EReference getResourceC_SubResources();

	/**
	 * Returns the meta object for class '{@link scheduler.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode</em>'.
	 * @see scheduler.Mode
	 * @generated
	 */
	EClass getMode();

	/**
	 * Returns the meta object for the reference list '{@link scheduler.Mode#getExclusiveResources <em>Exclusive Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exclusive Resources</em>'.
	 * @see scheduler.Mode#getExclusiveResources()
	 * @see #getMode()
	 * @generated
	 */
	EReference getMode_ExclusiveResources();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Mode#getResourceMode <em>Resource Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Mode</em>'.
	 * @see scheduler.Mode#getResourceMode()
	 * @see #getMode()
	 * @generated
	 */
	EAttribute getMode_ResourceMode();

	/**
	 * Returns the meta object for class '{@link scheduler.Power <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power</em>'.
	 * @see scheduler.Power
	 * @generated
	 */
	EClass getPower();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.Power#getMaxState <em>Max State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Max State</em>'.
	 * @see scheduler.Power#getMaxState()
	 * @see #getPower()
	 * @generated
	 */
	EReference getPower_MaxState();

	/**
	 * Returns the meta object for the reference '{@link scheduler.Power#getCurrPowerState <em>Curr Power State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Curr Power State</em>'.
	 * @see scheduler.Power#getCurrPowerState()
	 * @see #getPower()
	 * @generated
	 */
	EReference getPower_CurrPowerState();

	/**
	 * Returns the meta object for class '{@link scheduler.FixedStatePowerConsumption <em>Fixed State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed State Power Consumption</em>'.
	 * @see scheduler.FixedStatePowerConsumption
	 * @generated
	 */
	EClass getFixedStatePowerConsumption();

	/**
	 * Returns the meta object for class '{@link scheduler.DiscreteStatePowerConsumption <em>Discrete State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discrete State Power Consumption</em>'.
	 * @see scheduler.DiscreteStatePowerConsumption
	 * @generated
	 */
	EClass getDiscreteStatePowerConsumption();

	/**
	 * Returns the meta object for class '{@link scheduler.ContinuousStatePowerConsumption <em>Continuous State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous State Power Consumption</em>'.
	 * @see scheduler.ContinuousStatePowerConsumption
	 * @generated
	 */
	EClass getContinuousStatePowerConsumption();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.ContinuousStatePowerConsumption#getScalePrecision <em>Scale Precision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale Precision</em>'.
	 * @see scheduler.ContinuousStatePowerConsumption#getScalePrecision()
	 * @see #getContinuousStatePowerConsumption()
	 * @generated
	 */
	EAttribute getContinuousStatePowerConsumption_ScalePrecision();

	/**
	 * Returns the meta object for class '{@link scheduler.SchedulingCharacteristic <em>Scheduling Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Characteristic</em>'.
	 * @see scheduler.SchedulingCharacteristic
	 * @generated
	 */
	EClass getSchedulingCharacteristic();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingCharacteristic#getSchedType <em>Sched Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sched Type</em>'.
	 * @see scheduler.SchedulingCharacteristic#getSchedType()
	 * @see #getSchedulingCharacteristic()
	 * @generated
	 */
	EAttribute getSchedulingCharacteristic_SchedType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingCharacteristic#isPreemptive <em>Preemptive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preemptive</em>'.
	 * @see scheduler.SchedulingCharacteristic#isPreemptive()
	 * @see #getSchedulingCharacteristic()
	 * @generated
	 */
	EAttribute getSchedulingCharacteristic_Preemptive();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingCharacteristic#getMigration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Migration</em>'.
	 * @see scheduler.SchedulingCharacteristic#getMigration()
	 * @see #getSchedulingCharacteristic()
	 * @generated
	 */
	EAttribute getSchedulingCharacteristic_Migration();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingCharacteristic#getPriorityAssignment <em>Priority Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority Assignment</em>'.
	 * @see scheduler.SchedulingCharacteristic#getPriorityAssignment()
	 * @see #getSchedulingCharacteristic()
	 * @generated
	 */
	EAttribute getSchedulingCharacteristic_PriorityAssignment();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SchedulingCharacteristic#getObjectives <em>Objectives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objectives</em>'.
	 * @see scheduler.SchedulingCharacteristic#getObjectives()
	 * @see #getSchedulingCharacteristic()
	 * @generated
	 */
	EReference getSchedulingCharacteristic_Objectives();

	/**
	 * Returns the meta object for class '{@link scheduler.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objective</em>'.
	 * @see scheduler.Objective
	 * @generated
	 */
	EClass getObjective();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Objective#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see scheduler.Objective#getPurpose()
	 * @see #getObjective()
	 * @generated
	 */
	EAttribute getObjective_Purpose();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Objective#getCriteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Criteria</em>'.
	 * @see scheduler.Objective#getCriteria()
	 * @see #getObjective()
	 * @generated
	 */
	EAttribute getObjective_Criteria();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceObjective <em>Resource Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Objective</em>'.
	 * @see scheduler.ResourceObjective
	 * @generated
	 */
	EClass getResourceObjective();

	/**
	 * Returns the meta object for class '{@link scheduler.TaskObjective <em>Task Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Objective</em>'.
	 * @see scheduler.TaskObjective
	 * @generated
	 */
	EClass getTaskObjective();

	/**
	 * Returns the meta object for class '{@link scheduler.SchedulingWindow <em>Scheduling Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Window</em>'.
	 * @see scheduler.SchedulingWindow
	 * @generated
	 */
	EClass getSchedulingWindow();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingWindow#getBegin <em>Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin</em>'.
	 * @see scheduler.SchedulingWindow#getBegin()
	 * @see #getSchedulingWindow()
	 * @generated
	 */
	EAttribute getSchedulingWindow_Begin();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingWindow#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see scheduler.SchedulingWindow#getDuration()
	 * @see #getSchedulingWindow()
	 * @generated
	 */
	EAttribute getSchedulingWindow_Duration();

	/**
	 * Returns the meta object for class '{@link scheduler.SchedulingPolicy <em>Scheduling Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Policy</em>'.
	 * @see scheduler.SchedulingPolicy
	 * @generated
	 */
	EClass getSchedulingPolicy();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingPolicy#getRanking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ranking</em>'.
	 * @see scheduler.SchedulingPolicy#getRanking()
	 * @see #getSchedulingPolicy()
	 * @generated
	 */
	EAttribute getSchedulingPolicy_Ranking();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.SchedulingPolicy#isGrouping <em>Grouping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grouping</em>'.
	 * @see scheduler.SchedulingPolicy#isGrouping()
	 * @see #getSchedulingPolicy()
	 * @generated
	 */
	EAttribute getSchedulingPolicy_Grouping();

	/**
	 * Returns the meta object for class '{@link scheduler.SchedulingStrategy <em>Scheduling Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Strategy</em>'.
	 * @see scheduler.SchedulingStrategy
	 * @generated
	 */
	EClass getSchedulingStrategy();

	/**
	 * Returns the meta object for class '{@link scheduler.SolverAdapter <em>Solver Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Adapter</em>'.
	 * @see scheduler.SolverAdapter
	 * @generated
	 */
	EClass getSolverAdapter();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SolverAdapter#getSolvers <em>Solvers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solvers</em>'.
	 * @see scheduler.SolverAdapter#getSolvers()
	 * @see #getSolverAdapter()
	 * @generated
	 */
	EReference getSolverAdapter_Solvers();

	/**
	 * Returns the meta object for class '{@link scheduler.NumberJack <em>Number Jack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Jack</em>'.
	 * @see scheduler.NumberJack
	 * @generated
	 */
	EClass getNumberJack();

	/**
	 * Returns the meta object for class '{@link scheduler.SCIP <em>SCIP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCIP</em>'.
	 * @see scheduler.SCIP
	 * @generated
	 */
	EClass getSCIP();

	/**
	 * Returns the meta object for class '{@link scheduler.MiniSat <em>Mini Sat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mini Sat</em>'.
	 * @see scheduler.MiniSat
	 * @generated
	 */
	EClass getMiniSat();

	/**
	 * Returns the meta object for class '{@link scheduler.MipWrapper <em>Mip Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mip Wrapper</em>'.
	 * @see scheduler.MipWrapper
	 * @generated
	 */
	EClass getMipWrapper();

	/**
	 * Returns the meta object for class '{@link scheduler.Mistral <em>Mistral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mistral</em>'.
	 * @see scheduler.Mistral
	 * @generated
	 */
	EClass getMistral();

	/**
	 * Returns the meta object for class '{@link scheduler.Mistral2 <em>Mistral2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mistral2</em>'.
	 * @see scheduler.Mistral2
	 * @generated
	 */
	EClass getMistral2();

	/**
	 * Returns the meta object for class '{@link scheduler.SatWrapper <em>Sat Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sat Wrapper</em>'.
	 * @see scheduler.SatWrapper
	 * @generated
	 */
	EClass getSatWrapper();

	/**
	 * Returns the meta object for class '{@link scheduler.Toulbar2 <em>Toulbar2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Toulbar2</em>'.
	 * @see scheduler.Toulbar2
	 * @generated
	 */
	EClass getToulbar2();

	/**
	 * Returns the meta object for class '{@link scheduler.Walksat <em>Walksat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Walksat</em>'.
	 * @see scheduler.Walksat
	 * @generated
	 */
	EClass getWalksat();

	/**
	 * Returns the meta object for class '{@link scheduler.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other</em>'.
	 * @see scheduler.Other
	 * @generated
	 */
	EClass getOther();

	/**
	 * Returns the meta object for class '{@link scheduler.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see scheduler.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for class '{@link scheduler.Textual <em>Textual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textual</em>'.
	 * @see scheduler.Textual
	 * @generated
	 */
	EClass getTextual();

	/**
	 * Returns the meta object for class '{@link scheduler.Plot <em>Plot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plot</em>'.
	 * @see scheduler.Plot
	 * @generated
	 */
	EClass getPlot();

	/**
	 * Returns the meta object for class '{@link scheduler.MatPlotLib <em>Mat Plot Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mat Plot Lib</em>'.
	 * @see scheduler.MatPlotLib
	 * @generated
	 */
	EClass getMatPlotLib();

	/**
	 * Returns the meta object for class '{@link scheduler.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see scheduler.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.ResourceType#getAbstraction <em>Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstraction</em>'.
	 * @see scheduler.ResourceType#getAbstraction()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Abstraction();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.ResourceType#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see scheduler.ResourceType#getIdentifier()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Identifier();

	/**
	 * Returns the meta object for the reference list '{@link scheduler.ResourceType#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has</em>'.
	 * @see scheduler.ResourceType#getHas()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Has();

	/**
	 * Returns the meta object for class '{@link scheduler.PowerState <em>Power State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power State</em>'.
	 * @see scheduler.PowerState
	 * @generated
	 */
	EClass getPowerState();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.PowerState#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see scheduler.PowerState#getScale()
	 * @see #getPowerState()
	 * @generated
	 */
	EAttribute getPowerState_Scale();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.PowerState#getPowerConsumption <em>Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Power Consumption</em>'.
	 * @see scheduler.PowerState#getPowerConsumption()
	 * @see #getPowerState()
	 * @generated
	 */
	EAttribute getPowerState_PowerConsumption();

	/**
	 * Returns the meta object for class '{@link scheduler.Scalable <em>Scalable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalable</em>'.
	 * @see scheduler.Scalable
	 * @generated
	 */
	EClass getScalable();

	/**
	 * Returns the meta object for the containment reference '{@link scheduler.Scalable#getMinState <em>Min State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Min State</em>'.
	 * @see scheduler.Scalable#getMinState()
	 * @see #getScalable()
	 * @generated
	 */
	EReference getScalable_MinState();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.Scalable#getRunnableStates <em>Runnable States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Runnable States</em>'.
	 * @see scheduler.Scalable#getRunnableStates()
	 * @see #getScalable()
	 * @generated
	 */
	EReference getScalable_RunnableStates();

	/**
	 * Returns the meta object for class '{@link scheduler.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see scheduler.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Token#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see scheduler.Token#getName()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Name();

	/**
	 * Returns the meta object for the attribute '{@link scheduler.Token#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see scheduler.Token#getAmount()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Amount();

	/**
	 * Returns the meta object for enum '{@link scheduler.PeriodicityType <em>Periodicity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Periodicity Type</em>'.
	 * @see scheduler.PeriodicityType
	 * @generated
	 */
	EEnum getPeriodicityType();

	/**
	 * Returns the meta object for enum '{@link scheduler.PriorityRankingType <em>Priority Ranking Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority Ranking Type</em>'.
	 * @see scheduler.PriorityRankingType
	 * @generated
	 */
	EEnum getPriorityRankingType();

	/**
	 * Returns the meta object for enum '{@link scheduler.LogicalRelation <em>Logical Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Relation</em>'.
	 * @see scheduler.LogicalRelation
	 * @generated
	 */
	EEnum getLogicalRelation();

	/**
	 * Returns the meta object for enum '{@link scheduler.PreemptionType <em>Preemption Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Preemption Type</em>'.
	 * @see scheduler.PreemptionType
	 * @generated
	 */
	EEnum getPreemptionType();

	/**
	 * Returns the meta object for enum '{@link scheduler.DeadlineType <em>Deadline Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Deadline Type</em>'.
	 * @see scheduler.DeadlineType
	 * @generated
	 */
	EEnum getDeadlineType();

	/**
	 * Returns the meta object for enum '{@link scheduler.ResourceAbstraction <em>Resource Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Abstraction</em>'.
	 * @see scheduler.ResourceAbstraction
	 * @generated
	 */
	EEnum getResourceAbstraction();

	/**
	 * Returns the meta object for enum '{@link scheduler.ResourceMode <em>Resource Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Mode</em>'.
	 * @see scheduler.ResourceMode
	 * @generated
	 */
	EEnum getResourceMode();

	/**
	 * Returns the meta object for enum '{@link scheduler.SchedulingType <em>Scheduling Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scheduling Type</em>'.
	 * @see scheduler.SchedulingType
	 * @generated
	 */
	EEnum getSchedulingType();

	/**
	 * Returns the meta object for enum '{@link scheduler.MigrationType <em>Migration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Migration Type</em>'.
	 * @see scheduler.MigrationType
	 * @generated
	 */
	EEnum getMigrationType();

	/**
	 * Returns the meta object for enum '{@link scheduler.PriorityAssignmentType <em>Priority Assignment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Priority Assignment Type</em>'.
	 * @see scheduler.PriorityAssignmentType
	 * @generated
	 */
	EEnum getPriorityAssignmentType();

	/**
	 * Returns the meta object for enum '{@link scheduler.ObjectiveCriteria <em>Objective Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objective Criteria</em>'.
	 * @see scheduler.ObjectiveCriteria
	 * @generated
	 */
	EEnum getObjectiveCriteria();

	/**
	 * Returns the meta object for enum '{@link scheduler.ObjectivePurpose <em>Objective Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Objective Purpose</em>'.
	 * @see scheduler.ObjectivePurpose
	 * @generated
	 */
	EEnum getObjectivePurpose();

	/**
	 * Returns the meta object for enum '{@link scheduler.SchedulingPolicyType <em>Scheduling Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scheduling Policy Type</em>'.
	 * @see scheduler.SchedulingPolicyType
	 * @generated
	 */
	EEnum getSchedulingPolicyType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulerFactory getSchedulerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link scheduler.impl.SchedulerImpl <em>Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulerImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getScheduler()
		 * @generated
		 */
		EClass SCHEDULER = eINSTANCE.getScheduler();

		/**
		 * The meta object literal for the '<em><b>Taskset</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__TASKSET = eINSTANCE.getScheduler_Taskset();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__SYSTEM = eINSTANCE.getScheduler_System();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__NAME = eINSTANCE.getScheduler_Name();

		/**
		 * The meta object literal for the '<em><b>Resource Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__RESOURCE_TYPES = eINSTANCE.getScheduler_ResourceTypes();

		/**
		 * The meta object literal for the '<em><b>Token Pool</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__TOKEN_POOL = eINSTANCE.getScheduler_TokenPool();

		/**
		 * The meta object literal for the '{@link scheduler.AbstractTask <em>Abstract Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.AbstractTask
		 * @see scheduler.impl.SchedulerPackageImpl#getAbstractTask()
		 * @generated
		 */
		EClass ABSTRACT_TASK = eINSTANCE.getAbstractTask();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__NAME = eINSTANCE.getAbstractTask_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__TYPE = eINSTANCE.getAbstractTask_Type();

		/**
		 * The meta object literal for the '<em><b>Fires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TASK__FIRES = eINSTANCE.getAbstractTask_Fires();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TaskTImpl <em>Task T</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TaskTImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getTaskT()
		 * @generated
		 */
		EClass TASK_T = eINSTANCE.getTaskT();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TaskCImpl <em>Task C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TaskCImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getTaskC()
		 * @generated
		 */
		EClass TASK_C = eINSTANCE.getTaskC();

		/**
		 * The meta object literal for the '<em><b>Sub Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_C__SUB_TASKS = eINSTANCE.getTaskC_SubTasks();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TimingImpl <em>Timing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TimingImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getTiming()
		 * @generated
		 */
		EClass TIMING = eINSTANCE.getTiming();

		/**
		 * The meta object literal for the '<em><b>Release Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING__RELEASE_TIME = eINSTANCE.getTiming_ReleaseTime();

		/**
		 * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING__EXECUTION_TIME = eINSTANCE.getTiming_ExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING__DEADLINE = eINSTANCE.getTiming_Deadline();

		/**
		 * The meta object literal for the '{@link scheduler.impl.PeriodicityImpl <em>Periodicity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.PeriodicityImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getPeriodicity()
		 * @generated
		 */
		EClass PERIODICITY = eINSTANCE.getPeriodicity();

		/**
		 * The meta object literal for the '<em><b>Period Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODICITY__PERIOD_TYPE = eINSTANCE.getPeriodicity_PeriodType();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODICITY__PERIOD = eINSTANCE.getPeriodicity_Period();

		/**
		 * The meta object literal for the '{@link scheduler.impl.PriorityImpl <em>Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.PriorityImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getPriority()
		 * @generated
		 */
		EClass PRIORITY = eINSTANCE.getPriority();

		/**
		 * The meta object literal for the '<em><b>Ranking Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY__RANKING_TYPE = eINSTANCE.getPriority_RankingType();

		/**
		 * The meta object literal for the '<em><b>Priority Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIORITY__PRIORITY_VALUE = eINSTANCE.getPriority_PriorityValue();

		/**
		 * The meta object literal for the '{@link scheduler.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.DependencyImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Dependency Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__DEPENDENCY_ITEM = eINSTANCE.getDependency_DependencyItem();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY__RELATION = eINSTANCE.getDependency_Relation();

		/**
		 * The meta object literal for the '<em><b>Mutex Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__MUTEX_ITEMS = eINSTANCE.getDependency_MutexItems();

		/**
		 * The meta object literal for the '{@link scheduler.impl.DependencyItemImpl <em>Dependency Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.DependencyItemImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getDependencyItem()
		 * @generated
		 */
		EClass DEPENDENCY_ITEM = eINSTANCE.getDependencyItem();

		/**
		 * The meta object literal for the '<em><b>Num Tokens</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_ITEM__NUM_TOKENS = eINSTANCE.getDependencyItem_NumTokens();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY_ITEM__TOKEN = eINSTANCE.getDependencyItem_Token();

		/**
		 * The meta object literal for the '<em><b>Setup Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_ITEM__SETUP_TIME = eINSTANCE.getDependencyItem_SetupTime();

		/**
		 * The meta object literal for the '{@link scheduler.impl.PreemptionImpl <em>Preemption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.PreemptionImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getPreemption()
		 * @generated
		 */
		EClass PREEMPTION = eINSTANCE.getPreemption();

		/**
		 * The meta object literal for the '<em><b>Pmtn Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREEMPTION__PMTN_TYPE = eINSTANCE.getPreemption_PmtnType();

		/**
		 * The meta object literal for the '<em><b>NInterruptable Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREEMPTION__NINTERRUPTABLE_DURATION = eINSTANCE.getPreemption_NInterruptableDuration();

		/**
		 * The meta object literal for the '{@link scheduler.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.RequirementImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '{@link scheduler.impl.DeadlineRequirementImpl <em>Deadline Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.DeadlineRequirementImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getDeadlineRequirement()
		 * @generated
		 */
		EClass DEADLINE_REQUIREMENT = eINSTANCE.getDeadlineRequirement();

		/**
		 * The meta object literal for the '<em><b>Deadline Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEADLINE_REQUIREMENT__DEADLINE_TYPE = eINSTANCE.getDeadlineRequirement_DeadlineType();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceRequirementImpl <em>Resource Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceRequirementImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceRequirement()
		 * @generated
		 */
		EClass RESOURCE_REQUIREMENT = eINSTANCE.getResourceRequirement();

		/**
		 * The meta object literal for the '<em><b>Resource Requirement Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS = eINSTANCE.getResourceRequirement_ResourceRequirementItems();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceRequirementItemImpl <em>Resource Requirement Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceRequirementItemImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceRequirementItem()
		 * @generated
		 */
		EClass RESOURCE_REQUIREMENT_ITEM = eINSTANCE.getResourceRequirementItem();

		/**
		 * The meta object literal for the '<em><b>Required Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY = eINSTANCE.getResourceRequirementItem_RequiredCapacity();

		/**
		 * The meta object literal for the '<em><b>Eligible Resource Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEM = eINSTANCE.getResourceRequirementItem_EligibleResourceItem();

		/**
		 * The meta object literal for the '<em><b>Required Resource Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE = eINSTANCE.getResourceRequirementItem_RequiredResourceType();

		/**
		 * The meta object literal for the '{@link scheduler.impl.EligibleResourceImpl <em>Eligible Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.EligibleResourceImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getEligibleResource()
		 * @generated
		 */
		EClass ELIGIBLE_RESOURCE = eINSTANCE.getEligibleResource();

		/**
		 * The meta object literal for the '<em><b>Wcet On Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELIGIBLE_RESOURCE__WCET_ON_RESOURCE = eINSTANCE.getEligibleResource_WcetOnResource();

		/**
		 * The meta object literal for the '<em><b>Eligible Resource Pointer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_POINTER = eINSTANCE.getEligibleResource_EligibleResourcePointer();

		/**
		 * The meta object literal for the '{@link scheduler.impl.MutualExclusionImpl <em>Mutual Exclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.MutualExclusionImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMutualExclusion()
		 * @generated
		 */
		EClass MUTUAL_EXCLUSION = eINSTANCE.getMutualExclusion();

		/**
		 * The meta object literal for the '<em><b>Mutex Task</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTUAL_EXCLUSION__MUTEX_TASK = eINSTANCE.getMutualExclusion_MutexTask();

		/**
		 * The meta object literal for the '{@link scheduler.AbstractResource <em>Abstract Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.AbstractResource
		 * @see scheduler.impl.SchedulerPackageImpl#getAbstractResource()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE = eINSTANCE.getAbstractResource();

		/**
		 * The meta object literal for the '<em><b>Renewable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RESOURCE__RENEWABLE = eINSTANCE.getAbstractResource_Renewable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RESOURCE__NAME = eINSTANCE.getAbstractResource_Name();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RESOURCE__CAPACITY = eINSTANCE.getAbstractResource_Capacity();

		/**
		 * The meta object literal for the '<em><b>Belongs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RESOURCE__BELONGS = eINSTANCE.getAbstractResource_Belongs();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceTImpl <em>Resource T</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceTImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceT()
		 * @generated
		 */
		EClass RESOURCE_T = eINSTANCE.getResourceT();

		/**
		 * The meta object literal for the '<em><b>Power</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_T__POWER = eINSTANCE.getResourceT_Power();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceCImpl <em>Resource C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceCImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceC()
		 * @generated
		 */
		EClass RESOURCE_C = eINSTANCE.getResourceC();

		/**
		 * The meta object literal for the '<em><b>Sub Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_C__SUB_RESOURCES = eINSTANCE.getResourceC_SubResources();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ModeImpl <em>Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ModeImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMode()
		 * @generated
		 */
		EClass MODE = eINSTANCE.getMode();

		/**
		 * The meta object literal for the '<em><b>Exclusive Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE__EXCLUSIVE_RESOURCES = eINSTANCE.getMode_ExclusiveResources();

		/**
		 * The meta object literal for the '<em><b>Resource Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE__RESOURCE_MODE = eINSTANCE.getMode_ResourceMode();

		/**
		 * The meta object literal for the '{@link scheduler.Power <em>Power</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.Power
		 * @see scheduler.impl.SchedulerPackageImpl#getPower()
		 * @generated
		 */
		EClass POWER = eINSTANCE.getPower();

		/**
		 * The meta object literal for the '<em><b>Max State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER__MAX_STATE = eINSTANCE.getPower_MaxState();

		/**
		 * The meta object literal for the '<em><b>Curr Power State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER__CURR_POWER_STATE = eINSTANCE.getPower_CurrPowerState();

		/**
		 * The meta object literal for the '{@link scheduler.impl.FixedStatePowerConsumptionImpl <em>Fixed State Power Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.FixedStatePowerConsumptionImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getFixedStatePowerConsumption()
		 * @generated
		 */
		EClass FIXED_STATE_POWER_CONSUMPTION = eINSTANCE.getFixedStatePowerConsumption();

		/**
		 * The meta object literal for the '{@link scheduler.impl.DiscreteStatePowerConsumptionImpl <em>Discrete State Power Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.DiscreteStatePowerConsumptionImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getDiscreteStatePowerConsumption()
		 * @generated
		 */
		EClass DISCRETE_STATE_POWER_CONSUMPTION = eINSTANCE.getDiscreteStatePowerConsumption();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ContinuousStatePowerConsumptionImpl <em>Continuous State Power Consumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ContinuousStatePowerConsumptionImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getContinuousStatePowerConsumption()
		 * @generated
		 */
		EClass CONTINUOUS_STATE_POWER_CONSUMPTION = eINSTANCE.getContinuousStatePowerConsumption();

		/**
		 * The meta object literal for the '<em><b>Scale Precision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION = eINSTANCE.getContinuousStatePowerConsumption_ScalePrecision();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SchedulingCharacteristicImpl <em>Scheduling Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulingCharacteristicImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingCharacteristic()
		 * @generated
		 */
		EClass SCHEDULING_CHARACTERISTIC = eINSTANCE.getSchedulingCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Sched Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_CHARACTERISTIC__SCHED_TYPE = eINSTANCE.getSchedulingCharacteristic_SchedType();

		/**
		 * The meta object literal for the '<em><b>Preemptive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_CHARACTERISTIC__PREEMPTIVE = eINSTANCE.getSchedulingCharacteristic_Preemptive();

		/**
		 * The meta object literal for the '<em><b>Migration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_CHARACTERISTIC__MIGRATION = eINSTANCE.getSchedulingCharacteristic_Migration();

		/**
		 * The meta object literal for the '<em><b>Priority Assignment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT = eINSTANCE.getSchedulingCharacteristic_PriorityAssignment();

		/**
		 * The meta object literal for the '<em><b>Objectives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_CHARACTERISTIC__OBJECTIVES = eINSTANCE.getSchedulingCharacteristic_Objectives();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ObjectiveImpl <em>Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ObjectiveImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getObjective()
		 * @generated
		 */
		EClass OBJECTIVE = eINSTANCE.getObjective();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECTIVE__PURPOSE = eINSTANCE.getObjective_Purpose();

		/**
		 * The meta object literal for the '<em><b>Criteria</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECTIVE__CRITERIA = eINSTANCE.getObjective_Criteria();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceObjectiveImpl <em>Resource Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceObjectiveImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceObjective()
		 * @generated
		 */
		EClass RESOURCE_OBJECTIVE = eINSTANCE.getResourceObjective();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TaskObjectiveImpl <em>Task Objective</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TaskObjectiveImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getTaskObjective()
		 * @generated
		 */
		EClass TASK_OBJECTIVE = eINSTANCE.getTaskObjective();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SchedulingWindowImpl <em>Scheduling Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulingWindowImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingWindow()
		 * @generated
		 */
		EClass SCHEDULING_WINDOW = eINSTANCE.getSchedulingWindow();

		/**
		 * The meta object literal for the '<em><b>Begin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_WINDOW__BEGIN = eINSTANCE.getSchedulingWindow_Begin();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_WINDOW__DURATION = eINSTANCE.getSchedulingWindow_Duration();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SchedulingPolicyImpl <em>Scheduling Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulingPolicyImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingPolicy()
		 * @generated
		 */
		EClass SCHEDULING_POLICY = eINSTANCE.getSchedulingPolicy();

		/**
		 * The meta object literal for the '<em><b>Ranking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_POLICY__RANKING = eINSTANCE.getSchedulingPolicy_Ranking();

		/**
		 * The meta object literal for the '<em><b>Grouping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_POLICY__GROUPING = eINSTANCE.getSchedulingPolicy_Grouping();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SchedulingStrategyImpl <em>Scheduling Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulingStrategyImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingStrategy()
		 * @generated
		 */
		EClass SCHEDULING_STRATEGY = eINSTANCE.getSchedulingStrategy();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SolverAdapterImpl <em>Solver Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SolverAdapterImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSolverAdapter()
		 * @generated
		 */
		EClass SOLVER_ADAPTER = eINSTANCE.getSolverAdapter();

		/**
		 * The meta object literal for the '<em><b>Solvers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_ADAPTER__SOLVERS = eINSTANCE.getSolverAdapter_Solvers();

		/**
		 * The meta object literal for the '{@link scheduler.impl.NumberJackImpl <em>Number Jack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.NumberJackImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getNumberJack()
		 * @generated
		 */
		EClass NUMBER_JACK = eINSTANCE.getNumberJack();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SCIPImpl <em>SCIP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SCIPImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSCIP()
		 * @generated
		 */
		EClass SCIP = eINSTANCE.getSCIP();

		/**
		 * The meta object literal for the '{@link scheduler.impl.MiniSatImpl <em>Mini Sat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.MiniSatImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMiniSat()
		 * @generated
		 */
		EClass MINI_SAT = eINSTANCE.getMiniSat();

		/**
		 * The meta object literal for the '{@link scheduler.impl.MipWrapperImpl <em>Mip Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.MipWrapperImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMipWrapper()
		 * @generated
		 */
		EClass MIP_WRAPPER = eINSTANCE.getMipWrapper();

		/**
		 * The meta object literal for the '{@link scheduler.impl.MistralImpl <em>Mistral</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.MistralImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMistral()
		 * @generated
		 */
		EClass MISTRAL = eINSTANCE.getMistral();

		/**
		 * The meta object literal for the '{@link scheduler.impl.Mistral2Impl <em>Mistral2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.Mistral2Impl
		 * @see scheduler.impl.SchedulerPackageImpl#getMistral2()
		 * @generated
		 */
		EClass MISTRAL2 = eINSTANCE.getMistral2();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SatWrapperImpl <em>Sat Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SatWrapperImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSatWrapper()
		 * @generated
		 */
		EClass SAT_WRAPPER = eINSTANCE.getSatWrapper();

		/**
		 * The meta object literal for the '{@link scheduler.impl.Toulbar2Impl <em>Toulbar2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.Toulbar2Impl
		 * @see scheduler.impl.SchedulerPackageImpl#getToulbar2()
		 * @generated
		 */
		EClass TOULBAR2 = eINSTANCE.getToulbar2();

		/**
		 * The meta object literal for the '{@link scheduler.impl.WalksatImpl <em>Walksat</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.WalksatImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getWalksat()
		 * @generated
		 */
		EClass WALKSAT = eINSTANCE.getWalksat();

		/**
		 * The meta object literal for the '{@link scheduler.impl.OtherImpl <em>Other</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.OtherImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getOther()
		 * @generated
		 */
		EClass OTHER = eINSTANCE.getOther();

		/**
		 * The meta object literal for the '{@link scheduler.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.OutputImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TextualImpl <em>Textual</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TextualImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getTextual()
		 * @generated
		 */
		EClass TEXTUAL = eINSTANCE.getTextual();

		/**
		 * The meta object literal for the '{@link scheduler.impl.PlotImpl <em>Plot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.PlotImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getPlot()
		 * @generated
		 */
		EClass PLOT = eINSTANCE.getPlot();

		/**
		 * The meta object literal for the '{@link scheduler.impl.MatPlotLibImpl <em>Mat Plot Lib</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.MatPlotLibImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getMatPlotLib()
		 * @generated
		 */
		EClass MAT_PLOT_LIB = eINSTANCE.getMatPlotLib();

		/**
		 * The meta object literal for the '{@link scheduler.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.ResourceTypeImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Abstraction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__ABSTRACTION = eINSTANCE.getResourceType_Abstraction();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__IDENTIFIER = eINSTANCE.getResourceType_Identifier();

		/**
		 * The meta object literal for the '<em><b>Has</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__HAS = eINSTANCE.getResourceType_Has();

		/**
		 * The meta object literal for the '{@link scheduler.impl.PowerStateImpl <em>Power State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.PowerStateImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getPowerState()
		 * @generated
		 */
		EClass POWER_STATE = eINSTANCE.getPowerState();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_STATE__SCALE = eINSTANCE.getPowerState_Scale();

		/**
		 * The meta object literal for the '<em><b>Power Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_STATE__POWER_CONSUMPTION = eINSTANCE.getPowerState_PowerConsumption();

		/**
		 * The meta object literal for the '{@link scheduler.Scalable <em>Scalable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.Scalable
		 * @see scheduler.impl.SchedulerPackageImpl#getScalable()
		 * @generated
		 */
		EClass SCALABLE = eINSTANCE.getScalable();

		/**
		 * The meta object literal for the '<em><b>Min State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALABLE__MIN_STATE = eINSTANCE.getScalable_MinState();

		/**
		 * The meta object literal for the '<em><b>Runnable States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCALABLE__RUNNABLE_STATES = eINSTANCE.getScalable_RunnableStates();

		/**
		 * The meta object literal for the '{@link scheduler.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.TokenImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__NAME = eINSTANCE.getToken_Name();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__AMOUNT = eINSTANCE.getToken_Amount();

		/**
		 * The meta object literal for the '{@link scheduler.PeriodicityType <em>Periodicity Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.PeriodicityType
		 * @see scheduler.impl.SchedulerPackageImpl#getPeriodicityType()
		 * @generated
		 */
		EEnum PERIODICITY_TYPE = eINSTANCE.getPeriodicityType();

		/**
		 * The meta object literal for the '{@link scheduler.PriorityRankingType <em>Priority Ranking Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.PriorityRankingType
		 * @see scheduler.impl.SchedulerPackageImpl#getPriorityRankingType()
		 * @generated
		 */
		EEnum PRIORITY_RANKING_TYPE = eINSTANCE.getPriorityRankingType();

		/**
		 * The meta object literal for the '{@link scheduler.LogicalRelation <em>Logical Relation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.LogicalRelation
		 * @see scheduler.impl.SchedulerPackageImpl#getLogicalRelation()
		 * @generated
		 */
		EEnum LOGICAL_RELATION = eINSTANCE.getLogicalRelation();

		/**
		 * The meta object literal for the '{@link scheduler.PreemptionType <em>Preemption Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.PreemptionType
		 * @see scheduler.impl.SchedulerPackageImpl#getPreemptionType()
		 * @generated
		 */
		EEnum PREEMPTION_TYPE = eINSTANCE.getPreemptionType();

		/**
		 * The meta object literal for the '{@link scheduler.DeadlineType <em>Deadline Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.DeadlineType
		 * @see scheduler.impl.SchedulerPackageImpl#getDeadlineType()
		 * @generated
		 */
		EEnum DEADLINE_TYPE = eINSTANCE.getDeadlineType();

		/**
		 * The meta object literal for the '{@link scheduler.ResourceAbstraction <em>Resource Abstraction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.ResourceAbstraction
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceAbstraction()
		 * @generated
		 */
		EEnum RESOURCE_ABSTRACTION = eINSTANCE.getResourceAbstraction();

		/**
		 * The meta object literal for the '{@link scheduler.ResourceMode <em>Resource Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.ResourceMode
		 * @see scheduler.impl.SchedulerPackageImpl#getResourceMode()
		 * @generated
		 */
		EEnum RESOURCE_MODE = eINSTANCE.getResourceMode();

		/**
		 * The meta object literal for the '{@link scheduler.SchedulingType <em>Scheduling Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.SchedulingType
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingType()
		 * @generated
		 */
		EEnum SCHEDULING_TYPE = eINSTANCE.getSchedulingType();

		/**
		 * The meta object literal for the '{@link scheduler.MigrationType <em>Migration Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.MigrationType
		 * @see scheduler.impl.SchedulerPackageImpl#getMigrationType()
		 * @generated
		 */
		EEnum MIGRATION_TYPE = eINSTANCE.getMigrationType();

		/**
		 * The meta object literal for the '{@link scheduler.PriorityAssignmentType <em>Priority Assignment Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.PriorityAssignmentType
		 * @see scheduler.impl.SchedulerPackageImpl#getPriorityAssignmentType()
		 * @generated
		 */
		EEnum PRIORITY_ASSIGNMENT_TYPE = eINSTANCE.getPriorityAssignmentType();

		/**
		 * The meta object literal for the '{@link scheduler.ObjectiveCriteria <em>Objective Criteria</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.ObjectiveCriteria
		 * @see scheduler.impl.SchedulerPackageImpl#getObjectiveCriteria()
		 * @generated
		 */
		EEnum OBJECTIVE_CRITERIA = eINSTANCE.getObjectiveCriteria();

		/**
		 * The meta object literal for the '{@link scheduler.ObjectivePurpose <em>Objective Purpose</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.ObjectivePurpose
		 * @see scheduler.impl.SchedulerPackageImpl#getObjectivePurpose()
		 * @generated
		 */
		EEnum OBJECTIVE_PURPOSE = eINSTANCE.getObjectivePurpose();

		/**
		 * The meta object literal for the '{@link scheduler.SchedulingPolicyType <em>Scheduling Policy Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.SchedulingPolicyType
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulingPolicyType()
		 * @generated
		 */
		EEnum SCHEDULING_POLICY_TYPE = eINSTANCE.getSchedulingPolicyType();

	}

} //SchedulerPackage
