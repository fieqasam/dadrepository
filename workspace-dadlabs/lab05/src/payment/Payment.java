package payment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import staff.Staff;

public class Payment extends Staff implements Serializable{


	// used to indicate compatibility between different versions of serialized classes
	private static final long serialVersionUID = 1L;
	
	private int paymentId;
	private Date transactionDate;
	private Staff recordedBy;
	
	public Payment() {
			
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
		
	}
	public void setTransactionDate (Date date)
	{
		this.transactionDate = date;
	}
	
	public Date getTransactionDate()
	{
		return transactionDate;
	}
	
	
	public String getRecordedBy() {
		return super.name;
	}
	
	public void setRecordedBy(String recordedBy) {
		
		super.name = name;
	}
	

}
