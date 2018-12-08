import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class cancel_requests extends JFrame {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Cancel your booking");
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancel_requests frame = new cancel_requests();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void table()
	{
		try {
			String id="";
			int i=0;
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
			System.out.println("Connection Build");
			System.out.println("Statement Created");
			String query="select a.id,a.park_booked,a.no_of_ad,a.no_of_child,a.Date_of_book,a.total from admin a,users b where a.user_name=b.Domain_name";
		     PreparedStatement pst = myConn.prepareStatement(query);
			 ResultSet rs = pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public cancel_requests() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 646, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterYourBooking = new JLabel("Enter your Booking ID");
		lblEnterYourBooking.setForeground(new Color(0, 0, 139));
		lblEnterYourBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourBooking.setBounds(39, 48, 376, 26);
		lblEnterYourBooking.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(lblEnterYourBooking);
		
		textField = new JTextField();
		textField.setBounds(468, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 405, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton.setBounds(440, 116, 157, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String id="";
					int i=0;
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded Successfully");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
					System.out.println("Connection Build");
					System.out.println("Statement Created");
					Login log= new Login();
					String query="select * from users where Domain_name= '"+log.user+"'";
                    PreparedStatement pst = myConn.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    String _user="";
                    while(rs.next())
                    {
                    	_user=rs.getString("Domain_name");
                    	id=rs.getString("id");
                    	i++;
                    }
					
					 if(_user.equals(log.user)) //check
				 {
						 String query1="delete from admin where id= '"+textField.getText()+"'	 ";
						 PreparedStatement pst1 = myConn.prepareStatement(query1);
						 pst1.executeUpdate();
						 JOptionPane.showMessageDialog(null,"You cancelled your booking");
						 pst1.close();
				 }
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		table();
		
		JLabel last = new JLabel("");
		last.setBounds(0, 0, 630, 316);
		Image img=new ImageIcon(this.getClass().getResource("/vintage_style_photography_cool_wallpapers.jpg")).getImage();
		last.setIcon(new ImageIcon(img));
		contentPane.add(last);
		
		
		
	}
}
