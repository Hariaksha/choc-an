package chocAnSystem; 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 
import java.io.FileWriter;
import java.io.BufferedWriter;

class Member
{  
    String name; 
    int number; 
    String street; 
    String city; 
    String state; 
    String zip; 
    
}
//////////////////////////////////////////////////////////////////////////
class UpdateMember
{ 
    public void addMember() 
    { 
        Member newMember = new Member(); 

        Scanner myObj = new Scanner(System.in); 

        System.out.print("Enter Name: "); 

        newMember.name = myObj.nextLine(); 
        
        System.out.print("Enter Street: "); 

        newMember.street = myObj.nextLine(); 

        System.out.print("Enter City: "); 

        newMember.city = myObj.nextLine(); 

        System.out.print("Enter State: "); 

        newMember.state = myObj.nextLine();

        System.out.print("Enter Zip: "); 

        newMember.zip = myObj.nextLine(); 

        Random random = new Random(); 
        int n = 100000000 + random.nextInt(900000000);
        newMember.number = n; 

        updateMemberList(newMember);
    } 
/////////////////////////////////////////////////////////////////////////////////  
    public void deleteMember() 
    { 
        /* 
        System.out.println("Enter Member ID Number: ");
        Scanner input = new Scanner(System.in);  
        String id = input; 

        try {
            Scanner scan = new Scanner(new File("MemberList.txt"));
            PrintWriter writer = new PrintWriter(new FileWriter("tempList.txt"));
            scan.nextLine();

            while(scan.hasNextLine())
            { 

            }
        } catch (IOException e) {
           e.printStackTrace();
        }
        */
    }
//////////////////////////////////////////////////////////////////////////////////////
    public void updateMemberRecords() 
    { 
        System.out.println("Enter Member ID Number: ");
    } 
//////////////////////////////////////////////////////////////////////////////////////
    public void updateMemberList(Member member) 
    {
        try{
            FileWriter reader = new FileWriter("MemberList.txt", true);
            BufferedWriter writer = new BufferedWriter(reader);
            writer.write(member.name + " / " + member.number + " / " + member.street + " / " + member.city + " / " + member.state + " / " + member.zip);
            writer.newLine();
            writer.close();
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace(); 
        }
    }
////////////////////////////////////////////////////////////////////////////////////////

    public void start()
    { 
        System.out.println("To add member type add"); 
        System.out.println("To delete member type delete"); 
        System.out.println("To update member records type update"); 
        Boolean vaild = false;
        Scanner scan  = new Scanner(System.in); 
        while(!vaild)
        {
            String input =  scan.nextLine(); 
            if(input.equals("add"))
            { 
                vaild = true;
                addMember(); 
            }
            else if(input.equals("delete"))
            { 
                vaild = true; 
                deleteMember();
            }
            else if(input.equals("update"))
            { 
                vaild = true; 
                Member newMember = new Member(); 
                updateMemberList(newMember);
            }
            else 
            { 
                System.out.println("Enter valid function");
            }
        } 
    }
} 

