/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.DeadlineRequirement;
import scheduler.DeadlineType;
import scheduler.Dependency;
import scheduler.DependencyItem;
import scheduler.LogicalRelation;
import scheduler.MutualExclusion;
import scheduler.Preemption;
import scheduler.PreemptionType;
import scheduler.Priority;
import scheduler.PriorityRankingType;
import scheduler.Requirement;
import scheduler.ResourceRequirement;
import scheduler.ResourceRequirementItem;
import scheduler.SchedulerPackage;
import scheduler.TaskT;
import scheduler.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task T</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.TaskTImpl#getRankingType <em>Ranking Type</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getPriorityValue <em>Priority Value</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getDependencyItems <em>Dependency Items</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getMutexItems <em>Mutex Items</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getPmtnType <em>Pmtn Type</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getNInterruptableDuration <em>NInterruptable Duration</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getDeadlineType <em>Deadline Type</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getResourceRequirementItems <em>Resource Requirement Items</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getType <em>Type</em>}</li>
 *   <li>{@link scheduler.impl.TaskTImpl#getFires <em>Fires</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskTImpl extends TimingImpl implements TaskT {
	/**
	 * The default value of the '{@link #getRankingType() <em>Ranking Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRankingType()
	 * @generated
	 * @ordered
	 */
	protected static final PriorityRankingType RANKING_TYPE_EDEFAULT = PriorityRankingType.ASCENDING;

	/**
	 * The cached value of the '{@link #getRankingType() <em>Ranking Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRankingType()
	 * @generated
	 * @ordered
	 */
	protected PriorityRankingType rankingType = RANKING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriorityValue() <em>Priority Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityValue()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriorityValue() <em>Priority Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityValue()
	 * @generated
	 * @ordered
	 */
	protected int priorityValue = PRIORITY_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencyItems() <em>Dependency Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyItems()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyItem> dependencyItems;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final LogicalRelation RELATION_EDEFAULT = LogicalRelation.OR;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected LogicalRelation relation = RELATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMutexItems() <em>Mutex Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexItems()
	 * @generated
	 * @ordered
	 */
	protected EList<MutualExclusion> mutexItems;

	/**
	 * The default value of the '{@link #getPmtnType() <em>Pmtn Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPmtnType()
	 * @generated
	 * @ordered
	 */
	protected static final PreemptionType PMTN_TYPE_EDEFAULT = PreemptionType.NOT_PPREEMPTABLE;

	/**
	 * The cached value of the '{@link #getPmtnType() <em>Pmtn Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPmtnType()
	 * @generated
	 * @ordered
	 */
	protected PreemptionType pmtnType = PMTN_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNInterruptableDuration() <em>NInterruptable Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNInterruptableDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int NINTERRUPTABLE_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNInterruptableDuration() <em>NInterruptable Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNInterruptableDuration()
	 * @generated
	 * @ordered
	 */
	protected int nInterruptableDuration = NINTERRUPTABLE_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeadlineType() <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadlineType()
	 * @generated
	 * @ordered
	 */
	protected static final DeadlineType DEADLINE_TYPE_EDEFAULT = DeadlineType.HARD;

	/**
	 * The cached value of the '{@link #getDeadlineType() <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadlineType()
	 * @generated
	 * @ordered
	 */
	protected DeadlineType deadlineType = DEADLINE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceRequirementItems() <em>Resource Requirement Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequirementItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRequirementItem> resourceRequirementItems;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFires() <em>Fires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFires()
	 * @generated
	 * @ordered
	 */
	protected EList<Token> fires;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.TASK_T;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRankingType getRankingType() {
		return rankingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRankingType(PriorityRankingType newRankingType) {
		PriorityRankingType oldRankingType = rankingType;
		rankingType = newRankingType == null ? RANKING_TYPE_EDEFAULT : newRankingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__RANKING_TYPE, oldRankingType, rankingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityValue(int newPriorityValue) {
		int oldPriorityValue = priorityValue;
		priorityValue = newPriorityValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__PRIORITY_VALUE, oldPriorityValue, priorityValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependencyItem> getDependencyItems() {
		if (dependencyItems == null) {
			dependencyItems = new EObjectContainmentEList<DependencyItem>(DependencyItem.class, this, SchedulerPackage.TASK_T__DEPENDENCY_ITEMS);
		}
		return dependencyItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalRelation getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(LogicalRelation newRelation) {
		LogicalRelation oldRelation = relation;
		relation = newRelation == null ? RELATION_EDEFAULT : newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MutualExclusion> getMutexItems() {
		if (mutexItems == null) {
			mutexItems = new EObjectContainmentEList<MutualExclusion>(MutualExclusion.class, this, SchedulerPackage.TASK_T__MUTEX_ITEMS);
		}
		return mutexItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreemptionType getPmtnType() {
		return pmtnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPmtnType(PreemptionType newPmtnType) {
		PreemptionType oldPmtnType = pmtnType;
		pmtnType = newPmtnType == null ? PMTN_TYPE_EDEFAULT : newPmtnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__PMTN_TYPE, oldPmtnType, pmtnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNInterruptableDuration() {
		return nInterruptableDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNInterruptableDuration(int newNInterruptableDuration) {
		int oldNInterruptableDuration = nInterruptableDuration;
		nInterruptableDuration = newNInterruptableDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION, oldNInterruptableDuration, nInterruptableDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeadlineType getDeadlineType() {
		return deadlineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadlineType(DeadlineType newDeadlineType) {
		DeadlineType oldDeadlineType = deadlineType;
		deadlineType = newDeadlineType == null ? DEADLINE_TYPE_EDEFAULT : newDeadlineType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__DEADLINE_TYPE, oldDeadlineType, deadlineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequirementItem> getResourceRequirementItems() {
		if (resourceRequirementItems == null) {
			resourceRequirementItems = new EObjectContainmentEList<ResourceRequirementItem>(ResourceRequirementItem.class, this, SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS);
		}
		return resourceRequirementItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.TASK_T__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Token> getFires() {
		if (fires == null) {
			fires = new EObjectContainmentEList<Token>(Token.class, this, SchedulerPackage.TASK_T__FIRES);
		}
		return fires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS:
				return ((InternalEList<?>)getDependencyItems()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.TASK_T__MUTEX_ITEMS:
				return ((InternalEList<?>)getMutexItems()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS:
				return ((InternalEList<?>)getResourceRequirementItems()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.TASK_T__FIRES:
				return ((InternalEList<?>)getFires()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.TASK_T__RANKING_TYPE:
				return getRankingType();
			case SchedulerPackage.TASK_T__PRIORITY_VALUE:
				return getPriorityValue();
			case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS:
				return getDependencyItems();
			case SchedulerPackage.TASK_T__RELATION:
				return getRelation();
			case SchedulerPackage.TASK_T__MUTEX_ITEMS:
				return getMutexItems();
			case SchedulerPackage.TASK_T__PMTN_TYPE:
				return getPmtnType();
			case SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION:
				return getNInterruptableDuration();
			case SchedulerPackage.TASK_T__DEADLINE_TYPE:
				return getDeadlineType();
			case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS:
				return getResourceRequirementItems();
			case SchedulerPackage.TASK_T__NAME:
				return getName();
			case SchedulerPackage.TASK_T__TYPE:
				return getType();
			case SchedulerPackage.TASK_T__FIRES:
				return getFires();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.TASK_T__RANKING_TYPE:
				setRankingType((PriorityRankingType)newValue);
				return;
			case SchedulerPackage.TASK_T__PRIORITY_VALUE:
				setPriorityValue((Integer)newValue);
				return;
			case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS:
				getDependencyItems().clear();
				getDependencyItems().addAll((Collection<? extends DependencyItem>)newValue);
				return;
			case SchedulerPackage.TASK_T__RELATION:
				setRelation((LogicalRelation)newValue);
				return;
			case SchedulerPackage.TASK_T__MUTEX_ITEMS:
				getMutexItems().clear();
				getMutexItems().addAll((Collection<? extends MutualExclusion>)newValue);
				return;
			case SchedulerPackage.TASK_T__PMTN_TYPE:
				setPmtnType((PreemptionType)newValue);
				return;
			case SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION:
				setNInterruptableDuration((Integer)newValue);
				return;
			case SchedulerPackage.TASK_T__DEADLINE_TYPE:
				setDeadlineType((DeadlineType)newValue);
				return;
			case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS:
				getResourceRequirementItems().clear();
				getResourceRequirementItems().addAll((Collection<? extends ResourceRequirementItem>)newValue);
				return;
			case SchedulerPackage.TASK_T__NAME:
				setName((String)newValue);
				return;
			case SchedulerPackage.TASK_T__TYPE:
				setType((String)newValue);
				return;
			case SchedulerPackage.TASK_T__FIRES:
				getFires().clear();
				getFires().addAll((Collection<? extends Token>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchedulerPackage.TASK_T__RANKING_TYPE:
				setRankingType(RANKING_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__PRIORITY_VALUE:
				setPriorityValue(PRIORITY_VALUE_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS:
				getDependencyItems().clear();
				return;
			case SchedulerPackage.TASK_T__RELATION:
				setRelation(RELATION_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__MUTEX_ITEMS:
				getMutexItems().clear();
				return;
			case SchedulerPackage.TASK_T__PMTN_TYPE:
				setPmtnType(PMTN_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION:
				setNInterruptableDuration(NINTERRUPTABLE_DURATION_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__DEADLINE_TYPE:
				setDeadlineType(DEADLINE_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS:
				getResourceRequirementItems().clear();
				return;
			case SchedulerPackage.TASK_T__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SchedulerPackage.TASK_T__FIRES:
				getFires().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchedulerPackage.TASK_T__RANKING_TYPE:
				return rankingType != RANKING_TYPE_EDEFAULT;
			case SchedulerPackage.TASK_T__PRIORITY_VALUE:
				return priorityValue != PRIORITY_VALUE_EDEFAULT;
			case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS:
				return dependencyItems != null && !dependencyItems.isEmpty();
			case SchedulerPackage.TASK_T__RELATION:
				return relation != RELATION_EDEFAULT;
			case SchedulerPackage.TASK_T__MUTEX_ITEMS:
				return mutexItems != null && !mutexItems.isEmpty();
			case SchedulerPackage.TASK_T__PMTN_TYPE:
				return pmtnType != PMTN_TYPE_EDEFAULT;
			case SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION:
				return nInterruptableDuration != NINTERRUPTABLE_DURATION_EDEFAULT;
			case SchedulerPackage.TASK_T__DEADLINE_TYPE:
				return deadlineType != DEADLINE_TYPE_EDEFAULT;
			case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS:
				return resourceRequirementItems != null && !resourceRequirementItems.isEmpty();
			case SchedulerPackage.TASK_T__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulerPackage.TASK_T__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SchedulerPackage.TASK_T__FIRES:
				return fires != null && !fires.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Priority.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.TASK_T__RANKING_TYPE: return SchedulerPackage.PRIORITY__RANKING_TYPE;
				case SchedulerPackage.TASK_T__PRIORITY_VALUE: return SchedulerPackage.PRIORITY__PRIORITY_VALUE;
				default: return -1;
			}
		}
		if (baseClass == Dependency.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.TASK_T__DEPENDENCY_ITEMS: return SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEMS;
				case SchedulerPackage.TASK_T__RELATION: return SchedulerPackage.DEPENDENCY__RELATION;
				case SchedulerPackage.TASK_T__MUTEX_ITEMS: return SchedulerPackage.DEPENDENCY__MUTEX_ITEMS;
				default: return -1;
			}
		}
		if (baseClass == Preemption.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.TASK_T__PMTN_TYPE: return SchedulerPackage.PREEMPTION__PMTN_TYPE;
				case SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION: return SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION;
				default: return -1;
			}
		}
		if (baseClass == DeadlineRequirement.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.TASK_T__DEADLINE_TYPE: return SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE;
				default: return -1;
			}
		}
		if (baseClass == ResourceRequirement.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS: return SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS;
				default: return -1;
			}
		}
		if (baseClass == Requirement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Priority.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.PRIORITY__RANKING_TYPE: return SchedulerPackage.TASK_T__RANKING_TYPE;
				case SchedulerPackage.PRIORITY__PRIORITY_VALUE: return SchedulerPackage.TASK_T__PRIORITY_VALUE;
				default: return -1;
			}
		}
		if (baseClass == Dependency.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEMS: return SchedulerPackage.TASK_T__DEPENDENCY_ITEMS;
				case SchedulerPackage.DEPENDENCY__RELATION: return SchedulerPackage.TASK_T__RELATION;
				case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS: return SchedulerPackage.TASK_T__MUTEX_ITEMS;
				default: return -1;
			}
		}
		if (baseClass == Preemption.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.PREEMPTION__PMTN_TYPE: return SchedulerPackage.TASK_T__PMTN_TYPE;
				case SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION: return SchedulerPackage.TASK_T__NINTERRUPTABLE_DURATION;
				default: return -1;
			}
		}
		if (baseClass == DeadlineRequirement.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE: return SchedulerPackage.TASK_T__DEADLINE_TYPE;
				default: return -1;
			}
		}
		if (baseClass == ResourceRequirement.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS: return SchedulerPackage.TASK_T__RESOURCE_REQUIREMENT_ITEMS;
				default: return -1;
			}
		}
		if (baseClass == Requirement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rankingType: ");
		result.append(rankingType);
		result.append(", priorityValue: ");
		result.append(priorityValue);
		result.append(", relation: ");
		result.append(relation);
		result.append(", pmtnType: ");
		result.append(pmtnType);
		result.append(", nInterruptableDuration: ");
		result.append(nInterruptableDuration);
		result.append(", deadlineType: ");
		result.append(deadlineType);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TaskTImpl
