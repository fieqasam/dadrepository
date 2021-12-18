package assignment2.order;

public class orderMnager {

	public Order manageOrder (Order order) {
		
		int idorder = order.getIdorder();
		order.setIdorder(idorder);
		
		String order_no = order.getOrder_no();
		order.setOrder_no(order_no);
		
		String order_date = order.getOrder_date();
		order.setOrder_date(order_date);
		
		String receiver_name = order.getReceiver_name();
		order.setReceiver_name(receiver_name);
		
		String receiver_address = order.getReceiver_address();
		order.setReceiver_address(receiver_address);
		
		String receiver_tel_no = order.getReceiver_tel_no();
		order.setReceiver_tel_no(receiver_tel_no);
		
		String order_status = order.getOrder_status();
		order.setOrder_status(order_status);
		
		String invoice_no = order.getInvoice_no();
		order.setInvoice_no(invoice_no);
		
		return order;
	}
}
