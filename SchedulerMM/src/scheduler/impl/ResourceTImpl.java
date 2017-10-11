/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.Power;
import scheduler.ResourceT;
import scheduler.ResourceType;
import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource T</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.ResourceTImpl#isRenewable <em>Renewable</em>}</li>
 *   <li>{@link scheduler.impl.ResourceTImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.impl.ResourceTImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link scheduler.impl.ResourceTImpl#getBelongs <em>Belongs</em>}</li>
 *   <li>{@link scheduler.impl.ResourceTImpl#getPower <em>Power</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceTImpl extends ModeImpl implements ResourceT {
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
	 * The cached value of the '{@link #getPower() <em>Power</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPower()
	 * @generated
	 * @ordered
	 */
	protected Power power;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.RESOURCE_T;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__RENEWABLE, oldRenewable, renewable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__CAPACITY, oldCapacity, capacity));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.RESOURCE_T__BELONGS, oldBelongs, belongs));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__BELONGS, oldBelongs, newBelongs);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__BELONGS, newBelongs, newBelongs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Power getPower() {
		return power;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPower(Power newPower, NotificationChain msgs) {
		Power oldPower = power;
		power = newPower;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__POWER, oldPower, newPower);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPower(Power newPower) {
		if (newPower != power) {
			NotificationChain msgs = null;
			if (power != null)
				msgs = ((InternalEObject)power).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.RESOURCE_T__POWER, null, msgs);
			if (newPower != null)
				msgs = ((InternalEObject)newPower).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.RESOURCE_T__POWER, null, msgs);
			msgs = basicSetPower(newPower, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.RESOURCE_T__POWER, newPower, newPower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_T__BELONGS:
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
			case SchedulerPackage.RESOURCE_T__BELONGS:
				return basicSetBelongs(null, msgs);
			case SchedulerPackage.RESOURCE_T__POWER:
				return basicSetPower(null, msgs);
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
			case SchedulerPackage.RESOURCE_T__RENEWABLE:
				return isRenewable();
			case SchedulerPackage.RESOURCE_T__NAME:
				return getName();
			case SchedulerPackage.RESOURCE_T__CAPACITY:
				return getCapacity();
			case SchedulerPackage.RESOURCE_T__BELONGS:
				if (resolve) return getBelongs();
				return basicGetBelongs();
			case SchedulerPackage.RESOURCE_T__POWER:
				return getPower();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.RESOURCE_T__RENEWABLE:
				setRenewable((Boolean)newValue);
				return;
			case SchedulerPackage.RESOURCE_T__NAME:
				setName((String)newValue);
				return;
			case SchedulerPackage.RESOURCE_T__CAPACITY:
				setCapacity((Integer)newValue);
				return;
			case SchedulerPackage.RESOURCE_T__BELONGS:
				setBelongs((ResourceType)newValue);
				return;
			case SchedulerPackage.RESOURCE_T__POWER:
				setPower((Power)newValue);
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
			case SchedulerPackage.RESOURCE_T__RENEWABLE:
				setRenewable(RENEWABLE_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_T__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_T__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case SchedulerPackage.RESOURCE_T__BELONGS:
				setBelongs((ResourceType)null);
				return;
			case SchedulerPackage.RESOURCE_T__POWER:
				setPower((Power)null);
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
			case SchedulerPackage.RESOURCE_T__RENEWABLE:
				return renewable != RENEWABLE_EDEFAULT;
			case SchedulerPackage.RESOURCE_T__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulerPackage.RESOURCE_T__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case SchedulerPackage.RESOURCE_T__BELONGS:
				return belongs != null;
			case SchedulerPackage.RESOURCE_T__POWER:
				return power != null;
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

} //ResourceTImpl
