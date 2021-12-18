package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class orderStatus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderStatus frame = new orderStatus();
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
	public orderStatus() {
		setTitle("Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User10\\Documents\\GitHub\\dadrepository\\workspace-dadlabs\\ParcelManagement\\res\\deliveryIcon.png"));
		lblNewLabel.setBounds(0, 11, 647, 342);
		contentPane.add(lblNewLabel);
		
		JLabel lblYourOrderIs = new JLabel("Thank you for using our services!\r\n");
		lblYourOrderIs.setForeground(new Color(51, 0, 255));
		lblYourOrderIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderIs.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblYourOrderIs.setBounds(79, 428, 568, 42);
		contentPane.add(lblYourOrderIs);
		
		JLabel lblYourOrderIs_1 = new JLabel("Your order is confirmed.");
		lblYourOrderIs_1.setForeground(new Color(51, 0, 255));
		lblYourOrderIs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderIs_1.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblYourOrderIs_1.setBounds(112, 364, 506, 42);
		contentPane.add(lblYourOrderIs_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User10\\Documents\\GitHub\\dadrepository\\workspace-dadlabs\\ParcelManagement\\res\\marbel1.png"));
		lblNewLabel_1.setBounds(0, 0, 675, 539);
		lblNewLabel_1.setSize(800,600);
		contentPane.add(lblNewLabel_1);
	}

}
