package parcel;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 1.import
 * 2.load and register
 * 3.Establish connection
 */
public class JDBC {

	public static void main(String[] args){
	
		try {
			//1.Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "", "");
			//2.Create a statement
			//3.Execute SQL query
			//4.Process the result
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
