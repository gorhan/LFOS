/**
 */
package optimal.impl;

import java.util.Collection;

import optimal.Feature;
import optimal.MultiUtility;
import optimal.OptimalPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Utility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link optimal.impl.MultiUtilityImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link optimal.impl.MultiUtilityImpl#getContribution <em>Contribution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiUtilityImpl extends MinimalEObjectImpl.Container implements MultiUtility {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The default value of the '{@link #getContribution() <em>Contribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContribution()
	 * @generated
	 * @ordered
	 */
	protected static final float CONTRIBUTION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getContribution() <em>Contribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContribution()
	 * @generated
	 * @ordered
	 */
	protected float contribution = CONTRIBUTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiUtilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimalPackage.Literals.MULTI_UTILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectResolvingEList<Feature>(Feature.class, this, OptimalPackage.MULTI_UTILITY__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getContribution() {
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContribution(float newContribution) {
		float oldContribution = contribution;
		contribution = newContribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.MULTI_UTILITY__CONTRIBUTION, oldContribution, contribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimalPackage.MULTI_UTILITY__FEATURES:
				return getFeatures();
			case OptimalPackage.MULTI_UTILITY__CONTRIBUTION:
				return getContribution();
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
			case OptimalPackage.MULTI_UTILITY__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case OptimalPackage.MULTI_UTILITY__CONTRIBUTION:
				setContribution((Float)newValue);
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
			case OptimalPackage.MULTI_UTILITY__FEATURES:
				getFeatures().clear();
				return;
			case OptimalPackage.MULTI_UTILITY__CONTRIBUTION:
				setContribution(CONTRIBUTION_EDEFAULT);
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
			case OptimalPackage.MULTI_UTILITY__FEATURES:
				return features != null && !features.isEmpty();
			case OptimalPackage.MULTI_UTILITY__CONTRIBUTION:
				return contribution != CONTRIBUTION_EDEFAULT;
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
		result.append(" (contribution: ");
		result.append(contribution);
		result.append(')');
		return result.toString();
	}

} //MultiUtilityImpl
