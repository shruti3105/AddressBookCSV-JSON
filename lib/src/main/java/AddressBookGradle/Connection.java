package AddressBookGradle;

import java.util.Enumeration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Connection {
	private static Connection Connection = null;
	List<AddressBook> addressBookList = new ArrayList<>();
    private static Connection addressBookConnection;
    private PreparedStatement recordDataStatement;

    public Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/ address_book?useSS1=false";
        String userName = "root";
        String password = "Shruti@3105";
        Connection connection;
        connection = (Connection) DriverManager.getConnection(jdbcURL, userName, password);
        return connection;
    }
    public static Connection getInstance() {
        if (Connection == null)
            Connection = new Connection();
        return Connection;
    }
    public List<AddressBook> readData() throws AddressBookException {
        addressBookList = new ArrayList<AddressBook>();
        String sql = "SELECT * FROM addressbook; ";
        return this.getDataFromDataBase(sql);
    }

    private List<AddressBook> getDataFromDataBase(String sql) throws AddressBookException {
        addressBookList = new ArrayList<AddressBook>();
        try {
            Connection connection = this.getConnection();
            Statement statement = ((java.sql.Connection) connection).createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            addressBookList = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddressBookException(AddressBookException.AddressBookExceptionType.READ_DATA_EXCEPTION,
                    "!!Unable to read data from database!!");
        }
        return addressBookList;
    }

    private List<AddressBook> getAddressBookData(ResultSet resultSet) throws AddressBookException {
        addressBookList = new ArrayList<AddressBook>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String state = resultSet.getString("State");
                String phoneNo = resultSet.getString("Mobile_No");
                String email = resultSet.getString("Email");
                addressBookList.add(new AddressBook(firstName, lastName, address, city, state, phoneNo, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddressBookException(AddressBookException.AddressBookExceptionType.READ_DATA_EXCEPTION,
                    "!!Unable to read data from database!!");
        }
        return addressBookList;
    }
    public List<AddressBook> getRecordDataByName(String firstName) throws AddressBookException {
        List<AddressBook> record = null;
        if (this.recordDataStatement == null) this.preparedStatementForRecord();
        try {
            recordDataStatement.setString(1, firstName);
            ResultSet resultSet = recordDataStatement.executeQuery();
            record = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddressBookException(AddressBookException.AddressBookExceptionType.UPDATION_DATA_EXCEPTION,
                    "!!Unable to update data from database!!");
        }
        return record;
    }

    private void preparedStatementForRecord() {
        try {
            Connection connection = this.getConnection();
            String query = "SELECT * FROM addressbook WHERE First_Name = ?";
            recordDataStatement = connection.prepareStatement(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updateDataUsingPreparedStatement(String firstName, String address) {
        String query = "UPDATE addressbook SET Address = ? WHERE First_Name = ?";
        try (Connection connection = this.getConnection()) {
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(query);
            preparedStatementUpdate.setString(1, address);
            preparedStatementUpdate.setString(2, firstName);
            return preparedStatementUpdate.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}