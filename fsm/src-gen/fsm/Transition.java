/**
 */
package fsm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsm.Transition#getName <em>Name</em>}</li>
 *   <li>{@link fsm.Transition#getState <em>State</em>}</li>
 *   <li>{@link fsm.Transition#getTrigger <em>Trigger</em>}</li>
 * </ul>
 *
 * @see fsm.FsmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fsm.FsmPackage#getTransition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fsm.Transition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' reference list.
	 * The list contents are of type {@link fsm.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference list.
	 * @see fsm.FsmPackage#getTransition_State()
	 * @model upper="2"
	 * @generated
	 */
	EList<State> getState();

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see #setTrigger(String)
	 * @see fsm.FsmPackage#getTransition_Trigger()
	 * @model
	 * @generated
	 */
	String getTrigger();

	/**
	 * Sets the value of the '{@link fsm.Transition#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(String value);

} // Transition
