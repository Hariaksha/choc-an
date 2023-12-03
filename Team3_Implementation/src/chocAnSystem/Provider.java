/** @author Ryan Mcculley*/

package chocAnSystem;

/** /** The Provider class illustrates how the provider interacts with the provider terminal.*/
public class Provider {
    
	public String name;
	public int number;
	public String street;
	public String city;
	public String state;
	public String zip;
	
	
    /**basic Provider constructor*/
    public Provider() {
    
    }
    
    /** Provider constructor that lets you create a new provider with parameters*/
    public Provider(String name, int number, String street, String city, String state, String zip) 
    {
        this.name = name;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    } 
    
    /**This lets the Provider access the provider terminal and call its actions*/
    public void Paction() {
    	System.out.println("You are a Provider. You will be directed to the Manager Terminal.");
    	ProviderTerminal pt = new ProviderTerminal();
    	pt.providerLogin();
    	pt.chooseAction();
    }

}