package AddressBookGradle;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import AddressBookGradle.AddressBookService.IOService;

public class AddressBookServiceTest {
	 AddressBookService addressBookService = new AddressBookService();
	    List<AddressBook> addressBookList;

	    @Test
	    public void givenAddressBook_WhenRetrived_ShouldReturnAddressBookSize() throws AddressBookException {
	        addressBookList = addressBookService.readAddressBookDetails();
	        System.out.println(addressBookList);
	        Assert.assertEquals(6, addressBookList.size());
	    }
	    @Test
	    public void givenNewAddress_WhenUpdated_ShouldSyncWithDatabase() throws AddressBookException {
	        AddressBookService addressBookService = new AddressBookService();
	        List<AddressBook>addressBooks = addressBookService.readAddressBookDetails();
	        addressBookService.updateEmployeeSalary("Sandip","Kanpur");
	        System.out.println(addressBooks);
	        boolean result = addressBookService.checkEmployeePayrollInSyncWithDB("Sandip");
	        Assert.assertTrue(result);
	    }
	    @Test
	    public void givenDateRangeForRecord_WhenRetrieved_ShouldReturnProperData() throws AddressBookException {
	        AddressBookService addressBookService = new AddressBookService();
	        List<AddressBook> recordDataInGivenDateRange = addressBookService.getRecordAddedInDateRange("2020-01-01","2015-05-20");
	        Assert.assertEquals(3,recordDataInGivenDateRange.size());
	    }
	    @Test
		public void givenAddresBook_WhenRetrieved_ShouldReturnCountOfCity() throws AddressBookException {
			Assert.assertEquals(1, addressBookService.readAddressBookDetails("ND", "DEL"));
		}
	    @Test
		public void givenAddresBookDetails_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
			addressBookService.readAddressBookDetails(IOService.DB_IO);
			addressBookService.addNewContact("Shr", "Ver", "2021-05-31", "Jha", "JAM", "BH", "987654", "9988422334", "sshr@ver.com");
			boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("B");
			Assert.assertTrue(result);
	    
	}
	    @Test
		public void givenMultipleContact_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
			AddressBookDetails[] contactArray = {
					new AddressBookDetails("abc", "pqr", "ok", "lko", "UP", "137535", "4598663793"),
					new AddressBookDetails("zzz", "abc", "OK", "knp", "up", "227536", "9974563255") };
			addressBookService.addMultipleContactsToDBUsingThreads(Arrays.asList(contactArray));
			boolean result1 = addressBookService.checkUpdatedRecordSyncWithDatabase("Tharun");
			boolean result2 = addressBookService.checkUpdatedRecordSyncWithDatabase("Nani");
			Assert.assertTrue(result1);
			Assert.assertTrue(result2);

		}}



