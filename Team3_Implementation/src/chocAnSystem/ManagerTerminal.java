// Author: Hariaksha Gunda
package chocAnSystem;
import java.util.Scanner;

/** This declares the class attributes. */
public class ManagerTerminal {
  private String managerUsername;
  private String managerPassword;
  private String passwordArr[] = {"222222222", "333333333"}; // This variable and the next one are parallel arrays storing matching username and password pairs.
  private String usernameArr[] = {"Ethan", "Tyler"};
  public Scanner sc = new Scanner(System.in);
  public static String errorCode;

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
	  // Prompt user for username
	  System.out.println("Enter username and click Enter: ");
	  String username = sc.nextLine();
	  // Prompt user for password
	  System.out.println("Enter password and click Enter: ");
	  String password = sc.nextLine();
	  // Check if username is valid and return its index in username array. Return -1 if not found
	  int isUsernameValid = isStrInUsernameArr(username);
	  boolean loggedIn; // Create loggedIn boolean variable to continue prompting user for login info through while loop
	  int tries = 1; // To create limited try count
	  while(true) {
		  if(tries > 3) {
			  System.out.println("Failed too many times. You will be logged out.");
			  System.exit(0);
		  }
		  if (isUsernameValid == -1) { // If username is wrong, user is not logged in
			  loggedIn = false;
		  }
		  else {
			  if (!isPasswordRight(password, isUsernameValid)) { // if password is wrong, user is not logged in
				  loggedIn = false;
			  }
			  else { // user is logged in if username and password is correct
				  loggedIn = true;
			  }
		  }
		  // Tell user if login credentials worked
		  if (!loggedIn) {
			  System.out.println("Invalid credentials. Please try again");
			  tries++;
		  }
		  else if(loggedIn) {
			  System.out.println("Successful login.");
			  break;
		  }
		  // Reprompt user for login credentials if loop does not break
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
		System.out.println("You have chosen not to request a report. Have a nice day!"); // Say goodbye to user
	}
	else if (response.equals("Y")) {
		rc.requestReports(); // Request reports using report controller objects
	}
	return;
  }
  
  /**This method checks to see if the username entered is a valid username. It returns -1 if not valid and the index of the username in the username array if it is valid.*/
  public int isStrInUsernameArr(String str) {
	  for (int i = 0; i < usernameArr.length; i++) { // Use for loop to iterate through string
		  if (str.equals(usernameArr[i])) { // If entered username equals current element in array
			  return i; // Return index found
		  }
	  }
	  return -1; // Return -1 if username does not exist.
  }
  
  /**This method checks to see if the password is correct. It is only called if the username is valid, and it checks that the password entered is the password found at the index of the correct username in the password array.*/
  public boolean isPasswordRight(String str, int index) {
	  if (str.equals(passwordArr[index])) { // Use str.equals() method to see if password matches username
		  return true; // Return true if password is right
	  }
	  return false; // Return false if password is wrong
  }
}
