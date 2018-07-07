/**
 */
package platformMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link platformMM.TerminalResource#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link platformMM.TerminalResource#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see platformMM.PlatformMMPackage#getTerminalResource()
 * @model
 * @generated
 */
public interface TerminalResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(int)
	 * @see platformMM.PlatformMMPackage#getTerminalResource_Capacity()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getCapacity();

	/**
	 * Sets the value of the '{@link platformMM.TerminalResource#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(int value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link platformMM.StateDVS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see platformMM.PlatformMMPackage#getTerminalResource_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<StateDVS> getStates();

} // TerminalResource
