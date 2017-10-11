/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Power#getMaxState <em>Max State</em>}</li>
 *   <li>{@link scheduler.Power#getCurrPowerState <em>Curr Power State</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getPower()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Power extends EObject {
	/**
	 * Returns the value of the '<em><b>Max State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max State</em>' containment reference.
	 * @see #setMaxState(PowerState)
	 * @see scheduler.SchedulerPackage#getPower_MaxState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PowerState getMaxState();

	/**
	 * Sets the value of the '{@link scheduler.Power#getMaxState <em>Max State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max State</em>' containment reference.
	 * @see #getMaxState()
	 * @generated
	 */
	void setMaxState(PowerState value);

	/**
	 * Returns the value of the '<em><b>Curr Power State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Curr Power State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Curr Power State</em>' reference.
	 * @see #setCurrPowerState(PowerState)
	 * @see scheduler.SchedulerPackage#getPower_CurrPowerState()
	 * @model required="true"
	 * @generated
	 */
	PowerState getCurrPowerState();

	/**
	 * Sets the value of the '{@link scheduler.Power#getCurrPowerState <em>Curr Power State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Curr Power State</em>' reference.
	 * @see #getCurrPowerState()
	 * @generated
	 */
	void setCurrPowerState(PowerState value);

} // Power
