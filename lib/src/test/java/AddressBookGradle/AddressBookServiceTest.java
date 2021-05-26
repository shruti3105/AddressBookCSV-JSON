package AddressBookGradle;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

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
	}



