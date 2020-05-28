package UI;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import DAO.UserDAOImplementation;

public class Main {

	static Scanner unos = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		
		try {
			menu1();
		}catch(InputMismatchException e) {
			unos.nextLine();
			System.out.println("Morate unijeti broj!");
			menu1();
		}

	}

	public static void menu1() throws SQLException {
		System.out.println("1 - Sign up");
		System.out.println("2 - Log in");		
			int broj = unos.nextInt();
			if(broj == 1) {
				getInfoForUser();		
			} else if (broj == 2) {
				checkingLogin();
			} else {
				System.out.println("Wrong input! Try again: ");	
				menu1();
			}
	}
	
	public static void getInfoForUser() throws SQLException {
		System.out.println("Enter your first name: ");
		unos.nextLine();
		String firstName = unos.nextLine();
		System.out.println("Enter yout last name: ");
		String lastName = unos.nextLine();
		System.out.println("Enter your username: ");
		String userName = unos.nextLine();
		while(UserDAOImplementation.checkingUserName(userName) == true) {
			System.out.println("This username is already taken, try again: ");
			userName = unos.nextLine();
		}
		
		System.out.println("Enter your password (password must have more than 6 characters): ");
		String password = unos.nextLine();
		while(checkingPassword(password) == false) {
			System.out.println("Password must have more than 6 characters! Try again: ");
			password = unos.nextLine();
		}
		
		UserDAOImplementation.createUser(firstName, lastName, userName, password);
		
		
		try {
			menu1();
		}catch(InputMismatchException e) {
			unos.nextLine();
			System.out.println("Morate unijeti broj!");
			menu1();
		}
		
	}
	
	public static boolean checkingPassword(String password) {
		if(password.length() < 6) {
			return false;
		}
		return true;
	}
	
	public static void checkingLogin() throws SQLException {
		System.out.println("Enter your username: ");
		unos.nextLine();
		String userName = unos.nextLine();
		System.out.println("Enter you password: ");
		String password = unos.nextLine();
		int brojac = 0;
		
		if(UserDAOImplementation.loginUser(userName, password).equals("Mistake!")){
			System.out.println("You enetered the wrong username!");
			menu1();
		} else {
				if(UserDAOImplementation.loginUser(userName, password).equals(password)) {
					System.out.println("You have successfully loged in your account! ");
					try {
						menu2(userName);
					}catch(InputMismatchException e) {
						unos.nextLine();
						System.out.println("Morate unijeti broj!");
						menu2(userName);
					}
				}
				while(!UserDAOImplementation.loginUser(userName, password).equals(password)) {
					System.out.println("You have entered the wrong password!");
					password = unos.nextLine();
					brojac++;
					if(brojac == 4) {
						try {
							menu1();
						}catch(InputMismatchException e) {
							unos.nextLine();
							System.out.println("Morate unijeti broj!");
							menu1();
						}
						break;
					}
				}
				
			} 
	}
	
	public static void menu2(String userName) throws SQLException {
		System.out.println("1 - Change firstname");
		System.out.println("2 - Change lastname");
		System.out.println("3 - Account info");
		System.out.println("4 - Log out");
		int broj = unos.nextInt();
		
		if(broj == 1) {	
			changingFirstName(userName);
			try {
				menu2(userName);
			}catch(InputMismatchException e) {
				unos.nextLine();
				System.out.println("Morate unijeti broj!");
				menu2(userName);
			}
		} else if (broj == 2) {
			changingLastName(userName);
			try {
				menu2(userName);
			}catch(InputMismatchException e) {
				unos.nextLine();
				System.out.println("Morate unijeti broj!");
				menu2(userName);
			}
		} else if(broj == 3) {
			UserDAOImplementation.getUserInfo(userName);
			try {
				menu2(userName);
			}catch(InputMismatchException e) {
				unos.nextLine();
				System.out.println("Morate unijeti broj!");
				menu2(userName);
			}
		}else if(broj == 4){
			try {
				menu1();
			}catch(InputMismatchException e) {
				unos.nextLine();
				System.out.println("Morate unijeti broj!");
				menu1();
			}
		}
	}
	
	public static void changingFirstName(String userName) throws SQLException {
		System.out.println("Enter your new firstname: ");
		unos.nextLine();
		String firstName = unos.nextLine();
		
		UserDAOImplementation.updateFirstName(firstName, userName);
	}
	
	public static void changingLastName(String userName) throws SQLException{
		System.out.println("Enter your lastname: ");
		unos.nextLine();
		String lastName = unos.nextLine();
		
		UserDAOImplementation.updateLastName(lastName, userName);
	}
	
	
}



























