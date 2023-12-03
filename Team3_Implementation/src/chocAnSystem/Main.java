/** @author all team members: Ethan Busby, Adam Howard, Hariaksha Gunda, Ryan McCulley, Robert Read, Tyler Cruise, and James White*/
package chocAnSystem;

import java.io.IOException;

/** This Main class is where the Main Menu class and its functions are used.*/
public class Main {

	public static void main(String[] args) throws IOException {
		MainMenu menu = new MainMenu();
        menu.display();
        menu.login();
	}
}
