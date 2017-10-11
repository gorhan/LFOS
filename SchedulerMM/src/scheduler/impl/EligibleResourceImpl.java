/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.AbstractResource;
import scheduler.EligibleResource;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eligible Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.EligibleResourceImpl#getWcetOnResource <em>Wcet On Resource</em>}</li>
 *   <li>{@link scheduler.impl.EligibleResourceImpl#getEligibleResourcePtr <em>Eligible Resource Ptr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EligibleResourceImpl extends MinimalEObjectImpl.Container implements EligibleResource {
	/**
	 * The default value of the '{@link #getWcetOnResource() <em>Wcet On Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcetOnResource()
	 * @generated
	 * @ordered
	 */
	protected static final int WCET_ON_RESOURCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWcetOnResource() <em>Wcet On Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcetOnResource()
	 * @generated
	 * @ordered
	 */
	protected int wcetOnResource = WCET_ON_RESOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEligibleResourcePtr() <em>Eligible Resource Ptr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEligibleResourcePtr()
	 * @generated
	 * @ordered
	 */
	protected AbstractResource eligibleResourcePtr;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EligibleResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.ELIGIBLE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWcetOnResource() {
		return wcetOnResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWcetOnResource(int newWcetOnResource) {
		int oldWcetOnResource = wcetOnResource;
		wcetOnResource = newWcetOnResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.ELIGIBLE_RESOURCE__WCET_ON_RESOURCE, oldWcetOnResource, wcetOnResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResource getEligibleResourcePtr() {
		if (eligibleResourcePtr != null && eligibleResourcePtr.eIsProxy()) {
			InternalEObject oldEligibleResourcePtr = (InternalEObject)eligibleResourcePtr;
			eligibleResourcePtr = (AbstractResource)eResolveProxy(oldEligibleResourcePtr);
			if (eligibleResourcePtr != oldEligibleResourcePtr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR, oldEligibleResourcePtr, eligibleResourcePtr));
			}
		}
		return eligibleResourcePtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResource basicGetEligibleResourcePtr() {
		return eligibleResourcePtr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEligibleResourcePtr(AbstractResource newEligibleResourcePtr) {
		AbstractResource oldEligibleResourcePtr = eligibleResourcePtr;
		eligibleResourcePtr = newEligibleResourcePtr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR, oldEligibleResourcePtr, eligibleResourcePtr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.ELIGIBLE_RESOURCE__WCET_ON_RESOURCE:
				return getWcetOnResource();
			case SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR:
				if (resolve) return getEligibleResourcePtr();
				return basicGetEligibleResourcePtr();
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
			case SchedulerPackage.ELIGIBLE_RESOURCE__WCET_ON_RESOURCE:
				setWcetOnResource((Integer)newValue);
				return;
			case SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR:
				setEligibleResourcePtr((AbstractResource)newValue);
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
			case SchedulerPackage.ELIGIBLE_RESOURCE__WCET_ON_RESOURCE:
				setWcetOnResource(WCET_ON_RESOURCE_EDEFAULT);
				return;
			case SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR:
				setEligibleResourcePtr((AbstractResource)null);
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
			case SchedulerPackage.ELIGIBLE_RESOURCE__WCET_ON_RESOURCE:
				return wcetOnResource != WCET_ON_RESOURCE_EDEFAULT;
			case SchedulerPackage.ELIGIBLE_RESOURCE__ELIGIBLE_RESOURCE_PTR:
				return eligibleResourcePtr != null;
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
		result.append(" (wcetOnResource: ");
		result.append(wcetOnResource);
		result.append(')');
		return result.toString();
	}

} //EligibleResourceImpl
