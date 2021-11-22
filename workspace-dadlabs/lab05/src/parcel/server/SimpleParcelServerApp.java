package parcel.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import parcel.Parcel;
import parcel.ParcelManager;

/**
 * This class represent a server-side application.
 * 
 * The application demonstrate reading and writing object data using TCP 
 * and I/O streams. The program reads object to be process from the client
 * and return the processed object to the client. 
 *  
 *  @author Nurul Afiqah
 * 
 */

public class SimpleParcelServerApp {

	public static void main(String[] args) {
		
		ParcelManager parcelManager = new ParcelManager();
		
		System.out.println("Starting SimpleParcelServerApp");
		
		try {
			// Bind ServerSocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			//Server need to be alive forever
			while (true) {
				
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Read object from client, cast into Parcel
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				Parcel parcel = (Parcel) ois.readObject();
				System.out.println("Processing object from client: " +parcel.getWeight() + " kg");
				
				//process object
				parcel = parcelManager.createParcel(parcel);
				
				//Return object to client using input stream
				ObjectOutputStream oos  = new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(parcel);
				
				//Close all streams
				ois.close();
				oos.close();
			}
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
