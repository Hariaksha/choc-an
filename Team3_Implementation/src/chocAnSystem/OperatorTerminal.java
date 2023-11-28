package chocAnSystem;
import java.util.Scanner;

public class OperatorTerminal {
	public String operatorPassword;
	public String operatorUsername;
	
	public OperatorTerminal() {
	    operatorUsername = "random username";
	    operatorPassword = "Password";
	  }
	
	public OperatorTerminal(String pass, String name) {
	    operatorUsername = name;
	    operatorPassword = pass;
	    }
	
	public void chooseAction() {
		Scanner sc = new Scanner(System.in);

	}
}
