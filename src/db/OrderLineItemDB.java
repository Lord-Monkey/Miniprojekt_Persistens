package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.OrderLineItem;
import model.Product;

public class OrderLineItemDB implements OrderLineItemDBIF {
	//Fields
	private static final String FIND_ALL_Q = "select id, orderId, productNumber, quantity"
			+ "From OrderLineItem";
	private PreparedStatement findAllPS;
	
	private static final String INSERT_Q = "insert into OrderLineItem (orderId,"
			+ " productNumber, quantity) values (?, ?, ?)";
	private PreparedStatement INSERT_PS;
	private ProductDB productDB;
	
	public OrderLineItemDB() throws DataAccessException {
		try {
			findAllPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			INSERT_PS = DBConnection.getInstance().getConnection().prepareStatement(INSERT_Q);
			productDB = new ProductDB();
		} catch (Exception e) {
			throw new DataAccessException("Couldn't connect to database", e);
		}
	}

	@Override
	public Boolean insert(OrderLineItem ol) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLineItem> findAll() throws DataAccessException {
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<OrderLineItem> res = buildObjects(rs);
			return res;
		} catch (Exception e) {
			throw new DataAccessException("Couldn't find all order line items", e);
		}
	}
	
	public List<OrderLineItem> buildObjects(ResultSet rs) throws Exception {
		List<OrderLineItem> foundOrderLineItems = new java.util.ArrayList<OrderLineItem>();
		OrderLineItem tempOrderLineItem = null;
		while(rs.next()) {
			tempOrderLineItem = buildObject(rs);
			foundOrderLineItems.add(tempOrderLineItem);
		}
		return foundOrderLineItems;
	}
	
	public OrderLineItem buildObject(ResultSet rs) throws SQLException {
		Product p;
		int quantity;
		
		int productNumber = rs.getInt("productNumber");
		quantity = rs.getInt("quantity");
		
		p = productDB.findProduct(productNumber);
		
		OrderLineItem ol = new OrderLineItem(p, quantity);
		return ol;
	}

}
