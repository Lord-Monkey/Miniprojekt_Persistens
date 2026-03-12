import controller.CustomerCtr;
import controller.ProductCtr;
import controller.SalesOrderCtr;
import db.DataAccessException;

public class Test {

	public static void main(String[] args) throws DataAccessException {
		CustomerCtr cctr = new CustomerCtr();
		SalesOrderCtr soctr = new SalesOrderCtr();
		ProductCtr pctr = new ProductCtr();
		
		if(cctr != null) {
			System.out.println("cctr works");
		}
		
		if(soctr != null) {
			System.out.println("soctr works");
			
		if(pctr != null) {
			System.out.println("pctr works");
		}
	}
	}
}
