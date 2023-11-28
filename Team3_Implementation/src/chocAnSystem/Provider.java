package chocAnSystem;

import java.util.Scanner;

public class Provider {

	public int providerNumber;
    public String providerName;
    public String providerAddress;
    public String providerCity;
    public String providerState;
    int providerZip;

    //Gets the Provider number
    public int getProviderNumber(Provider pClass){
        int meow = pClass.providerNumber;
        return meow;
    }
    //Gets the Provider Name
    public String getProviderName(Provider pClass){
    	String meow = pClass.providerName;
        return meow;
    }
    //Gets the Provider Address
    public String getProviderAddress(Provider pClass){
    	String meow = pClass.providerAddress;
        return meow;
    }
    //Gets the Provider City
    public String getProviderCity(Provider pClass){
    	String meow = pClass.providerCity;
        return meow;
    }
    //Gets the Provider State
    public String getProviderState(Provider pClass){
    	String meow = pClass.providerState;
        return meow;
    }
    //Gets the Provider Zip 
    public int getProviderZip(Provider pClass){
    	int meow = pClass.providerZip;
        return meow;
    }
    
    //creates a new provider with all the inputs
    public Provider createProvider(int pNum, String pName, String pAdd, String pCity, String pState, int pZip) {
    	Provider meow = new Provider();
    	meow.providerNumber = pNum;
    	meow.providerName = pName;
    	meow.providerAddress = pAdd;
    	meow.providerCity = pCity;
    	meow.providerState = pState;
    	meow.providerZip = pZip;
    	return meow;
    }
    
    //basic Provider constructor
    public Provider createProvider() {
    	Provider meow = new Provider();
    	return meow;
    }
     
    

}
