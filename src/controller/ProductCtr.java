package controller;

import java.util.List;
import db.ProductDB;
import db.ProductDBIF;
import db.DataAccessException;
import model.Product;

public class ProductCtr {
	//Fields
	private Product p;
	private ProductDBIF prdb;
	
	//Constructor
	public ProductCtr() throws DataAccessException {
		prdb = new ProductDB();
	}
	
	//Methods
	public Product findProduct(int productNumber) throws DataAccessException {
		return prdb.findProduct(productNumber);
	}
	
	public List<Product> findAllProducts() throws DataAccessException {
		return prdb.findAll();
	}
}
