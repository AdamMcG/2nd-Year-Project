package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import databasePackage.CreateDBOperations;
import javax.swing.ButtonGroup;

public class EmSearch extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField SearchField;
	private JRadioButton rdbtnEmployeeNumber, rdbtnFirstName, rdbtnSurname,
			rdbtnDepartment;
	private JButton search, cancel;
	private ArrayList<User> EmList;
	private ResultSet rset;
	private CreateDBOperations CDBO;
	private EmployeeRegister EList;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int mode, empCount;
	private ArrayList<String> groups;

	public EmSearch(EmployeeRegister e, ResultSet data, CreateDBOperations a,
			int mode, int empCount, ArrayList<String> groups) {

		rset = data;
		CDBO = a;
		EList = e;
		EmList = new ArrayList<User>();
		this.mode = mode;
		this.empCount = empCount;

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 682, 567);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBounds(31, 31, 567, 420);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		SearchField = new JTextField();
		SearchField.setBounds(87, 265, 230, 32);
		panel.add(SearchField);
		SearchField.setColumns(10);

		JLabel label = new JLabel("McRoched Industries");
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		label.setBounds(10, 11, 181, 32);
		panel.add(label);

		search = new JButton("Search");
		search.setBackground(new Color(255, 255, 204));
		search.setBounds(87, 330, 89, 34);
		search.addActionListener(this);
		panel.add(search);

		cancel = new JButton("cancel");
		cancel.setBackground(new Color(255, 255, 204));
		cancel.setBounds(206, 331, 80, 32);
		panel.add(cancel);
		cancel.addActionListener(this);

		JLabel lblSearchBy = new JLabel("Find Employee By: ");
		lblSearchBy.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSearchBy.setBounds(10, 118, 130, 34);
		panel.add(lblSearchBy);

		rdbtnEmployeeNumber = new JRadioButton("Employee Number");
		buttonGroup.add(rdbtnEmployeeNumber);
		rdbtnEmployeeNumber.setSelected(true);
		rdbtnEmployeeNumber.setBounds(10, 159, 130, 23);
		panel.add(rdbtnEmployeeNumber);

		rdbtnFirstName = new JRadioButton("First Name");
		buttonGroup.add(rdbtnFirstName);
		rdbtnFirstName.setBounds(144, 159, 109, 23);
		panel.add(rdbtnFirstName);

		rdbtnSurname = new JRadioButton("Surname");
		buttonGroup.add(rdbtnSurname);
		rdbtnSurname.setBounds(255, 159, 109, 23);
		panel.add(rdbtnSurname);

		rdbtnDepartment = new JRadioButton("Department");
		buttonGroup.add(rdbtnDepartment);
		rdbtnDepartment.setBounds(371, 159, 109, 23);
		panel.add(rdbtnDepartment);

		JLabel lblEnterSearchTerm = new JLabel("Enter Search Term:");
		lblEnterSearchTerm.setFont(new Font("Arial", Font.BOLD, 13));
		lblEnterSearchTerm.setBounds(87, 236, 151, 31);
		panel.add(lblEnterSearchTerm);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Team");
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancel) {
			frame.dispose();
		}

		else if (ae.getSource() == search
				&& rdbtnEmployeeNumber.isSelected() == true) {

			User u;
			int index = -1;
			System.out.println(EList.EmployeeListSize());

			String searchTerm = SearchField.getText();

			for (int i = 0; i < EList.EmployeeListSize(); i++) {
				System.out.println(searchTerm + " " + EList.getEmployeeNum(i));
			}
			for (int i = 0; i < EList.EmployeeListSize(); i++) {
				if (searchTerm.equalsIgnoreCase(EList.getEmployeeNum(i))) {

					index = i;

				}
			}

			if (index >= 0) {
				u = new User(EList.getEmployeeName(index),
						EList.getEmployeeSurName(index),
						EList.getEmployeeAddress(index),
						EList.getGender(index), EList.getNationality(index),
						EList.getEmployeeNum(index),
						EList.GetContractLength(index),
						EList.getEmployeeType(index),
						EList.getEmployeePass(index), EList.getSecretQ(index),
						EList.getSecretA(index), EList.getDepartment(index),
						EList.getdNumber(index), EList.getpNumber(index),
						EList.getcNumber(index), EList.gettNumber(index));

				if (mode == 0) {
					UpdateScreen US = new UpdateScreen(u, EList, rset, CDBO);
					frame.dispose();

				} else if (mode == 1) {

					CDBO.deleteEmployee(EList.getEmployeeNum(index));
					EList.fillRegister();
					frame.dispose();
				} else if (mode == 2) {

					AccountScreen s = new AccountScreen(rset, CDBO, EList,
							EList.getEmployeeNum(index), mode, empCount, groups);
					frame.dispose();

				}

			} else {
				System.out.println("Error searching failed");
				frame.dispose();
			}

		}

		else if (ae.getSource() == search
				&& rdbtnFirstName.isSelected() == true) {

			String searchTerm = SearchField.getText();
			String searchType = "FName";

			searchResultEmployee RScreen = new searchResultEmployee(rset, CDBO,
					EList, mode, searchTerm, searchType, empCount, groups);
			frame.dispose();

		}

		else if (ae.getSource() == search && rdbtnSurname.isSelected() == true) {

			String searchTerm = SearchField.getText();
			String searchType = "Surname";

			searchResultEmployee RScreen = new searchResultEmployee(rset, CDBO,
					EList, mode, searchTerm, searchType, empCount, groups);
			frame.dispose();

		}

		else if (ae.getSource() == search
				&& rdbtnDepartment.isSelected() == true) {

			String searchTerm = SearchField.getText();
			String searchType = "Department";

			searchResultEmployee RScreen = new searchResultEmployee(rset, CDBO,
					EList, mode, searchTerm, searchType, empCount, groups);
			frame.dispose();

		}

	}
}
