package db;

import java.util.List;

import model.OrderLineItem;

public interface OrderLineItemDBIF {
	
	Boolean insert(OrderLineItem ol) throws DataAccessException;
	
	List<OrderLineItem> findAll() throws DataAccessException;

}
