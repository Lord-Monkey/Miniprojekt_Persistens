package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.SaleOrder;

/**
 * {@link SalesOrderDB} is a class that 
 * 
 * @author Christian Nordentoft
 * @version 11-3-2026
 */
public class SaleOrderDB {
	
	private String FIND_ALL_Q;
	private PreparedStatement findAllPS;
	private String insert_Q;
	private PreparedStatement INSERT_PS;
	
	public SaleOrderDB(){
		 
	}
	
	public List<SaleOrderDB> findAll() {
		
	}
	
	private List<SaleOrder> buildObjects(ResultSet rs){
		
	}
	
	private SaleOrder buildObject(ResultSet rs) {
		
	}
	
	public boolean insert(SalesOrder so) {
		
	}
}
