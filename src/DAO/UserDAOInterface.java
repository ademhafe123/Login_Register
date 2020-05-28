package DAO;

import java.sql.SQLException;

public interface UserDAOInterface {

	public void createUser(String name, String lastName, String userName, String password) throws SQLException;
	
	public String loginUser(String userName, String password) throws SQLException;
	
	public void updateFirstName(String firstName, String userName) throws SQLException;
	
	public void updateLastName(String lastName, String userName) throws SQLException;
	
	public String getUserInfo(String userName) throws SQLException;
	
	public boolean checkingUserName(String userName) throws SQLException;
	
}
