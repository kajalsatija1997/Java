import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class park_register extends JFrame {
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JPasswordField txtreenterpassword;
	private JTextField txtcity;
	private JTextField txtparkname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					park_register frame = new park_register();
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
	public park_register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 10, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 11, 323, 42);
		contentPane.add(panel);
		
		JLabel lblParkRegistration = new JLabel("PARK REGISTRATION");
		lblParkRegistration.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblParkRegistration);
		
		JLabel lblNewLabel = new JLabel("PARK NAME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 209, 79, 25);
		contentPane.add(lblNewLabel);
		
		JLabel user = new JLabel("USERNAME");
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Tahoma", Font.BOLD, 12));
		user.setBounds(37, 83, 79, 27);
		contentPane.add(user);
		
		JLabel password = new JLabel("PASSWORD");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setBounds(37, 121, 79, 25);
		contentPane.add(password);
		
		JLabel ReenterPassword = new JLabel("RE-ENTER PASSWORD");
		ReenterPassword.setForeground(Color.WHITE);
		ReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		ReenterPassword.setBounds(10, 157, 142, 25);
		contentPane.add(ReenterPassword);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(62, 302, 41, 25);
		contentPane.add(lblCity);
		
		txtusername = new JTextField();
		txtusername.setBounds(182, 87, 171, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(182, 124, 171, 20);
		contentPane.add(txtpassword);
		
		txtreenterpassword = new JPasswordField();
		txtreenterpassword.setBounds(182, 160, 171, 20);
		contentPane.add(txtreenterpassword);
		
		txtcity = new JTextField();
		txtcity.setBounds(182, 305, 171, 20);
		contentPane.add(txtcity);
		txtcity.setColumns(10);
		
		JComboBox state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"STATE", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana ", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"}));
		state.setBounds(182, 251, 168, 20);
		contentPane.add(state);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded Successfully");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
					System.out.println("Connection Build");
					System.out.println("Statement Created");
					
					String query1="select * from users where Domain_name=? and Password=? and Reenter_password=? ";
                    
                    PreparedStatement pst1 = myConn.prepareStatement(query1);
                    pst1.setString(1,txtusername.getText());
                    pst1.setString(2,txtpassword.getText() );
                    pst1.setString(3,txtreenterpassword.getText() );
                    ResultSet rs = pst1.executeQuery();
                    String _user="";
                    String _pass="";
                    String _repass="";
                    while(rs.next())
                    {
                    	_user=rs.getString("Domain_name");
                    	_pass=rs.getString("Password");
                    	_repass=rs.getString("Reenter_password");
                    }
                    if(_user.equals(txtusername.getText())&&_pass.equals(txtpassword.getText())&&_repass.equals(txtreenterpassword.getText()))
            		{
                    String query="insert into parks (Park_name,State,City) values(?,?,?)";
                    PreparedStatement pst = myConn.prepareStatement(query);
                    pst.setString(1,txtparkname.getText());
                    String value= state.getSelectedItem().toString(); //to get item from combo box
                    pst.setString(2,value);
                    pst.setString(3,txtcity.getText());
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null,"Data Saved");
                    
                    pst.close();
                    pst1.close();
				}
                    else
                    {
                    	JOptionPane.showMessageDialog(null,"Invalid username/password","Message" , 0);
                    	txtusername.setText(null);
        				txtpassword.setText(null);
        				txtreenterpassword.setText(null);
        				txtparkname.setText(null);
        				txtcity.setText(null);
                    }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(98, 372, 220, 42);
		contentPane.add(btnNewButton);
		
		txtparkname = new JTextField();
		txtparkname.setBounds(182, 212, 171, 20);
		contentPane.add(txtparkname);
		txtparkname.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 193, 414, 5);
		contentPane.add(separator);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblState.setBounds(51, 253, 57, 14);
		contentPane.add(lblState);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 661);
		Image img=new ImageIcon(this.getClass().getResource("/register_bg.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
	}

}
