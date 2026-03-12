package db;

import java.util.List;

import model.Product;

public interface ProductDBIF {

	public Product findProduct(int productNumber) throws DataAccessException;
	public List<Product> findAll() throws DataAccessException;
}
