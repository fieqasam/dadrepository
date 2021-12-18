package assignment2.tcpparcelkiosk;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import assignment2.customer.Customer;
import assignment2.order.Order;
import assignment2.parcel.Parcel;
import assignment2.parcel.ParcelManager;

public class ManageParcel extends JFrame {
	
	String databaseName = "parceldb";
	String username = "root";
	String password = "Bitp3123@";
    Connection conn;
    java.sql.Statement stmt;
    ResultSet st;
    String connectionPath = "jdbc:mysql://localhost:3306/" + databaseName + "?" +
            "user=" + username + "&password=" + password;
	
	private JPanel contentPane;
	private JTextField txtWeight;
	private JTextField txtParcelContent;
	private JTextField txtSenderPhone;
	private JTextField txtSenderName;
	private JTextField txtReceiverName;
	private JTextField txtReceiverPhone;
	private JTextField txtAmountParcel;
	Vector records;
	String str;
	JLabel lblParcelId2;
	
	Customer customer = new Customer();
	Order order = new Order();
	Parcel parcel = new Parcel();
	ParcelManager pm = new ParcelManager();
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnknownHostException, 
	IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageParcel frame = new ManageParcel();
					frame.setSize(700,600);
					frame.setLocationRelativeTo(null);
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
	public ManageParcel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 816);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelManagementSystem = new JLabel("PARCEL MANAGEMENT SYSTEM");
		lblParcelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelManagementSystem.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblParcelManagementSystem.setBounds(276, 11, 409, 48);
		contentPane.add(lblParcelManagementSystem);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Parcel Detail", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 61, 285, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(10, 26, 142, 33);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblFrom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(60, 29, 215, 28);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Please select...","Peninsular State", "Within Peninsular", "Sabah & Sarawak"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(comboBox);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(10, 70, 38, 33);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTo);
		
		JComboBox boxTypeParcel = new JComboBox();
		boxTypeParcel.setBounds(10, 183, 265, 28);
		boxTypeParcel.setModel(new DefaultComboBoxModel(new String[] {"Please select...","Document", "Non-Document"}));
		boxTypeParcel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(boxTypeParcel);
		
		JLabel lblWeightkg = new JLabel("Weight(kg)");
		lblWeightkg.setBounds(10, 114, 81, 33);
		lblWeightkg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblWeightkg);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(91, 117, 184, 28);
		txtWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWeight.setColumns(10);
		txtWeight.setEditable(false); 
		
		Random rn = new Random();
		double answer = rn.nextDouble();
		df.setRoundingMode(RoundingMode.UP);
		txtWeight.setText(df.format(answer));
		panel.add(txtWeight);
		
		JLabel lblTypeOfParcel = new JLabel("Type of Parcel");
		lblTypeOfParcel.setBounds(10, 151, 184, 33);
		lblTypeOfParcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTypeOfParcel);
		
		JComboBox boxTo = new JComboBox();
		boxTo.setBounds(47, 70, 215, 28);
		boxTo.setModel(new DefaultComboBoxModel(new String[] {"Please Select...","Peninsular State", "Within Peninsular", "Sabah & Sarawak"}));
		boxTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		boxTo.addItemListener(new ItemListener() {
			@Override
		    public void itemStateChanged(ItemEvent e) {
		      if(e.getStateChange() == ItemEvent.SELECTED) { // Check if the value got selected, ignore if it has been deselected
		    	 String state = boxTo.getSelectedItem().toString();
		    	 calculateRate(state);
		    	 panel.add(txtAmountParcel);
		      }
		    }
		});
		panel.add(boxTo);
		
		JLabel lblParcelContent = new JLabel("Parcel Content");
		lblParcelContent.setBounds(10, 220, 184, 33);
		lblParcelContent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblParcelContent);
		
		txtParcelContent = new JTextField();
		txtParcelContent.setBounds(10, 250, 265, 28);
		txtParcelContent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtParcelContent.setColumns(10);
		panel.add(txtParcelContent);
		
		JLabel lblTrackingNumber_2_1_2 = new JLabel("Total Amount (RM) :");
		lblTrackingNumber_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_1_2.setBounds(10, 290, 96, 33);
		panel.add(lblTrackingNumber_2_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Sender Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(305, 61, 296, 284);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSenderName = new JLabel("Sender Name");
		lblSenderName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenderName.setBounds(10, 25, 142, 33);
		panel_1.add(lblSenderName);
		
		txtSenderPhone = new JTextField();
		txtSenderPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenderPhone.setColumns(10);
		txtSenderPhone.setBounds(10, 125, 276, 28);
		panel_1.add(txtSenderPhone);
		
		JLabel lblSenderAddress = new JLabel("Sender Address\r\n");
		lblSenderAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenderAddress.setBounds(10, 164, 203, 33);
		panel_1.add(lblSenderAddress);
		
		txtSenderName = new JTextField();
		txtSenderName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenderName.setColumns(10);
		txtSenderName.setBounds(10, 57, 276, 28);
		panel_1.add(txtSenderName);
		
		JLabel lblSenderAddress_1 = new JLabel("Sender Mobile Phone Number\r\n");
		lblSenderAddress_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenderAddress_1.setBounds(10, 96, 203, 33);
		panel_1.add(lblSenderAddress_1);
		
		JTextArea txtSenderAddress = new JTextArea();
		txtSenderAddress.setBounds(10, 196, 276, 59);
		panel_1.add(txtSenderAddress);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(305, 352, 296, 276);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Receiver Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblReceiverName = new JLabel("Receiver Mobile Phone Number");
		lblReceiverName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReceiverName.setBounds(10, 94, 240, 33);
		panel_1_1.add(lblReceiverName);
		
		txtReceiverName = new JTextField();
		txtReceiverName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReceiverName.setColumns(10);
		txtReceiverName.setBounds(10, 55, 276, 28);
		panel_1_1.add(txtReceiverName);
		
		JLabel lblReceiverAddress = new JLabel("Receiver Address");
		lblReceiverAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReceiverAddress.setBounds(10, 163, 142, 33);
		panel_1_1.add(lblReceiverAddress);
		
		JLabel lblReceiverName_1 = new JLabel("Receiver Name");
		lblReceiverName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReceiverName_1.setBounds(10, 25, 142, 33);
		panel_1_1.add(lblReceiverName_1);
		
		txtReceiverPhone = new JTextField();
		txtReceiverPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReceiverPhone.setColumns(10);
		txtReceiverPhone.setBounds(10, 124, 276, 28);
		panel_1_1.add(txtReceiverPhone);
		
		JTextArea txtReceiverAddr = new JTextArea();
		txtReceiverAddr.setBounds(10, 192, 276, 59);
		panel_1_1.add(txtReceiverAddr);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Delivery Parcel Info", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(611, 61, 338, 674);
		contentPane.add(panel_1_2);
		
		JLabel lblDeliveryDetailsAs = new JLabel("Delivery Details as referenced from server");
		lblDeliveryDetailsAs.setForeground(new Color(51, 0, 255));
		lblDeliveryDetailsAs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeliveryDetailsAs.setBounds(10, 23, 301, 33);
		panel_1_2.add(lblDeliveryDetailsAs);
		
		JLabel lblParcelInfo = new JLabel("Parcel Info");
		lblParcelInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblParcelInfo.setBounds(10, 55, 181, 33);
		panel_1_2.add(lblParcelInfo);
		
		JLabel lblParcelId = new JLabel("Parcel ID:");
		lblParcelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelId.setBounds(10, 89, 142, 33);
		panel_1_2.add(lblParcelId);
		
		lblParcelId2 = new JLabel();
		lblParcelId2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelId2.setBounds(110, 89, 142, 33);
		panel_1_2.add(lblParcelId2);
		
		JLabel lblParcelType = new JLabel("Parcel Type:");
		lblParcelType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelType.setBounds(10, 126, 142, 33);
		panel_1_2.add(lblParcelType);
		
		JLabel lblParcelType2 = new JLabel("Parcel Type:");
		lblParcelType2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelType2.setBounds(105, 126, 142, 33);
		
		
		JLabel lblParcelWeight = new JLabel("Parcel Weight:");
		lblParcelWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelWeight.setBounds(10, 161, 142, 33);
		panel_1_2.add(lblParcelWeight);
		
		JLabel lblParcelWeight2 = new JLabel("Parcel Weight:");
		lblParcelWeight2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelWeight2.setBounds(110, 161, 142, 33);
		
		
		JLabel lblSenderInfo = new JLabel("Receiver Info");
		lblSenderInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSenderInfo.setBounds(10, 414, 181, 33);
		panel_1_2.add(lblSenderInfo);
		
		JLabel lblSenderaddress = new JLabel("SenderAddress:");
		lblSenderaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenderaddress.setBounds(10, 379, 142, 33);
		panel_1_2.add(lblSenderaddress);
		
		JLabel lblSenderaddress2 = new JLabel("SenderAddress:");
		lblSenderaddress2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenderaddress2.setBounds(118, 379, 142, 33);
		
		
		JLabel lblTrackingNumber_1 = new JLabel("Sender Name:");
		lblTrackingNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1.setBounds(10, 292, 142, 33);
		panel_1_2.add(lblTrackingNumber_1);
		
		JLabel lblTrackingNumber_12 = new JLabel("Sender Name:");
		lblTrackingNumber_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_12.setBounds(110, 292, 142, 33);
		
		
		JLabel lblTrackingNumber_2 = new JLabel("Sender Mobile Phone No:");
		lblTrackingNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2.setBounds(10, 336, 181, 33);
		panel_1_2.add(lblTrackingNumber_2);
		
		JLabel lblTrackingNumber_22 = new JLabel("Sender Mobile Phone No:");
		lblTrackingNumber_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_22.setBounds(180, 336, 181, 33);
		
		
		Button btnProceedPayment = new Button("Proceed Payment");
		btnProceedPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				paymentFrame next = new paymentFrame();
//				next.setVisible(true);
			}
			
		});
		
		btnProceedPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProceedPayment.setBackground(new Color(102, 153, 204));
		btnProceedPayment.setBounds(31, 603, 279, 33);
		btnProceedPayment.setVisible(true);
		
		
		JLabel lblParcelContent_1 = new JLabel("Parcel Content:");
		lblParcelContent_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelContent_1.setBounds(10, 204, 142, 33);
		panel_1_2.add(lblParcelContent_1);
		
		JLabel lblParcelContent_12 = new JLabel("Parcel Content:");
		lblParcelContent_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelContent_12.setBounds(115, 204, 142, 33);
		
		
		JLabel lblSenderInfo_1 = new JLabel("Sender Info");
		lblSenderInfo_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSenderInfo_1.setBounds(10, 248, 181, 33);
		panel_1_2.add(lblSenderInfo_1);
		
		JLabel lblTrackingNumber_1_1 = new JLabel("Receiver Name:");
		lblTrackingNumber_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1_1.setBounds(10, 448, 142, 33);
		panel_1_2.add(lblTrackingNumber_1_1);
		
		JLabel lblTrackingNumber_1_12 = new JLabel("Receiver Name:");
		lblTrackingNumber_1_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1_12.setBounds(115, 448, 142, 33);
		
		
		JLabel lblTrackingNumber_2_2 = new JLabel("Receiver Mobile Phone No:");
		lblTrackingNumber_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_2.setBounds(10, 492, 181, 33);
		panel_1_2.add(lblTrackingNumber_2_2);
		
		JLabel lblTrackingNumber_2_22 = new JLabel("Receiver Mobile Phone No:");
		lblTrackingNumber_2_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_22.setBounds(190, 492, 181, 33);
		
		
		JLabel lblTrackingNumber_2_1_1 = new JLabel("Receiver Address:");
		lblTrackingNumber_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_1_1.setBounds(10, 536, 181, 33);
		panel_1_2.add(lblTrackingNumber_2_1_1);
		
		JLabel lblTrackingNumber_2_1_12 = new JLabel("Receiver Address:");
		lblTrackingNumber_2_1_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_1_12.setBounds(130, 536, 181, 33);
		
		
		Button btnExit = new Button("Exit");
		btnExit.setBounds(67, 651, 127, 39);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(new Color(102, 153, 204));
		
		Button btnClear = new Button("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBackground(new Color(102, 153, 204));
		btnClear.setBounds(212, 651, 127, 39);
		contentPane.add(btnClear);
		
		Button btnSave = new Button("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBackground(new Color(102, 153, 204));
		btnSave.setBounds(355, 651, 127, 39);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem().equals(0)) {
                    JOptionPane.showMessageDialog(null, "Please fill in Parcel Details properly");
                } else if (boxTypeParcel.getSelectedItem().equals(0)) {
                    JOptionPane.showMessageDialog(null, "Please fill in Parcel Details properly");
                } else if (boxTo.getSelectedItem().equals(0)) {
                    JOptionPane.showMessageDialog(null, "Please fill in Parcel Details properly");
                } else if (txtParcelContent.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Parcel Details properly");
                } else if (txtSenderPhone.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Sender Details properly");
                } else if (txtSenderName.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Sender Details properly");
                } else if (txtSenderAddress.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Sender Details properly");
                } else if (txtReceiverName.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Receiver Details properly");
                } else if (txtReceiverPhone.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Receiver Details properly");
                } else if (txtReceiverAddr.getText().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in Receiver Details properly");
                
                } else {
                	
                	//Create new object
                	Parcel parcel = new Parcel();
                	double weightParcel  = Double.parseDouble(txtWeight.getText());
                	parcel.setParcel_weight(weightParcel);

                        try {
                        	
//                        	System.out.println(comboBox.getSelectedItem());
//                        	System.out.println(boxTo.getSelectedItem());
//                        	System.out.println(boxTypeParcel.getSelectedItem());
//                        	System.out.println(txtWeight.getText());
//                        	System.out.println(txtParcelContent.getText());
//                        	System.out.println(txtSenderPhone.getText());
//                        	System.out.println(txtSenderName.getText());
//                        	System.out.println(txtSenderAddress.getText());
//                        	System.out.println(txtReceiverName.getText());
//                        	System.out.println(txtReceiverPhone.getText());
//                        	System.out.println(txtReceiverAddr.getText());
//                        	System.out.println(txtAmountParcel.getText());
                        	
                            conn = (Connection)DriverManager.getConnection(connectionPath);
                            stmt = conn.createStatement();
                            
                         // Connect to the server at localhost, port 4228
                        	Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
                        	
                        	// Update the status of the connection
                        	updateConnectionStatus(socket.isConnected());
                        	
                        	//Send object to be processed by the server-side application
                        	ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
                        	oos.writeObject(parcel);
                        	
                        	System.out.println("Sending "+parcel.getParcel_weight() + " kg"
                					+ " to server-side application");
                			
                        	//Receive processed object
                        	ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        	Parcel processedParcel = (Parcel) ois.readObject();
                        	
                        	//Manipulate processed object
                			System.out.println("Weight of the parcel(in kg): "+ processedParcel.getParcel_weight());
                        	
                        	// Create input stream - filter and chain
//                        	BufferedReader bufferedReader = new BufferedReader(
//                        			new InputStreamReader(socket.getInputStream()));
//                        	
//                        	
//                        	// Read from the network and display the current date
//                        	String parcel_id = bufferedReader.readLine();
//                        	updateServerParcel(parcel_id); 
                        	
                            customer.setSender_name(txtSenderName.getText());
                            customer.setSender_address(txtSenderAddress.getText());
                            customer.setSender_tel_no(txtSenderPhone.getText());
                            customer.setSender_state_from(comboBox.getSelectedItem().toString());
                            

							int i=1;  
									
							String customer_id = "100" + i++;;
//							System.out.println(customer_id);
							
                            customer.setIdcustomer(Integer.parseInt(customer_id));
                            
                            customer = new Customer(Integer.parseInt(customer_id), txtSenderName.getText(), txtSenderAddress.getText(),
                            		txtSenderPhone.getText(),comboBox.getSelectedItem().toString());
                            
//                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                            ObjectOutputStream oos = new ObjectOutputStream(baos);
//                            oos.writeObject(customer);
//                            
//                            byte[] customerAsBytes = baos.toByteArray();
                            
//                            String Query = "INSERT INTO parceldb.customer (`sender_name`, `sender_address`, "
//                            		+ "`sender_tel_no`, `sender_state_from`, `customer_id`) VALUES(?,?,?,?,?)";
                            
                            String Query = "INSERT INTO `parceldb`.`customer` "
                            		+ "(`sender_name`, `sender_address`, "
                            		+ "`sender_tel_no`,`sender_state_from`,`customer_id`) VALUES ('" + txtSenderName.getText() + "',' "
                            		+ txtSenderAddress.getText() + "',' " + txtSenderPhone.getText() + "','" + comboBox.getSelectedItem() + "','" + customer_id + "');\r\n"
                            		+ "";
                            
//                            PreparedStatement pstmt = conn
//                                .prepareStatement(Query);
//                            ByteArrayInputStream bais = new ByteArrayInputStream(customerAsBytes);
//                            pstmt.setBinaryStream(1, bais, customerAsBytes.length);
                            stmt.executeUpdate(Query);
                            
                            
                            String sql = "select count(*) from parceldb.order";
                            //Executing the query
                            ResultSet rs = stmt.executeQuery(sql);
                            //Retrieving the result
                            rs.next();
                            int count_order = rs.getInt(1);
                            order.setOrder_no(Integer.toString(count_order));
                            
                            LocalDate mycurrdate = LocalDate.now();
                            order.setOrder_date(mycurrdate.toString());
//                            System.out.println(order.getOrder_date());
                            
                            String sql2 = "select count(*) from parceldb.invoice";
                            //Executing the query
                            ResultSet rs2 = stmt.executeQuery(sql2);
                            //Retrieving the result
                            rs2.next();
                            int count_invoice = rs2.getInt(1);
                            order.setInvoice_no(Integer.toString(count_invoice));
                            
                            order.setOrder_date("2021-11-30");
                            order.setReceiver_name(txtReceiverName.getText());
                            order.setReceiver_address(txtReceiverAddr.getText());
                            order.setReceiver_tel_no(txtReceiverPhone.getText());
                            order.setOrder_status("y");
                            order.setOrder_state_to(boxTo.getSelectedItem().toString());
                            
                            order = new Order(Integer.toString(count_order),"2021-11-30", txtReceiverName.getText(), txtReceiverAddr.getText(),
                            		txtReceiverPhone.getText(), "y", Integer.toString(count_invoice), boxTo.getSelectedItem().toString() );
                            
//                            oos.writeObject(order);
//                            
//                            byte[] orderAsBytes = baos.toByteArray();
                            
                            String Query2 = "INSERT INTO `parceldb`.`order` "
                            		+ "(`order_no`, `order_date`, `order_receiver_name`, "
                            		+ "`order_receiver_address`, `order_receiver_tel_no`, "
                            		+ "`invoice_no`, `order_status`, `order_state_to`,`customer_id`) VALUES ('"+ order.getOrder_no() + "', "
                            		+ "'2021-11-29',' " + txtReceiverName.getText() + "',' "
                            		+ txtReceiverAddr.getText() + "','" + txtReceiverPhone.getText() + "', '" + order.getInvoice_no() + "', 'y','" + boxTo.getSelectedItem() + "','" + customer_id + "');\r\n"
                            		+ ""
                            		+ "";
                            
//                            PreparedStatement pstmt2 = conn
//                            .prepareStatement(Query2);
//	                        ByteArrayInputStream bais2 = new ByteArrayInputStream(orderAsBytes);
//	                        pstmt2.setBinaryStream(1, bais2, orderAsBytes.length);
	                        stmt.executeUpdate(Query2);
                            
//                            int idpayment = 1;
//                            int payment_no = idpayment + 1;
//                            order.setInvoice_no(Integer.toString(payment_no));
                            
                            parcel.setParcel_weight(Double.parseDouble(txtWeight.getText()));
                            parcel.setParcelType(boxTypeParcel.getSelectedItem().toString());
                            parcel.setParcel_delivery_rate(txtAmountParcel.getText());
                            
                            double weight = Double.parseDouble(txtWeight.getText());
                            
                            parcel = new Parcel(weight,"", boxTypeParcel.getSelectedItem().toString(),count_order,
                            		txtAmountParcel.getText(), "", txtParcelContent.getText() );
                            
//                            oos.writeObject(parcel);
//                            
//                            byte[] parcelAsBytes = baos.toByteArray();
//                            
                            String Query3 = " INSERT INTO `parceldb`.`parcel` (`parcel_weight`, `parcelType`,"
                            		+ " `idorder`, `parcel_delivery_rate`, `idpayment`,`parcel_content`) VALUES ('" + txtWeight.getText() + "', '"
                            		+ boxTypeParcel.getSelectedItem() + "', '" + order.getOrder_no() + "','" + txtAmountParcel.getText()+ "', '1','"+ txtParcelContent.getText() + "');";
//                          
                            
//                            PreparedStatement pstmt3 = conn
//                                    .prepareStatement(Query3);
//        	                        ByteArrayInputStream bais3 = new ByteArrayInputStream(parcelAsBytes);
//        	                        pstmt3.setBinaryStream(1, bais3, parcelAsBytes.length);
                            stmt.executeUpdate(Query3);
        	                        
//        	                pstmt.close();
//        	                pstmt2.close();
//        	                pstmt3.close();
        	                
        	                // Close everything
//                        	bufferedReader.close();
                        	
                            //close all stream
                            ois.close();
                            oos.close();
                            socket.close();
        	                
                            JOptionPane.showMessageDialog(null, "Parcel Information has been recorded");
                            
                            lblParcelType2.setText(boxTypeParcel.getSelectedItem().toString());
                            lblParcelWeight2.setText(txtWeight.getText() + "  kg");
                            lblSenderaddress2.setText(txtSenderAddress.getText());
                            lblTrackingNumber_12.setText(txtSenderName.getText());
                            lblTrackingNumber_22.setText(txtSenderPhone.getText());
                            lblParcelContent_12.setText(txtParcelContent.getText());
                            lblTrackingNumber_1_12.setText(txtReceiverName.getText());
                            lblTrackingNumber_2_22.setText(txtReceiverPhone.getText());
                            lblTrackingNumber_2_1_12.setText(txtReceiverAddr.getText());
//                            lblParcelId2.setText(parcel_id);
                            panel_1_2.add(btnProceedPayment);
                            panel_1_2.add(lblParcelType2);
                            panel_1_2.add(lblParcelWeight2);
                            panel_1_2.add(lblSenderaddress2);
                            panel_1_2.add(lblTrackingNumber_12);
                            panel_1_2.add(lblTrackingNumber_22);
                            panel_1_2.add(lblParcelContent_12);
                            panel_1_2.add(lblTrackingNumber_1_12);
                            panel_1_2.add(lblTrackingNumber_2_22);
                            panel_1_2.add(lblTrackingNumber_2_1_12);
                            
                            socket.close();
                            
                        } catch (Exception ex) {
                            System.err.println("SQLException: " + ex.getMessage());
                        }
                        try {
                            if (stmt != null) {
                                stmt.close();
                                conn.close();
                            }
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                            ex.printStackTrace();
                        }

                        
			}
		}
	});


}
	public void calculateRate(String state) {
		
		Random rn = new Random();
		double answer = rn.nextDouble();
		
		txtAmountParcel = new JTextField();
		txtAmountParcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAmountParcel.setColumns(10);
		txtAmountParcel.setBounds(10, 321, 265, 28);	
		Double txtAmountParcelDouble  = pm.courierCharge(answer,state);
		String amount = Double.toString(txtAmountParcelDouble);
		txtAmountParcel.setText("RM  " + amount);
		txtAmountParcel.setEditable(false); 
		
	}
	
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
			System.out.println(status);
	}
	
public void updateServerParcel (String parcel_id) {
		
		this.lblParcelId2.setText(parcel_id);
		System.out.println(parcel_id);
		
	}

}
