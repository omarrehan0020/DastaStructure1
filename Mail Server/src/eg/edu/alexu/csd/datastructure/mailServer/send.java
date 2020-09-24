package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class send {

	public JFrame frame;
	private String x ;
	DefaultListModel<String> listModel ;
	boolean flag ;
	private JScrollPane menuScrollPane;
	private String y="" ;
	public String path ="";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public send() {
		initialize();
		listModel = new DefaultListModel<>();
		flag=true ;
	}
	public send(String user) {
		initialize();
		x = user ;
		listModel = new DefaultListModel<>();
		flag=true ;
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				compo wi = new compo(x);
				wi.frame.setVisible(true);
				frame.dispose();
			
				
			}
		});
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(340, 421, 99, 31);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Compose");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gui window = new Gui();
				window.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(339, 11, 87, 31);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Log Out");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
	
		JList<String> list = new JList<>();
		list.setBackground(Color.LIGHT_GRAY);
		 
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		list.setBounds(10, 11, 319, 405);
		frame.getContentPane().add(list);
		frame.setBounds(100, 100, 465, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				y = "inbox" ;
				listModel.removeAllElements();
				list.setModel(listModel);
				BufferedReader br = null ;
				
					try {
						br = new BufferedReader(new FileReader("users/" + x + "/inbox/index.txt"));
					} catch (FileNotFoundException e1) {
						
						return;
					}
					

					    String line;
					    try {
							while ((line = br.readLine()) != null) {
							  listModel.addElement(line);
							}
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					    list.setModel(listModel);
					 
					   
					    try {
							br.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  }
			
				
				
				
			
		});
		panel_2.setBounds(339, 73, 87, 23);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("inbox");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				y = "sent" ;
				listModel.removeAllElements();
				list.setModel(listModel);
				BufferedReader br = null ;
				
					try {
						br = new BufferedReader(new FileReader("users/" + x + "/sent/sent.txt"));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						return ;
					}
					

					    String line;
					    try {
							while ((line = br.readLine()) != null) {
							  listModel.addElement(line);
							}
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					    list.setModel(listModel);
					 
					   
					    try {
							br.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
				
			}
		});
		panel_4.setBounds(339, 125, 87, 23);
		frame.getContentPane().add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("sent");
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] splited ;
				  String s = (String) list.getSelectedValue();
				  try {
				  splited = s.split(" ");
				  }catch(Exception E)
				  {
					  return ;
				  }
				 path ="users\\" + x +"\\"+ y +"\\" + splited[0]; 
				mai window = new mai(path,x);
				window.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		panel_5.setBounds(259, 421, 71, 31);
		frame.getContentPane().add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Select");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password window = new password(x);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		panel_3.setBounds(10, 421, 145, 32);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Change Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_5);
		
		
		
	}
}
