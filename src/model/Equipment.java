package model;

/**
 * {@link Equipment} is a subclass of {@link Product} that represents a equipment product.
 * 
 * It adds equipment-specific attributes such as material and style to the generic product information.
 * 
 * @author Lau Jul Jensen, Nikolaj Grønhøj Thimm, Christian Nordentoft
 * @version 11-3-2026
 */
public class Equipment extends Product{

	//Fields
	private String material;
	private String style;
	
	//Constructors
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipment(int productNumber,ProductTypeEnum ptEnum, String name, int minStock, int reserveQty,
			String material, String style) {
		super(productNumber, ptEnum, name, minStock, reserveQty);
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
