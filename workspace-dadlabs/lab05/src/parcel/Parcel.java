package parcel;

import java.io.Serializable;

/**
 * This class represent of amount of parcel using parcel pricing table.
 * 
 * @author Nurul Afiqah
 *
 */
public class Parcel implements Serializable {

	// used to indicate compatibility between different versions of serialized classes
	private static final long serialVersionUID = 1L;
	
	private double weight;
	private double price;
	
	public Parcel() {
		this.weight = 0.0;
		this.price = 0.0;
		
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
