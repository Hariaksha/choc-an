package chocAnSystem;
import java.util.Scanner;

public class ManagerTerminal {
  private String managerUserame;
  private String managerPassword;

  /** This is a Default Constructor that will be used in case arguments are accidentally not passed. */
  public ManagerTerminal() {
    managerUserame = "Bobby Brady";
    managerPassword = "Password";
  }

  /** This is the Primary Constructor that is recommended for use. */
  public ManagerTerminal(String pass, String name) {
    managerUserame = name;
    managerPassword = pass;
    }

  /** This class will let the manager choose an action. */
  public void chooseAction() {
	  Scanner sc = new Scanner(System.in);
	  String response = " ";
	  ReportController rc = new ReportController();

	  while (!response.equals("Y") && !response.equals("N")) {
		  System.out.println("Would you like to request a report? Type 'Y' for Yes and 'N' for No");
		  response = sc.nextLine();
		  System.out.println("You entered: " + response);
		  if (response.equals("N")) {
			  System.out.println("You have chosen not to request a report. Have a nice day!");
		  }
		  else if (response.equals("Y")) {
			  rc.requestReports();
		  }
		  else {
			  System.out.println("You have entered an invalid input. You will be redirected to the question.");
		  }
	  }    
	  sc.close();
	  return;
  }

  /** This class allows a manager to enter login credentials to securely log into the system. */
  public void managerLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username and click Enter: ");
    String username = sc.nextLine();
    System.out.println("Enter password and click Enter: ");
    String password = sc.nextLine();
    if (username.equals(managerUsername) && password.equals(managerPassword)) {
      System.out.println("Welcome, " + managerUserame + "!");
    }
        else {
          System.out.println("Invalid username or password.");
    }
    sc.close();
    return;
  }
}