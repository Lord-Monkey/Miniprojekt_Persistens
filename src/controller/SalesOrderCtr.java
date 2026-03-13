package controller;

import java.util.List;
import db.SaleOrderDB;
import db.SaleOrderDBIF;
import db.DataAccessException;
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
	public SalesOrderCtr() throws DataAccessException {
		cctr = new CustomerCtr();
		pctr = new ProductCtr();
		sodb = new SaleOrderDB();
	}
	
	//Methods
	public SaleOrder createSaleOrder() throws DataAccessException {
		return new SaleOrder();
	}
	
	public Customer enterCustomer(String mail) throws DataAccessException {
		return cctr.findCustomer(mail);
	}
	
	public Product enterProduct(int productNumber, int quantity) throws DataAccessException {
		return pctr.findProduct(productNumber);
	}
	
	public void discount(boolean discountGiven) throws DataAccessException {
		so.setDiscountGiven(discountGiven);
	}
	
	public List<SaleOrder> findAll() throws DataAccessException {
		return sodb.findAll();
	}
	
	public SaleOrder findByOrderNo(int orderNo) throws DataAccessException {
		return so = sodb.findOrderByOrderNo(orderNo);
	}
}
