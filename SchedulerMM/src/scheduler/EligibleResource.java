/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eligible Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.EligibleResource#getWcetOnResource <em>Wcet On Resource</em>}</li>
 *   <li>{@link scheduler.EligibleResource#getEligibleResourcePtr <em>Eligible Resource Ptr</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getEligibleResource()
 * @model
 * @generated
 */
public interface EligibleResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Wcet On Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wcet On Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wcet On Resource</em>' attribute.
	 * @see #setWcetOnResource(int)
	 * @see scheduler.SchedulerPackage#getEligibleResource_WcetOnResource()
	 * @model
	 * @generated
	 */
	int getWcetOnResource();

	/**
	 * Sets the value of the '{@link scheduler.EligibleResource#getWcetOnResource <em>Wcet On Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wcet On Resource</em>' attribute.
	 * @see #getWcetOnResource()
	 * @generated
	 */
	void setWcetOnResource(int value);

	/**
	 * Returns the value of the '<em><b>Eligible Resource Ptr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eligible Resource Ptr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eligible Resource Ptr</em>' reference.
	 * @see #setEligibleResourcePtr(AbstractResource)
	 * @see scheduler.SchedulerPackage#getEligibleResource_EligibleResourcePtr()
	 * @model required="true"
	 * @generated
	 */
	AbstractResource getEligibleResourcePtr();

	/**
	 * Sets the value of the '{@link scheduler.EligibleResource#getEligibleResourcePtr <em>Eligible Resource Ptr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eligible Resource Ptr</em>' reference.
	 * @see #getEligibleResourcePtr()
	 * @generated
	 */
	void setEligibleResourcePtr(AbstractResource value);

} // EligibleResource
