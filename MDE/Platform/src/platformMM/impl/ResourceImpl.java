/**
 */
package platformMM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import platformMM.PlatformMMPackage;
import platformMM.Resource;
import platformMM.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link platformMM.impl.ResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link platformMM.impl.ResourceImpl#getExclusiveResources <em>Exclusive Resources</em>}</li>
 *   <li>{@link platformMM.impl.ResourceImpl#getBelongs <em>Belongs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ResourceImpl extends MinimalEObjectImpl.Container implements Resource {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExclusiveResources() <em>Exclusive Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusiveResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> exclusiveResources;

	/**
	 * The cached value of the '{@link #getBelongs() <em>Belongs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBelongs()
	 * @generated
	 * @ordered
	 */
	protected ResourceType belongs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformMMPackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformMMPackage.RESOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getExclusiveResources() {
		if (exclusiveResources == null) {
			exclusiveResources = new EObjectResolvingEList<Resource>(Resource.class, this, PlatformMMPackage.RESOURCE__EXCLUSIVE_RESOURCES);
		}
		return exclusiveResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getBelongs() {
		if (belongs != null && belongs.eIsProxy()) {
			InternalEObject oldBelongs = (InternalEObject)belongs;
			belongs = (ResourceType)eResolveProxy(oldBelongs);
			if (belongs != oldBelongs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PlatformMMPackage.RESOURCE__BELONGS, oldBelongs, belongs));
			}
		}
		return belongs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType basicGetBelongs() {
		return belongs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBelongs(ResourceType newBelongs) {
		ResourceType oldBelongs = belongs;
		belongs = newBelongs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformMMPackage.RESOURCE__BELONGS, oldBelongs, belongs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PlatformMMPackage.RESOURCE__NAME:
				return getName();
			case PlatformMMPackage.RESOURCE__EXCLUSIVE_RESOURCES:
				return getExclusiveResources();
			case PlatformMMPackage.RESOURCE__BELONGS:
				if (resolve) return getBelongs();
				return basicGetBelongs();
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
			case PlatformMMPackage.RESOURCE__NAME:
				setName((String)newValue);
				return;
			case PlatformMMPackage.RESOURCE__EXCLUSIVE_RESOURCES:
				getExclusiveResources().clear();
				getExclusiveResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case PlatformMMPackage.RESOURCE__BELONGS:
				setBelongs((ResourceType)newValue);
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
			case PlatformMMPackage.RESOURCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PlatformMMPackage.RESOURCE__EXCLUSIVE_RESOURCES:
				getExclusiveResources().clear();
				return;
			case PlatformMMPackage.RESOURCE__BELONGS:
				setBelongs((ResourceType)null);
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
			case PlatformMMPackage.RESOURCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PlatformMMPackage.RESOURCE__EXCLUSIVE_RESOURCES:
				return exclusiveResources != null && !exclusiveResources.isEmpty();
			case PlatformMMPackage.RESOURCE__BELONGS:
				return belongs != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ResourceImpl
