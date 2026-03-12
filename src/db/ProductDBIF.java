package db;

import java.util.List;

import model.Product;

public interface ProductDBIF {

	Product findProduct(int productNumber) throws DataAccessException;
	
	List<Product> findAll() throws DataAccessException;
}
