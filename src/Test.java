import controller.CustomerCtr;
import controller.ProductCtr;
import controller.SalesOrderCtr;
import db.DataAccessException;
import db.SaleOrderDB;
import model.OrderLineItem;
import model.SaleOrder;

import java.util.List;


public class Test {

	public static void main(String[] args) throws DataAccessException {
		CustomerCtr cctr = new CustomerCtr();
		SalesOrderCtr soctr = new SalesOrderCtr();
		ProductCtr pctr = new ProductCtr();
		
		SaleOrderDB sodb = new SaleOrderDB();
		List<SaleOrder> sol = sodb.findAll();
		SaleOrder 
//		so = sol.get(0);
		so = sodb.findOrderByOrderNo(1);
		
		System.out.println(sol.size());
		System.out.println(so.getCustomer());
		System.out.println(so.getOrderNo());
		System.out.println(so.getDate());
		System.out.println(so.getDeliveryStatus());
		System.out.println(so.getDiscountGiven());
		System.out.println(so.getDeliveryDate());
		List<OrderLineItem> olil = so.getOrderLines();
		for(OrderLineItem oli : olil) {
			System.out.println(oli.getProduct().getName());
		}
		
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
