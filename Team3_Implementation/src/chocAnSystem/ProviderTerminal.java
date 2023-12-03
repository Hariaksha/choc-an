// Author: Ryan McCulley
package chocAnSystem;
import java.util.Scanner;

/** This declares the class attributes. */
public class ProviderTerminal {
  private String providerUsername;
  private String providerPassword;
  private String passwordArr[] = {"121925030", "password649"}; // This variable and the next one are parallel arrays storing matching username and password pairs.
  private String usernameArr[] = {"Ryan", "Busby"};
  public Scanner sc = new Scanner(System.in);
  public String pID;

  // This is a Default Constructor
  public ProviderTerminal() {
	providerUsername = "Meowy";
	providerPassword = "meowPass";
  }

  // This is the Primary Constructor with parameters
  public ProviderTerminal(String pass, String name) {
	providerUsername = name;
    providerPassword = pass;
    }

  // This method allows the provider to login
  public void providerLogin() {
	  // Prompt user for username
	  System.out.println("Enter username and click Enter: ");
	  String username = sc.nextLine();
	  // Prompt user for p	assword
	  System.out.println("Enter password and click Enter: ");
	  String password = sc.nextLine();
	  // Check if username is valid and return its index in username array. Return -1 if not found
	  int isUsernameValid = isStrInUsernameArr(username);
	  boolean loggedIn; // Create loggedIn boolean variable to continue prompting user for login info through while loop
	  while(true) {
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
  
  // This method allows a provider to choose an action. */
  public void chooseAction() {
    ProviderController pc = new ProviderController(); // Creates a ProviderController
	System.out.println("Choose Action: Bill Choc An, Verify Member, Request Directory"); // Prompt user to choose an action between bill chocAn, Verify Member, and Request Directory
	String response = sc.nextLine();
	
	while (!(response.equals("Bill Choc An") || response.equals("Verify Member") || response.equals("Request Directory"))) { // Prompt for correct response until correct response is given
		System.out.println("You entered: " + response);
		if (!(response.equals("Bill Choc An") || response.equals("Verify Member") || response.equals("Request Directory"))) {
			System.out.println("You have entered an invalid input. Please try again"); // Reprompt
			response = sc.nextLine();
		}
	}
	
	if (response.equals("Bill Choc An")) {
		pc.billChocAn(); // Runs Bill Choc An
	}
	else if (response.equals("Verify Member")) {
		System.out.println("Enter Provider ID: ");
		pID = sc.nextLine();
		while(pID.length() != 9) {
			System.out.println("You entered: " + pID + ", please enter a valid Provider ID:");
			pID = sc.nextLine();
		}
		pc.verifyMember(pID); // Runs Verify Member
	}
	else if (response.equals("Request Directory")) {
		pc.requestDirectory(); // Runs Request Directory
	}
	return;
  }
  
  //This method checks to see if the username entered is a valid username. It returns -1 if not valid and the index of the username in the username array if it is valid.
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