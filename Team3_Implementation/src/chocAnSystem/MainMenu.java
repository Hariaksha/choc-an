/** This class was written by all team members.*/
package chocAnSystem;
import java.util.Scanner;

public class MainMenu {
  // Constructor
  public MainMenu() {
  }

  public void display() {
    System.out.println("You are in the main menu.");
  }

  public void login() {
    // Use scanner to take login number
    Scanner myObj = new Scanner(System.in);
    int loginNumber = -1;
    while (loginNumber < 0 || loginNumber >= 3) {
      System.out.println("Enter login number. 0 will run the main accounting procedure, 1 will guide you to the Operator Terminal, 2 will guide you to the Manager Terminal, and 3 will guide you to the Provider Terminal.: ");
      loginNumber = myObj.nextInt();
      System.out.println("You entered " + loginNumber + " as your login ID number.");
      if (loginNumber == 0) {
        System.out.println("You are running the Main Accounting Procedure.");
        ReportController rc = new ReportController();
        rc.runAccountingProcedure();
      } 
      else if (loginNumber == 1) {
    	  Operator operator = new Operator();
    	  operator.action();
//        System.out.println("You are an Operator. You will be directed to the Operator Terminal");
//        OperatorTerminal ot = new OperatorTerminal();
//        ot.operatorLoginAndChooseAction();
        //oops
      } 
      else if (loginNumber == 2) {
        System.out.println("You are a Manager. You will be directed to the Manager Terminal");
        ManagerTerminal mt = new ManagerTerminal();
        mt.login();
        mt.chooseAction();
      } 
      else if (loginNumber == 3) {
    	  System.out.println("You are a Provider. You will be directed to the Provider Terminal.");
      }
      else {
        System.out.println("You have entered an invalid login. Please try again.");
      }
    }
    myObj.close();
  }
}
