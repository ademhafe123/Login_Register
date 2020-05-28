package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

		// instanca same klase
		private static ConnectionManager instance = null;

		// vrijednosti koje smo izabrali prilikom instalacije MySQL Servera
		private static final String USERNAME = "root";
		private static final String PASSWORD = "ademhafe54321";
		// localhost//imeBazeNaKojuSeSpajamo
		private static final String CONN_STRING = "jdbc:mysql://localhost/users?useSSL=false&serverTimezone=UTC";

		// connection object
		private Connection connection = null;

		// privatni konstruktor - klasa moze biti instancirana samo unutar sebe
		private ConnectionManager() {

		}

		// provjeriti da li je instanca null, instancirati i vratiti ili samo vratiti
		public static ConnectionManager getInstance() {
			if (instance == null) {
				instance = new ConnectionManager();
			}
			return instance;
		}

		private boolean openConnection() {
			try {
				connection = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				return true;
			} catch (SQLException e) {
				System.err.println(e);
				return false;
			}
		}

		public Connection getConnection() {
			if (connection == null) {
				if (openConnection()) {
					return connection;
				} else {
					return null;
				}
			}
			return connection;
		}

		public void close() {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
			}
		}
	
}
