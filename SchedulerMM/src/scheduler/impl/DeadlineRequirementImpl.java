/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.DeadlineRequirement;
import scheduler.DeadlineType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deadline Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.DeadlineRequirementImpl#getDeadlineType <em>Deadline Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeadlineRequirementImpl extends MinimalEObjectImpl.Container implements DeadlineRequirement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeadlineRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.DEADLINE_REQUIREMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE, oldDeadlineType, deadlineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE:
				return getDeadlineType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE:
				setDeadlineType((DeadlineType)newValue);
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
			case SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE:
				setDeadlineType(DEADLINE_TYPE_EDEFAULT);
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
			case SchedulerPackage.DEADLINE_REQUIREMENT__DEADLINE_TYPE:
				return deadlineType != DEADLINE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (deadlineType: ");
		result.append(deadlineType);
		result.append(')');
		return result.toString();
	}

} //DeadlineRequirementImpl
