/**
 */
package platformMM.impl;

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

import platformMM.CompositeResource;
import platformMM.PlatformDiagram;
import platformMM.PlatformMMPackage;
import platformMM.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Platform Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link platformMM.impl.PlatformDiagramImpl#getSystem <em>System</em>}</li>
 *   <li>{@link platformMM.impl.PlatformDiagramImpl#getResourceTypes <em>Resource Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlatformDiagramImpl extends MinimalEObjectImpl.Container implements PlatformDiagram {
	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected CompositeResource system;

	/**
	 * The cached value of the '{@link #getResourceTypes() <em>Resource Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceType> resourceTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformMMPackage.Literals.PLATFORM_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeResource getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(CompositeResource newSystem, NotificationChain msgs) {
		CompositeResource oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM, oldSystem, newSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(CompositeResource newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceType> getResourceTypes() {
		if (resourceTypes == null) {
			resourceTypes = new EObjectContainmentEList<ResourceType>(ResourceType.class, this, PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES);
		}
		return resourceTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM:
				return basicSetSystem(null, msgs);
			case PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES:
				return ((InternalEList<?>)getResourceTypes()).basicRemove(otherEnd, msgs);
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
			case PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM:
				return getSystem();
			case PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES:
				return getResourceTypes();
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
			case PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM:
				setSystem((CompositeResource)newValue);
				return;
			case PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES:
				getResourceTypes().clear();
				getResourceTypes().addAll((Collection<? extends ResourceType>)newValue);
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
			case PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM:
				setSystem((CompositeResource)null);
				return;
			case PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES:
				getResourceTypes().clear();
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
			case PlatformMMPackage.PLATFORM_DIAGRAM__SYSTEM:
				return system != null;
			case PlatformMMPackage.PLATFORM_DIAGRAM__RESOURCE_TYPES:
				return resourceTypes != null && !resourceTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PlatformDiagramImpl
