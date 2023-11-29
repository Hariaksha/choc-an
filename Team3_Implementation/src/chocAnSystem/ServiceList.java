/** Code by: Tyler Cruise.*/

package chocAnSystem;

import java.util.ArrayList;

public class ServiceList {
	public ArrayList<String> comments;
	public ArrayList<String> dates;
	public int amount;
	
	/** Constructor.*/
	public ServiceList() {
		comments = new ArrayList<String>();
		dates = new ArrayList<String>();
		amount = 0;
	}

	/** Adds new service info to list.*/
	public void addServiceInfo(String note, String date) {

		comments.add(note);
		dates.add(date);
		amount++;						//Tracks amount of values
		return;
	}
	
	/** Stand-in for service info output.*/
	public void getServiceInfo() {
		System.out.println("Got Service Info");
	}
}
