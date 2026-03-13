package db;
/**
 * Interface for database operations on {@link OrderLineItem} objects.
 * Supports inserting and retrieving {@link OrderLineItem} by order number.
 * 
 * @author Lau, Thimm
 * @version 11-3-2026
 */
import java.util.List;

import model.OrderLineItem;

public interface OrderLineItemDBIF {
	
	Boolean insert(OrderLineItem ol, int orderNo) throws DataAccessException;
	
	List<OrderLineItem> findOrderLinesByOrderNo(int orderNo) throws DataAccessException;

}
