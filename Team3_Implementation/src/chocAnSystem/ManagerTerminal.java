package chocAnSystem;
import java.util.Scanner;

public class ManagerTerminal {
  private String managerUsername;
  private String managerPassword;
  private String passwordArr[] = {"password123", "password321"};
  private String usernameArr[] = {"Ethan", "Hari"};

  /** This is a Default Constructor that will be used in case arguments are accidentally not passed. */
  public ManagerTerminal() {
    managerUsername = "Bobby";
    managerPassword = "Password";
  }

  /** This is the Primary Constructor that is recommended for use. */
  public ManagerTerminal(String pass, String name) {
    managerUsername = name;
    managerPassword = pass;
    }

  /** This class will let the manager choose an action. */
//  public void chooseAction() {
//	  Scanner sc2 = new Scanner(System.in);
//	  ReportController rc = new ReportController();
//	  System.out.println("Would you like to request a report? Type 'Y' for Yes and 'N' for No");
//	  String response = sc2.nextLine();
//	  System.out.println("You entered: " + response);
//	  if (response.equals("N")) {
//		  System.out.println("You have chosen not to request a report. Have a nice day!");
//	  }
//	  else if (response.equals("Y")) {
//		  rc.requestReports();
//	  }
//	  else {
//		  System.out.println("You have entered an invalid input.");
//	  }
//	  sc2.close();
//	  return;
//  }

  /** This class allows a manager to enter login credentials to securely log into the system. */
  public void managerLoginAndChooseAction() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username and click Enter: ");
    String username = sc.nextLine();
    System.out.println("Enter password and click Enter: ");
    String password = sc.nextLine();
    int isUsernameValid = isStrInUsernameArr(username);
    boolean loggedIn;
    if (isUsernameValid == -1) {
      System.out.println("Username is not valid.");
      loggedIn = false;
    }
    else {
    	if (!isPasswordRight(password, isUsernameValid)) {
    		System.out.println("Password is incorrect.");
    		loggedIn = false;
    	}
    	else {
    		System.out.println("Welcome, user.");
    		loggedIn = true;
    	}
    }
    if (!loggedIn) {
    	return;
    }
    ReportController rc = new ReportController();
	System.out.println("Would you like to request a report? Type 'Y' for Yes and 'N' for No");
	String response = sc.nextLine();
	System.out.println("You entered: " + response);
	if (response.equals("N")) {
		System.out.println("You have chosen not to request a report. Have a nice day!");
	}
	else if (response.equals("Y")) {
		rc.requestReports();
	}
	else {
		System.out.println("You have entered an invalid input.");
	}
	sc.close();
	return;
  }
  
  public int isStrInUsernameArr(String str) {
	  for (int i = 0; i < usernameArr.length; i++) {
		  if (str.equals(usernameArr[i])) {
			  return i;
		  }
	  }
	  return -1;
  }
  
  public boolean isPasswordRight(String str, int index) {
	  if (str.equals(passwordArr[index])) {
		  return true;
	  }
	  return false;
  }
}
