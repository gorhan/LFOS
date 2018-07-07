/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.featuremodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.featuremodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.featuremodel.FeatureModelPackage
 * @generated
 */
public class FeatureModelSwitch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FeatureModelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureModelSwitch() {
    if (modelPackage == null) {
      modelPackage = FeatureModelPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage) {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case FeatureModelPackage.RULE: {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.FEATURE_MODEL: {
        FeatureModel featureModel = (FeatureModel)theEObject;
        T result = caseFeatureModel(featureModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.CONSTRAINT: {
        Constraint constraint = (Constraint)theEObject;
        T result = caseConstraint(constraint);
        if (result == null) result = caseRule(constraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.GROUP: {
        Group group = (Group)theEObject;
        T result = caseGroup(group);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.FEATURE: {
        Feature feature = (Feature)theEObject;
        T result = caseFeature(feature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE: {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.DESCRIPTION: {
        Description description = (Description)theEObject;
        T result = caseDescription(description);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_TYPE: {
        AttributeType attributeType = (AttributeType)theEObject;
        T result = caseAttributeType(attributeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_TYPE_INT: {
        AttributeTypeInt attributeTypeInt = (AttributeTypeInt)theEObject;
        T result = caseAttributeTypeInt(attributeTypeInt);
        if (result == null) result = caseAttributeType(attributeTypeInt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_TYPE_STRING: {
        AttributeTypeString attributeTypeString = (AttributeTypeString)theEObject;
        T result = caseAttributeTypeString(attributeTypeString);
        if (result == null) result = caseAttributeType(attributeTypeString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_TYPE_BOOLEAN: {
        AttributeTypeBoolean attributeTypeBoolean = (AttributeTypeBoolean)theEObject;
        T result = caseAttributeTypeBoolean(attributeTypeBoolean);
        if (result == null) result = caseAttributeType(attributeTypeBoolean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_TYPE_EOBJECT: {
        AttributeTypeEObject attributeTypeEObject = (AttributeTypeEObject)theEObject;
        T result = caseAttributeTypeEObject(attributeTypeEObject);
        if (result == null) result = caseAttributeType(attributeTypeEObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_VALUE: {
        AttributeValue attributeValue = (AttributeValue)theEObject;
        T result = caseAttributeValue(attributeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_VALUE_INT: {
        AttributeValueInt attributeValueInt = (AttributeValueInt)theEObject;
        T result = caseAttributeValueInt(attributeValueInt);
        if (result == null) result = caseAttributeValue(attributeValueInt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_VALUE_STRING: {
        AttributeValueString attributeValueString = (AttributeValueString)theEObject;
        T result = caseAttributeValueString(attributeValueString);
        if (result == null) result = caseAttributeValue(attributeValueString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_VALUE_BOOLEAN: {
        AttributeValueBoolean attributeValueBoolean = (AttributeValueBoolean)theEObject;
        T result = caseAttributeValueBoolean(attributeValueBoolean);
        if (result == null) result = caseAttributeValue(attributeValueBoolean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case FeatureModelPackage.ATTRIBUTE_VALUE_EOBJECT: {
        AttributeValueEObject attributeValueEObject = (AttributeValueEObject)theEObject;
        T result = caseAttributeValueEObject(attributeValueEObject);
        if (result == null) result = caseAttributeValue(attributeValueEObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureModel(FeatureModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint(Constraint object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroup(Group object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeature(Feature object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDescription(Description object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeType(AttributeType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type Int</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type Int</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeTypeInt(AttributeTypeInt object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeTypeString(AttributeTypeString object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeTypeBoolean(AttributeTypeBoolean object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Type EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Type EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeTypeEObject(AttributeTypeEObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValue(AttributeValue object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value Int</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value Int</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValueInt(AttributeValueInt object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValueString(AttributeValueString object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValueBoolean(AttributeValueBoolean object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValueEObject(AttributeValueEObject object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object) {
    return null;
  }

} //FeatureModelSwitch
