package model;

public abstract class Product {
	
	//Fields
	private int productNumber;
	private ProductTypeEnum ptEnum;
	private String name;
	private int minStock;
	private int reserveQty;
	
	//Constructors
	public Product(int productNumber, String name, int minStock, int reserveQty){
		this.productNumber = productNumber;
		this.name = name;
		this.minStock = minStock;
		this.reserveQty = reserveQty;
	}
	
	public Product() {
		
	}
	
	//Methods
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
