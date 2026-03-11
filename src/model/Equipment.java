package model;

public class Equipment extends Product{

	private String material;
	private String style;
	
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipment(int productNumber, String name, int minStock, int reserveQty) {
		super(productNumber, name, minStock, reserveQty);
		// TODO Auto-generated constructor stub
	}
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
