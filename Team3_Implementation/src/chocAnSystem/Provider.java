/** @author Ryan Mcculley*/

package chocAnSystem;

/** /** The Provider class illustrates how the provider interacts with the provider terminal.*/
public class Provider {
    
    /**basic Provider constructor*/
    public Provider() {
    
    }
    /**This lets the Provider access the provider terminal and call its actions*/
    public void Paction() {
    	System.out.println("You are a Provider. You will be directed to the Manager Terminal.");
    	ProviderTerminal pt = new ProviderTerminal();
    	pt.providerLogin();
    	pt.chooseAction();
    }

}