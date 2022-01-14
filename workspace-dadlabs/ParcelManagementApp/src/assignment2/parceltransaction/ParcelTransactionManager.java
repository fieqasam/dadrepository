package assignment2.parceltransaction;

import java.util.Date;

import assignment2.parcel.Parcel;

public class ParcelTransactionManager {
	
	Parcel parcel = new Parcel();
	
	public ParcelTransaction createPayment (ParcelTransaction parceltransaction)
	{
		int paymentID = parceltransaction.getPaymentTransactionId();
		parceltransaction.setPaymentTransactionId(paymentID);
		
		String date = new Date().toString();
//		String date = parceltransaction.getTransactionDate();
		parceltransaction.setTransactionDate(date);
		
		String amountCharged = parceltransaction.getAmountCharged();
		parceltransaction.setAmountCharged(amountCharged);
		
		String creditcard = parceltransaction.getCreditcard();
		parceltransaction.setCreditcard(creditcard);
		
		int cvv = parceltransaction.getCvv();
		parceltransaction.setCvv(cvv);
		
		String tracking_no = parcel.getParcel_tracking_no();
		parcel.setParcel_tracking_no(tracking_no);
		
		return parceltransaction;
	}

}
