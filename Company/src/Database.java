/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.sql.*;
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
	
	//This function is a sample one. It looks up all games released in the year wanted.
	public ArrayList<Game> gameYearLookup(Float YearSearch) throws SQLException {
		String query = "SELECT Rank, Name, Platform, Genre, Year FROM Game WHERE Year = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setFloat(1, YearSearch);
		ResultSet results = stmt.executeQuery();
		ArrayList<Game> games = new ArrayList<>();
		Game g = null;
		while(results.next()) {
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
	
	//This function is a sample one. It takes two tables and joins them.
	//ITS USELESS NO IT DOESNT
	public ArrayList<Game> joinStatement(String query) throws SQLException{
		ArrayList<Game> results = new ArrayList<>();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rawResults = stmt.executeQuery();
		
		while(rawResults.next()) {
			System.out.println(rawResults.getString("Name"));
			System.out.println(rawResults.getFloat("Global_Sales"));
		}
		return results;
	}
	
	
	
	public void basicQuery(String query) throws SQLException{
		ArrayList<Game> results = new ArrayList<>();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet rawResults = stmt.executeQuery();
		
		while(rawResults.next()) {
			//RANK
			try {
				if(rawResults.getLong("Rank") != 0) {
					System.out.print("RANK: " + rawResults.getLong("Rank") + "  ");
				}
			} catch (SQLException e) {
			}
			//NAME
			try {
				if(rawResults.getString("Name")!= null) {
					System.out.print("NAME: " + rawResults.getString("Name") + "  ");
				}
			} catch (SQLException e) {
			}
			//PLATFORM
			try {
				if(rawResults.getString("Platform") != null) {
					System.out.print("PLATFORM: " + rawResults.getString("Platform") + "  ");
				}
			} catch (SQLException e) {
			}
			//GENRE
			try {
				if(rawResults.getString("Genre") != null) {
					System.out.print("GENRE: " + rawResults.getString("Genre") + "  ");
				}
			} catch (SQLException e) {
			}
			//YEAR
			try {
				if(rawResults.getFloat("Year") != 0) {
					System.out.print("YEAR: " + rawResults.getFloat("Year") + "  ");
				}
			} catch (SQLException e) {
			}
			//DEVELOPER
			try {
				if(rawResults.getString("Developer") != null) {
					System.out.print("DEVELOPER: " + rawResults.getString("Developer") + "  ");
				}
			} catch (SQLException e) {
			}
			//PUBLISHER
			try {
				if(rawResults.getString("Publisher") != null) {
					System.out.print("PUBLISHER: " + rawResults.getString("Publisher") + "  ");
				}
			} catch (SQLException e) {
			}
			//ESRB_RATING
			try {
				if(rawResults.getString("ESRB_Rating") != null) {
					System.out.print("ESRB RATING: " + rawResults.getString("ESRB_Rating") + "  ");
				}
			} catch (SQLException e) {
			}
			//CRITIC SCORE
			try {
				if(rawResults.getFloat("Critic_Score") != 0) {
					System.out.print("CRITIC SCORE: " + rawResults.getFloat("Critic_Score") + "  ");
				}
			} catch (SQLException e) {
			}
			//USER SCORE
			try {
				if(rawResults.getFloat("User_Score") != 0) {
					System.out.print("USER SCORE: " + rawResults.getFloat("User_Score") + "  ");
				}
			} catch (SQLException e) {
			}
			//TOTAL SHIPPED
			try {
				if(rawResults.getFloat("Total_Shipped") != 0) {
					System.out.print("TOTAL SHIPPED: " + rawResults.getFloat("Total_Shipped") + " Million  ");
				}
			} catch (SQLException e) {
			}
			//GLOBAL SALES
			try {
				if(rawResults.getFloat("Global_Sales") != 0) {
					System.out.print("GLOBAL SALES: " + rawResults.getFloat("Global_Sales") + " Million  ");
				}
			} catch (SQLException e) {
			}
			//NA SALES
			try {
				if(rawResults.getFloat("NA_Sales") != 0) {
					System.out.print("NORTH AMERICAN SALES: " + rawResults.getFloat("NA_Sales") + " Million  ");
				}
			} catch (SQLException e) {
			}
			//PAL SALES
			try {
				if(rawResults.getFloat("PAL_Sales") != 0) {
					System.out.print("EUROPEAN SALES: " + rawResults.getFloat("PAL_Sales") + " Million  ");
				}
			} catch (SQLException e) {
			}
			//JP SALES
			try {
				if(rawResults.getFloat("JP_Sales") != 0) {
					System.out.print("JAPANESE SALES: " + rawResults.getFloat("JP_Sales") + " Million  ");
				}
			} catch (SQLException e) {
			}
			//OTHER SALES
			try {
				if(rawResults.getFloat("Other_Sales") != 0) {
					System.out.print("ALL OTHER SALES: " + rawResults.getFloat("Other_Sales") + " Million  ");
				}
			} catch (SQLException e) {
			}
			
			
			System.out.println();
		}
	}
	
	//This function inserts a NEW game into the Game table
	public void insertGame(Game g) throws SQLException {
		String sql = "INSERT INTO Game(Rank, Name, Platform, Genre, Year) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, Long.parseLong(g.getRank().toString()));
		stmt.setString(2, g.getName());
		stmt.setString(3, g.getPlatform());
		stmt.setString(4, g.getGenre());
		stmt.setFloat(5, g.getYear());
		stmt.executeUpdate();
	}
	
	//This function deletes a game from the Game table
	public void deleteGame(String g) throws SQLException {
		String sql = "DELETE FROM Game WHERE Name = '"+ g + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.executeUpdate();
	}
	
	public void updateGame(Game g) throws SQLException{
		String sql = "UPDATE Game SET Platform=?, Genre=?, Year=? WHERE Name =?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, g.getPlatform());
		stmt.setString(2, g.getGenre());
		stmt.setFloat(3, g.getYear());
		stmt.setString(4, g.getName());
		stmt.executeUpdate();
	}
	
	
	
}

