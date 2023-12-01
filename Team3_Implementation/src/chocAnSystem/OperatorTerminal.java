package chocAnSystem;
import java.util.Scanner;

public class OperatorTerminal {
	public String operatorPassword;
	public String operatorUsername;
	private String passwordArr[] = {"password999", "password888"};
	private String usernameArr[] = {"Hari", "James"};
	public Scanner sc = new Scanner(System.in);
	
	/** This is a Default Constructor that will be used in case arguments are accidentally not passed. */
	public OperatorTerminal() {
	    operatorUsername = "random username";
	    operatorPassword = "Password";
	  }
	
	/** This is the Primary Constructor. This recommended for use. */
	public OperatorTerminal(String pass, String name) {
	    operatorUsername = name;
	    operatorPassword = pass;
	    }
	
	/** Here is where an operator can login the operator terminal. After they log in, they
	  want to edit a member or provider. */
	public void login() {
		//Scanner sc1 = new Scanner(System.in);
		//String response1 = "";
		
		System.out.println("Enter username and click Enter: ");
	    String username = sc.nextLine();
	    System.out.println("Enter password and click Enter: ");
	    String password = sc.nextLine();
	    int isUsernameValid = isStrInUsernameArr(username);
	    boolean loggedIn;
	    while(true) {
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
	
	public void chooseAction() {
		Scanner sc = new Scanner(System.in);
		String response = "";
	
		System.out.println("Would you like to edit a member or a provider? Type M for member and P for provider.");
		response = sc.nextLine();
		while(!response.equals("M") && !response.equals("P")) {
		if(!response.equals("M") && !response.equals("P")) {
			System.out.println("You entered an invalid response. Please try again" + response);
			response = sc.nextLine();
			}
		}
		if(response.equals("M")) {
			System.out.println("You have decided to edit a member.");
			UpdateMember updateMember = new UpdateMember();
			//System.out.println("Would you like to add, delete, or update  member? \n A - add \n D - delete \n U - update");
			updateMember.start();
		}
//		else if(response.equals("P")) {
//			System.out.println("You have decided to edit a provider.");
//			UpdateProvider updateProvider = new UpdateProvider();
//			System.out.println("Would you like to add, delete, or update  member? \n A - add \n D - delete \n U - update");
//			updateProvider.start();
//		}
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
	//oopsssss
	