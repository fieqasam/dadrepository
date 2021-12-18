package payment;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import parcel.Parcel;
import staff.Staff;

public class paymentManager {
	
	Staff staff= new Staff();
	
	Parcel parcel = new Parcel();

	public Payment managePayment (Payment payment) {
		
		int paymentId = payment.getPaymentId();
		payment.setPaymentId(paymentId);
		
		double weight = parcel.getWeight();
		parcel.setWeight(weight);
		
		Timestamp transacDate = payment.getTransactionDate();
		payment.setTransactionDate(transacDate);
		
		String name = staff.getRecordedBy();
		payment.setRecordedBy(name);

		return payment;
	}
	
}

