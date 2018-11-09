/**
 */
package optimal.impl;

import optimal.Feature;
import optimal.OptimalPackage;
import optimal.SingleUtility;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Utility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link optimal.impl.SingleUtilityImpl#getBound <em>Bound</em>}</li>
 *   <li>{@link optimal.impl.SingleUtilityImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link optimal.impl.SingleUtilityImpl#getUnbound <em>Unbound</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleUtilityImpl extends MinimalEObjectImpl.Container implements SingleUtility {
	/**
	 * The default value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected static final float BOUND_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getBound() <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBound()
	 * @generated
	 * @ordered
	 */
	protected float bound = BOUND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPoints() <em>Points</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected Feature points;

	/**
	 * The default value of the '{@link #getUnbound() <em>Unbound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnbound()
	 * @generated
	 * @ordered
	 */
	protected static final float UNBOUND_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getUnbound() <em>Unbound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnbound()
	 * @generated
	 * @ordered
	 */
	protected float unbound = UNBOUND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleUtilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimalPackage.Literals.SINGLE_UTILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBound() {
		return bound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBound(float newBound) {
		float oldBound = bound;
		bound = newBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.SINGLE_UTILITY__BOUND, oldBound, bound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getPoints() {
		if (points != null && points.eIsProxy()) {
			InternalEObject oldPoints = (InternalEObject)points;
			points = (Feature)eResolveProxy(oldPoints);
			if (points != oldPoints) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimalPackage.SINGLE_UTILITY__POINTS, oldPoints, points));
			}
		}
		return points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetPoints() {
		return points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoints(Feature newPoints) {
		Feature oldPoints = points;
		points = newPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.SINGLE_UTILITY__POINTS, oldPoints, points));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUnbound() {
		return unbound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnbound(float newUnbound) {
		float oldUnbound = unbound;
		unbound = newUnbound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimalPackage.SINGLE_UTILITY__UNBOUND, oldUnbound, unbound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimalPackage.SINGLE_UTILITY__BOUND:
				return getBound();
			case OptimalPackage.SINGLE_UTILITY__POINTS:
				if (resolve) return getPoints();
				return basicGetPoints();
			case OptimalPackage.SINGLE_UTILITY__UNBOUND:
				return getUnbound();
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
			case OptimalPackage.SINGLE_UTILITY__BOUND:
				setBound((Float)newValue);
				return;
			case OptimalPackage.SINGLE_UTILITY__POINTS:
				setPoints((Feature)newValue);
				return;
			case OptimalPackage.SINGLE_UTILITY__UNBOUND:
				setUnbound((Float)newValue);
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
			case OptimalPackage.SINGLE_UTILITY__BOUND:
				setBound(BOUND_EDEFAULT);
				return;
			case OptimalPackage.SINGLE_UTILITY__POINTS:
				setPoints((Feature)null);
				return;
			case OptimalPackage.SINGLE_UTILITY__UNBOUND:
				setUnbound(UNBOUND_EDEFAULT);
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
			case OptimalPackage.SINGLE_UTILITY__BOUND:
				return bound != BOUND_EDEFAULT;
			case OptimalPackage.SINGLE_UTILITY__POINTS:
				return points != null;
			case OptimalPackage.SINGLE_UTILITY__UNBOUND:
				return unbound != UNBOUND_EDEFAULT;
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
		result.append(" (bound: ");
		result.append(bound);
		result.append(", unbound: ");
		result.append(unbound);
		result.append(')');
		return result.toString();
	}

} //SingleUtilityImpl
