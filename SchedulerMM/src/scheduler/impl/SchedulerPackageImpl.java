/**
 */
package scheduler.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import scheduler.AbstractResource;
import scheduler.AbstractTask;
import scheduler.ContinuousStatePowerConsumption;
import scheduler.DeadlineRequirement;
import scheduler.DeadlineType;
import scheduler.Dependency;
import scheduler.DependencyItem;
import scheduler.DiscreteStatePowerConsumption;
import scheduler.EligibleResource;
import scheduler.FixedStatePowerConsumption;
import scheduler.LogicalRelation;
import scheduler.MatPlotLib;
import scheduler.MigrationType;
import scheduler.MiniSat;
import scheduler.MipWrapper;
import scheduler.Mistral;
import scheduler.Mistral2;
import scheduler.Mode;
import scheduler.MutualExclusion;
import scheduler.NumberJack;
import scheduler.Objective;
import scheduler.ObjectiveCriteria;
import scheduler.ObjectivePurpose;
import scheduler.Other;
import scheduler.Output;
import scheduler.Periodicity;
import scheduler.PeriodicityType;
import scheduler.Plot;
import scheduler.Power;
import scheduler.PowerState;
import scheduler.Preemption;
import scheduler.PreemptionType;
import scheduler.Priority;
import scheduler.PriorityAssignmentType;
import scheduler.PriorityRankingType;
import scheduler.Requirement;
import scheduler.ResourceAbstraction;
import scheduler.ResourceC;
import scheduler.ResourceMode;
import scheduler.ResourceObjective;
import scheduler.ResourceRequirement;
import scheduler.ResourceRequirementItem;
import scheduler.ResourceT;
import scheduler.ResourceType;
import scheduler.SatWrapper;
import scheduler.Scalable;
import scheduler.Scheduler;
import scheduler.SchedulerFactory;
import scheduler.SchedulerPackage;
import scheduler.SchedulingCharacteristic;
import scheduler.SchedulingPolicy;
import scheduler.SchedulingPolicyType;
import scheduler.SchedulingStrategy;
import scheduler.SchedulingType;
import scheduler.SchedulingWindow;
import scheduler.SolverAdapter;
import scheduler.TaskC;
import scheduler.TaskObjective;
import scheduler.TaskT;
import scheduler.Textual;
import scheduler.Timing;
import scheduler.Token;
import scheduler.Toulbar2;
import scheduler.Walksat;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerPackageImpl extends EPackageImpl implements SchedulerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskCEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass periodicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass priorityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preemptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deadlineRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceRequirementItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eligibleResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutualExclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceCEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedStatePowerConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discreteStatePowerConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousStatePowerConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingCharacteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceObjectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskObjectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingWindowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverAdapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberJackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass miniSatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mipWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mistralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mistral2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass satWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toulbar2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass walksatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matPlotLibEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum periodicityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityRankingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicalRelationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum preemptionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum deadlineTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceAbstractionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum schedulingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum migrationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum priorityAssignmentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum objectiveCriteriaEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum objectivePurposeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum schedulingPolicyTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see scheduler.SchedulerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulerPackageImpl() {
		super(eNS_URI, SchedulerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SchedulerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulerPackage init() {
		if (isInited) return (SchedulerPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI);

		// Obtain or create and register package
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSchedulerPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulerPackage.eNS_URI, theSchedulerPackage);
		return theSchedulerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduler() {
		return schedulerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_Taskset() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_System() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduler_Name() {
		return (EAttribute)schedulerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_ResourceTypes() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduler_TokenPool() {
		return (EReference)schedulerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTask() {
		return abstractTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTask_Name() {
		return (EAttribute)abstractTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractTask_Type() {
		return (EAttribute)abstractTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractTask_Fires() {
		return (EReference)abstractTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskT() {
		return taskTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskC() {
		return taskCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskC_SubTasks() {
		return (EReference)taskCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTiming() {
		return timingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTiming_ReleaseTime() {
		return (EAttribute)timingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTiming_ExecutionTime() {
		return (EAttribute)timingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTiming_Deadline() {
		return (EAttribute)timingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeriodicity() {
		return periodicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeriodicity_PeriodType() {
		return (EAttribute)periodicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeriodicity_Period() {
		return (EAttribute)periodicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriority() {
		return priorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_RankingType() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_PriorityValue() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_DependencyItem() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependency_Relation() {
		return (EAttribute)dependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_MutexItems() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyItem() {
		return dependencyItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyItem_NumTokens() {
		return (EAttribute)dependencyItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyItem_Token() {
		return (EReference)dependencyItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyItem_SetupTime() {
		return (EAttribute)dependencyItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreemption() {
		return preemptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreemption_PmtnType() {
		return (EAttribute)preemptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreemption_NInterruptableDuration() {
		return (EAttribute)preemptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeadlineRequirement() {
		return deadlineRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeadlineRequirement_DeadlineType() {
		return (EAttribute)deadlineRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceRequirement() {
		return resourceRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequirement_ResourceRequirementItems() {
		return (EReference)resourceRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceRequirementItem() {
		return resourceRequirementItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceRequirementItem_RequiredCapacity() {
		return (EAttribute)resourceRequirementItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequirementItem_EligibleResourceItem() {
		return (EReference)resourceRequirementItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRequirementItem_RequiredResourceType() {
		return (EReference)resourceRequirementItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEligibleResource() {
		return eligibleResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEligibleResource_WcetOnResource() {
		return (EAttribute)eligibleResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEligibleResource_EligibleResourcePointer() {
		return (EReference)eligibleResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutualExclusion() {
		return mutualExclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutualExclusion_MutexTask() {
		return (EReference)mutualExclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractResource() {
		return abstractResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractResource_Renewable() {
		return (EAttribute)abstractResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractResource_Name() {
		return (EAttribute)abstractResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractResource_Capacity() {
		return (EAttribute)abstractResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractResource_Belongs() {
		return (EReference)abstractResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceT() {
		return resourceTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceT_Power() {
		return (EReference)resourceTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceC() {
		return resourceCEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceC_SubResources() {
		return (EReference)resourceCEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMode() {
		return modeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMode_ExclusiveResources() {
		return (EReference)modeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMode_ResourceMode() {
		return (EAttribute)modeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPower() {
		return powerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPower_MaxState() {
		return (EReference)powerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPower_CurrPowerState() {
		return (EReference)powerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedStatePowerConsumption() {
		return fixedStatePowerConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscreteStatePowerConsumption() {
		return discreteStatePowerConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousStatePowerConsumption() {
		return continuousStatePowerConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContinuousStatePowerConsumption_ScalePrecision() {
		return (EAttribute)continuousStatePowerConsumptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingCharacteristic() {
		return schedulingCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingCharacteristic_SchedType() {
		return (EAttribute)schedulingCharacteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingCharacteristic_Preemptive() {
		return (EAttribute)schedulingCharacteristicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingCharacteristic_Migration() {
		return (EAttribute)schedulingCharacteristicEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingCharacteristic_PriorityAssignment() {
		return (EAttribute)schedulingCharacteristicEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingCharacteristic_Objectives() {
		return (EReference)schedulingCharacteristicEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjective() {
		return objectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjective_Purpose() {
		return (EAttribute)objectiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjective_Criteria() {
		return (EAttribute)objectiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceObjective() {
		return resourceObjectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskObjective() {
		return taskObjectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingWindow() {
		return schedulingWindowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingWindow_Begin() {
		return (EAttribute)schedulingWindowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingWindow_Duration() {
		return (EAttribute)schedulingWindowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingPolicy() {
		return schedulingPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingPolicy_Ranking() {
		return (EAttribute)schedulingPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingPolicy_Grouping() {
		return (EAttribute)schedulingPolicyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingStrategy() {
		return schedulingStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverAdapter() {
		return solverAdapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverAdapter_Solvers() {
		return (EReference)solverAdapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberJack() {
		return numberJackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCIP() {
		return scipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMiniSat() {
		return miniSatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMipWrapper() {
		return mipWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMistral() {
		return mistralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMistral2() {
		return mistral2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSatWrapper() {
		return satWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToulbar2() {
		return toulbar2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWalksat() {
		return walksatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOther() {
		return otherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextual() {
		return textualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlot() {
		return plotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatPlotLib() {
		return matPlotLibEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceType() {
		return resourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Abstraction() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Identifier() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Has() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerState() {
		return powerStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerState_Scale() {
		return (EAttribute)powerStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerState_PowerConsumption() {
		return (EAttribute)powerStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalable() {
		return scalableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalable_MinState() {
		return (EReference)scalableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalable_RunnableStates() {
		return (EReference)scalableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToken() {
		return tokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Name() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Amount() {
		return (EAttribute)tokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPeriodicityType() {
		return periodicityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriorityRankingType() {
		return priorityRankingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicalRelation() {
		return logicalRelationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPreemptionType() {
		return preemptionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDeadlineType() {
		return deadlineTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceAbstraction() {
		return resourceAbstractionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceMode() {
		return resourceModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSchedulingType() {
		return schedulingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMigrationType() {
		return migrationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPriorityAssignmentType() {
		return priorityAssignmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectiveCriteria() {
		return objectiveCriteriaEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectivePurpose() {
		return objectivePurposeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSchedulingPolicyType() {
		return schedulingPolicyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactory getSchedulerFactory() {
		return (SchedulerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		schedulerEClass = createEClass(SCHEDULER);
		createEReference(schedulerEClass, SCHEDULER__TASKSET);
		createEReference(schedulerEClass, SCHEDULER__SYSTEM);
		createEAttribute(schedulerEClass, SCHEDULER__NAME);
		createEReference(schedulerEClass, SCHEDULER__RESOURCE_TYPES);
		createEReference(schedulerEClass, SCHEDULER__TOKEN_POOL);

		abstractTaskEClass = createEClass(ABSTRACT_TASK);
		createEAttribute(abstractTaskEClass, ABSTRACT_TASK__NAME);
		createEAttribute(abstractTaskEClass, ABSTRACT_TASK__TYPE);
		createEReference(abstractTaskEClass, ABSTRACT_TASK__FIRES);

		taskTEClass = createEClass(TASK_T);

		taskCEClass = createEClass(TASK_C);
		createEReference(taskCEClass, TASK_C__SUB_TASKS);

		timingEClass = createEClass(TIMING);
		createEAttribute(timingEClass, TIMING__RELEASE_TIME);
		createEAttribute(timingEClass, TIMING__EXECUTION_TIME);
		createEAttribute(timingEClass, TIMING__DEADLINE);

		periodicityEClass = createEClass(PERIODICITY);
		createEAttribute(periodicityEClass, PERIODICITY__PERIOD_TYPE);
		createEAttribute(periodicityEClass, PERIODICITY__PERIOD);

		priorityEClass = createEClass(PRIORITY);
		createEAttribute(priorityEClass, PRIORITY__RANKING_TYPE);
		createEAttribute(priorityEClass, PRIORITY__PRIORITY_VALUE);

		dependencyEClass = createEClass(DEPENDENCY);
		createEReference(dependencyEClass, DEPENDENCY__DEPENDENCY_ITEM);
		createEAttribute(dependencyEClass, DEPENDENCY__RELATION);
		createEReference(dependencyEClass, DEPENDENCY__MUTEX_ITEMS);

		dependencyItemEClass = createEClass(DEPENDENCY_ITEM);
		createEAttribute(dependencyItemEClass, DEPENDENCY_ITEM__NUM_TOKENS);
		createEAttribute(dependencyItemEClass, DEPENDENCY_ITEM__SETUP_TIME);
		createEReference(dependencyItemEClass, DEPENDENCY_ITEM__TOKEN);

		preemptionEClass = createEClass(PREEMPTION);
		createEAttribute(preemptionEClass, PREEMPTION__PMTN_TYPE);
		createEAttribute(preemptionEClass, PREEMPTION__NINTERRUPTABLE_DURATION);

		requirementEClass = createEClass(REQUIREMENT);

		deadlineRequirementEClass = createEClass(DEADLINE_REQUIREMENT);
		createEAttribute(deadlineRequirementEClass, DEADLINE_REQUIREMENT__DEADLINE_TYPE);

		resourceRequirementEClass = createEClass(RESOURCE_REQUIREMENT);
		createEReference(resourceRequirementEClass, RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS);

		resourceRequirementItemEClass = createEClass(RESOURCE_REQUIREMENT_ITEM);
		createEAttribute(resourceRequirementItemEClass, RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY);
		createEReference(resourceRequirementItemEClass, RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEM);
		createEReference(resourceRequirementItemEClass, RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE);

		eligibleResourceEClass = createEClass(ELIGIBLE_RESOURCE);
		createEAttribute(eligibleResourceEClass, ELIGIBLE_RESOURCE__WCET_ON_RESOURCE);
		createEReference(eligibleResourceEClass, ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_POINTER);

		mutualExclusionEClass = createEClass(MUTUAL_EXCLUSION);
		createEReference(mutualExclusionEClass, MUTUAL_EXCLUSION__MUTEX_TASK);

		abstractResourceEClass = createEClass(ABSTRACT_RESOURCE);
		createEAttribute(abstractResourceEClass, ABSTRACT_RESOURCE__RENEWABLE);
		createEAttribute(abstractResourceEClass, ABSTRACT_RESOURCE__NAME);
		createEAttribute(abstractResourceEClass, ABSTRACT_RESOURCE__CAPACITY);
		createEReference(abstractResourceEClass, ABSTRACT_RESOURCE__BELONGS);

		resourceTEClass = createEClass(RESOURCE_T);
		createEReference(resourceTEClass, RESOURCE_T__POWER);

		resourceCEClass = createEClass(RESOURCE_C);
		createEReference(resourceCEClass, RESOURCE_C__SUB_RESOURCES);

		modeEClass = createEClass(MODE);
		createEReference(modeEClass, MODE__EXCLUSIVE_RESOURCES);
		createEAttribute(modeEClass, MODE__RESOURCE_MODE);

		powerEClass = createEClass(POWER);
		createEReference(powerEClass, POWER__MAX_STATE);
		createEReference(powerEClass, POWER__CURR_POWER_STATE);

		fixedStatePowerConsumptionEClass = createEClass(FIXED_STATE_POWER_CONSUMPTION);

		discreteStatePowerConsumptionEClass = createEClass(DISCRETE_STATE_POWER_CONSUMPTION);

		continuousStatePowerConsumptionEClass = createEClass(CONTINUOUS_STATE_POWER_CONSUMPTION);
		createEAttribute(continuousStatePowerConsumptionEClass, CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION);

		schedulingCharacteristicEClass = createEClass(SCHEDULING_CHARACTERISTIC);
		createEAttribute(schedulingCharacteristicEClass, SCHEDULING_CHARACTERISTIC__SCHED_TYPE);
		createEAttribute(schedulingCharacteristicEClass, SCHEDULING_CHARACTERISTIC__PREEMPTIVE);
		createEAttribute(schedulingCharacteristicEClass, SCHEDULING_CHARACTERISTIC__MIGRATION);
		createEAttribute(schedulingCharacteristicEClass, SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT);
		createEReference(schedulingCharacteristicEClass, SCHEDULING_CHARACTERISTIC__OBJECTIVES);

		objectiveEClass = createEClass(OBJECTIVE);
		createEAttribute(objectiveEClass, OBJECTIVE__PURPOSE);
		createEAttribute(objectiveEClass, OBJECTIVE__CRITERIA);

		resourceObjectiveEClass = createEClass(RESOURCE_OBJECTIVE);

		taskObjectiveEClass = createEClass(TASK_OBJECTIVE);

		schedulingWindowEClass = createEClass(SCHEDULING_WINDOW);
		createEAttribute(schedulingWindowEClass, SCHEDULING_WINDOW__BEGIN);
		createEAttribute(schedulingWindowEClass, SCHEDULING_WINDOW__DURATION);

		schedulingPolicyEClass = createEClass(SCHEDULING_POLICY);
		createEAttribute(schedulingPolicyEClass, SCHEDULING_POLICY__RANKING);
		createEAttribute(schedulingPolicyEClass, SCHEDULING_POLICY__GROUPING);

		schedulingStrategyEClass = createEClass(SCHEDULING_STRATEGY);

		solverAdapterEClass = createEClass(SOLVER_ADAPTER);
		createEReference(solverAdapterEClass, SOLVER_ADAPTER__SOLVERS);

		numberJackEClass = createEClass(NUMBER_JACK);

		scipEClass = createEClass(SCIP);

		miniSatEClass = createEClass(MINI_SAT);

		mipWrapperEClass = createEClass(MIP_WRAPPER);

		mistralEClass = createEClass(MISTRAL);

		mistral2EClass = createEClass(MISTRAL2);

		satWrapperEClass = createEClass(SAT_WRAPPER);

		toulbar2EClass = createEClass(TOULBAR2);

		walksatEClass = createEClass(WALKSAT);

		otherEClass = createEClass(OTHER);

		outputEClass = createEClass(OUTPUT);

		textualEClass = createEClass(TEXTUAL);

		plotEClass = createEClass(PLOT);

		matPlotLibEClass = createEClass(MAT_PLOT_LIB);

		resourceTypeEClass = createEClass(RESOURCE_TYPE);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__HAS);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__IDENTIFIER);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__ABSTRACTION);

		powerStateEClass = createEClass(POWER_STATE);
		createEAttribute(powerStateEClass, POWER_STATE__SCALE);
		createEAttribute(powerStateEClass, POWER_STATE__POWER_CONSUMPTION);

		scalableEClass = createEClass(SCALABLE);
		createEReference(scalableEClass, SCALABLE__MIN_STATE);
		createEReference(scalableEClass, SCALABLE__RUNNABLE_STATES);

		tokenEClass = createEClass(TOKEN);
		createEAttribute(tokenEClass, TOKEN__NAME);
		createEAttribute(tokenEClass, TOKEN__AMOUNT);

		// Create enums
		periodicityTypeEEnum = createEEnum(PERIODICITY_TYPE);
		priorityRankingTypeEEnum = createEEnum(PRIORITY_RANKING_TYPE);
		logicalRelationEEnum = createEEnum(LOGICAL_RELATION);
		preemptionTypeEEnum = createEEnum(PREEMPTION_TYPE);
		deadlineTypeEEnum = createEEnum(DEADLINE_TYPE);
		resourceAbstractionEEnum = createEEnum(RESOURCE_ABSTRACTION);
		resourceModeEEnum = createEEnum(RESOURCE_MODE);
		schedulingTypeEEnum = createEEnum(SCHEDULING_TYPE);
		migrationTypeEEnum = createEEnum(MIGRATION_TYPE);
		priorityAssignmentTypeEEnum = createEEnum(PRIORITY_ASSIGNMENT_TYPE);
		objectiveCriteriaEEnum = createEEnum(OBJECTIVE_CRITERIA);
		objectivePurposeEEnum = createEEnum(OBJECTIVE_PURPOSE);
		schedulingPolicyTypeEEnum = createEEnum(SCHEDULING_POLICY_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		schedulerEClass.getESuperTypes().add(this.getSchedulingCharacteristic());
		schedulerEClass.getESuperTypes().add(this.getSchedulingStrategy());
		abstractTaskEClass.getESuperTypes().add(this.getTiming());
		abstractTaskEClass.getESuperTypes().add(this.getPriority());
		abstractTaskEClass.getESuperTypes().add(this.getDependency());
		abstractTaskEClass.getESuperTypes().add(this.getPreemption());
		abstractTaskEClass.getESuperTypes().add(this.getRequirement());
		taskTEClass.getESuperTypes().add(this.getAbstractTask());
		taskCEClass.getESuperTypes().add(this.getAbstractTask());
		timingEClass.getESuperTypes().add(this.getPeriodicity());
		requirementEClass.getESuperTypes().add(this.getDeadlineRequirement());
		requirementEClass.getESuperTypes().add(this.getResourceRequirement());
		abstractResourceEClass.getESuperTypes().add(this.getMode());
		resourceTEClass.getESuperTypes().add(this.getAbstractResource());
		resourceCEClass.getESuperTypes().add(this.getAbstractResource());
		fixedStatePowerConsumptionEClass.getESuperTypes().add(this.getPower());
		discreteStatePowerConsumptionEClass.getESuperTypes().add(this.getScalable());
		continuousStatePowerConsumptionEClass.getESuperTypes().add(this.getScalable());
		schedulingCharacteristicEClass.getESuperTypes().add(this.getSchedulingWindow());
		schedulingCharacteristicEClass.getESuperTypes().add(this.getSchedulingPolicy());
		resourceObjectiveEClass.getESuperTypes().add(this.getObjective());
		taskObjectiveEClass.getESuperTypes().add(this.getObjective());
		schedulingStrategyEClass.getESuperTypes().add(this.getSolverAdapter());
		schedulingStrategyEClass.getESuperTypes().add(this.getOutput());
		scipEClass.getESuperTypes().add(this.getNumberJack());
		miniSatEClass.getESuperTypes().add(this.getNumberJack());
		mipWrapperEClass.getESuperTypes().add(this.getNumberJack());
		mistralEClass.getESuperTypes().add(this.getNumberJack());
		mistral2EClass.getESuperTypes().add(this.getNumberJack());
		satWrapperEClass.getESuperTypes().add(this.getNumberJack());
		toulbar2EClass.getESuperTypes().add(this.getNumberJack());
		walksatEClass.getESuperTypes().add(this.getNumberJack());
		otherEClass.getESuperTypes().add(this.getNumberJack());
		textualEClass.getESuperTypes().add(this.getOutput());
		plotEClass.getESuperTypes().add(this.getOutput());
		plotEClass.getESuperTypes().add(this.getMatPlotLib());
		scalableEClass.getESuperTypes().add(this.getPower());

		// Initialize classes, features, and operations; add parameters
		initEClass(schedulerEClass, Scheduler.class, "Scheduler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduler_Taskset(), this.getAbstractTask(), null, "taskset", null, 1, -1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduler_System(), this.getResourceC(), null, "System", null, 1, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduler_Name(), ecorePackage.getEString(), "name", null, 0, 1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduler_ResourceTypes(), this.getResourceType(), null, "resourceTypes", null, 1, -1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScheduler_TokenPool(), this.getToken(), null, "tokenPool", null, 0, -1, Scheduler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTaskEClass, AbstractTask.class, "AbstractTask", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractTask_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractTask_Type(), ecorePackage.getEString(), "type", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractTask_Fires(), this.getToken(), null, "fires", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskTEClass, TaskT.class, "TaskT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taskCEClass, TaskC.class, "TaskC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskC_SubTasks(), this.getAbstractTask(), null, "subTasks", null, 1, -1, TaskC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timingEClass, Timing.class, "Timing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTiming_ReleaseTime(), ecorePackage.getEInt(), "releaseTime", null, 0, 1, Timing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTiming_ExecutionTime(), ecorePackage.getEInt(), "executionTime", null, 1, 1, Timing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTiming_Deadline(), ecorePackage.getEInt(), "deadline", null, 0, 1, Timing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(periodicityEClass, Periodicity.class, "Periodicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPeriodicity_PeriodType(), this.getPeriodicityType(), "periodType", null, 1, 1, Periodicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeriodicity_Period(), ecorePackage.getEInt(), "period", null, 0, 1, Periodicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(priorityEClass, Priority.class, "Priority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPriority_RankingType(), this.getPriorityRankingType(), "rankingType", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPriority_PriorityValue(), ecorePackage.getEInt(), "priorityValue", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependency_DependencyItem(), this.getDependencyItem(), null, "dependencyItem", null, 0, -1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependency_Relation(), this.getLogicalRelation(), "relation", null, 0, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_MutexItems(), this.getMutualExclusion(), null, "mutexItems", null, 0, -1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyItemEClass, DependencyItem.class, "DependencyItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependencyItem_NumTokens(), ecorePackage.getEInt(), "numTokens", null, 0, 1, DependencyItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyItem_SetupTime(), ecorePackage.getEInt(), "setupTime", null, 0, 1, DependencyItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyItem_Token(), this.getToken(), null, "token", null, 1, 1, DependencyItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preemptionEClass, Preemption.class, "Preemption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPreemption_PmtnType(), this.getPreemptionType(), "pmtnType", null, 1, 1, Preemption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreemption_NInterruptableDuration(), ecorePackage.getEInt(), "nInterruptableDuration", null, 0, 1, Preemption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deadlineRequirementEClass, DeadlineRequirement.class, "DeadlineRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeadlineRequirement_DeadlineType(), this.getDeadlineType(), "deadlineType", null, 0, 1, DeadlineRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceRequirementEClass, ResourceRequirement.class, "ResourceRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceRequirement_ResourceRequirementItems(), this.getResourceRequirementItem(), null, "resourceRequirementItems", null, 1, -1, ResourceRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceRequirementItemEClass, ResourceRequirementItem.class, "ResourceRequirementItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceRequirementItem_RequiredCapacity(), ecorePackage.getEInt(), "requiredCapacity", null, 0, 1, ResourceRequirementItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceRequirementItem_EligibleResourceItem(), this.getEligibleResource(), null, "eligibleResourceItem", null, 1, -1, ResourceRequirementItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceRequirementItem_RequiredResourceType(), this.getResourceType(), null, "requiredResourceType", null, 1, 1, ResourceRequirementItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eligibleResourceEClass, EligibleResource.class, "EligibleResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEligibleResource_WcetOnResource(), ecorePackage.getEInt(), "wcetOnResource", null, 0, 1, EligibleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEligibleResource_EligibleResourcePointer(), this.getAbstractResource(), null, "eligibleResourcePointer", null, 1, 1, EligibleResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutualExclusionEClass, MutualExclusion.class, "MutualExclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutualExclusion_MutexTask(), this.getAbstractTask(), null, "mutexTask", null, 1, 1, MutualExclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractResourceEClass, AbstractResource.class, "AbstractResource", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractResource_Renewable(), ecorePackage.getEBoolean(), "renewable", "true", 1, 1, AbstractResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractResource_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, AbstractResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractResource_Capacity(), ecorePackage.getEInt(), "capacity", null, 0, 1, AbstractResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractResource_Belongs(), this.getResourceType(), this.getResourceType_Has(), "belongs", null, 1, 1, AbstractResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTEClass, ResourceT.class, "ResourceT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceT_Power(), this.getPower(), null, "power", null, 1, 1, ResourceT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceCEClass, ResourceC.class, "ResourceC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceC_SubResources(), this.getAbstractResource(), null, "subResources", null, 1, -1, ResourceC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modeEClass, Mode.class, "Mode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMode_ExclusiveResources(), this.getAbstractResource(), null, "exclusiveResources", null, 0, -1, Mode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMode_ResourceMode(), this.getResourceMode(), "resourceMode", null, 0, 1, Mode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerEClass, Power.class, "Power", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPower_MaxState(), this.getPowerState(), null, "maxState", null, 1, 1, Power.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPower_CurrPowerState(), this.getPowerState(), null, "currPowerState", null, 1, 1, Power.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fixedStatePowerConsumptionEClass, FixedStatePowerConsumption.class, "FixedStatePowerConsumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(discreteStatePowerConsumptionEClass, DiscreteStatePowerConsumption.class, "DiscreteStatePowerConsumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousStatePowerConsumptionEClass, ContinuousStatePowerConsumption.class, "ContinuousStatePowerConsumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContinuousStatePowerConsumption_ScalePrecision(), ecorePackage.getEFloat(), "scalePrecision", "0.1", 1, 1, ContinuousStatePowerConsumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingCharacteristicEClass, SchedulingCharacteristic.class, "SchedulingCharacteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulingCharacteristic_SchedType(), this.getSchedulingType(), "schedType", null, 1, 1, SchedulingCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingCharacteristic_Preemptive(), ecorePackage.getEBoolean(), "preemptive", "true", 1, 1, SchedulingCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingCharacteristic_Migration(), this.getMigrationType(), "migration", null, 1, 1, SchedulingCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingCharacteristic_PriorityAssignment(), this.getPriorityAssignmentType(), "priorityAssignment", null, 1, 1, SchedulingCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulingCharacteristic_Objectives(), this.getObjective(), null, "objectives", null, 0, -1, SchedulingCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectiveEClass, Objective.class, "Objective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjective_Purpose(), this.getObjectivePurpose(), "purpose", null, 1, 1, Objective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjective_Criteria(), this.getObjectiveCriteria(), "criteria", "LATENESS", 1, 1, Objective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceObjectiveEClass, ResourceObjective.class, "ResourceObjective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taskObjectiveEClass, TaskObjective.class, "TaskObjective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schedulingWindowEClass, SchedulingWindow.class, "SchedulingWindow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulingWindow_Begin(), ecorePackage.getEInt(), "begin", null, 0, 1, SchedulingWindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingWindow_Duration(), ecorePackage.getEInt(), "duration", null, 0, 1, SchedulingWindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingPolicyEClass, SchedulingPolicy.class, "SchedulingPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulingPolicy_Ranking(), this.getSchedulingPolicyType(), "ranking", null, 1, 1, SchedulingPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingPolicy_Grouping(), ecorePackage.getEBoolean(), "grouping", null, 1, 1, SchedulingPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingStrategyEClass, SchedulingStrategy.class, "SchedulingStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(solverAdapterEClass, SolverAdapter.class, "SolverAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolverAdapter_Solvers(), this.getNumberJack(), null, "solvers", null, 1, -1, SolverAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numberJackEClass, NumberJack.class, "NumberJack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scipEClass, scheduler.SCIP.class, "SCIP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(miniSatEClass, MiniSat.class, "MiniSat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mipWrapperEClass, MipWrapper.class, "MipWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mistralEClass, Mistral.class, "Mistral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mistral2EClass, Mistral2.class, "Mistral2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(satWrapperEClass, SatWrapper.class, "SatWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(toulbar2EClass, Toulbar2.class, "Toulbar2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(walksatEClass, Walksat.class, "Walksat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(otherEClass, Other.class, "Other", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textualEClass, Textual.class, "Textual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(plotEClass, Plot.class, "Plot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matPlotLibEClass, MatPlotLib.class, "MatPlotLib", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceTypeEClass, ResourceType.class, "ResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceType_Has(), this.getAbstractResource(), this.getAbstractResource_Belongs(), "has", null, 1, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Abstraction(), this.getResourceAbstraction(), "abstraction", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerStateEClass, PowerState.class, "PowerState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPowerState_Scale(), ecorePackage.getEFloat(), "scale", null, 0, 1, PowerState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerState_PowerConsumption(), ecorePackage.getEFloat(), "powerConsumption", null, 0, 1, PowerState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalableEClass, Scalable.class, "Scalable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalable_MinState(), this.getPowerState(), null, "minState", null, 1, 1, Scalable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalable_RunnableStates(), this.getPowerState(), null, "runnableStates", null, 1, -1, Scalable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenEClass, Token.class, "Token", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToken_Name(), ecorePackage.getEString(), "name", null, 1, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToken_Amount(), ecorePackage.getEInt(), "amount", null, 1, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(periodicityTypeEEnum, PeriodicityType.class, "PeriodicityType");
		addEEnumLiteral(periodicityTypeEEnum, PeriodicityType.PERIODIC);
		addEEnumLiteral(periodicityTypeEEnum, PeriodicityType.APERIODIC);
		addEEnumLiteral(periodicityTypeEEnum, PeriodicityType.SPORADIC);

		initEEnum(priorityRankingTypeEEnum, PriorityRankingType.class, "PriorityRankingType");
		addEEnumLiteral(priorityRankingTypeEEnum, PriorityRankingType.ASCENDING);
		addEEnumLiteral(priorityRankingTypeEEnum, PriorityRankingType.DESCENDING);

		initEEnum(logicalRelationEEnum, LogicalRelation.class, "LogicalRelation");
		addEEnumLiteral(logicalRelationEEnum, LogicalRelation.OR);
		addEEnumLiteral(logicalRelationEEnum, LogicalRelation.AND);
		addEEnumLiteral(logicalRelationEEnum, LogicalRelation.XOR);

		initEEnum(preemptionTypeEEnum, PreemptionType.class, "PreemptionType");
		addEEnumLiteral(preemptionTypeEEnum, PreemptionType.NOT_PPREEMPTABLE);
		addEEnumLiteral(preemptionTypeEEnum, PreemptionType.FULLY_PREEMPTABLE);
		addEEnumLiteral(preemptionTypeEEnum, PreemptionType.COOPERATIVELY_PREEMPTABLE);

		initEEnum(deadlineTypeEEnum, DeadlineType.class, "DeadlineType");
		addEEnumLiteral(deadlineTypeEEnum, DeadlineType.HARD);
		addEEnumLiteral(deadlineTypeEEnum, DeadlineType.FIRM);
		addEEnumLiteral(deadlineTypeEEnum, DeadlineType.SOFT);

		initEEnum(resourceAbstractionEEnum, ResourceAbstraction.class, "ResourceAbstraction");
		addEEnumLiteral(resourceAbstractionEEnum, ResourceAbstraction.ACTIVE);
		addEEnumLiteral(resourceAbstractionEEnum, ResourceAbstraction.PASSIVE);
		addEEnumLiteral(resourceAbstractionEEnum, ResourceAbstraction.COMPOSITE);

		initEEnum(resourceModeEEnum, ResourceMode.class, "ResourceMode");
		addEEnumLiteral(resourceModeEEnum, ResourceMode.SHARED);
		addEEnumLiteral(resourceModeEEnum, ResourceMode.CB_EXCLUSIVE);
		addEEnumLiteral(resourceModeEEnum, ResourceMode.SB_EXCLUSIVE);
		addEEnumLiteral(resourceModeEEnum, ResourceMode.CB_AND_SB_EXCLUSIVE);

		initEEnum(schedulingTypeEEnum, SchedulingType.class, "SchedulingType");
		addEEnumLiteral(schedulingTypeEEnum, SchedulingType.OFFLINE);
		addEEnumLiteral(schedulingTypeEEnum, SchedulingType.ONLINE);

		initEEnum(migrationTypeEEnum, MigrationType.class, "MigrationType");
		addEEnumLiteral(migrationTypeEEnum, MigrationType.JOB_LEVEL);
		addEEnumLiteral(migrationTypeEEnum, MigrationType.TASK_LEVEL);
		addEEnumLiteral(migrationTypeEEnum, MigrationType.NON_MIGRATION);

		initEEnum(priorityAssignmentTypeEEnum, PriorityAssignmentType.class, "PriorityAssignmentType");
		addEEnumLiteral(priorityAssignmentTypeEEnum, PriorityAssignmentType.FIXED);
		addEEnumLiteral(priorityAssignmentTypeEEnum, PriorityAssignmentType.DYNAMIC);

		initEEnum(objectiveCriteriaEEnum, ObjectiveCriteria.class, "ObjectiveCriteria");
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.POWER_CONSUMPTION);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.LATENESS);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.EARLINESS);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.TARDINESS);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.CENTERING);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.MAKESPAN);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.MAX_LATENESS);
		addEEnumLiteral(objectiveCriteriaEEnum, ObjectiveCriteria.USER_DEFINED);

		initEEnum(objectivePurposeEEnum, ObjectivePurpose.class, "ObjectivePurpose");
		addEEnumLiteral(objectivePurposeEEnum, ObjectivePurpose.MAXI);
		addEEnumLiteral(objectivePurposeEEnum, ObjectivePurpose.MINI);

		initEEnum(schedulingPolicyTypeEEnum, SchedulingPolicyType.class, "SchedulingPolicyType");
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.FIFO);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.EDF);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.SJF);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.LJF);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.RM);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.ERT);
		addEEnumLiteral(schedulingPolicyTypeEEnum, SchedulingPolicyType.USER_DEFINED);

		// Create resource
		createResource(eNS_URI);
	}

} //SchedulerPackageImpl
