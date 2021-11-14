package payrollProgram;

public class Person {
	private int ID;
	private String fname;
	private String lname;
	//has an address
	private Address address;
	
	//constructor
	public Person(int ID, String fname, String lname, String street, String city, String state, String zip) {
		this.ID= ID;
		this.fname= fname;
		this.lname=lname;
		address= new Address(street, city, state, zip);
	}
	public Person(int ID, String fname, String lname, Address add) {
		this(ID, fname, lname, add.getStreet(), add.getCity(), add.getState(), add.getZipcode());
	}
	//setters and getters
	public void setID(int ID) {
		this.ID=ID;
	}
	public int getID() {
		return ID;
	}
	public void setFname(String fname) {
		this.fname=fname;
	}
	public String getFname() {
		return fname;
	}
	public void setLname(String lname){
		this.lname=lname;
	}
	public String getLname(){
		return lname;
	}
	public void setAddress(Address add) {
		this.address=add;
	}
	public Address getAddress() {
		return address;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder str= new StringBuilder();
		str.append("\nID: "+ ID);
		str.append("\nName: "+fname+" "+lname);
		str.append("\nAddress: "+ address);		
		return str.toString();
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (ID != other.ID)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}



}
