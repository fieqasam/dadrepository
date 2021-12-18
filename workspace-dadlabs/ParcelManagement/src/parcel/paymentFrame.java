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
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class paymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCard;
	private JTextField txtPaymentMode;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentFrame frame = new paymentFrame();
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
	public paymentFrame() {
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
		panel.setBounds(34, 70, 299, 355);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Card Credit Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 30, 142, 33);
		panel.add(lblNewLabel);
		
		txtCard = new JTextField();
		txtCard.setBounds(10, 64, 279, 33);
		panel.add(txtCard);
		txtCard.setColumns(10);
		
		JLabel lblPaymentMode = new JLabel("Total Amount");
		lblPaymentMode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentMode.setBounds(10, 191, 142, 33);
		panel.add(lblPaymentMode);
		
		txtPaymentMode = new JTextField();
		txtPaymentMode.setColumns(10);
		txtPaymentMode.setBounds(10, 140, 279, 33);
		panel.add(txtPaymentMode);
		
		Button button = new Button("Pay Now");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(102, 153, 204));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderStatus status = new orderStatus();
				status.setVisible(true);
			}
		});
		button.setBounds(10, 285, 279, 33);
		panel.add(button);
		
		JLabel lblPaymentMode_1 = new JLabel("Payment Mode");
		lblPaymentMode_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPaymentMode_1.setBounds(10, 108, 142, 33);
		panel.add(lblPaymentMode_1);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(10, 222, 279, 33);
		panel.add(txtAmount);
		
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
		
		JLabel lblDatetime = new JLabel("Date/Time:");
		lblDatetime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDatetime.setBounds(10, 126, 142, 33);
		panel_1.add(lblDatetime);
		
		JLabel lblReferenceNumber = new JLabel("Reference Number:");
		lblReferenceNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReferenceNumber.setBounds(10, 164, 142, 33);
		panel_1.add(lblReferenceNumber);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount:");
		lblPaymentAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaymentAmount.setBounds(10, 196, 142, 33);
		panel_1.add(lblPaymentAmount);
		
		JLabel lblBank = new JLabel("Bank:");
		lblBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBank.setBounds(10, 232, 142, 33);
		panel_1.add(lblBank);
		
		JLabel lblDeliveryInfo = new JLabel("Delivery Info");
		lblDeliveryInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDeliveryInfo.setBounds(10, 271, 181, 33);
		panel_1.add(lblDeliveryInfo);
		
		JLabel lblTrackingNumber = new JLabel("Receiver Name:");
		lblTrackingNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber.setBounds(10, 379, 142, 33);
		panel_1.add(lblTrackingNumber);
		
		JLabel lblTrackingNumber_1 = new JLabel("Tracking Number:");
		lblTrackingNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_1.setBounds(10, 315, 142, 33);
		panel_1.add(lblTrackingNumber_1);
		
		JLabel lblTrackingNumber_2 = new JLabel("Sender Name:");
		lblTrackingNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrackingNumber_2.setBounds(10, 347, 142, 33);
		panel_1.add(lblTrackingNumber_2);
		
		Button button_1 = new Button("Print Receipt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(102, 153, 204));
		button_1.setBounds(32, 418, 279, 33);
		panel_1.add(button_1);
	}
}
