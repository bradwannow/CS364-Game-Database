import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Company {
	
	public static void main(String[] args) {
		
		Database db = Database.getInstance();
		
		
		try {
			db.connect();
			System.out.println("Database connected good yes.");
		} catch (SQLException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
		
		
	
		
			ArrayList<Employee> employees = new ArrayList<>();
			
			
	
		
		
		
		try {
			db.disconnect();
			System.out.println("Database disconnected good yes.");
		} catch (SQLException e) {
			System.out.println("Database disconnected bad no!");
			e.printStackTrace();
		}
		
		
		
	}

}
