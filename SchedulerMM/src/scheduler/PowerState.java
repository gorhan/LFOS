/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.PowerState#getScale <em>Scale</em>}</li>
 *   <li>{@link scheduler.PowerState#getPowerConsumption <em>Power Consumption</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getPowerState()
 * @model
 * @generated
 */
public interface PowerState extends EObject {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(float)
	 * @see scheduler.SchedulerPackage#getPowerState_Scale()
	 * @model
	 * @generated
	 */
	float getScale();

	/**
	 * Sets the value of the '{@link scheduler.PowerState#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(float value);

	/**
	 * Returns the value of the '<em><b>Power Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Power Consumption</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Power Consumption</em>' attribute.
	 * @see #setPowerConsumption(float)
	 * @see scheduler.SchedulerPackage#getPowerState_PowerConsumption()
	 * @model
	 * @generated
	 */
	float getPowerConsumption();

	/**
	 * Sets the value of the '{@link scheduler.PowerState#getPowerConsumption <em>Power Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Power Consumption</em>' attribute.
	 * @see #getPowerConsumption()
	 * @generated
	 */
	void setPowerConsumption(float value);

} // PowerState
