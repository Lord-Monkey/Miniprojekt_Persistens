import controller.CustomerCtr;
import controller.ProductCtr;
import controller.SalesOrderCtr;
import db.DataAccessException;
import model.SaleOrder;

import java.util.ArrayList;


public class Test {

	public static void main(String[] args) throws DataAccessException {
		CustomerCtr cctr = new CustomerCtr();
		SalesOrderCtr soctr = new SalesOrderCtr();
		ProductCtr pctr = new ProductCtr();
		ArrayList<SaleOrder> sol = (ArrayList<SaleOrder>) soctr.findAll();
		SaleOrder so = null;
		so = sol.get(0);
		System.out.println(sol.size());
		if(so != null) {
			System.out.println("Wuuh");
		}
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
