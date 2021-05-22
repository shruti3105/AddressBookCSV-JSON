package AddressBookGradle;

import java.util.Scanner;

public class AddressBook {
	public static void main(String args[]) {
		ContactDirectory ac = new ContactDirectory();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 : Add contact");
		System.out.println("Enter 2 : edit contact ");
		int choose = sc.nextInt();
		switch(choose) {
		//first name
		case 1 :
			ac.addContact();
			System.out.println("For Edit this contact press 1 , otherwise press 0");
			int f = sc.nextInt();
			if (f == 1) {
				ac.editContact();
				break;
			}
			else if(f == 0) {
				System.out.println("Contact details are added , discarded updating ");
				break;
			}
			else {
				System.out.println("Invalid Choice");
				break;
			}
		case 2:
			ac.editContact();
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}	
	}
}
