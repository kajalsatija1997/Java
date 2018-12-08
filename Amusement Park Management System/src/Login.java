import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;

public class Login extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JPasswordField txtPassword;
	public static JTextField txtUsername;
	private JFrame frmLoginSystem;
	public static String user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN SYSTEM");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
		//lblLogin.setText("Text Color: White");
		lblLogin.setBounds(0, 26, 684, 22);
	    contentPane.add(lblLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(241, 144, 210, 20);
		contentPane.add(txtPassword);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(134, 85, 72, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(134, 146, 72, 14);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(241, 83, 210, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

	    JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded Successfully");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
					System.out.println("Connection Build");
					System.out.println("Statement Created");
                    String query="select * from users where Domain_name=? and password=?";
                    PreparedStatement pst = myConn.prepareStatement(query);
                    pst.setString(1,txtUsername.getText());
                    pst.setString(2,txtPassword.getText() );
                    ResultSet rs = pst.executeQuery();
                    String _user=" ";
                    String _pass=" ";
                    int i=0;
                    while(rs.next())
                    {
                    	_user=rs.getString("Domain_name");
                    	_pass=rs.getString("password");
                    	i++;
                    }
                    if(_user.equals(txtUsername.getText())&&_pass.equals(txtPassword.getText()))
                    {
                    	JOptionPane.showMessageDialog(null,"Login Successful");
                    	user=txtUsername.getText();
                    	if(user.equals("ADMIN"))
                    	{
                    		admin ad=new admin();
                    		ad.setVisible(true);
                    		return;
                    	}
                    	user_dashboard db=new user_dashboard();
                    	db.show_label.setText(txtUsername.getText());
                     	db.setVisible(true);
                    		}
                    else if (_user.equals("") && _pass.equals("")) {
                    	JOptionPane.showMessageDialog(null, "Please fill out all the fields", "MESSAGE", 0);}
                    else
                    {
                    	JOptionPane.showMessageDialog(null,"Invalid username/password","Message" , 0);
                    	txtUsername.setText(null);
        				txtPassword.setText(null);
                    }
	} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(40, 199, 89, 25);
		contentPane.add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login system",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(348, 199, 89, 25);
		contentPane.add(btnExit);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(193, 199, 89, 25);
		contentPane.add(btnReset);

		JSeparator separator = new JSeparator();
		separator.setBounds(41, 186, 621, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 59, 622, 2);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login_small.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(10, 71, 89, 117);
		contentPane.add(label);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setForeground(Color.LIGHT_GRAY);
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOr.setBounds(474, 119, 33, 22);
		contentPane.add(lblOr);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registeration reg=new registeration();
				reg.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(535, 119, 110, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(85, 205, 46, 14);
		Image img2=new ImageIcon(this.getClass().getResource("/oksmall.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/login_bg.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 684, 261);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
