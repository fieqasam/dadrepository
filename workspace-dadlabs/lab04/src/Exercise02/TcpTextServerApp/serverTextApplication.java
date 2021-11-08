package Exercise02.TcpTextServerApp;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * To run this application on terminal
 * cd TCPTextServerApp/bin/
 * java servertext.ServerTextApplication
 * @author Nurul Afiqah
 *
 */

public class serverTextApplication {

	public static void main(String[] args) {
		// Launch the server frame
		serverTextFrame serverFrame = new serverTextFrame();
		serverFrame.setVisible(true);
		
		try {
			//Bind SeverSocket to port
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			TextGenerator textGenerator = new TextGenerator();
			
			// Counter to keep track the number of requested connection
			int totalRequest = 0;
			
			// Server need to be alive forever
			while(true) {
				
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//Get current text input length		
				int textLength = textGenerator.getTextLength();
				
				// Create stream to write data on the network
				DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());
				//send current text length back to the client
				outputStream.writeByte(textLength);
				
				// Close the socket
				clientSocket.close();
				
				//update the request status
				serverFrame.updateRequestStatus("Data sent to the client: "+textLength);
				serverFrame.updateRequestStatus("Accepted connection from the client. " 
				+ "Total request =" + ++totalRequest);
				
			}
			
		}catch(Exception exception) {
			
			System.out.println("Durian Tunggal, we got problem");
			exception.printStackTrace();
		}
	

	} 

}
