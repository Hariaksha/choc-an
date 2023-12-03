package chocAnSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Random; 
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class Member
{  
    String name; 
    int number; 
    String street; 
    String city; 
    String state; 
    String zip; 

    public Member(String name, int number, String street, String city, String state, String zip) 
    {
        this.name = name;
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    } 
    public Member(){}
}

class UpdateMember
{ 
    ArrayList <Member> memberList = new ArrayList<>();
    Scanner scan = new Scanner(System.in); 

    public void readMemberList()
    { 
        try{
            File  file = new File("memberData.txt"); 
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

                    Member member = new Member(name, number, street, city, state, zip); 
                    memberList.add(member); 
                }
            } 
        }
        catch (IOException e) 
        { 
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addMember() 
    { 
        Member newMember = new Member(); 

        System.out.print("Enter Name: "); 

        newMember.name = scan.nextLine(); 
        
        System.out.print("Enter Street: "); 

        newMember.street = scan.nextLine(); 

        System.out.print("Enter City: "); 

        newMember.city = scan.nextLine(); 

        System.out.print("Enter State: "); 

        newMember.state = scan.nextLine();

        System.out.print("Enter Zip: "); 

        newMember.zip = scan.nextLine(); 

        Random random = new Random(); 
        int n = 100000000 + random.nextInt(900000000);
        newMember.number = n; 
        
        memberList.add(newMember);  
        System.out.println(newMember.name + "was successfully added." ); 

        System.out.println("Would you like to continue to add another member? YES or NO"); 
        boolean cont  = false; 
        String input; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                addMember();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return;  
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("Would you like to continue to update member list? YES or NO"); 
            }
        } 
    } 

    /////////////////////////////////////////////////////////////////////////////////  
    public void deleteMember() 
    { 
        System.out.println("Enter Member ID Number: ");
        int idNum = Integer.parseInt(scan.nextLine()); 
        boolean found = false; 

        for(int i = 0; i < memberList.size(); i++)
        { 
            if(memberList.get(i).number == idNum)
            { 
                found = true; 
                memberList.remove(i);
                System.out.println("Member with ID " + idNum + " deleted successfully.");
            }
        }

        if(!found)
        { 
            System.out.println("Member not found");
            deleteMember(); 
            return; 
        }


        System.out.println("You you like to delete other members? YES or NO"); 
        boolean cont  = false; 
        String input; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                deleteMember();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return; 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update member list? YES or NO"); 
            }
        } 
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public void updateMemberRecords() 
    { 
        System.out.println("Enter Member ID Number: "); 
        int idNum = Integer.parseInt(scan.nextLine()); 
        boolean vaild = false; 
        int memberLocation = 0; 
        boolean found = false; 

        for(int i = 0; i < memberList.size(); i++)
        { 
            if(memberList.get(i).number == idNum)
            { 
                found = true; 
                memberLocation = i; 
                break; 
            }
        } 

        if(!found)
        { 
            System.out.println("Member not found");
            updateMemberRecords();
            return; 
        }

        System.out.println("To update member name type NAME"); 
        System.out.println("To update member address type ADDRESS"); 
        while(!vaild)
        { 
            String input = scan.nextLine(); 

            if(input.equalsIgnoreCase("NAME"))
            { 
                vaild = true;
                System.out.print("Enter Name: "); 
                memberList.get(memberLocation).name = scan.nextLine();
            }
            else if(input.equalsIgnoreCase("ADDRESS"))
            { 
                vaild = true; 
                System.out.print("Enter Street: ");
                memberList.get(memberLocation).street = scan.nextLine();
                
                System.out.print("Enter City: "); 
                memberList.get(memberLocation).city = scan.nextLine();
            
                System.out.print("Enter State: "); 
                memberList.get(memberLocation).state = scan.nextLine();
            
                System.out.print("Enter Zip: "); 
                memberList.get(memberLocation).zip = scan.nextLine();
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("To update member name type NAME"); 
                System.out.println("To update member address type ADDRESS"); 
            }
        }
        
        System.out.println(idNum + "was successfully updated");
        
        System.out.println("You you like to continue to update other member records? YES or NO"); 
        boolean cont  = false; 
        String input;
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                updateMemberRecords();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
                return; 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update member list? YES or NO"); 
            }
        } 
    } 

    //////////////////////////////////////////////////////////////////////////////////////
    public void updateMemberList() 
    {
        try{
            FileWriter reader = new FileWriter("memberData.txt");
            BufferedWriter writer = new BufferedWriter(reader);
            for(int i = 0; i < memberList.size(); i++)
            {
                writer.write(memberList.get(i).name + ", " + memberList.get(i).number + ", " + memberList.get(i).street + ", " + memberList.get(i).city + ", " + memberList.get(i).state + ", " + memberList.get(i).zip + "\n");
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
    public void startMemberUpdate()
    { 
        readMemberList();
        System.out.println("To add member type ADD"); 
        System.out.println("To delete member type DELETE"); 
        System.out.println("To update member records type UPDATE"); 
        Boolean vaild = false;
        String input; 

        while(!vaild)
        {
            input =  scan.nextLine(); 
            if(input.equalsIgnoreCase("ADD"))
            { 
                vaild = true;
                addMember(); 
            }
            else if(input.equalsIgnoreCase("DELETE"))
            { 
                vaild = true; 
                deleteMember();
            }
            else if(input.equalsIgnoreCase("UPDATE"))
            { 
                vaild = true; 
                updateMemberRecords(); 
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("To add member type ADD"); 
                System.out.println("To delete member type DELETE"); 
                System.out.println("To update member records type UPDATE"); 
            }
        } 

        System.out.println("You you like to continue to update member list? YES or NO"); 
        boolean cont  = false; 
        while(!cont)
        { 
            input = scan.nextLine(); 
            if(input.equalsIgnoreCase("YES"))
            { 
                updateMemberList(); 
                memberList.clear(); 
            	startMemberUpdate();
            } 
            else if(input.equalsIgnoreCase("NO"))
            { 
            	updateMemberList(); 
                return;  
            }
            else 
            { 
                System.out.println("Enter valid function");
                System.out.println("You you like to continue to update member list? YES or NO"); 
            }
        } 
        
    }
}