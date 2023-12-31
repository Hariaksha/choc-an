/** @author Owner Ethan Busby*/

package chocAnSystem;
import java.util.Scanner;

/** This class calls the update member and provider classes so the operator can perform different tasks.*/
public class OperatorTerminal {
	public String operatorPassword;
	public String operatorUsername;
	private String passwordArr[] = {"000000000", "111111111"};
	private String usernameArr[] = {"Hari", "James"};
	public Scanner sc = new Scanner(System.in);
	
	/** This is a Default Constructor that will be used in case arguments are accidentally not passed.*/
	public OperatorTerminal() {
	    operatorUsername = "random username";
	    operatorPassword = "Password";
	  }
	
	/** This is the Primary Constructor. This recommended for use. */
	public OperatorTerminal(String pass, String name) {
	    operatorUsername = name;
	    operatorPassword = pass;
	    }
	
	/** Here is where an operator can login the operator terminal. If there are
	 invalid credentials, then they can try again. */
	public void login() {
		//Scanner sc1 = new Scanner(System.in);
		//String response1 = "";
		
		System.out.println("Enter username and click Enter: ");
		String username = sc.nextLine();
	    System.out.println("Enter password and click Enter: ");
	    String password = sc.nextLine();
	    int isUsernameValid = isStrInUsernameArr(username);
	    boolean loggedIn;
	    int tries = 0;
	    while(true) {
	    	if(tries > 3) {
				   System.out.println("Failed too many times. You will be logged out.");
				   System.exit(0);
			   }
	    if (isUsernameValid == -1) {
	      //System.out.println("Username is not valid.");
	      loggedIn = false;
	    }
	    else {
	    	if (!isPasswordRight(password, isUsernameValid)) {
	    		//System.out.println("Password is incorrect.");
	    		loggedIn = false;
	    	}
	    	else {
	    		//System.out.println("Welcome, user.");
	    		loggedIn = true;
	    	}
	    }
	    if (!loggedIn) {
	    	System.out.println("Invalid credentials. Please try again");
	    	tries++;
//	    	sc.close();
//	    	return;
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
	   //sc.close();

	
	}
	/** This is where a operator chooses whether they want to edit a member or provider.*/
	public void chooseAction() {
		//Scanner sc = new Scanner(System.in);
		String response = "";
	
		System.out.println("Would you like to edit a member or a provider? Type M for member and P for provider.");
		response = sc.nextLine();
		while(!response.equals("M") && !response.equals("P")) {
		if(!response.equals("M") && !response.equals("P")) {
			System.out.println("You entered an invalid response. Please try again");
			response = sc.nextLine();
			}
		}
		if(response.equals("M")) {
			System.out.println("You have decided to edit a member.");
			UpdateMember updateMember = new UpdateMember();
			//System.out.println("Would you like to add, delete, or update  member? \n A - add \n D - delete \n U - update");
			updateMember.startMemberUpdate();
			System.out.println("Would you like to update a provider. Y for yes and N for no.");
			response = sc.nextLine();
			while(true) {
			if(response.equals("Y")) {
				UpdateProvider updateProvider = new UpdateProvider();
				updateProvider.startProviderUpdate();
			}
			else if(response.equals("N")) {
				System.out.println("You have selected no. You will be logged out");
				return;
			}
			else {
			System.out.println("Invalid response. Please try again");
			response = sc.nextLine();
			} 
		  }
		}
		else if(response.equals("P")) {
			System.out.println("You have decided to edit a provider.");
			UpdateProvider updateProvider = new UpdateProvider();
			//System.out.println("Would you like to add, delete, or update  member? \n A - add \n D - delete \n U - update");
			updateProvider.startProviderUpdate();
			System.out.println("Would you like to update a member. Y for yes and N for no.");
			response = sc.nextLine();
			while(true) {
				if(response.equals("Y")) {
					UpdateMember updateMember = new UpdateMember();
					updateMember.startMemberUpdate();
				}
				else if(response.equals("N")) {
					System.out.println("You have selected no. You will be logged out");
					return;
				}
				else {
				System.out.println("Invalid response. Please try again");
				response = sc.nextLine();
				} 
			  }
		}
		sc.close();
	}
	
	/** This determines where a valid username is in the array. It also saves the index
	 that the username is at in the array.*/
	public int isStrInUsernameArr(String str) {
		  for (int i = 0; i < usernameArr.length; i++) {
			  if (str.equals(usernameArr[i])) {
				  return i;
			  }
		  }
		  return -1;
	  }
	  /** This checks to make sure the password matches up with the correct username. */
	  public boolean isPasswordRight(String str, int index) {
		  if (str.equals(passwordArr[index])) {
			  return true;
		  }
		  return false;
	  }
}

//edit
	