package projectoop;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class Training extends JPanel{

	private JFrame frmExpertSkill;
	private final JLabel Banner = new JLabel("");
	private JTextField nameField;
	private JTextField emailField;
	private JTextField participantField;

	public Training() {
		initialize();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Training window = new Training();
					window.frmExpertSkill.setSize(400,550);
					window.frmExpertSkill.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Promotion Algorithm
	
	private Double applyPromotion(int price, int qty, int stateIndex) {	
		Double discount = Double.valueOf(price);
		
		if (qty >= 10 && qty < 50 && stateIndex == 4) {
			discount =  Double.valueOf((price-(price*10)/100)-(qty*5));
		}
		else if (qty >= 50 && stateIndex == 4) {
			discount =  Double.valueOf((price-(price*20)/100)-(qty*5));
		}
		else if (qty >= 10 && qty < 50 && stateIndex != 4) {
			discount =  Double.valueOf((price-(price*10)/100));
		}
		else if (qty >= 50 && stateIndex != 4) {
			discount = Double.valueOf((price-(price*20)/100));
		}
		return discount;
	}
	
	private void initialize() {
		
		//Frame Title
		
		frmExpertSkill = new JFrame();
		frmExpertSkill.setTitle("Expert Skill - Best web development training center");
		frmExpertSkill.setBounds(100, 100, 400, 550);
		frmExpertSkill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpertSkill.getContentPane().setLayout(null);
		
		//Import Banner
		
		Image img = new ImageIcon(this.getClass().getResource("/newexskill.jpg")).getImage();
		Banner.setBounds(0, 0, 386, 90);
		Banner.setIcon(new ImageIcon(img));
		frmExpertSkill.getContentPane().add(Banner);
		Banner.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Banner Label
		
		JLabel bannerLabel = DefaultComponentFactory.getInstance().createLabel("<<< Connecting you to a more sustainable future >>>");
		bannerLabel.setBounds(37, 96, 332, 14);
		frmExpertSkill.getContentPane().add(bannerLabel);
        
		//Name Label
		
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(5, 147, 49, 14);
        frmExpertSkill.getContentPane().add(nameLabel);
        
        //Email Label
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(5, 167, 49, 14);
        frmExpertSkill.getContentPane().add(emailLabel);
        
        //Participant Label
        
        JLabel particpantLabel = new JLabel("Number of participants:");
        particpantLabel.setBounds(5, 187, 140, 14);
        frmExpertSkill.getContentPane().add(particpantLabel);
        Border border_1 = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        //Area Label
        
        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(5, 250, 140, 14);
        frmExpertSkill.getContentPane().add(areaLabel);
        
        //Result Display
        
        JTextArea resultPane = new JTextArea();
        resultPane.setEditable(false);
        resultPane.setBorder(border_1);
        resultPane.setBounds(3, 377, 381, 139);
        frmExpertSkill.getContentPane().add(resultPane);
        
        //Course Label
        
        JLabel courseLabel = new JLabel("Choose Course:");
        courseLabel.setBounds(197, 250, 140, 14);
        frmExpertSkill.getContentPane().add(courseLabel);
        
        //State Drop Down
        
        JComboBox areaDropdown = new JComboBox();
        areaDropdown.setModel(new DefaultComboBoxModel(new String[] {"Choose area..", "Johor", "Selangor", "Kedah", "Perak", "Melaka"}));
        areaDropdown.setBounds(0, 275, 185, 54);
        frmExpertSkill.getContentPane().add(areaDropdown);
	    
        //Course Scroll and List
        
	    JScrollPane courseListpane = new JScrollPane();
	    courseListpane.setBounds(197, 275, 189, 54);
	    frmExpertSkill.getContentPane().add(courseListpane);
	    
	    JList list = new JList();
	    list.setModel(new AbstractListModel() {
	    	String[] values = new String[] {"Basic PHP (RM180)", "Laravel (RM300)", "BootStrap (RM220)", "Java Script (RM200)"};
	    	public int getSize() {
	    		return values.length;
	    	}
	    	public Object getElementAt(int index) {
	    		return values[index];
	    	}
	    });
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    courseListpane.setViewportView(list);
	    
	    //Name Field
	    
	    nameField = new JTextField();
	    nameField.setBounds(173, 147, 203, 20);
	    nameField.setBorder(border_1);
	    frmExpertSkill.getContentPane().add(nameField);
	    nameField.setColumns(10);
	    
	    //Email Field
	    
	    emailField = new JTextField();
	    emailField.setColumns(10);
	    emailField.setBounds(173, 170, 203, 20);
	    emailField.setBorder(border_1);
	    frmExpertSkill.getContentPane().add(emailField);
	    
	    //Text Field
	    
	    participantField = new JTextField();
	    participantField.setColumns(10);
	    participantField.setBorder(border_1);
	    participantField.setBounds(173, 194, 203, 20);
	    frmExpertSkill.getContentPane().add(participantField);
	    
	    //Register Button
	    
	    JButton registerButton = new JButton("Register");
        registerButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String totalFee =  ""; 
        		String err = "Form is not complete.\nPlease enter all information";      		
        		DecimalFormat df = new DecimalFormat("0.00");
        		
        		//Error Handler
        		if (nameField.getText().equals("") || emailField.getText().equals("") || areaDropdown.getSelectedIndex() == 0) {
        			resultPane.setText(err);
        		}
        		else {
        			try {
        			  if (list.getSelectedValue().toString().equals("Basic PHP (RM180)")) {
        				totalFee = df.format(applyPromotion(180 * Integer.parseInt(participantField.getText()), Integer.parseInt(participantField.getText()),areaDropdown.getSelectedIndex()));
        			}
        			  else if (list.getSelectedValue().toString().equals("Laravel (RM300)")) {
        				totalFee = df.format(applyPromotion(300 * Integer.parseInt(participantField.getText()), Integer.parseInt(participantField.getText()),areaDropdown.getSelectedIndex()));
        			}
        			  else if (list.getSelectedValue().toString().equals("BootStrap (RM220)")) {
        				totalFee = df.format(applyPromotion(220 * Integer.parseInt(participantField.getText()), Integer.parseInt(participantField.getText()),areaDropdown.getSelectedIndex()));
        			}
        			  else if (list.getSelectedValue().toString().equals("Java Script (RM200)")) {
        				totalFee = df.format(applyPromotion(200 * Integer.parseInt(participantField.getText()), Integer.parseInt(participantField.getText()),areaDropdown.getSelectedIndex()));
        			}
        			resultPane.setText("Name : " + nameField.getText() + "\nEmail : " + emailField.getText() + "\nParticipants : " + participantField.getText() + " person" +"\nArea : " + areaDropdown.getSelectedItem() + "\nCourse : " + list.getSelectedValue() + "\nTotal fee : RM" + totalFee);
        		}
        		catch (Exception E) {
        			resultPane.setText(err);
        		    }
        		}
        	}
        });
        registerButton.setBounds(96, 347, 89, 23);
        frmExpertSkill.getContentPane().add(registerButton);
        
        //Cancel Button
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		resultPane.setText(null);
        		nameField.setText(null);
        		emailField.setText(null);
        		participantField.setText(null);
        		list.setSelectedValue(null, true);
        		areaDropdown.setSelectedIndex(0);
        	}
        });
        cancelButton.setBounds(188, 347, 89, 23);
        frmExpertSkill.getContentPane().add(cancelButton);
	}
}
