package AddressBookGradle;

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

}