package AddressBookGradle;

public class Contact {
	private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phone_number;
    private String email;

    Contact(String first_name, String last_name, String address, String city, String state, int zip,
            long phone_number, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone_number = phone_number;
        this.email = email;
    }

    Contact() {
        this("", "", "", "", "", 0, 0, "");
    }
    
    public Contact(String firstName, String lastName, String area, String city2, String state2, String zip2,
			String phoneNumber, String email2) {
		// TODO Auto-generated constructor stub
	}

	public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter Method

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Person Details: \t \nFirst name:" + this.first_name + " \t \nLast name:" + this.last_name
                + " \t \nAddress:" + this.address + " \t \nCity:" + this.city + " \t \nState:" + this.state
                + " \t \nZip:" + this.zip + " \t \nPhone Number:" + this.phone_number + " \t \nEmail:" + this.email;
    }

	public Object getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPhoneNumber(String next) {
		// TODO Auto-generated method stub
		
	}

	public void setZip(String next) {
		// TODO Auto-generated method stub
		
	}

	public void setLastName(String next) {
		// TODO Auto-generated method stub
		
	}

	public void setFirstName(String next) {
		// TODO Auto-generated method stub
		
	}

}
