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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.ContinuousStatePowerConsumption;
import scheduler.PowerState;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Continuous State Power Consumption</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ContinuousStatePowerConsumptionImpl#getMaxState <em>Max State</em>}</li>
 *   <li>{@link scheduler.impl.ContinuousStatePowerConsumptionImpl#getCurrPowerState <em>Curr Power State</em>}</li>
 *   <li>{@link scheduler.impl.ContinuousStatePowerConsumptionImpl#getMinState <em>Min State</em>}</li>
 *   <li>{@link scheduler.impl.ContinuousStatePowerConsumptionImpl#getRunnableStates <em>Runnable States</em>}</li>
 *   <li>{@link scheduler.impl.ContinuousStatePowerConsumptionImpl#getScalePrecision <em>Scale Precision</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContinuousStatePowerConsumptionImpl extends MinimalEObjectImpl.Container implements ContinuousStatePowerConsumption {
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
	 * The cached value of the '{@link #getMinState() <em>Min State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinState()
	 * @generated
	 * @ordered
	 */
	protected PowerState minState;

	/**
	 * The cached value of the '{@link #getRunnableStates() <em>Runnable States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnableStates()
	 * @generated
	 * @ordered
	 */
	protected EList<PowerState> runnableStates;

	/**
	 * The default value of the '{@link #getScalePrecision() <em>Scale Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalePrecision()
	 * @generated
	 * @ordered
	 */
	protected static final float SCALE_PRECISION_EDEFAULT = 0.1F;

	/**
	 * The cached value of the '{@link #getScalePrecision() <em>Scale Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScalePrecision()
	 * @generated
	 * @ordered
	 */
	protected float scalePrecision = SCALE_PRECISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContinuousStatePowerConsumptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.CONTINUOUS_STATE_POWER_CONSUMPTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE, oldMaxState, newMaxState);
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
				msgs = ((InternalEObject)maxState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE, null, msgs);
			if (newMaxState != null)
				msgs = ((InternalEObject)newMaxState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE, null, msgs);
			msgs = basicSetMaxState(newMaxState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE, newMaxState, newMaxState));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE, oldCurrPowerState, currPowerState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE, oldCurrPowerState, currPowerState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerState getMinState() {
		return minState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinState(PowerState newMinState, NotificationChain msgs) {
		PowerState oldMinState = minState;
		minState = newMinState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE, oldMinState, newMinState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinState(PowerState newMinState) {
		if (newMinState != minState) {
			NotificationChain msgs = null;
			if (minState != null)
				msgs = ((InternalEObject)minState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE, null, msgs);
			if (newMinState != null)
				msgs = ((InternalEObject)newMinState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE, null, msgs);
			msgs = basicSetMinState(newMinState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE, newMinState, newMinState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PowerState> getRunnableStates() {
		if (runnableStates == null) {
			runnableStates = new EObjectContainmentEList<PowerState>(PowerState.class, this, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES);
		}
		return runnableStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScalePrecision() {
		return scalePrecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScalePrecision(float newScalePrecision) {
		float oldScalePrecision = scalePrecision;
		scalePrecision = newScalePrecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION, oldScalePrecision, scalePrecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE:
				return basicSetMaxState(null, msgs);
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE:
				return basicSetMinState(null, msgs);
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES:
				return ((InternalEList<?>)getRunnableStates()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE:
				return getMaxState();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				if (resolve) return getCurrPowerState();
				return basicGetCurrPowerState();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE:
				return getMinState();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES:
				return getRunnableStates();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION:
				return getScalePrecision();
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
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE:
				setMaxState((PowerState)newValue);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				setCurrPowerState((PowerState)newValue);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE:
				setMinState((PowerState)newValue);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES:
				getRunnableStates().clear();
				getRunnableStates().addAll((Collection<? extends PowerState>)newValue);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION:
				setScalePrecision((Float)newValue);
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
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE:
				setMaxState((PowerState)null);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				setCurrPowerState((PowerState)null);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE:
				setMinState((PowerState)null);
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES:
				getRunnableStates().clear();
				return;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION:
				setScalePrecision(SCALE_PRECISION_EDEFAULT);
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
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MAX_STATE:
				return maxState != null;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__CURR_POWER_STATE:
				return currPowerState != null;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__MIN_STATE:
				return minState != null;
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__RUNNABLE_STATES:
				return runnableStates != null && !runnableStates.isEmpty();
			case SchedulerPackage.CONTINUOUS_STATE_POWER_CONSUMPTION__SCALE_PRECISION:
				return scalePrecision != SCALE_PRECISION_EDEFAULT;
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
		result.append(" (scalePrecision: ");
		result.append(scalePrecision);
		result.append(')');
		return result.toString();
	}

} //ContinuousStatePowerConsumptionImpl
