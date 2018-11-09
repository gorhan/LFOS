/**
 */
package optimal.impl;

import java.util.Collection;

import optimal.Criteria;
import optimal.MultiUtility;
import optimal.OptimalPackage;
import optimal.Purpose;
import optimal.SingleUtility;

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
 *   <li>{@link optimal.impl.CriteriaImpl#getMultiutility <em>Multiutility</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getSingleutility <em>Singleutility</em>}</li>
 *   <li>{@link optimal.impl.CriteriaImpl#getPercentage <em>Percentage</em>}</li>
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
	 * The cached value of the '{@link #getMultiutility() <em>Multiutility</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiutility()
	 * @generated
	 * @ordered
	 */
	protected EList<MultiUtility> multiutility;

	/**
	 * The cached value of the '{@link #getSingleutility() <em>Singleutility</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleutility()
	 * @generated
	 * @ordered
	 */
	protected EList<SingleUtility> singleutility;

	/**
	 * The default value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final float PERCENTAGE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected float percentage = PERCENTAGE_EDEFAULT;

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
	public EList<MultiUtility> getMultiutility() {
		if (multiutility == null) {
			multiutility = new EObjectContainmentEList<MultiUtility>(MultiUtility.class, this, OptimalPackage.CRITERIA__MULTIUTILITY);
		}
		return multiutility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SingleUtility> getSingleutility() {
		if (singleutility == null) {
			singleutility = new EObjectContainmentEList<SingleUtility>(SingleUtility.class, this, OptimalPackage.CRITERIA__SINGLEUTILITY);
		}
		return singleutility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPercentage() {
		return percentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentage(float newPercentage) {
		float oldPercentage = percentage;
		percentage = newPercentage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.CRITERIA__PERCENTAGE, oldPercentage, percentage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimalPackage.CRITERIA__MULTIUTILITY:
				return ((InternalEList<?>)getMultiutility()).basicRemove(otherEnd, msgs);
			case OptimalPackage.CRITERIA__SINGLEUTILITY:
				return ((InternalEList<?>)getSingleutility()).basicRemove(otherEnd, msgs);
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
			case OptimalPackage.CRITERIA__MULTIUTILITY:
				return getMultiutility();
			case OptimalPackage.CRITERIA__SINGLEUTILITY:
				return getSingleutility();
			case OptimalPackage.CRITERIA__PERCENTAGE:
				return getPercentage();
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
			case OptimalPackage.CRITERIA__MULTIUTILITY:
				getMultiutility().clear();
				getMultiutility().addAll((Collection<? extends MultiUtility>)newValue);
				return;
			case OptimalPackage.CRITERIA__SINGLEUTILITY:
				getSingleutility().clear();
				getSingleutility().addAll((Collection<? extends SingleUtility>)newValue);
				return;
			case OptimalPackage.CRITERIA__PERCENTAGE:
				setPercentage((Float)newValue);
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
			case OptimalPackage.CRITERIA__MULTIUTILITY:
				getMultiutility().clear();
				return;
			case OptimalPackage.CRITERIA__SINGLEUTILITY:
				getSingleutility().clear();
				return;
			case OptimalPackage.CRITERIA__PERCENTAGE:
				setPercentage(PERCENTAGE_EDEFAULT);
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
			case OptimalPackage.CRITERIA__MULTIUTILITY:
				return multiutility != null && !multiutility.isEmpty();
			case OptimalPackage.CRITERIA__SINGLEUTILITY:
				return singleutility != null && !singleutility.isEmpty();
			case OptimalPackage.CRITERIA__PERCENTAGE:
				return percentage != PERCENTAGE_EDEFAULT;
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
		result.append(", percentage: ");
		result.append(percentage);
		result.append(')');
		return result.toString();
	}

} //CriteriaImpl
