package screenPackage;

import hardCodePackage.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPanel;

import databasePackage.CreateDBOperations;

public class HomeScreen extends JFrame implements ActionListener {

	private JFrame frame;
	JButton addButton, deleteButton, teamRoster, leaveApp, account,
			updateEmployee, advancedSearch, deleteEmployee, logout;
	private ResultSet data;
	private CreateDBOperations a;
	private EmployeeRegister e;
	private int empCount;
	private TeamManagement t;
	private ArrayList<String> groups;
	private ArrayList<ArrayList<User>> teamList;
	
	public HomeScreen(EmployeeRegister e, int i, CreateDBOperations a,TeamManagement t,
			ResultSet data, ArrayList<String> groups) {
		this.a = a;
		this.groups = groups;
		empCount = i;
		this.t = t;
		this.data = data;
		this.e = e;
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.RED);
		frame.setForeground(Color.ORANGE);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.setBounds(100, 100, 663, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Team");
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_3 = new JMenu("Help");
		mnNewMenu_3.setForeground(Color.BLACK);
		mnNewMenu_3.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu_3);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 11, 519, 370);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		addButton = new JButton("Add Employee");
		addButton.setBackground(new Color(255, 153, 255));
		addButton.setBounds(10, 329, 115, 30);
		panel.add(addButton);
		addButton.setEnabled(false);
		addButton.addActionListener(this);

		leaveApp = new JButton("Apply for Leave");
		leaveApp.setBackground(new Color(255, 255, 204));
		leaveApp.addActionListener(this);

		leaveApp.setBounds(10, 142, 140, 32);
		panel.add(leaveApp);
		leaveApp.addActionListener(this);

		JLabel mcrochedIndustries = new JLabel("   McRoched Industries");
		mcrochedIndustries.setBounds(0, 15, 181, 32);
		panel.add(mcrochedIndustries);
		mcrochedIndustries.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		teamRoster = new JButton("Team Roster");
		teamRoster.setBounds(198, 209, 148, 32);
		panel.add(teamRoster);
		teamRoster.setBackground(new Color(255, 255, 204));
		teamRoster.addActionListener(this);

		account = new JButton("Account");
		account.setBounds(10, 209, 140, 32);
		panel.add(account);
		account.addActionListener(this);
		account.setBackground(new Color(255, 255, 204));

		advancedSearch = new JButton("Find Employee");
		advancedSearch.setBounds(198, 142, 148, 32);
		panel.add(advancedSearch);
		advancedSearch.addActionListener(this);
		advancedSearch.setBackground(new Color(255, 255, 204));

		updateEmployee = new JButton("Update Employee");
		updateEmployee.setBackground(new Color(255, 153, 255));
		updateEmployee.setBounds(135, 329, 148, 30);
		panel.add(updateEmployee);
		updateEmployee.setEnabled(false);
		updateEmployee.addActionListener(this);

		deleteEmployee = new JButton("Delete Employee");
		deleteEmployee.setBackground(new Color(255, 153, 255));
		deleteEmployee.setBounds(293, 329, 130, 30);
		panel.add(deleteEmployee);
		deleteEmployee.setEnabled(false);
		deleteEmployee.addActionListener(this);

		if (e.returnEmployeeType(i) == "Admin") {
			updateEmployee.setEnabled(true);
			deleteEmployee.setEnabled(true);
			addButton.setEnabled(true);
		}

		logout = new JButton("Logout");
		logout.setBackground(new Color(255, 255, 204));
		logout.setBounds(395, 43, 102, 23);
		panel.add(logout);

		JLabel lblWelcome = new JLabel("Welcome " + e.getEmployeeName(i) + " "
				+ e.getEmployeeSurName(i));
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 12));
		lblWelcome.setBounds(10, 66, 207, 23);
		panel.add(lblWelcome);
		logout.addActionListener(this);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {
			// new AddScreen();
			AddScreen add = new AddScreen(data, a, e);
		}

		else if (ae.getSource() == account) {
			AccountScreen s = new AccountScreen(data, a, e,
					e.getEmployeeNum(empCount), 1, empCount, groups);

		}

		else if (ae.getSource() == advancedSearch) {
			frame.dispose();
			// Advanced_Search_Screen A = new Advanced_Search_Screen(e, data,
			// a);
			EmSearch search = new EmSearch(e, data, a, 2, empCount, groups);
		}

		else if (ae.getSource() == teamRoster) {
			frame.dispose();
			TeamScreen T = new TeamScreen(e, a, empCount, data, t, groups);

		}



		else if (ae.getSource() == updateEmployee) {

			EmSearch search = new EmSearch(e, data, a, 0, empCount, groups);

			// User u;
			// int index = -1;
			//
			// String b = JOptionPane.showInputDialog(null,
			// "Enter the Employee ID of the Employee you wish to update. ",
			// "EmployeeRoster", JOptionPane.QUESTION_MESSAGE);
			//
			//
			// for (int i = 0; i < e.EmployeeListSize(); i++){
			// if (b.equalsIgnoreCase(e.getEmployeeNum(i))){
			// index = i;
			//
			// }
			//
			// }
			//
			// if (index >= 0){
			// u = new User
			// (e.getEmployeeName(index),e.getEmployeeSurName(index),
			// e.getEmployeeAddress(index), e.getGender(index),
			// e.getNationality(index), e.getEmployeeNum(index),
			// e.GetContractLength(index),
			// e.getEmployeeType(index), e.getEmployeePass(index),
			// e.getDepartment(index));
			//
			// UpdateScreen US = new UpdateScreen (u, e , data, a);
			// }
			// else {
			//
			// JOptionPane.showMessageDialog(null,
			// "Employee not found ", "Update Employee",
			// JOptionPane.PLAIN_MESSAGE);
			// }

		}

		else if (ae.getSource() == deleteEmployee) {
			// String b = JOptionPane.showInputDialog(null,
			// "Enter the ID of the Employee you wish to delete. ",
			// "EmployeeRoster", JOptionPane.QUESTION_MESSAGE);
			//
			// int index = -1;
			//
			// for (int i = 0; i < e.EmployeeListSize(); i++){
			// if (b.equalsIgnoreCase(e.getEmployeeNum(i))){
			// index = i;
			//
			// }
			//
			// }
			//
			// if (index >= 0){
			// a.deleteEmployee(e.getEmployeeNum(index));
			// }
			// else {
			//
			// JOptionPane.showMessageDialog(null,
			// "Employee not found ", "Delete " +
			// "Employee",
			// JOptionPane.PLAIN_MESSAGE);
			// }

			EmSearch search = new EmSearch(e, data, a, 1, empCount, groups);

		}

		else if (ae.getSource() == logout) {
			loginScreen l = new loginScreen(e, a, data, t);
			l.getFrame().setVisible(true);
			frame.dispose();
		}
	}
}
