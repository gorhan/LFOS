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

import scheduler.MigrationType;
import scheduler.Objective;
import scheduler.PriorityAssignmentType;
import scheduler.SchedulerPackage;
import scheduler.SchedulingCharacteristic;
import scheduler.SchedulingPolicy;
import scheduler.SchedulingPolicyType;
import scheduler.SchedulingType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#isGrouping <em>Grouping</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#getSchedType <em>Sched Type</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#isPreemptive <em>Preemptive</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#getMigration <em>Migration</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#getPriorityAssignment <em>Priority Assignment</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingCharacteristicImpl#getObjectives <em>Objectives</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingCharacteristicImpl extends SchedulingWindowImpl implements SchedulingCharacteristic {
	/**
	 * The default value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicyType RANKING_EDEFAULT = SchedulingPolicyType.FIFO;

	/**
	 * The cached value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicyType ranking = RANKING_EDEFAULT;

	/**
	 * The default value of the '{@link #isGrouping() <em>Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrouping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GROUPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGrouping() <em>Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrouping()
	 * @generated
	 * @ordered
	 */
	protected boolean grouping = GROUPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedType() <em>Sched Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedType()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingType SCHED_TYPE_EDEFAULT = SchedulingType.OFFLINE;

	/**
	 * The cached value of the '{@link #getSchedType() <em>Sched Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedType()
	 * @generated
	 * @ordered
	 */
	protected SchedulingType schedType = SCHED_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPreemptive() <em>Preemptive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreemptive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PREEMPTIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPreemptive() <em>Preemptive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPreemptive()
	 * @generated
	 * @ordered
	 */
	protected boolean preemptive = PREEMPTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMigration() <em>Migration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigration()
	 * @generated
	 * @ordered
	 */
	protected static final MigrationType MIGRATION_EDEFAULT = MigrationType.JOB_LEVEL;

	/**
	 * The cached value of the '{@link #getMigration() <em>Migration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMigration()
	 * @generated
	 * @ordered
	 */
	protected MigrationType migration = MIGRATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriorityAssignment() <em>Priority Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityAssignment()
	 * @generated
	 * @ordered
	 */
	protected static final PriorityAssignmentType PRIORITY_ASSIGNMENT_EDEFAULT = PriorityAssignmentType.FIXED;

	/**
	 * The cached value of the '{@link #getPriorityAssignment() <em>Priority Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityAssignment()
	 * @generated
	 * @ordered
	 */
	protected PriorityAssignmentType priorityAssignment = PRIORITY_ASSIGNMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObjectives() <em>Objectives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectives()
	 * @generated
	 * @ordered
	 */
	protected EList<Objective> objectives;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingCharacteristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULING_CHARACTERISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicyType getRanking() {
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRanking(SchedulingPolicyType newRanking) {
		SchedulingPolicyType oldRanking = ranking;
		ranking = newRanking == null ? RANKING_EDEFAULT : newRanking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING, oldRanking, ranking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrouping() {
		return grouping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrouping(boolean newGrouping) {
		boolean oldGrouping = grouping;
		grouping = newGrouping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING, oldGrouping, grouping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingType getSchedType() {
		return schedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedType(SchedulingType newSchedType) {
		SchedulingType oldSchedType = schedType;
		schedType = newSchedType == null ? SCHED_TYPE_EDEFAULT : newSchedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__SCHED_TYPE, oldSchedType, schedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreemptive() {
		return preemptive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreemptive(boolean newPreemptive) {
		boolean oldPreemptive = preemptive;
		preemptive = newPreemptive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__PREEMPTIVE, oldPreemptive, preemptive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationType getMigration() {
		return migration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMigration(MigrationType newMigration) {
		MigrationType oldMigration = migration;
		migration = newMigration == null ? MIGRATION_EDEFAULT : newMigration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__MIGRATION, oldMigration, migration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityAssignmentType getPriorityAssignment() {
		return priorityAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityAssignment(PriorityAssignmentType newPriorityAssignment) {
		PriorityAssignmentType oldPriorityAssignment = priorityAssignment;
		priorityAssignment = newPriorityAssignment == null ? PRIORITY_ASSIGNMENT_EDEFAULT : newPriorityAssignment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT, oldPriorityAssignment, priorityAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Objective> getObjectives() {
		if (objectives == null) {
			objectives = new EObjectContainmentEList<Objective>(Objective.class, this, SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES);
		}
		return objectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES:
				return ((InternalEList<?>)getObjectives()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING:
				return getRanking();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING:
				return isGrouping();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__SCHED_TYPE:
				return getSchedType();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PREEMPTIVE:
				return isPreemptive();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__MIGRATION:
				return getMigration();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT:
				return getPriorityAssignment();
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES:
				return getObjectives();
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
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING:
				setRanking((SchedulingPolicyType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING:
				setGrouping((Boolean)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__SCHED_TYPE:
				setSchedType((SchedulingType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PREEMPTIVE:
				setPreemptive((Boolean)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__MIGRATION:
				setMigration((MigrationType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT:
				setPriorityAssignment((PriorityAssignmentType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES:
				getObjectives().clear();
				getObjectives().addAll((Collection<? extends Objective>)newValue);
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
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING:
				setRanking(RANKING_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING:
				setGrouping(GROUPING_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__SCHED_TYPE:
				setSchedType(SCHED_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PREEMPTIVE:
				setPreemptive(PREEMPTIVE_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__MIGRATION:
				setMigration(MIGRATION_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT:
				setPriorityAssignment(PRIORITY_ASSIGNMENT_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES:
				getObjectives().clear();
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
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING:
				return ranking != RANKING_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING:
				return grouping != GROUPING_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__SCHED_TYPE:
				return schedType != SCHED_TYPE_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PREEMPTIVE:
				return preemptive != PREEMPTIVE_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__MIGRATION:
				return migration != MIGRATION_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__PRIORITY_ASSIGNMENT:
				return priorityAssignment != PRIORITY_ASSIGNMENT_EDEFAULT;
			case SchedulerPackage.SCHEDULING_CHARACTERISTIC__OBJECTIVES:
				return objectives != null && !objectives.isEmpty();
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
		if (baseClass == SchedulingPolicy.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING: return SchedulerPackage.SCHEDULING_POLICY__RANKING;
				case SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING: return SchedulerPackage.SCHEDULING_POLICY__GROUPING;
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
		if (baseClass == SchedulingPolicy.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.SCHEDULING_POLICY__RANKING: return SchedulerPackage.SCHEDULING_CHARACTERISTIC__RANKING;
				case SchedulerPackage.SCHEDULING_POLICY__GROUPING: return SchedulerPackage.SCHEDULING_CHARACTERISTIC__GROUPING;
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
		result.append(" (ranking: ");
		result.append(ranking);
		result.append(", grouping: ");
		result.append(grouping);
		result.append(", schedType: ");
		result.append(schedType);
		result.append(", preemptive: ");
		result.append(preemptive);
		result.append(", migration: ");
		result.append(migration);
		result.append(", priorityAssignment: ");
		result.append(priorityAssignment);
		result.append(')');
		return result.toString();
	}

} //SchedulingCharacteristicImpl
