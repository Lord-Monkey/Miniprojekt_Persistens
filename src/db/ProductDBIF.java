package db;
/**
 * Interface for database operations on {@link Product} objects.
 * Supports finding a single {@link Product} by product number and retrieving all {@link Product}.
 * 
 * @author Mathias, Lau
 * @version 11-3-2026
 */
import java.util.List;

import model.Product;

public interface ProductDBIF {

	Product findProduct(int productNumber) throws DataAccessException;
	
	List<Product> findAll() throws DataAccessException;
}
