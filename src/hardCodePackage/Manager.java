package hardCodePackage;

import java.util.ArrayList;

public class Manager extends User 
{
	private String groupTitle;
	

	public Manager(String FName, String LName, String Address, String gender,
			String nationality, String employeeNumber, double contractLength,
			String employeeType, String password, String SecretQ , String SecretA, String department, String dNumber, String pNumber, String cNumber, String tNumber) {
	
		super(FName, LName, Address, gender, nationality, employeeNumber,
				contractLength, employeeType, password, SecretQ, SecretA, department, dNumber, pNumber, cNumber, tNumber);
	
	}

	public void CreateGroup()
	{
		ArrayList<User> group = new ArrayList<User>();
		
	}
	
	
}
