package AddressBookGradle;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

public class AddressBookService {
	public enum IOService {
		DB_IO
	}

	private List<AddressBookDetails> addressBookList;
	private static AddressBookDBService addressBookDBService;

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public List<AddressBookDetails> readAddressBookDetails(IOService ioservice) throws AddressBookException {
		if (ioservice.equals(IOService.DB_IO))
			return this.addressBookList = addressBookDBService.readData();
		return this.addressBookList;
	}

	public void updateRecord(String firstname, String address) throws AddressBookException {
		int result = addressBookDBService.updateAddressBookDetails(firstname, address);
		if (result == 0)
			return;
		AddressBookDetails addressBookDetails = this.getAddressBookDetails(firstname);
		if (addressBookDetails != null)
			addressBookDetails.address = address;
	}

	public boolean checkUpdatedRecordSyncWithDatabase(String firstname) throws AddressBookException {
		try {
			List<AddressBookDetails> addressBookDetails = addressBookDBService.getAddressBookDetails(firstname);
			return addressBookDetails.get(0).equals(getAddressBookDetails(firstname));
		} catch (AddressBookException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DATABASE_EXCEPTION);
		}
	}

	private AddressBookDetails getAddressBooketails(String firstname) {
		return this.addressBookList.stream().filter(addressBookItem -> addressBookItem.firstName.equals(firstname))
				.findFirst().orElse(null);
	}

	public List<AddressBookDetails> readAddressBookDetails(IOService ioService, String start, String end)
			throws AddressBookException {
		try {
			LocalDate startLocalDate = LocalDate.parse(start);
			LocalDate endLocalDate = LocalDate.parse(end);
			if (ioService.equals(IOService.DB_IO))
				return addressBookDBService.readData(startLocalDate, endLocalDate);
			return this.addressBookList;
		} catch (AddressBookException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DATABASE_EXCEPTION);
		}
	}

	public int readAddressBookDetails(String function, String city) throws AddressBookException {
		return addressBookDBService.readDataBasedOnCity(function, city);
	}
	public AddressBookDetails addNewContact(String firstName, String lastName, String start, String address, String city, String state,
			String zip, String phoneNo, String email) throws AddressBookException {
		int id = -1;
		AddressBookDetails addressBookData = null;
		String query = String.format(
				"insert into addressBook(FirstName, LastName, Date, Address, City, State, Zip, PhoneNo, Email) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s')",
				firstName, lastName, start, address, city, state, zip, phoneNo, email);
		try (Connection connection = this.getConnection()) {
			Statement statement = connection.createStatement();
			int rowChanged = statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
			if (rowChanged == 1) {
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next())
					id = resultSet.getInt(1);
			}
			addressBookDetails = new AddressBookDetails(firstName, lastName, start, address, city, state, zip);
		} catch (SQLException e) {
			throw new AddressBookException(e.getMessage(), AddressBookException.ExceptionType.DATABASE_EXCEPTION);
		}
		return addressBookDetails;
	}


}