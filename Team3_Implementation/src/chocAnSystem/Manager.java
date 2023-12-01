// Author: Hariaksha Gunda
package chocAnSystem;

public class Manager {

    /** This is the default constructor that is used when the constructor is called without arguments by accident. */
    public Manager() {
    }

    /** This demonstrates that the manager can access the terminal and call its functions.*/
    public void action() {
    	System.out.println("You are a Manager. You will be directed to the Manager Terminal.");
    	ManagerTerminal mt = new ManagerTerminal();
    	mt.login();
    	mt.chooseAction();
    }
}
