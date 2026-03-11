package controller;

import java.util.List;
import db.CustomerDB;
import db.CustomerDBIF;
import db.DataAccessException;
import model.Customer;

public class CustomerCtr {
	//Fields
	private Customer c;
	private CustomerDBIF cdb;
	
	//Constructor
	public CustomerCtr() throws DataAccessException {
		cdb = new CustomerDB();
	}
	
	//Methods
	public Customer findCustomer(String mail) throws DataAccessException {
		c = cdb.findCustomer(mail);
		return c;
	}
	
	public List<Customer> findAll() throws DataAccessException{
		return cdb.findAll();
	}
}
