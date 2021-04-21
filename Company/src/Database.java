import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.w3c.dom.Text;

//import javax.xml.soap.Text;

import java.math.*;

public class Database {

	
	private String url = "jdbc:sqlite:D:\\Program Files (x86)\\SQLiteStudio\\GameDatabase.db";
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
	
	public ArrayList<Game> gameYearLookup(Float YearSearch) throws SQLException {
		String query = "SELECT Rank, Name, Platform, Genre, Year FROM Game WHERE Year = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setFloat(1, YearSearch);
		ResultSet results = stmt.executeQuery();
		ArrayList<Game> games = new ArrayList<>();
		
		Game g = null;
		while(results.next()) {
			//BigInteger index = BigInteger.valueOf(results.getLong("index"));
			BigInteger Rank = BigInteger.valueOf(results.getLong("Rank"));
			String Name = results.getString("Name");
			String Platform = results.getString("Platform");
			String Genre = results.getString("Genre");
			Float Year = results.getFloat("Year");
			g = new Game(Rank, Name, Platform, Genre, Year);
			games.add(g);
		}
		
		return games;
	}
	
	public void insertGame(Game g) throws SQLException {
		String sql = "INSERT INTO Game(index, Rank, Name, Platform, Genre, Year) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, Long.parseLong(g.getIndex().toString()));
		stmt.setLong(2, Long.parseLong(g.getRank().toString()));
		stmt.setString(3, g.getName());
		stmt.setString(4, g.getGenre());
		stmt.setFloat(5, g.getYear());
		stmt.executeUpdate();
	}
	
	
	
}

