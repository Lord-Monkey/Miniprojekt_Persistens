package db;

import java.sql.PreparedStatement;

public class OrderLineItemDB implements OrderLineItemDBIF {
	//Fields
	private static final String FIND_ALL_Q = "select id, orderId, productNumber, quantity";
	private PreparedStatement findAllPS;
	
	private static final String INSERT_Q = "insert into OrderLineItem (orderId,"
			+ " productNumber, quantity) values (?, ?, ?)";
	private PreparedStatement insertPS;

}
