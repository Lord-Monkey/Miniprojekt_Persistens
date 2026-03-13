package model;

/**
 * {@link Clothing} is a subclass of {@link Product} that represents a clothing product.
 * 
 * It adds clothing-specific attributes such as size and colour to the generic product information.
 * 
 * @author Thimm, Christian
 * @version 11-3-2026
 */
public class Clothing extends Product{
		
		//Fields
		private String size;
		private String colour;
		
		//Constructors
		public Clothing() {
			super();
		}
		
		public Clothing(int productNumber, ProductTypeEnum ptEnum, String name, int minStock, 
				int reserveQty, String size, String colour) {
			super(productNumber, ptEnum, name, minStock, reserveQty);
			this.size = size;
			this.colour = colour;
		}
		
		//Methods
		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}
		
		public String getColour() {
			return colour;
		}
		
		public void setColour(String colour) {
			this.colour = colour;
		}
}
