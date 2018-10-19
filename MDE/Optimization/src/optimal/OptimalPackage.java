/**
 */
package optimal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see optimal.OptimalFactory
 * @model kind="package"
 * @generated
 */
public interface OptimalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "optimal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/optimal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "optimal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptimalPackage eINSTANCE = optimal.impl.OptimalPackageImpl.init();

	/**
	 * The meta object id for the '{@link optimal.impl.OptimizationImpl <em>Optimization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.OptimizationImpl
	 * @see optimal.impl.OptimalPackageImpl#getOptimization()
	 * @generated
	 */
	int OPTIMIZATION = 0;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION__CRITERIA = 0;

	/**
	 * The number of structural features of the '<em>Optimization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Optimization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.CriteriaImpl <em>Criteria</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.CriteriaImpl
	 * @see optimal.impl.OptimalPackageImpl#getCriteria()
	 * @generated
	 */
	int CRITERIA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__PURPOSE = 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__DEFAULT = 2;

	/**
	 * The feature id for the '<em><b>Contribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__CONTRIBUTION = 3;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__FEATURES = 4;

	/**
	 * The number of structural features of the '<em>Criteria</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Criteria</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.FeatureImpl
	 * @see optimal.impl.OptimalPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Cooccurrences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__COOCCURRENCES = 2;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.CooccurrenceImpl <em>Cooccurrence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.CooccurrenceImpl
	 * @see optimal.impl.OptimalPackageImpl#getCooccurrence()
	 * @generated
	 */
	int COOCCURRENCE = 3;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOCCURRENCE__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOCCURRENCE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Cooccurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOCCURRENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cooccurrence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COOCCURRENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.Purpose <em>Purpose</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.Purpose
	 * @see optimal.impl.OptimalPackageImpl#getPurpose()
	 * @generated
	 */
	int PURPOSE = 4;


	/**
	 * Returns the meta object for class '{@link optimal.Optimization <em>Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimization</em>'.
	 * @see optimal.Optimization
	 * @generated
	 */
	EClass getOptimization();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Optimization#getCriteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Criteria</em>'.
	 * @see optimal.Optimization#getCriteria()
	 * @see #getOptimization()
	 * @generated
	 */
	EReference getOptimization_Criteria();

	/**
	 * Returns the meta object for class '{@link optimal.Criteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criteria</em>'.
	 * @see optimal.Criteria
	 * @generated
	 */
	EClass getCriteria();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see optimal.Criteria#getName()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Name();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see optimal.Criteria#getPurpose()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Purpose();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see optimal.Criteria#getDefault()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Default();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getContribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contribution</em>'.
	 * @see optimal.Criteria#getContribution()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Contribution();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Criteria#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see optimal.Criteria#getFeatures()
	 * @see #getCriteria()
	 * @generated
	 */
	EReference getCriteria_Features();

	/**
	 * Returns the meta object for class '{@link optimal.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see optimal.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see optimal.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Feature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see optimal.Feature#getValue()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Feature#getCooccurrences <em>Cooccurrences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cooccurrences</em>'.
	 * @see optimal.Feature#getCooccurrences()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Cooccurrences();

	/**
	 * Returns the meta object for class '{@link optimal.Cooccurrence <em>Cooccurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cooccurrence</em>'.
	 * @see optimal.Cooccurrence
	 * @generated
	 */
	EClass getCooccurrence();

	/**
	 * Returns the meta object for the reference list '{@link optimal.Cooccurrence#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see optimal.Cooccurrence#getFeatures()
	 * @see #getCooccurrence()
	 * @generated
	 */
	EReference getCooccurrence_Features();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Cooccurrence#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see optimal.Cooccurrence#getValue()
	 * @see #getCooccurrence()
	 * @generated
	 */
	EAttribute getCooccurrence_Value();

	/**
	 * Returns the meta object for enum '{@link optimal.Purpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Purpose</em>'.
	 * @see optimal.Purpose
	 * @generated
	 */
	EEnum getPurpose();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptimalFactory getOptimalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link optimal.impl.OptimizationImpl <em>Optimization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.OptimizationImpl
		 * @see optimal.impl.OptimalPackageImpl#getOptimization()
		 * @generated
		 */
		EClass OPTIMIZATION = eINSTANCE.getOptimization();

		/**
		 * The meta object literal for the '<em><b>Criteria</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION__CRITERIA = eINSTANCE.getOptimization_Criteria();

		/**
		 * The meta object literal for the '{@link optimal.impl.CriteriaImpl <em>Criteria</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.CriteriaImpl
		 * @see optimal.impl.OptimalPackageImpl#getCriteria()
		 * @generated
		 */
		EClass CRITERIA = eINSTANCE.getCriteria();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__NAME = eINSTANCE.getCriteria_Name();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__PURPOSE = eINSTANCE.getCriteria_Purpose();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__DEFAULT = eINSTANCE.getCriteria_Default();

		/**
		 * The meta object literal for the '<em><b>Contribution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__CONTRIBUTION = eINSTANCE.getCriteria_Contribution();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERIA__FEATURES = eINSTANCE.getCriteria_Features();

		/**
		 * The meta object literal for the '{@link optimal.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.FeatureImpl
		 * @see optimal.impl.OptimalPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__VALUE = eINSTANCE.getFeature_Value();

		/**
		 * The meta object literal for the '<em><b>Cooccurrences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__COOCCURRENCES = eINSTANCE.getFeature_Cooccurrences();

		/**
		 * The meta object literal for the '{@link optimal.impl.CooccurrenceImpl <em>Cooccurrence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.CooccurrenceImpl
		 * @see optimal.impl.OptimalPackageImpl#getCooccurrence()
		 * @generated
		 */
		EClass COOCCURRENCE = eINSTANCE.getCooccurrence();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COOCCURRENCE__FEATURES = eINSTANCE.getCooccurrence_Features();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COOCCURRENCE__VALUE = eINSTANCE.getCooccurrence_Value();

		/**
		 * The meta object literal for the '{@link optimal.Purpose <em>Purpose</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.Purpose
		 * @see optimal.impl.OptimalPackageImpl#getPurpose()
		 * @generated
		 */
		EEnum PURPOSE = eINSTANCE.getPurpose();

	}

} //OptimalPackage
