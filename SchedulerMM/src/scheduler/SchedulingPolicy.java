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
 *   <li>{@link scheduler.SchedulingPolicy#getRanking <em>Ranking</em>}</li>
 *   <li>{@link scheduler.SchedulingPolicy#isGrouping <em>Grouping</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSchedulingPolicy()
 * @model
 * @generated
 */
public interface SchedulingPolicy extends EObject {
	/**
	 * Returns the value of the '<em><b>Ranking</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.SchedulingPolicyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranking</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking</em>' attribute.
	 * @see scheduler.SchedulingPolicyType
	 * @see #setRanking(SchedulingPolicyType)
	 * @see scheduler.SchedulerPackage#getSchedulingPolicy_Ranking()
	 * @model required="true"
	 * @generated
	 */
	SchedulingPolicyType getRanking();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingPolicy#getRanking <em>Ranking</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ranking</em>' attribute.
	 * @see scheduler.SchedulingPolicyType
	 * @see #getRanking()
	 * @generated
	 */
	void setRanking(SchedulingPolicyType value);

	/**
	 * Returns the value of the '<em><b>Grouping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grouping</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grouping</em>' attribute.
	 * @see #setGrouping(boolean)
	 * @see scheduler.SchedulerPackage#getSchedulingPolicy_Grouping()
	 * @model required="true"
	 * @generated
	 */
	boolean isGrouping();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingPolicy#isGrouping <em>Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grouping</em>' attribute.
	 * @see #isGrouping()
	 * @generated
	 */
	void setGrouping(boolean value);

} // SchedulingPolicy
