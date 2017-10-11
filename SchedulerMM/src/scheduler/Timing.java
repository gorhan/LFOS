/**
 */
package scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Timing#getReleaseTime <em>Release Time</em>}</li>
 *   <li>{@link scheduler.Timing#getExecutionTime <em>Execution Time</em>}</li>
 *   <li>{@link scheduler.Timing#getDeadline <em>Deadline</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getTiming()
 * @model
 * @generated
 */
public interface Timing extends Periodicity {
	/**
	 * Returns the value of the '<em><b>Release Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Time</em>' attribute.
	 * @see #setReleaseTime(int)
	 * @see scheduler.SchedulerPackage#getTiming_ReleaseTime()
	 * @model
	 * @generated
	 */
	int getReleaseTime();

	/**
	 * Sets the value of the '{@link scheduler.Timing#getReleaseTime <em>Release Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Time</em>' attribute.
	 * @see #getReleaseTime()
	 * @generated
	 */
	void setReleaseTime(int value);

	/**
	 * Returns the value of the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Time</em>' attribute.
	 * @see #setExecutionTime(int)
	 * @see scheduler.SchedulerPackage#getTiming_ExecutionTime()
	 * @model required="true"
	 * @generated
	 */
	int getExecutionTime();

	/**
	 * Sets the value of the '{@link scheduler.Timing#getExecutionTime <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Time</em>' attribute.
	 * @see #getExecutionTime()
	 * @generated
	 */
	void setExecutionTime(int value);

	/**
	 * Returns the value of the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline</em>' attribute.
	 * @see #setDeadline(int)
	 * @see scheduler.SchedulerPackage#getTiming_Deadline()
	 * @model
	 * @generated
	 */
	int getDeadline();

	/**
	 * Sets the value of the '{@link scheduler.Timing#getDeadline <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' attribute.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(int value);

} // Timing
