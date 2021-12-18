import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class firstTrial {

	private JFrame frame;
	private JLabel lblMessage ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstTrial window = new firstTrial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public firstTrial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Show Message");
		btnNewButton.setBounds(167, 198, 174, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,  "Hi, welcome to drop parcel!");
				lblMessage.setText("Hi, welcome to drop parcel!");
	
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(btnNewButton);
		
		lblMessage = new JLabel("Message");
		lblMessage.setBounds(128, 77, 277, 49);
		frame.getContentPane().add(lblMessage);
	}
}
