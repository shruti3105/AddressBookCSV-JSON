package AddressBookGradle;

public class AddressBook {
	public static void main(String[] args) {
        Contact contactPerson = new Contact("Shruti", "Verma", "Awas Vikas", "Kanpur", "Uttar Pradesh",
                208017, 12345, "shrutiverma3105@gmail.com");
        System.out.println(contactPerson.toString());
    }
}