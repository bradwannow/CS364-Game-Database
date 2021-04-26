import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
	
	public static void main(String[] args) {
		
		Database db = Database.getInstance();
		Scanner userInput = new Scanner(System.in);
		
		try {
			db.connect();
			System.out.println("Database connected successfully!.");
		} catch (SQLException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
		
		ArrayList<Game> games = new ArrayList<>();
		while(true) {
		System.out.println("What would you like to do?");
		String userQuery = userInput.nextLine().toUpperCase();
		if(userQuery.equals("EXIT")) {
			break;
		}
		//This will allow the user to update a game's information
		//DATABASE BUSY? DATABASE LOCKED? DOESNT WORK YET
		else if(userQuery.equals("UPDATE")) {
			System.out.println("Provide Name of Game to Update");
			String updateName = userInput.nextLine();
			System.out.println("Provide Platform of Game to Update");
			String updatePlatform = userInput.nextLine().toUpperCase();
			System.out.println("Provide Genre of Game to Update");
			String updateGenre = userInput.nextLine().toUpperCase();
			System.out.println("Provide Release Year of Game to Update");
			Float updateYear = userInput.nextFloat();
			Game updatedGame = new Game(updateName, updatePlatform, updateGenre, updateYear);
			try {
				db.updateGame(updatedGame);
				System.out.println("Game updated successfully!");
			} catch (SQLException e) {
				System.out.println("Error updating Game!");
				e.printStackTrace();
			}
		}
		
		//this will allow the user to insert a new game into the database!
		//DATABASE BUSY? DATABASE LOCKED? DOESNT WORK YET
		else if(userQuery.equals("INSERT")) {
			System.out.println("Provide Name of Game");
			String newName = userInput.nextLine().toUpperCase();
			System.out.println("Provide Platform of Game");
			String newPlatform = userInput.nextLine().toUpperCase();
			System.out.println("Provide Genre of Game");
			String newGenre = userInput.nextLine().toUpperCase();
			System.out.println("Provide Release Year of Game");
			Float newYear = userInput.nextFloat();
			Game newGame = new Game(newName, newPlatform, newGenre, newYear);
			try {
				db.insertGame(newGame);
				System.out.println("Game added successfully!");
			} catch (SQLException e) {
				System.out.println("Error inserting game!");
				e.printStackTrace();
			}
		}
		
		else if(userQuery.equals("DELETE")){
			System.out.println("Provide Name of Game");
			String gameToDelete = userInput.nextLine();
			try {
				db.deleteGame(gameToDelete);
				System.out.println("Game Deleted Successfully!");
			} catch (SQLException e) {
				System.out.println("Error Deleting Game!");
				e.printStackTrace();
			}
		}
		else if(userQuery.equals("SEARCH")) {
			
		}
		else if(userQuery.equals("HELP")) {
			System.out.println("To update the database, type 'UPDATE'");
			System.out.println("To insert into the database, type 'INSERT'");
			System.out.println("To delete a record from the database, type 'DELETE'");
			System.out.println("To search the database, type 'SEARCH'");
			System.out.println("To exit the application, type 'EXIT'");
		}
		else {
			System.out.println("Unknown input. Try again or type 'HELP' for help!");
		}
		
		
		//end of while(true) loop
		}
		userInput.close();
		
		
		
		try {
			db.disconnect();
			System.out.println("Database disconnected good yes.");
		} catch (SQLException e) {
			System.out.println("Database disconnected bad no!");
			e.printStackTrace();
		}
		
		
		
	}

}
