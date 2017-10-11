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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.AbstractResource;
import scheduler.ResourceC;
import scheduler.ResourceType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource C</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ResourceCImpl#isRenewable <em>Renewable</em>}</li>
 *   <li>{@link scheduler.impl.ResourceCImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.impl.ResourceCImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link scheduler.impl.ResourceCImpl#getBelongs <em>Belongs</em>}</li>
 *   <li>{@link scheduler.impl.ResourceCImpl#getSubResources <em>Sub Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceCImpl extends ModeImpl implements ResourceC {
	/**
	 * The default value of the '{@link #isRenewable() <em>Renewable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenewable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENEWABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRenewable() <em>Renewable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenewable()
	 * @generated
	 * @ordered
	 */
	protected boolean renewable = RENEWABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected int capacity = CAPACITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBelongs() <em>Belongs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBelongs()
	 * @generated
	 * @ordered
	 */
	protected ResourceType belongs;

	/**
	 * The cached value of the '{@link #getSubResources() <em>Sub Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubResources()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractResource> subResources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceCImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RESOURCE_C;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRenewable() {
		return renewable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenewable(boolean newRenewable) {
		boolean oldRenewable = renewable;
		renewable = newRenewable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_C__RENEWABLE, oldRenewable, renewable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_C__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(int newCapacity) {
		int oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_C__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getBelongs() {
		if (belongs != null && belongs.eIsProxy()) {
			InternalEObject oldBelongs = (InternalEObject)belongs;
			belongs = (ResourceType)eResolveProxy(oldBelongs);
			if (belongs != oldBelongs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.RESOURCE_C__BELONGS, oldBelongs, belongs));
			}
		}
		return belongs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType basicGetBelongs() {
		return belongs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBelongs(ResourceType newBelongs, NotificationChain msgs) {
		ResourceType oldBelongs = belongs;
		belongs = newBelongs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_C__BELONGS, oldBelongs, newBelongs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBelongs(ResourceType newBelongs) {
		if (newBelongs != belongs) {
			NotificationChain msgs = null;
			if (belongs != null)
				msgs = ((InternalEObject)belongs).eInverseRemove(this, SchedulerPackage.RESOURCE_TYPE__HAS, ResourceType.class, msgs);
			if (newBelongs != null)
				msgs = ((InternalEObject)newBelongs).eInverseAdd(this, SchedulerPackage.RESOURCE_TYPE__HAS, ResourceType.class, msgs);
			msgs = basicSetBelongs(newBelongs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_C__BELONGS, newBelongs, newBelongs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractResource> getSubResources() {
		if (subResources == null) {
			subResources = new EObjectContainmentEList<AbstractResource>(AbstractResource.class, this, SchedulerPackage.RESOURCE_C__SUB_RESOURCES);
		}
		return subResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_C__BELONGS:
				if (belongs != null)
					msgs = ((InternalEObject)belongs).eInverseRemove(this, SchedulerPackage.RESOURCE_TYPE__HAS, ResourceType.class, msgs);
				return basicSetBelongs((ResourceType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_C__BELONGS:
				return basicSetBelongs(null, msgs);
			case SchedulerPackage.RESOURCE_C__SUB_RESOURCES:
				return ((InternalEList<?>)getSubResources()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.RESOURCE_C__RENEWABLE:
				return isRenewable();
			case SchedulerPackage.RESOURCE_C__NAME:
				return getName();
			case SchedulerPackage.RESOURCE_C__CAPACITY:
				return getCapacity();
			case SchedulerPackage.RESOURCE_C__BELONGS:
				if (resolve) return getBelongs();
				return basicGetBelongs();
			case SchedulerPackage.RESOURCE_C__SUB_RESOURCES:
				return getSubResources();
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
			case SchedulerPackage.RESOURCE_C__RENEWABLE:
				setRenewable((Boolean)newValue);
				return;
			case SchedulerPackage.RESOURCE_C__NAME:
				setName((String)newValue);
				return;
			case SchedulerPackage.RESOURCE_C__CAPACITY:
				setCapacity((Integer)newValue);
				return;
			case SchedulerPackage.RESOURCE_C__BELONGS:
				setBelongs((ResourceType)newValue);
				return;
			case SchedulerPackage.RESOURCE_C__SUB_RESOURCES:
				getSubResources().clear();
				getSubResources().addAll((Collection<? extends AbstractResource>)newValue);
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
			case SchedulerPackage.RESOURCE_C__RENEWABLE:
				setRenewable(RENEWABLE_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_C__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_C__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_C__BELONGS:
				setBelongs((ResourceType)null);
				return;
			case SchedulerPackage.RESOURCE_C__SUB_RESOURCES:
				getSubResources().clear();
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
			case SchedulerPackage.RESOURCE_C__RENEWABLE:
				return renewable != RENEWABLE_EDEFAULT;
			case SchedulerPackage.RESOURCE_C__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulerPackage.RESOURCE_C__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case SchedulerPackage.RESOURCE_C__BELONGS:
				return belongs != null;
			case SchedulerPackage.RESOURCE_C__SUB_RESOURCES:
				return subResources != null && !subResources.isEmpty();
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
		result.append(" (renewable: ");
		result.append(renewable);
		result.append(", name: ");
		result.append(name);
		result.append(", capacity: ");
		result.append(capacity);
		result.append(')');
		return result.toString();
	}

} //ResourceCImpl
