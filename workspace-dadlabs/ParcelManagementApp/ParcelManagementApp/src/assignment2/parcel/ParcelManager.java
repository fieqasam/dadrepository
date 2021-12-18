package assignment2.parcel;

public class ParcelManager {
	
public Parcel createParcel(Parcel parcel) {
		
		Double weight = parcel.getParcel_weight();
		parcel.setParcel_weight(weight);
		
		String rate = parcel.getParcel_delivery_rate();
		parcel.setParcel_delivery_rate(rate);
	
		//get weight of the parcel
		Double txtAmountParcel  = this.courierCharge(parcel.getParcel_weight(), parcel.getParcel_delivery_rate());
		String amount = Double.toString(txtAmountParcel);
		parcel.setParcel_delivery_rate(amount);
			return parcel;
	}

	/**
	 * This method to calculate the rate of shipping based on weight and rate
	 * @param weight, rate
	 * @return price
	 */

	public double courierCharge(double weight, String rate) {
	
		double txtAmountParcel = 0.0;
		
		if(rate == "Peninsular State" && weight >= 0.0 && weight <= 0.50) {
			
			txtAmountParcel = 8;
		}
		else if (rate == "Peninsular State" && weight >= 0.51 && weight <= 1.00) {
			txtAmountParcel = 9;
		}
		else if (rate == "Peninsular State" && weight >= 1.01 && weight <= 1.50) {
			txtAmountParcel = 10.05;
		}
		else if (rate == "Peninsular State" && weight >= 1.51 && weight <= 2.00) {
			txtAmountParcel = 10.60;
		}
		else if (rate == "Peninsular State" && weight >= 2.01 && weight <= 2.50) {
			txtAmountParcel = 11.65;
		}
		else if (rate == "Peninsular State" && weight >= 2.51 && weight <= 3.00) {
			txtAmountParcel = 12.70;
		}
		else if (rate == "Peninsular State" && weight >= 3.01 && weight <= 3.50) {
			txtAmountParcel = 13.80;
		}
		else if (rate == "Peninsular State" && weight >= 3.51 && weight <= 4.00) {
			txtAmountParcel = 14.30;
		}
		else if (rate == "Peninsular State" && weight >= 4.01 && weight <= 4.50) {
			txtAmountParcel = 14.85;
		}
		else if (rate == "Peninsular State" && weight >= 4.51 && weight <= 5.00) {
			txtAmountParcel = 14.85;
		}
		else if (rate == "Peninsular State" && weight >= 5.01 && weight <= 5.50) {
			txtAmountParcel = 15.90;
		}
		else if (rate == "Peninsular State" && weight >= 5.51 && weight <= 6.00) {
			txtAmountParcel = 15.90;
		}
		else if (rate == "Peninsular State" && weight >= 6.01 && weight <= 6.50) {
			txtAmountParcel = 16.95;

		}
		else if (rate == "Peninsular State" && weight >= 6.51 && weight <= 7.00) {
			txtAmountParcel = 16.95;
		}
		else if (rate == "Peninsular State" && weight >= 7.01 && weight <= 7.50) {
			txtAmountParcel = 18;
		}
		else if (rate == "Peninsular State" && weight >= 7.51 && weight <= 8.00) {
			txtAmountParcel = 18;
		}
		else if (rate == "Peninsular State" && weight >= 8.01 && weight <= 8.50) {
			txtAmountParcel = 20.15;
		}
		else if (rate == "Peninsular State" && weight >= 8.51 && weight <= 9.00) {
			txtAmountParcel = 20.15;
		}
		else if (rate == "Peninsular State" && weight >= 9.01 && weight <= 9.50) {
			txtAmountParcel = 21.20;
		}
		else if (rate == "Peninsular State" && weight >= 9.51 && weight <= 10.00) {
			txtAmountParcel = 21.20;
		}
		else if(rate == "Within Peninsular" && weight >= 0.0 && weight <= 0.50) {
			
			txtAmountParcel = 8.50;
		}
		else if (rate == "Within Peninsular" && weight >= 0.51 && weight <= 1.00) {
			txtAmountParcel = 10.05;
		}
		else if (rate == "Within Peninsular" && weight >= 1.01 && weight <= 1.50) {
			txtAmountParcel = 11.15;
		}
		else if (rate == "Within Peninsular" && weight >= 1.51 && weight <= 2.00) {
			txtAmountParcel = 12.20;
		}
		else if (rate == "Within Peninsular" && weight >= 2.01 && weight <= 2.50) {
			txtAmountParcel = 15.15;
		}
		else if (rate == "Within Peninsular" && weight >= 2.51 && weight <= 3.00) {
			txtAmountParcel = 16.90;
		}
		else if (rate == "Within Peninsular" && weight >= 3.01 && weight <= 3.50) {
			txtAmountParcel = 18.65;
		}
		else if (rate == "Within Peninsular" && weight >= 3.51 && weight <= 4.00) {
			txtAmountParcel = 20.40;
		}
		else if (rate == "Within Peninsular" && weight >= 4.01 && weight <= 4.50) {
			txtAmountParcel = 22.15;
		}
		else if (rate == "Within Peninsular" && weight >= 4.51 && weight <= 5.00) {
			txtAmountParcel = 23.30;
		}
		else if (rate == "Within Peninsular" && weight >= 5.01 && weight <= 5.50) {
			txtAmountParcel = 24.50;
		}
		else if (rate == "Within Peninsular" && weight >= 5.51 && weight <= 6.00) {
			txtAmountParcel = 25.65;
		}
		else if (rate == "Within Peninsular" && weight >= 6.01 && weight <= 6.50) {
			txtAmountParcel = 26.80;

		}
		else if (rate == "Within Peninsular" && weight >= 6.51 && weight <= 7.00) {
			txtAmountParcel = 28.00;
		}
		else if (rate == "Within Peninsular" && weight >= 7.01 && weight <= 7.50) {
			txtAmountParcel = 29.16;
		}
		else if (rate == "Within Peninsular" && weight >= 7.51 && weight <= 8.00) {
			txtAmountParcel = 30.30;
		}
		else if (rate == "Within Peninsular" && weight >= 8.01 && weight <= 8.50) {
			txtAmountParcel = 31.50;
		}
		else if (rate == "Within Peninsular" && weight >= 8.51 && weight <= 9.00) {
			txtAmountParcel = 32.65;
		}
		else if (rate == "Within Peninsular" && weight >= 9.01 && weight <= 9.50) {
			txtAmountParcel = 33.80;
		}
		else if (rate == "Within Peninsular" && weight >= 9.51 && weight <= 10.00) {
			txtAmountParcel = 35.00;
		}
		else if(rate == "Sabah & Sarawak" && weight >= 0.0 && weight <= 0.50) {
			
			txtAmountParcel = 14.85;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 0.51 && weight <= 1.00) {
			txtAmountParcel = 21.20;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 1.01 && weight <= 1.50) {
			txtAmountParcel = 27.55;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 1.51 && weight <= 2.00) {
			txtAmountParcel = 33.90;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 2.01 && weight <= 2.50) {
			txtAmountParcel = 40.30;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 2.51 && weight <= 3.00) {
			txtAmountParcel = 46.65;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 3.01 && weight <= 3.50) {
			txtAmountParcel = 53.00;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 3.51 && weight <= 4.00) {
			txtAmountParcel = 59.35;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 4.01 && weight <= 4.50) {
			txtAmountParcel = 65.70;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 4.51 && weight <= 5.00) {
			txtAmountParcel = 72.10;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 5.01 && weight <= 5.50) {
			txtAmountParcel = 78.45;
		}
		else if (rate == "Sabah & Sarawakr" && weight >= 5.51 && weight <= 6.00) {
			txtAmountParcel = 84.80;
		}
		else if (rate == "Sabah & Sarawakr" && weight >= 6.01 && weight <= 6.50) {
			txtAmountParcel = 91.15;

		}
		else if (rate == "Sabah & Sarawak" && weight >= 6.51 && weight <= 7.00) {
			txtAmountParcel = 97.50;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 7.01 && weight <= 7.50) {
			txtAmountParcel = 103.90;
		}
		else if (rate == "Sabah & Sarawakr" && weight >= 7.51 && weight <= 8.00) {
			txtAmountParcel = 110.25;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 8.01 && weight <= 8.50) {
			txtAmountParcel = 116.60;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 8.51 && weight <= 9.00) {
			txtAmountParcel = 122.95;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 9.01 && weight <= 9.50) {
			txtAmountParcel = 129.30;
		}
		else if (rate == "Sabah & Sarawak" && weight >= 9.51 && weight <= 10.00) {
			txtAmountParcel = 135.70;
		}
		else {
			System.out.println("Please insert the correct weight!");
		}
		return txtAmountParcel;
	}


}
