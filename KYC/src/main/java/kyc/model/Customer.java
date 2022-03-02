package kyc.model;

public class Customer {
	private int customerid;
	private String firstname;
	private String lastname;
	private String gender;
	private String dob;
	private String address;
	private String city;
	private String state;
	private String country;
	private int postalcode;
	private String identificationtype;
	private int identificationnumber;
	private String occupationtype;
	private String designation;
	private int salary;
	private String kycstatus;
	public Customer() {}
	
	protected Customer(int customerid, String firstname, String lastname, String gender, String dob, String address,
			String city, String state, String country, int postalcode, String identificationtype,
			int identificationnumber, String occupationtype, String designation, int salary, String kycstatus) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalcode = postalcode;
		this.identificationtype = identificationtype;
		this.identificationnumber = identificationnumber;
		this.occupationtype = occupationtype;
		this.designation = designation;
		this.salary = salary;
		this.kycstatus = kycstatus;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getIdentificationtype() {
		return identificationtype;
	}
	public void setIdentificationtype(String identificationtype) {
		this.identificationtype = identificationtype;
	}
	public int getIdentificationnumber() {
		return identificationnumber;
	}
	public void setIdentificationnumber(int identificationnumber) {
		this.identificationnumber = identificationnumber;
	}
	public String getOccupationtype() {
		return occupationtype;
	}
	public void setOccupationtype(String occupationtype) {
		this.occupationtype = occupationtype;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getKycstatus() {
		return kycstatus;
	}
	public void setKycstatus(String kycstatus) {
		this.kycstatus = kycstatus;
	}
	
}
