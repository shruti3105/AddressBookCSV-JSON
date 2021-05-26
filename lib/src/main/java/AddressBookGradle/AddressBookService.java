package AddressBookGradle;

import java.util.Arrays;
import java.util.List;

public class AddressBookService {

    List<AddressBook> addressBookList;
    private static Connection Connection;
    private Arrays record;

    public AddressBookService() {
    	Connection = Connection.getInstance();
    }

    public List<AddressBook> readAddressBookData() throws AddressBookException {

        return this.addressBookList = Connection.readData();
    }
    public void updateEmployeeSalary(String firstName, String address) throws AddressBookException{
        int result = new Connection().updateDataUsingPreparedStatement(firstName,address);
        if (result == 0)
            return;
        AddressBook addressBook = this.getAddressBookData(firstName);
        if (addressBook != null)
            addressBook.setAddress(address);
    }

    private AddressBook getAddressBookData(String firstName) throws AddressBookException {
        addressBookList = this.readAddressBookData();
        return this.addressBookList.stream()
                .filter(addressBook -> addressBook.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public boolean checkEmployeePayrollInSyncWithDB(String firstName) throws AddressBookException {
        List<AddressBook> addressBooks = Connection.getRecordDataByName(firstName);

        return addressBooks.get(0).equals(getAddressBookData(firstName));
    }

}