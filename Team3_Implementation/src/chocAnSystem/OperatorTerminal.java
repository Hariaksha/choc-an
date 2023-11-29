package chocAnSystem;
import java.util.Scanner;

public class OperatorTerminal {
	public String operatorPassword;
	public String operatorUsername;
//	private String passwordArr[] = {"password999", "password888"};
//	private String usernameArr[] = {"Hari", "James"};
	
	public OperatorTerminal() {
	    operatorUsername = "random username";
	    operatorPassword = "Password";
	  }
	
	public OperatorTerminal(String pass, String name) {
	    operatorUsername = name;
	    operatorPassword = pass;
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
//		else if() {
//			
//		}
		sc.close();
	}
}
	
	