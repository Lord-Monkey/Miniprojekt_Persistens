package model;
/**
 * {@link SaleOrder} Represents a sales order in the system.
 * 
 * A SaleOrder contains information about the order number, order date,
 * delivery status, delivery date, discount status, the associated customer,
 * and the list of order line items included in the order.
 * 
 * @author Lau, Aksel
 * @version 11-3-2026
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {

	private int orderNo;
	private LocalDate date;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private boolean discountGiven;
	private Customer c;
	private List<OrderLineItem> orderLines;
	
	public SaleOrder() {
		orderLines = new ArrayList<>();
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean getDiscountGiven() {
		return discountGiven;
	}

	public void setDiscountGiven(boolean discountGiven) {
		this.discountGiven = discountGiven;
	}

	public Customer getCustomer() {
		return c;
	}

	public void setCustomer(Customer c) {
		this.c = c;
	}

	public ArrayList<OrderLineItem> getOrderLines() {
		return new ArrayList<OrderLineItem>(orderLines);
	}

	public void addOrderLine(Product p, int quantity) {
		OrderLineItem oli = new OrderLineItem(p, quantity);
		orderLines.add(oli);
	}
	
	public void setOrderLines(List<OrderLineItem> orderLines) {
		this.orderLines = orderLines;
	}
}
