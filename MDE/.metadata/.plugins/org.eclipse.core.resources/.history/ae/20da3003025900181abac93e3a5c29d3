/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.featuremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.featuremodel.Feature;
import org.eclipse.featuremodel.FeatureModelPackage;
import org.eclipse.featuremodel.Group;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.featuremodel.impl.GroupImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.GroupImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.GroupImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.GroupImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends EObjectImpl implements Group {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected static final int LOWER_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLower()
   * @generated
   * @ordered
   */
  protected int lower = LOWER_EDEFAULT;

  /**
   * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected static final int UPPER_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpper()
   * @generated
   * @ordered
   */
  protected int upper = UPPER_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FeatureModelPackage.Literals.GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLower() {
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLower(int newLower) {
    int oldLower = lower;
    lower = newLower;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__LOWER, oldLower, lower));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUpper() {
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpper(int newUpper) {
    int oldUpper = upper;
    upper = newUpper;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.GROUP__UPPER, oldUpper, upper));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures() {
    if (features == null) {
      features = new EObjectContainmentEList<Feature>(Feature.class, this, FeatureModelPackage.GROUP__FEATURES);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case FeatureModelPackage.GROUP__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
      case FeatureModelPackage.GROUP__ID:
        return getId();
      case FeatureModelPackage.GROUP__LOWER:
        return new Integer(getLower());
      case FeatureModelPackage.GROUP__UPPER:
        return new Integer(getUpper());
      case FeatureModelPackage.GROUP__FEATURES:
        return getFeatures();
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
      case FeatureModelPackage.GROUP__ID:
        setId((String)newValue);
        return;
      case FeatureModelPackage.GROUP__LOWER:
        setLower(((Integer)newValue).intValue());
        return;
      case FeatureModelPackage.GROUP__UPPER:
        setUpper(((Integer)newValue).intValue());
        return;
      case FeatureModelPackage.GROUP__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
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
      case FeatureModelPackage.GROUP__ID:
        setId(ID_EDEFAULT);
        return;
      case FeatureModelPackage.GROUP__LOWER:
        setLower(LOWER_EDEFAULT);
        return;
      case FeatureModelPackage.GROUP__UPPER:
        setUpper(UPPER_EDEFAULT);
        return;
      case FeatureModelPackage.GROUP__FEATURES:
        getFeatures().clear();
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
      case FeatureModelPackage.GROUP__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case FeatureModelPackage.GROUP__LOWER:
        return lower != LOWER_EDEFAULT;
      case FeatureModelPackage.GROUP__UPPER:
        return upper != UPPER_EDEFAULT;
      case FeatureModelPackage.GROUP__FEATURES:
        return features != null && !features.isEmpty();
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
    result.append(" (id: ");
    result.append(id);
    result.append(", lower: ");
    result.append(lower);
    result.append(", upper: ");
    result.append(upper);
    result.append(')');
    return result.toString();
  }

} //GroupImpl
