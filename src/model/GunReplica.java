package model;

public class GunReplica extends Product{

	//Fields
	private String caliber;
	private String material;
	
	//Constructors
	public GunReplica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GunReplica(int productNumber, String name, int minStock, int reserveQty) {
		super(productNumber, name, minStock, reserveQty);
		// TODO Auto-generated constructor stub
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
