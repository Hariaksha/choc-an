import java.util.Scanner;

public class ManagerTerminal {
  private String managerUserame;
  private String managerPassword;

  /** This is a Default Constructor that will be used in case arguments are accidentally not passed. */
  public ManagerTerminal() {
    managerUserame = "Bobby Brady";
    managerPassword = "Password";
  }

  /** This is the Primary Constructor that is recommended for use. */
  public Manager(String pass, String name) {
    managerUserame = name;
    managerPassword = pass;
    }

  /** This class will let the manager choose an action. */
  public void chooseAction() {
    return;
  }

  public void managerLogin() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username and click Enter: ");
    String username = sc.nextLine();
    System.out.println("Enter password and click Enter: ");
    String password = sc.nextLine();
    if (username.equals(managerUserame) && password.equals(managerPassword)) {
      System.out.println("Welcome, " + managerUserame + "!");
    }
        else {
          System.out.println("Invalid username or password.");
    }
    sc.close();
  }
}
