/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Priority#getRankingType <em>Ranking Type</em>}</li>
 *   <li>{@link scheduler.Priority#getPriorityValue <em>Priority Value</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getPriority()
 * @model
 * @generated
 */
public interface Priority extends EObject {
	/**
	 * Returns the value of the '<em><b>Ranking Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.PriorityRankingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ranking Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking Type</em>' attribute.
	 * @see scheduler.PriorityRankingType
	 * @see #setRankingType(PriorityRankingType)
	 * @see scheduler.SchedulerPackage#getPriority_RankingType()
	 * @model unique="false" required="true"
	 * @generated
	 */
	PriorityRankingType getRankingType();

	/**
	 * Sets the value of the '{@link scheduler.Priority#getRankingType <em>Ranking Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ranking Type</em>' attribute.
	 * @see scheduler.PriorityRankingType
	 * @see #getRankingType()
	 * @generated
	 */
	void setRankingType(PriorityRankingType value);

	/**
	 * Returns the value of the '<em><b>Priority Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Value</em>' attribute.
	 * @see #setPriorityValue(int)
	 * @see scheduler.SchedulerPackage#getPriority_PriorityValue()
	 * @model required="true"
	 * @generated
	 */
	int getPriorityValue();

	/**
	 * Sets the value of the '{@link scheduler.Priority#getPriorityValue <em>Priority Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Value</em>' attribute.
	 * @see #getPriorityValue()
	 * @generated
	 */
	void setPriorityValue(int value);

} // Priority
