/**
 */
package Connection;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Connection.Data#getNo_available <em>No available</em>}</li>
 *   <li>{@link Connection.Data#getAlias <em>Alias</em>}</li>
 *   <li>{@link Connection.Data#getProducedBy <em>Produced By</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getData()
 * @model
 * @generated
 */
public interface Data extends EObject {
	/**
	 * Returns the value of the '<em><b>No available</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No available</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No available</em>' attribute.
	 * @see #setNo_available(int)
	 * @see Connection.ProcessPackage#getData_No_available()
	 * @model default="0"
	 * @generated
	 */
	int getNo_available();

	/**
	 * Sets the value of the '{@link Connection.Data#getNo_available <em>No available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No available</em>' attribute.
	 * @see #getNo_available()
	 * @generated
	 */
	void setNo_available(int value);

	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see Connection.ProcessPackage#getData_Alias()
	 * @model
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link Connection.Data#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Produced By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced By</em>' reference.
	 * @see #setProducedBy(Connection.Process)
	 * @see Connection.ProcessPackage#getData_ProducedBy()
	 * @model
	 * @generated
	 */
	Connection.Process getProducedBy();

	/**
	 * Sets the value of the '{@link Connection.Data#getProducedBy <em>Produced By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Produced By</em>' reference.
	 * @see #getProducedBy()
	 * @generated
	 */
	void setProducedBy(Connection.Process value);

} // Data
