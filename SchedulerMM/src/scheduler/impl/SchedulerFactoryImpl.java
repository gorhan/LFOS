/**
 */
package scheduler.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import scheduler.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerFactoryImpl extends EFactoryImpl implements SchedulerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulerFactory init() {
		try {
			SchedulerFactory theSchedulerFactory = (SchedulerFactory)EPackage.Registry.INSTANCE.getEFactory(SchedulerPackage.eNS_URI);
			if (theSchedulerFactory != null) {
				return theSchedulerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SchedulerPackage.SCHEDULER: return createScheduler();
			case SchedulerPackage.TASK_T: return createTaskT();
			case SchedulerPackage.TASK_C: return createTaskC();
			case SchedulerPackage.TIMING: return createTiming();
			case SchedulerPackage.PERIODICITY: return createPeriodicity();
			case SchedulerPackage.PRIORITY: return createPriority();
			case SchedulerPackage.DEPENDENCY: return createDependency();
			case SchedulerPackage.DEPENDENCY_ITEM: return createDependencyItem();
			case SchedulerPackage.PREEMPTION: return createPreemption();
			case SchedulerPackage.REQUIREMENT: return createRequirement();
			case SchedulerPackage.DEADLINE_REQUIREMENT: return createDeadlineRequirement();
			case SchedulerPackage.RESOURCE_REQUIREMENT: return createResourceRequirement();
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM: return createResourceRequirementItem();
			case SchedulerPackage.ELIGIBLE_RESOURCE: return createEligibleResource();
			case SchedulerPackage.MUTUAL_EXCLUSION: return createMutualExclusion();
			case SchedulerPackage.RESOURCE_T: return createResourceT();
			case SchedulerPackage.RESOURCE_C: return createResourceC();
			case SchedulerPackage.MODE: return createMode();
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION: return createFixedStatePowerConsumption();
			case SchedulerPackage.DISCRETE_STATE_POWER_CONSUMPTION: return createDiscreteStatePowerConsumption();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION: return createContinuousStatePowerConsumption();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC: return createSchedulingCharacteristic();
			case SchedulerPackage.OBJECTIVE: return createObjective();
			case SchedulerPackage.RESOURCE_OBJECTIVE: return createResourceObjective();
			case SchedulerPackage.TASK_OBJECTIVE: return createTaskObjective();
			case SchedulerPackage.SCHEDULING_WINDOW: return createSchedulingWindow();
			case SchedulerPackage.SCHEDULING_POLICY: return createSchedulingPolicy();
			case SchedulerPackage.SCHEDULING_STRATEGY: return createSchedulingStrategy();
			case SchedulerPackage.SOLVER_ADAPTER: return createSolverAdapter();
			case SchedulerPackage.NUMBER_JACK: return createNumberJack();
			case SchedulerPackage.SCIP: return createSCIP();
			case SchedulerPackage.MINI_SAT: return createMiniSat();
			case SchedulerPackage.MIP_WRAPPER: return createMipWrapper();
			case SchedulerPackage.MISTRAL: return createMistral();
			case SchedulerPackage.MISTRAL2: return createMistral2();
			case SchedulerPackage.SAT_WRAPPER: return createSatWrapper();
			case SchedulerPackage.TOULBAR2: return createToulbar2();
			case SchedulerPackage.WALKSAT: return createWalksat();
			case SchedulerPackage.OTHER: return createOther();
			case SchedulerPackage.OUTPUT: return createOutput();
			case SchedulerPackage.TEXTUAL: return createTextual();
			case SchedulerPackage.PLOT: return createPlot();
			case SchedulerPackage.MAT_PLOT_LIB: return createMatPlotLib();
			case SchedulerPackage.RESOURCE_TYPE: return createResourceType();
			case SchedulerPackage.POWER_STATE: return createPowerState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulerPackage.PERIODICITY_TYPE:
				return createPeriodicityTypeFromString(eDataType, initialValue);
			case SchedulerPackage.PRIORITY_RANKING_TYPE:
				return createPriorityRankingTypeFromString(eDataType, initialValue);
			case SchedulerPackage.LOGICAL_RELATION:
				return createLogicalRelationFromString(eDataType, initialValue);
			case SchedulerPackage.PREEMPTION_TYPE:
				return createPreemptionTypeFromString(eDataType, initialValue);
			case SchedulerPackage.DEADLINE_TYPE:
				return createDeadlineTypeFromString(eDataType, initialValue);
			case SchedulerPackage.RESOURCE_ABSTRACTION:
				return createResourceAbstractionFromString(eDataType, initialValue);
			case SchedulerPackage.RESOURCE_MODE:
				return createResourceModeFromString(eDataType, initialValue);
			case SchedulerPackage.SCHEDULING_TYPE:
				return createSchedulingTypeFromString(eDataType, initialValue);
			case SchedulerPackage.MIGRATION_TYPE:
				return createMigrationTypeFromString(eDataType, initialValue);
			case SchedulerPackage.PRIORITY_ASSIGNMENT_TYPE:
				return createPriorityAssignmentTypeFromString(eDataType, initialValue);
			case SchedulerPackage.OBJECTIVE_CRITERIA:
				return createObjectiveCriteriaFromString(eDataType, initialValue);
			case SchedulerPackage.OBJECTIVE_PURPOSE:
				return createObjectivePurposeFromString(eDataType, initialValue);
			case SchedulerPackage.SCHEDULING_POLICY_TYPE:
				return createSchedulingPolicyTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulerPackage.PERIODICITY_TYPE:
				return convertPeriodicityTypeToString(eDataType, instanceValue);
			case SchedulerPackage.PRIORITY_RANKING_TYPE:
				return convertPriorityRankingTypeToString(eDataType, instanceValue);
			case SchedulerPackage.LOGICAL_RELATION:
				return convertLogicalRelationToString(eDataType, instanceValue);
			case SchedulerPackage.PREEMPTION_TYPE:
				return convertPreemptionTypeToString(eDataType, instanceValue);
			case SchedulerPackage.DEADLINE_TYPE:
				return convertDeadlineTypeToString(eDataType, instanceValue);
			case SchedulerPackage.RESOURCE_ABSTRACTION:
				return convertResourceAbstractionToString(eDataType, instanceValue);
			case SchedulerPackage.RESOURCE_MODE:
				return convertResourceModeToString(eDataType, instanceValue);
			case SchedulerPackage.SCHEDULING_TYPE:
				return convertSchedulingTypeToString(eDataType, instanceValue);
			case SchedulerPackage.MIGRATION_TYPE:
				return convertMigrationTypeToString(eDataType, instanceValue);
			case SchedulerPackage.PRIORITY_ASSIGNMENT_TYPE:
				return convertPriorityAssignmentTypeToString(eDataType, instanceValue);
			case SchedulerPackage.OBJECTIVE_CRITERIA:
				return convertObjectiveCriteriaToString(eDataType, instanceValue);
			case SchedulerPackage.OBJECTIVE_PURPOSE:
				return convertObjectivePurposeToString(eDataType, instanceValue);
			case SchedulerPackage.SCHEDULING_POLICY_TYPE:
				return convertSchedulingPolicyTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduler createScheduler() {
		SchedulerImpl scheduler = new SchedulerImpl();
		return scheduler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskT createTaskT() {
		TaskTImpl taskT = new TaskTImpl();
		return taskT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskC createTaskC() {
		TaskCImpl taskC = new TaskCImpl();
		return taskC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timing createTiming() {
		TimingImpl timing = new TimingImpl();
		return timing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Periodicity createPeriodicity() {
		PeriodicityImpl periodicity = new PeriodicityImpl();
		return periodicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriority() {
		PriorityImpl priority = new PriorityImpl();
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency createDependency() {
		DependencyImpl dependency = new DependencyImpl();
		return dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyItem createDependencyItem() {
		DependencyItemImpl dependencyItem = new DependencyItemImpl();
		return dependencyItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preemption createPreemption() {
		PreemptionImpl preemption = new PreemptionImpl();
		return preemption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeadlineRequirement createDeadlineRequirement() {
		DeadlineRequirementImpl deadlineRequirement = new DeadlineRequirementImpl();
		return deadlineRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequirement createResourceRequirement() {
		ResourceRequirementImpl resourceRequirement = new ResourceRequirementImpl();
		return resourceRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequirementItem createResourceRequirementItem() {
		ResourceRequirementItemImpl resourceRequirementItem = new ResourceRequirementItemImpl();
		return resourceRequirementItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EligibleResource createEligibleResource() {
		EligibleResourceImpl eligibleResource = new EligibleResourceImpl();
		return eligibleResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutualExclusion createMutualExclusion() {
		MutualExclusionImpl mutualExclusion = new MutualExclusionImpl();
		return mutualExclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceT createResourceT() {
		ResourceTImpl resourceT = new ResourceTImpl();
		return resourceT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceC createResourceC() {
		ResourceCImpl resourceC = new ResourceCImpl();
		return resourceC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode createMode() {
		ModeImpl mode = new ModeImpl();
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedStatePowerConsumption createFixedStatePowerConsumption() {
		FixedStatePowerConsumptionImpl fixedStatePowerConsumption = new FixedStatePowerConsumptionImpl();
		return fixedStatePowerConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscreteStatePowerConsumption createDiscreteStatePowerConsumption() {
		DiscreteStatePowerConsumptionImpl discreteStatePowerConsumption = new DiscreteStatePowerConsumptionImpl();
		return discreteStatePowerConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinuousStatePowerConsumption createContinuousStatePowerConsumption() {
		ContinuousStatePowerConsumptionImpl continuousStatePowerConsumption = new ContinuousStatePowerConsumptionImpl();
		return continuousStatePowerConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingCharacteristic createSchedulingCharacteristic() {
		SchedulingCharacteristicImpl schedulingCharacteristic = new SchedulingCharacteristicImpl();
		return schedulingCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Objective createObjective() {
		ObjectiveImpl objective = new ObjectiveImpl();
		return objective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceObjective createResourceObjective() {
		ResourceObjectiveImpl resourceObjective = new ResourceObjectiveImpl();
		return resourceObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskObjective createTaskObjective() {
		TaskObjectiveImpl taskObjective = new TaskObjectiveImpl();
		return taskObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingWindow createSchedulingWindow() {
		SchedulingWindowImpl schedulingWindow = new SchedulingWindowImpl();
		return schedulingWindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicy createSchedulingPolicy() {
		SchedulingPolicyImpl schedulingPolicy = new SchedulingPolicyImpl();
		return schedulingPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingStrategy createSchedulingStrategy() {
		SchedulingStrategyImpl schedulingStrategy = new SchedulingStrategyImpl();
		return schedulingStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverAdapter createSolverAdapter() {
		SolverAdapterImpl solverAdapter = new SolverAdapterImpl();
		return solverAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberJack createNumberJack() {
		NumberJackImpl numberJack = new NumberJackImpl();
		return numberJack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCIP createSCIP() {
		SCIPImpl scip = new SCIPImpl();
		return scip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniSat createMiniSat() {
		MiniSatImpl miniSat = new MiniSatImpl();
		return miniSat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MipWrapper createMipWrapper() {
		MipWrapperImpl mipWrapper = new MipWrapperImpl();
		return mipWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mistral createMistral() {
		MistralImpl mistral = new MistralImpl();
		return mistral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mistral2 createMistral2() {
		Mistral2Impl mistral2 = new Mistral2Impl();
		return mistral2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SatWrapper createSatWrapper() {
		SatWrapperImpl satWrapper = new SatWrapperImpl();
		return satWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Toulbar2 createToulbar2() {
		Toulbar2Impl toulbar2 = new Toulbar2Impl();
		return toulbar2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Walksat createWalksat() {
		WalksatImpl walksat = new WalksatImpl();
		return walksat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Other createOther() {
		OtherImpl other = new OtherImpl();
		return other;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Textual createTextual() {
		TextualImpl textual = new TextualImpl();
		return textual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plot createPlot() {
		PlotImpl plot = new PlotImpl();
		return plot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatPlotLib createMatPlotLib() {
		MatPlotLibImpl matPlotLib = new MatPlotLibImpl();
		return matPlotLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState createPowerState() {
		PowerStateImpl powerState = new PowerStateImpl();
		return powerState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicityType createPeriodicityTypeFromString(EDataType eDataType, String initialValue) {
		PeriodicityType result = PeriodicityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPeriodicityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRankingType createPriorityRankingTypeFromString(EDataType eDataType, String initialValue) {
		PriorityRankingType result = PriorityRankingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityRankingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalRelation createLogicalRelationFromString(EDataType eDataType, String initialValue) {
		LogicalRelation result = LogicalRelation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicalRelationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreemptionType createPreemptionTypeFromString(EDataType eDataType, String initialValue) {
		PreemptionType result = PreemptionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPreemptionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeadlineType createDeadlineTypeFromString(EDataType eDataType, String initialValue) {
		DeadlineType result = DeadlineType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDeadlineTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAbstraction createResourceAbstractionFromString(EDataType eDataType, String initialValue) {
		ResourceAbstraction result = ResourceAbstraction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceAbstractionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceMode createResourceModeFromString(EDataType eDataType, String initialValue) {
		ResourceMode result = ResourceMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingType createSchedulingTypeFromString(EDataType eDataType, String initialValue) {
		SchedulingType result = SchedulingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedulingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationType createMigrationTypeFromString(EDataType eDataType, String initialValue) {
		MigrationType result = MigrationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMigrationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityAssignmentType createPriorityAssignmentTypeFromString(EDataType eDataType, String initialValue) {
		PriorityAssignmentType result = PriorityAssignmentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPriorityAssignmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectiveCriteria createObjectiveCriteriaFromString(EDataType eDataType, String initialValue) {
		ObjectiveCriteria result = ObjectiveCriteria.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectiveCriteriaToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectivePurpose createObjectivePurposeFromString(EDataType eDataType, String initialValue) {
		ObjectivePurpose result = ObjectivePurpose.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectivePurposeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicyType createSchedulingPolicyTypeFromString(EDataType eDataType, String initialValue) {
		SchedulingPolicyType result = SchedulingPolicyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSchedulingPolicyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerPackage getSchedulerPackage() {
		return (SchedulerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulerPackage getPackage() {
		return SchedulerPackage.eINSTANCE;
	}

} //SchedulerFactoryImpl
