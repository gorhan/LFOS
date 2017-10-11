/**
 */
package scheduler.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import scheduler.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage
 * @generated
 */
public class SchedulerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchedulerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerSwitch() {
		if (modelPackage == null) {
			modelPackage = SchedulerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SchedulerPackage.SCHEDULER: {
				Scheduler scheduler = (Scheduler)theEObject;
				T result = caseScheduler(scheduler);
				if (result == null) result = caseSchedulingCharacteristic(scheduler);
				if (result == null) result = caseSchedulingStrategy(scheduler);
				if (result == null) result = caseSchedulingWindow(scheduler);
				if (result == null) result = caseSchedulingPolicy(scheduler);
				if (result == null) result = caseSolverAdapter(scheduler);
				if (result == null) result = caseOutput(scheduler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.ABSTRACT_TASK: {
				AbstractTask abstractTask = (AbstractTask)theEObject;
				T result = caseAbstractTask(abstractTask);
				if (result == null) result = caseTiming(abstractTask);
				if (result == null) result = casePriority(abstractTask);
				if (result == null) result = caseDependency(abstractTask);
				if (result == null) result = casePreemption(abstractTask);
				if (result == null) result = caseRequirement(abstractTask);
				if (result == null) result = casePeriodicity(abstractTask);
				if (result == null) result = caseDeadlineRequirement(abstractTask);
				if (result == null) result = caseResourceRequirement(abstractTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TASK_T: {
				TaskT taskT = (TaskT)theEObject;
				T result = caseTaskT(taskT);
				if (result == null) result = caseAbstractTask(taskT);
				if (result == null) result = caseTiming(taskT);
				if (result == null) result = casePriority(taskT);
				if (result == null) result = caseDependency(taskT);
				if (result == null) result = casePreemption(taskT);
				if (result == null) result = caseRequirement(taskT);
				if (result == null) result = casePeriodicity(taskT);
				if (result == null) result = caseDeadlineRequirement(taskT);
				if (result == null) result = caseResourceRequirement(taskT);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TASK_C: {
				TaskC taskC = (TaskC)theEObject;
				T result = caseTaskC(taskC);
				if (result == null) result = caseAbstractTask(taskC);
				if (result == null) result = caseTiming(taskC);
				if (result == null) result = casePriority(taskC);
				if (result == null) result = caseDependency(taskC);
				if (result == null) result = casePreemption(taskC);
				if (result == null) result = caseRequirement(taskC);
				if (result == null) result = casePeriodicity(taskC);
				if (result == null) result = caseDeadlineRequirement(taskC);
				if (result == null) result = caseResourceRequirement(taskC);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TIMING: {
				Timing timing = (Timing)theEObject;
				T result = caseTiming(timing);
				if (result == null) result = casePeriodicity(timing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.PERIODICITY: {
				Periodicity periodicity = (Periodicity)theEObject;
				T result = casePeriodicity(periodicity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.PRIORITY: {
				Priority priority = (Priority)theEObject;
				T result = casePriority(priority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.DEPENDENCY: {
				Dependency dependency = (Dependency)theEObject;
				T result = caseDependency(dependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.DEPENDENCY_ITEM: {
				DependencyItem dependencyItem = (DependencyItem)theEObject;
				T result = caseDependencyItem(dependencyItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.PREEMPTION: {
				Preemption preemption = (Preemption)theEObject;
				T result = casePreemption(preemption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.REQUIREMENT: {
				Requirement requirement = (Requirement)theEObject;
				T result = caseRequirement(requirement);
				if (result == null) result = caseDeadlineRequirement(requirement);
				if (result == null) result = caseResourceRequirement(requirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.DEADLINE_REQUIREMENT: {
				DeadlineRequirement deadlineRequirement = (DeadlineRequirement)theEObject;
				T result = caseDeadlineRequirement(deadlineRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_REQUIREMENT: {
				ResourceRequirement resourceRequirement = (ResourceRequirement)theEObject;
				T result = caseResourceRequirement(resourceRequirement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM: {
				ResourceRequirementItem resourceRequirementItem = (ResourceRequirementItem)theEObject;
				T result = caseResourceRequirementItem(resourceRequirementItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.ELIGIBLE_RESOURCE: {
				EligibleResource eligibleResource = (EligibleResource)theEObject;
				T result = caseEligibleResource(eligibleResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MUTUAL_EXCLUSION: {
				MutualExclusion mutualExclusion = (MutualExclusion)theEObject;
				T result = caseMutualExclusion(mutualExclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.ABSTRACT_RESOURCE: {
				AbstractResource abstractResource = (AbstractResource)theEObject;
				T result = caseAbstractResource(abstractResource);
				if (result == null) result = caseMode(abstractResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_T: {
				ResourceT resourceT = (ResourceT)theEObject;
				T result = caseResourceT(resourceT);
				if (result == null) result = caseAbstractResource(resourceT);
				if (result == null) result = caseMode(resourceT);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_C: {
				ResourceC resourceC = (ResourceC)theEObject;
				T result = caseResourceC(resourceC);
				if (result == null) result = caseAbstractResource(resourceC);
				if (result == null) result = caseMode(resourceC);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MODE: {
				Mode mode = (Mode)theEObject;
				T result = caseMode(mode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.POWER: {
				Power power = (Power)theEObject;
				T result = casePower(power);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION: {
				FixedStatePowerConsumption fixedStatePowerConsumption = (FixedStatePowerConsumption)theEObject;
				T result = caseFixedStatePowerConsumption(fixedStatePowerConsumption);
				if (result == null) result = casePower(fixedStatePowerConsumption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.DISCRETE_STATE_POWER_CONSUMPTION: {
				DiscreteStatePowerConsumption discreteStatePowerConsumption = (DiscreteStatePowerConsumption)theEObject;
				T result = caseDiscreteStatePowerConsumption(discreteStatePowerConsumption);
				if (result == null) result = caseScalable(discreteStatePowerConsumption);
				if (result == null) result = casePower(discreteStatePowerConsumption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION: {
				ContinuousStatePowerConsumption continuousStatePowerConsumption = (ContinuousStatePowerConsumption)theEObject;
				T result = caseContinuousStatePowerConsumption(continuousStatePowerConsumption);
				if (result == null) result = caseScalable(continuousStatePowerConsumption);
				if (result == null) result = casePower(continuousStatePowerConsumption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC: {
				SchedulingCharacteristic schedulingCharacteristic = (SchedulingCharacteristic)theEObject;
				T result = caseSchedulingCharacteristic(schedulingCharacteristic);
				if (result == null) result = caseSchedulingWindow(schedulingCharacteristic);
				if (result == null) result = caseSchedulingPolicy(schedulingCharacteristic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.OBJECTIVE: {
				Objective objective = (Objective)theEObject;
				T result = caseObjective(objective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_OBJECTIVE: {
				ResourceObjective resourceObjective = (ResourceObjective)theEObject;
				T result = caseResourceObjective(resourceObjective);
				if (result == null) result = caseObjective(resourceObjective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TASK_OBJECTIVE: {
				TaskObjective taskObjective = (TaskObjective)theEObject;
				T result = caseTaskObjective(taskObjective);
				if (result == null) result = caseObjective(taskObjective);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCHEDULING_WINDOW: {
				SchedulingWindow schedulingWindow = (SchedulingWindow)theEObject;
				T result = caseSchedulingWindow(schedulingWindow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCHEDULING_POLICY: {
				SchedulingPolicy schedulingPolicy = (SchedulingPolicy)theEObject;
				T result = caseSchedulingPolicy(schedulingPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCHEDULING_STRATEGY: {
				SchedulingStrategy schedulingStrategy = (SchedulingStrategy)theEObject;
				T result = caseSchedulingStrategy(schedulingStrategy);
				if (result == null) result = caseSolverAdapter(schedulingStrategy);
				if (result == null) result = caseOutput(schedulingStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SOLVER_ADAPTER: {
				SolverAdapter solverAdapter = (SolverAdapter)theEObject;
				T result = caseSolverAdapter(solverAdapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.NUMBER_JACK: {
				NumberJack numberJack = (NumberJack)theEObject;
				T result = caseNumberJack(numberJack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCIP: {
				SCIP scip = (SCIP)theEObject;
				T result = caseSCIP(scip);
				if (result == null) result = caseNumberJack(scip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MINI_SAT: {
				MiniSat miniSat = (MiniSat)theEObject;
				T result = caseMiniSat(miniSat);
				if (result == null) result = caseNumberJack(miniSat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MIP_WRAPPER: {
				MipWrapper mipWrapper = (MipWrapper)theEObject;
				T result = caseMipWrapper(mipWrapper);
				if (result == null) result = caseNumberJack(mipWrapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MISTRAL: {
				Mistral mistral = (Mistral)theEObject;
				T result = caseMistral(mistral);
				if (result == null) result = caseNumberJack(mistral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MISTRAL2: {
				Mistral2 mistral2 = (Mistral2)theEObject;
				T result = caseMistral2(mistral2);
				if (result == null) result = caseNumberJack(mistral2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SAT_WRAPPER: {
				SatWrapper satWrapper = (SatWrapper)theEObject;
				T result = caseSatWrapper(satWrapper);
				if (result == null) result = caseNumberJack(satWrapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TOULBAR2: {
				Toulbar2 toulbar2 = (Toulbar2)theEObject;
				T result = caseToulbar2(toulbar2);
				if (result == null) result = caseNumberJack(toulbar2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.WALKSAT: {
				Walksat walksat = (Walksat)theEObject;
				T result = caseWalksat(walksat);
				if (result == null) result = caseNumberJack(walksat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.OTHER: {
				Other other = (Other)theEObject;
				T result = caseOther(other);
				if (result == null) result = caseNumberJack(other);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TEXTUAL: {
				Textual textual = (Textual)theEObject;
				T result = caseTextual(textual);
				if (result == null) result = caseOutput(textual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.PLOT: {
				Plot plot = (Plot)theEObject;
				T result = casePlot(plot);
				if (result == null) result = caseOutput(plot);
				if (result == null) result = caseMatPlotLib(plot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.MAT_PLOT_LIB: {
				MatPlotLib matPlotLib = (MatPlotLib)theEObject;
				T result = caseMatPlotLib(matPlotLib);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.RESOURCE_TYPE: {
				ResourceType resourceType = (ResourceType)theEObject;
				T result = caseResourceType(resourceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.POWER_STATE: {
				PowerState powerState = (PowerState)theEObject;
				T result = casePowerState(powerState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.SCALABLE: {
				Scalable scalable = (Scalable)theEObject;
				T result = caseScalable(scalable);
				if (result == null) result = casePower(scalable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchedulerPackage.TOKEN: {
				Token token = (Token)theEObject;
				T result = caseToken(token);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduler(Scheduler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTask(AbstractTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task T</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task T</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskT(TaskT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task C</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task C</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskC(TaskC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTiming(Timing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Periodicity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Periodicity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriodicity(Periodicity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriority(Priority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyItem(DependencyItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preemption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preemption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreemption(Preemption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deadline Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deadline Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeadlineRequirement(DeadlineRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceRequirement(ResourceRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Requirement Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Requirement Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceRequirementItem(ResourceRequirementItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eligible Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eligible Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEligibleResource(EligibleResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutual Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutual Exclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutualExclusion(MutualExclusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractResource(AbstractResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource T</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource T</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceT(ResourceT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource C</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource C</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceC(ResourceC object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMode(Mode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePower(Power object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed State Power Consumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedStatePowerConsumption(FixedStatePowerConsumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discrete State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discrete State Power Consumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscreteStatePowerConsumption(DiscreteStatePowerConsumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continuous State Power Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continuous State Power Consumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinuousStatePowerConsumption(ContinuousStatePowerConsumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingCharacteristic(SchedulingCharacteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjective(Objective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceObjective(ResourceObjective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskObjective(TaskObjective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Window</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Window</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingWindow(SchedulingWindow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingPolicy(SchedulingPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingStrategy(SchedulingStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solver Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solver Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolverAdapter(SolverAdapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Jack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Jack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberJack(NumberJack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCIP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCIP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCIP(SCIP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mini Sat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mini Sat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMiniSat(MiniSat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mip Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mip Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMipWrapper(MipWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mistral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mistral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMistral(Mistral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mistral2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mistral2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMistral2(Mistral2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sat Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sat Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSatWrapper(SatWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Toulbar2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Toulbar2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToulbar2(Toulbar2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Walksat</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Walksat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWalksat(Walksat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Other</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOther(Other object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Textual</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Textual</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextual(Textual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlot(Plot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mat Plot Lib</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mat Plot Lib</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatPlotLib(MatPlotLib object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceType(ResourceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerState(PowerState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalable(Scalable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToken(Token object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SchedulerSwitch
