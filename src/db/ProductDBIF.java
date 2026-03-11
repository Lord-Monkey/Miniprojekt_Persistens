package db;

import java.util.List;

import model.Product;

public interface ProductDBIF {

	public Product findProduct(int productNumber);
	public List<Product> findAll();
}
