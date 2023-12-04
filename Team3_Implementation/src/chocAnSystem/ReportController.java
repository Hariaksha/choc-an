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
		//System.out.println("Compiling Member Report");
		
		//loop thru each member.
		//for each member, add their info to the doc
		//check all files generated with the member's memberID in the name
		//get relevant info from those files
		
		try {
		      File memberFile = new File("memberData.txt");	//load member data
		      Scanner memberData = new Scanner(memberFile);
		      
		      File folder = new File("Service_Logs/");	//load the full folder of service logs
		      File[] ServiceLogList = folder.listFiles();
		      
		      while (memberData.hasNextLine()) {	//while there is still text in the memberData file,
		        String data = memberData.nextLine();	//store that line.
		        if (data.equals("")) continue;	//if there's a blank line, skip.
		        
		        
		        String curID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));	//Get the member ID of the current member.
		        
		        FileWriter memFile = new FileWriter("MemberReports/" + curID + "_Report.txt");
		        
		        String memFileText = data + "\nAll services provided:\n";
		        
		        for(int i = 0; i < ServiceLogList.length; i++) {			//For every file in the service log folder,
		        	if (ServiceLogList[i].getName().contains(curID)) {		//if the log's name contains the current member's ID,
		        		Scanner curFile = new Scanner(ServiceLogList[i]);	//start a scanner to look at that log.
		        		String curData;
		        		memFileText += "Service:\n";
		        		
		        		String filename = ServiceLogList[i].getName();
		        		
		        		
		        		 while (curFile.hasNextLine()) {					//While the current log has text,
		        			 curData = curFile.nextLine();					//store that next line.
		        			 if (curData.contains("Date of Service:")) {	//If the line contains 'Date of Service:',
		        				 memFileText += curData + "\n";				//add it to what needs to be written to the report.
		        				 
		        				 
		        				 
		        			 }
		        			 if (curData.contains("Service Name:")) memFileText += curData + "\n";
		        		 }
		        		 curFile.close();
		        	  }
		        	
		        }
		        memFile.write(memFileText);
		        memFile.close();
		        
		        
		      }
		      memberData.close();

		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    }
	}
	
	
	/** Stand-in for Provider Report Compiler.*/
	public void providerReport(){
		
		try {
		      File ProviderData = new File("ProviderData.txt");
		      Scanner reader = new Scanner(ProviderData);
		      
		      File folder = new File("Service_Logs/");
		      File[] listOfFiles = folder.listFiles();
		      
		      while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        if (data.equals("")) continue;
		        
		        
		        String curID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));
		        
		        //File memFile = new File();
		        FileWriter memProvFile = new FileWriter("ProviderReports/" + curID + "_Report.txt");
		        
		        String memFileText = data + "\nAll services provided:\n";
		        
		        for(int i = 0; i < listOfFiles.length; i++) {
		        	if (listOfFiles[i].getName().contains(curID)) {
		        		Scanner curFile = new Scanner(listOfFiles[i]);
		        		String curData;
		        		memFileText += "Service:\n";
		        		 while (curFile.hasNextLine()) {
		        			 curData = curFile.nextLine();
		        			 //if (curData.contains("Date of Service:") || curData.contains("Provider Name:") || curData.contains("Service Name:")) memFileText += curData + "\n";
		        			 if (curData.contains("Current Time: ")) memFileText += "Time service entered in computer: " + curData.substring(14) + "\n";
		        			 if (curData.contains("Date of Service:")) {
		        				 memFileText += curData + "\n";
		        				 memFileText += 
		        			 }
		        			 if (curData.contains("Provider Name:")) memFileText += curData + "\n";
		        			 if (curData.contains("Service Name:")) memFileText += curData + "\n";
		        		 }
		        		 curFile.close();
		        	  }
		        	
		        }
		        memProvFile.write(memFileText);
		        memProvFile.close();
		        
		        
		      }
		      reader.close();

		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
//		System.out.println("Compiling Provider Report");
//		try {
//			BufferedReader r = new BufferedReader( new FileReader("providerData.txt") );
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
