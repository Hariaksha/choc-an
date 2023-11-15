public class Manager {
    private String managerName;
    private int managerNumber;

    // Default Constructor
    public Manager() {
        managerName = "Bobby Brady";
        managerNumber = 123456;
    }

    // Primary Constructor
    public Manager(int num, String name) {
        managerName = name;
        managerNumber = num;
    }

    public int getManagerNumber() {
        return managerNumber;
    }

    public String getManagerName() {
        return managerName;
    }
}
