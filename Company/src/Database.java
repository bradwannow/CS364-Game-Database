import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

		
	
	
	
	private String url = "jdbc:sqlite:D:\\Program Files (x86)\\SQLiteStudio\\Company";
	private Connection connection;
	
	
	private static final Database INSTANCE = new Database();
	
	private Database() { }
	
	public static Database getInstance(){
		return INSTANCE;
	}
	
	public void connect() throws SQLException {
		connection = DriverManager.getConnection(url);
	}
	
	public void disconnect() throws SQLException{
		connection.close();
	}
	
	public ResultSet runQuery(String query) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		return results;
	}
	
	public Employee employeeLookup(String ssnSearch) throws SQLException {
		String query = "SELECT SSN, Salary, FirstName, MiddleName, LastName FROM Employee WHERE SSN = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, ssnSearch);
		ResultSet results = stmt.executeQuery();
		
		Employee e = null;
		while(results.next()) {
			String ssn = results.getString("SSN");
			double salary = results.getDouble("Salary");
			String firstName = results.getString("FirstName");
			String middleName = results.getString("MiddleName");
			String lastName = results.getString("LastName");
			e = new Employee(ssn, salary, firstName, middleName, lastName);
		}
		
		return e;
	}
	
	public void insertEmployee(Employee e) throws SQLException {
		String sql = "INSERT INTO Employee(SSN, Salary, FirstName, MiddleName, LastName) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, e.getSsn());
		stmt.setDouble(2, e.getSalary());
		stmt.setString(3, e.getFirstName());
		stmt.setString(4, e.getMiddleName());
		stmt.setString(5, e.getLastName());
		stmt.executeUpdate();
	}
	
	
	
}

