package assignment2.transaction;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import assignment2.customer.Customer;
import assignment2.order.Order;
import assignment2.parcel.Parcel;
import assignment2.parcel.ParcelIdGenerator;
import assignment2.parcel.ParcelManager;
import assignment2.parceltransaction.ParcelTransaction;

public class ClientPaymentApp extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtCard;
	private JTextField txtPaymentMode;
	private JTextField txtAmount;
	private JLabel exception;
	JLabel lblStatus1,lblDatetime1,lblReferenceNumber1,lblPaymentAmount1,lblBank1,
	lblTrackingNumber1,lblTrackingNumber_11,lblTrackingNumber_21;
	private boolean statusTrans;
	String tracking;
	
	String databaseName = "parceldb";
	String username = "root";
	String password = "mysql1234";
    Connection conn;
    java.sql.Statement stmt;
    ResultSet st;
    String connectionPath = "jdbc:mysql://localhost:3306/" + databaseName + "?" +
            "user=" + username + "&password=" + password;

	
	ParcelTransaction parcelTransaction = new ParcelTransaction();
	Parcel parcel = new Parcel();
	Customer customer = new Customer();
	Order order = new Order();
	ParcelManager pm = new ParcelManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientPaymentApp frame = new ClientPaymentApp();
					frame.setSize(800,600);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientPaymentApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelManagementSystem = new JLabel("PARCEL MANAGEMENT SYSTEM");
		lblParcelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelManagementSystem.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblParcelManagementSystem.setBounds(152, 11, 409, 48);
		contentPane.add(lblParcelManagementSystem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Payment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(34, 70, 299, 478);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPaymentMode_1 = new JLabel("Payment Mode");
		lblPaymentMode_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentMode_1.setBounds(10, 240, 142, 33);
		panel.add(lblPaymentMode_1);
		
		JLabel lblcvv = new JLabel("CVV");
		lblcvv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcvv.setBounds(10, 173, 142, 33);
		panel.add(lblcvv);
		
		JTextField txtcvv = new JTextField();
		txtcvv.setColumns(10);
		txtcvv.setBounds(10, 205, 109, 33);
		txtcvv.setText("");
		panel.add(txtcvv);
		
		JLabel lblNewLabel = new JLabel("Card Credit Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 30, 142, 33);
		panel.add(lblNewLabel);
		
		txtCard = new JTextField();
		txtCard.setBounds(10, 64, 279, 33);
		panel.add(txtCard);
		txtCard.setColumns(10);
		
		JLabel lblexpireddate = new JLabel("Expiration Date");
		lblexpireddate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblexpireddate.setBounds(10, 100, 142, 33);
		panel.add(lblexpireddate);
		
		JComboBox boxMonth = new JComboBox();
		boxMonth.setBounds(10, 134, 145, 33);
		boxMonth.setModel(new DefaultComboBoxModel(new String[] {"Please select...","January", "February",
				"March", "April","May", "June", "July", "August", "September", "October", "November", "December"}));
		boxMonth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(boxMonth);
		
		JComboBox boxYear = new JComboBox();
		boxYear.setBounds(170, 134, 110, 33);
		boxYear.setModel(new DefaultComboBoxModel(new String[] {"Please select...","2020", "2021",
				"2022", "2023","2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
		boxYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(boxYear);
		
		JLabel lblPaymentMode = new JLabel("Total Amount");
		lblPaymentMode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentMode.setBounds(10, 310, 142, 33);
		panel.add(lblPaymentMode);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(10, 340, 279, 33);
		txtAmount.setText("9.0");
//		txtAmount.setText(parcel.getParcel_delivery_rate());
		txtAmount.setEditable(false);
		panel.add(txtAmount);
		
		exception = new JLabel("");
    	exception.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	exception.setBounds(10, 370, 172, 33);
    	exception.setForeground(Color.RED);
    	exception.setVisible(false);
		panel.add(exception);
		
		txtPaymentMode = new JTextField();
		txtPaymentMode.setColumns(10);
		txtPaymentMode.setBounds(10, 274, 279, 33);
		txtPaymentMode.setText("Credit Card Payment");
		txtPaymentMode.setEditable(false);
		panel.add(txtPaymentMode);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Payment Info", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(361, 70, 338, 478);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPaymentDetailsAs = new JLabel("Payment Details as referenced from server");
		lblPaymentDetailsAs.setForeground(new Color(51, 0, 255));
		lblPaymentDetailsAs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPaymentDetailsAs.setBounds(10, 23, 301, 33);
		panel_1.add(lblPaymentDetailsAs);
		
		JLabel lblTransactionStatus = new JLabel("Transaction Status");
		lblTransactionStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTransactionStatus.setBounds(10, 55, 181, 33);
		panel_1.add(lblTransactionStatus);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(10, 89, 142, 33);
		panel_1.add(lblStatus);
		
		JLabel lblStatus1 = new JLabel("Status:");
		lblStatus1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus1.setBounds(110, 89, 142, 33);
		
		
		JLabel lblDatetime = new JLabel("Date/Time:");
		lblDatetime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatetime.setBounds(10, 126, 142, 33);
		panel_1.add(lblDatetime);
		
		JLabel lblDatetime1 = new JLabel("Date/Time:");
		lblDatetime1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatetime1.setBounds(110, 126, 142, 33);
		
		
		JLabel lblReferenceNumber = new JLabel("Reference Number:");
		lblReferenceNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReferenceNumber.setBounds(10, 164, 142, 33);
		panel_1.add(lblReferenceNumber);
		
		JLabel lblReferenceNumber1 = new JLabel("Reference Number:");
		lblReferenceNumber1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReferenceNumber1.setBounds(150, 164, 142, 33);
		
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		lblPaymentAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaymentAmount.setBounds(10, 196, 142, 33);
		panel_1.add(lblPaymentAmount);
		
		JLabel lblPaymentAmount1 = new JLabel("Payment Amount:");
		lblPaymentAmount1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaymentAmount1.setBounds(150, 196, 142, 33);
		
		
		JLabel lblBank = new JLabel("Bank:");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBank.setBounds(10, 232, 142, 33);
		panel_1.add(lblBank);
		
		JLabel lblBank1 = new JLabel("Bank:");
		lblBank1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBank1.setBounds(100, 232, 142, 33);
		
		
		JLabel lblDeliveryInfo = new JLabel("Delivery Info");
		lblDeliveryInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDeliveryInfo.setBounds(10, 271, 181, 33);
		panel_1.add(lblDeliveryInfo);
		
		
		JLabel lblTrackingNumber_1 = new JLabel("Tracking Number:");
		lblTrackingNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1.setBounds(10, 315, 142, 33);
		panel_1.add(lblTrackingNumber_1);
		
		JLabel lblTrackingNumber_11 = new JLabel("Tracking Number:");
		lblTrackingNumber_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_11.setBounds(150, 315, 142, 33);
		
		
		Button button = new Button("Pay Now");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(102, 153, 204));
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				try {
					
					String card = txtCard.getText();
					
					System.out.println(card); 
					
					
					if(card.length() == 16)
			        {                                
			            txtCard.setText(card);
			            
			        try
					{    
			        
			        	conn = (Connection)DriverManager.getConnection(connectionPath);
                        stmt = conn.createStatement();

						// Connect to the server at localhost, port 4884
		            	Socket c = new Socket(InetAddress.getLocalHost(), 4884);
		            	
		            	// Update the status of the connection
		            	updateConnectionStatus(c.isConnected());
		            	
		            	parcelTransaction.setAmountCharged(txtAmount.getText());
						parcelTransaction.setCreditcard(card);
						parcelTransaction.setCvv(Integer.parseInt(txtcvv.getText()));
		            	
		            	int i=1;  
						
						String payment_id = "100" + i++;;
		
		            	parcelTransaction.setPaymentTransactionId(Integer.parseInt(payment_id));
		            	tracking = parcelTransaction.getTransactionDate() + "00" + payment_id;
//		            	
						// Create stream to write data on the network
						ObjectOutputStream dout = new ObjectOutputStream(c.getOutputStream());
						dout.writeObject(parcelTransaction);
//		            	
//						System.out.println("Sending RM "+ parcelTransaction.getAmountCharged() + ""
//		    					+ " to server-side application");
						System.out.println("Sending "+ parcelTransaction.getCreditcard() + ""
	        					+ " to server-side application");
						 
						//Receive processed object
		            	ObjectInputStream ois = new ObjectInputStream(c.getInputStream());
		            	ParcelTransaction processedParcelTransaction = (ParcelTransaction) ois.readObject();
		
		            	//Manipulate processed object
		    			System.out.println("Total Amount RM: "+ processedParcelTransaction.getAmountCharged());
//		    			System.out.println(Integer.parseInt(payment_id));	            	
//		    			
//		            	System.out.println(tracking);
//						
		            	LocalDate mycurrdate = LocalDate.now();
		            	String current = mycurrdate.toString();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				        String localDate = formatter.format(mycurrdate);
				        
				        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMYYYY");
				        String localDate2 = formatter2.format(mycurrdate);
//		            	
				        String ref = localDate2 + "00" + parcelTransaction.getPaymentTransactionId();
				        
				        parcelTransaction.setRefNo(ref);
				        
		            	parcelTransaction = new ParcelTransaction(Integer.parseInt(payment_id), current, txtAmount.getText(), true,
		        				card,Integer.parseInt(txtcvv.getText()), ref);
//		
//						//send credit number to order server
//						dout.writeObject(parcelTransaction);
//						
						String bank = "Bank Islam Berhad";
						String tracking = "MY" + localDate2 + "AP";
						
						 String querypayment = "INSERT INTO `parceldb`.`payment` "
						 		+ "(`idpayment`, `payment_bank`, `payment_card_no`, "
						 		+ "`payment_card_cvv`, `payment_total_amount`) "
						 		+ "VALUES ('" + Integer.parseInt(payment_id) + "', '" + bank + "', "
						 		+ "'" + card + "', '" + Integer.parseInt(txtcvv.getText()) + "', '" + Float.parseFloat(txtAmount.getText()) + "');";
						 
						 stmt.executeUpdate(querypayment);
						 
						 String updateParcel = "UPDATE `parceldb`.`parcel` SET `parcel_tracking_no` = '" + tracking + "' WHERE (`idpayment` = '1');";
							 
							 stmt.executeUpdate(updateParcel);
						 
						 parcel.setParcel_tracking_no("MY" + localDate2 + "AP");
						 
						System.out.println("Client = Successful");
						JOptionPane.showMessageDialog(null, "Transaction successful and receipt will be printed");
						
						lblStatus1.setText("Successful");			        
						lblDatetime1.setText(localDate);
						lblReferenceNumber1.setText(ref);
						lblBank1.setText("Bank Islam Berhad");
//						lblTrackingNumber1.setText(order.getReceiver_name());
						lblTrackingNumber_11.setText("MY" + localDate2 + "AP");
//						lblTrackingNumber_21.setText(customer.getSender_name());
						lblPaymentAmount1.setText("RM " + parcelTransaction.getAmountCharged());
						panel_1.add(lblStatus1);
						panel_1.add(lblDatetime1);
						panel_1.add(lblReferenceNumber1);
						panel_1.add(lblBank1);
//						panel_1.add(lblTrackingNumber1);
						panel_1.add(lblTrackingNumber_11);
//						panel_1.add(lblTrackingNumber_21);
						panel_1.add(lblPaymentAmount1);
//						dispose();
//		
//								
						OrderStatusFrame status = new OrderStatusFrame();
						status.setVisible(true);
//								
//						dout.flush();
						c.close();
//						System.exit(0);
						
				}catch (Exception ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                }
			        
			        }
			        else
			        {
			        	exception.setVisible(true);
			        	exception.setText("E1 Credit Card Fail Authentication");
			        	txtCard.setText("");
			        }
				} catch (Exception ex) {
					
                    System.err.println("SQLException: " + ex.getMessage());
                    
                }
			
			}

		});
		button.setBounds(158, 418, 129, 33);
		panel.add(button);
		
		JButton button2 = new JButton("Cancel");
		button2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button2.setBackground(new Color(237,237,237));
		button2.setBorder(BorderFactory.createLineBorder(new Color(102, 153, 204)));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "E2 Fail Payment.");
			}

		});
		button2.setBounds(10, 418, 129, 33);
		panel.add(button2);
		
//		JLabel lblPaymentMode_1 = new JLabel("Payment Mode");
//		lblPaymentMode_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		lblPaymentMode_1.setBounds(10, 108, 142, 33);
//		panel.add(lblPaymentMode_1);
//		
//		txtAmount = new JTextField();
//		txtAmount.setColumns(10);
//		txtAmount.setBounds(10, 222, 279, 33);
//		txtAmount.setText("Credit Card Payment");
//		txtAmount.setEditable(false);
//		panel.add(txtAmount);
		
		
		
		Button button_1 = new Button("Print Receipt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				//take transaction id and order id as file name 
				String targetSource = parcelTransaction.getRefNo() + ".txt";
				
				Receipt printed = new Receipt();
				String receiptContent = Receipt.writeReceipt(parcelTransaction);
				FileWriter fileWriter = new FileWriter (targetSource);
				fileWriter.write(receiptContent);
				fileWriter.flush();
				fileWriter.close();	
				
				} catch (Exception ex) {
					
                    System.err.println("SQLException: " + ex.getMessage());
                    
                }
				
			}
		});
		
		
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(102, 153, 204));
		button_1.setBounds(32, 418, 279, 33);
		panel_1.add(button_1);
	}


	public String getCardCreadit() throws InterruptedException {
		waitForInput(); //bila tekan confirm baru jalan
		return txtCard.getText();
	}

	public void setCardCreadit() {
		txtCard.getText();
		//this.CardCreadit = cardCreadit;
	}

	//wait for input
    public void waitForInput() throws InterruptedException {
        synchronized(this) {
            wait();
        }
    }

    //release after button clicked
    public void release() throws InterruptedException {
        synchronized(this) {
            notifyAll();
        }
    }
    public ParcelTransaction getOrderTransaction() {
		return this.parcelTransaction;
	}

	public void setStatus(boolean status) {
		statusTrans = status;
	}
	
public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
			System.out.println(status);
	}


}
