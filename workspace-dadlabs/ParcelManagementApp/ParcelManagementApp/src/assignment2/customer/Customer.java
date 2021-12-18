package assignment2.customer;

import java.io.Serializable;

public class Customer implements Serializable {
	
	public int idcustomer;
	public String sender_name;
	public String sender_address;
	public String sender_tel_no;
	public String sender_state_from;
	
	public Customer() {
	}
	
	public Customer(int idcustomer, String sender_name, String sender_address, String sender_tel_no, String sender_state_from ) {
	    this.idcustomer = idcustomer;
	    this.sender_name = sender_name;
	    this.sender_address = sender_address;
	    this.sender_tel_no = sender_tel_no;
	    this.sender_state_from = sender_state_from;
	  }
	
	public int getIdcustomer() {
		return idcustomer;
	}
	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getSender_address() {
		return sender_address;
	}
	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}
	public String getSender_tel_no() {
		return sender_tel_no;
	}
	public void setSender_tel_no(String sender_tel_no) {
		this.sender_tel_no = sender_tel_no;
	}
	public String getSender_state_from() {
		return sender_state_from;
	}
	public void setSender_state_from(String sender_state_from) {
		this.sender_state_from = sender_state_from;
	}

	

}
