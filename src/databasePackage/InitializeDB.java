package databasePackage;

import hardCodePackage.EmployeeRegister;

import java.sql.*;

import screenPackage.AccountScreen;
import screenPackage.loginScreen;
import databasePackage.CreateDBOperations;

public class InitializeDB {

	public static void main(String[] args) {

		CreateDBOperations a = new CreateDBOperations();
		a.openDB();
		a.dropTables();
		a.dropTableTeam();
		a.dropTableContract();
		a.dropTableEmp();
		a.dropTablePassword();
		a.buildtableDept();
		a.buildTableContract();
		a.buildTablePassword();
		a.buildTableTeam();
		a.buildEmployeeTable();
		a.CloseDB();

		System.out.println("\nDB initalized successfully");
		// a.buildTableGenericLeave();
		// a.buildTableLeaveHoliday();
		// ResultSet data = a.queryDBemp();
		/*
		 * // ResultSet data2 = a.queryDBPass(); ResultSet data =
		 * a.queryDBemp(); EmployeeRegister E = new EmployeeRegister(a);
		 * E.printList(); System.out.println(E.findEmployee("Test"));
		 * loginScreen s = new loginScreen(E, a, data);
		 * s.getFrame().setVisible(true);
		 */

	}

}
