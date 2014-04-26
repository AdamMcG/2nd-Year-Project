package hardCodePackage;

import java.sql.*;
import java.util.ArrayList;

import databasePackage.CreateDBOperations;

public class EmployeeRegister {
	private ArrayList<User> EmployeeList;
	private ResultSet rset;
	private CreateDBOperations cDBo;

	public EmployeeRegister(CreateDBOperations cDBo) {
		this.cDBo = cDBo;
		EmployeeList = new ArrayList<User>();
		fillRegister();
	}

	public void AddUserToRegistry(User u) {
		EmployeeList.add(u);

	}

	public User getStaffMember(int n) {
		return EmployeeList.get(n);

	}

	public void removeEmployee() {

	}

	public int findEmployee(String name) {
		int index = -1;
		for (int i = 0; i < EmployeeList.size(); i++) {
			if (EmployeeList.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	public void fillRegister() {

		rset = cDBo.queryDBemp();
		// ResultSet rsetPass = cDBo.queryDBPass();
		// ResultSet rsetDep = cDBo.queryDB();

		try {
			rset.first();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		if (EmployeeList.size() > 0) {
			for (int i = EmployeeList.size() - 1; i >= 0; i--) {
				EmployeeList.remove(i);
			}
		}
		try {
			rset.beforeFirst();
			while (rset.next() == true) {

				User u = new User(rset.getString("EM_FNAME"),
						rset.getString("EM_LNAME"),
						rset.getString("EM_ADDRESS"),
						rset.getString("EM_GENDER"),
						rset.getString("EM_NATIONALITY"),
						rset.getString("EMPLOYEEID"),
						rset.getDouble("EM_CONTRACTLENGTH"),
						setStaff(rset),
						rset.getString("PASSWORD"),
						rset.getString("PASS_SECRETQ"),
						rset.getString("PASS_SECRETA"),
						rset.getString("DEP_NAME"),
						rset.getString("DepartmentID"),
						rset.getString("Passwordid"),
						rset.getString("contractid"),
						rset.getString("Teamid"));
				EmployeeList.add(u);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String returnEmployeeType(int i) {
		return EmployeeList.get(i).getEmployeeType();
	}

	public void removeTeamMember() {

	}

	public void printList() {
		for (int i = 0; i < EmployeeList.size(); i++) {
			System.out.println(EmployeeList.get(i).getEmployeeNumber()
					+ EmployeeList.get(i).getGender()
					+ EmployeeList.get(i).getEmployeeType());

		}
	}

	public String setStaff(ResultSet rset) {
		String staff = "regular employee";
		try {
			if (rset.getString("Em_IsAdmin").equals("Y")) {
				staff = "Admin";
			} else if (rset.getString("Em_Manager").equals("Y")
					&& (rset.getString("Em_IsAdmin").equals("N"))) {
				staff = "Manager";
			} else {
				staff = "staff";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return staff;
	}

	public String getEmployeeNum(int i) {
		String s = EmployeeList.get(i).getEmployeeNumber();
		return s;
	}

	public String getEmployeePass(int i) {
		String s = EmployeeList.get(i).getPassword();
		return s;
	}

	public int EmployeeListSize() {
		return EmployeeList.size();
	}

	public String getEmployeeName(int i) {
		return EmployeeList.get(i).getName();
	}

	public String getEmployeeSurName(int i) {
		return EmployeeList.get(i).getLName();
	}

	public String getEmployeeAddress(int i) {
		return EmployeeList.get(i).getAddress();
	}

	public String getGender(int i) {
		return EmployeeList.get(i).getGender();
	}

	public String getNationality(int i) {
		return EmployeeList.get(i).getNationality();
	}

	public double GetContractLength(int i) {
		return EmployeeList.get(i).getContractLength();
	}

	public String getEmployeeType(int i) {

		return EmployeeList.get(i).getEmployeeType();

	}

	public String getDepartment(int i) {

		return EmployeeList.get(i).getDepartment();

	}

	public User ReturnEmployee(int i) {
		return EmployeeList.get(i);
	}

	public String getdNumber(int i) {
		
		
		return EmployeeList.get(i).getdNumber();
	}
	
	public String getcNumber(int i) {
		
		return EmployeeList.get(i).getcNumber();
		
	}
	
	public String gettNumber(int i) {
		return EmployeeList.get(i).gettNumber();
	}
	
	public String getpNumber(int i){
		return EmployeeList.get(i).getpNumber();
	}
	
	public String getSecretQ (int i){
		return EmployeeList.get(i).getSecretQ();
	}
	public String getSecretA (int i){
		return EmployeeList.get(i).getSecretA();
	}
}
