package model;
/**
 * {@link Customer} is a class that provides getter and setter methods for accessing
 * and updating customer attributes.
 * 
 * @author Christian
 * @version 11-3-2026
 */
public class Customer {
	
	//Fields
	private String name;
	private String address;
	private int zipcode;
	private String city;
	private String mail;
	private String type;
	
	// Constructors
	public Customer() {
		
	}
	
	public Customer(String name, String address, int zipcode, String city, String mail, String type) {
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.mail = mail;
		this.type = type;
	}
	
	//Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
