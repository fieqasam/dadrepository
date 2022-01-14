package parcel;

public class ParcelManager {
	
	public Parcel createParcel(Parcel parcel) {
		
		double weight = parcel.getWeight();
		parcel.setWeight(weight);
		
		//Get weight of the parcel 
		double price = this.courierCharge(parcel.getWeight());
		parcel.setPrice(price);
		
		return parcel;
		
	}
	
	/**
	 * This method to calculate the rate of shipping based on weight
	 * @param weight
	 * @return price
	 */
	
	private double courierCharge(double weight) {
		
		double price = 0.0;
		
		if(weight <= 0.00) {
			
			System.out.println("Please enter the valid amount of weight in kg.");
		}
		else if(weight >= 0.00 && weight<=0.50) {
			
			price = 8.00;
		}
		else if(weight>= 0.51 && weight <= 1.00) {
			
			price = 9.00;
		}
		else if(weight >= 1.01 && weight <=1.50) {
			
			price = 10.05;
			
		}
		else if(weight >= 1.51 && weight <= 2.00) {
			
			price = 10.60;
	
		}
		else {
			System.out.println("The weight you've insert exceed the limit.");
		}
		return price;
	}

}
