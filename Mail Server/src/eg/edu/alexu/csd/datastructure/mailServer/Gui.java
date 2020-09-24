package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Gui {

	public JFrame frame;

	int xx,xy ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui(); 
					window.frame.setUndecorated(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(new Color(0, 0, 255));
		frame.setBounds(100, 100, 569, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		JButton btnNewButton = new JButton("Sign In");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn window = new signIn();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(326, 278, 185, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
					SignUp window = new SignUp();
					window.frame_1.setVisible(true);
					
					frame.dispose();
				
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(326, 223, 185, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		Image img_1 = new ImageIcon(this.getClass().getResource("/lab.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(358, 50, 160, 117);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen() ;
				frame.setLocation(x-xx,y-xy);
				
			}
		});
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(0, -123, 497, 459);
		frame.getContentPane().add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/lab.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 165, 268, 65);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 258, 268, 161);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("...We Got You...");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 226, 268, 44);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel("\r\nKeepToo");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setBounds(535, 11, 54, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
	}
}
