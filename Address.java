package payrollProgram;
//declare fields
public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
//constructor
public Address(String street, String city, String state, String zipcode) {
	this.street=street;
	this.city=city;
	this.state=state;
	this.zipcode=zipcode;
}
//getters
public String getStreet() {
	return street;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
public String getZipcode() {
	return zipcode;
}
//toString
@Override
public String toString() {
	StringBuilder string = new StringBuilder();
	string.append(street+" ");
	string.append("\n"+ city+","+state+" "+zipcode );
	return string.toString();
}
}

