/** @author Robert Read*/
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
	
	private static Scanner sc = new Scanner(System.in);
	
	//Replacement for system.out.println because I'm lazy.
	private static void debug(String text) {
		System.out.println(text);
	}
	
	/**
	 * This is the method for when the provider wants to bill ChocAn. It prompts the provider for all of the relevant info,
	 * does all of the verification steps, etc.
	 */
	public static void billChocAn() {

		
		debug("Enter Member ID");
		String memberID = getInput();
		String userInput;
		String curTime, serviceTime, providerID, serviceCode, comments;
		double servicePrice;
		
		
		providerID = "3";
		
		
		
		
		
		boolean exit = false;
		
		while(!exit) {
			//checks to make sure the member ID is valid. If not, user is prompted to try a different ID.
			while(!verifyMember(memberID)) {
				debug("Try again? (y/n)");
				userInput = getInput();
				if(userInput.equals("n")) {exit = true; break;}
				debug("Enter Member ID");
				memberID = getInput();
			}
			
			
			
			
			
			
			
			//prompts user for date in correct format. Validates date format.
			debug("Enter service date (MM-DD-YYYY)");
			userInput = getInput();
			
			while(userInput.charAt(2) != '-' || userInput.charAt(5) != '-' || userInput.length() != 10) {
				
				
				debug(userInput);
				debug(""+userInput.charAt(2));
				debug(""+userInput.charAt(5));
				debug(""+userInput.length());
				
				
				
				
				debug("Invalid date format used. Please try again");
				userInput = getInput();
				
				
				break;
			}
			serviceTime = userInput;
			
			serviceCode = checkCode(exit, userInput);
			
			if(exit) break;
			
			
			
			debug("Enter in comments about service or hit enter to leave blank");
			userInput = getInput();
			comments = userInput;
			
			servicePrice = ProviderDirectory.getPrice(serviceCode);
			debug("Price of service: " + servicePrice);
			
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    curTime = formatter.format(date);  
		    debug("Attempting to write to file");
		    String filename = serviceTime + "_" + serviceCode + "_" + memberID + ".txt";
			try {
				debug("filename: " + filename);
				FileWriter fw = new FileWriter(filename);
				debug("File created.");
				fw.write("Current Time: " + curTime + 
						 "\nDate of Service: " + serviceTime + 
						 "\nProvider ID: " + providerID + 
						 "\nMember ID: " + memberID + 
						 "\nService Code: " + serviceCode + 
						 "\nPrice: " + servicePrice + 
						 "\nComments: " + comments);
				fw.close();
				debug("File written");
				
			}
			catch (Exception e) {
				
			}
			
			
			break;
		}
		
		
			
		
	}
	
	public static boolean verifyMember(String testID) {
		debug("Beginning member verification process...");
		debug("Connecting to member database...");
		try {
		      File file = new File("memberData.txt");
		      debug("Connected. Verifying member...");
		      Scanner reader = new Scanner(file);
		      while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        String curID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));
		        if(testID.equals(curID)) {
		        	debug("Member validated!");
		        	reader.close();
		        	return true;
		        }
		      }
		      reader.close();
		      debug("Invalid member ID");
		      return false;
		      
		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    }
		return false;
	}
	
	
	
	
	
	
	
	
	public void requestDirectory() {
		debug("Requesting Service Directory");
		
		ProviderDirectory.makeDirectory();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private static String checkCode(boolean exit, String userInput) {
		//prompts the user for service code. checks if invalid.
		debug("Enter the service code for the service provided.");
		userInput = getInput();
		String serviceName = ProviderDirectory.getService(userInput);
		
		while(serviceName.equals("Service code not found.")) {
			debug("Try again? (y/n)");
			userInput = getInput();
			if(userInput.equals("n")) {
				exit = true;
				return "";
			}
			debug("Enter the service code for the service provided.");
			userInput = getInput();
			serviceName = ProviderDirectory.getService(userInput);
		}
		String serviceCode = userInput;
		
		debug("Entered code: " + userInput + ". Associated Service: " + serviceName + ". Correct? (y/n)");
		userInput = getInput();
		if(userInput.equals("n")) {
			checkCode(exit, userInput);
		}
		
		return serviceCode;
	}
	
	
	public static String getInput() {
        String out = sc.next();
        debug(out);
        return out;
    }	
	

}

