package assignment2.tcpparcelkiosk;

import assignment2.parcel.Parcel;

public class ClientParcelApplication {

	public static void main(String[] args) {
		// Launch client-side frame
		ManageParcel manageParcelFrame = new ManageParcel();
		manageParcelFrame.setVisible(true);
		
		// Create new object to get from db
		Parcel parcel = new Parcel();
		//Connect to the server at localhost port 4228
		

	}

}
