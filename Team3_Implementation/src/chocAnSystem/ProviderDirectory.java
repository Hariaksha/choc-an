/** @author Robert Read*/
package chocAnSystem;

import java.io.FileWriter;

/** Holds all service codes, names, and prices. It also creates a text file.*/
public class ProviderDirectory {
	public ProviderDirectory() {
		
	}
	
	private static String serviceCodes[] = {"598470", "883948"};
	private static String serviceNames[] = {"dietitianAppt", "aerobicsSession"};
	private static double servicePrices[] = {125.73, 143.89};
	
	/** Provides a service based on the service code.*/
	public static String getService(String code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code.equals(serviceCodes[i])) {
				return serviceNames[i];
			}
		}
		
	return "Service code not found.";
	}
	
	/** Provides a service price based on the service code.*/
	public static double getPrice(String code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code.equals(serviceCodes[i])) {
				return servicePrices[i];
			}
		}
		return -1;
		
	}
	
	public static String getName(String code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code.equals(serviceCodes[i])) {
				return serviceNames[i];
			}
		}
		return "";
		
	}
	

	private static String buff;
	
	/** Creates a provider directory that holds all of the information.*/
	public static void makeDirectory() {
		
		try {
			FileWriter fw = new FileWriter("Provider_Directory.txt");
			buff = "Service Code\tService Name\tService Price";
			for(int i = 0; i < serviceCodes.length; i++) {
				buff += "\n" + serviceCodes[i] + "\t" + serviceNames[i] + "\t" + servicePrices[i];
			}
			fw.write(buff);
			fw.close();
			System.out.println("File written");
			
		}
		catch (Exception e) {
			
		}
		
	}
	
	
	
}
