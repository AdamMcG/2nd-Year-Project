package screenPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.TeamManagement;
import hardCodePackage.User;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databasePackage.CreateDBOperations;

public class TeamScreen extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField mem1, mem2, mem3, mem4, mem5, groupName;
	private JComboBox<String> groupBox, positionSelect1, positionSelect2,
			positionSelect3, positionSelect4, positionSelect5;
	private JButton add, cancel, delete;
	private EmployeeRegister e;
	private CreateDBOperations a;
	private int i;
	private ResultSet rset;
	private TeamManagement t;
	private String teamName;
	private ArrayList<String> groups;
	
	public TeamScreen(EmployeeRegister e, CreateDBOperations a, int i,
			ResultSet rset, TeamManagement t, ArrayList<String> groups) {
		this.groups = groups;
		this.t = t;
		this.e = e;
		this.a = a;
		this.i = i;
		this.rset = rset;
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

		positionSelect1 = new JComboBox<String>();
		positionSelect1.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		positionSelect1.setBounds(390, 167, 220, 20);
		panel_1.add(positionSelect1);

		JLabel lblNewLabel = new JLabel("Team Mem 1.");
		lblNewLabel.setBounds(27, 132, 181, 24);
		panel_1.add(lblNewLabel);

		mem1 = new JTextField();
		mem1.setEditable(false);
		mem1.setBounds(27, 167, 255, 20);
		panel_1.add(mem1);
		mem1.setBackground(Color.WHITE);
		mem1.setColumns(10);

		mem2 = new JTextField();
		mem2.setEditable(false);
		mem2.setBounds(27, 223, 255, 20);
		panel_1.add(mem2);
		mem2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Team Mem 2.");
		lblNewLabel_1.setBounds(27, 195, 164, 24);
		panel_1.add(lblNewLabel_1);

		mem3 = new JTextField();
		mem3.setEditable(false);
		mem3.setBounds(27, 270, 255, 20);
		panel_1.add(mem3);
		mem3.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Team Mem 3.");
		lblNewLabel_2.setBounds(27, 242, 164, 24);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Team Mem 4.");
		lblNewLabel_3.setBounds(27, 293, 181, 34);
		panel_1.add(lblNewLabel_3);

		positionSelect2 = new JComboBox<String>();
		positionSelect2.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		positionSelect2.setBounds(390, 223, 220, 20);
		panel_1.add(positionSelect2);

		positionSelect3 = new JComboBox<String>();
		positionSelect3.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		positionSelect3.setBounds(390, 270, 220, 20);
		panel_1.add(positionSelect3);

		positionSelect4 = new JComboBox<String>();
		positionSelect4.setModel(new DefaultComboBoxModel<String>(new String[] {
				"                   ", "Project Manager", "Vice-Manager",
				"Marketing", "Programming ", "Recruitment" }));
		positionSelect4.setBounds(390, 327, 220, 20);
		panel_1.add(positionSelect4);

		positionSelect5 = new JComboBox<String>();
		positionSelect5.setModel(new DefaultComboBoxModel<String>(new String[] {
				"     ", "Project Manager", "Vice-Manager", "Marketing",
				"Programming ", "Recruitment" }));
		positionSelect5.setBounds(390, 394, 220, 20);
		panel_1.add(positionSelect5);

		groupBox = new JComboBox<String>();
		for (int j = 0; j < groups.size(); j++) {
			groupBox.addItem(groups.get(j));
		}
		groupBox.setBounds(510, 27, 125, 24);
		panel_1.add(groupBox);
		groupBox.setSelectedIndex(0);
		groupBox.addActionListener(this);

		delete = new JButton("Delete Group");
		delete.setBounds(510, 448, 109, 45);
		panel_1.add(delete);

		JLabel lblGroupName = new JLabel("Group Name:");
		lblGroupName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGroupName.setBounds(24, 76, 86, 35);
		panel_1.add(lblGroupName);

		groupName = new JTextField();
		groupName.setEditable(false);
		groupName.setFont(new Font("Arial", Font.PLAIN, 13));
		groupName.setBounds(151, 76, 187, 35);
		panel_1.add(groupName);
		groupName.setColumns(10);

		mem4 = new JTextField();
		mem4.setEditable(false);
		mem4.setBounds(27, 327, 255, 20);
		panel_1.add(mem4);
		mem4.setColumns(10);

		mem5 = new JTextField();
		mem5.setEditable(false);
		mem5.setBounds(27, 394, 255, 20);
		panel_1.add(mem5);
		mem5.setColumns(10);

		JLabel lblTeamMem = new JLabel("Team Mem 5.");
		lblTeamMem.setBounds(27, 355, 164, 41);
		panel_1.add(lblTeamMem);

		JLabel label = new JLabel("McRoched Industries");
		label.setBounds(10, 19, 181, 32);
		panel_1.add(label);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		cancel = new JButton("Cancel");
		cancel.setBounds(111, 448, 131, 34);
		panel_1.add(cancel);
		cancel.setBackground(new Color(255, 255, 204));
		cancel.setForeground(Color.BLACK);
		cancel.addActionListener(this);

		add = new JButton("Add New Team");
		add.setBounds(510, 76, 125, 29);
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
		if (groupBox.getSelectedIndex() == 0) {
			groupName.setText("Group 1");
			mem1.setText("bob");
			mem2.setText("Joe");
			mem3.setText("Hernadoe");
			mem4.setText("Bob2");
			mem5.setText("Joqwatr");
			positionSelect1.setSelectedIndex(1);
			positionSelect2.setSelectedIndex(2);
			positionSelect3.setSelectedIndex(3);
			positionSelect4.setSelectedIndex(4);
			positionSelect5.setSelectedIndex(5);
		} else {
			mem1.setText("");
			mem2.setText("");
			mem3.setText("");
			mem4.setText("");
			mem5.setText("");
			positionSelect1.setSelectedIndex(0);
			positionSelect2.setSelectedIndex(0);
			positionSelect3.setSelectedIndex(0);
			positionSelect4.setSelectedIndex(0);
			positionSelect5.setSelectedIndex(0);
		}

	}

	public void addToGroupBox(String name) {
		groups.add(name);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancel) {
			HomeScreen h = new HomeScreen(e, i, a, t, rset, groups);
			frame.dispose();
		} else if (ae.getSource() == add) {
			if (groupBox.getItemCount() >= 5) {
				JOptionPane.showMessageDialog(null,
						"You already have your maximum number of teams. ",
						"EmployeeRoster", JOptionPane.WARNING_MESSAGE);

			} else {
				String b = JOptionPane.showInputDialog(null,
						"Enter the name of the team you wish to create. ",
						"EmployeeRoster", JOptionPane.QUESTION_MESSAGE);
				teamName = b;
				addToGroupBox(b);
				System.out.println(groups.size());
				int groupNum = groups.size()-1;
				AddGroup AG = new AddGroup(i, e, a, t, teamName, rset,
						groupNum, groups);
				frame.dispose();
			}
		}

		else if (ae.getSource() == groupBox) {
			if (groupBox.getSelectedIndex() == 0) {
				groupName.setText("Group 1");
				mem1.setText("Bob");
				mem2.setText("Joe");
				mem3.setText("Hernadoe");
				mem4.setText("Bob2");
				mem5.setText("Joqwatr");
				positionSelect1.setSelectedIndex(1);
				positionSelect2.setSelectedIndex(2);
				positionSelect3.setSelectedIndex(3);
				positionSelect4.setSelectedIndex(4);
				positionSelect5.setSelectedIndex(5);
			} else if (groupBox.getSelectedIndex() == 1) {
				String s = t.getTeamName();
				groupName.setText(s);
				mem1.setText(t.getName(0, 0));
				mem2.setText(t.getName(0, 1));
				mem3.setText(t.getName(0, 2));
				mem4.setText(t.getName(0, 3));
				mem5.setText(t.getName(0, 4));
				positionSelect1.setSelectedIndex(t.getComboIndex(0));
				positionSelect2.setSelectedIndex(t.getComboIndex(1));
				positionSelect3.setSelectedIndex(t.getComboIndex(2));
				positionSelect4.setSelectedIndex(t.getComboIndex(3));
				positionSelect5.setSelectedIndex(t.getComboIndex(4));
			}
			else if (groupBox.getSelectedIndex() == 2) {
				String s = t.getTeamName();
				groupName.setText(s);
				mem1.setText(t.getName(1, 0));
				mem2.setText(t.getName(1, 1));
				mem3.setText(t.getName(1, 2));
				mem4.setText(t.getName(1, 3));
				mem5.setText(t.getName(1, 4));
				positionSelect1.setSelectedIndex(t.getComboIndex(0));
				positionSelect2.setSelectedIndex(t.getComboIndex(1));
				positionSelect3.setSelectedIndex(t.getComboIndex(2));
				positionSelect4.setSelectedIndex(t.getComboIndex(3));
				positionSelect5.setSelectedIndex(t.getComboIndex(4));
			}
			else if (groupBox.getSelectedIndex() == 3) {
				String s = t.getTeamName();
				groupName.setText(s);
				mem1.setText(t.getName(2, 0));
				mem2.setText(t.getName(2, 1));
				mem3.setText(t.getName(2, 2));
				mem4.setText(t.getName(2, 3));
				mem5.setText(t.getName(2, 4));
				positionSelect1.setSelectedIndex(t.getComboIndex(0));
				positionSelect2.setSelectedIndex(t.getComboIndex(1));
				positionSelect3.setSelectedIndex(t.getComboIndex(2));
				positionSelect4.setSelectedIndex(t.getComboIndex(3));
				positionSelect5.setSelectedIndex(t.getComboIndex(4));
			}
			else if (groupBox.getSelectedIndex() == 4) {
				String s = t.getTeamName();
				groupName.setText(s);
				mem1.setText(t.getName(3, 0));
				mem2.setText(t.getName(3, 1));
				mem3.setText(t.getName(3, 2));
				mem4.setText(t.getName(3, 3));
				mem5.setText(t.getName(3, 4));
				positionSelect1.setSelectedIndex(t.getComboIndex(0));
				positionSelect2.setSelectedIndex(t.getComboIndex(1));
				positionSelect3.setSelectedIndex(t.getComboIndex(2));
				positionSelect4.setSelectedIndex(t.getComboIndex(3));
				positionSelect5.setSelectedIndex(t.getComboIndex(4));
			}
			else if(groupBox.getSelectedIndex() == 5)
			{
				String s = t.getTeamName();
				groupName.setText(s);
				mem1.setText(t.getName(4, 0));
				mem2.setText(t.getName(4, 1));
				mem3.setText(t.getName(4, 2));
				mem4.setText(t.getName(4, 3));
				mem5.setText(t.getName(4, 4));
				positionSelect1.setSelectedIndex(t.getComboIndex(0));
				positionSelect2.setSelectedIndex(t.getComboIndex(1));
				positionSelect3.setSelectedIndex(t.getComboIndex(2));
				positionSelect4.setSelectedIndex(t.getComboIndex(3));
				positionSelect5.setSelectedIndex(t.getComboIndex(4));
			
			}
			
		} else {
			groupName.setText("");
			mem1.setText("");
			mem2.setText("");
			mem3.setText("");
			mem4.setText("");
			mem5.setText("");
			positionSelect1.setSelectedIndex(0);
			positionSelect2.setSelectedIndex(0);
			positionSelect3.setSelectedIndex(0);
			positionSelect4.setSelectedIndex(0);
			positionSelect5.setSelectedIndex(0);
		}

	}

}
