/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.SchedulerPackage;
import scheduler.SchedulingWindow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.SchedulingWindowImpl#getSchedBegin <em>Sched Begin</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingWindowImpl#getSchedDuration <em>Sched Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingWindowImpl extends MinimalEObjectImpl.Container implements SchedulingWindow {
	/**
	 * The default value of the '{@link #getSchedBegin() <em>Sched Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedBegin()
	 * @generated
	 * @ordered
	 */
	protected static final int SCHED_BEGIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSchedBegin() <em>Sched Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedBegin()
	 * @generated
	 * @ordered
	 */
	protected int schedBegin = SCHED_BEGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedDuration() <em>Sched Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SCHED_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSchedDuration() <em>Sched Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedDuration()
	 * @generated
	 * @ordered
	 */
	protected int schedDuration = SCHED_DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingWindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULING_WINDOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSchedBegin() {
		return schedBegin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedBegin(int newSchedBegin) {
		int oldSchedBegin = schedBegin;
		schedBegin = newSchedBegin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_WINDOW__SCHED_BEGIN, oldSchedBegin, schedBegin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSchedDuration() {
		return schedDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedDuration(int newSchedDuration) {
		int oldSchedDuration = schedDuration;
		schedDuration = newSchedDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_WINDOW__SCHED_DURATION, oldSchedDuration, schedDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_BEGIN:
				return getSchedBegin();
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_DURATION:
				return getSchedDuration();
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
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_BEGIN:
				setSchedBegin((Integer)newValue);
				return;
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_DURATION:
				setSchedDuration((Integer)newValue);
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
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_BEGIN:
				setSchedBegin(SCHED_BEGIN_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_DURATION:
				setSchedDuration(SCHED_DURATION_EDEFAULT);
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
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_BEGIN:
				return schedBegin != SCHED_BEGIN_EDEFAULT;
			case SchedulerPackage.SCHEDULING_WINDOW__SCHED_DURATION:
				return schedDuration != SCHED_DURATION_EDEFAULT;
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
		result.append(" (schedBegin: ");
		result.append(schedBegin);
		result.append(", schedDuration: ");
		result.append(schedDuration);
		result.append(')');
		return result.toString();
	}

} //SchedulingWindowImpl
