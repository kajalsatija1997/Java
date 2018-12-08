import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private JFrame frmLoginSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-2,0,1500,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("EXPLORE");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explore ex=new explore();
				ex.setVisible(true);
			    
			}
			
		});
		btnNewButton.setBounds(1132, 31, 181, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN IN");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Login log=new Login();
			log.setVisible(true);
		}
		
	});
		btnNewButton_1.setBounds(1132, 65, 181, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login system",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(1132, 99, 181, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblWelcomeToAmusement = new JLabel("<html>WELCOME TO<br>AMUSEMENT PARK MANAGEMENT SYSTEM</html>");
		lblWelcomeToAmusement.setForeground(new Color(222, 184, 135));
		lblWelcomeToAmusement.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblWelcomeToAmusement.setBounds(23, 53, 656, 151);
		contentPane.add(lblWelcomeToAmusement);
		
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Image img=new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		contentPane.setLayout(null);
		label.setIcon(new ImageIcon(img));
		label.setBounds(5, 0, 1344, 706);
		contentPane.add(label);
		
		
	
	}
}
