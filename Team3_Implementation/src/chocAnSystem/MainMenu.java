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
    while (loginNumber < 0 || loginNumber >= 300) {
      System.out.println("Enter login number: ");
      loginNumber = myObj.nextInt();
      System.out.println("You entered " + loginNumber + " as your login ID number.");
      if (loginNumber >= 0 && loginNumber < 100) {
        System.out.println("You are a Provider. You will be directed to the Provider Terminal");
      } 
      else if (loginNumber >= 100 && loginNumber < 200) {
        System.out.println("You are an Operator. You will be directed to the Operator Terminal");
        OperatorTerminal ot = new OperatorTerminal();
        ot.operatorLoginAndChooseAction();
        //oops
      } 
      else if (loginNumber >= 200 && loginNumber < 300) {
        System.out.println("You are a Manager. You will be directed to the Manager Terminal");
        ManagerTerminal mt = new ManagerTerminal();
        mt.managerLoginAndChooseAction();
      } 
      else {
        System.out.println("You have entered an invalid login. Please try again.");
      }
    }
    myObj.close();
  }
}
