import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class reviews extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reviews frame = new reviews();
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
	public reviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Enter your Park");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(68, 87, 117, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stars");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(68, 146, 97, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(253, 145, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Your Review");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(68, 203, 97, 17);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(255, 203, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--ENTER PARK--", "Thunder Zone", "Wonderland", "Suncity Amusement Park", "TR Enjoy World", "Dream Land", "Hardy's World"}));
		comboBox.setBounds(253, 89, 129, 20);
		contentPane.add(comboBox);
		
		JButton btnSendReview = new JButton("SEND REVIEW");
		btnSendReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Login log=new Login();
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded Successfully");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
					System.out.println("Connection Build");
					System.out.println("Statement Created");
					String query="insert into reviews (user_name,Park,Review,Stars) values(?,?,?,?)";
	                PreparedStatement pst = myConn.prepareStatement(query);
	                pst.setString(1,log.user);
	                String value= comboBox.getSelectedItem().toString(); //to get item from combo box
                    pst.setString(2,value);
	                pst.setString(3,textField_1.getText());
                    
                    pst.setString(4,textField.getText());
	                pst.execute();
                    JOptionPane.showMessageDialog(null,"Thanks for your review");
                    
                    pst.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSendReview.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSendReview.setBounds(164, 293, 179, 36);
		contentPane.add(btnSendReview);
		
		JLabel lblNewLabel_3 = new JLabel("REVIEW TAB");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(10, 22, 537, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 547, 402);
		Image img=new ImageIcon(this.getClass().getResource("/review1.jpg")).getImage();
		contentPane.setLayout(null);
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
		
		
		
		
		
		

	}
}
