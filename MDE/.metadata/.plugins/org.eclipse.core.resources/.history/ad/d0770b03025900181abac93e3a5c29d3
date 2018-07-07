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

import org.eclipse.featuremodel.Attribute;
import org.eclipse.featuremodel.Constraint;
import org.eclipse.featuremodel.Description;
import org.eclipse.featuremodel.Feature;
import org.eclipse.featuremodel.FeatureModel;
import org.eclipse.featuremodel.FeatureModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.featuremodel.impl.FeatureModelImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureModelImpl extends EObjectImpl implements FeatureModel {
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
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected Feature root;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<Constraint> constraints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FeatureModelPackage.Literals.FEATURE_MODEL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion() {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion) {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__VERSION, oldVersion, version));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs) {
    Description oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription) {
    if (newDescription != description) {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes() {
    if (attributes == null) {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getRoot() {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoot(Feature newRoot, NotificationChain msgs) {
    Feature oldRoot = root;
    root = newRoot;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT, oldRoot, newRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(Feature newRoot) {
    if (newRoot != root) {
      NotificationChain msgs = null;
      if (root != null)
        msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT, null, msgs);
      if (newRoot != null)
        msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FeatureModelPackage.FEATURE_MODEL__ROOT, null, msgs);
      msgs = basicSetRoot(newRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeatureModelPackage.FEATURE_MODEL__ROOT, newRoot, newRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Constraint> getConstraints() {
    if (constraints == null) {
      constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS);
    }
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case FeatureModelPackage.FEATURE_MODEL__ROOT:
        return basicSetRoot(null, msgs);
      case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
      case FeatureModelPackage.FEATURE_MODEL__ID:
        return getId();
      case FeatureModelPackage.FEATURE_MODEL__VERSION:
        return getVersion();
      case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
        return getDescription();
      case FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES:
        return getAttributes();
      case FeatureModelPackage.FEATURE_MODEL__ROOT:
        return getRoot();
      case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
        return getConstraints();
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
      case FeatureModelPackage.FEATURE_MODEL__ID:
        setId((String)newValue);
        return;
      case FeatureModelPackage.FEATURE_MODEL__VERSION:
        setVersion((String)newValue);
        return;
      case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case FeatureModelPackage.FEATURE_MODEL__ROOT:
        setRoot((Feature)newValue);
        return;
      case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
      case FeatureModelPackage.FEATURE_MODEL__ID:
        setId(ID_EDEFAULT);
        return;
      case FeatureModelPackage.FEATURE_MODEL__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
      case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
        setDescription((Description)null);
        return;
      case FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES:
        getAttributes().clear();
        return;
      case FeatureModelPackage.FEATURE_MODEL__ROOT:
        setRoot((Feature)null);
        return;
      case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
        getConstraints().clear();
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
      case FeatureModelPackage.FEATURE_MODEL__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case FeatureModelPackage.FEATURE_MODEL__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
      case FeatureModelPackage.FEATURE_MODEL__DESCRIPTION:
        return description != null;
      case FeatureModelPackage.FEATURE_MODEL__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case FeatureModelPackage.FEATURE_MODEL__ROOT:
        return root != null;
      case FeatureModelPackage.FEATURE_MODEL__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
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
    result.append(", version: ");
    result.append(version);
    result.append(')');
    return result.toString();
  }

} //FeatureModelImpl
