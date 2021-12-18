package parcel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelManagementSystem = new JLabel("PARCEL MANAGEMENT SYSTEM");
		lblParcelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelManagementSystem.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblParcelManagementSystem.setBounds(129, 11, 409, 48);
		contentPane.add(lblParcelManagementSystem);
		
		JLabel lblIconImage = new JLabel("");
		lblIconImage.setIcon(new ImageIcon("C:\\Users\\User10\\Documents\\GitHub\\dadrepository\\workspace-dadlabs\\ParcelManagement\\res\\parcelImage.png"));
		lblIconImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconImage.setBounds(184, 70, 341, 234);
		contentPane.add(lblIconImage);
		
		Button btnMain = new Button("Drop Parcel");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manageParcel nextPage = new manageParcel();
				nextPage.setVisible(true);
			}
		});
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMain.setBackground(new Color(102, 153, 204));
		btnMain.setBounds(194, 310, 321, 56);
		contentPane.add(btnMain);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User10\\Documents\\GitHub\\dadrepository\\workspace-dadlabs\\ParcelManagement\\res\\marbel1.png"));
		lblNewLabel.setBounds(0, 0, 610, 407);
		lblNewLabel.setSize(800,600);
		contentPane.add(lblNewLabel);
	}

}
