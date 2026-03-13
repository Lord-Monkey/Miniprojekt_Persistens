package model;

/**
 * {@link OrderLineItem} Represents a single line item in an order.
 * 
 * An OrderLineItem contains a {@link Product} and the quantity of that product
 * included in the order.
 * 
 * @author Lau Jul Jensen, Nikolaj Grønhøj Thimm, Christian Nordentoft
 * @version 11-3-2026
 */
public class OrderLineItem {
	
	//Fields
	private Product p;
	private int quantity;
	
	//Constructors
	public OrderLineItem(Product p, int quantity) {
		this.p = p;
		this.quantity = quantity;
	}

	//Methods
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
