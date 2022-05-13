package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Connection makeConnection() throws SQLException {
		String connectionUrl = "jdbc:postgresql://localhost:5432/sms";
		String userName = "postgres";
		String password = "coffee";
		
		if(conn==null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		return conn;
	}
	
}
