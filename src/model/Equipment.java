package model;

public class Equipment extends Product{

	//Fields
	private String material;
	private String style;
	
	//Constructors
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipment(int productNumber, String name, int minStock, int reserveQty,
			String material, String style) {
		super(productNumber, name, minStock, reserveQty);
		this.material = material;
		this.style = style;
	}
	
	//Methods
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
