package AddressBookGradle;

import java.util.Scanner;

public class AddressBook {
	public static void main(String[] args) {
        Contact contact = new Contact();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Address Book Menu");
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("Enter choice: ");
            System.out.println("1. For Add a new Contact to AddressBook.");
            System.out.println("2. For Display Contact Detial.");
            System.out.println("3. For Exit.");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                System.out.println("Enter the first_name:-");
                contact.setFirst_name(sc.nextLine());
                System.out.println("Enter the last_name:-");
                contact.setLast_name(sc.nextLine());
                System.out.println("Enter the address_name:-");
                contact.setAddress(sc.nextLine());
                System.out.println("Enter the city_name:-");
                contact.setCity(sc.nextLine());
                System.out.println("Enter the state_name:-");
                contact.setState(sc.nextLine());
                System.out.println("Enter the zip_number:-");
                contact.setZip(sc.nextInt());
                System.out.println("Enter the phone_number:-");
                contact.setPhone_number(sc.nextLong());
                sc.nextLine();
                System.out.println("Enter the email:-");
                contact.setEmail(sc.nextLine());
                isAlive = true;
                break;

            case 2:
                System.out.println(contact.toString());
                System.out.println("Contact is added successfully.");
                break;

            case 3:
                isAlive = false;
                System.out.println("Exit.....");
                break;

            default:
                System.out.println("You have entered wrong choice.");
                isAlive = true;
                break;
            }
        }
        sc.close();
    }
}
