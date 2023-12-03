package chocAnSystem;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random; 
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class Provider
{  
    String name; 
    int number; 
    String street; 
    String city; 
    String state; 
    String zip; 

    public Provider(String name, int number, String street, String city, String state, String zip) 
    {
        this.name = name;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    } 
    public Provider(){}
}

//////////////////////////////////////////////////////////////////////////
public class UpdateProvider
{ 
    ArrayList <Provider> providerList = new ArrayList<>();
    Scanner scan = new Scanner(System.in); 

    public void readProviderList()
    { 
        try{
            File  file = new File("providerData.txt"); 
            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            String line;
            while ((line = reader.readLine()) != null)
            { 
                String [] parts = line.split(", " ); 
                if(parts.length == 6) 
                { 
                    String name = parts[0]; 
                    int number = Integer.parseInt(parts[1]); 
                    String street = parts[2]; 
                    String city = parts[3]; 
                    String state = parts[4]; 
                    String zip = parts[5]; 

                    Provider provider = new Provider(name, number, street, city, state, zip); 
                    providerList.add(provider); 
                }
            } 
        }
        catch (IOException e) 
        { 
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addProvider() 
    { 
        Provider newProvider = new Provider(); 

        System.out.print("Enter Name: "); 

        newProvider.name = scan.nextLine(); 
        
        System.out.print("Enter Street: "); 

        newProvider.street = scan.nextLine(); 

        System.out.print("Enter City: "); 

        newProvider.city = scan.nextLine(); 

        System.out.print("Enter State: "); 

        newProvider.state = scan.nextLine();

        System.out.print("Enter Zip: "); 

        newProvider.zip = scan.nextLine(); 

        Random random = new Random(); 
        int n = 100000000 + random.nextInt(900000000);
        newProvider.number = n; 

        providerList.add(newProvider);

        System.out.println("You you like to continue to add another Provider? YES or NO"); 
        boolean cont  = false; 
        String input; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                addProvider();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return;  
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update Provider list? YES or NO"); 
            }
        } 
    } 

    /////////////////////////////////////////////////////////////////////////////////  
    public void deleteProvider() 
    { 
        System.out.println("Enter Provider ID Number: ");
        int idNum = Integer.parseInt(scan.nextLine()); 
        boolean found = false; 

        for(int i = 0; i < providerList.size(); i++)
        { 
            if(providerList.get(i).number == idNum)
            { 
                found = true; 
                providerList.remove(i);
                System.out.println("Provider with ID " + idNum + " deleted successfully.");
            }
        }

        if(!found)
        { 
            System.out.println("Provider not found");
            deleteProvider();
            return; 
        }

        System.out.println("You you like to delete other Providers? YES or NO"); 
        boolean cont  = false; 
        String input; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                deleteProvider();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return; 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update Provider list? YES or NO"); 
            }
        } 
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public void updateProviderRecords() 
    { 
        System.out.println("Enter Provider ID Number: "); 
        int idNum = Integer.parseInt(scan.nextLine()); 
        boolean vaild = false; 
        int providerLocation = 0; 
        boolean found = false; 

        for(int i = 0; i < providerList.size(); i++)
        { 
            if(providerList.get(i).number == idNum)
            { 
                found = true; 
                providerLocation = i; 
                break; 
            }
        } 

        if(!found)
        { 
            System.out.println("Provider not found");
            updateProviderRecords();
            return; 
        }

        System.out.println("To update Provider name type NAME"); 
        System.out.println("To update Provider address type ADDRESS"); 
        while(!vaild)
        { 
            String input = scan.nextLine(); 

            if(input.equalsIgnoreCase("NAME"))
            { 
                vaild = true;
                System.out.print("Enter Name: "); 
                providerList.get(providerLocation).name = scan.nextLine();
            }
            else if(input.equalsIgnoreCase("ADDRESS"))
            { 
                vaild = true; 
                System.out.print("Enter Street: ");
                providerList.get(providerLocation).street = scan.nextLine();
                
                System.out.print("Enter City: "); 
                providerList.get(providerLocation).city = scan.nextLine();
            
                System.out.print("Enter State: "); 
                providerList.get(providerLocation).state = scan.nextLine();
            
                System.out.print("Enter Zip: "); 
                providerList.get(providerLocation).zip = scan.nextLine();
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("To update Provider name type NAME"); 
                System.out.println("To update Provider address type ADDRESS"); 
            }
        }

        System.out.println("You you like to continue to update other Provider records? YES or NO"); 
        boolean cont  = false; 
        String input;
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                updateProviderRecords();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return; 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update Provider list? YES or NO"); 
            }
        } 
    } 

    //////////////////////////////////////////////////////////////////////////////////////
    public void updateProviderList() 
    {
        try{
            FileWriter reader = new FileWriter("providerData.txt");
            BufferedWriter writer = new BufferedWriter(reader);
            for(int i = 0; i < providerList.size(); i++)
            {
                writer.write(providerList.get(i).name + ", " + providerList.get(i).number + ", " + providerList.get(i).street + ", " + providerList.get(i).city + ", " + providerList.get(i).state + ", " + providerList.get(i).zip + "\n");
            }

            writer.newLine();
            writer.close();
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace(); 
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public void startProviderUpdate()
    { 
        readProviderList();
        System.out.println("To add Provider type ADD"); 
        System.out.println("To delete Provider type DELETE"); 
        System.out.println("To update Provider records type UPDATE"); 
        Boolean vaild = false;
        String input; 

        while(!vaild)
        {
            input =  scan.nextLine(); 
            if(input.equalsIgnoreCase("ADD"))
            { 
                vaild = true;
                addProvider(); 
            }
            else if(input.equalsIgnoreCase("DELETE"))
            { 
                vaild = true; 
                deleteProvider();
            }
            else if(input.equalsIgnoreCase("UPDATE"))
            { 
                vaild = true; 
                updateProviderRecords(); 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("To add Provider type ADD"); 
                System.out.println("To delete Provider type DELETE"); 
                System.out.println("To update Provider records type UPDATE"); 
            }
        } 
        
        System.out.println("You you like to continue to update Provider list? YES or NO"); 
        boolean cont  = false; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
            	updateProviderList(); 
            	providerList.clear(); 
                startProviderUpdate();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
            	updateProviderList();
                return;  
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update Provider list? YES or NO"); 
            }
        } 
    }
}

