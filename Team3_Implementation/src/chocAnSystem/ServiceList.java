/** Code by: Tyler Cruise.*/

package chocAnSystem;

public class ServiceList {
	String[] comments;
	String[] dates;
	int size;
	int amount;
	
	/** Constructor.*/
	public ServiceList() {
		size = 50;
		comments = new String[50];
		dates = new String[50];
		amount = 0;
	}
	
	/** Called when Array is full.*/
	private void increaseSize() {
		String[] tempCom = new String[size];
		String[] tempDat = new String[size];
		
		for(int i = 0; i <= size; i++) {
			tempCom[i] = comments[i];
			tempDat[i] = dates[i];
		}
		
		
		String[] dates = new String[size + 50];
		String[] comments = new String[size + 50];
		
		for(int i = 0; i <= size; i++) {
			comments[i] = tempCom[i];
			dates[i] = tempDat[i];
		}
		
		size = size + 50;
		return;
	}
	
	/** Adds new service info to list.*/
	public void addServiceInfo(String note, String date) {
		if(size == amount) {
			increaseSize();
		}
		comments[amount] = note;
		dates[amount] = date;
		amount++;
		return;
	}
	
	/** Stand-in for service info output.*/
	public void getServiceInfo() {
		System.out.println("Got Service Info");
	}
}
