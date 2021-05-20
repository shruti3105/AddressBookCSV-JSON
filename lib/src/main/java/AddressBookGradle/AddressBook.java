package AddressBookGradle;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook {
	public static void main(String[] args) {
	        System.out.println("Welcome to Address book Program !");
	        Contact person = new Contact();
	        List<Contact> contact = new ArrayList<>();
	        try {
	            Scanner sc = new Scanner(System.in);
	            boolean isAlive = true;
	            do {
	                System.out.println("Address Book Menu");
	                System.out.println("1. Add New Person address");
	                System.out.println("2. Update Person address");
	                System.out.println("3. Delete Person address");
	                System.out.println("4. Display all Address Book entries");
	                System.out.println("5. Exit for Address Book");
	                int choice = Integer.parseInt(sc.nextLine());
	                int index = 0;
	                boolean ans = contact.isEmpty();

	                switch (choice) {
	                case 1:
	                    System.out.println("First name");
	                    person.setFirst_name(sc.nextLine());
	                    System.out.println("Last Name");
	                    person.setLast_name(sc.nextLine());
	                    System.out.println("Address");
	                    person.setAddress(sc.nextLine());
	                    System.out.println("City");
	                    person.setCity(sc.nextLine());
	                    System.out.println("State");
	                    person.setState(sc.nextLine());
	                    System.out.println("Zip");
	                    person.setZip(Integer.parseInt(sc.nextLine()));
	                    System.out.println("PhoneNo");
	                    person.setPhone_number((sc.nextLong()));
	                    System.out.println("Email");
	                    person.setEmail(sc.nextLine());

	                    contact.add(new Contact(person.getFirst_name(), person.getLast_name(), person.getAddress(),
	                            person.getCity(), person.getState(), person.getZip(), person.getPhone_number(),
	                            person.getEmail()));
	                    System.out.println(contact);
	                    System.out.println("New address added to the book successfully !");
	                    break;
	                case 2:
	                    if (ans == true) {
	                        System.out.println("Address Book is Empty. Please enter atleast one entry to update.");
	                    } else {
	                        System.out.println("Please enter persone id to its update ?");
	                        int etr = Integer.parseInt(sc.nextLine());
	                        System.out.println("Update First name");
	                        person.setFirst_name(sc.nextLine());
	                        System.out.println("Update Last Name6");
	                        person.setLast_name(sc.nextLine());
	                        System.out.println("Update Address");
	                        person.setAddress(sc.nextLine());
	                        System.out.println("Update City");
	                        person.setCity(sc.nextLine());
	                        System.out.println("Update State");
	                        person.setState(sc.nextLine());
	                        System.out.println("Update Zip");
	                        person.setZip(Integer.parseInt(sc.nextLine()));
	                        System.out.println("Update PhoneNo");
	                        person.setPhone_number(sc.nextLong());
	                        System.out.println("Update Email");
	                        person.setEmail(sc.nextLine());
	                        contact.set(etr, person);
	                        System.out.println("Updated AddressBook : " + contact.get(etr));
	                        System.out.println("Address Book Updated Successfully !");
	                    }
	                    break;
	                case 3:
	                    if (ans == true) {
	                        System.out.println("Address Book is Empty. Please enter atleast one entry to delete");
	                    } else {
	                        System.out.println("Please enter persone id to delete its contact ?");
	                        int entry = Integer.parseInt(sc.nextLine());
	                        contact.remove(entry);
	                        System.out.println("Contact removed Successfully !");
	                    }
	                    break;
	                case 4:
	                    Iterator itr = contact.iterator();

	                    if (ans == true) {
	                        System.out.println("Address Book is Empty. Please enter atleast one entry to display.");
	                    } else {
	                        while (itr.hasNext()) {
	                            System.out.println("Person Id " + index + " " + itr.next());
	                            index++;
	                        }
	                    }
	                    break;

	                case 5:
	                    isAlive = false;
	                    System.out.println("You have chosen Exit option .");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Please enter valid choice ");
	                    break;
	                }
	            } while (isAlive != false);
	        } catch (Exception e) {
	            System.out.println(
	                    "Please enter valid inputs. Re-execute the program and ensure that your enter Zip and Phone Number as integer and all other input must be string");
	        }
	    }
}