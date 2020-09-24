package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mai {

	public JFrame frame;
	private String path ;
	private boolean flag ;
	private String user ;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public mai() {
		initialize();
		flag = true ;
	}
	public mai(String p , String x) {
		initialize();
		this.path = p ;
		flag = true ;
		user = x ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 519, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 530, 365);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(0, 0, 509, 365);
		panel.add(textArea); 
		
		JButton btnNewButton = new JButton("Content");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (flag) {
				BufferedReader in = null;
				try {
					String path1 = path + "\\content.txt" ;
				    in = new BufferedReader(new FileReader(path1));
				    String str;
				    while ((str = in.readLine()) != null) {
				        textArea.append(str); 
				        textArea.append("\n");
				    }
				    flag = false ;
				} catch (IOException e1) {
				} finally {
				    try { in.close(); } catch (Exception ex) { }
				}
			}
			}
		});
		btnNewButton.setBounds(247, 376, 101, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Attachments");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {        
					 String path2 = path + "\\Attachments" ;   
	                Runtime runtime = Runtime.getRuntime();        
	                runtime.exec("explorer.exe "+path2);        
	                System.out.println("open");        
	            } catch (Exception E) {        
	                System.out.println("File Not Found");        
	            }
				
			}
		});
		btnNewButton_1.setBounds(55, 376, 137, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				send window = new send(user);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		panel_1.setBounds(429, 390, 64, 26);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("back");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblNewLabel);
		

		
	}
}
