package model;

public abstract class Product {
	
	private int productNumber;
	private String name;
	private int minStock;
	private int reserveQty;
	
	public Product(int productNumber, String name, int minStock, int reserveQty){
		this.productNumber = productNumber;
		this.name = name;
		this.minStock = minStock;
		this.reserveQty = reserveQty;
	}
	
	public Product() {
		
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getReserveQty() {
		return reserveQty;
	}

	public void setReserveQty(int reserveQty) {
		this.reserveQty = reserveQty;
	}
	
	
}
