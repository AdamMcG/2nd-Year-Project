package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.TeamManagement;
import hardCodePackage.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databasePackage.CreateDBOperations;

public class AddGroup extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField mem1, mem2, mem3, mem4, mem5;
	private JButton add, cancel;
	private TeamManagement createGroup;
	private EmployeeRegister e;
	private CreateDBOperations a;
	private JComboBox<String> combo1, combo2, combo3, combo4, combo5;
	private int comboIndex1, comboIndex2, comboIndex3, comboIndex4,
			comboIndex5, i;
	private TeamManagement t;
	private String teamName;
	private ResultSet rset;
	private String teamLead;
	private String teamDes;
	private int count;
	private int groupNum;
	private int groupCheck;
	private int compareNumInGroup;
	private ArrayList<String> groups;


	public AddGroup(int i, EmployeeRegister e, CreateDBOperations a,
			TeamManagement t, String name, ResultSet rset, int groupNum,
			ArrayList<String> groups) {
		this.i = i;
		this.groups = groups;
		
		this.e = e;
		this.a = a;
		this.t = t;
		this.rset = rset;
		teamName = name;
		this.groupNum = groupNum;
		System.out.println(groupNum);
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 628);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(35, 26, 724, 519);
		panel.add(panel_1);
		panel_1.setLayout(null);

		combo1 = new JComboBox<String>();
		combo1.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		combo1.setBounds(390, 167, 220, 20);
		panel_1.add(combo1);

		JLabel lblNewLabel = new JLabel("Team Mem 1.");
		lblNewLabel.setBounds(27, 122, 72, 34);
		panel_1.add(lblNewLabel);

		mem1 = new JTextField();
		mem1.setBounds(27, 167, 255, 20);
		panel_1.add(mem1);
		mem1.setBackground(Color.WHITE);
		mem1.setColumns(10);

		mem2 = new JTextField();
		mem2.setBounds(27, 223, 255, 20);
		panel_1.add(mem2);
		mem2.setText("");
		mem2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Team Mem 2.");
		lblNewLabel_1.setBounds(27, 182, 72, 34);
		panel_1.add(lblNewLabel_1);

		mem3 = new JTextField();
		mem3.setBounds(27, 270, 255, 20);
		panel_1.add(mem3);
		mem3.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Team Mem 3.");
		lblNewLabel_2.setBounds(27, 243, 72, 34);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Team Mem 4.");
		lblNewLabel_3.setBounds(27, 293, 72, 41);
		panel_1.add(lblNewLabel_3);

		combo2 = new JComboBox<String>();
		combo2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		combo2.setBounds(390, 223, 220, 20);
		panel_1.add(combo2);

		combo3 = new JComboBox<String>();
		combo3.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		combo3.setBounds(390, 270, 220, 20);
		panel_1.add(combo3);

		combo4 = new JComboBox<String>();
		combo4.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		combo4.setBounds(390, 327, 220, 20);
		panel_1.add(combo4);

		combo5 = new JComboBox<String>();
		combo5.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		combo5.setBounds(390, 394, 220, 20);
		panel_1.add(combo5);

		mem4 = new JTextField();
		mem4.setBounds(27, 327, 255, 20);
		panel_1.add(mem4);
		mem4.setColumns(10);

		mem5 = new JTextField();
		mem5.setBounds(27, 394, 255, 20);
		panel_1.add(mem5);
		mem5.setColumns(10);

		JLabel lblTeamMem = new JLabel("Team Mem 5.");
		lblTeamMem.setBounds(27, 355, 79, 41);
		panel_1.add(lblTeamMem);

		JLabel label = new JLabel("McRoched Industries");
		label.setBounds(10, 19, 181, 32);
		panel_1.add(label);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		cancel = new JButton("Cancel");
		cancel.setBounds(429, 449, 127, 34);
		panel_1.add(cancel);
		cancel.setBackground(new Color(255, 255, 204));
		cancel.setForeground(Color.BLACK);
		cancel.addActionListener(this);

		add = new JButton("Add");
		add.setBounds(102, 449, 127, 34);
		panel_1.add(add);
		add.setBackground(new Color(255, 255, 204));
		add.setForeground(Color.BLACK);
		add.addActionListener(this);

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
		menuBar.add(mnNewMenu_3);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			comboIndex1 = combo1.getSelectedIndex();
			comboIndex2 = combo2.getSelectedIndex();
			comboIndex3 = combo3.getSelectedIndex();
			comboIndex4 = combo4.getSelectedIndex();
			comboIndex5 = combo5.getSelectedIndex();
			createGroup = new TeamManagement(e, teamName, a);
			if (mem1.getText() != "") {
				compareNumInGroup++;
			}
			if (mem2.getText() != "") {
				compareNumInGroup++;
			}
			if (mem3.getText() != "") {
				compareNumInGroup++;
			}
			if (mem4.getText() != "") {
				compareNumInGroup++;
			}
			if (mem5.getText() != "") {
				compareNumInGroup++;
			}
			t.createGroup(mem1.getText(), mem2.getText(),
					mem3.getText(), mem4.getText(), mem5.getText());
			t.setPositions(comboIndex1, comboIndex2, comboIndex3,
					comboIndex4, comboIndex5);
			t.setComboxIndex(comboIndex1);
			t.setComboxIndex(comboIndex2);
			t.setComboxIndex(comboIndex3);
			t.setComboxIndex(comboIndex4);
			t.setComboxIndex(comboIndex5);

			t.printList();
			if (comboIndex1 == 1) {
				teamLead = mem1.getText();
			}
			t.addTeam(groupNum, teamName, teamDes, teamLead);
			count = groupNum;

			for (int i = 0; i < compareNumInGroup; i++) {
				System.out.println("Group num" + count);
				groupCheck = 0;
				if (groupNum > 2) {
					groupCheck++;
				}
				System.out.println("Group Check" + groupCheck);
				t.updateTeamNumber(groupCheck, 0);
				System.out.println(createGroup.getName(groupCheck, i));
			}
			TeamScreen test = new TeamScreen(e, a, i, rset, t, groups);
			frame.dispose();

		} else if (ae.getSource() == cancel) {
			frame.dispose();

		}

	}
}
