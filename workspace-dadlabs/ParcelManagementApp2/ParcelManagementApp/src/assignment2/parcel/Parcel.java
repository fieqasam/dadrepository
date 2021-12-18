package assignment2.parcel;

import java.io.Serializable;

public class Parcel implements Serializable {
	
	public int idparcel;
	public double parcel_weight;
	public String parcel_tracking_no;
	public String parcelType;
	public int idorder;
	public String parcel_delivery_rate;
	public String idpayment;
	public String parcel_content;
	
	public Parcel() {
	}
	
	public Parcel(double parcel_weight, String parcel_tracking_no, String parcelType, int idorder,
			String parcel_delivery_rate, String idpayment, String parcel_content ) {
	    this.parcel_weight = parcel_weight;
	    this.parcel_tracking_no = parcel_tracking_no;
	    this.parcelType = parcelType;
	    this.idorder = idorder;
	    this.parcel_delivery_rate = parcel_delivery_rate;
	    this.idpayment = idpayment;
	    this.parcel_content = parcel_content;
	  }
	
	public int getIdparcel() {
		return idparcel;
	}
	public void setIdparcel(int idparcel) {
		this.idparcel = idparcel;
	}
	public double getParcel_weight() {
		return parcel_weight;
	}
	public void setParcel_weight(double parcel_weight) {
		this.parcel_weight = parcel_weight;
	}
	public String getParcel_tracking_no() {
		return parcel_tracking_no;
	}
	public void setParcel_tracking_no(String parcel_tracking_no) {
		this.parcel_tracking_no = parcel_tracking_no;
	}
	public String getParcelType() {
		return parcelType;
	}
	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public String getParcel_delivery_rate() {
		return parcel_delivery_rate;
	}
	public void setParcel_delivery_rate(String parcel_delivery_rate) {
		this.parcel_delivery_rate = parcel_delivery_rate;
	}
	public String getIdpayment() {
		return idpayment;
	}
	public void setIdpayment(String idpayment) {
		this.idpayment = idpayment;
	}
	public String getParcel_content() {
		return parcel_content;
	}
	public void setParcel_content(String parcel_content) {
		this.parcel_content = parcel_content;
	}

}
