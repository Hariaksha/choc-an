/** @author Tyler Cruise*/

package chocAnSystem;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Performs all the actions of the manager and runs the main accounting procedure.*/
public class ReportController {
	/** Constructor.*/
	public ReportController() {}
	
	private static void debug(String text) {
		System.out.println(text);
	}
	
	/** Stand-in for EFT Report Compiler.*/
	public void eftReport(){		
		System.out.println("Compiled EFT Report");
	}
	
	/** Stand-in for Summary Report Compiler.*/
	public void summaryReport(){		
		System.out.println("Compiled Summary Report");
	}
	
	/** Reads data from text file and prints it to Console.*/
	public void memberReport()throws IOException{		
		System.out.println("Compiling Member Report");
		
		//loop thru each member.
		//for each member, add their info to the doc
		//check all files generated with the member's memberID in the name
		//get relevant info from those files
		
		try {
		      File memberData = new File("memberData.txt");
		      Scanner reader = new Scanner(memberData);
		      
		      File folder = new File("Service_Logs/");
		      File[] listOfFiles = folder.listFiles();
		      
		      while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        if (data.equals("")) continue;
		        
		        
		        String curID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));
		        
		        //File memFile = new File();
		        FileWriter memFile = new FileWriter("MemberReports/" + curID + "_Report.txt");
		        
		        String memFileText = data + "\nAll services provided:\n";
		        
		        for(int i = 0; i < listOfFiles.length; i++) {
		        	if (listOfFiles[i].getName().contains(curID)) {
		        		Scanner curFile = new Scanner(listOfFiles[i]);
		        		 while (curFile.hasNextLine()) {
		        			 String curData = curFile.nextLine();
		        			 if (curData.contains("Date of Service:")) memFileText += curData + "\n";
		        			 if (curData.contains("Provider Name:")) memFileText += curData + "\n";
		        			 if (curData.contains("Service Name:")) memFileText += curData + "\n";
		        		 }
		        		 curFile.close();
		        	  }
		        	
		        }
		        memFile.write(memFileText);
		        memFile.close();
		        
		        
		      }
		      reader.close();

		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    }
		
		
		
		
//		try {
//			BufferedReader r = new BufferedReader( new FileReader("memberData.txt") );
//			String s = "", line = null;
//			while ((line = r.readLine()) != null) {
//				s += line;
//				s += "\n";
//			}
//			System.out.print(s);
//			r.close();
//		}
//		
//        catch (IOException e) 
//        { 
//            e.printStackTrace();
//        }
	}
	
	
	/** Stand-in for Provider Report Compiler.*/
	public void providerReport(){
		System.out.println("Compiling Provider Report");
		try {
			BufferedReader r = new BufferedReader( new FileReader("providerData.txt") );
			String s = "", line = null;
			while ((line = r.readLine()) != null) {
				s += line;
				s += "\n";
			}
			System.out.print(s);
			r.close();
		}
		
        catch (IOException e) 
        { 
            e.printStackTrace();
        }
	}
	
	/** Called by Timer, runs all compilers.*/
	public void runAccountingProcedure()throws IOException{
		System.out.println("Running Accounting Procedure");
		providerReport();
		memberReport();
		summaryReport();
		eftReport();
		System.out.println("Accounting Procedure Completed");
	}
	
	/** Called my Manager; Runs desired report compiler after an input.*/
	public void requestReports()throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Desired Report Value: \n 1: Provider Report \n 2: Member Report \n 3: Summary Report \n 4: EFT Report");
		int input = sc.nextInt();
		
		if(input == 1) {
			System.out.println("Compiling Provider Report");
			providerReport();
			System.out.println("Would you like to request another report? Type '1' for yes and any other integer for no");
			int nextInput = sc.nextInt();
			if (nextInput == 1) {
				System.out.println("You have chosen to request another report");
				requestReports();
			}
			else {
				System.out.println("You have chosen not to request another report");
			}
		}
		else if(input == 2) {
			System.out.println("Compiling Member Report");
			memberReport();
			System.out.println("Would you like to request another report? Type '1' for yes and any other integer for no");
			int nextInput = sc.nextInt();
			if (nextInput == 1) {
				System.out.println("You have chosen to request another report");
				requestReports();
			}
			else {
				System.out.println("You have chosen not to request another report");
			}
		}
		else if(input == 3) {
			System.out.println("Compiling Summary Report");
			summaryReport();
			System.out.println("Would you like to request another report? Type '1' for yes and any other integer for no");
			int nextInput = sc.nextInt();
			if (nextInput == 1) {
				System.out.println("You have chosen to request another report");
				requestReports();
			}
			else {
				System.out.println("You have chosen not to request another report");
			}
		}
		else if(input == 4) {
			System.out.println("Compiling EFT Report");
			eftReport();
			System.out.println("Would you like to request another report? Type '1' for yes and any other integer for no");
			int nextInput = sc.nextInt();
			if (nextInput == 1) {
				System.out.println("You have chosen to request another report");
				requestReports();
			}
			else {
				System.out.println("You have chosen not to request another report");
			}
		}
		else {
			System.out.println("Invalid Input");
			requestReports();
		}
		sc.close();
	}
	
	
	private void formatReport(String fileName) {
		try {
			FileWriter fw = new FileWriter("src/chocAnSystem/" + fileName + ".txt");
			fw.write("This is a test");
			fw.close();
		}
		catch(Exception e){
			System.out.println(e);
		
	}
   }
}
