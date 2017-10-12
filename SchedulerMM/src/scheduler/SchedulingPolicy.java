/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.SchedulingPolicy#getPolicyRanking <em>Policy Ranking</em>}</li>
 *   <li>{@link scheduler.SchedulingPolicy#isPolicyGrouping <em>Policy Grouping</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSchedulingPolicy()
 * @model
 * @generated
 */
public interface SchedulingPolicy extends EObject {
	/**
	 * Returns the value of the '<em><b>Policy Ranking</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.SchedulingPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Ranking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Ranking</em>' attribute.
	 * @see scheduler.SchedulingPolicyType
	 * @see #setPolicyRanking(SchedulingPolicyType)
	 * @see scheduler.SchedulerPackage#getSchedulingPolicy_PolicyRanking()
	 * @model required="true"
	 * @generated
	 */
	SchedulingPolicyType getPolicyRanking();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingPolicy#getPolicyRanking <em>Policy Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Ranking</em>' attribute.
	 * @see scheduler.SchedulingPolicyType
	 * @see #getPolicyRanking()
	 * @generated
	 */
	void setPolicyRanking(SchedulingPolicyType value);

	/**
	 * Returns the value of the '<em><b>Policy Grouping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policy Grouping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Grouping</em>' attribute.
	 * @see #setPolicyGrouping(boolean)
	 * @see scheduler.SchedulerPackage#getSchedulingPolicy_PolicyGrouping()
	 * @model required="true"
	 * @generated
	 */
	boolean isPolicyGrouping();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingPolicy#isPolicyGrouping <em>Policy Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy Grouping</em>' attribute.
	 * @see #isPolicyGrouping()
	 * @generated
	 */
	void setPolicyGrouping(boolean value);

} // SchedulingPolicy
