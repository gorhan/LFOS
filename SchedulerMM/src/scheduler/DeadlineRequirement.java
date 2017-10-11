/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deadline Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.DeadlineRequirement#getDeadlineType <em>Deadline Type</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getDeadlineRequirement()
 * @model
 * @generated
 */
public interface DeadlineRequirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Deadline Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.DeadlineType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline Type</em>' attribute.
	 * @see scheduler.DeadlineType
	 * @see #setDeadlineType(DeadlineType)
	 * @see scheduler.SchedulerPackage#getDeadlineRequirement_DeadlineType()
	 * @model
	 * @generated
	 */
	DeadlineType getDeadlineType();

	/**
	 * Sets the value of the '{@link scheduler.DeadlineRequirement#getDeadlineType <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline Type</em>' attribute.
	 * @see scheduler.DeadlineType
	 * @see #getDeadlineType()
	 * @generated
	 */
	void setDeadlineType(DeadlineType value);

} // DeadlineRequirement
