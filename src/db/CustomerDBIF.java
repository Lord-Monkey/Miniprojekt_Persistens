package db;

import java.util.List;

import model.Customer;

public interface CustomerDBIF {

	Customer findCustomer(String mail) throws DataAccessException;
	
	List<Customer> findAll() throws DataAccessException;
	
}
