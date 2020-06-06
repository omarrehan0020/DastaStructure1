import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class simple {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					simple window = new simple();
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
	public simple() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField1 = new JTextField();
		textField1.setBounds(71, 23, 86, 51);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("num1");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(29, 38, 63, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textField2 = new JTextField();
		textField2.setBounds(264, 23, 79, 51);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("num2");
		lblNewLabel_1.setBounds(226, 41, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x ,y  ;
				int res ;
				try {
					x = Integer.parseInt(textField1.getText()) ;
					y = Integer.parseInt(textField2.getText()) ;
					calculate oo = new calculate() ;
					res = oo.add(x, y) ;
					textField3.setText(Integer.toString(res));
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Enter a valid number ");
				}
			}
		});
		btnNewButton.setBounds(71, 114, 101, 51);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("divide");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x ,y  ;
				float res ;
				try {
					x = Integer.parseInt(textField1.getText()) ;
					y = Integer.parseInt(textField2.getText()) ;
					calculate ooo = new calculate() ;
					res = ooo.divide(x, y) ;
					if (y != 0)
					textField3.setText(Float.toString(res));
					else 
						JOptionPane.showMessageDialog(null,"you can't divide by zero ");
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Enter a valid number ");
				}
			}
		});
		btnNewButton_1.setBounds(247, 114, 96, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("result");
		lblNewLabel_2.setBounds(46, 209, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField3 = new JTextField();
		textField3.setBounds(102, 192, 86, 58);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);
	}
}
