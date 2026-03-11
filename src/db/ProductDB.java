package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Product;

public class ProductDB implements ProductDBIF {

	private static final String FIND_ALL_Q =
			"select type, productNumber, name, minStock, reservedStock from Product";
	private static final String FIND_BY_PRODUCTNUMBER =
			FIND_ALL_Q + "where id = ?";
	private PreparedStatement findAllPs, findByPN;
	
	public ProductDB() throws DataAccessException {
		try{
			findAllPs = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}

	
	public Product findProduct(int productNumber) {
		
		return null;
	}


	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
