/**
 */
package platformMM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import platformMM.PlatformMMPackage;
import platformMM.ResourceAbstraction;
import platformMM.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link platformMM.impl.ResourceTypeImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link platformMM.impl.ResourceTypeImpl#getAbstraction <em>Abstraction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceTypeImpl extends MinimalEObjectImpl.Container implements ResourceType {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAbstraction() <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstraction()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceAbstraction ABSTRACTION_EDEFAULT = ResourceAbstraction.COMPOSITE;

	/**
	 * The cached value of the '{@link #getAbstraction() <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstraction()
	 * @generated
	 * @ordered
	 */
	protected ResourceAbstraction abstraction = ABSTRACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformMMPackage.Literals.RESOURCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformMMPackage.RESOURCE_TYPE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAbstraction getAbstraction() {
		return abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstraction(ResourceAbstraction newAbstraction) {
		ResourceAbstraction oldAbstraction = abstraction;
		abstraction = newAbstraction == null ? ABSTRACTION_EDEFAULT : newAbstraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformMMPackage.RESOURCE_TYPE__ABSTRACTION, oldAbstraction, abstraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PlatformMMPackage.RESOURCE_TYPE__IDENTIFIER:
				return getIdentifier();
			case PlatformMMPackage.RESOURCE_TYPE__ABSTRACTION:
				return getAbstraction();
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
			case PlatformMMPackage.RESOURCE_TYPE__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case PlatformMMPackage.RESOURCE_TYPE__ABSTRACTION:
				setAbstraction((ResourceAbstraction)newValue);
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
			case PlatformMMPackage.RESOURCE_TYPE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case PlatformMMPackage.RESOURCE_TYPE__ABSTRACTION:
				setAbstraction(ABSTRACTION_EDEFAULT);
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
			case PlatformMMPackage.RESOURCE_TYPE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case PlatformMMPackage.RESOURCE_TYPE__ABSTRACTION:
				return abstraction != ABSTRACTION_EDEFAULT;
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", abstraction: ");
		result.append(abstraction);
		result.append(')');
		return result.toString();
	}

} //ResourceTypeImpl
