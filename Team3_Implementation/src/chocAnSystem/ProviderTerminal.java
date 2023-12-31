/** @author Ryan McCulley*/
package chocAnSystem;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** This class calls the methods within the ProviderController so the provider can perform certain actions. */
public class ProviderTerminal {
  private static String providerUsername = "";
  private static String providerPassword = "";
  ArrayList<String> usernames = new ArrayList<String>();
  ArrayList<String> passwords = new ArrayList<String>();
  public Scanner sc = new Scanner(System.in);
  public String pID;
  int counter = 0;

  /** This is the Default Constructor */
  public ProviderTerminal() {
	//providerUsername = "Meowy";
	//providerPassword = "meowPass";
  }

  /** This is the Primary Constructor with parameters */
  public ProviderTerminal(String pass, String name) {
	providerUsername = name;
    providerPassword = pass;
    }

  /** This method allows the provider to login */
  public void providerLogin() {
	  // Prompt user for username
	  System.out.println("Enter username and click Enter: ");
	  String username = sc.nextLine();
	  // Prompt user for password
	  System.out.println("Enter password and click Enter: ");
	  String password = sc.nextLine();
	  // Check if username is valid and return its index in username array. Return -1 if not found
	  int isUsernameValid = isStrInUsernameArr(username);
	  boolean loggedIn; // Create loggedIn boolean variable to continue prompting user for login info through while loop
	  while(true) {
		  if (isUsernameValid == -1) { // If username is wrong, user is not logged in
			  loggedIn = false;
			  int meow = usernames.size()-1;
			  while(usernames.size()>0) {
				  usernames.remove(meow);
				  meow--;
			  }
		  }
		  else {
			  if (!isPasswordRight(password, isUsernameValid)) { // if password is wrong, user is not logged in
				  loggedIn = false;
				  int meow = passwords.size()-1;
				  while(passwords.size()>0) {
					  passwords.remove(meow);
					  usernames.remove(meow);
					  meow--;
				  }
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

 /** This gets the ID for provider Controller */
 public static String getPID() {
	 return providerPassword;
 }
 
 /** This gets the username for provider Controller */
 public static String getPName() {
	 return providerUsername;
 }
  
  /** This method allows a provider to choose an action. */
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
		System.out.println("Would you like to perform another action? Enter Y for yes and N for no.");
		response = sc.nextLine();
		while(true) {
			if(response.equals("Y")) {
				chooseAction();
			}
			else if(response.equals("N")) {
				System.out.println("You will now be logged out.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid response. Please try again");
				response = sc.nextLine();
			}
			
		  }
		
	}
	
	else if (response.equals("Verify Member")) {
		System.out.println("Enter Member ID: ");
		pID = sc.nextLine();
		while(pID.length() != 9) {
			System.out.println("You entered: " + pID + ", please enter a valid Member ID:");
			pID = sc.nextLine();
		}
		pc.verifyMember(pID); // Runs Verify Member
		System.out.println("Would you like to perform another action? Enter Y for yes and N for no.");
		response = sc.nextLine();
		while(true) {
			if(response.equals("Y")) {
				chooseAction();
			}
			else if(response.equals("N")) {
				System.out.println("You will now be logged out.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid response. Please try again");
				response = sc.nextLine();
			}
			
		  }
	}
	
	else if (response.equals("Request Directory")) {
		pc.requestDirectory(); // Runs Request Directory
		System.out.println("Would you like to perform another action? Enter Y for yes and N for no.");
		response = sc.nextLine();
		while(true) {
			if(response.equals("Y")) {
				chooseAction();
			}
			else if(response.equals("N")) {
				System.out.println("You will now be logged out.");
				System.exit(0);
			}
			else {
				System.out.println("Invalid response. Please try again");
				response = sc.nextLine();
			}
			
		  }
		
	}
	return;
  }
  
  /** This method checks to see if the username entered is a valid username. It returns -1 if not valid and the index of the username in the username array if it is valid. */
  public int isStrInUsernameArr(String str) {
	  File pFile = new File("providerData.txt");
	  try {
		  Scanner reader = new Scanner(pFile);
		  
		  String data = "";
		  String lines;
		  counter = 0;
		  
		  while(reader.hasNextLine()) {
			  
			  lines = reader.nextLine();
			  while(lines.charAt(counter) != ',') {
				  data = data + lines.charAt(counter);
				  counter++;
				  
			  }
			  
			  usernames.add(data);
			  data = "";
			  counter = 0;
			  
		  }
		
		  reader.close();
	  
	  } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	  
	  for (int i = 0; i < usernames.size(); i++) { // Use for loop to iterate through string
		  if (str.equals(usernames.get(i))) { // If entered username equals current element in array
			  return i; // Return index found
		  }
	  }
	  return -1; // Return -1 if username does not exist.
  }
  
  /** This method checks to see if the password is correct. It is only called if the username is valid, and it checks that the password entered is the password found at the index of the correct username in the password array.*/
  public boolean isPasswordRight(String str, int index) {
	  
	  File pFile = new File("providerData.txt");
	  try {
		  Scanner reader = new Scanner(pFile);
		  
		  String data = "";
		  String lines;
		  counter = 0;
		  
		  while(reader.hasNextLine()) {
			  
			  lines = reader.nextLine();
			  while(lines.charAt(counter) != ',') {
				  counter++;
			  }
			  counter += 2;
			  while(lines.charAt(counter) != ',') {
				  data = data + lines.charAt(counter);
				  counter++;
			  }
			  passwords.add(data);
			  data = "";
			  counter = 0;	  
		  }
		  
		  reader.close();
	  
	  } catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	  
	  if (str.equals(passwords.get(index))) { // Use str.equals() method to see if password matches username
		  return true; // Return true if password is right
	  }
	  return false; // Return false if password is wrong
  }
}