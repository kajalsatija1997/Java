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
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class registeration extends JFrame {
	private JPanel contentPane;
	private JTextField txtfirst;
	private JTextField textmobile;
	private JTextField txtlast;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtdomain;
    public String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registeration frame = new registeration();
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
	public registeration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 10, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 11, 323, 42);
		contentPane.add(panel);
		
		JLabel lblParkRegistration = new JLabel("USER REGISTRATION");
		lblParkRegistration.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblParkRegistration);
		
		JLabel pass = new JLabel("PASSWORD");
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(37, 193, 79, 25);
		contentPane.add(pass);
		
		JLabel first = new JLabel("FIRST NAME");
		first.setForeground(Color.WHITE);
		first.setFont(new Font("Tahoma", Font.BOLD, 12));
		first.setBounds(37, 83, 85, 27);
		contentPane.add(first);
		
		JLabel password = new JLabel("LAST NAME");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setBounds(37, 121, 79, 25);
		contentPane.add(password);
		
		JLabel domain = new JLabel("DOMAIN NAME");
		domain.setHorizontalAlignment(SwingConstants.CENTER);
		domain.setForeground(Color.WHITE);
		domain.setFont(new Font("Tahoma", Font.BOLD, 12));
		domain.setBounds(10, 157, 142, 25);
		contentPane.add(domain);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setForeground(Color.WHITE);
		lblgender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblgender.setBounds(37, 270, 61, 25);
		contentPane.add(lblgender);
		
		txtfirst = new JTextField();
		txtfirst.setBounds(182, 87, 171, 20);
		contentPane.add(txtfirst);
		txtfirst.setColumns(10);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"I AM...", "Male", "Female"}));
		gender.setBounds(182, 273, 168, 20);
		contentPane.add(gender);
		
		txtlast = new JTextField();
		txtlast.setBounds(182, 124, 171, 22);
		contentPane.add(txtlast);
		txtlast.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 196, 168, 22);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(182, 232, 171, 16);
		contentPane.add(passwordField_1);
	
		
		JRadioButton institution = new JRadioButton("Institution");
		institution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user="Institution";
			}
		});
		institution.setBounds(301, 354, 109, 23);
		contentPane.add(institution);
		
		txtdomain = new JTextField();
		txtdomain.setBounds(182, 160, 171, 20);
		contentPane.add(txtdomain);
		txtdomain.setColumns(10);
		
		
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
					
					String query1="select * from users where Domain_name= '"+txtdomain.getText()+"' and password= '"+passwordField.getText()+"'";
                    PreparedStatement pst1 = myConn.prepareStatement(query1);
                    ResultSet rs = pst1.executeQuery();
                    String _user="";
                    String _pass="";
                    int i=0;
                    while(rs.next())
                    {
                    	_user=rs.getString("Domain_name");
                    	_pass=rs.getString("Password");
                    	i++;
                    }
                    if(!_user.equals(txtdomain.getText())&&!_pass.equals(passwordField.getText()))
            		{
                    String query="insert into users (First_name,Last_name,Domain_name,Password,Reenter_password,gender,mobil_number,user_type) values(?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = myConn.prepareStatement(query);
                    pst.setString(1,txtfirst.getText());
                    pst.setString(2,txtlast.getText());
                    pst.setString(3,txtdomain.getText());
                    pst.setString(4,passwordField.getText());
                    pst.setString(5,passwordField_1.getText());
                    String value= gender.getSelectedItem().toString(); //to get item from combo box
                    pst.setString(6,value);
                    pst.setString(7,textmobile.getText());
                    pst.setString(8,user);
                    
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null,"Welcoome to the Amusement Hub");
                    
                    pst.close();
                    pst1.close();
				}
                    else
                    {
                    	JOptionPane.showMessageDialog(null,"Already Registered Please Login","Message" , 0);
                    	Login log=new Login();
                    	log.setVisible(true);	
                    }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(97, 428, 220, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblreenter = new JLabel("RE-ENTER PASSWORD");
		lblreenter.setForeground(Color.WHITE);
		lblreenter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblreenter.setBounds(10, 234, 142, 14);
		contentPane.add(lblreenter);
		
		JLabel lblMobileNumber = new JLabel("MOBILE NUMBER");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setBounds(10, 315, 120, 14);
		contentPane.add(lblMobileNumber);
		
		textmobile = new JTextField();
		textmobile.setBounds(182, 315, 171, 16);
		contentPane.add(textmobile);
		textmobile.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USER TYPE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 354, 109, 20);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton individual = new JRadioButton("Individual");
		individual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user="Individual";
			}
		});
		individual.setBounds(182, 354, 109, 23);
		contentPane.add(individual);
		
		
		JLabel last = new JLabel("");
		last.setBounds(0, 0, 434, 661);
		Image img=new ImageIcon(this.getClass().getResource("/register_bg.jpg")).getImage();
		last.setIcon(new ImageIcon(img));
		contentPane.add(last);
		
		
		
	
	}
}
