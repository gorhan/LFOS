/**
 */
package scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resource Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage#getResourceMode()
 * @model
 * @generated
 */
public enum ResourceMode implements Enumerator {
	/**
	 * The '<em><b>SHARED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHARED_VALUE
	 * @generated
	 * @ordered
	 */
	SHARED(0, "SHARED", "SHARED"),

	/**
	 * The '<em><b>CB EXCLUSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CB_EXCLUSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	CB_EXCLUSIVE(1, "CB_EXCLUSIVE", "CB_EXCLUSIVE"),

	/**
	 * The '<em><b>SB EXCLUSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SB_EXCLUSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	SB_EXCLUSIVE(2, "SB_EXCLUSIVE", "SB_EXCLUSIVE"),

	/**
	 * The '<em><b>CB AND SB EXCLUSIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CB_AND_SB_EXCLUSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	CB_AND_SB_EXCLUSIVE(3, "CB_AND_SB_EXCLUSIVE", "CB_AND_SB_EXCLUSIVE");

	/**
	 * The '<em><b>SHARED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHARED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHARED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHARED_VALUE = 0;

	/**
	 * The '<em><b>CB EXCLUSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CB EXCLUSIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CB_EXCLUSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CB_EXCLUSIVE_VALUE = 1;

	/**
	 * The '<em><b>SB EXCLUSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SB EXCLUSIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SB_EXCLUSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SB_EXCLUSIVE_VALUE = 2;

	/**
	 * The '<em><b>CB AND SB EXCLUSIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CB AND SB EXCLUSIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CB_AND_SB_EXCLUSIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CB_AND_SB_EXCLUSIVE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Resource Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResourceMode[] VALUES_ARRAY =
		new ResourceMode[] {
			SHARED,
			CB_EXCLUSIVE,
			SB_EXCLUSIVE,
			CB_AND_SB_EXCLUSIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Resource Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResourceMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resource Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ResourceMode get(int value) {
		switch (value) {
			case SHARED_VALUE: return SHARED;
			case CB_EXCLUSIVE_VALUE: return CB_EXCLUSIVE;
			case SB_EXCLUSIVE_VALUE: return SB_EXCLUSIVE;
			case CB_AND_SB_EXCLUSIVE_VALUE: return CB_AND_SB_EXCLUSIVE;
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
	private ResourceMode(int value, String name, String literal) {
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
	
} //ResourceMode
