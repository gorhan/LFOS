/**
 */
package scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource T</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.ResourceT#getPower <em>Power</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getResourceT()
 * @model
 * @generated
 */
public interface ResourceT extends AbstractResource {
	/**
	 * Returns the value of the '<em><b>Power</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Power</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power</em>' containment reference.
	 * @see #setPower(Power)
	 * @see scheduler.SchedulerPackage#getResourceT_Power()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Power getPower();

	/**
	 * Sets the value of the '{@link scheduler.ResourceT#getPower <em>Power</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power</em>' containment reference.
	 * @see #getPower()
	 * @generated
	 */
	void setPower(Power value);

} // ResourceT
