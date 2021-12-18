package assignment2.tcpparcelkiosk;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TcpParcelKiosk extends JFrame {
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TcpParcelKiosk frame = new TcpParcelKiosk();
					frame.setSize(700,600);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TcpParcelKiosk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParcelManagementSystem = new JLabel("PARCEL MANAGEMENT SYSTEM");
		lblParcelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelManagementSystem.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblParcelManagementSystem.setBounds(175, 15, 409, 48);
		contentPane.add(lblParcelManagementSystem);
		
		JLabel lblIconImage = new JLabel("");
		lblIconImage.setIcon(new ImageIcon("C:\\Users\\AthirahShuhaidi\\workspace-dadlabs\\ParcelManagementApp\\res\\parcelImage.png"));
		lblIconImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconImage.setBounds(184, 70, 341, 234);
		contentPane.add(lblIconImage);
		
		Button btnMain = new Button("WEIGHT PARCEL");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageParcel nextPage = new ManageParcel();
				nextPage.setVisible(true);
			}
		});
		
		btnMain.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMain.setBackground(new Color(102, 153, 204));
		btnMain.setBounds(194, 310, 321, 56);
		contentPane.add(btnMain);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\AthirahShuhaidi\\workspace-dadlabs\\ParcelManagementApp\\res\\marbel1.png"));
		lblNewLabel.setBounds(0, 0, 610, 407);
		lblNewLabel.setSize(800,600);
		contentPane.add(lblNewLabel);
	}


}
