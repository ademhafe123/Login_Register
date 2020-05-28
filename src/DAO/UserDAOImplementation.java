package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import DTO.User;

public class UserDAOImplementation {
	
	public static void createUser(String firstName, String lastName, String userName, String password) throws SQLException {
		
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String query = "INSERT INTO users(userName, firstName, lastName, usersPassword) "
				+ "values(?, ?, ?, ?)";
		
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, userName);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, password);
		
			statement.executeUpdate();
			System.out.println("User account successfully added! ");
		}
		
	}
	
	public static String loginUser(String userName, String password) throws SQLException {
		String str = "";
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String query = "SELECT * FROM users WHERE userName = ?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, userName);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				str = rs.getString("usersPassword");
				rs.close();
			}else {
				str = "Mistake!";
			}
		}
		return str;
	}

	public static void updateFirstName(String firstName, String userName) throws SQLException {
		
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE users SET firstName = ? WHERE userName = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, firstName);
			statement.setString(2, userName);
			
			statement.executeUpdate();
		}
		
		System.out.println("You have successfully changed your firstname! ");
	}
	
	public static void updateLastName(String lastName, String userName) throws SQLException {
		
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String query = "UPDATE users SET lastName = ? WHERE userName = ?";
		
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, lastName);
			statement.setString(2, userName);
			
			statement.executeUpdate();
		}
		
		System.out.println("You have successfully changed your lastname! ");
	}
	
	public static void getUserInfo(String userName) throws SQLException {
		Connection connection = ConnectionManager.getInstance().getConnection();
		
		String query = "SELECT * FROM users WHERE userName = ?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, userName);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				System.out.println("Username: " + rs.getString("userName"));
				System.out.println("Firstname: " + rs.getString("firstName"));
				System.out.println("Lastname: " + rs.getString("lastName"));
			}
		}
		
	}
	
	public static boolean checkingUserName(String userName) throws SQLException {
		String query = "SELECT * FROM users";
		boolean validacija = false;
		Connection connection = ConnectionManager.getInstance().getConnection();

		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			if(userName.equals(rs.getString("userName"))) {
				validacija = true;
			}
		}		
		return validacija;
	}

}


















