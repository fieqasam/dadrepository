package payment.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import payment.Payment;
import payment.paymentManager;

/**
 * This class represent a server-side application.
 * 
 * The application demonstrate reading and writing a list of of object data using 
 * TCP and I/O streams.
 * 
 * The program reads a list of object to be process from the client
 * and return it to the client.
 * 
 *cd C:\Users\User10\Documents\GitHub\dadrepository\workspace-dadlabs\lab05\bin
 *
 * run java listObject.client.ListPaymentClientApp
 * 
 * @author Nurul Afiqah
 *
 */

public class paymentServerApp {

	public static void main(String[] args) {
		
		paymentManager managePayment = new paymentManager();
		
		System.out.println("Starting Payment Server side..");
		
		try {
			//Bind SeverSocket to a port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			//Server need to be alive forever
			while(true) {
				
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Read object from client, cast into payment
				
				ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
				Payment payment = (Payment) ois.readObject();
				System.out.println("Processing object from client: "+payment.getPaymentId());
				
				//Process object
				payment = managePayment.managePayment(payment);
				
				//Return object to client using input stream
				ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
				oos.writeObject(payment);
				
				//close all stream
				ois.close();
				oos.close();
				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
