/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Mode#getExclusiveResources <em>Exclusive Resources</em>}</li>
 *   <li>{@link scheduler.Mode#getResourceMode <em>Resource Mode</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getMode()
 * @model
 * @generated
 */
public interface Mode extends EObject {
	/**
	 * Returns the value of the '<em><b>Exclusive Resources</b></em>' reference list.
	 * The list contents are of type {@link scheduler.AbstractResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive Resources</em>' reference list.
	 * @see scheduler.SchedulerPackage#getMode_ExclusiveResources()
	 * @model
	 * @generated
	 */
	EList<AbstractResource> getExclusiveResources();

	/**
	 * Returns the value of the '<em><b>Resource Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.ResourceMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Mode</em>' attribute.
	 * @see scheduler.ResourceMode
	 * @see #setResourceMode(ResourceMode)
	 * @see scheduler.SchedulerPackage#getMode_ResourceMode()
	 * @model
	 * @generated
	 */
	ResourceMode getResourceMode();

	/**
	 * Sets the value of the '{@link scheduler.Mode#getResourceMode <em>Resource Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Mode</em>' attribute.
	 * @see scheduler.ResourceMode
	 * @see #getResourceMode()
	 * @generated
	 */
	void setResourceMode(ResourceMode value);

} // Mode
