package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;
	public JFrame frame_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame_1 = new JFrame();
		frame_1.getContentPane().setBackground(Color.BLACK);
		frame_1.setBounds(100, 100, 542, 392);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		frame_1.setUndecorated(true);
		
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(179, 31, 76, 28);
		frame_1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(179, 109, 76, 23);
		frame_1.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Contact contact = new Contact();
				contact.SetUsername(textField.getText());
				contact.SetPassword(passwordField_1.getText());
				contact.SetRepeatPassword(passwordField.getText());
				App a = new App();
				try {
					a.signup(contact);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(179, 313, 271, 42);
		frame_1.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.BLACK);
		Image img = new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		lblNewLabel_2.setBounds(20, 88, 144, 181);
		frame_1.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("repeat password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(179, 192, 163, 23);
		frame_1.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(179, 226, 270, 28);
		frame_1.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("X");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(521, 0, 81, 28);
		frame_1.getContentPane().add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(179, 143, 276, 28);
		frame_1.getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(179, 70, 271, 28);
		frame_1.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
