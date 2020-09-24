package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;

public class compo {

	public JFrame frame;
	private JTextField from;
	private JTextField to;
	private JLabel email;
	private JTextField subject;
	private JTextField pr;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
    private Mail f = new Mail();
    private JLabel lblNewLabel_5;
    private JTextField to2;
    private JTextField to3;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public compo() {
		initialize();
	}
	
	public compo(String user) {
		initialize();
		from.setText(user);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 11, 70, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To    : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 66, 70, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		from = new JTextField();
		from.setBackground(Color.LIGHT_GRAY);
		from.setBounds(82, 26, 196, 23);
		frame.getContentPane().add(from);
		from.setColumns(10);
		
		to = new JTextField();
		to.setBackground(Color.LIGHT_GRAY);
		to.setBounds(82, 75, 135, 24);
		frame.getContentPane().add(to);
		to.setColumns(10);
		
		email = new JLabel("Email :");
		email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		email.setForeground(Color.LIGHT_GRAY);
		email.setBounds(10, 174, 54, 23);
		frame.getContentPane().add(email);
		
		JTextPane message = new JTextPane();
		message.setBackground(Color.LIGHT_GRAY);
		message.setBounds(82, 174, 196, 196);
		frame.getContentPane().add(message);
		
		JLabel lblNewLabel_2 = new JLabel("Subject :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(10, 121, 70, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		subject = new JTextField();
		subject.setBackground(Color.LIGHT_GRAY);
		subject.setBounds(82, 129, 196, 23);
		frame.getContentPane().add(subject);
		subject.setColumns(10);
		
		pr = new JTextField();
		pr.setBackground(Color.LIGHT_GRAY);
		pr.setBounds(301, 128, 36, 23);
		frame.getContentPane().add(pr);
		pr.setColumns(10);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 JFileChooser file = new JFileChooser();
			      file.setMultiSelectionEnabled(true);
			      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			      file.setFileHidingEnabled(false);
			     Component fr = null ;
			     file.showOpenDialog(fr);
			     File[] files = file.getSelectedFiles();
			     for (int i=0 ;i<files.length;i++)
			     {
			    	 f.setAttachment(files[i].getPath());
			     }
			     
			     
			         
			}
		});
		lblNewLabel_4.setBounds(150, 387, 54, 67);
		frame.getContentPane().add(lblNewLabel_4);
		Image img = new ImageIcon(this.getClass().getResource("/attach.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img));
		
		lblNewLabel_5 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img2));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (subject.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please,Enter main subject",  "Hey!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if (pr.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please,Enter priority",  "Hey!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if (to.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please,Enter the receiver username",  "Hey!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if (from.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please,Enter the sender username",  "Hey!", JOptionPane.ERROR_MESSAGE);
					return ;
				}
			
				f.setSender(from.getText());
				f.setReceivers(to.getText());
				f.setEmail(message.getText());
				f.setMainSubject(subject.getText());
				if (!to2.getText().equals("")) f.setReceivers(to2.getText());
				if (!to3.getText().equals("")) f.setReceivers(to3.getText());
				
				try {
				f.setPriority(Integer.parseInt(pr.getText()));
				}catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Please,Enter number for priority",  "Hey!", JOptionPane.ERROR_MESSAGE);
			        return ;
			    }
				App o = new App();
				try {
					if(o.compose(f))
					{
						JOptionPane.showMessageDialog(null, "Email sent successfully");
						to.setText("");
						pr.setText("");
						message.setText("");
						subject.setText("");
						to2.setText("");
						to3.setText("");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		lblNewLabel_5.setBounds(61, 387, 54, 67);
		frame.getContentPane().add(lblNewLabel_5);
		
		to2 = new JTextField();
		to2.setBackground(Color.LIGHT_GRAY);
		to2.setBounds(237, 76, 142, 23);
		frame.getContentPane().add(to2);
		to2.setColumns(10);
		
		to3 = new JTextField();
		to3.setBackground(Color.LIGHT_GRAY);
		to3.setBounds(403, 76, 142, 23);
		frame.getContentPane().add(to3);
		to3.setColumns(10);
		
	}
}
