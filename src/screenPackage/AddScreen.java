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
import java.sql.SQLException;

import databasePackage.CreateDBOperations;

public class AddScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField textName, textEmpTitle, textDepartment,
			textContractDateStart, textContractLength;
	private JButton cancel, add;
	private JTextArea description, adField;
	private JRadioButton genderMale, genderFemale;
	private EmployeeRegister EList;
	private CreateDBOperations ad;
	private ResultSet data;
	private String gender = "F";
	private boolean male;
	private JPasswordField PasswordField;
	private String a;
	private String m;
	private int empCounty;
	private User user;
	private JTextField text_LName;
	private JTextField SecretA;
	private JComboBox SecretQBox;

	public AddScreen(ResultSet data, CreateDBOperations ad,
			EmployeeRegister EList) {
		this.EList = EList;
		this.data = data;
		this.ad = ad;
		this.empCounty = EList.EmployeeListSize();
		 frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.RED);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(0, 0, 573, 728);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 507, 651);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.RED);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textName = new JTextField();
		textName.setBackground(Color.WHITE);
		textName.setBounds(106, 79, 101, 20);
		panel.add(textName);
		textName.setColumns(10);

		JLabel lblEmployeeNo = new JLabel("First Name:");
		lblEmployeeNo.setForeground(Color.BLACK);
		lblEmployeeNo.setBackground(Color.WHITE);
		lblEmployeeNo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmployeeNo.setBounds(10, 78, 86, 20);
		panel.add(lblEmployeeNo);

		JLabel lblNewLabel = new JLabel("McRoched Industries");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 35, 181, 32);
		panel.add(lblNewLabel);

		genderMale = new JRadioButton("Male");
		genderMale.setBounds(109, 177, 54, 23);
		panel.add(genderMale);
		genderMale.addActionListener(this);
		genderFemale = new JRadioButton("Female");
		genderFemale.setBounds(183, 177, 70, 23);
		panel.add(genderFemale);
		ButtonGroup b = new ButtonGroup();
		b.add(genderMale);
		b.add(genderFemale);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGender.setBounds(10, 177, 72, 23);
		panel.add(lblGender);

		JLabel lblEmpTitle = new JLabel("Emp. Title:");
		lblEmpTitle.setForeground(Color.BLACK);
		lblEmpTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmpTitle.setBounds(10, 211, 72, 23);
		panel.add(lblEmpTitle);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDepartment.setBounds(10, 245, 72, 23);
		panel.add(lblDepartment);

		textEmpTitle = new JTextField();
		textEmpTitle.setBounds(106, 213, 136, 20);
		panel.add(textEmpTitle);
		textEmpTitle.setColumns(10);

		textDepartment = new JTextField();
		textDepartment.setBounds(105, 247, 137, 20);
		panel.add(textDepartment);
		textDepartment.setColumns(10);

		add = new JButton("Add");
		add.addActionListener(this);
		add.setBounds(10, 591, 101, 33);
		panel.add(add);

		cancel = new JButton("Cancel");
		cancel.setBounds(193, 591, 120, 33);
		panel.add(cancel);
		cancel.addActionListener(this);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.setBounds(10, 279, 351, 171);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblContractStartDate = new JLabel("Contract Start date");
		lblContractStartDate.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContractStartDate.setBounds(10, 11, 117, 24);
		panel_1.add(lblContractStartDate);

		textContractDateStart = new JTextField();
		textContractDateStart.setBounds(153, 14, 117, 20);
		panel_1.add(textContractDateStart);
		textContractDateStart.setColumns(10);

		JLabel lblContracg = new JLabel("Contract Length");
		lblContracg.setFont(new Font("Arial", Font.PLAIN, 13));
		lblContracg.setBounds(10, 51, 117, 24);
		panel_1.add(lblContracg);

		textContractLength = new JTextField();
		textContractLength.setBounds(153, 53, 117, 20);
		panel_1.add(textContractLength);
		textContractLength.setColumns(10);

		JLabel lblContractDescription = new JLabel("Contract Description");
		lblContractDescription.setFont(new Font("Arial", Font.PLAIN, 13));
		lblContractDescription.setBounds(10, 90, 135, 24);
		panel_1.add(lblContractDescription);

		description = new JTextArea();
		description.setBounds(153, 91, 157, 69);
		panel_1.add(description);

		PasswordField = new JPasswordField();
		PasswordField.setBounds(128, 461, 136, 20);
		panel.add(PasswordField);
		PasswordField.setColumns(10);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword_1.setBounds(10, 461, 69, 17);
		panel.add(lblPassword_1);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAddress.setBounds(10, 93, 59, 30);
		panel.add(lblAddress);

		JLabel Surname = new JLabel("Surname:");
		Surname.setForeground(Color.BLACK);
		Surname.setFont(new Font("Arial", Font.PLAIN, 13));
		Surname.setBackground(Color.WHITE);
		Surname.setBounds(229, 79, 86, 20);
		panel.add(Surname);

		text_LName = new JTextField();
		text_LName.setColumns(10);
		text_LName.setBackground(Color.WHITE);
		text_LName.setBounds(325, 80, 101, 20);
		panel.add(text_LName);

		adField = new JTextArea();
		adField.setBounds(107, 102, 181, 64);
		panel.add(adField);
		
		JLabel label = new JLabel("Secret Answer:");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 525, 86, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Secret Question:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 484, 101, 30);
		panel.add(label_1);
		
		SecretQBox = new JComboBox();
		SecretQBox.setModel(new DefaultComboBoxModel(new String[] {"Mother's maiden name?", "First pet's name?", "Best Friend?", "Place of Birth?"}));
		SecretQBox.setBounds(128, 492, 146, 20);
		panel.add(SecretQBox);
		
		SecretA = new JTextField();
		SecretA.setColumns(10);
		SecretA.setBounds(128, 524, 136, 20);
		panel.add(SecretA);

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

	public int empCounter() {
		int empcounter;
		if (textEmpTitle.getText().equalsIgnoreCase("Admin")) {
			m = "Y";
			a = "N";
			empcounter = 15000;
		} else if (textEmpTitle.getText().equalsIgnoreCase("Manager")) {
			m = "N";
			a = "Y";
			empcounter = 13000;
		} else {
			empcounter = 10000;
		}
		empCounty++;
		empcounter = empcounter + empCounty;

		return empcounter;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancel) {
			frame.dispose();

		}
		if (ae.getSource() == genderMale) {
			gender = "M";
		} else if (ae.getSource() == add) {
			addNewUser();
		}
	}

	public void addNewUser() {
		try {
			int emp = empCounter();
			String empNumber = "E" + emp;
			String pNumber = "P" + emp;
			String dNumber = "D15001";
			String cNumber = "C" + emp;
			String tNumber = "T15001";
			String name = textName.getText();
			String surname = text_LName.getText();
			String address = adField.getText();
			String title = textEmpTitle.getText();
			String pass = PasswordField.getText();
			String dept = textDepartment.getText();
			String secretQ = (String) SecretQBox.getSelectedItem();
			String secretA = SecretA.getText();
			
			double contract = Double.parseDouble(textContractLength.getText());
			String contractL = ("" + contract);

			user = new User(name, surname, address, gender, "Ireland",
					empNumber, contract, title, pass, secretQ, secretA, dept,
					dNumber, pNumber,cNumber, tNumber);
			System.out.println(user.getName());

			EList.AddUserToRegistry(user);
			ad.addEmp(user);
			ad.addPass(user);
			data.first();
			data = ad.queryDBemp();
			for(int i = 0; i < EList.EmployeeListSize(); i++)
			{
				System.out.println(EList.getEmployeeName(i));
			}
			System.out.println(EList.EmployeeListSize());
			data.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
