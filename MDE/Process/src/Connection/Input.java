/**
 */
package Connection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Connection.Input#getData <em>Data</em>}</li>
 *   <li>{@link Connection.Input#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends EObject {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link Connection.Data}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see Connection.ProcessPackage#getInput_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Data> getData();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The literals are from the enumeration {@link Connection.LogicalOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see Connection.LogicalOperation
	 * @see #setOperation(LogicalOperation)
	 * @see Connection.ProcessPackage#getInput_Operation()
	 * @model
	 * @generated
	 */
	LogicalOperation getOperation();

	/**
	 * Sets the value of the '{@link Connection.Input#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see Connection.LogicalOperation
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(LogicalOperation value);

} // Input
