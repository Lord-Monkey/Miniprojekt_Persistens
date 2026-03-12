package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.OrderLineItem;
import model.Product;

public class OrderLineItemDB implements OrderLineItemDBIF {
	//Fields
	private static final String FIND_ALL_Q = "select id, orderId, productNumber, quantity"
			+ "From OrderLineItem";
	private PreparedStatement findAllPS;
	private static final String INSERT_Q = "INSERT INTO OrderLineItem (orderId, productId, quantity) values "
			+ "(?, "
			+ "(SELECT Id FROM Product WHERE productNumber = ?), "
			+ "(SELECT Id FROM SaleOrder WHERE orderNo = ?)";
	private PreparedStatement INSERT_PS;
	private ProductDBIF productDB;
	
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
	public Boolean insert(OrderLineItem oli, int orderNo) throws DataAccessException {
		boolean result = false;
		try {
			INSERT_PS.setInt(1, oli.getQuantity());
			INSERT_PS.setInt(2, oli.getProduct().getProductNumber());
			INSERT_PS.setInt(3, orderNo);
			int res = INSERT_PS.executeUpdate();
			if(res > 0) {
				result = true;
			}
		} catch (SQLException e) {
			throw new DataAccessException("Couldn't insert order line item", e);
		}
		return	result;
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
	
	private List<OrderLineItem> buildObjects(ResultSet rs) throws Exception {
		List<OrderLineItem> foundOrderLineItems = new ArrayList<OrderLineItem>();
		OrderLineItem tempOrderLineItem = null;
		while(rs.next()) {
			tempOrderLineItem = buildObject(rs);
			foundOrderLineItems.add(tempOrderLineItem);
		}
		return foundOrderLineItems;
	}
	
	private OrderLineItem buildObject(ResultSet rs) throws SQLException, DataAccessException {
		Product p;
		int quantity;
		int productNumber = rs.getInt("productNumber");
		quantity = rs.getInt("quantity");
		p = productDB.findProduct(productNumber);
		OrderLineItem oli = new OrderLineItem(p, quantity);
		return oli;
	}
}
