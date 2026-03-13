package model;

/**
 * {@link GunReplica} is a subclass of {@link Product} that represents a gunReplica product.
 * 
 * It adds gunReplica-specific attributes such as caliber and material to the generic product information.
 * 
 * @author Lau Jul Jensen, Nikolaj Grønhøj Thimm, Christian Nordentoft
 * @version 11-3-2026
 */
public class GunReplica extends Product{

	//Fields
	private String caliber;
	private String material;
	
	//Constructors
	public GunReplica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GunReplica(int productNumber, ProductTypeEnum ptEnum, String name, int minStock, int reserveQty,
			String caliber, String material) {
		super(productNumber, ptEnum, name, minStock, reserveQty);
		this.caliber = caliber;
		this.material = material;
	}
	
	//Methods
	public String getCaliber() {
		return caliber;
	}
	public void setCaliber(String caliber) {
		this.caliber = caliber;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
