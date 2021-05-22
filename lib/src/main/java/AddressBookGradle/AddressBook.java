package AddressBookGradle;

import java.util.Scanner;

public class AddressBook {
	public static void main(String args[]) {
		AddressBook ad = new AddressBook();
		Scanner sc = new Scanner(System.in);
		String m;
        System.out.println("Enter your first name:");
	    String firstName = sc.nextLine();
	    ad.setFirstName(firstName);
	    System.out.println("Enter the last name :");
	    String lastName = sc.nextLine();
	    ad.setLastName(lastName);
	    System.out.println("Enter the address :");
	    String address = sc.nextLine();
	    ad.setAddress(address);
	    System.out.println("Enter the city :");
	    String city = sc.nextLine();
	    ad.setCity(city);
	    System.out.println("Enter the state :");
	    String state = sc.nextLine();
	    ad.setState(state);
	    System.out.println("Enter the email :");
	    String email = sc.nextLine();
	    ad.setEmail(email);
	    System.out.println("Enter the mobile number :");
	    String phoneNo = sc.next();
	    ad.setPhoneNo(phoneNo);
	    System.out.println("Enter the zip :");
	    int zip = sc.nextInt();
	    ad.setZip(zip);
	    m = "First Name :- "+ad.getFirstName()+
	            	"Last name : - "+ad.getLastName()+
	            	"Address :- "+ad.getAddress()+
	            	"City :- "+ad.getCity()+
	            	"State :- "+ad.getCity()+
	            	"Email:- "+ad.getEmail()+
	            	"MobileNo. :- "+ad.getPhoneNo()+
	            	"Zip :- "+ad.getZip();
	    
	    System.out.println(m);
    }
		
	
}
