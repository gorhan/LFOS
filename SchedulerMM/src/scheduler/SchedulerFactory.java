/**
 */
package scheduler;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage
 * @generated
 */
public interface SchedulerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulerFactory eINSTANCE = scheduler.impl.SchedulerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler</em>'.
	 * @generated
	 */
	Scheduler createScheduler();

	/**
	 * Returns a new object of class '<em>Task T</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task T</em>'.
	 * @generated
	 */
	TaskT createTaskT();

	/**
	 * Returns a new object of class '<em>Task C</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task C</em>'.
	 * @generated
	 */
	TaskC createTaskC();

	/**
	 * Returns a new object of class '<em>Timing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timing</em>'.
	 * @generated
	 */
	Timing createTiming();

	/**
	 * Returns a new object of class '<em>Periodicity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Periodicity</em>'.
	 * @generated
	 */
	Periodicity createPeriodicity();

	/**
	 * Returns a new object of class '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority</em>'.
	 * @generated
	 */
	Priority createPriority();

	/**
	 * Returns a new object of class '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency</em>'.
	 * @generated
	 */
	Dependency createDependency();

	/**
	 * Returns a new object of class '<em>Dependency Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Item</em>'.
	 * @generated
	 */
	DependencyItem createDependencyItem();

	/**
	 * Returns a new object of class '<em>Preemption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preemption</em>'.
	 * @generated
	 */
	Preemption createPreemption();

	/**
	 * Returns a new object of class '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement</em>'.
	 * @generated
	 */
	Requirement createRequirement();

	/**
	 * Returns a new object of class '<em>Deadline Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deadline Requirement</em>'.
	 * @generated
	 */
	DeadlineRequirement createDeadlineRequirement();

	/**
	 * Returns a new object of class '<em>Resource Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Requirement</em>'.
	 * @generated
	 */
	ResourceRequirement createResourceRequirement();

	/**
	 * Returns a new object of class '<em>Resource Requirement Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Requirement Item</em>'.
	 * @generated
	 */
	ResourceRequirementItem createResourceRequirementItem();

	/**
	 * Returns a new object of class '<em>Eligible Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eligible Resource</em>'.
	 * @generated
	 */
	EligibleResource createEligibleResource();

	/**
	 * Returns a new object of class '<em>Mutual Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutual Exclusion</em>'.
	 * @generated
	 */
	MutualExclusion createMutualExclusion();

	/**
	 * Returns a new object of class '<em>Resource T</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource T</em>'.
	 * @generated
	 */
	ResourceT createResourceT();

	/**
	 * Returns a new object of class '<em>Resource C</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource C</em>'.
	 * @generated
	 */
	ResourceC createResourceC();

	/**
	 * Returns a new object of class '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode</em>'.
	 * @generated
	 */
	Mode createMode();

	/**
	 * Returns a new object of class '<em>Fixed State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed State Power Consumption</em>'.
	 * @generated
	 */
	FixedStatePowerConsumption createFixedStatePowerConsumption();

	/**
	 * Returns a new object of class '<em>Discrete State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discrete State Power Consumption</em>'.
	 * @generated
	 */
	DiscreteStatePowerConsumption createDiscreteStatePowerConsumption();

	/**
	 * Returns a new object of class '<em>Continuous State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuous State Power Consumption</em>'.
	 * @generated
	 */
	ContinuousStatePowerConsumption createContinuousStatePowerConsumption();

	/**
	 * Returns a new object of class '<em>Scheduling Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Characteristic</em>'.
	 * @generated
	 */
	SchedulingCharacteristic createSchedulingCharacteristic();

	/**
	 * Returns a new object of class '<em>Objective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Objective</em>'.
	 * @generated
	 */
	Objective createObjective();

	/**
	 * Returns a new object of class '<em>Resource Objective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Objective</em>'.
	 * @generated
	 */
	ResourceObjective createResourceObjective();

	/**
	 * Returns a new object of class '<em>Task Objective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Objective</em>'.
	 * @generated
	 */
	TaskObjective createTaskObjective();

	/**
	 * Returns a new object of class '<em>Scheduling Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Window</em>'.
	 * @generated
	 */
	SchedulingWindow createSchedulingWindow();

	/**
	 * Returns a new object of class '<em>Scheduling Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Policy</em>'.
	 * @generated
	 */
	SchedulingPolicy createSchedulingPolicy();

	/**
	 * Returns a new object of class '<em>Scheduling Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Strategy</em>'.
	 * @generated
	 */
	SchedulingStrategy createSchedulingStrategy();

	/**
	 * Returns a new object of class '<em>Solver Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Adapter</em>'.
	 * @generated
	 */
	SolverAdapter createSolverAdapter();

	/**
	 * Returns a new object of class '<em>Number Jack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Jack</em>'.
	 * @generated
	 */
	NumberJack createNumberJack();

	/**
	 * Returns a new object of class '<em>SCIP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCIP</em>'.
	 * @generated
	 */
	SCIP createSCIP();

	/**
	 * Returns a new object of class '<em>Mini Sat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mini Sat</em>'.
	 * @generated
	 */
	MiniSat createMiniSat();

	/**
	 * Returns a new object of class '<em>Mip Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mip Wrapper</em>'.
	 * @generated
	 */
	MipWrapper createMipWrapper();

	/**
	 * Returns a new object of class '<em>Mistral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mistral</em>'.
	 * @generated
	 */
	Mistral createMistral();

	/**
	 * Returns a new object of class '<em>Mistral2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mistral2</em>'.
	 * @generated
	 */
	Mistral2 createMistral2();

	/**
	 * Returns a new object of class '<em>Sat Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sat Wrapper</em>'.
	 * @generated
	 */
	SatWrapper createSatWrapper();

	/**
	 * Returns a new object of class '<em>Toulbar2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Toulbar2</em>'.
	 * @generated
	 */
	Toulbar2 createToulbar2();

	/**
	 * Returns a new object of class '<em>Walksat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Walksat</em>'.
	 * @generated
	 */
	Walksat createWalksat();

	/**
	 * Returns a new object of class '<em>Other</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other</em>'.
	 * @generated
	 */
	Other createOther();

	/**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
	Output createOutput();

	/**
	 * Returns a new object of class '<em>Textual</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Textual</em>'.
	 * @generated
	 */
	Textual createTextual();

	/**
	 * Returns a new object of class '<em>Plot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plot</em>'.
	 * @generated
	 */
	Plot createPlot();

	/**
	 * Returns a new object of class '<em>Mat Plot Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mat Plot Lib</em>'.
	 * @generated
	 */
	MatPlotLib createMatPlotLib();

	/**
	 * Returns a new object of class '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type</em>'.
	 * @generated
	 */
	ResourceType createResourceType();

	/**
	 * Returns a new object of class '<em>Power State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power State</em>'.
	 * @generated
	 */
	PowerState createPowerState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulerPackage getSchedulerPackage();

} //SchedulerFactory
