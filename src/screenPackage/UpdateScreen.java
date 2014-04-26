package screenPackage;
import hardCodePackage.EmployeeRegister;
import hardCodePackage.Manager;
import hardCodePackage.User;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

import databasePackage.CreateDBOperations;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class UpdateScreen extends JFrame implements ActionListener {

	private JFrame frmUpdateEmployee;
	private JTextField NameField, EmTitleField;
	private JTextArea AddressField;
	private JButton cancel, Update;
	private JRadioButton genderMale, genderFemale, rdbtnAdmin , rdbtnManager, rdbtnStaff ;
	private EmployeeRegister EList;
	private ResultSet data;
	private CreateDBOperations a;
	private String gender = "F";
	private boolean male;
	private User u;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField DepField;
	private JTextField txtSurname;

	public UpdateScreen(User u, EmployeeRegister e, ResultSet data, CreateDBOperations a) {
		
		this.data = data;
		this.a = a;
		this.u = u;
		EList = e;
		
		frmUpdateEmployee = new JFrame();
		frmUpdateEmployee.setTitle("Update Employee");
		frmUpdateEmployee.getContentPane().setBackground(Color.DARK_GRAY);
		frmUpdateEmployee.setForeground(Color.RED);
		frmUpdateEmployee.getContentPane().setForeground(Color.WHITE);
		frmUpdateEmployee.setBounds(100, 100, 658, 660);
		frmUpdateEmployee.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frmUpdateEmployee.getContentPane().setLayout(null);
		frmUpdateEmployee.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 34, 507, 565);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.RED);
		frmUpdateEmployee.getContentPane().add(panel);
		panel.setLayout(null);

		NameField = new JTextField();
		NameField.setText(u.getName());
		NameField.setBackground(Color.WHITE);
		NameField.setBounds(106, 107, 101, 20);
		panel.add(NameField);
		NameField.setColumns(10);

		JLabel lblEmployeeNo = new JLabel("First Name:");
		lblEmployeeNo.setForeground(Color.BLACK);
		lblEmployeeNo.setBackground(Color.WHITE);
		lblEmployeeNo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmployeeNo.setBounds(10, 106, 86, 20);
		panel.add(lblEmployeeNo);

		JLabel lblNewLabel = new JLabel("McRoched Industries");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 35, 181, 32);
		panel.add(lblNewLabel);

		
		genderMale = new JRadioButton("Male");
		genderMale.setBounds(106, 132, 54, 23);
		panel.add(genderMale);
		genderMale.addActionListener(this);
		genderFemale = new JRadioButton("Female");
		genderFemale.setBounds(178, 132, 70, 23);
		panel.add(genderFemale);
		ButtonGroup b = new ButtonGroup();
		b.add(genderMale);
		b.add(genderFemale);
		
		if (u.getGender().equalsIgnoreCase("M")){
			boolean male = true;
		}

		if (male = true){
			genderMale.setSelected(true);
		}
		else if (male = false){
			genderFemale.setSelected(true);
		}
		
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGender.setBounds(10, 135, 72, 23);
		panel.add(lblGender);

		JLabel lblEmpTitle = new JLabel("Emp. Title:");
		lblEmpTitle.setForeground(Color.BLACK);
		lblEmpTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmpTitle.setBounds(10, 169, 72, 23);
		panel.add(lblEmpTitle);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDepartment.setBounds(10, 199, 72, 23);
		panel.add(lblDepartment);

		EmTitleField = new JTextField();
		EmTitleField.setText(u.getEmployeeType());
		EmTitleField.setBounds(106, 171, 136, 20);
		panel.add(EmTitleField);
		EmTitleField.setColumns(10);

		Update = new JButton("Update");
		Update.addActionListener(this);
		Update.setBounds(10, 516, 101, 33);
		panel.add(Update);

		cancel = new JButton("Cancel");
		cancel.setBounds(190, 516, 120, 33);
		panel.add(cancel);
		
		JLabel lblAddress = new JLabel("Home Address:");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAddress.setBounds(10, 235, 107, 14);
		panel.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 258, 238, 158);
		panel.add(scrollPane);
		
		AddressField = new JTextArea();
		AddressField.setText(u.getAddress());
		scrollPane.setViewportView(AddressField);
		
		rdbtnManager = new JRadioButton("Manager");
		buttonGroup.add(rdbtnManager);
		rdbtnManager.setBounds(10, 458, 77, 23);
		panel.add(rdbtnManager);
		
		rdbtnAdmin = new JRadioButton("Admin");
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(130, 458, 77, 23);
		panel.add(rdbtnAdmin);
		

		rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setBounds(242, 458, 77, 23);
		panel.add(rdbtnStaff);
		cancel.addActionListener(this);

		System.out.println(u.getEmployeeType());
		if (u.getEmployeeType().equalsIgnoreCase("Admin")){
			rdbtnAdmin.setSelected(true);
		}
		else if (u.getEmployeeType().equalsIgnoreCase("Manager")){
			rdbtnManager.setSelected(true);
		}
		else {
			rdbtnStaff.setSelected(true);
		}
		
		DepField = new JTextField();
		DepField.setText(u.getDepartment());
		DepField.setBounds(106, 201, 136, 20);
		panel.add(DepField);
		DepField.setColumns(10);
		
		JLabel lblEditingDetailsOf = new JLabel("Editing Details of " + u.getEmployeeNumber());
		lblEditingDetailsOf.setFont(new Font("Arial", Font.BOLD, 12));
		lblEditingDetailsOf.setBounds(10, 72, 181, 20);
		panel.add(lblEditingDetailsOf);
		
		txtSurname = new JTextField();
		txtSurname.setText(u.getLName());
		txtSurname.setColumns(10);
		txtSurname.setBackground(Color.WHITE);
		txtSurname.setBounds(288, 107, 101, 20);
		panel.add(txtSurname);
		
		JLabel label = new JLabel("Surname:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.PLAIN, 13));
		label.setBackground(Color.WHITE);
		label.setBounds(217, 106, 86, 20);
		panel.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		frmUpdateEmployee.setJMenuBar(menuBar);

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
		frmUpdateEmployee.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancel) {
			frmUpdateEmployee.dispose();

			
			
		}
		
		if (ae.getSource() == Update) {
			
			System.out.println("Updating...");
			
			String name = NameField.getText();
			String LName = txtSurname.getText();
			String address = AddressField.getText();
			String gender;
			
			String manager;
			String admin;
			
			if (genderMale.isSelected() == true){
				gender = "M";
			}
			else gender = "F";
			
			if (rdbtnManager.isSelected() == true){
				manager = "Y";
				admin = "N";
			}
			else if (rdbtnAdmin.isSelected() == true){
				manager = "Y";
				admin = "Y";
			}
			else {
				manager = "N";
				admin = "N";
			}
			
			
			if (u.getEmployeeNumber() == "15001" && rdbtnAdmin.isSelected() == false){

				JOptionPane.showMessageDialog(null,
						"Cannot demote system Admin", "EmployeeRoster",
						JOptionPane.PLAIN_MESSAGE);
				
			}
			
			String department = DepField.getText();
			String nationality = "Ireland";
			String employeeType = u.getEmployeeType();
			String employeeNum = u.getEmployeeNumber();
			
			//	public void updateEmp (String name, String LName, String Address, String gender, String nationality, String employeeNumber, String employeeType,String manager, String admin, String deparment ){

			
			a.updateEmp(name,LName, address, gender, nationality, employeeNum, manager, admin, department);
			EList.fillRegister();
			

			JOptionPane.showMessageDialog(null,
					"Updated Employee", "EmployeeRoster",
					JOptionPane.PLAIN_MESSAGE);
			
			frmUpdateEmployee.dispose();
		}
		 
		

	}
}
