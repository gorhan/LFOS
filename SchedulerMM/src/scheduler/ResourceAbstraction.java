/**
 */
package scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resource Abstraction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage#getResourceAbstraction()
 * @model
 * @generated
 */
public enum ResourceAbstraction implements Enumerator {
	/**
	 * The '<em><b>ACTIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE(0, "ACTIVE", "ACTIVE"),

	/**
	 * The '<em><b>PASSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	PASSIVE(1, "PASSIVE", "PASSIVE"),

	/**
	 * The '<em><b>COMPOSITE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE_VALUE
	 * @generated
	 * @ordered
	 */
	COMPOSITE(2, "COMPOSITE", "COMPOSITE");

	/**
	 * The '<em><b>ACTIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_VALUE = 0;

	/**
	 * The '<em><b>PASSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PASSIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASSIVE_VALUE = 1;

	/**
	 * The '<em><b>COMPOSITE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPOSITE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOSITE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPOSITE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Resource Abstraction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResourceAbstraction[] VALUES_ARRAY =
		new ResourceAbstraction[] {
			ACTIVE,
			PASSIVE,
			COMPOSITE,
		};

	/**
	 * A public read-only list of all the '<em><b>Resource Abstraction</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResourceAbstraction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resource Abstraction</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceAbstraction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceAbstraction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Abstraction</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceAbstraction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceAbstraction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Abstraction</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceAbstraction get(int value) {
		switch (value) {
			case ACTIVE_VALUE: return ACTIVE;
			case PASSIVE_VALUE: return PASSIVE;
			case COMPOSITE_VALUE: return COMPOSITE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ResourceAbstraction(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ResourceAbstraction
