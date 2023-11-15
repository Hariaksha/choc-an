package chocAnSystem;

public class Manager {
    private String managerName;
    private int managerNumber;

    /** This is the default constructor that is used when the constructor is called without arguments by accident. */
    public Manager() {
        managerName = "Bobby Brady";
        managerNumber = 123456;
    }

    /** This is the primary constructor that will be used for the software. */
    public Manager(int num, String name) {
        managerName = name;
        managerNumber = num;
    }

    /** This class simply returns the ID number of the manager. */
    public int getManagerNumber() {
        return managerNumber;
    }

    /** This class simply returns the name of the manager. */
    public String getManagerName() {
        return managerName;
    }
}
