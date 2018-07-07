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
 *   <li>{@link Connection.Data#getAmount <em>Amount</em>}</li>
 *   <li>{@link Connection.Data#getProducedBy <em>Produced By</em>}</li>
 * </ul>
 *
 * @see Connection.ProcessPackage#getData()
 * @model
 * @generated
 */
public interface Data extends EObject {
	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(int)
	 * @see Connection.ProcessPackage#getData_Amount()
	 * @model default="1"
	 * @generated
	 */
	int getAmount();

	/**
	 * Sets the value of the '{@link Connection.Data#getAmount <em>Amount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(int value);

	/**
	 * Returns the value of the '<em><b>Produced By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced By</em>' reference.
	 * @see #setProducedBy(ProcessNode)
	 * @see Connection.ProcessPackage#getData_ProducedBy()
	 * @model required="true"
	 * @generated
	 */
	ProcessNode getProducedBy();

	/**
	 * Sets the value of the '{@link Connection.Data#getProducedBy <em>Produced By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Produced By</em>' reference.
	 * @see #getProducedBy()
	 * @generated
	 */
	void setProducedBy(ProcessNode value);

} // Data
