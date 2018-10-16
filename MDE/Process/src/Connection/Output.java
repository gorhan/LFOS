/**
 */
package Connection;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Connection.Output#getNo_provided <em>No provided</em>}</li>
 *   <li>{@link Connection.Output#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends EObject {
	/**
	 * Returns the value of the '<em><b>No provided</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No provided</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No provided</em>' attribute.
	 * @see #setNo_provided(int)
	 * @see Connection.ProcessPackage#getOutput_No_provided()
	 * @model
	 * @generated
	 */
	int getNo_provided();

	/**
	 * Sets the value of the '{@link Connection.Output#getNo_provided <em>No provided</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No provided</em>' attribute.
	 * @see #getNo_provided()
	 * @generated
	 */
	void setNo_provided(int value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(Data)
	 * @see Connection.ProcessPackage#getOutput_Data()
	 * @model required="true"
	 * @generated
	 */
	Data getData();

	/**
	 * Sets the value of the '{@link Connection.Output#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(Data value);

} // Output
