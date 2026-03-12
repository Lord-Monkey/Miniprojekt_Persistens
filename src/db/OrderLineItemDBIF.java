package db;

import java.util.List;

import model.OrderLineItem;
import model.SaleOrder;

public interface OrderLineItemDBIF {
	
	Boolean insert(OrderLineItem ol, int orderNo) throws DataAccessException;
	
	List<OrderLineItem> findOrderLinesByOrderNo(int orderNo) throws DataAccessException;

}
