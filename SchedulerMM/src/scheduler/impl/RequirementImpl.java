/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.Requirement;
import scheduler.ResourceRequirement;
import scheduler.ResourceRequirementItem;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.RequirementImpl#getResourceRequirementItems <em>Resource Requirement Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementImpl extends DeadlineRequirementImpl implements Requirement {
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
	protected RequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRequirementItem> getResourceRequirementItems() {
		if (resourceRequirementItems == null) {
			resourceRequirementItems = new EObjectContainmentEList<ResourceRequirementItem>(ResourceRequirementItem.class, this, SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS);
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
			case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
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
			case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
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
			case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
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
			case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
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
			case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS:
				return resourceRequirementItems != null && !resourceRequirementItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceRequirement.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS: return SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ResourceRequirement.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.RESOURCE_REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS: return SchedulerPackage.REQUIREMENT__RESOURCE_REQUIREMENT_ITEMS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RequirementImpl
