package db;

import java.util.List;

import model.SaleOrder;

public interface SaleOrderDBIF {

	public boolean addOrderToDB(SaleOrder so);
	
	List<SaleOrder> findAll() throws DataAccessException;

	List<SaleOrder> findOrderByOrderNo(SaleOrder orderNo) throws DataAccessException;

}
