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
//			  System.out.println("Which report would you like to request? Type 'M' for Member Report, 'P' for Provider Report, 'S' for Summary Report, and 'E' for EFT Report.");
//			  String reportResponse = " ";
//			  reportResponse = sc.nextLine();
//			  System.out.println("You entered: " + reportResponse);
//			  if (reportResponse.equals("M")) {
//				  rc.memberReport();
//				  String quitResponse = " ";
//				  while (quitResponse.equals("Q") && quitResponse.equals("R")) {
//					  System.out.println("Enter 'Q' if you would like to exit the software. Enter 'R' if you would like to request another report"");
//					  quitResponse = sc.nextLine();
//					  if (quitResponse.equals("Q")) {
//						  System.out.println("Have a nice day!");
//					  }
//					  else if (quitResponse.equals)
//				  }
//			  }
//			  else if (reportResponse.equals("P")) {
//				  rc.providerReport();
//			  }
//			  else if (reportResponse.equals("S")) {
//				  rc.summaryReport();
//			  }
//			  else if (reportResponse.equals("E")) {
//				  rc.eftReport();
//			  }
//			  else {
//				  System.out.println("You have entered an invalid input. You will be redirected to the question.");
//			  }
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
    if (username.equals(managerUserame) && password.equals(managerPassword)) {
      System.out.println("Welcome, " + managerUserame + "!");
    }
        else {
          System.out.println("Invalid username or password.");
    }
    sc.close();
    return;
  }
}
