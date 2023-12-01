package chocAnSystem;

public class ProviderDirectory {
	public ProviderDirectory() {
		
	}
	
	private static int serviceCodes[] = {598470, 883948};
	private static String serviceNames[] = {"dietitianAppt", "aerobicsSession"};
	
	public static String getService(int code) {
		for(int i = 0; i < serviceCodes.length; i++) {
			if(code == serviceCodes[i]) {
				return serviceNames[i];
			}
		}
		
	return "Service code not found.";
	}
	
}
