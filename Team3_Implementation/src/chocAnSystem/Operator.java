package chocAnSystem;

public class Operator {
	public String operatorName;
	public int operatorNumber;
	
	/** This shows that an operator can perform the actions on the operator terminal. */
	public void action() {
		System.out.println("You are an Operator. You will be directed to the Operator Terminal");
        OperatorTerminal ot = new OperatorTerminal();
        ot.login();
        ot.chooseAction();
	}
	
}
