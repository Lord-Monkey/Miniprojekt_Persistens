package model;

public class GunReplica extends Product{

	private String caliber;
	private String material;
	public GunReplica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GunReplica(int productNumber, String name, int minStock, int reserveQty) {
		super(productNumber, name, minStock, reserveQty);
		// TODO Auto-generated constructor stub
	}
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
