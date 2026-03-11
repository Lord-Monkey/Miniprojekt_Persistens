package controller;

import java.util.List;
import db.ProductDB;
import model.Product;

public class ProductCtr {
	//Fields
	private Product p;
	private ProductDB productDBIF;
	
	//Constructor
	public ProductCtr() {
		productDBIF = new ProductDB();
	}
	
	//Methods
	public Product findProduct(int id) {
		return productDBIF.findProduct(id);
	}
	
	public List<Product> findAllProducts() {
		return productDBIF.findAllProducts();
	}
}
