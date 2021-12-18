package assignment2.parcel;


public class ParcelIdGenerator {
	
	static int i=1;  
	Parcel parcel = new Parcel();
	
	public String getParcel_id() {
			
			String parcel_id = "100" + i++;;
			
			return parcel_id;
			
			
		}

}
