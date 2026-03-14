package db;

/**
 * Interface for database operations on {@link SaleOrder} objects.
 * Supports inserting {@link SaleOrder}, retrieving all {@link SaleOrder},
 * and finding an {@link SaleOrder} by order number.
 * 
 * @author Lau, Mathias
 * @version 11-3-2026
 */
import java.util.List;

import model.SaleOrder;

public interface SaleOrderDBIF {

	boolean insert(SaleOrder so) throws DataAccessException;
	
	List<SaleOrder> findAll() throws DataAccessException;

	SaleOrder findOrderByOrderNo(int orderNo) throws DataAccessException;

	int getNewOrderNumber();

}
