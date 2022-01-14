package assignment2.deliverybay;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import assignment2.order.Order;
import assignment2.parceltransaction.ParcelTransaction;

public class ClientDeliveryApp extends Thread {
	
	public static void main(String[] args) throws Exception, IOException {

		ClientDeliveryFrame window = new ClientDeliveryFrame();
		window.setVisible(true);
			
		// Step 2: Making connection using
        // Connection type and inbuilt function on
		String databaseName = "parceldb";
		String username = "root";
		String password = "mysql1234";
	    Connection conn;
	    java.sql.Statement stmt;
	    ResultSet st = null;
	    PreparedStatement p = null;
        ResultSet rs = null;
	    String connectionPath = "jdbc:mysql://localhost:3306/" + databaseName + "?" +
	            "user=" + username + "&password=" + password;
 
	    conn = (Connection)DriverManager.getConnection(connectionPath);
        stmt = conn.createStatement();
 
        // Try block to catch exception/s
        try {
 
            // SQL command data stored in String datatype
            String sql = "select * from parcel";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
 
            // Printing ID, name, email of customers
            // of the SQL command above
//            System.out.println("Order No\t\tWeight\t\tParcel Type\t\tDelivery Rate");
 
            // Condition check
            while (rs.next()) {
 
                String weight = rs.getString("parcel_weight");
                String type = rs.getString("parcelType");
                String rate = rs.getString("parcel_delivery_rate");
                String tracking = rs.getString("parcel_tracking_no");
                int id_order = rs.getInt("idorder");
                
                String currentDate = new Date().toString();
//                window.updateRequestStatus("Order No\t\tWeight\t\tParcel Type\t\tDelivery Rate");
                System.out.println("Order No: " + id_order + "\n" + "Weight: " + weight
                                   + "\t\t" + "Parcel Type: "+ type + "\t" + "Delivery Rate" + rate);
				window.updateRequestStatus("Order No: " + id_order + "\n > Weight: " + weight
                        + "\t\t\t" + "Parcel Type: "+ type + "\n > Delivery Rate: " + rate + "\t" + "Tracking No: " + tracking);
				window.updateRequestStatus("Drop Off Delivery for " + currentDate);
            }
        }
 
        // Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on scrreen
            System.out.println(e);
        }
    }


}
