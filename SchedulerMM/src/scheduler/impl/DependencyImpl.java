/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.Dependency;
import scheduler.DependencyItem;
import scheduler.LogicalRelation;
import scheduler.MutualExclusion;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.DependencyImpl#getDependencyItem <em>Dependency Item</em>}</li>
 *   <li>{@link scheduler.impl.DependencyImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link scheduler.impl.DependencyImpl#getMutexItems <em>Mutex Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyImpl extends MinimalEObjectImpl.Container implements Dependency {
	/**
	 * The cached value of the '{@link #getDependencyItem() <em>Dependency Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyItem()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyItem> dependencyItem;

	/**
	 * The default value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected static final LogicalRelation RELATION_EDEFAULT = LogicalRelation.OR;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected LogicalRelation relation = RELATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMutexItems() <em>Mutex Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexItems()
	 * @generated
	 * @ordered
	 */
	protected EList<MutualExclusion> mutexItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependencyItem> getDependencyItem() {
		if (dependencyItem == null) {
			dependencyItem = new EObjectContainmentEList<DependencyItem>(DependencyItem.class, this, SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM);
		}
		return dependencyItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalRelation getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(LogicalRelation newRelation) {
		LogicalRelation oldRelation = relation;
		relation = newRelation == null ? RELATION_EDEFAULT : newRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.DEPENDENCY__RELATION, oldRelation, relation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MutualExclusion> getMutexItems() {
		if (mutexItems == null) {
			mutexItems = new EObjectContainmentEList<MutualExclusion>(MutualExclusion.class, this, SchedulerPackage.DEPENDENCY__MUTEX_ITEMS);
		}
		return mutexItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM:
				return ((InternalEList<?>)getDependencyItem()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS:
				return ((InternalEList<?>)getMutexItems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM:
				return getDependencyItem();
			case SchedulerPackage.DEPENDENCY__RELATION:
				return getRelation();
			case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS:
				return getMutexItems();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM:
				getDependencyItem().clear();
				getDependencyItem().addAll((Collection<? extends DependencyItem>)newValue);
				return;
			case SchedulerPackage.DEPENDENCY__RELATION:
				setRelation((LogicalRelation)newValue);
				return;
			case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS:
				getMutexItems().clear();
				getMutexItems().addAll((Collection<? extends MutualExclusion>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM:
				getDependencyItem().clear();
				return;
			case SchedulerPackage.DEPENDENCY__RELATION:
				setRelation(RELATION_EDEFAULT);
				return;
			case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS:
				getMutexItems().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY__DEPENDENCY_ITEM:
				return dependencyItem != null && !dependencyItem.isEmpty();
			case SchedulerPackage.DEPENDENCY__RELATION:
				return relation != RELATION_EDEFAULT;
			case SchedulerPackage.DEPENDENCY__MUTEX_ITEMS:
				return mutexItems != null && !mutexItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (relation: ");
		result.append(relation);
		result.append(')');
		return result.toString();
	}

} //DependencyImpl
