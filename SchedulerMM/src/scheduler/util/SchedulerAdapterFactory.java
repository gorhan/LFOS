/**
 */
package scheduler.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import scheduler.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage
 * @generated
 */
public class SchedulerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SchedulerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerSwitch<Adapter> modelSwitch =
		new SchedulerSwitch<Adapter>() {
			@Override
			public Adapter caseScheduler(Scheduler object) {
				return createSchedulerAdapter();
			}
			@Override
			public Adapter caseAbstractTask(AbstractTask object) {
				return createAbstractTaskAdapter();
			}
			@Override
			public Adapter caseTaskT(TaskT object) {
				return createTaskTAdapter();
			}
			@Override
			public Adapter caseTaskC(TaskC object) {
				return createTaskCAdapter();
			}
			@Override
			public Adapter caseTiming(Timing object) {
				return createTimingAdapter();
			}
			@Override
			public Adapter casePeriodicity(Periodicity object) {
				return createPeriodicityAdapter();
			}
			@Override
			public Adapter casePriority(Priority object) {
				return createPriorityAdapter();
			}
			@Override
			public Adapter caseDependency(Dependency object) {
				return createDependencyAdapter();
			}
			@Override
			public Adapter caseDependencyItem(DependencyItem object) {
				return createDependencyItemAdapter();
			}
			@Override
			public Adapter casePreemption(Preemption object) {
				return createPreemptionAdapter();
			}
			@Override
			public Adapter caseRequirement(Requirement object) {
				return createRequirementAdapter();
			}
			@Override
			public Adapter caseDeadlineRequirement(DeadlineRequirement object) {
				return createDeadlineRequirementAdapter();
			}
			@Override
			public Adapter caseResourceRequirement(ResourceRequirement object) {
				return createResourceRequirementAdapter();
			}
			@Override
			public Adapter caseResourceRequirementItem(ResourceRequirementItem object) {
				return createResourceRequirementItemAdapter();
			}
			@Override
			public Adapter caseEligibleResource(EligibleResource object) {
				return createEligibleResourceAdapter();
			}
			@Override
			public Adapter caseMutualExclusion(MutualExclusion object) {
				return createMutualExclusionAdapter();
			}
			@Override
			public Adapter caseAbstractResource(AbstractResource object) {
				return createAbstractResourceAdapter();
			}
			@Override
			public Adapter caseResourceT(ResourceT object) {
				return createResourceTAdapter();
			}
			@Override
			public Adapter caseResourceC(ResourceC object) {
				return createResourceCAdapter();
			}
			@Override
			public Adapter caseMode(Mode object) {
				return createModeAdapter();
			}
			@Override
			public Adapter casePower(Power object) {
				return createPowerAdapter();
			}
			@Override
			public Adapter caseFixedStatePowerConsumption(FixedStatePowerConsumption object) {
				return createFixedStatePowerConsumptionAdapter();
			}
			@Override
			public Adapter caseDiscreteStatePowerConsumption(DiscreteStatePowerConsumption object) {
				return createDiscreteStatePowerConsumptionAdapter();
			}
			@Override
			public Adapter caseContinuousStatePowerConsumption(ContinuousStatePowerConsumption object) {
				return createContinuousStatePowerConsumptionAdapter();
			}
			@Override
			public Adapter caseSchedulingCharacteristic(SchedulingCharacteristic object) {
				return createSchedulingCharacteristicAdapter();
			}
			@Override
			public Adapter caseObjective(Objective object) {
				return createObjectiveAdapter();
			}
			@Override
			public Adapter caseResourceObjective(ResourceObjective object) {
				return createResourceObjectiveAdapter();
			}
			@Override
			public Adapter caseTaskObjective(TaskObjective object) {
				return createTaskObjectiveAdapter();
			}
			@Override
			public Adapter caseSchedulingWindow(SchedulingWindow object) {
				return createSchedulingWindowAdapter();
			}
			@Override
			public Adapter caseSchedulingPolicy(SchedulingPolicy object) {
				return createSchedulingPolicyAdapter();
			}
			@Override
			public Adapter caseSchedulingStrategy(SchedulingStrategy object) {
				return createSchedulingStrategyAdapter();
			}
			@Override
			public Adapter caseSolverAdapter(SolverAdapter object) {
				return createSolverAdapterAdapter();
			}
			@Override
			public Adapter caseNumberJack(NumberJack object) {
				return createNumberJackAdapter();
			}
			@Override
			public Adapter caseSCIP(SCIP object) {
				return createSCIPAdapter();
			}
			@Override
			public Adapter caseMiniSat(MiniSat object) {
				return createMiniSatAdapter();
			}
			@Override
			public Adapter caseMipWrapper(MipWrapper object) {
				return createMipWrapperAdapter();
			}
			@Override
			public Adapter caseMistral(Mistral object) {
				return createMistralAdapter();
			}
			@Override
			public Adapter caseMistral2(Mistral2 object) {
				return createMistral2Adapter();
			}
			@Override
			public Adapter caseSatWrapper(SatWrapper object) {
				return createSatWrapperAdapter();
			}
			@Override
			public Adapter caseToulbar2(Toulbar2 object) {
				return createToulbar2Adapter();
			}
			@Override
			public Adapter caseWalksat(Walksat object) {
				return createWalksatAdapter();
			}
			@Override
			public Adapter caseOther(Other object) {
				return createOtherAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseTextual(Textual object) {
				return createTextualAdapter();
			}
			@Override
			public Adapter casePlot(Plot object) {
				return createPlotAdapter();
			}
			@Override
			public Adapter caseMatPlotLib(MatPlotLib object) {
				return createMatPlotLibAdapter();
			}
			@Override
			public Adapter caseResourceType(ResourceType object) {
				return createResourceTypeAdapter();
			}
			@Override
			public Adapter casePowerState(PowerState object) {
				return createPowerStateAdapter();
			}
			@Override
			public Adapter caseScalable(Scalable object) {
				return createScalableAdapter();
			}
			@Override
			public Adapter caseToken(Token object) {
				return createTokenAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Scheduler
	 * @generated
	 */
	public Adapter createSchedulerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.AbstractTask <em>Abstract Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.AbstractTask
	 * @generated
	 */
	public Adapter createAbstractTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.TaskT <em>Task T</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.TaskT
	 * @generated
	 */
	public Adapter createTaskTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.TaskC <em>Task C</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.TaskC
	 * @generated
	 */
	public Adapter createTaskCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Timing <em>Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Timing
	 * @generated
	 */
	public Adapter createTimingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Periodicity <em>Periodicity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Periodicity
	 * @generated
	 */
	public Adapter createPeriodicityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Priority
	 * @generated
	 */
	public Adapter createPriorityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.DependencyItem <em>Dependency Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.DependencyItem
	 * @generated
	 */
	public Adapter createDependencyItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Preemption <em>Preemption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Preemption
	 * @generated
	 */
	public Adapter createPreemptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.DeadlineRequirement <em>Deadline Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.DeadlineRequirement
	 * @generated
	 */
	public Adapter createDeadlineRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceRequirement <em>Resource Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceRequirement
	 * @generated
	 */
	public Adapter createResourceRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceRequirementItem <em>Resource Requirement Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceRequirementItem
	 * @generated
	 */
	public Adapter createResourceRequirementItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.EligibleResource <em>Eligible Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.EligibleResource
	 * @generated
	 */
	public Adapter createEligibleResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.MutualExclusion <em>Mutual Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.MutualExclusion
	 * @generated
	 */
	public Adapter createMutualExclusionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.AbstractResource <em>Abstract Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.AbstractResource
	 * @generated
	 */
	public Adapter createAbstractResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceT <em>Resource T</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceT
	 * @generated
	 */
	public Adapter createResourceTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceC <em>Resource C</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceC
	 * @generated
	 */
	public Adapter createResourceCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Mode
	 * @generated
	 */
	public Adapter createModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Power <em>Power</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Power
	 * @generated
	 */
	public Adapter createPowerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.FixedStatePowerConsumption <em>Fixed State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.FixedStatePowerConsumption
	 * @generated
	 */
	public Adapter createFixedStatePowerConsumptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.DiscreteStatePowerConsumption <em>Discrete State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.DiscreteStatePowerConsumption
	 * @generated
	 */
	public Adapter createDiscreteStatePowerConsumptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ContinuousStatePowerConsumption <em>Continuous State Power Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ContinuousStatePowerConsumption
	 * @generated
	 */
	public Adapter createContinuousStatePowerConsumptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SchedulingCharacteristic <em>Scheduling Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SchedulingCharacteristic
	 * @generated
	 */
	public Adapter createSchedulingCharacteristicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Objective
	 * @generated
	 */
	public Adapter createObjectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceObjective <em>Resource Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceObjective
	 * @generated
	 */
	public Adapter createResourceObjectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.TaskObjective <em>Task Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.TaskObjective
	 * @generated
	 */
	public Adapter createTaskObjectiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SchedulingWindow <em>Scheduling Window</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SchedulingWindow
	 * @generated
	 */
	public Adapter createSchedulingWindowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SchedulingPolicy <em>Scheduling Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SchedulingPolicy
	 * @generated
	 */
	public Adapter createSchedulingPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SchedulingStrategy <em>Scheduling Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SchedulingStrategy
	 * @generated
	 */
	public Adapter createSchedulingStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SolverAdapter <em>Solver Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SolverAdapter
	 * @generated
	 */
	public Adapter createSolverAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.NumberJack <em>Number Jack</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.NumberJack
	 * @generated
	 */
	public Adapter createNumberJackAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SCIP <em>SCIP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SCIP
	 * @generated
	 */
	public Adapter createSCIPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.MiniSat <em>Mini Sat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.MiniSat
	 * @generated
	 */
	public Adapter createMiniSatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.MipWrapper <em>Mip Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.MipWrapper
	 * @generated
	 */
	public Adapter createMipWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Mistral <em>Mistral</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Mistral
	 * @generated
	 */
	public Adapter createMistralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Mistral2 <em>Mistral2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Mistral2
	 * @generated
	 */
	public Adapter createMistral2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.SatWrapper <em>Sat Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.SatWrapper
	 * @generated
	 */
	public Adapter createSatWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Toulbar2 <em>Toulbar2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Toulbar2
	 * @generated
	 */
	public Adapter createToulbar2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Walksat <em>Walksat</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Walksat
	 * @generated
	 */
	public Adapter createWalksatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Other <em>Other</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Other
	 * @generated
	 */
	public Adapter createOtherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Textual <em>Textual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Textual
	 * @generated
	 */
	public Adapter createTextualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Plot <em>Plot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Plot
	 * @generated
	 */
	public Adapter createPlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.MatPlotLib <em>Mat Plot Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.MatPlotLib
	 * @generated
	 */
	public Adapter createMatPlotLibAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.ResourceType
	 * @generated
	 */
	public Adapter createResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.PowerState <em>Power State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.PowerState
	 * @generated
	 */
	public Adapter createPowerStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Scalable <em>Scalable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Scalable
	 * @generated
	 */
	public Adapter createScalableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link scheduler.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see scheduler.Token
	 * @generated
	 */
	public Adapter createTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SchedulerAdapterFactory
