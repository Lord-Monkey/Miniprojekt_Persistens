package db;

import java.util.List;

import model.SaleOrder;

public interface SaleOrderDBIF {

	public boolean insert(SaleOrder so) throws DataAccessException;
	
	List<SaleOrder> findAll() throws DataAccessException;

	SaleOrder findOrderByOrderNo(int orderNo) throws DataAccessException;

}
