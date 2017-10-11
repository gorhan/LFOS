/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.Preemption;
import scheduler.PreemptionType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preemption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.PreemptionImpl#getPmtnType <em>Pmtn Type</em>}</li>
 *   <li>{@link scheduler.impl.PreemptionImpl#getNInterruptableDuration <em>NInterruptable Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PreemptionImpl extends MinimalEObjectImpl.Container implements Preemption {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreemptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.PREEMPTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.PREEMPTION__PMTN_TYPE, oldPmtnType, pmtnType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION, oldNInterruptableDuration, nInterruptableDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.PREEMPTION__PMTN_TYPE:
				return getPmtnType();
			case SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION:
				return getNInterruptableDuration();
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
			case SchedulerPackage.PREEMPTION__PMTN_TYPE:
				setPmtnType((PreemptionType)newValue);
				return;
			case SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION:
				setNInterruptableDuration((Integer)newValue);
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
			case SchedulerPackage.PREEMPTION__PMTN_TYPE:
				setPmtnType(PMTN_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION:
				setNInterruptableDuration(NINTERRUPTABLE_DURATION_EDEFAULT);
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
			case SchedulerPackage.PREEMPTION__PMTN_TYPE:
				return pmtnType != PMTN_TYPE_EDEFAULT;
			case SchedulerPackage.PREEMPTION__NINTERRUPTABLE_DURATION:
				return nInterruptableDuration != NINTERRUPTABLE_DURATION_EDEFAULT;
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
		result.append(" (pmtnType: ");
		result.append(pmtnType);
		result.append(", nInterruptableDuration: ");
		result.append(nInterruptableDuration);
		result.append(')');
		return result.toString();
	}

} //PreemptionImpl
