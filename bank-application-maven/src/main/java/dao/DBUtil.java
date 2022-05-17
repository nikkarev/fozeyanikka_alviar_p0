package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Load the driver only ONCE.
 * Establish the driver only ONCE.
 */
public class DBUtil {

	static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Connection establishConnection() throws SQLException {
		String connectionUrl = "jdbc:postgresql://localhost:5433/bank";
		String userName = "postgres";
		String password = "coffee";
		
		if(connection==null) {
			connection = DriverManager.getConnection(connectionUrl, userName, password);
		}
		return connection;
	}
	
}
