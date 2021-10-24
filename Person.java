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
	//equals method: compares based on ID and name
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(o==null) {
			return false;
		}
		if(getClass() != o.getClass()) {
			return false;
		}
		Person compare= (Person) o ;
		if(ID<0) {
			if(compare.ID >= 0) {
				return false;
			}
		}
		if(ID != compare.ID) {
			return false;
		}
		if(name==null) {
			if(compare.name != null) {
				return false;
			}
		}
		if(name != name) {
			return false;
		}
		
		return true;
	}

}
