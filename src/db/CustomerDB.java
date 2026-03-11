package db;

import java.sql.PreparedStatement;

public class CustomerDB implements CustomerDBIF {

	private static final String FIND_ALL_Q = "select id, name, address, zipCode, city, mail, type from Customer";
	private PreparedStatement findAllCustomers;
	
	private static final String FIND_BY_EMAIL_Q = FIND_ALL_Q + "where mail = ?";
	private PreparedStatement findByEmail;
	
	public CustomerDB(){
		
	}
}
