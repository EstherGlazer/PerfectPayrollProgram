package payrollProgram;

public class Person {
	private int ID;
	private String name;
	//has an address
	private Address address;
	
	//constructor
	public Person(int ID, String name, String street, String city, String state, String zip) {
		this.ID= ID;
		this.name= name;
		address= new Address(street, city, state, zip);
	}
	public Person(int ID, String name, Address add) {
		this(ID, name, add.getStreet(), add.getCity(), add.getState(), add.getZipcode());
	}
	//setters and getters
	public void setID(int ID) {
		this.ID=ID;
	}
	public int getID() {
		return ID;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
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
		str.append("\nName: "+name);
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
