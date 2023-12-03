/** @author Robert Read*/
package chocAnSystem;

import java.io.FileWriter;

public class ProviderDirectory {
	public ProviderDirectory() {
		
	}
	
	private static String serviceCodes[] = {"598470", "883948"};
	private static String serviceNames[] = {"dietitianAppt", "aerobicsSession"};
	private static double servicePrices[] = {125.73, 143.89};
	
	public static String getService(String code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code.equals(serviceCodes[i])) {
				return serviceNames[i];
			}
		}
		
	return "Service code not found.";
	}
	
	
	public static double getPrice(String code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code.equals(serviceCodes[i])) {
				return servicePrices[i];
			}
		}
		return -1;
		
	}
	

	private static String buff;
	
	
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
