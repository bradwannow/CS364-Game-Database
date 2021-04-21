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
		
		ArrayList<Game> games = new ArrayList<>();
	
		try {
			 games = db.gameYearLookup((float)1999);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//System.out.println(g);
		
		for(int i = 0; i < games.size(); i++) {
			System.out.println(games.get(i));
		}

		
		try {
			db.disconnect();
			System.out.println("Database disconnected good yes.");
		} catch (SQLException e) {
			System.out.println("Database disconnected bad no!");
			e.printStackTrace();
		}
		
		
		
	}

}
