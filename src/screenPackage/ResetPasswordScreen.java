package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import databasePackage.CreateDBOperations;


public class ResetPasswordScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel passwordLabel1, passwordLabel2;
	private JButton cancel, submit;
	private ResultSet Rset;
	private CreateDBOperations CDBO;
	private EmployeeRegister Elist;
	private User currentUser;
	
	
	public ResetPasswordScreen(ResultSet Rset, CreateDBOperations CDBO, EmployeeRegister Elist, User currentUser) {
	
		
		this.Rset = Rset;
		this.CDBO = CDBO;
		this.Elist = Elist;
		this.currentUser = currentUser;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 647, 455);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 538, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("McRoched Industries");
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		label.setBounds(10, 34, 153, 21);
		panel.add(label);
		
		passwordLabel1 = new JLabel("New Password:");
		passwordLabel1.setBounds(10, 133, 102, 17);
		panel.add(passwordLabel1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 131, 125, 20);
		panel.add(passwordField);
		
		passwordLabel2 = new JLabel("Repeat Password");
		passwordLabel2.setBounds(10, 173, 102, 28);
		panel.add(passwordLabel2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(168, 177, 125, 20);
		panel.add(passwordField_1);
		
		submit = new JButton("Submit");
		submit.setBounds(74, 298, 89, 23);
		panel.add(submit);
		submit.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(204, 298, 89, 23);
		panel.add(cancel);
		cancel.addActionListener(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Team");
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Messaging");
		mnNewMenu_2.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_2);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == cancel)
		{
			frame.dispose();
		}

		
		else if(e.getSource() == submit && passwordField.getText().equals(passwordField_1.getText()))
		{

			
			
			currentUser.setPassword(passwordField.getText());
			CDBO.updatePass(currentUser);
			

			JOptionPane.showMessageDialog(null,
			"Password updated", "Password Reset",
			JOptionPane.PLAIN_MESSAGE);
			
			frame.dispose();
			
		}
		
		else {
			

			JOptionPane.showMessageDialog(null,
			"Passwords don't match", "Password Reset",
			JOptionPane.PLAIN_MESSAGE);
			
		}
	}
}
