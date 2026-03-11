package controller;

import java.util.List;
import db.ProductDB;
import db.ProductDBIF;
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
	public Product findProduct(int productNumber) {
		return prdb.findProduct(productNumber);
	}
	
	public List<Product> findAllProducts() {
		return prdb.findAll();
	}
}
