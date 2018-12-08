import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class book_tickets extends JFrame {

	private JPanel contentPane;
	private JTextField noad;
	private JTextField nochil;
	private JButton btnBookNow;
	private JTextField textField;
	public JLabel park;
	public JLabel cost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book_tickets frame = new book_tickets();
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
	public book_tickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-2,0,1500,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("No. of adults");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(357, 250, 114, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No. of children");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(357, 321, 125, 22);
		contentPane.add(lblNewLabel_1);
		
		
		noad = new JTextField();
		noad.setBounds(566, 253, 114, 22);
		contentPane.add(noad);
	    noad.setColumns(10);
		
		nochil = new JTextField();
		nochil.setBounds(566, 323, 114, 22);
		contentPane.add(nochil);
		nochil.setColumns(10);
		
		JLabel lblParkName = new JLabel("Park Name");
		lblParkName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblParkName.setForeground(Color.WHITE);
		lblParkName.setBounds(357, 155, 101, 22);
		contentPane.add(lblParkName);
		
		textField = new JTextField();
		textField.setBounds(1056, 231, 86, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(912, 231, 109, 33);
		contentPane.add(lblTotal);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(566, 392, 114, 20);
		contentPane.add(dateChooser);
		
		JLabel lblBookDate = new JLabel("Book Date");
		lblBookDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBookDate.setForeground(new Color(255, 255, 255));
		lblBookDate.setBounds(357, 392, 125, 14);
		contentPane.add(lblBookDate);
		
		JLabel lblBookYourTickets = new JLabel("BOOK YOUR TICKETS HERE");
		lblBookYourTickets.setForeground(new Color(250, 235, 215));
		lblBookYourTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookYourTickets.setFont(new Font("Tahoma", Font.BOLD, 63));
		lblBookYourTickets.setBounds(5, 43, 1318, 101);
		contentPane.add(lblBookYourTickets);
		
		park = new JLabel("");
		park.setForeground(Color.WHITE);
		park.setFont(new Font("Times New Roman", Font.BOLD, 18));
		park.setBounds(566, 158, 227, 16);
		contentPane.add(park);
		
		cost = new JLabel("");
		cost.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cost.setForeground(Color.WHITE);
		cost.setBounds(566, 210, 83, 14);
		contentPane.add(cost);
		
		JLabel lblCostPerPerson = new JLabel("Cost per person");
		lblCostPerPerson.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCostPerPerson.setForeground(Color.WHITE);
		lblCostPerPerson.setBounds(357, 202, 125, 22);
		contentPane.add(lblCostPerPerson);
		
		
		btnBookNow = new JButton("BOOK NOW");
		btnBookNow.setForeground(Color.BLACK);
		btnBookNow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBookNow.setBounds(419, 508, 158, 33);
		contentPane.add(btnBookNow);
		btnBookNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Login log=new Login();
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver Loaded Successfully");
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
					System.out.println("Connection Build");
					System.out.println("Statement Created");
					String query="insert into admin (user_name,park_booked,no_of_ad,no_of_child,Date_of_book,total) values(?,?,?,?,?,?)";
	                PreparedStatement pst = myConn.prepareStatement(query);
	                pst.setString(1,log.user);
	                String value= park.getText();
                    pst.setString(2,value);
	                pst.setString(3,noad.getText());
                    pst.setString(4,nochil.getText());
                    pst.setString(5,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
                    int one=Integer.parseInt(noad.getText());
                    int two=Integer.parseInt(nochil.getText());
                    String total;
                    if(value.equals("Wonderland"))
                    {
                    total= String.valueOf(600*(one+two)); 
                    }
                    else if(value.equals("Hardy's World"))
                    {
                    	 total= String.valueOf(450*(one+two)); 
                    }
                    else if(value.equals("TR Enjoy World"))
                    {
                    	 total= String.valueOf(360*(one+two)); 
                    }
                    else if(value.equals("Suncity Amusement Park"))
                    {
                    	 total= String.valueOf(580*(one+two)); 
                    }
                    else if(value.equals("DreamLand"))
                    {
                    	 total= String.valueOf(300*(one+two)); 
                    }
                    else
                    {
                    	 total= String.valueOf(450*(one+two)); 
                    }
                    
                    textField.setText("Rs."+total);
           
                    pst.setString(6, total);
	                pst.execute();
                    JOptionPane.showMessageDialog(null,"YOUR PARK HAS BEEN BOOKED..PLEASE WRITE A REVIEW..");
                    pst.close();
                    reviews rev=new reviews();
                    rev.setVisible(true);
                   
                    
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/maxresdefault.jpg")).getImage();
		contentPane.setLayout(null);
		label.setIcon(new ImageIcon(img));
		label.setBounds(5, 5, 1352, 701);
		contentPane.add(label);
			
	}
}
