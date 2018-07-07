/**
 */
package platformMM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import platformMM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlatformMMFactoryImpl extends EFactoryImpl implements PlatformMMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PlatformMMFactory init() {
		try {
			PlatformMMFactory thePlatformMMFactory = (PlatformMMFactory)EPackage.Registry.INSTANCE.getEFactory(PlatformMMPackage.eNS_URI);
			if (thePlatformMMFactory != null) {
				return thePlatformMMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PlatformMMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformMMFactoryImpl() {
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
			case PlatformMMPackage.TERMINAL_RESOURCE: return createTerminalResource();
			case PlatformMMPackage.COMPOSITE_RESOURCE: return createCompositeResource();
			case PlatformMMPackage.STATE_DVS: return createStateDVS();
			case PlatformMMPackage.RESOURCE_TYPE: return createResourceType();
			case PlatformMMPackage.PLATFORM_DIAGRAM: return createPlatformDiagram();
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
			case PlatformMMPackage.RESOURCE_ABSTRACTION:
				return createResourceAbstractionFromString(eDataType, initialValue);
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
			case PlatformMMPackage.RESOURCE_ABSTRACTION:
				return convertResourceAbstractionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalResource createTerminalResource() {
		TerminalResourceImpl terminalResource = new TerminalResourceImpl();
		return terminalResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeResource createCompositeResource() {
		CompositeResourceImpl compositeResource = new CompositeResourceImpl();
		return compositeResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDVS createStateDVS() {
		StateDVSImpl stateDVS = new StateDVSImpl();
		return stateDVS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceType() {
		ResourceTypeImpl resourceType = new ResourceTypeImpl();
		return resourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformDiagram createPlatformDiagram() {
		PlatformDiagramImpl platformDiagram = new PlatformDiagramImpl();
		return platformDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAbstraction createResourceAbstractionFromString(EDataType eDataType, String initialValue) {
		ResourceAbstraction result = ResourceAbstraction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceAbstractionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformMMPackage getPlatformMMPackage() {
		return (PlatformMMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PlatformMMPackage getPackage() {
		return PlatformMMPackage.eINSTANCE;
	}

} //PlatformMMFactoryImpl
