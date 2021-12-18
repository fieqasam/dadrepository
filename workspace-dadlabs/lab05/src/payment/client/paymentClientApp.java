package payment.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import parcel.Parcel;
import payment.Payment;

/**
 * This class represent a client-side application.
 * 
 * The application demonstrate reading and writing object data using 
 * TCP and I/O streams.
 * 
 * The program send the list of objects to be process to the server-side
 * program by writing in into an input stream.
 * 
 * @author nurul afiqah
 * 
 */

public class paymentClientApp {

	public static void main(String[] args) {
		System.out.println("Launching Payment Client App..");
		
		// Create new object
		Parcel parcel = new Parcel();
		parcel.setWeight(4.50);
		
		Payment payment = new Payment();
		payment.setPaymentId(1377305051);
		
		Date date = new Date();
		Timestamp trans = new Timestamp(date.getTime());
		payment.setTransactionDate(trans);
		
		String name ="Nurul Afiqah";
		payment.setRecordedBy(name);
		
	
		 try {
			 //Connect to server-side program
			 Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
			 
			 //Send object to be processed by the server-side application
			 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			 oos.writeObject(payment);
			 oos.writeObject(parcel);
			 
			 System.out.println("Sending "+payment.getPaymentId() + " to server-side application");
			 
			 //Receive processed object
			 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			 Payment processedPayment = (Payment) ois.readObject();
			 Parcel processedParcel = (Parcel) ois.readObject();
			 
			 //Manipulate processed object
			 System.out.println("Payment Id: "+ processedPayment.getPaymentId());
			 System.out.println("Weight of Parcel: "+processedParcel.getWeight());
			 System.out.println("Recorded By:  " + processedPayment.getRecordedBy());
			 System.out.println("Transaction Date: "+processedPayment.getTransactionDate());
			 
			 
			 //Close all stream
			 ois.close();
			 oos.close();
			 socket.close();
			 
			 
		 }
		 catch(Exception ex) {
			 
		 }
		

	}

}
