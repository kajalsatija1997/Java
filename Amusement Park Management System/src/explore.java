import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class explore extends JFrame {

	private JPanel contentPane;
	private JTextField txtExploreParks;
	private final Action action = new SwingAction();
	public JLabel thunder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					explore frame = new explore();
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
	public explore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-2,0,1500,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExploreParks = new JLabel("CHOOSE THE BEST PARK TO VISIT");
		lblExploreParks.setHorizontalAlignment(SwingConstants.CENTER);
		lblExploreParks.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblExploreParks.setForeground(Color.WHITE);
		lblExploreParks.setBounds(10, 11, 1116, 76);
		contentPane.add(lblExploreParks);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\thunder_zone.jpeg"));
		label_1.setBounds(74, 98, 237, 164);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\suncity-amusement-park.jpg"));
		lblNewLabel.setBounds(572, 98, 237, 164);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\thunder.jpeg"));
		lblNewLabel_1.setBounds(1062, 98, 237, 164);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\wonderland.jpg"));
		lblNewLabel_2.setBounds(74, 404, 237, 164);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\TRenjoy.jpg"));
		lblNewLabel_3.setBounds(572, 404, 237, 164);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Dell\\Pictures\\Capture.PNG"));
		lblNewLabel_4.setBounds(1062, 404, 237, 164);
		contentPane.add(lblNewLabel_4);
		
		JButton btnsun = new JButton("BOOK NOW");
		btnsun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book_tickets bo=new book_tickets();
				bo.park.setText("Suncity Amusement Park");
				bo.cost.setText("RS. 450");
				bo.setVisible(true);
				
			}
		});
	
		btnsun.setBounds(635, 352, 111, 23);
		contentPane.add(btnsun);
		
		JButton btnwonderland = new JButton("BOOK NOW");
		btnwonderland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book_tickets bo=new book_tickets();
				bo.park.setText("Wonderland");
				bo.cost.setText("RS. 600");
				bo.setVisible(true);
			}
		});
		btnwonderland.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnwonderland.setBounds(138, 661, 111, 23);
		contentPane.add(btnwonderland);
		
		JButton btnTR = new JButton("BOOK NOW");
				btnTR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						book_tickets bo=new book_tickets();
						bo.park.setText("TR Enjoy World");
						bo.cost.setText("RS. 600");
						bo.setVisible(true);
					}
				});;
		btnTR.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTR.setBounds(635, 661, 111, 23);
		contentPane.add(btnTR);
		
		JButton btnhardy = new JButton("BOOK NOW");
		btnhardy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book_tickets bo=new book_tickets();
				bo.park.setText("Hardy's World");
				bo.cost.setText("RS.450 ");
				bo.setVisible(true);
			}
		});
		btnhardy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnhardy.setBounds(1122, 352, 111, 23);
		contentPane.add(btnhardy);
		
		JButton btndream = new JButton("BOOK NOW");
		btndream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book_tickets bo=new book_tickets();
				bo.park.setText("Dreamland");
				bo.cost.setText("RS. 300");
				bo.setVisible(true);
			}
		});
		btndream.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btndream.setBounds(1122, 661, 111, 23);
		contentPane.add(btndream);
		
		JButton btnthunder = new JButton("BOOK NOW");
		btnthunder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_tickets bo=new book_tickets();
				bo.park.setText("Thunder Zone");
				bo.cost.setText("RS. 450");
				bo.setVisible(true);
				
			}
		});
		btnthunder.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthunder.setBounds(138, 352, 111, 23);
		contentPane.add(btnthunder);
		
		JLabel lblL = new JLabel("Suncity Amusement Park ");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblL.setForeground(Color.ORANGE);
		lblL.setBounds(572, 287, 237, 23);
		contentPane.add(lblL);
		
		JLabel lblamuse = new JLabel("580/-");
		lblamuse.setHorizontalAlignment(SwingConstants.CENTER);
		lblamuse.setForeground(Color.ORANGE);
		lblamuse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblamuse.setBounds(572, 321, 237, 20);
		contentPane.add(lblamuse);
		
		JLabel lblL1 = new JLabel("Wonderland");
		lblL1.setHorizontalAlignment(SwingConstants.CENTER);
		lblL1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblL1.setForeground(Color.ORANGE);
		lblL1.setBounds(74, 591, 237, 23);
		contentPane.add(lblL1);
		
		JLabel lblwonder = new JLabel("600/-");
		lblwonder.setHorizontalAlignment(SwingConstants.CENTER);
		lblwonder.setForeground(Color.ORANGE);
		lblwonder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblwonder.setBounds(74, 628, 237, 20);
		contentPane.add(lblwonder);
		
		JLabel lblL2 = new JLabel("TR Enjoy world ");
		lblL2.setHorizontalAlignment(SwingConstants.CENTER);
		lblL2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblL2.setForeground(Color.ORANGE);
		lblL2.setBounds(583, 591, 237, 23);
		contentPane.add(lblL2);
		
		JLabel lblTR = new JLabel("360/-");
		lblTR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTR.setForeground(Color.ORANGE);
		lblTR.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTR.setBounds(572, 628, 237, 20);
		contentPane.add(lblTR);
		
		JLabel lblL3 = new JLabel("Hardy's World ");
		lblL3.setHorizontalAlignment(SwingConstants.CENTER);
		lblL3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblL3.setForeground(Color.ORANGE);
		lblL3.setBounds(1062, 287, 237, 23);
		contentPane.add(lblL3);
		
		JLabel lblNewLabel_8 = new JLabel("450/-");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.ORANGE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(1062, 321, 237, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lbldream = new JLabel("Dream Land");
		lbldream.setHorizontalAlignment(SwingConstants.CENTER);
		lbldream.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbldream.setForeground(Color.ORANGE);
		lbldream.setBounds(1062, 591, 237, 23);
		contentPane.add(lbldream);
		
		JLabel lblNewLabel_9 = new JLabel("300/-");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.ORANGE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(1062, 628, 237, 20);
		contentPane.add(lblNewLabel_9);
		
		thunder = new JLabel("Thunder Zone ");
		thunder.setHorizontalAlignment(SwingConstants.CENTER);
		thunder.setFont(new Font("Times New Roman", Font.BOLD, 20));
		thunder.setForeground(Color.ORANGE);
		thunder.setBounds(74, 287, 237, 23);
		contentPane.add(thunder);
		
		JLabel lblthunder = new JLabel("450/-");
		lblthunder.setHorizontalAlignment(SwingConstants.CENTER);
		lblthunder.setForeground(Color.ORANGE);
		lblthunder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblthunder.setBounds(74, 321, 237, 20);
		contentPane.add(lblthunder);
		
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/explore_bg.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 1362, 711);
		contentPane.add(label);	
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
