// Author: Hariaksha Gunda
package chocAnSystem;

public class Manager {

    /** This constructor creates instances of the Manager class.*/
    public Manager() {
    }

    /** This demonstrates that the Manager can access the terminal and call its functions. This function returns nothing.*/
    public void action() {
    	System.out.println("You are a Manager. You will be directed to the Manager Terminal.");
    	ManagerTerminal mt = new ManagerTerminal();
    	mt.login();
    	mt.chooseAction();
    }
}
