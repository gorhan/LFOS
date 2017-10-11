/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Objective#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link scheduler.Objective#getCriteria <em>Criteria</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getObjective()
 * @model
 * @generated
 */
public interface Objective extends EObject {
	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.ObjectivePurpose}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see scheduler.ObjectivePurpose
	 * @see #setPurpose(ObjectivePurpose)
	 * @see scheduler.SchedulerPackage#getObjective_Purpose()
	 * @model required="true"
	 * @generated
	 */
	ObjectivePurpose getPurpose();

	/**
	 * Sets the value of the '{@link scheduler.Objective#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see scheduler.ObjectivePurpose
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(ObjectivePurpose value);

	/**
	 * Returns the value of the '<em><b>Criteria</b></em>' attribute.
	 * The default value is <code>"LATENESS"</code>.
	 * The literals are from the enumeration {@link scheduler.ObjectiveCriteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criteria</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criteria</em>' attribute.
	 * @see scheduler.ObjectiveCriteria
	 * @see #setCriteria(ObjectiveCriteria)
	 * @see scheduler.SchedulerPackage#getObjective_Criteria()
	 * @model default="LATENESS" required="true"
	 * @generated
	 */
	ObjectiveCriteria getCriteria();

	/**
	 * Sets the value of the '{@link scheduler.Objective#getCriteria <em>Criteria</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criteria</em>' attribute.
	 * @see scheduler.ObjectiveCriteria
	 * @see #getCriteria()
	 * @generated
	 */
	void setCriteria(ObjectiveCriteria value);

} // Objective
