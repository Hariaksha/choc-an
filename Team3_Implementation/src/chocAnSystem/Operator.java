/** @author Ethan Busby*/
/** This class shows how the operator interacts with the operator terminal*/

package chocAnSystem;

/** The Operator class illustrates how the operator interacts with the operator terminal.*/
public class Operator {
	
	/** This shows that an operator can perform the actions on the operator terminal. */
	public void action() {
		System.out.println("You are an Operator. You will be directed to the Operator Terminal");
        OperatorTerminal ot = new OperatorTerminal();
        ot.login();
        ot.chooseAction();
	}
	
}
