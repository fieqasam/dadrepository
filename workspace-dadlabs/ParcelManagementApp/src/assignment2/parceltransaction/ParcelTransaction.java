package assignment2.parceltransaction;

import java.io.Serializable;

import assignment2.order.Order;

public class ParcelTransaction implements Serializable {
	
	// Declaration of attributes
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public int paymentTransactionId;
		public String transactionDate;
		public String amountCharged;
		public String refNo;
		public boolean transactionStatus;
		public String creditcard;
		public int cvv;
		
		public ParcelTransaction() {
		}
		
		public ParcelTransaction( int paymentTransactionId, String transactionDate, String amountCharged, boolean transactionStatus,
				String creditcard, int cvv, String refNo ) {
		    this.paymentTransactionId = paymentTransactionId;
		    this.transactionDate = transactionDate;
		    this.amountCharged = amountCharged;
		    this.transactionStatus = transactionStatus;
		    this.creditcard = creditcard;
		    this.cvv = cvv;
		    this.refNo = refNo;
		  }
		
		/* Implementation of 1:1 */
		public Order order;

		/**
		 * @return the order
		 */
		public Order getOrder() {
			return order;
		}

		/**
		 * @param order the order to set
		 */
		public void setOrder(Order order) {
			this.order = order;
		}

		public int getPaymentTransactionId() {
			return paymentTransactionId;
		}

		public void setPaymentTransactionId(int paymentTransactionId) {
			this.paymentTransactionId = paymentTransactionId;
		}

		public String getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(String transactionDate) {
			this.transactionDate = transactionDate;
		}

		public String getAmountCharged() {
			return amountCharged;
		}

		public void setAmountCharged(String amountCharged) {
			this.amountCharged = amountCharged;
		}

		public boolean isTransactionStatus() {
			return transactionStatus;
		}

		public void setTransactionStatus(boolean transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		public String getCreditcard() {
			return creditcard;
		}

		public void setCreditcard(String creditcard) {
			this.creditcard = creditcard;
		}

		public int getCvv() {
			return cvv;
		}

		public void setCvv(int cvv) {
			this.cvv = cvv;
		}

		public String getRefNo() {
			return refNo;
		}

		public void setRefNo(String refNo) {
			this.refNo = refNo;
		}
		
		

}

