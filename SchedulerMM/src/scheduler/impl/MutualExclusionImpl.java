/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.AbstractTask;
import scheduler.MutualExclusion;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutual Exclusion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.MutualExclusionImpl#getMutexTask <em>Mutex Task</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MutualExclusionImpl extends MinimalEObjectImpl.Container implements MutualExclusion {
	/**
	 * The cached value of the '{@link #getMutexTask() <em>Mutex Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexTask()
	 * @generated
	 * @ordered
	 */
	protected AbstractTask mutexTask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutualExclusionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.MUTUAL_EXCLUSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTask getMutexTask() {
		if (mutexTask != null && mutexTask.eIsProxy()) {
			InternalEObject oldMutexTask = (InternalEObject)mutexTask;
			mutexTask = (AbstractTask)eResolveProxy(oldMutexTask);
			if (mutexTask != oldMutexTask) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK, oldMutexTask, mutexTask));
			}
		}
		return mutexTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTask basicGetMutexTask() {
		return mutexTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutexTask(AbstractTask newMutexTask) {
		AbstractTask oldMutexTask = mutexTask;
		mutexTask = newMutexTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK, oldMutexTask, mutexTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK:
				if (resolve) return getMutexTask();
				return basicGetMutexTask();
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
			case SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK:
				setMutexTask((AbstractTask)newValue);
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
			case SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK:
				setMutexTask((AbstractTask)null);
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
			case SchedulerPackage.MUTUAL_EXCLUSION__MUTEX_TASK:
				return mutexTask != null;
		}
		return super.eIsSet(featureID);
	}

} //MutualExclusionImpl
