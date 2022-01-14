package payment;

import java.security.Timestamp;
import java.util.Date;

import parcel.Parcel;
import staff.Staff;

public class paymentManager {
	
	Staff staff= new Staff();

	public Payment managePayment (Payment payment) {
		
		int paymentId = payment.getPaymentId();
		payment.setPaymentId(paymentId);
		
		Date date = payment.getTransactionDate();
		payment.setTransactionDate(date);
		
		String name = staff.getRecordedBy();
		payment.setRecordedBy(name);

		return payment;
	}
	
}

