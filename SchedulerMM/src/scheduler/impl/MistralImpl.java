/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.Mistral;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mistral</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.MistralImpl#getTimeCutoff <em>Time Cutoff</em>}</li>
 *   <li>{@link scheduler.impl.MistralImpl#getVerboseLevel <em>Verbose Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MistralImpl extends MinimalEObjectImpl.Container implements Mistral {
	/**
	 * The default value of the '{@link #getTimeCutoff() <em>Time Cutoff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeCutoff()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_CUTOFF_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getTimeCutoff() <em>Time Cutoff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeCutoff()
	 * @generated
	 * @ordered
	 */
	protected int timeCutoff = TIME_CUTOFF_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerboseLevel() <em>Verbose Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerboseLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int VERBOSE_LEVEL_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getVerboseLevel() <em>Verbose Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerboseLevel()
	 * @generated
	 * @ordered
	 */
	protected int verboseLevel = VERBOSE_LEVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MistralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.MISTRAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeCutoff() {
		return timeCutoff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeCutoff(int newTimeCutoff) {
		int oldTimeCutoff = timeCutoff;
		timeCutoff = newTimeCutoff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.MISTRAL__TIME_CUTOFF, oldTimeCutoff, timeCutoff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVerboseLevel() {
		return verboseLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerboseLevel(int newVerboseLevel) {
		int oldVerboseLevel = verboseLevel;
		verboseLevel = newVerboseLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.MISTRAL__VERBOSE_LEVEL, oldVerboseLevel, verboseLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.MISTRAL__TIME_CUTOFF:
				return getTimeCutoff();
			case SchedulerPackage.MISTRAL__VERBOSE_LEVEL:
				return getVerboseLevel();
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
			case SchedulerPackage.MISTRAL__TIME_CUTOFF:
				setTimeCutoff((Integer)newValue);
				return;
			case SchedulerPackage.MISTRAL__VERBOSE_LEVEL:
				setVerboseLevel((Integer)newValue);
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
			case SchedulerPackage.MISTRAL__TIME_CUTOFF:
				setTimeCutoff(TIME_CUTOFF_EDEFAULT);
				return;
			case SchedulerPackage.MISTRAL__VERBOSE_LEVEL:
				setVerboseLevel(VERBOSE_LEVEL_EDEFAULT);
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
			case SchedulerPackage.MISTRAL__TIME_CUTOFF:
				return timeCutoff != TIME_CUTOFF_EDEFAULT;
			case SchedulerPackage.MISTRAL__VERBOSE_LEVEL:
				return verboseLevel != VERBOSE_LEVEL_EDEFAULT;
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
		result.append(" (timeCutoff: ");
		result.append(timeCutoff);
		result.append(", verboseLevel: ");
		result.append(verboseLevel);
		result.append(')');
		return result.toString();
	}

} //MistralImpl
