package parcel.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import parcel.Parcel;

/**
 * This class represent a client-side application.
 * 
 * The application demonstrate reading and writing object data using TCP
 * and I/O streams.
 * 
 *  The program sends the object to be process to be
 *  server-side program by writing into an input stream.
 *  
 *  The program will
 *  received the processed object from the server-side application by reading
 *  input stream.
 *  
 *   @author Nurul Afiqah
 */

public class SimpleParcelClientApp {

	public static void main(String[] args) {
		
		System.out.println("Launching SimpleParcelClientApp program");
		
		// Create new object
		Parcel parcel = new Parcel();
		parcel.setWeight(0.99);
		
		try {
			
			//Connect to server-side program
			Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
			
			//Send object to be processed by the server-side application
			ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
			oos.writeObject(parcel);
			
			System.out.println("Sending "+parcel.getWeight() + " kg"
					+ " to server-side application");
			
			//Receive processed object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Parcel processedParcel = (Parcel) ois.readObject();
			
			//Manipulate processed object
			System.out.println("Weight of the parcel(in kg): "+ parcel.getWeight());
			System.out.print("The courier charge: RM  ");
			//
			System.out.printf("%.2f", processedParcel.getWeight());
			
			//close all streams
			ois.close();
			oos.close();
			socket.close();
		}
		catch (Exception ex) {
			
		}

	}

}
