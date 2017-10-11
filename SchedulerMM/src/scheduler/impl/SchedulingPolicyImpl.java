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
 *   <li>{@link scheduler.impl.SchedulingPolicyImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingPolicyImpl#isGrouping <em>Grouping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingPolicyImpl extends MinimalEObjectImpl.Container implements SchedulingPolicy {
	/**
	 * The default value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicyType RANKING_EDEFAULT = SchedulingPolicyType.FIFO;

	/**
	 * The cached value of the '{@link #getRanking() <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicyType ranking = RANKING_EDEFAULT;

	/**
	 * The default value of the '{@link #isGrouping() <em>Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrouping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GROUPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGrouping() <em>Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGrouping()
	 * @generated
	 * @ordered
	 */
	protected boolean grouping = GROUPING_EDEFAULT;

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
	public SchedulingPolicyType getRanking() {
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRanking(SchedulingPolicyType newRanking) {
		SchedulingPolicyType oldRanking = ranking;
		ranking = newRanking == null ? RANKING_EDEFAULT : newRanking;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_POLICY__RANKING, oldRanking, ranking));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrouping() {
		return grouping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrouping(boolean newGrouping) {
		boolean oldGrouping = grouping;
		grouping = newGrouping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_POLICY__GROUPING, oldGrouping, grouping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULING_POLICY__RANKING:
				return getRanking();
			case SchedulerPackage.SCHEDULING_POLICY__GROUPING:
				return isGrouping();
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
			case SchedulerPackage.SCHEDULING_POLICY__RANKING:
				setRanking((SchedulingPolicyType)newValue);
				return;
			case SchedulerPackage.SCHEDULING_POLICY__GROUPING:
				setGrouping((Boolean)newValue);
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
			case SchedulerPackage.SCHEDULING_POLICY__RANKING:
				setRanking(RANKING_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULING_POLICY__GROUPING:
				setGrouping(GROUPING_EDEFAULT);
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
			case SchedulerPackage.SCHEDULING_POLICY__RANKING:
				return ranking != RANKING_EDEFAULT;
			case SchedulerPackage.SCHEDULING_POLICY__GROUPING:
				return grouping != GROUPING_EDEFAULT;
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
		result.append(" (ranking: ");
		result.append(ranking);
		result.append(", grouping: ");
		result.append(grouping);
		result.append(')');
		return result.toString();
	}

} //SchedulingPolicyImpl
