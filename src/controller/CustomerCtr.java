package controller;

import java.util.List;
import db.CustomerDB;
import db.CustomerDBIF;
import db.DataAccessException;
import model.Customer;

public class CustomerCtr {

	private Customer c;
	private CustomerDBIF cdb;
	
	public CustomerCtr() throws DataAccessException {
		cdb = new CustomerDB();
	}
	
	public Customer findCustomer(String mail) throws DataAccessException {
		c = cdb.findCustomer(mail);
		return c;
	}
	
	public List<Customer> findAll() throws DataAccessException{
		return cdb.findAll();
	}
}
