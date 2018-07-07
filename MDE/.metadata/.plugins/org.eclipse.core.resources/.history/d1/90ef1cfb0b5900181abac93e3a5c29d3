/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.featuremodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.featuremodel.Constraint;
import org.eclipse.featuremodel.Description;
import org.eclipse.featuremodel.FeatureModel;
import org.eclipse.featuremodel.FeatureModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.featuremodel.impl.ConstraintImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.featuremodel.impl.ConstraintImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConstraintImpl extends RuleImpl implements Constraint {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}'
   * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ConstraintImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FeatureModelPackage.Literals.CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          FeatureModelPackage.CONSTRAINT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Description getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetDescription(Description newDescription,
      NotificationChain msgs) {
    Description oldDescription = description;
    description = newDescription;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this,
          Notification.SET, FeatureModelPackage.CONSTRAINT__DESCRIPTION,
          oldDescription, newDescription);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setDescription(Description newDescription) {
    if (newDescription != description) {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject) description).eInverseRemove(this,
            EOPPOSITE_FEATURE_BASE
                - FeatureModelPackage.CONSTRAINT__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject) newDescription).eInverseAdd(this,
            EOPPOSITE_FEATURE_BASE
                - FeatureModelPackage.CONSTRAINT__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          FeatureModelPackage.CONSTRAINT__DESCRIPTION, newDescription,
          newDescription));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FeatureModel getModel() {
    FeatureModel model = null;
    EObject container = eContainer();
    if (container instanceof FeatureModel) {
      model = (FeatureModel) container;
    }
    return model;
    // Ensure that you remove @generated or mark it @generated NOT
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd,
      int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
      return basicSetDescription(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FeatureModelPackage.CONSTRAINT__ID:
      return getId();
    case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
      return getDescription();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FeatureModelPackage.CONSTRAINT__ID:
      setId((String) newValue);
      return;
    case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
      setDescription((Description) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FeatureModelPackage.CONSTRAINT__ID:
      setId(ID_EDEFAULT);
      return;
    case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
      setDescription((Description) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FeatureModelPackage.CONSTRAINT__ID:
      return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    case FeatureModelPackage.CONSTRAINT__DESCRIPTION:
      return description != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} // ConstraintImpl
