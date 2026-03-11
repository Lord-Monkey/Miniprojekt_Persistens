package model;
/**
 * {@link Customer} is a class that provides getter and setter methods for accessing
 * and updating customer attributes.
 * 
 * @author Christian Nordentoft
 * @version 11-3-2026
 */
public class Customer {
	
	private String name;
	private String address;
	private int zipcode;
	private String city;
	private String mail;
	private String type;
	
	// Constructors
    /**
     * Empty constructor for {@link Customer}.
     */
	public Customer() {
		
	}
	 /**
     * Constructs a {@link Customer} with specified details.
     *
     * @param name the customer's name
     * @param address the customer's street address
     * @param zipcode the customer's postal code
     * @param city the city where the customer resides
     * @param mail the customer's email address
     * @param type the type/category of the customer
     */
	public Customer(String name, String address, int zipcode, String city, String mail, String type) {
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.mail = mail;
		this.type = type;
	}
	/**
     * Gets the customer's name.
     * @return the name
     */

	public String getName() {
		return name;
	}
	
	 /**
     * Sets the customer's name.
     * @param name the name to set
     */
	public void setName(String name) {
		this.name = name;
	}
	
	 /**
     * Gets the customer's address.
     * @return the address
     */
	public String getAddress() {
		return address;
	}
	
	/**
     * Sets the customer's address.
     * @param address the address to set
     */
	public void setAddress(String address) {
		this.address = address;
	}
	
	 /**
     * Gets the customer's postal code.
     * @return the zipcode
     */
	public int getZipcode() {
		return zipcode;
	}
	
	/**
     * Sets the customer's postal code.
     * @param zipcode the zipcode to set
     */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	  /**
     * Gets the customer's city.
     * @return the city
     */
	public String getCity() {
		return city;
	}
	
	 /**
     * Sets the customer's city.
     * @param city the city to set
     */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
     * Gets the customer's email address.
     * @return the email
     */
	public String getMail() {
		return mail;
	}
	
	 /**
     * Sets the customer's email address.
     * @param mail the email to set
     */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
     * Gets the type of the customer.
     * @return the type
     */
	public String getType() {
		return type;
	}
	
	/**
     * Sets the type of the customer.
     * @param type the type to set
     */
	public void setType(String type) {
		this.type = type;
	}
	
}
