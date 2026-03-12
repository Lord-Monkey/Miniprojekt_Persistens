package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;
import model.ProductTypeEnum;
import model.ProductTypeEnumHelper;

/**
 * Sends queries to the database and gets a ResultSet back
 * Uses prepared statements to execute queries
 * Also implements methods to build new product object through the model layer
 */
public class ProductDB implements ProductDBIF {

	private static final String FIND_ALL_Q =
			"select pro.id, type, productNumber, name, minStock, reservedStock, from Product pro"
					+ "LEFT JOIN GunReplica gun on gun.ID = pro.ID"
					+ "LEFT JOIN Equipment equip on equip.ID = pro.ID"
					+ "LEFT JOIN Clothing cloth on cloth.ID = pro.ID";
	private static final String FIND_BY_PRODUCTNUMBER =
			FIND_ALL_Q + "where pro.id = ?";
	private PreparedStatement findAllPS, findByPN;

	public ProductDB() throws DataAccessException {
		try{
			findAllPS = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			findByPN = DBConnection.getInstance().getConnection().prepareStatement(FIND_BY_PRODUCTNUMBER);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}

	/**
	 * Will access the database with a query made from a prepared statement.
	 * Receives a ResultSet back from the database.
	 * Method needs a specified product number of the type int.
	 * The method then calls another method to build the object, before returning the product
	 * @param	productNumber	An int to determine which product that needs to be found
	 * @return					The product found in the database
	 */
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
			throw new DataAccessException("Could not find the product with product number = " + productNumber, e);
		}
	}

	/**
	 * Will access the database with a query made from a prepared statement.
	 * Receives a ResultSet back from the database.
	 * The method will find all the products currently in the database
	 * The method then calls another method, which handles making a list
	 * with the results and returns the list.
	 * @return		An ArrayList with all the products from the database
	 */
	public List<Product> findAll() throws DataAccessException {
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<Product> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve all products", e);
		}
	}

	public Product buildObject(ResultSet rs) throws DataAccessException {
		Product end = null;
		String productString, name;
		int productNumber, minStock, reservedStock;

		try {
			productString = rs.getString("type"); name = rs.getString("name");
			productNumber = rs.getInt("productNumber"); minStock = rs.getInt("minStock"); reservedStock = rs.getInt("reservedStock");


			ProductTypeEnumHelper pteh = new ProductTypeEnumHelper();
			ProductTypeEnum ptEnum = pteh.buildEnum(productString);

			if(ptEnum.equals(pteh.buildEnum("CLOTHING"))) {
				String colour = rs.getString("colour");
				String size = rs.getString("size");
				Clothing product = new Clothing();
				product.setProductNumber(productNumber);
				product.setName(name);
				product.setMinStock(minStock);
				product.setReserveQty(reservedStock);
				product.setColour(colour);
				product.setSize(size);
				end = product;
			} 
			else if(ptEnum.equals(pteh.buildEnum("EQUIPMENT"))) {
				String material = rs.getString("material");
				String style = rs.getString("style");
				Equipment product = new Equipment();
				product.setProductNumber(productNumber);
				product.setName(name);
				product.setMinStock(minStock);
				product.setReserveQty(reservedStock);
				product.setMaterial(material);
				product.setStyle(style);
				end = product;
			} 
			else if(ptEnum.equals(pteh.buildEnum("GUNREPLICA"))) {
				String caliber = rs.getString("caliber");
				String material = rs.getString("material");
				GunReplica product = new GunReplica();
				product.setProductNumber(productNumber);
				product.setName(name);
				product.setMinStock(minStock);
				product.setReserveQty(reservedStock);
				product.setCaliber(caliber);
				product.setMaterial(material);
				end = product;
			}

		} catch (SQLException e) {
			throw new DataAccessException("Could not identify the type of product found", e);}
		return end;
	}

	public List<Product> buildObjects(ResultSet rs) throws SQLException, DataAccessException{
		List<Product> result = new ArrayList<>();
		while(rs.next()) {
			result.add(buildObject(rs));
		}
		return result;
	}
}
