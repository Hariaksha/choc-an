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
		
		try {
			File providerReports = new File("ProviderReports/");	//load the full folder of service logs
			File[] providerFolderList = providerReports.listFiles();
			
			File summaryFile = new File("Summary Report.txt");
			FileWriter summaryWriter = new FileWriter(summaryFile);
			String summaryText = "";
			int totalConsultations = 0;
			int totalFee = 0;
			for(int i = 0; i < providerFolderList.length; i++) {	//For every file in the service log folder,
				summaryText += "Provider: " + providerFolderList[i].getName().substring(0, providerFolderList[i].getName().indexOf('.'));
				
				Scanner curFile = new Scanner(providerFolderList[i]);	//start a scanner to look at that log.
        		String curData;
				while(curFile.hasNextLine()) {
					curData = curFile.nextLine();
					if(curData.contains("Total number of consultations:")) {
						summaryText += "\n" + curData;
						totalConsultations += Double.parseDouble(curData.substring(curData.indexOf(" ")));
						
					}
					if(curData.contains("Total fee to be paid:")) {
						summaryText += "\n" + curData;
						totalFee += Double.parseDouble(curData.substring(curData.indexOf(" ")));
					}
				}
			}
			summaryText += "\nTotal number of active providers this week: " + providerFolderList.length;
			summaryText += "\nTotal number of consultations: " + totalConsultations;
			summaryText += "\nTotal fee for all providers: " + totalFee;
			summaryWriter.write(summaryText);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
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
		        int numServices = 0;
		        
		        String curID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));	//Get the member ID of the current member.
		        File memFileFile = new File("MemberReports/" + curID + "_Report.txt");
		        FileWriter memFile = new FileWriter(memFileFile);
		        
		        String memFileText = data + "\nAll services provided:\n";
		        
		        for(int i = 0; i < ServiceLogList.length; i++) {			//For every file in the service log folder,
		        	if (ServiceLogList[i].getName().contains(curID)) {		//if the log's name contains the current member's ID,
		        		numServices++;
		        		Scanner curFile = new Scanner(ServiceLogList[i]);	//start a scanner to look at that log.
		        		String curData;
		        		memFileText += "Service:\n";
		        		
		        		File providerFile = new File("providerData.txt");	//load member data
		  		      	Scanner providerData = new Scanner(providerFile);
		        		
		        		String filename = ServiceLogList[i].getName();
		        		String providerID = filename.substring(0,filename.indexOf('_'));	//Get the ID of the provider of this service
						 String providerName = "";

						while (providerData.hasNextLine()) {	//while there is still text in the providerData file,
		        			String providerLine = providerData.nextLine();	//store that line.
		        			if (providerLine.contains(providerID)) providerName = providerLine.substring(0, providerLine.indexOf(','));	//If the line contains the ID of the provider in question, get the name of the Provider.
						}
		        		
		        		 while (curFile.hasNextLine()) {					//While the current log has text,
		        			 curData = curFile.nextLine();					//store that next line.
		        			 if (curData.contains("Date of Service:")) {	//If the line contains 'Date of Service:',
							 	memFileText += curData + "\n";				//add it to what needs to be written to the report.
								memFileText += providerName + "\n";			//Additionally, add the provider name to the report.
		        			 }
		        			 if (curData.contains("Service Name:")) memFileText += curData + "\n";
		        		 }
		        		 providerData.close();
		        		 curFile.close();
		        	  }
		        	
		        }
		        memFile.write(memFileText);
		        memFile.close();
		        if(numServices == 0) memFileFile.delete();
		        
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

			  File providerFile = new File("providerData.txt");	//load member data
		      Scanner providerData = new Scanner(providerFile);
		      
		      File folder = new File("Service_Logs/");	//load the full folder of service logs
		      File[] serviceLogList = folder.listFiles();
		      
		      while (providerData.hasNextLine()) {
		        String data = providerData.nextLine();
		        if (providerData.equals("")) continue;
		        
				double totalFee = 0;
				int numConsultations = 0;
		        
		        String providerID = data.substring(data.indexOf(',') + 2, data.indexOf(',', data.indexOf(',') + 1));
		        
		        File provFile = new File("ProviderReports/" + providerID + "_Report.txt");
		        FileWriter memProvFile = new FileWriter(provFile);
		        
		        String proFileText = data + "\nAll services provided:\n";
		        
		        for(int i = 0; i < serviceLogList.length; i++) {
		        	if (serviceLogList[i].getName().contains(providerID)) {
						numConsultations++;
		        		Scanner curFile = new Scanner(serviceLogList[i]);
		        		String curData;
						
						
						String memberName = "";
						String filename = serviceLogList[i].getName();
		        		String memberID = filename.substring(filename.lastIndexOf('_')+1, filename.lastIndexOf('.') -1);	//Get the ID of the member
		        		
		        		File memberFile = new File("memberData.txt");	//load member data
		        		Scanner memberData = new Scanner(memberFile);


						while (memberData.hasNextLine()) {	//while there is still text in the memberData file,
		        			String memberLine = memberData.nextLine();	//store that line.
		        			if (memberLine.contains(memberID)) memberName = memberLine.substring(0, memberLine.indexOf(','));	//If the line contains the ID of the provider in question, get the name of the Provider.
						}


		        		proFileText += "\nService:\n";
		        		 while (curFile.hasNextLine()) {
		        			 curData = curFile.nextLine();

		        			 if (curData.contains("Current Time: ")) proFileText += "Time service entered in computer: " + curData.substring(14) + "\n";
		        			 if (curData.contains("Date of Service:")) {

		        				 memFileText += curData + "\n";
		        				 memFileText += 
		        						 
		        				 proFileText += curData + "\n";
		        				 proFileText += memberName + "\n" + memberID + "\n";
		        			 }
		        			 if (curData.contains("Service code:")) proFileText += curData + "\n";
							 if (curData.contains("Price:")){
								totalFee += Double.valueOf(curData.substring(6));
								proFileText += curData + "\n";
							 }
								
		        		 }
		        		 memberData.close();
		        		 curFile.close();
		        	  }
		        	
		        }
				proFileText += "Total number of consultations: " + numConsultations + "\n";
				proFileText += "Total fee to be paid: " + totalFee;
		        memProvFile.write(proFileText);
		        memProvFile.close();
		        if(numConsultations == 0) provFile.delete();
		        
		      }
		      providerData.close();

		    } catch (FileNotFoundException e) {
		      debug("Member database not found, please try again later.");
		      e.printStackTrace();
		    } catch (IOException e) {
				// TODO Auto-generated catch block
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
