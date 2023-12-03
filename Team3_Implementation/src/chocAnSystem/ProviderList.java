/** @author James White*/
package chocAnSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Generates a provider list with each providers information.*/
public class ProviderList {
	public static void main(String[] args) {
        saveProviderData();
    }
	
	/** Saves all the provider data.*/
    public static void saveProviderData() {
    	// Open scanner
        Scanner scanner = new Scanner(System.in);

        // Get member data from user
        System.out.print("Enter provider name (25 characters): ");
        String name = readInputWithMaxLength(scanner, 25);

        System.out.print("Enter provider number (9 digits): ");
        String number = readInputWithMaxLength(scanner, 9);

        System.out.print("Enter provider street address (25 characters): ");
        String streetAddress = readInputWithMaxLength(scanner, 25);

        System.out.print("Enter provider city (14 characters): ");
        String city = readInputWithMaxLength(scanner, 14);

        System.out.print("Enter provider state (2 letters): ");
        String state = readInputWithMaxLength(scanner, 2);

        System.out.print("Enter provider ZIP code (5 digits): ");
        String zipCode = readInputWithMaxLength(scanner, 5);

        // Close scanner
        scanner.close();

        // Save data to text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("providerData.txt", true))) {
            // Write data to the file
            String data = name + ", " + number + ", " + streetAddress + ", " + city + ", " + state + ", " + zipCode + "\n";
            writer.write(data);

            System.out.println("Provider data saved successfully.");
        } 
        catch (IOException e) {
            System.err.println("Error saving provider data: " + e.getMessage());
        }
    }

    /** This checks to make sure that any input given doesn't exceed the maximum length.*/
    private static String readInputWithMaxLength(Scanner scanner, int maxLength) {
        String input;
        do {
            input = scanner.nextLine();

            // Check if the input exceeds the maximum length
            if (input.length() > maxLength) {
                System.out.println("Input exceeds the maximum length. Please re-enter (max length: " + maxLength + "):");
            }
        } while (input.length() > maxLength);

        return input;
    }
}
