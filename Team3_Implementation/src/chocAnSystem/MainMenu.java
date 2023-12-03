/** @author all team members: Ethan Busby, Adam Howard, Hariaksha Gunda, Ryan McCulley, Robert Read, Tyler Cruise, and James White*/
package chocAnSystem;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	/** This constructor creates an instance of the class*/
  public MainMenu() {
  }

  /** This method prints to the console, indicating that the user is in the main menu. It returns nothing.*/
  public void display() {
    System.out.println("You are in the main menu.");
  }

  /** This method takes input to lead the user to the right terminal or run the main accounting procedure. It returns nothing.*/
  public void login() throws IOException{
    // Use scanner to take login number
    Scanner myObj = new Scanner(System.in);
    int loginNumber = -1;
    while (loginNumber < 0 || loginNumber >= 3) {
      System.out.println("Enter login number.\n0 will run the main accounting procedure\n1 will guide you to the Operator Terminal\n2 will guide you to the Manager Terminal,\n3 will guide you to the Provider Terminal.");
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
    	  ProviderTerminal pt = new ProviderTerminal();
    	  pt.providerLogin();
    	  pt.chooseAction();
      }
      else {
        System.out.println("You have entered an invalid login. Please try again.");
      }
    }
    myObj.close();
  }
}
