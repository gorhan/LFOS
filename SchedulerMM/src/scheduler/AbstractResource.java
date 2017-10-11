/**
 */
package scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.AbstractResource#isRenewable <em>Renewable</em>}</li>
 *   <li>{@link scheduler.AbstractResource#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.AbstractResource#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link scheduler.AbstractResource#getBelongs <em>Belongs</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getAbstractResource()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AbstractResource extends Mode {
	/**
	 * Returns the value of the '<em><b>Renewable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renewable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renewable</em>' attribute.
	 * @see #setRenewable(boolean)
	 * @see scheduler.SchedulerPackage#getAbstractResource_Renewable()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isRenewable();

	/**
	 * Sets the value of the '{@link scheduler.AbstractResource#isRenewable <em>Renewable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renewable</em>' attribute.
	 * @see #isRenewable()
	 * @generated
	 */
	void setRenewable(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scheduler.SchedulerPackage#getAbstractResource_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.AbstractResource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(int)
	 * @see scheduler.SchedulerPackage#getAbstractResource_Capacity()
	 * @model
	 * @generated
	 */
	int getCapacity();

	/**
	 * Sets the value of the '{@link scheduler.AbstractResource#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(int value);

	/**
	 * Returns the value of the '<em><b>Belongs</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scheduler.ResourceType#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belongs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belongs</em>' reference.
	 * @see #setBelongs(ResourceType)
	 * @see scheduler.SchedulerPackage#getAbstractResource_Belongs()
	 * @see scheduler.ResourceType#getHas
	 * @model opposite="has" required="true"
	 * @generated
	 */
	ResourceType getBelongs();

	/**
	 * Sets the value of the '{@link scheduler.AbstractResource#getBelongs <em>Belongs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Belongs</em>' reference.
	 * @see #getBelongs()
	 * @generated
	 */
	void setBelongs(ResourceType value);

} // AbstractResource
