package db;

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
	
	private static final String INSERT_Q = "insert into SaleOrder(orderNo, date, deliveryStatus,"
			+ " deliveryDate, discountGiven, c, orderLineItem)";
	
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
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
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
				
				
				
//				if(fullAssociation) {
//					List<SaleOrder> saleOrders = saleOrderDBIF.findOrderByOrderNo(so.getOrderNo());
//					so.setOrderNo(saleOrders)
//				}
			}
	} catch(SQLException e1) {
		throw new DataAccessException("Kunne ikke finde ordren");
	}
	return so;
	}
	

	
	public boolean insert(SaleOrder so) {
		
	}

	@Override
	public boolean addOrderToDB(SaleOrder so) {
		// TODO Auto-generated method stub
		return false;
	}
}
