package assignment2.transaction;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import assignment2.order.Order;
import assignment2.parcel.Parcel;
import assignment2.parceltransaction.ParcelTransaction;

public class Receipt {
	
	public static String writeReceipt(ParcelTransaction parcelTransaction) {
		DecimalFormat df = new DecimalFormat("0.00");
		// receipt part
		
		Order orders = parcelTransaction.getOrder();
		Parcel parcel = new Parcel();

		String receipt = "\n " + "      PARCEL MANAGEMENT SYSTEM           \n"
						+ "------------------------------------------------\n"
						+ "                  RECEIPT    \n"
						+ "------------------------------------------------\n"
						+ "        TRANSACTION STATUS: SUCCESSFULL         \n"
						+ "------------------------------------------------\n"
						+ "Date: " + parcelTransaction.getTransactionDate().formatted("dd-MM-YYYY") + "\t" + "References No: " + parcelTransaction.getRefNo() + "\n"
						+ "------------------------------------------------\n"
						+ "Payment ID: " + parcelTransaction.getPaymentTransactionId() + "\n" 
						+ "------------------------------------------------\n"
						+ "Total RM : "+ parcelTransaction.getAmountCharged() +"\n"
						+ "------------------------------------------------\n"
						+ "------------------------------------------------\n"
						+ "                    THANK YOU         \n";
		return receipt;
	}


}
