package db;

import java.util.List;

import model.OrderLineItem;

public interface OrderLineItemDBIF {
	
	Boolean insert(OrderLineItem ol, int orderNo) throws DataAccessException;
	
	List<OrderLineItem> findOrderLinesByOrderNo(int orderNo) throws DataAccessException;

}
