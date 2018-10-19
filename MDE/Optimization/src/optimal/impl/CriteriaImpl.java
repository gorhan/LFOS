/**
 */
package optimal.impl;

import java.util.Collection;

import optimal.Criteria;
import optimal.Feature;
import optimal.OptimalPackage;
import optimal.Purpose;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criteria</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link optimal.impl.CriteriaImpl#getName <em>Name</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getContribution <em>Contribution</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CriteriaImpl extends MinimalEObjectImpl.Container implements Criteria {
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
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final Purpose PURPOSE_EDEFAULT = Purpose.MINIMIZE;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected Purpose purpose = PURPOSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final float DEFAULT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected float default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getContribution() <em>Contribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContribution()
	 * @generated
	 * @ordered
	 */
	protected static final float CONTRIBUTION_EDEFAULT = 1.0F;

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
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriteriaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimalPackage.Literals.CRITERIA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.CRITERIA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Purpose getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(Purpose newPurpose) {
		Purpose oldPurpose = purpose;
		purpose = newPurpose == null ? PURPOSE_EDEFAULT : newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.CRITERIA__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(float newDefault) {
		float oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.CRITERIA__DEFAULT, oldDefault, default_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.CRITERIA__CONTRIBUTION, oldContribution, contribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, OptimalPackage.CRITERIA__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimalPackage.CRITERIA__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case OptimalPackage.CRITERIA__NAME:
				return getName();
			case OptimalPackage.CRITERIA__PURPOSE:
				return getPurpose();
			case OptimalPackage.CRITERIA__DEFAULT:
				return getDefault();
			case OptimalPackage.CRITERIA__CONTRIBUTION:
				return getContribution();
			case OptimalPackage.CRITERIA__FEATURES:
				return getFeatures();
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
			case OptimalPackage.CRITERIA__NAME:
				setName((String)newValue);
				return;
			case OptimalPackage.CRITERIA__PURPOSE:
				setPurpose((Purpose)newValue);
				return;
			case OptimalPackage.CRITERIA__DEFAULT:
				setDefault((Float)newValue);
				return;
			case OptimalPackage.CRITERIA__CONTRIBUTION:
				setContribution((Float)newValue);
				return;
			case OptimalPackage.CRITERIA__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case OptimalPackage.CRITERIA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OptimalPackage.CRITERIA__PURPOSE:
				setPurpose(PURPOSE_EDEFAULT);
				return;
			case OptimalPackage.CRITERIA__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case OptimalPackage.CRITERIA__CONTRIBUTION:
				setContribution(CONTRIBUTION_EDEFAULT);
				return;
			case OptimalPackage.CRITERIA__FEATURES:
				getFeatures().clear();
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
			case OptimalPackage.CRITERIA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OptimalPackage.CRITERIA__PURPOSE:
				return purpose != PURPOSE_EDEFAULT;
			case OptimalPackage.CRITERIA__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case OptimalPackage.CRITERIA__CONTRIBUTION:
				return contribution != CONTRIBUTION_EDEFAULT;
			case OptimalPackage.CRITERIA__FEATURES:
				return features != null && !features.isEmpty();
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
		result.append(", purpose: ");
		result.append(purpose);
		result.append(", default: ");
		result.append(default_);
		result.append(", contribution: ");
		result.append(contribution);
		result.append(')');
		return result.toString();
	}

} //CriteriaImpl
