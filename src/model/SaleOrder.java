package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SaleOrder {

	private int orderNo;
	private LocalDate date;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private boolean discountGiven;
	private Customer c;
	private ArrayList<OrderLineItem> orderLines;
	
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
}
