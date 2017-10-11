/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.ResourceRequirement;
import scheduler.ResourceRequirementItem;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ResourceRequirementImpl#getResourceRequirementItems <em>Resource Requirement Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceRequirementImpl extends MinimalEObjectImpl.Container implements ResourceRequirement {
	/**
	 * The cached value of the '{@link #getResourceRequirementItems() <em>Resource Requirement Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequirementItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRequirementItem> resourceRequirementItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RESOURCE_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequirementItem> getResourceRequirementItems() {
		if (resourceRequirementItems == null) {
			resourceRequirementItems = new EObjectContainmentEList<ResourceRequirementItem>(ResourceRequirementItem.class, this, SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS);
		}
		return resourceRequirementItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				return ((InternalEList<?>)getResourceRequirementItems()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				return getResourceRequirementItems();
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
			case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				getResourceRequirementItems().clear();
				getResourceRequirementItems().addAll((Collection<? extends ResourceRequirementItem>)newValue);
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
			case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				getResourceRequirementItems().clear();
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
			case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				return resourceRequirementItems != null && !resourceRequirementItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceRequirementImpl
