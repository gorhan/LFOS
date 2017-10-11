/**
 */
package scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Continuous State Power Consumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.ContinuousStatePowerConsumption#getScalePrecision <em>Scale Precision</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getContinuousStatePowerConsumption()
 * @model
 * @generated
 */
public interface ContinuousStatePowerConsumption extends Scalable {
	/**
	 * Returns the value of the '<em><b>Scale Precision</b></em>' attribute.
	 * The default value is <code>"0.1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale Precision</em>' attribute.
	 * @see #setScalePrecision(float)
	 * @see scheduler.SchedulerPackage#getContinuousStatePowerConsumption_ScalePrecision()
	 * @model default="0.1" required="true"
	 * @generated
	 */
	float getScalePrecision();

	/**
	 * Sets the value of the '{@link scheduler.ContinuousStatePowerConsumption#getScalePrecision <em>Scale Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale Precision</em>' attribute.
	 * @see #getScalePrecision()
	 * @generated
	 */
	void setScalePrecision(float value);

} // ContinuousStatePowerConsumption
