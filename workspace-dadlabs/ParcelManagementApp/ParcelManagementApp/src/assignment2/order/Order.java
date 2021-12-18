package assignment2.order;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
	
	public int idorder;
	public String order_no;
	public String order_date;
	public String receiver_name;
	public String receiver_address;
	public String receiver_tel_no;
	public String order_status;
	public String invoice_no;
	public String order_state_to;
	
	public Order() {
	}
	
	public Order(String order_no, String order_date, String receiver_name, String receiver_address,
			String receiver_tel_no, String order_status, String invoice_no, String order_state_to ) {
	    
		this.order_no = order_no;
	    this.order_date = order_date;
	    this.receiver_name = receiver_name;
	    this.receiver_address = receiver_address;
	    this.receiver_tel_no = receiver_tel_no;
	    this.order_status = order_status;
	    this.invoice_no = invoice_no;
	    this.order_state_to = order_state_to;
	  }
	
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_tel_no() {
		return receiver_tel_no;
	}
	public void setReceiver_tel_no(String receiver_tel_no) {
		this.receiver_tel_no = receiver_tel_no;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getOrder_state_to() {
		return order_state_to;
	}
	public void setOrder_state_to(String order_state_to) {
		this.order_state_to = order_state_to;
	}
	

}
