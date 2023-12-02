package chocAnSystem;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

public class ProviderController {
	public ProviderController() {
	}
	

	
	
	private static void debug(String text) {
		System.out.println(text);
	}
	
	public static void billChocAn() {
		
		
		debug("Enter Member ID");
		String memberID = System.in.toString();
		String userInput;
		String curTime, serviceTime, providerID, serviceCode, comments;
		
		
		
		providerID = "3";
		
		
		
		
		
		boolean exit = false;
		
		while(!exit) {
			//checks to make sure the member ID is valid. If not, user is prompted to try a different ID.
			while(!verifyMember(memberID)) {
				debug("Try again? (y/n)");
				userInput = System.in.toString();
				if(userInput.equals("n")) exit = true;
				debug("Enter Member ID");
				memberID = System.in.toString();
			}
			
			//prompts user for date in correct format. Validates date format.
			debug("Enter service date (MM-DD-YYYY)");
			userInput = System.in.toString();
			while(userInput.charAt(2) != '-' && userInput.charAt(5) != '-' && userInput.length() != 10) {
				debug("Invalid date format used. Please try again");
				userInput = System.in.toString();
			}
			serviceTime = userInput;
			
			
			serviceCode = checkCode(exit, userInput);
			
			
			
			debug("Enter in comments about service or hit enter to leave blank");
			userInput = System.in.toString();
			comments = userInput;
			
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    curTime = formatter.format(date);  
			
			try {
				FileWriter fw = new FileWriter(curTime + "_" + providerID);
				fw.write(curTime);
				fw.write(serviceTime);
				fw.write(providerID);
				fw.write(memberID);
				fw.write(serviceCode);
				fw.write(comments);
				
			}
			catch (Exception e) {
				
			}
			
			
			
			
			

			
			
			
		}
		
		
			
			
			
		
	}
	
	public static boolean verifyMember(String testID) {
		boolean memberExists = false;
		debug("Beginning member verification process...");
		debug("Connecting to member database...");
		try {
		      File file = new File("memberData.txt");
		      debug("Connected. Verifying member...");
		      Scanner reader = new Scanner(file);
		      while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        String curID = data.substring(data.indexOf(",") + 1, data.indexOf(",", data.indexOf(",") + 1));
		        debug(curID);
		        if(testID.equals(curID)) {
		        	memberExists = true;
		        	break;
		        }
		      }
		      reader.close();
		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    }
		if (!memberExists) debug("Invalid member ID");
		else debug("Member validated!");
		return memberExists;
	}
	
	public void requestDirectory() {
		
		System.out.println("gimme directory");
	}
	
	
	private static String checkCode(boolean exit, String userInput) {
		//prompts the user for service code. checks if invalid.
		debug("Enter the service code for the service provided.");
		userInput = System.in.toString();
		String serviceName = ProviderDirectory.getService(Integer.parseInt(userInput));
		
		while(serviceName.equals("Service code not found.")) {
			debug("Try again? (y/n)");
			userInput = System.in.toString();
			if(userInput.equals("n")) {
				exit = true;
				return "";
			}
			debug("Enter the service code for the service provided.");
			userInput = System.in.toString();
			serviceName = ProviderDirectory.getService(Integer.parseInt(userInput));
		}
		String serviceCode = userInput;
		
		debug("Entered code: " + userInput + ". Associated Service: " + serviceName + ". Correct? (y/n)");
		userInput = System.in.toString();
		if(userInput.equals("n")) {
			checkCode(exit, userInput);
		}
		
		return serviceCode;
	}
	
	
}
