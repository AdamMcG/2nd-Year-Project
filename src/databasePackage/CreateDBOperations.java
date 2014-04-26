package databasePackage;

import hardCodePackage.User;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class CreateDBOperations {
	private Connection conn;
	private ResultSet rset;
	private PreparedStatement pstmt;
	int i2 = 123456790;
	int i = 2;
	private String number;
	int empcounter;

	public void openDB() {
		try {
			OracleDataSource ods = new OracleDataSource();

			// home Database
			ods.setURL("jdbc:oracle:thin:proje/proje@localhost:1521/xe");
			ods.setUser("adam");
			ods.setPassword("luke1712");

			// Tallaght Database
			// ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
			// ods.setUser("X00098814");
			// ods.setPassword("db11Feb95");

			conn = ods.getConnection();
			System.out.println("Connection has been opened.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void buildEmployeeTable() {
		try {
			String s = "Create table Employee(EmployeeID VARCHAR2(15) NOT NULL PRIMARY KEY, "
					+ "DepartmentID Varchar2(20) Not Null,"
					+ "Teamid  Varchar2(20) Not Null,"
					+ "Contractid Varchar2(20) Not Null, "
					+ "Passwordid Varchar2(20) Not Null, "
					+ "Em_Fname	Varchar2(30),"
					+ "Em_Lname  Varchar2(50),"
					+ "Em_Gender CHAR,"
					+ "Em_Nationality Varchar2(50),"
					+ "Em_Contractlength Float,"
					+ "Em_Holidays	 Integer,"
					+ "Em_Sickdays INTEGER,"
					+ "Em_Leavedays Integer, "
					+ "Em_Address Varchar2(100),"
					+ "Em_Isadmin Char, Em_Manager Char)";

			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();

			String s2 = "INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(s2);

			pstmt.setString(1, "E15001");
			pstmt.setString(2, "D15001");
			pstmt.setString(3, "T15001");
			pstmt.setString(4, "C15001");
			pstmt.setString(5, "P15001");
			pstmt.setString(6, "Test1");
			pstmt.setString(7, "TestLName");
			pstmt.setString(8, "M");
			pstmt.setString(9, "Ireland");
			pstmt.setString(10, "0.0");
			pstmt.setString(11, "12");
			pstmt.setString(12, "12");
			pstmt.setString(13, "12");
			pstmt.setString(14, "123 Fake st.");
			pstmt.setString(15, "Y");
			pstmt.setString(16, "Y");

			pstmt.executeUpdate();

			pstmt.setString(1, "E15002");
			pstmt.setString(2, "D15001");
			pstmt.setString(3, "T15002");
			pstmt.setString(4, "C15002");
			pstmt.setString(5, "P15002");
			pstmt.setString(6, "Test2");
			pstmt.setString(7, "TestLName");
			pstmt.setString(8, "F");
			pstmt.setString(9, "Ireland");
			pstmt.setString(10, "0.0");
			pstmt.setString(11, "12");
			pstmt.setString(12, "12");
			pstmt.setString(13, "12");
			pstmt.setString(14, "123 Fake st.");
			pstmt.setString(15, "N");
			pstmt.setString(16, "Y");

			pstmt.executeUpdate();

			System.out.println("Employee TABLE WAS MADE");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not make table");
		}
	}

	public void buildtableDept() {
		try {
			String s = "CREATE TABLE Department(DepartmentID VARCHAR2(13) NOT NULL Primary Key,"
					+ "Dep_Name VARCHAR2(50) NOT NULL)";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();// error here

			String s2 = "INSERT INTO Department VALUES(?,?)";
			pstmt = conn.prepareStatement(s2);

			// Row1
			pstmt.setString(1, "D15001");
			pstmt.setString(2, "TestDep");

			pstmt.executeUpdate();
			System.out.println("Dept table created");
		} catch (SQLException e) {
			System.out.println("Bollocks");
			e.printStackTrace();
		}
	}

	public void buildTableTeam() {
		try {
			String s = "CREATE TABLE Team" + "(	TeamID Varchar2(10) Not Null,"
					+ "Tm_Name VARCHAR2(50)," + "Tm_Description Varchar2(100),"
					+ "Tm_Leader VARCHAR2(50)," + "PRIMARY KEY (TeamID))";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();

			String s2 = "INSERT INTO Team VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(s2);

			pstmt.setString(1, "T15001");
			pstmt.setString(2, "TestTeam");
			pstmt.setString(3, "Test team description");
			pstmt.setString(4, "E123456789");
			pstmt.executeUpdate();
			System.out.println("Team table created");
		} catch (SQLException e) {

		}
	}

	public void updateTeam(String teamNum, String empNum) {
		String updateString = ("UPDATE employee SET TeamID = ? WHERE EmployeeID = ?");

		try {
			pstmt = conn.prepareStatement(updateString);

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

		try {
			pstmt.setString(1, teamNum);
			pstmt.setString(2, empNum);
			pstmt.executeUpdate();
			System.out.println("Did this even run?");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void AddNewTeam(String teamNum, String teamName, String teamDes,
			String teamLead) {
		try {
			String s2 = "INSERT INTO Team VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(s2);

			pstmt.setString(1, teamNum);
			pstmt.setString(2, teamName);
			pstmt.setString(3, teamDes);
			pstmt.setString(4, teamLead);
			pstmt.executeUpdate();
			System.out.println("Team added");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void buildTableLeaveHoliday() {
		try {
			String s = "CREATE TABLE HolidayLeave"
					+ "(Leaveid Varchar2(10) Not Null,"
					+ "Employeeid Varchar2(20) Not Null,"
					+ "Leave_Startdate	VARCHAR2(20),"
					+ "Leave_Length Integer,PRIMARY KEY (LeaveID),"
					+ "FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID))";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();

			String s2 = "INSERT INTO HolidayLeave VALUES (?,?,?)";
			pstmt = conn.prepareStatement(s2);

			// Row1
			pstmt.setString(1, "placeholder");

			pstmt.executeUpdate();
			System.out.println("Successful");
		} catch (SQLException e) {

		}
	}

	public void buildTableGenericLeave() {
		try {
			String s = "CREATE TABLE GenericLeave"
					+ "(LeaveID VARCHAR2(10) NOT NULL,"
					+ "GLeaveID VARCHAR2(20) NOT NULL,"
					+ "Gen_ReasonVARCHAR2(100)," + "Primary Key (Gleaveid),"
					+ "FOREIGN KEY (LeaveID) REFERENCES HolidayLeave (LeaveID)";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();
			System.out.println("Successful");
			// String s2 = "INSERT INTO GenericLeave VALUES (?,?,?)";
			// pstmt = conn.prepareStatement(s2);

			// Row1
			// pstmt.setString(1, "placeholder");

			// pstmt.executeUpdate();

		} catch (SQLException e) {

		}
	}

	public void buildTableContract() {
		try {
			String s = "CREATE TABLE Contract"
					+ "(ContractID Varchar2(20) Not Null,"
					+ "Con_StartVARCHAR2(20),"
					+ "Con_Description Varchar2(200),"
					+ "Con_Type VARCHAR2(200),PRIMARY KEY (ContractID))";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();

			String s2 = "INSERT INTO Contract VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(s2);
			// '', 0.0, '1/1/2014', 'Test Description', 'Test Type'
			// Row1
			pstmt.setString(1, "C123456789");
			pstmt.setString(2, "0.0");
			pstmt.setString(3, "0.0");
			pstmt.setString(4, "1/1/2014");
			pstmt.setString(5, "Test Description");
			pstmt.setString(6, "TestType");

			pstmt.executeUpdate();
			System.out.println("Contract table created");
		} catch (SQLException e) {

		}
	}

	public void buildTablePassword() {
		try {
			String s = "CREATE TABLE Password"
					+ "(PasswordID VARCHAR2(10) NOT NULL,"
					+ "Password VARCHAR2(50) NOT NULL,"
					+ "Pass_SecretQ VARCHAR2(100),"
					+ "Pass_SecretA VARCHAR2(100),"
					+ "PRIMARY KEY(PasswordID))";
			pstmt = conn.prepareStatement(s);

			// Create the table.
			pstmt.executeUpdate();

			String s2 = "INSERT INTO Password VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(s2);
			// 'P123456789', 'Admin', 'SecretQ', 'SecretA'
			// Row1
			pstmt.setString(1, "P15001");
			pstmt.setString(2, "Admin");
			pstmt.setString(3, "SecretQ");
			pstmt.setString(4, "SecretA");

			pstmt.executeUpdate();

			pstmt.setString(1, "P15002");
			pstmt.setString(2, "Admin3");
			pstmt.setString(3, "SecretQ");
			pstmt.setString(4, "SecretA");

			pstmt.executeUpdate();
			System.out.println("Password table created");
		} catch (SQLException e) {

		}
	}

	public void dropTables() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			pstmt = conn.prepareStatement("DROP TABLE Department");

			try {
				pstmt.execute();
				// Drop the Movie table.
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void dropTableEmp() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			pstmt = conn.prepareStatement("DROP TABLE Employee");

			try {
				pstmt.execute();

			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void dropTableTeam() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			pstmt = conn.prepareStatement("DROP TABLE Team");

			try {
				pstmt.execute();
				// Drop the Movie table.
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void dropTableContract() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			pstmt = conn.prepareStatement("DROP TABLE Contract");

			try {
				pstmt.execute();
				// Drop the Movie table.
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void dropTablePassword() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			pstmt = conn.prepareStatement("DROP TABLE Password");

			try {
				pstmt.execute();
				// Drop the Movie table.
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void CloseDB() {
		try {
			pstmt.close();
			// rset.close();
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}

	/*
	 * public ResultSet queryDBPass() { String sqlStatement =
	 * "SELECT * FROM Password"; try { pstmt =
	 * conn.prepareStatement(sqlStatement, ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); rset = pstmt.executeQuery(); while
	 * (rset.next()) { System.out.printf("%20s %40s %40s %40s \n",
	 * rset.getString("PasswordID"), rset.getString("Password"),
	 * rset.getString("Pass_SecretQ"), rset.getString("Pass_SecretA"));
	 * 
	 * } } catch (Exception ex) { System.out.println("ERROR: BOLOBDZSFBGH" +
	 * ex.getMessage()); }
	 * 
	 * return rset; }
	 */

	public void updateEmp(String name, String LName, String Address,
			String gender, String nationality, String employeeNumber,
			String manager, String admin, String deparment) {

		String updateString = ("UPDATE employee SET Em_FName = ?, Em_LName = ?, Em_Address = ?, Em_Gender = ?, EM_ISADMIN = ?, EM_MANAGER= ? WHERE EmployeeID = ?");

		try {
			pstmt = conn.prepareStatement(updateString);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			pstmt.setString(1, name);
			pstmt.setString(2, LName);
			pstmt.setString(3, Address);
			pstmt.setNString(4, gender);
			pstmt.setNString(5, admin);
			pstmt.setNString(6, manager);
			pstmt.setString(7, employeeNumber);
			pstmt.executeUpdate();

			System.out.println("Updated " + employeeNumber);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

	/*
	 * public ResultSet queryDB() { String sqlStatement =
	 * "SELECT * FROM Department"; try { pstmt =
	 * conn.prepareStatement(sqlStatement, ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); rset = pstmt.executeQuery(); while
	 * (rset.next()) { System.out.printf("%20s %40s \n",
	 * rset.getString("DepartmentID"), rset.getString("Dep_Name"));
	 * 
	 * } } catch (Exception ex) { System.out.println("ERROR: " +
	 * ex.getMessage()); }
	 * 
	 * return rset; }
	 */

	public ResultSet queryDBteam(String teamName) {
		String sqlStatement = "SELECT * FROM EMPLOYEE e, TEAM t WHERE e.TeamID = t.TeamID AND e.TeamName ='"
				+ teamName + "'";

		try {
			pstmt = conn.prepareStatement(sqlStatement,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				System.out.printf("%20s %20s %20s ", rset.getString("teamID"),
						rset.getString("tm_name"), rset.getString("tm_leader"));
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return rset;

	}

	public ResultSet queryDBteam2() {
		String sqlStatement = "SELECT * FROM EMPLOYEE e, TEAM t WHERE e.TeamID = t.TeamID";

		try {
			pstmt = conn.prepareStatement(sqlStatement,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				System.out.printf("%20s %20s %20s ", rset.getString("teamID"),
						rset.getString("tm_name"), rset.getString("tm_leader"));
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return rset;

	}

	public ResultSet queryDBemp() {
		String sqlStatement = "SELECT * FROM EMPLOYEE e, Department d, Password p WHERE e.PASSWORDID = p.PASSWORDID AND e.DEPARTMENTID = d.DEPARTMENTID";

		try {
			pstmt = conn.prepareStatement(sqlStatement,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				System.out.printf(
						"%20s %20s %20s \n %20s %20s %20s \n %20s %20s %20s \n"
								+ "%20f %20d %20d \n" + "%20d %20s %20s \n \n"
								+ "%20s %20s %20s \n ",
						rset.getString("EmployeeID"),
						rset.getString("DepartmentID"),
						rset.getString("TeamID"), rset.getString("ContractID"),
						rset.getString("PasswordID"),
						rset.getString("Em_Fname"), rset.getString("Em_Lname"),
						rset.getString("Em_Gender"),
						rset.getString("Em_Nationality"),
						rset.getDouble("Em_Contractlength"),
						rset.getInt("Em_Holidays"), rset.getInt("Em_Sickdays"),
						rset.getInt("Em_Leavedays"),
						rset.getString("Em_Address"),
						rset.getString("Em_Isadmin"),
						rset.getString("Em_Manager"),
						rset.getString("Dep_Name"), rset.getString("Password"));

			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}

		return rset;
	}

	public void updatePass(User u) {

		String s2 = ("UPDATE Password SET PASSWORD = ?");
		try {
			pstmt = conn.prepareStatement(s2);

			pstmt.setString(1, u.getPassword());

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addPass(User u) {

		String s2 = "INSERT INTO Password VALUES (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(s2);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 'P123456789', 'Admin', 'SecretQ', 'SecretA'
		// Row1
		try {
			number = "P" + i2;
			pstmt.setString(1, u.getpNumber());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getSecretQ());
			pstmt.setString(4, u.getSecretA());
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addEmp(User u) {

		try {
			String m = "n";
			String a = "n";
			String queryString = "insert into Employee(EmployeeID, "
					+ "DepartmentID," + "Teamid," + "Contractid,"
					+ "Passwordid , " + "Em_Fname," + "Em_Lname,"
					+ "Em_Gender," + "Em_Nationality," + "Em_Contractlength,"
					+ "Em_Holidays," + "Em_Sickdays," + "Em_Leavedays, "
					+ "Em_Address," + "Em_Isadmin, "
					+ "Em_Manager) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(queryString);
			String contactLength = " " + (u.getContractLength());
			i2++;
			pstmt.setString(1, u.getEmployeeNumber());
			pstmt.setString(2, u.getdNumber());
			pstmt.setString(3, u.gettNumber());
			pstmt.setString(4, u.getcNumber());
			pstmt.setString(5, u.getpNumber());
			pstmt.setString(6, u.getName());
			pstmt.setString(7, u.getLName());
			pstmt.setString(8, u.getGender());
			pstmt.setString(9, "Ireland");
			pstmt.setString(10, contactLength);
			pstmt.setString(11, "12");
			pstmt.setString(12, "12");
			pstmt.setString(13, "12");
			pstmt.setString(14, u.getAddress());
			pstmt.setString(15, m);
			pstmt.setString(16, a);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public ResultSet findEmployee(String SearchTerm, String type) {

		if (type == "FName") {
			String search = ("SELECT * FROM EMPLOYEE e, Department d, Password p WHERE e.PASSWORDID = p.PASSWORDID AND e.DEPARTMENTID = d.DEPARTMENTID AND EM_FNAME LIKE '%"
					+ SearchTerm + "%'");

			System.out.println("===============First Name===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

			return rset;
		}

		else if (type == "Surname") {

			String search = ("SELECT * "
					+ "FROM EMPLOYEE e, Department d, Password p WHERE e.PASSWORDID = p.PASSWORDID AND e.DEPARTMENTID = d.DEPARTMENTID AND EM_LNAME LIKE '%"
					+ SearchTerm + "%'");

			System.out.println("===============Surname===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

			return rset;

		}

		else if (type == "Department") {

			String search = ("SELECT * FROM EMPLOYEE e, Department d, Password p WHERE e.DEPARTMENTID = d.DEPARTMENTID AND DEP_Name LIKE '%"
					+ SearchTerm + "%'");

			System.out.println("===============Department===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

				while (rset.next()) {
					System.out.printf(
							"%20s %20s %20s \n %20s %20s %20s \n %20s %20s %20s \n"
									+ "%20f %20d %20d \n"
									+ "%20d %20s %20s \n \n",
							rset.getString("EmployeeID"),
							rset.getString("DepartmentID"),
							rset.getString("TeamID"),
							rset.getString("ContractID"),
							rset.getString("PasswordID"),
							rset.getString("Em_Fname"),
							rset.getString("Em_Lname"),
							rset.getString("Em_Gender"),
							rset.getString("Em_Nationality"),
							rset.getDouble("Em_Contractlength"),
							rset.getInt("Em_Holidays"),
							rset.getInt("Em_Sickdays"),
							rset.getInt("Em_Leavedays"),
							rset.getString("Em_Address"),
							rset.getString("Em_Isadmin"));

				}

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

		}
		return rset;

	}

	public void deleteEmployee(String ID) {

		String updateString = ("DELETE FROM employee WHERE employeeID = ?");

		try {
			pstmt = conn.prepareStatement(updateString);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			pstmt.setString(1, ID);
			pstmt.executeUpdate();

			System.out.println("Deleted " + ID);
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}

	public ResultSet displayEmployee(String searchTerm, String type) {

		if (type == "FName") {
			String search = ("SELECT EmployeeID, em_Fname, em_lname  FROM Employee   WHERE em_fname LIKE '%"
					+ searchTerm + "%'");

			System.out.println("===============First Name===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

			return rset;
		}

		else if (type == "Surname") {

			String search = ("SELECT EmployeeID, em_Fname, em_lname  FROM Employee   WHERE em_lname LIKE '%"
					+ searchTerm + "%'");

			System.out.println("===============Surname===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

			return rset;

		}

		else if (type == "Department") {

			String search = ("SELECT e.employeeid,e.departmentID, d.dep_name, e.em_fname, e.em_lname FROM EMPLOYEE e, Department d WHERE e.departmentID = d.departmentID AND d.dep_name LIKE '%"
					+ searchTerm + "%'");

			System.out.println("===============Department===============");

			try {

				pstmt = conn.prepareStatement(search,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rset = pstmt.executeQuery();

			} catch (SQLException e) {
				e.getErrorCode();
				e.printStackTrace();
			}

		}
		return rset;
	}

}
