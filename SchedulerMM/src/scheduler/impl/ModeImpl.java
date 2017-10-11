/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import scheduler.AbstractResource;
import scheduler.Mode;
import scheduler.ResourceMode;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ModeImpl#getExclusiveResources <em>Exclusive Resources</em>}</li>
 *   <li>{@link scheduler.impl.ModeImpl#getResourceMode <em>Resource Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeImpl extends MinimalEObjectImpl.Container implements Mode {
	/**
	 * The cached value of the '{@link #getExclusiveResources() <em>Exclusive Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusiveResources()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractResource> exclusiveResources;

	/**
	 * The default value of the '{@link #getResourceMode() <em>Resource Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceMode()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceMode RESOURCE_MODE_EDEFAULT = ResourceMode.SHARED;

	/**
	 * The cached value of the '{@link #getResourceMode() <em>Resource Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceMode()
	 * @generated
	 * @ordered
	 */
	protected ResourceMode resourceMode = RESOURCE_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractResource> getExclusiveResources() {
		if (exclusiveResources == null) {
			exclusiveResources = new EObjectResolvingEList<AbstractResource>(AbstractResource.class, this, SchedulerPackage.MODE__EXCLUSIVE_RESOURCES);
		}
		return exclusiveResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceMode getResourceMode() {
		return resourceMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceMode(ResourceMode newResourceMode) {
		ResourceMode oldResourceMode = resourceMode;
		resourceMode = newResourceMode == null ? RESOURCE_MODE_EDEFAULT : newResourceMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.MODE__RESOURCE_MODE, oldResourceMode, resourceMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.MODE__EXCLUSIVE_RESOURCES:
				return getExclusiveResources();
			case SchedulerPackage.MODE__RESOURCE_MODE:
				return getResourceMode();
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
			case SchedulerPackage.MODE__EXCLUSIVE_RESOURCES:
				getExclusiveResources().clear();
				getExclusiveResources().addAll((Collection<? extends AbstractResource>)newValue);
				return;
			case SchedulerPackage.MODE__RESOURCE_MODE:
				setResourceMode((ResourceMode)newValue);
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
			case SchedulerPackage.MODE__EXCLUSIVE_RESOURCES:
				getExclusiveResources().clear();
				return;
			case SchedulerPackage.MODE__RESOURCE_MODE:
				setResourceMode(RESOURCE_MODE_EDEFAULT);
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
			case SchedulerPackage.MODE__EXCLUSIVE_RESOURCES:
				return exclusiveResources != null && !exclusiveResources.isEmpty();
			case SchedulerPackage.MODE__RESOURCE_MODE:
				return resourceMode != RESOURCE_MODE_EDEFAULT;
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
		result.append(" (resourceMode: ");
		result.append(resourceMode);
		result.append(')');
		return result.toString();
	}

} //ModeImpl
