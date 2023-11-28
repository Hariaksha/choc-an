package chocAnSystem;

public class ProviderController {
	public ProviderController() {
	}
	boolean memberExists = true;
	
	void billChocAn() {
		System.out.println("billed chocAn");
	}
	
	boolean verifyMember() {
		
		if (memberExists) return true;
		else return false;
	}
	
	void requestDirectory() {
		System.out.println("gimme directory");
	}
}
