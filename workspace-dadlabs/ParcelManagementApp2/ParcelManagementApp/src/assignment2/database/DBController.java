package assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBController {
	
	public static void main (String[] args) {
	
	String databaseName = "parceldb";
	String username = "root";
	String password = "Bitp3123@";
	
	String connectionPath = "jdbc:mysql://localhost:3306/" + databaseName + "?" +
            "user=" + username + "&password=" + password;
	
	Connection conn = null;
	try {
				
		conn = (Connection)DriverManager.getConnection(connectionPath);

		if (conn != null) {
			System.out.println("Connected successfully");
		}
	}catch (Exception e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	}


}
