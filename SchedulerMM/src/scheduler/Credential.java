/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Credential</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Credential#getAttrs <em>Attrs</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getCredential()
 * @model
 * @generated
 */
public interface Credential extends EObject {
	/**
	 * Returns the value of the '<em><b>Attrs</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attrs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attrs</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getCredential_Attrs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Attribute> getAttrs();

} // Credential
