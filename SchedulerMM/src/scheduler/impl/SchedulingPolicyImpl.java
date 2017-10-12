/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.SchedulerPackage;
import scheduler.SchedulingPolicy;
import scheduler.SchedulingPolicyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.SchedulingPolicyImpl#getPolicyRanking <em>Policy Ranking</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingPolicyImpl#isPolicyGrouping <em>Policy Grouping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingPolicyImpl extends MinimalEObjectImpl.Container implements SchedulingPolicy {
	/**
	 * The default value of the '{@link #getPolicyRanking() <em>Policy Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyRanking()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicyType POLICY_RANKING_EDEFAULT = SchedulingPolicyType.FIFO;

	/**
	 * The cached value of the '{@link #getPolicyRanking() <em>Policy Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicyRanking()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicyType policyRanking = POLICY_RANKING_EDEFAULT;

	/**
	 * The default value of the '{@link #isPolicyGrouping() <em>Policy Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPolicyGrouping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POLICY_GROUPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPolicyGrouping() <em>Policy Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPolicyGrouping()
	 * @generated
	 * @ordered
	 */
	protected boolean policyGrouping = POLICY_GROUPING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULING_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicyType getPolicyRanking() {
		return policyRanking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyRanking(SchedulingPolicyType newPolicyRanking) {
		SchedulingPolicyType oldPolicyRanking = policyRanking;
		policyRanking = newPolicyRanking == null ? POLICY_RANKING_EDEFAULT : newPolicyRanking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_POLICY__POLICY_RANKING, oldPolicyRanking, policyRanking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPolicyGrouping() {
		return policyGrouping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicyGrouping(boolean newPolicyGrouping) {
		boolean oldPolicyGrouping = policyGrouping;
		policyGrouping = newPolicyGrouping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_POLICY__POLICY_GROUPING, oldPolicyGrouping, policyGrouping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_RANKING:
				return getPolicyRanking();
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_GROUPING:
				return isPolicyGrouping();
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
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_RANKING:
				setPolicyRanking((SchedulingPolicyType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_GROUPING:
				setPolicyGrouping((Boolean)newValue);
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
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_RANKING:
				setPolicyRanking(POLICY_RANKING_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_GROUPING:
				setPolicyGrouping(POLICY_GROUPING_EDEFAULT);
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
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_RANKING:
				return policyRanking != POLICY_RANKING_EDEFAULT;
			case SchedulerPackage.SCHEDULING_POLICY__POLICY_GROUPING:
				return policyGrouping != POLICY_GROUPING_EDEFAULT;
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
		result.append(" (policyRanking: ");
		result.append(policyRanking);
		result.append(", policyGrouping: ");
		result.append(policyGrouping);
		result.append(')');
		return result.toString();
	}

} //SchedulingPolicyImpl
