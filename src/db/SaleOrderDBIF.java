package db;

import java.util.List;

import model.SaleOrder;

public interface SaleOrderDBIF {

	public boolean addOrderToDB(SaleOrder so);
	public List<SaleOrder> findAll();
}
