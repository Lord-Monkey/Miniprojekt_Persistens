package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.SaleOrder;
import model.Vehicle;

/**
 * {@link SalesOrderDB} is a class that 
 * 
 * @author Christian Nordentoft
 * @version 11-3-2026
 */
public class SaleOrderDB implements SaleOrderDBIF {
	
	private static final String FIND_ALL_Q = "select orderNo, date, deliveryStatus, deliveryDate,"
			+ " discountGiven, c, orderLineItem from SaleOrder ";
	private PreparedStatement findAllPS;
	
	private static final String INSERT_Q = "insert into SaleOrder(orderNo, date, deliveryStatus,"
			+ " deliveryDate, discountGiven, c, orderLineItem)";
	private PreparedStatement INSERT_PS;
	
	public SaleOrderDB() throws DataAccessException{
		try {
			findAllPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			INSERT_PS = DBConnection.getInstance().getConnection().prepareStatement(INSERT_Q);
		} catch (SQLException e) {
			throw new DataAccessException("Connection issue", e);
		}
	}
	
	public List<SaleOrder> findAll() throws DataAccessException{
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<SaleOrder> res = buildObjects(rs);
			return res;
		} catch(SQLException e) {
			throw new DataAccessException("Couldn't find all saleorders", e);
		}
	}
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
		List<SaleOrder> foundSaleOrder = new ArrayList<SaleOrder>();
		SaleOrder tempSaleOrder = null;
		while(rs.next()) {
			tempSaleOrder = buildObject(rs);
			foundSaleOrder.add(tempSaleOrder);
		}
		return foundSaleOrder;
	}
	
	private SaleOrder buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException{
		SaleOrder so = null;
		try {
			if(rs.next()) {
				so = new SaleOrder(
						rs.getInt("id"),
						rs.getDate("date").toLocalDate(),
						rs.getBoolean("deliveryStatus"),
						rs.getDate("deliveryDate").toLocalDate(),
						rs.getBoolean("discountGiven"),
						rs.getString("c"),
						rs.getFloat("orderLineItem")
						);
				if(fullAssociation) {
					List<SaleOrder> saleOrders = saleOrderDBIF.findOrderByOrderNo();
				}
			}
	}
	
	private Employee buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
		Employee e = null;
		try {
			if(rs.next()) {
				e = new Employee(
						rs.getInt("id"),
						rs.getString("initials"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getDate("employmentdate").toLocalDate()
						);
				if(fullAssociation) {
					List<Vehicle> vehicles = vehicleDao.findByEmployeeId(e.getId());
					e.setVehicles(vehicles);
				}
			}
		} catch (SQLException e1) {
			throw new DataAccessException("Could not read result set for employee", e1);
		}
		return e;
	}

	
	public boolean insert(SaleOrder so) {
		
	}

	@Override
	public boolean addOrderToDB(SaleOrder so) {
		// TODO Auto-generated method stub
		return false;
	}
}
