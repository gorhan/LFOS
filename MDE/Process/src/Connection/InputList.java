/**
 */
package Connection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Connection.InputList#getOperation <em>Operation</em>}</li>
 *   <li>{@link Connection.InputList#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getInputList()
 * @model
 * @generated
 */
public interface InputList extends EObject {
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
	 * @see Connection.ProcessPackage#getInputList_Operation()
	 * @model
	 * @generated
	 */
	LogicalOperation getOperation();

	/**
	 * Sets the value of the '{@link Connection.InputList#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see Connection.LogicalOperation
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(LogicalOperation value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference list.
	 * The list contents are of type {@link Connection.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference list.
	 * @see Connection.ProcessPackage#getInputList_Item()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Input> getItem();

} // InputList
