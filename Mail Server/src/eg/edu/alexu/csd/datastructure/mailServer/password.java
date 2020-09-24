package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class password {

	public JFrame frame;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private String user ;
	private String path ;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public password() {
		initialize();
	}
	public password(String x) {
		initialize();
		user = x ;
		path = "users\\" + x +"\\password.txt" ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 11, 128, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New password");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 92, 105, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		oldPass = new JPasswordField();
		oldPass.setBackground(Color.LIGHT_GRAY);
		oldPass.setBounds(10, 49, 367, 32);
		frame.getContentPane().add(oldPass);
		
		newPass = new JPasswordField();
		newPass.setBackground(Color.LIGHT_GRAY);
		newPass.setBounds(10, 122, 367, 32);
		frame.getContentPane().add(newPass);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				BufferedReader in = null ;
				try {
				
				    in = new BufferedReader(new FileReader(path));
				    String str = in.readLine();
				    if (str.equals(oldPass.getText()))
				    {
				    	 FileWriter fwOb = new FileWriter(path, false); 
				         PrintWriter pwOb = new PrintWriter(fwOb, false);
				         pwOb.flush();
				         pwOb.close();
				         fwOb.close();
				         try {
				             FileWriter writer = new FileWriter(path, true);
				             writer.write(newPass.getText());
				             writer.close();
				             JOptionPane.showMessageDialog(null, "The password is changed successfully");
				         } catch (IOException e2) {
				             e2.printStackTrace();
				         }
				         
				    }else 
				    {
				    	JOptionPane.showMessageDialog(null, "Old Password is wrong",  "Hey!", JOptionPane.ERROR_MESSAGE);
				    }
				  
				}
				catch (IOException e1) {
				} finally {
				    try { in.close(); } catch (Exception ex) { }
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 189, 367, 38);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 403, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
