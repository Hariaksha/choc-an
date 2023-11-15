package chocAnSystem;
import java.util.Scanner;
import java.io.FileWriter;

public class ReportController {
	/** Constructor.*/
	public ReportController() {}
	
	/** Stand-in for EFT Report Compiler.*/
	public void eftReport(){		
		System.out.println("Compiled EFT Report");
	}
	
	/** Stand-in for Summary Report Compiler.*/
	public void summaryReport(){		
		System.out.println("Compiled Summary Report");
	}
	

	
	/** Stand-in for Provider Report Compiler.*/
	public void providerReport(){
		System.out.println("Compiled Provider Report");
	}
	
	/** Called by Timer, runs all compilers.*/
	public void runAccountingProcedure(){
		System.out.println("Running Accounting Procedure");
		providerReport();
		memberReport();
		summaryReport();
		eftReport();
		System.out.println("Accounting Procedure Completed");
	}
	
	/** Called my Manager; Runs desired report compiler after an input.*/
	public void requestReports(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Desired Report Value: \n 1: Provider Report \n 2: Member Report \n 3: Summary Report \n 4: EFT Report");
		int input = sc.nextInt();
		
		if(input == 1) {
			System.out.println("Compiling Provider Report");
			providerReport();
		}
		else if(input == 2) {
			System.out.println("Compiling Member Report");
			memberReport();
		}
		else if(input == 3) {
			System.out.println("Compiling Summary Report");
			summaryReport();
		}
		else if(input == 4) {
			System.out.println("Compiling EFT Report");
			eftReport();
		}
		else {
			System.out.println("Invalid Input");
		}
		sc.close();
	}
	

}
