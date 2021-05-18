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
                if (contact.getFirst_name() == " " && contact.getLast_name() == " "
                        && contact.getAddress() == " " && contact.getCity() == " "
                        && contact.getState() == " " && contact.getZip() == 0
                        && contact.getPhone_number() == 0 && contact.getEmail() == " ") {
                    System.out.println("Address book is Empty. Firstly add the contact.");
                    break;
                } else {
                    System.out.println(contact.toString());
                }
                break;

            case 3:
                if (contact.getFirst_name() == " " && contact.getLast_name() == " "
                        && contact.getAddress() == " " && contact.getCity() == " "
                        && contact.getState() == " " && contact.getZip() == 0
                        && contact.getPhone_number() == 0 && contact.getEmail() == " ") {
                    System.out.println("Address book is Empty. Firstly add the contact.");
                    break;
                } else {
                    System.out.println("Enter the name you want to update:- ");
                    String name = sc.nextLine();
                    if (name.equalsIgnoreCase(contact.getFirst_name())) {
                        boolean isUpdate = true;
                        while (isUpdate) {
                            System.out.println(contact.toString());
                            System.out.print("Enter the index number you want to update form 0 to 7:  ");
                            int index = sc.nextInt();
                            sc.nextLine();
                            switch (index) {
                            case 0:
                                System.out.println("Update the first_name:-");
                                contact.setFirst_name(sc.nextLine());
                                break;
                            case 1:
                                System.out.println("Update the last_name:-");
                                contact.setLast_name(sc.nextLine());
                                break;
                            case 2:
                                System.out.println("Update the address:-");
                                contact.setAddress(sc.nextLine());
                                break;
                            case 3:
                                System.out.println("Update the city:-");
                                contact.setCity(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Update the state:-");
                                contact.setState(sc.nextLine());
                                break;
                            case 5:
                                System.out.println("Update the zip:-");
                                contact.setZip(sc.nextInt());
                                break;
                            case 6:
                                System.out.println("Update the phone_number:-");
                                contact.setPhone_number(sc.nextLong());
                                sc.nextLine();
                                break;
                            case 7:
                                System.out.println("Update the email_id:-");
                                contact.setEmail(sc.nextLine());
                                break;

                            default:
                                System.out.println("You entered the wrong choice.");
                                break;
                            }
                            System.out.println("Want to update more..?? Yes or No");
                            String ans = sc.next();
                            String yes = "Yes";
                            String no = "No";
                            if (ans.equalsIgnoreCase(yes)) {
                                isUpdate = true;
                            } else if (ans.equalsIgnoreCase(no)) {
                                isUpdate = false;
                            } else {
                                System.out.print("You Entered wrong input: ");
                                isUpdate = true;
                            }
                        }
                    } else {
                        System.out.println("Name not found in contact list.");
                    }
                }
                break;

            case 4:
            	if (contact.getFirst_name() == " " && contact.getLast_name() == " "
                && contact.getAddress() == " " && contact.getCity() == " "
                && contact.getState() == " " && contact.getZip() == 0
                && contact.getPhone_number() == 0 && contact.getEmail() == " ") {
            System.out.println("Address book is Already Empty.");
            break;
        } else {
            System.out.println("Enter the name you want to update:- ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase(contact.getFirst_name())) {
            	contact.setFirst_name(" ");
            	contact.setLast_name(" ");
            	contact.setAddress(" ");
            	contact.setCity(" ");
            	contact.setState(" ");
            	contact.setZip(0);
            	contact.setPhone_number(0);
            	contact.setEmail(" ");

                System.out.println("Contact is deleted.");
            } else {
                System.out.println("There is no contact with " + name + ".");
            }
        }
        break;

    case 5:
        isAlive = false;
        System.out.println("Exit.....");
        break;

    default:
        System.out.println("You have entered wrong choice.");
        break;
    }
}
sc.close();
}
}