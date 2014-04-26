package hardCodePackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databasePackage.CreateDBOperations;

public class TeamManagement {
	private ArrayList<User> Team;
	private ArrayList<ArrayList<User>> TeamList;
	private ArrayList<String> teamPositions;
	private String teamName;
	private String managerName;
	private EmployeeRegister e;
	private int comboxIndex;
	private ArrayList<Integer> ComboxStorage;
	private CreateDBOperations a;
	private int teamNum;
	private String teamString;
	private ResultSet rset;

	public TeamManagement(EmployeeRegister e, String teamName,
			CreateDBOperations a) {
		this.e = e;
		this.teamName = teamName;
		TeamList = new ArrayList<ArrayList<User>>();
		this.a = a;
		ComboxStorage = new ArrayList<Integer>();
	}

	public void addTeam(int groupNum, String teamName, String teamDes,
			String teamLead) {
		teamNum = 2000 + groupNum;
		teamString = ("T" + teamNum);
		a.AddNewTeam(teamString, teamName, teamDes, teamLead);
	}

	public void updateTeamNumber(int j, int i) {
		System.out.println(j);
		TeamList.get(j).get(i).settNumber(teamString);
		a.updateTeam(TeamList.get(j).get(i).gettNumber(), TeamList.get(j)
				.get(i).getEmployeeNumber());

	}

	public void addToGroup(String memberToAdd) {
		int check = -1;
		if (memberToAdd != null) {
			check = e.findEmployee(memberToAdd);
		}
		if (check >= 0) {
			Team.add(e.ReturnEmployee(check));
		}
	}

	public void createGroup(String member1, String member2, String member3,
			String member4, String member5) {
		System.out.println("This is member one: " + member1);
		Team = new ArrayList<User>();
		addToGroup(member1);
		if (member2 != null)
			addToGroup(member2);
		if (member3 != null)
			addToGroup(member3);
		if (member4 != null)
			addToGroup(member4);
		if (member5 != null)
			addToGroup(member5);
		TeamList.add(Team);
		System.out.println(TeamList.isEmpty());
		for(int j = 0; j < TeamList.size(); j++)
		{
			for (int i = 0; i < TeamList.get(j).size(); i++) {
				System.out.println("Team member at:" +j+ " , " + i + "is: " + TeamList.get(j).get(i).getName());
			}
		}
	}

	public String getTeamName() {
		
		
		return teamName;
	}

	public void setTeamName(String teamName) {
		rset = a.queryDBteam(teamName);
		String s = null;
		try {
			s = rset.getString("tm_name");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		teamName = s;

	}

	public void setComboxIndex(int combindex) {
		comboxIndex = combindex;
		ComboxStorage.add(comboxIndex);
	}

	public int getComboIndex(int i) {
		return ComboxStorage.get(i);
	}

	public void setPositions(int comboIndex1, int comboIndex2, int comboIndex3,
			int comboIndex4, int comboIndex5) {
		teamPositions = new ArrayList<String>();
		teamPositions.add(addPosition(comboIndex1));
		teamPositions.add(addPosition(comboIndex2));
		teamPositions.add(addPosition(comboIndex3));
		teamPositions.add(addPosition(comboIndex4));
		teamPositions.add(addPosition(comboIndex5));

	}

	public String addPosition(int comboIndex) {
		String position = "Filler";
		if (comboIndex == 1) {
			position = "Project Manager";
		} else if (comboIndex == 2) {
			position = "Vice-Manager";
		} else if (comboIndex == 3) {
			position = "Marketing";
		} else if (comboIndex == 4) {
			position = "Programming ";
		} else if (comboIndex == 5) {
			position = "Recruitment";
		}
		return position;
	}

	public void printList() {
		for (int i = 0; i < Team.size(); i++)
			System.out.println(getTeamName() + "\n" + TeamList.size()
					+ TeamList.get(0).get(i).getName() + teamPositions.get(i));
	}

	public String getName(int Arrayindex1, int arrayIndex2) {
		String s;
		try {
			s = TeamList.get(Arrayindex1).get(arrayIndex2).getName();
		} catch (Exception e) {
			s = null;
		}
		System.out.println(s);
		return s;
	}

	public void fillRegister() {

		rset = a.queryDBteam2();
		// ResultSet rsetPass = cDBo.queryDBPass();
		// ResultSet rsetDep = cDBo.queryDB();

		try {
			rset.first();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		try {
			rset.beforeFirst();
			while (rset.next() == true) {
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
