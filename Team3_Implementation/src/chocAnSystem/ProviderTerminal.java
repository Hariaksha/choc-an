package chocAnSystem;

import java.util.Scanner;
import java.util.ArrayList;


public class ProviderTerminal{

    public String providerUsername;
    public String providerPassword;

    public String action;

    public ArrayList<String> Usernames = new ArrayList<String>();
    public ArrayList<String> Passwords = new ArrayList<String>();
    
    public void createToPList() {
    	Usernames.add("Ryan");
        Usernames.add("Hari");
        Usernames.add("Ethan");
        Passwords.add("121925030");
        Passwords.add("122381670");
        Passwords.add("122048720");
    }

     public String chooseAction(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Choose Action: Bill ChocAn, Verify Member, Request Directory");
        action = obj.nextLine();
        obj.close();
        if (action != "Bill ChocAn" || action != "Verify Member" || action != "Request Directory") return chooseAction();
        return "Nothing Selected";
    }

    public boolean providerLogin(){
        Scanner obj = new Scanner(System.in);

        int count = 0;

        System.out.println("Enter username");
        providerUsername = obj.nextLine();

        System.out.println("Enter password");
        providerPassword = obj.nextLine();

        String meowUsername = providerUsername;
        String meowPassword = providerPassword;

        for(int i = 0; i < Usernames.size(); i++){
            if (meowUsername == Usernames.get(i)){
                count = i;
                break;
            }
        }
        obj.close();
        if(meowPassword == Passwords.get(count)){
            return true;
        }
        return false;
    }

    public String verifyProvider(boolean meow){
        if(meow == true){
        	return "Logging in";
        }
        return "Invalid Log In";
        
    }


}
