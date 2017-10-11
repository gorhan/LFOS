/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.FixedStatePowerConsumption;
import scheduler.PowerState;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed State Power Consumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.FixedStatePowerConsumptionImpl#getMaxState <em>Max State</em>}</li>
 *   <li>{@link scheduler.impl.FixedStatePowerConsumptionImpl#getCurrPowerState <em>Curr Power State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedStatePowerConsumptionImpl extends MinimalEObjectImpl.Container implements FixedStatePowerConsumption {
	/**
	 * The cached value of the '{@link #getMaxState() <em>Max State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxState()
	 * @generated
	 * @ordered
	 */
	protected PowerState maxState;

	/**
	 * The cached value of the '{@link #getCurrPowerState() <em>Curr Power State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrPowerState()
	 * @generated
	 * @ordered
	 */
	protected PowerState currPowerState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedStatePowerConsumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.FIXED_STATE_POWER_CONSUMPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState getMaxState() {
		return maxState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaxState(PowerState newMaxState, NotificationChain msgs) {
		PowerState oldMaxState = maxState;
		maxState = newMaxState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE, oldMaxState, newMaxState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxState(PowerState newMaxState) {
		if (newMaxState != maxState) {
			NotificationChain msgs = null;
			if (maxState != null)
				msgs = ((InternalEObject)maxState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE, null, msgs);
			if (newMaxState != null)
				msgs = ((InternalEObject)newMaxState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE, null, msgs);
			msgs = basicSetMaxState(newMaxState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE, newMaxState, newMaxState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState getCurrPowerState() {
		if (currPowerState != null && currPowerState.eIsProxy()) {
			InternalEObject oldCurrPowerState = (InternalEObject)currPowerState;
			currPowerState = (PowerState)eResolveProxy(oldCurrPowerState);
			if (currPowerState != oldCurrPowerState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE, oldCurrPowerState, currPowerState));
			}
		}
		return currPowerState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState basicGetCurrPowerState() {
		return currPowerState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrPowerState(PowerState newCurrPowerState) {
		PowerState oldCurrPowerState = currPowerState;
		currPowerState = newCurrPowerState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE, oldCurrPowerState, currPowerState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE:
				return basicSetMaxState(null, msgs);
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
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE:
				return getMaxState();
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				if (resolve) return getCurrPowerState();
				return basicGetCurrPowerState();
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
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE:
				setMaxState((PowerState)newValue);
				return;
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				setCurrPowerState((PowerState)newValue);
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
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE:
				setMaxState((PowerState)null);
				return;
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				setCurrPowerState((PowerState)null);
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
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__MAX_STATE:
				return maxState != null;
			case SchedulerPackage.FIXED_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				return currPowerState != null;
		}
		return super.eIsSet(featureID);
	}

} //FixedStatePowerConsumptionImpl
