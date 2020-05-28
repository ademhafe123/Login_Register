package DTO;

public class User {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	String name;
	String lastName;
	String userName;
	String password;
	
	public User(String name, String lastName, String userName, String password) {
		name = this.name;
		lastName = this.lastName;
		userName = this.userName;
		password = this.password;
	}
	
}
