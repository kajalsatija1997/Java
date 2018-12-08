import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class tabledemo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabledemo frame = new tabledemo();
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
	public tabledemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 573, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 70, 487, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btloadtable = new JButton("Check Your Booked Parks");
		btloadtable.setFont(new Font("Tahoma", Font.BOLD, 15));
		btloadtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Loaded Successfully");
				Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false","mydatabase_admin" , "wethesatijas");
				System.out.println("Connection Build");
				System.out.println("Statement Created");
				String query="select a.id,a.park_booked,a.no_of_ad,a.no_of_child,a.Date_of_book,a.total from admin a,users b where a.user_name=b.Domain_name";
				PreparedStatement pst = myConn.prepareStatement(query);
				 
				 ResultSet rs = pst.executeQuery();
				 table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
		btloadtable.setBounds(130, 25, 233, 34);
		contentPane.add(btloadtable);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 557, 412);
		Image img=new ImageIcon(this.getClass().getResource("/vintage_style_photography_cool_wallpapers.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		contentPane.add(label);
	}
	
}
