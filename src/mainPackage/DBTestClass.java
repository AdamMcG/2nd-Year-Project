package mainPackage;

import hardCodePackage.EmployeeRegister;
import hardCodePackage.TeamManagement;
import hardCodePackage.User;

import java.sql.*;
import java.util.ArrayList;

import screenPackage.AccountScreen;
import screenPackage.loginScreen;
import databasePackage.CreateDBOperations;

public class DBTestClass {

	public static void main(String[] args) {
		CreateDBOperations a = new CreateDBOperations();
		a.openDB();
		/*
		 * a.dropTables(); a.dropTableTeam(); a.dropTableContract();
		 * a.dropTableEmp(); a.dropTablePassword(); a.buildtableDept(); //Error
		 * here. a.buildTableContract(); a.buildTablePassword();
		 * a.buildTableTeam(); a.buildEmployeeTable();
		 */// a.buildTableGenericLeave();
			// a.buildTableLeaveHoliday();
			// ResultSet data = a.queryDBemp();
			// ResultSet data2 = a.queryDBPass();
		ResultSet data = a.queryDBemp();
		EmployeeRegister E = new EmployeeRegister(a);
		ArrayList<ArrayList<User>> teamList = new ArrayList<ArrayList<User>>();
		TeamManagement t = new TeamManagement(E, "Group1", a);
		E.printList();
		System.out.println(E.findEmployee("Test1"));
		loginScreen s = new loginScreen(E, a, data, t);
		s.getFrame().setVisible(true);
		// a.CloseDB();
	}

}
