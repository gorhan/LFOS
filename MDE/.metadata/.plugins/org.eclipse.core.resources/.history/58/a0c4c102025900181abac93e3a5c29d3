/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.featuremodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.featuremodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureModelFactoryImpl extends EFactoryImpl implements FeatureModelFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FeatureModelFactory init() {
    try {
      FeatureModelFactory theFeatureModelFactory = (FeatureModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/featuremodel"); 
      if (theFeatureModelFactory != null) {
        return theFeatureModelFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FeatureModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureModelFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case FeatureModelPackage.RULE: return createRule();
      case FeatureModelPackage.FEATURE_MODEL: return createFeatureModel();
      case FeatureModelPackage.CONSTRAINT: return createConstraint();
      case FeatureModelPackage.GROUP: return createGroup();
      case FeatureModelPackage.FEATURE: return createFeature();
      case FeatureModelPackage.ATTRIBUTE: return createAttribute();
      case FeatureModelPackage.DESCRIPTION: return createDescription();
      case FeatureModelPackage.ATTRIBUTE_TYPE_INT: return createAttributeTypeInt();
      case FeatureModelPackage.ATTRIBUTE_TYPE_STRING: return createAttributeTypeString();
      case FeatureModelPackage.ATTRIBUTE_TYPE_BOOLEAN: return createAttributeTypeBoolean();
      case FeatureModelPackage.ATTRIBUTE_TYPE_EOBJECT: return createAttributeTypeEObject();
      case FeatureModelPackage.ATTRIBUTE_VALUE_INT: return createAttributeValueInt();
      case FeatureModelPackage.ATTRIBUTE_VALUE_STRING: return createAttributeValueString();
      case FeatureModelPackage.ATTRIBUTE_VALUE_BOOLEAN: return createAttributeValueBoolean();
      case FeatureModelPackage.ATTRIBUTE_VALUE_EOBJECT: return createAttributeValueEObject();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case FeatureModelPackage.VARIABILITY_TYPE:
        return createVariabilityTypeFromString(eDataType, initialValue);
      case FeatureModelPackage.ID:
        return createIDFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case FeatureModelPackage.VARIABILITY_TYPE:
        return convertVariabilityTypeToString(eDataType, instanceValue);
      case FeatureModelPackage.ID:
        return convertIDToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule() {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureModel createFeatureModel() {
    FeatureModelImpl featureModel = new FeatureModelImpl();
    return featureModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint() {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Group createGroup() {
    GroupImpl group = new GroupImpl();
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature() {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute() {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description createDescription() {
    DescriptionImpl description = new DescriptionImpl();
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeTypeInt createAttributeTypeInt() {
    AttributeTypeIntImpl attributeTypeInt = new AttributeTypeIntImpl();
    return attributeTypeInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeTypeString createAttributeTypeString() {
    AttributeTypeStringImpl attributeTypeString = new AttributeTypeStringImpl();
    return attributeTypeString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeTypeBoolean createAttributeTypeBoolean() {
    AttributeTypeBooleanImpl attributeTypeBoolean = new AttributeTypeBooleanImpl();
    return attributeTypeBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeTypeEObject createAttributeTypeEObject() {
    AttributeTypeEObjectImpl attributeTypeEObject = new AttributeTypeEObjectImpl();
    return attributeTypeEObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValueInt createAttributeValueInt() {
    AttributeValueIntImpl attributeValueInt = new AttributeValueIntImpl();
    return attributeValueInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValueString createAttributeValueString() {
    AttributeValueStringImpl attributeValueString = new AttributeValueStringImpl();
    return attributeValueString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValueBoolean createAttributeValueBoolean() {
    AttributeValueBooleanImpl attributeValueBoolean = new AttributeValueBooleanImpl();
    return attributeValueBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValueEObject createAttributeValueEObject() {
    AttributeValueEObjectImpl attributeValueEObject = new AttributeValueEObjectImpl();
    return attributeValueEObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariabilityType createVariabilityTypeFromString(EDataType eDataType, String initialValue) {
    VariabilityType result = VariabilityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVariabilityTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String createIDFromString(EDataType eDataType, String initialValue) {
    return (String)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIDToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureModelPackage getFeatureModelPackage() {
    return (FeatureModelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FeatureModelPackage getPackage() {
    return FeatureModelPackage.eINSTANCE;
  }

} //FeatureModelFactoryImpl
