package chocAnSystem;

public class Operator {
	public String operatorName;
	public int operatorNumber;
	
	public Operator() {
		operatorName = "Random Name";
		operatorNumber = 9999;
	}
	
	public Operator(int num, String name) {
		operatorName = name;
		operatorNumber = num;
	}
	
	public String getOperatorName() {
		return operatorName;
	}
	
	public int getOperatorNumber() {
		return operatorNumber;
	}
	
	/** This shows that an operator can perform the actions on the operator terminal. */
	public void action() {
		System.out.println("You are an Operator. You will be directed to the Operator Terminal");
        OperatorTerminal ot = new OperatorTerminal();
        ot.login();
        ot.chooseAction();
	}
	
}
