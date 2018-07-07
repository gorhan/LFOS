/**
 */
package platformMM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import platformMM.CompositeResource;
import platformMM.PlatformMMPackage;
import platformMM.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link platformMM.impl.CompositeResourceImpl#getChilds <em>Childs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeResourceImpl extends ResourceImpl implements CompositeResource {
	/**
	 * The cached value of the '{@link #getChilds() <em>Childs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChilds()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> childs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformMMPackage.Literals.COMPOSITE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getChilds() {
		if (childs == null) {
			childs = new EObjectContainmentEList<Resource>(Resource.class, this, PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS);
		}
		return childs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS:
				return ((InternalEList<?>)getChilds()).basicRemove(otherEnd, msgs);
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
			case PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS:
				return getChilds();
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
			case PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS:
				getChilds().clear();
				getChilds().addAll((Collection<? extends Resource>)newValue);
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
			case PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS:
				getChilds().clear();
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
			case PlatformMMPackage.COMPOSITE_RESOURCE__CHILDS:
				return childs != null && !childs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeResourceImpl
