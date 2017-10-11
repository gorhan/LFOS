/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.Priority;
import scheduler.PriorityRankingType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.PriorityImpl#getRankingType <em>Ranking Type</em>}</li>
 *   <li>{@link scheduler.impl.PriorityImpl#getPriorityValue <em>Priority Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PriorityImpl extends MinimalEObjectImpl.Container implements Priority {
	/**
	 * The default value of the '{@link #getRankingType() <em>Ranking Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRankingType()
	 * @generated
	 * @ordered
	 */
	protected static final PriorityRankingType RANKING_TYPE_EDEFAULT = PriorityRankingType.ASCENDING;

	/**
	 * The cached value of the '{@link #getRankingType() <em>Ranking Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRankingType()
	 * @generated
	 * @ordered
	 */
	protected PriorityRankingType rankingType = RANKING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriorityValue() <em>Priority Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityValue()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriorityValue() <em>Priority Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriorityValue()
	 * @generated
	 * @ordered
	 */
	protected int priorityValue = PRIORITY_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PriorityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.PRIORITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityRankingType getRankingType() {
		return rankingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRankingType(PriorityRankingType newRankingType) {
		PriorityRankingType oldRankingType = rankingType;
		rankingType = newRankingType == null ? RANKING_TYPE_EDEFAULT : newRankingType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.PRIORITY__RANKING_TYPE, oldRankingType, rankingType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriorityValue() {
		return priorityValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriorityValue(int newPriorityValue) {
		int oldPriorityValue = priorityValue;
		priorityValue = newPriorityValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.PRIORITY__PRIORITY_VALUE, oldPriorityValue, priorityValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.PRIORITY__RANKING_TYPE:
				return getRankingType();
			case SchedulerPackage.PRIORITY__PRIORITY_VALUE:
				return getPriorityValue();
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
			case SchedulerPackage.PRIORITY__RANKING_TYPE:
				setRankingType((PriorityRankingType)newValue);
				return;
			case SchedulerPackage.PRIORITY__PRIORITY_VALUE:
				setPriorityValue((Integer)newValue);
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
			case SchedulerPackage.PRIORITY__RANKING_TYPE:
				setRankingType(RANKING_TYPE_EDEFAULT);
				return;
			case SchedulerPackage.PRIORITY__PRIORITY_VALUE:
				setPriorityValue(PRIORITY_VALUE_EDEFAULT);
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
			case SchedulerPackage.PRIORITY__RANKING_TYPE:
				return rankingType != RANKING_TYPE_EDEFAULT;
			case SchedulerPackage.PRIORITY__PRIORITY_VALUE:
				return priorityValue != PRIORITY_VALUE_EDEFAULT;
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
		result.append(" (rankingType: ");
		result.append(rankingType);
		result.append(", priorityValue: ");
		result.append(priorityValue);
		result.append(')');
		return result.toString();
	}

} //PriorityImpl
