package chocAnSystem; 
public class Provider
{ 
    String name; 
    int number; 
    Street street; 
    String city; 
    int zip; 

}


class UpdateProvider
{ 
    public static void main(String args[])
    { 
       UpdateProvider provider = new UpdateProvider(); 
       provider.updateProviderRecords(); 
    }
    public void addProvider() 
    { 
         System.out.println("Enter New Member Info: "); 
    } 
      
    public void deleteProvider() 
    { 
        System.out.println("Enter New Member Info: ");
    }

    public void updateProviderRecords() 
    { 
        System.out.println("Enter Member ID Number: ");
    } 
} 