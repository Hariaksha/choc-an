package chocAnSystem;

public class Main {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		MainMenu menu = new MainMenu();
        menu.display();
        menu.login();
        
        ReportController rc = new ReportController();
        
        rc.memberReport();
	}
}