package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.OrderLineItem;
import model.SaleOrder;

/**
 * {@link SalesOrderDB} is a class that 
 * 
 * @author Christian Nordentoft
 * @version 11-3-2026
 */
public class SaleOrderDB implements SaleOrderDBIF {
	
	private static final String FIND_ALL_Q = "select orderNo, orderDate, deliveryStatus, deliveryDate,"
            + " discountGiven, mail from SaleOrder, Customer cdb WHERE customerId = cdb.id";
	
	private PreparedStatement findAllPS;
	
	private static final String INSERT_Q = "insert into SaleOrder(orderNo, orderDate, deliveryStatus,"
			+ " deliveryDate, discountGiven, freightID, customerID, invoiceID)"
			+ " VALUES(?, ?, ?, ?, ?, 1, (SELECT id FROM Customer WHERE mail = ?), 1)";
	
	private PreparedStatement INSERT_PS;
	
	private CustomerDBIF customerDB;
	
	private OrderLineItemDBIF oliDB;
	
	public SaleOrderDB() throws DataAccessException{
		try {
			findAllPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			INSERT_PS = DBConnection.getInstance().getConnection().prepareStatement(INSERT_Q);
			customerDB = new CustomerDB();
			oliDB = new OrderLineItemDB();
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
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws DataAccessException, SQLException {
		List<SaleOrder> foundSaleOrder = new ArrayList<SaleOrder>();
		SaleOrder tempSaleOrder = null;
		while(rs.next()) {
			tempSaleOrder = buildObject(rs);
			foundSaleOrder.add(tempSaleOrder);
		}
		return foundSaleOrder;
	}
	
	private SaleOrder buildObject(ResultSet rs) throws DataAccessException{
		SaleOrder so = null;
		try {
			if(rs.next()) {
				so = new SaleOrder();
				int orderNo = rs.getInt("orderNo");
				LocalDate date = rs.getDate("date").toLocalDate();
				String deliveryStatus = rs.getString("deliveryStatus");
				LocalDate deliveryDate = rs.getDate("deliveryDate").toLocalDate();
				boolean discountGiven = rs.getBoolean("discountGiven");
				String tempMail = rs.getString("mail");
				Customer c = customerDB.findCustomer(tempMail);
				List<OrderLineItem> oli = oliDB.findOrderLinesByOrderNo(orderNo);
				
				so.setOrderNo(orderNo);
				so.setDate(deliveryDate);
				so.setDeliveryStatus(deliveryStatus);
				so.setDeliveryDate(deliveryDate);
				so.setDiscountGiven(discountGiven);
				so.setCustomer(c);
				so.setOrderLines(oli);
			}
	} catch(SQLException e1) {
		throw new DataAccessException("Kunne ikke finde ordren", e1);
	}
	return so;
	}
	

	@Override
	public boolean insert(SaleOrder so) throws DataAccessException {
		boolean result = false;
		try {
			INSERT_PS.setInt(1, so.getOrderNo());
			INSERT_PS.setDate(2, Date.valueOf(so.getDate()));
			INSERT_PS.setString(3, so.getDeliveryStatus());
			INSERT_PS.setDate(4, Date.valueOf(so.getDeliveryDate()));
			INSERT_PS.setBoolean(5, so.getDiscountGiven());
			INSERT_PS.setString(6, so.getCustomer().getMail());
			for(OrderLineItem oli : so.getOrderLines()) {
				oliDB.insert(oli, so.getOrderNo());
			}
			int res = INSERT_PS.executeUpdate();
			if(res > 0) {
				result = true;
			}
		} catch(SQLException e) {
			throw new DataAccessException("Couldn't insert order", e);
		}
		return result;
	}

	@Override
	public List<SaleOrder> findOrderByOrderNo(SaleOrder orderNo) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}
