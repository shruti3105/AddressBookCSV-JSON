package AddressBookGradle;

public class AddressBookException extends Exception{
    public enum AddressBookExceptionType {
        READ_DATA_EXCEPTION, UPDATION_DATA_EXCEPTION
    }

	public static final String ExceptionType = null;

    public AddressBookExceptionType type;

    public AddressBookException(AddressBookExceptionType type, String message) {
        this.type = type;
    }


}