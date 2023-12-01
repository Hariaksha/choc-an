// Author: Hariaksha Gunda
package chocAnSystem;
import java.util.Scanner;

/** This declares the class attributes. */
public class ManagerTerminal {
  private String managerUsername;
  private String managerPassword;
  private String passwordArr[] = {"password123", "password321"}; // This variable and the next one are parallel arrays storing matching username and password pairs.
  private String usernameArr[] = {"Ethan", "Hari"};
  public Scanner sc = new Scanner(System.in);

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

  /** This method allows the manager to login. */
  public void login() {
	  System.out.println("Enter username and click Enter: ");
	  String username = sc.nextLine();
	  System.out.println("Enter password and click Enter: ");
	  String password = sc.nextLine();
	  int isUsernameValid = isStrInUsernameArr(username);
	  boolean loggedIn;
	  while(true) {
	  if (isUsernameValid == -1) {
	    loggedIn = false;
	  }
	  else {
	  	if (!isPasswordRight(password, isUsernameValid)) {
	  		loggedIn = false;
	  	}
	  	else {
	  		loggedIn = true;
	  	}
	  }
	  if (!loggedIn) {
	  	System.out.println("Invalid credentials. Please try again");
	  }
	  else if(loggedIn) {
	  	System.out.println("Successful login.");
	  	break;
	  }
	  System.out.println("Enter username and click Enter: ");
	  username = sc.nextLine();
	  System.out.println("Enter password and click Enter: ");
	  password = sc.nextLine();
	  isUsernameValid = isStrInUsernameArr(username);
	}
  }
  
  /** This method allows a manager to enter login credentials to securely log into the system, and then choose an action. */
  public void chooseAction() {
    ReportController rc = new ReportController(); // Create ReportController object
	System.out.println("Would you like to request a report? Type 'Y' for Yes and 'N' for No"); // Prompt user to choose to request a report
	String response = sc.nextLine();
	
	while (!(response.equals("Y") || response.equals("N"))) { // Prompt for correct response until correct response is given
		System.out.println("You entered: " + response);
		if (!(response.equals("Y") || response.equals("N"))) {
			System.out.println("You have entered an invalid input. Please try again"); // Reprompt
			response = sc.nextLine();
		}
	}
	
	if (response.equals("N")) {
		System.out.println("You have chosen not to request a report. Have a nice day!");
	}
	else if (response.equals("Y")) {
		rc.requestReports(); // Request reports using report controller objects
	}
	return;
  }
  
  /**This method checks to see if the username entered is a valid username. It returns -1 if not valid and the index of the username in the username array if it is valid.*/
  public int isStrInUsernameArr(String str) {
	  for (int i = 0; i < usernameArr.length; i++) {
		  if (str.equals(usernameArr[i])) {
			  return i;
		  }
	  }
	  return -1;
  }
  
  /**This method checks to see if the password is correct. It is only called if the username is valid, and it checks that the password entered is the password found at the index of the correct username in the password array.*/
  public boolean isPasswordRight(String str, int index) {
	  if (str.equals(passwordArr[index])) {
		  return true;
	  }
	  return false;
  }
}
