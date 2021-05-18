package AddressBookGradle;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;
    
    @Override
    public String toString() {
    	return "CSVUser{"+"name='"+name+'\''+", email=''"+email+'\''+", phoneNo=''"+phoneNo+'\''+", country='"+country+'\''+'}';
    			}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhoneNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}
}