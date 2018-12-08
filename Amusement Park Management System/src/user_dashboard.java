import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.INITIALIZE;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class user_dashboard extends JFrame {

	private JPanel contentPane;
	public JLabel show_label;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					user_dashboard frame = new user_dashboard();
					//user_dashboard frame1 = new user_dashboard("");
					
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
	
	public user_dashboard() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-2,0,1500,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        super.setResizable(false);
		
		JLabel lblUserDashboard = new JLabel("USER DASHBOARD");
		lblUserDashboard.setForeground(new Color(0, 0, 0));
		lblUserDashboard.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblUserDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDashboard.setBounds(10, 11, 1200, 42);
		contentPane.add(lblUserDashboard);
		
		JButton bookedparks = new JButton("Booked Parks");
		bookedparks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tabledemo book=new tabledemo();
				book.setVisible(true);
								
			}
		});
		bookedparks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookedparks.setBounds(10, 123, 184, 27);
		contentPane.add(bookedparks);
		
		JButton cancelrequests = new JButton("Cancel Your Booking");
		cancelrequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_requests can=new cancel_requests();
				can.setVisible(true);
			}
		});
		cancelrequests.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelrequests.setBounds(10, 161, 184, 27);
		contentPane.add(cancelrequests);
		
		JButton home = new JButton("Home");
		home.setFont(new Font("Tahoma", Font.PLAIN, 15));
		home.setBounds(10, 85, 184, 27);
		contentPane.add(home);
		
		JButton parksreview = new JButton("Parks Reviewed");
		parksreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkreviews check=new checkreviews();
				check.setVisible(true);
			}
		});
		parksreview.setFont(new Font("Tahoma", Font.PLAIN, 15));
		parksreview.setBounds(10, 199, 184, 27);
		contentPane.add(parksreview);
		
		JButton payments = new JButton("Payments");
		payments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		payments.setBounds(10, 237, 184, 27);
		contentPane.add(payments);
		
		JButton btnNewButton = new JButton("Explore Parks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				explore ex=new explore();
				ex.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 275, 184, 23);
		contentPane.add(btnNewButton);
		
		show_label = new JLabel("");
		show_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		show_label.setBounds(1266, 11, 88, 27);
		contentPane.add(show_label);
		
		JLabel lblNewLabel = new JLabel("WELCOME!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1168, 11, 88, 27);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1372, 721);
		Image img=new ImageIcon(this.getClass().getResource("/amuse.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		
	
	}
}
