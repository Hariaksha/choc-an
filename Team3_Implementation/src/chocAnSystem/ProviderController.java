package chocAnSystem;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProviderController {
	public ProviderController() {
	}
	
	private static void debug(String text) {
		System.out.println(text);
	}
	
	public void billChocAn() {
		
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
		if (!memberExists) debug("There is no valid member for this ID");
		else debug("Member found!");
		return memberExists;
	}
	
	public void requestDirectory() {
		
		System.out.println("gimme directory");
	}
}
