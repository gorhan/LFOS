/**
 */
package Connection;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Resource Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Connection.ActiveResourceRequirement#getWCET <em>WCET</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getActiveResourceRequirement()
 * @model
 * @generated
 */
public interface ActiveResourceRequirement extends Requirement {
	/**
	 * Returns the value of the '<em><b>WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>WCET</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>WCET</em>' attribute.
	 * @see #setWCET(int)
	 * @see Connection.ProcessPackage#getActiveResourceRequirement_WCET()
	 * @model required="true"
	 * @generated
	 */
	int getWCET();

	/**
	 * Sets the value of the '{@link Connection.ActiveResourceRequirement#getWCET <em>WCET</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>WCET</em>' attribute.
	 * @see #getWCET()
	 * @generated
	 */
	void setWCET(int value);

} // ActiveResourceRequirement
