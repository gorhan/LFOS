/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Dependency#getDependencyItems <em>Dependency Items</em>}</li>
 *   <li>{@link scheduler.Dependency#getRelation <em>Relation</em>}</li>
 *   <li>{@link scheduler.Dependency#getMutexItems <em>Mutex Items</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependency Items</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.DependencyItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Items</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getDependency_DependencyItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyItem> getDependencyItems();

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.LogicalRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' attribute.
	 * @see scheduler.LogicalRelation
	 * @see #setRelation(LogicalRelation)
	 * @see scheduler.SchedulerPackage#getDependency_Relation()
	 * @model
	 * @generated
	 */
	LogicalRelation getRelation();

	/**
	 * Sets the value of the '{@link scheduler.Dependency#getRelation <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' attribute.
	 * @see scheduler.LogicalRelation
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(LogicalRelation value);

	/**
	 * Returns the value of the '<em><b>Mutex Items</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.MutualExclusion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutex Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutex Items</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getDependency_MutexItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<MutualExclusion> getMutexItems();

} // Dependency
