package db;
/**
 * Interface for accessing customer data from a database.
 * Provides methods to find a single {@link Customer} by email
 * and to retrieve all {@link Customer} from the database.
 * 
 * @author Thimm, Lau
 * @version 11-3-2026
 */
import java.util.List;

import model.Customer;

public interface CustomerDBIF {

	Customer findCustomer(String mail) throws DataAccessException;
	
	List<Customer> findAll() throws DataAccessException;
	
}
