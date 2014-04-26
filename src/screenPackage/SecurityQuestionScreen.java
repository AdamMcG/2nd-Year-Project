package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.xml.transform.ErrorListener;

import databasePackage.CreateDBOperations;


public class SecurityQuestionScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField securityQ, securityA;
	private JButton submit, cancel;
	private EmployeeRegister Elist;
	private ResultSet Rset;
	private CreateDBOperations CDBO;
	private String EmpNo;
	private String answer;
	private User currentUser;
	
	public SecurityQuestionScreen(ResultSet Rset, CreateDBOperations CDBO, EmployeeRegister Elist, User currentUser) {
	
		this.Rset = Rset;
		this.CDBO = CDBO;
		this.Elist = Elist;
		this.currentUser = currentUser;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 635, 448);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 539, 368);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("McRoched Industries");
		label.setBounds(10, 50, 153, 21);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		panel.add(label);
		
		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question: ");
		lblYourSecurityQuestion.setBounds(30, 144, 132, 21);
		panel.add(lblYourSecurityQuestion);
		
		securityQ = new JTextField();
		securityQ.setEditable(false);
		securityQ.setBounds(175, 144, 200, 21);
		panel.add(securityQ);
		securityQ.setColumns(10);
		
		securityA = new JTextField();
		securityA.setBounds(175, 197, 200, 20);
		panel.add(securityA);
		securityA.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer: ");
		lblAnswer.setBounds(30, 200, 133, 17);
		panel.add(lblAnswer);
		
		submit = new JButton("Save");
		submit.setBounds(105, 314, 89, 23);
		panel.add(submit);
		submit.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(264, 314, 89, 23);
		panel.add(cancel);
		cancel.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("title");
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Messaging");
		mnNewMenu_2.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_2);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);
		start();
		frame.setVisible(true);
	}

	private void start() {
		
			securityQ.setText(currentUser.getSecretQ());
			answer = currentUser.getSecretA();
			
			
			
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == submit)
		{
			String input = securityA.getText();
			
			if (input.equalsIgnoreCase(answer)){
				
				ResetPasswordScreen RPS  = new ResetPasswordScreen(Rset, CDBO, Elist, currentUser);
				frame.dispose();
				
			}
			else {
				
			JOptionPane.showMessageDialog(null,
			"Wrong Answer", "Secret Question",
			JOptionPane.PLAIN_MESSAGE);
				
				
				
			}
			
		}
		else if(e.getSource() == cancel)
		{
		
			frame.dispose();
			
		}
	}
}
