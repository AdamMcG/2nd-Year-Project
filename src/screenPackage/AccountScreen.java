package screenPackage;

import hardCodePackage.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import databasePackage.CreateDBOperations;

public class AccountScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField textName, textEmployeeNo, Textemptitle, textDept,
			gender;
	private JTextArea textAddress;
	private String EmpNo;
	private JButton security, contract, password;
	private ResultSet s;
	private CreateDBOperations d;
	private EmployeeRegister r;
	private int count;
	private JTextField textField;
	private int mode;
	private ArrayList<String> groups;

	public AccountScreen(ResultSet s, CreateDBOperations d, EmployeeRegister r,
			String EmpNo, int mode, int empCount, ArrayList<String> groups) {
		this.r = r;
		this.s = s;
		this.d = d;
		this.EmpNo = EmpNo;
		this.mode = mode;
		this.count = empCount;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.RED);
		frame.getContentPane().setForeground(Color.GREEN);
		frame.setBounds(100, 100, 564, 603);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.RED);
		panel.setBounds(30, 23, 485, 465);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textName = new JTextField(30);
		textName.setEditable(false);
		textName.setBounds(106, 65, 181, 20);
		panel.add(textName);
		textName.setColumns(10);

		JLabel lblEmployeeNo = new JLabel("Name:");
		lblEmployeeNo.setForeground(Color.BLACK);
		lblEmployeeNo.setBackground(Color.GREEN);
		lblEmployeeNo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmployeeNo.setBounds(10, 64, 86, 20);
		panel.add(lblEmployeeNo);

		JLabel lblPassword = new JLabel("Emp.No:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(10, 95, 72, 17);
		panel.add(lblPassword);

		JLabel lblNewLabel = new JLabel("McRoched Industries");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 181, 32);
		panel.add(lblNewLabel);

		ButtonGroup a = new ButtonGroup();

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGender.setBounds(10, 123, 72, 23);
		panel.add(lblGender);

		JLabel lblEmpTitle = new JLabel("Emp. Title:");
		lblEmpTitle.setForeground(Color.BLACK);
		lblEmpTitle.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmpTitle.setBounds(10, 174, 72, 23);
		panel.add(lblEmpTitle);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.BLACK);
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDepartment.setBounds(10, 208, 72, 23);
		panel.add(lblDepartment);

		textEmployeeNo = new JTextField(30);
		textEmployeeNo.setEditable(false);
		textEmployeeNo.setBounds(106, 96, 181, 20);
		panel.add(textEmployeeNo);
		textEmployeeNo.setColumns(10);

		Textemptitle = new JTextField(3);
		Textemptitle.setEditable(false);
		Textemptitle.setBounds(106, 176, 190, 20);
		panel.add(Textemptitle);
		Textemptitle.setColumns(10);

		textDept = new JTextField(30);
		textDept.setEditable(false);
		textDept.setBounds(106, 207, 191, 20);
		panel.add(textDept);
		textDept.setColumns(10);

		textAddress = new JTextArea();
		textAddress.setEditable(false);
		textAddress.setBounds(106, 238, 269, 121);
		panel.add(textAddress);

		JLabel lblDescription = new JLabel("Address:");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescription.setBounds(10, 242, 72, 38);
		panel.add(lblDescription);

		password = new JButton("Reset Password");
		password.setBounds(332, 18, 143, 23);
		panel.add(password);
		password.addActionListener(this);

		contract = new JButton("Contract details");
		contract.setBounds(332, 82, 143, 23);
		panel.add(contract);
		contract.addActionListener(this);

		security = new JButton("Set Security Question");
		security.setBounds(332, 124, 143, 23);
		panel.add(security);

		if (mode == 2 && r.getEmployeeType(empCount) != "Admin") {
			security.setVisible(false);
			password.setVisible(false);
			contract.setVisible(false);
		}

		JLabel lblEmployeeDetails = new JLabel("Employee Details:");
		lblEmployeeDetails.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmployeeDetails.setBounds(10, 39, 108, 14);
		panel.add(lblEmployeeDetails);

		gender = new JTextField();
		gender.setEditable(false);
		gender.setBounds(106, 125, 181, 20);
		panel.add(gender);
		gender.setColumns(10);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();

			}
		});
		btnReturn.setBounds(198, 416, 89, 23);
		panel.add(btnReturn);
		security.addActionListener(this);

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

		try {
			s.first();
			setFirst();
		} catch (SQLException e) {
			System.out.println("BOB");
		}
	}

	public void setFirst() {
		try {

			for (int i = 0; i < r.EmployeeListSize(); i++) {
				if (EmpNo.equals(r.getEmployeeNum(i))) {

					User u = new User(r.getEmployeeName(i),
							r.getEmployeeSurName(i), r.getEmployeeAddress(i),
							r.getGender(i), r.getNationality(i),
							r.getEmployeeNum(i), r.GetContractLength(i),
							r.getEmployeeType(i), r.getEmployeePass(i),
							r.getSecretQ(i), r.getSecretA(i),
							r.getDepartment(i), r.getdNumber(i),
							r.getpNumber(i), r.getcNumber(i), r.gettNumber(i));
					textName.setText(u.getName() + " " + u.getLName());
					textEmployeeNo.setText(u.getEmployeeNumber());
					Textemptitle.setText(u.getEmployeeType());
					textDept.setText(u.getDepartment());
					textAddress.setText(u.getAddress());

				}
			}
			/*
			 * textName.setText((r.getEmployeeName(count)));
			 * textEmployeeNo.setText(r.getEmployeeNum(count));
			 * textPhone.setText("12");
			 * Textemptitle.setText(r.getEmployeeType(count));
			 * textDept.setText(r.getDepartment(count));
			 */

			if (r.getGender(count).equals("M")) {
				gender.setText("Male");
			} else {
				gender.setText("Female");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		if (ae.getSource() == security) {
			SecurityQuestionScreen s = new SecurityQuestionScreen();
			frame.dispose();

		} else if (ae.getSource() == password) {
			ResetPasswordScreen R = new ResetPasswordScreen();
			frame.dispose();
		} else if (ae.getSource() == contract) {
			frame.dispose();
			cScreen1 C = new cScreen1();

		}

	}
}
