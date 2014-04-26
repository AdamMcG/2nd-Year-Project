package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.User;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import databasePackage.CreateDBOperations;

public class searchResultEmployee extends JFrame implements ActionListener {

	private JFrame frame;
	private int mode, empCount;
	private EmployeeRegister EList;
	private CreateDBOperations CDBO;
	private ResultSet rset;
	private JButton Select, Cancel;
	private String searchTerm, searchType;
	private Vector columnNames, rows, data;
	private JTable table;
	User user;
	ArrayList<User> searchResult = new ArrayList();
	ArrayList<String> groups;

	public searchResultEmployee(ResultSet rset, CreateDBOperations CDBO,
			EmployeeRegister EList, int mode, String searchTerm,
			String searchType, int empCount, ArrayList<String> groups) {
		this.groups = groups;
		this.EList = EList;
		this.rset = rset;
		this.CDBO = CDBO;
		this.searchTerm = searchTerm;
		this.searchType = searchType;
		this.mode = mode;
		this.empCount = empCount;
		columnNames = new Vector();
		data = new Vector();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.RED);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 573, 479);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.RED);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("McRoched Industries");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		Select = new JButton("Select");
		Select.addActionListener(this);
		panel_1.add(Select);

		Cancel = new JButton("Cancel");
		Cancel.addActionListener(this);
		panel_1.add(Cancel);

		JScrollPane scrollPane = new JScrollPane(populateTable());
		panel.add(scrollPane, BorderLayout.CENTER);

		ButtonGroup b = new ButtonGroup();

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Team");
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);
		frame.setVisible(true);

	}

	public JTable populateTable() {
		if (searchType.equals("FName")) {

			rset = CDBO.findEmployee(searchTerm, "FName");
		} else if (searchType.equals("Surname")) {
			rset = CDBO.findEmployee(searchTerm, "Surname");
		} else if (searchType.equals("Department")) {
			rset = CDBO.findEmployee(searchTerm, "Department");
		}
		try {
			rset.beforeFirst();
			while (rset.next() == true) {

				System.out.println(rset.getString("EMPLOYEEID"));
				System.out.println("==================");

				User u = new User(rset.getString("EM_FNAME"),
						rset.getString("EM_LNAME"),
						rset.getString("EM_ADDRESS"),
						rset.getString("EM_GENDER"),
						rset.getString("EM_NATIONALITY"),
						rset.getString("EMPLOYEEID"),
						rset.getDouble("EM_CONTRACTLENGTH"),
						EList.setStaff(rset), rset.getString("PASSWORD"),
						rset.getString("PASS_SECRETQ"),
						rset.getString("PASS_SECRETA"),
						rset.getString("DEP_NAME"),
						rset.getString("DEPARTMENTID"),
						rset.getString("PASSWORDID"),
						rset.getString("CONTRACTID"), rset.getString("TEAMID"));
				searchResult.add(u);
				System.out.println(u.getEmployeeNumber());

			}

			if (searchType.equals("FName")) {

				rset = CDBO.displayEmployee(searchTerm, "FName");
			} else if (searchType.equals("Surname")) {
				rset = CDBO.displayEmployee(searchTerm, "Surname");
			} else if (searchType.equals("Department")) {
				rset = CDBO.displayEmployee(searchTerm, "Department");
			}

			ResultSetMetaData md;

			md = rset.getMetaData();
			int columns = md.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(md.getColumnName(i));
			}

			while (rset.next()) {
				Vector row = new Vector(columns);

				/*
				 * User u = new User(rset.getString("EM_FNAME"),
				 * rset.getString("EM_LNAME"),rset.getString("EM_ADDRESS"),
				 * rset.getString("EM_GENDER"),
				 * rset.getString("EM_NATIONALITY"),
				 * rset.getString("EMPLOYEEID"),
				 * rset.getDouble("EM_CONTRACTLENGTH"), EList.setStaff(rset),
				 * rset.getString("PASSWORD"), rset.getString("DEP_NAME"),
				 * rset.getString("DEPARTMENTID"), rset.getString("PASSWORDID"),
				 * rset.getString("CONTRACTID"), rset.getString("TEAMID"));
				 * searchResult.add(u);
				 */

				for (int i = 1; i <= columns; i++) {
					row.addElement(rset.getObject(i));
				}

				data.addElement(row);
			}

			table = new JTable(data, columnNames) {
				public Class getColumnClass(int column) {
					for (int row = 0; row < getRowCount(); row++) {
						Object o = getValueAt(row, column);

						if (o != null) {
							return o.getClass();
						}
					}

					return Object.class;
				}
			};

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return table;

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == Select && mode == 0) {

			System.out.println(table.getSelectedRow());
			user = searchResult.get(table.getSelectedRow());
			UpdateScreen US = new UpdateScreen(user, EList, rset, CDBO);
			frame.dispose();

		}

		else if (ae.getSource() == Select && mode == 1) {

			user = searchResult.get(table.getSelectedRow());

			JOptionPane Pane = new JOptionPane();

			int reply = JOptionPane.showConfirmDialog(null,
					"Are you sure you wish to delete this Employee?",
					"Deletion Confirmation", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				CDBO.deleteEmployee(user.getEmployeeNumber());
				frame.dispose();
			}

		}

		else if (ae.getSource() == Select && mode == 2) {

			user = searchResult.get(table.getSelectedRow());

			AccountScreen s = new AccountScreen(rset, CDBO, EList,
					user.getEmployeeNumber(), 1, empCount, groups);
			frame.dispose();

		}

		else if (ae.getSource() == Cancel) {
			frame.dispose();
		}

	}
}