/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scalable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Scalable#getMinState <em>Min State</em>}</li>
 *   <li>{@link scheduler.Scalable#getRunnableStates <em>Runnable States</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getScalable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Scalable extends Power {
	/**
	 * Returns the value of the '<em><b>Min State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min State</em>' containment reference.
	 * @see #setMinState(PowerState)
	 * @see scheduler.SchedulerPackage#getScalable_MinState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PowerState getMinState();

	/**
	 * Sets the value of the '{@link scheduler.Scalable#getMinState <em>Min State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min State</em>' containment reference.
	 * @see #getMinState()
	 * @generated
	 */
	void setMinState(PowerState value);

	/**
	 * Returns the value of the '<em><b>Runnable States</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.PowerState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable States</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getScalable_RunnableStates()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PowerState> getRunnableStates();

} // Scalable
