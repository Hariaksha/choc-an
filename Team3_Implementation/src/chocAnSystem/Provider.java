//Author: Ryan McCulley

package chocAnSystem;

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