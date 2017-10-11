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

import scheduler.EligibleResource;
import scheduler.ResourceRequirementItem;
import scheduler.ResourceType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Requirement Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ResourceRequirementItemImpl#getRequiredCapacity <em>Required Capacity</em>}</li>
 *   <li>{@link scheduler.impl.ResourceRequirementItemImpl#getEligibleResourceItems <em>Eligible Resource Items</em>}</li>
 *   <li>{@link scheduler.impl.ResourceRequirementItemImpl#getRequiredResourceType <em>Required Resource Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceRequirementItemImpl extends MinimalEObjectImpl.Container implements ResourceRequirementItem {
	/**
	 * The default value of the '{@link #getRequiredCapacity() <em>Required Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRED_CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRequiredCapacity() <em>Required Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCapacity()
	 * @generated
	 * @ordered
	 */
	protected int requiredCapacity = REQUIRED_CAPACITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEligibleResourceItems() <em>Eligible Resource Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEligibleResourceItems()
	 * @generated
	 * @ordered
	 */
	protected EList<EligibleResource> eligibleResourceItems;

	/**
	 * The cached value of the '{@link #getRequiredResourceType() <em>Required Resource Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredResourceType()
	 * @generated
	 * @ordered
	 */
	protected ResourceType requiredResourceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceRequirementItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RESOURCE_REQUIREMENT_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRequiredCapacity() {
		return requiredCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredCapacity(int newRequiredCapacity) {
		int oldRequiredCapacity = requiredCapacity;
		requiredCapacity = newRequiredCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY, oldRequiredCapacity, requiredCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EligibleResource> getEligibleResourceItems() {
		if (eligibleResourceItems == null) {
			eligibleResourceItems = new EObjectContainmentEList<EligibleResource>(EligibleResource.class, this, SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS);
		}
		return eligibleResourceItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getRequiredResourceType() {
		if (requiredResourceType != null && requiredResourceType.eIsProxy()) {
			InternalEObject oldRequiredResourceType = (InternalEObject)requiredResourceType;
			requiredResourceType = (ResourceType)eResolveProxy(oldRequiredResourceType);
			if (requiredResourceType != oldRequiredResourceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE, oldRequiredResourceType, requiredResourceType));
			}
		}
		return requiredResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType basicGetRequiredResourceType() {
		return requiredResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredResourceType(ResourceType newRequiredResourceType) {
		ResourceType oldRequiredResourceType = requiredResourceType;
		requiredResourceType = newRequiredResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE, oldRequiredResourceType, requiredResourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS:
				return ((InternalEList<?>)getEligibleResourceItems()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY:
				return getRequiredCapacity();
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS:
				return getEligibleResourceItems();
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE:
				if (resolve) return getRequiredResourceType();
				return basicGetRequiredResourceType();
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
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY:
				setRequiredCapacity((Integer)newValue);
				return;
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS:
				getEligibleResourceItems().clear();
				getEligibleResourceItems().addAll((Collection<? extends EligibleResource>)newValue);
				return;
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE:
				setRequiredResourceType((ResourceType)newValue);
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
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY:
				setRequiredCapacity(REQUIRED_CAPACITY_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS:
				getEligibleResourceItems().clear();
				return;
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE:
				setRequiredResourceType((ResourceType)null);
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
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_CAPACITY:
				return requiredCapacity != REQUIRED_CAPACITY_EDEFAULT;
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__ELIGIBLE_RESOURCE_ITEMS:
				return eligibleResourceItems != null && !eligibleResourceItems.isEmpty();
			case SchedulerPackage.RESOURCE_REQUIREMENT_ITEM__REQUIRED_RESOURCE_TYPE:
				return requiredResourceType != null;
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
		result.append(" (requiredCapacity: ");
		result.append(requiredCapacity);
		result.append(')');
		return result.toString();
	}

} //ResourceRequirementItemImpl
