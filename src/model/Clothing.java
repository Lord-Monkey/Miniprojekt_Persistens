package model;

public class Clothing extends Product{
		
		//Fields
		private String size;
		private String colour;
		
		//Constructors
		public Clothing() {
			super();
		}
		
		public Clothing(int productNumber, String name, int minStock, 
				int reserveQty, String size, String colour) {
			
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
