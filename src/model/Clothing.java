package model;

/**
 * {@link Clothing} is a subclass of {@link Product} that represents a clothing product.
 * It adds clothing-specific attributes such as size and colour to the generic product information.
 * 
 * @author Nikolaj Grønhøj Thimm, Christian Nordentoft
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
		
		/**
	     * Constructs a {@link Clothing} object with specified attributes.
	     *
	     * @param productNumber the unique product number
	     * @param name the name of the product
	     * @param minStock the minimum stock level
	     * @param reserveQty the reserve quantity
	     * @param size the size of the clothing
	     * @param colour the colour of the clothing
	     */
		public Clothing(int productNumber, String name, int minStock, 
				int reserveQty, String size, String colour) {
			
		}

	    /**
	     * Gets the size of the clothing item.
	     * @return the size
	     */
		public String getSize() {
			return size;
		}
		
		 /**
	     * Sets the size of the clothing item.
	     * @param size the size to set
	     */
		public void setSize(String size) {
			this.size = size;
		}
		
		/**
	     * Gets the colour of the clothing item.
	     * @return the colour
	     */
		public String getColour() {
			return colour;
		}
		
		 /**
	     * Sets the colour of the clothing item.
	     * @param colour the colour to set
	     */
		public void setColour(String colour) {
			this.colour = colour;
		}
}
