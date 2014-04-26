package hardCodePackage;

public class User {
	private String FName;
	private String LName;
	private String Address;
	private String employeeNumber;
	private String pNumber;
	private String dNumber;
	private String cNumber;
	private String tNumber;
	private String birthdate;
	private String gender;
	private String nationality;
	private String employeeType;
	private double contractLength;
	private String department, password, secretQ, secretA;

	public User(String FName, String LName, String Address, String gender,
			String nationality, String employeeNumber, double contractLength,
			String employeeType, String password, String SecretQ , String SecretA, String department,
			String dNumber, String pNumber, String cNumber, String tNumber) {
		this.FName = FName;
		this.setLName(LName);
		this.setAddress(Address);
		this.setEmployeeNumber(employeeNumber);
		this.employeeType = employeeType;
		this.setGender(gender);
		this.setNationality(nationality);
		this.setContractLength(contractLength);
		this.setDepartment(department);
		this.setPassword(password);
		this.setSecretQ(SecretQ);
		this.setSecretA(SecretA);
		this.setdNumber(dNumber);
		this.setpNumber(pNumber);
		this.setcNumber(cNumber);
		this.settNumber(tNumber);
		this.setSecretQ(SecretQ);
		this.setSecretA(SecretA);
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getName() {
		return FName;
	}

	public void setName(String name) {
		this.FName = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getContractLength() {
		return contractLength;
	}

	public void setContractLength(double contractLength) {
		this.contractLength = contractLength;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getdNumber() {
		return dNumber;
	}

	public void setdNumber(String dNumber) {
		this.dNumber = dNumber;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String gettNumber() {
		return tNumber;
	}

	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}

	public String getSecretQ() {
		
		return secretQ;
	}

	public void setSecretQ(String secretQ) {
		this.secretQ = secretQ;
	}

	public String getSecretA() {
		return secretA;
	}

	public void setSecretA(String secretA) {
		this.secretA = secretA;
	}
}
