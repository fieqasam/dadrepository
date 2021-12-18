package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageParcel extends JFrame {

	private JPanel contentPane;
	private JTextField txtWeight;
	private JTextField txtParcelContent;
	private JTextField txtSenderPhone;
	private JTextField txtSenderName;
	private JTextField txtReceiverName;
	private JTextField txtReceiverPhone;
	private JTextField txtAmountParcel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageParcel frame = new manageParcel();
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
	public manageParcel() {
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Penisular State", "Within Penisular", "Sabah & Sarawak"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(comboBox);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(10, 70, 38, 33);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTo);
		
		JComboBox boxTypeParcel = new JComboBox();
		boxTypeParcel.setBounds(10, 183, 265, 28);
		boxTypeParcel.setModel(new DefaultComboBoxModel(new String[] {"Document", "Non-Document"}));
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
		panel.add(txtWeight);
		
		JLabel lblTypeOfParcel = new JLabel("Type of Parcel");
		lblTypeOfParcel.setBounds(10, 151, 184, 33);
		lblTypeOfParcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTypeOfParcel);
		
		JComboBox boxTo = new JComboBox();
		boxTo.setBounds(47, 70, 215, 28);
		boxTo.setModel(new DefaultComboBoxModel(new String[] {"Penisular State", "Within Penisular", "Sabah & Sarawak"}));
		boxTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		JLabel lblTrackingNumber_2_1_2 = new JLabel("Total Amount:");
		lblTrackingNumber_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_1_2.setBounds(10, 290, 96, 33);
		panel.add(lblTrackingNumber_2_1_2);
		
		txtAmountParcel = new JTextField();
		txtAmountParcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAmountParcel.setColumns(10);
		txtAmountParcel.setBounds(10, 321, 265, 28);
		panel.add(txtAmountParcel);
		
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
		
		JLabel lblParcelType = new JLabel("Parcel Type:");
		lblParcelType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelType.setBounds(10, 126, 142, 33);
		panel_1_2.add(lblParcelType);
		
		JLabel lblParcelWeight = new JLabel("Parcel Weight:");
		lblParcelWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelWeight.setBounds(10, 161, 142, 33);
		panel_1_2.add(lblParcelWeight);
		
		JLabel lblSenderInfo = new JLabel("Receiver Info");
		lblSenderInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSenderInfo.setBounds(10, 414, 181, 33);
		panel_1_2.add(lblSenderInfo);
		
		JLabel lblSenderaddress = new JLabel("SenderAddress:");
		lblSenderaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenderaddress.setBounds(10, 379, 142, 33);
		panel_1_2.add(lblSenderaddress);
		
		JLabel lblTrackingNumber_1 = new JLabel("Sender Name:");
		lblTrackingNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1.setBounds(10, 292, 142, 33);
		panel_1_2.add(lblTrackingNumber_1);
		
		JLabel lblTrackingNumber_2 = new JLabel("Sender Mobile Phone No:");
		lblTrackingNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2.setBounds(10, 336, 181, 33);
		panel_1_2.add(lblTrackingNumber_2);
		
		Button btnProceedPayment = new Button("Proceed Payment");
		btnProceedPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				paymentFrame next = new paymentFrame();
				next.setVisible(true);
			}
			
		});
		btnProceedPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProceedPayment.setBackground(new Color(102, 153, 204));
		btnProceedPayment.setBounds(31, 603, 279, 33);
		panel_1_2.add(btnProceedPayment);
		
		JLabel lblParcelContent_1 = new JLabel("Parcel Content:");
		lblParcelContent_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcelContent_1.setBounds(10, 204, 142, 33);
		panel_1_2.add(lblParcelContent_1);
		
		JLabel lblSenderInfo_1 = new JLabel("Sender Info");
		lblSenderInfo_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSenderInfo_1.setBounds(10, 248, 181, 33);
		panel_1_2.add(lblSenderInfo_1);
		
		JLabel lblTrackingNumber_1_1 = new JLabel("Receiver Name:");
		lblTrackingNumber_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1_1.setBounds(10, 448, 142, 33);
		panel_1_2.add(lblTrackingNumber_1_1);
		
		JLabel lblTrackingNumber_2_2 = new JLabel("Receiver Mobile Phone No:");
		lblTrackingNumber_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_2.setBounds(10, 492, 181, 33);
		panel_1_2.add(lblTrackingNumber_2_2);
		
		JLabel lblTrackingNumber_2_1_1 = new JLabel("Receiver Address:");
		lblTrackingNumber_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2_1_1.setBounds(10, 536, 181, 33);
		panel_1_2.add(lblTrackingNumber_2_1_1);
		
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
	}
}
