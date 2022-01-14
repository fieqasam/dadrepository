package assignment2.transaction;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OrderStatusFrame extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderStatusFrame frame = new OrderStatusFrame();
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
	public OrderStatusFrame() {
		setTitle("Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\AthirahShuhaidi\\\\workspace-dadlabs\\\\ParcelManagementApp\\\\res\\deliveryIcon.png"));
		lblNewLabel.setBounds(0, 11, 647, 342);
		contentPane.add(lblNewLabel);
		
		JLabel lblYourOrderIs = new JLabel("Thank you for using our services!\r\n");
		lblYourOrderIs.setForeground(new Color(51, 0, 255));
		lblYourOrderIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderIs.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblYourOrderIs.setBounds(79, 428, 568, 42);
		contentPane.add(lblYourOrderIs);
		
		JButton btnback = new JButton("Back");
		btnback.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnback.setHorizontalAlignment(SwingConstants.CENTER);
		btnback.setBackground(new Color(102, 153, 204));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnback.setBounds(310, 498, 106, 33);
		contentPane.add(btnback);
		
		JLabel lblYourOrderIs_1 = new JLabel("Your order is confirmed.");
		lblYourOrderIs_1.setForeground(new Color(51, 0, 255));
		lblYourOrderIs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderIs_1.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblYourOrderIs_1.setBounds(112, 364, 506, 42);
		contentPane.add(lblYourOrderIs_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\\\Users\\\\AthirahShuhaidi\\\\workspace-dadlabs\\\\ParcelManagementApp\\\\res\\marbel1.png"));
		lblNewLabel_1.setBounds(0, 0, 675, 539);
		lblNewLabel_1.setSize(800,600);
		contentPane.add(lblNewLabel_1);
	}



}
