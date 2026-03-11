package controller;

import java.util.List;
import db.SaleOrderDB;
import db.SaleOrderDBIF;
import model.Customer;
import model.Product;
import model.SaleOrder;

public class SalesOrderCtr {
	//Fields
	private CustomerCtr cctr;
	private ProductCtr pctr;
	private SaleOrder so;
	private SaleOrderDBIF sodb;
	
	//Constructor
	public SalesOrderCtr() {
		cctr = new CustomerCtr();
		pctr = new ProductCtr();
		sodb = new SaleOrderDB();
	}
	
	//Methods
	public SaleOrder createSaleOrder() {
		return new SaleOrder();
	}
	
	public Customer enterCustomer(String email) {
		return cctr.findCustomer(email);
	}
	
	public Product enterProduct(int id, int quantity) {
		return pctr.findProduct(id);
	}
	
	public void discount(boolean discountGiven) {
		if (discountGiven) {
			so.setDiscountGiven(0.1);
		} else {
			so.setDiscountGiven(0);
		}
	}
	
	public List<SaleOrder> findAll() {
		return sodb.findAll();
	}
}
