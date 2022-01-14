package assignment2.tcpparcelserver;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import assignment2.customer.Customer;
import assignment2.order.Order;
import assignment2.parcel.Parcel;
import assignment2.parcel.ParcelIdGenerator;
import assignment2.parcel.ParcelManager;


public class ServerParcelApp extends Thread  {
	
    static Vector records = new Vector(10,10);
    ObjectOutputStream out =null;

    static String databaseName = "parceldb";
	static String username = "root";
	static String password = "mysql1234";
    static Connection conn = null;
    static java.sql.Statement stmt = null;
    static ResultSet rs;
    static String connectionPath = "jdbc:mysql://localhost:3306/" + databaseName + "?" +
            "user=" + username + "&password=" + password;
    Customer cust = null;
    Order order = null;
    Parcel parcel = null;
	
public static void main(String[] args) {
	
	
		ParcelManager parcelManager = new ParcelManager();

		
		// Launch the server frame
		ServerParcelFrame serverFrame = new ServerParcelFrame();
		serverFrame.setVisible(true);
		
		try {
			
			// Bind Serversocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			ParcelIdGenerator parcelidGenerator = new ParcelIdGenerator();

			// Counter to keep track the number of requested connection
			int totalRequest = 0;

			// Server need to be alive forever
			while (true) {

				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();

				// Get current parcel_id
				String parcelid = parcelidGenerator.getParcel_id();
				
				//Read object from client, cast into parcel
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				Parcel parcel = (Parcel) ois.readObject();
				
				//Process object
				parcel = parcelManager.createParcel(parcel);
				
				//Return object to client using input stream
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				//send back to the client
				oos.writeObject(parcel);
				

				
				// Update the request status
				
				serverFrame.updateRequestStatus("Processing object from client: "+ parcel.getParcel_weight() + "kg");
				serverFrame.updateRequestStatus("Data sent to the client: " 
						+ parcelid);
				serverFrame.updateRequestStatus(
						"Accepted connection from the client.  "
						+ "Total request =" + ++totalRequest);
			    serverFrame.updateRequestStatus("Data sent to the client: ");
			         
			}


			
			
		} catch (Exception exception) {

			System.out.println("Durian Tunggal, we got problem.");
			exception.printStackTrace();

		}
	
	}

}
