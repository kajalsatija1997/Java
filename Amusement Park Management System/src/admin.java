import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-2,0,1500,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register Park");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				park_register park=new park_register();
				park.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(0, 0, 212, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" View Registered Parks");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tryme tr=new tryme();
			tr.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(0, 47, 212, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Registerd Users");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userstable us=new userstable();
				us.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(0, 94, 212, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXPLORE PARKS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				explore ex=new explore();
				ex.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(0, 141, 212, 36);
		contentPane.add(btnNewButton_3);
		
		JLabel last = new JLabel("");
		last.setBounds(0, 0, 1362, 711);
		Image img=new ImageIcon(this.getClass().getResource("/kj.jpg")).getImage();
		last.setIcon(new ImageIcon(img));
		contentPane.add(last);
		
		
	}
}
