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
	
}
