package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Product;

public class ProductDB implements ProductDBIF {

	private static final String FIND_ALL_Q =
			"select type, productNumber, name, minStock, reservedStock, from Product"
			+ "LEFT JOIN GunReplica gun on gun.productID = pro.productID"
			+ "where pro.productID = ?";
	private static final String FIND_BY_PRODUCTNUMBER =
			FIND_ALL_Q + "where id = ?";
	private PreparedStatement findAllPS, findByPN;
	
	public ProductDB() throws DataAccessException {
		try{
			findAllPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			findByPN = DBConnection.getInstance().getConnection().prepareStatement(FIND_BY_PRODUCTNUMBER);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}

	
	public Product findProduct(int productNumber) throws DataAccessException {
		try {
			findByPN.setInt(1, productNumber);
			ResultSet rs = findByPN.executeQuery();
			Product p = null;
			if(rs.next()) {
				p = buildObject(rs);
			}
			return p;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find the specified product with product number = " + productNumber, e);
		}
	}


	public List<Product> findAll() {
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<Product> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve all products", e);
		}
	}

	public Product buildObject(ResultSet rs) {
		Product p = new Product();
	}
}
