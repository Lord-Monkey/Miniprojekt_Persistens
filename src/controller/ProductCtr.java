package controller;

import java.util.List;
import db.ProductDB;
import model.Product;

public class ProductCtr {
	private Product p;
	private ProductDB productDBIF;
	
	
	public ProductCtr() {
		productDBIF = new ProductDB();
	}
	
	public Product findProduct(int id) {
		return productDBIF.findProduct(id);
	}
	
	public List<Product> findAllProducts() {
		return productDBIF.findAllProducts();
	}
}
