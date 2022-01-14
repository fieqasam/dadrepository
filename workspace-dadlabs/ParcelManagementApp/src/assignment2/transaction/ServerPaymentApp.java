package assignment2.transaction;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import assignment2.customer.Customer;
import assignment2.order.Order;
import assignment2.parcel.Parcel;
import assignment2.parcel.ParcelManager;
import assignment2.parceltransaction.ParcelTransaction;
import assignment2.parceltransaction.ParcelTransactionManager;

public class ServerPaymentApp extends Thread {
	
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
    ParcelTransaction parcelTransaction = null;
    
	public static void main(String[] args) {
		
			ParcelManager parcelManager = new ParcelManager();
			ParcelTransactionManager ptManager = new ParcelTransactionManager();
			
			ServerPaymentFrame frame = new ServerPaymentFrame();
			frame.setVisible(true);
			
			try {
				
			//binding portNo 4884 to server socket
			int portNo = 4884;
			ServerSocket serverSocket = new ServerSocket(portNo);

			int totalRequest = 0;
			
			//OrderTransaction orderTransaction = null;
			while(true) {
				
				
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Receive data card credit from client
				ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream()); //(2)
				//receive order from server
//				Parcel parcel = (Parcel)inputStream.readObject();
				ParcelTransaction parceltransaction = (ParcelTransaction) inputStream.readObject();
				
				//Process object
//				parcel = parcelManager.createParcel(parcel);
				parceltransaction = ptManager.createPayment(parceltransaction);
				
				String creditCardNo = parceltransaction.getCreditcard();
				int paymentid = parceltransaction.getPaymentTransactionId();
				String amount = parceltransaction.getAmountCharged();
				
				//to send validation status to server
				ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				outputStream.writeObject(parceltransaction);
//				outputStream.writeObject(parcel);

				
				// Update the request status
				frame.updateRequestStatus(
						"Data sent to the client: " + paymentid);
				frame.updateRequestStatus(
						"Amount: RM " + amount);
				frame.updateRequestStatus(
						"Transaction Successful");
				frame.updateRequestStatus("Accepted connection to from the "
						+ "client. Total request = " + ++totalRequest );
				
				System.out.println(creditCardNo);
				
				outputStream.flush();
				clientSocket.close();	
				inputStream.close();
				outputStream.close();
				
				}
			
			}catch (Exception exception) {
				
				System.out.println("Durian Tunggal, we got problem.");
				exception.printStackTrace();
			}
			
	}


}
