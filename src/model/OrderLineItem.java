package model;

public class OrderLineItem {

	private Product p;
	private int quantity;
	
	public OrderLineItem(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
