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

public class ProductDB implements ProductDBIF {

	private static final String FIND_ALL_Q =
			"select type, productNumber, name, minStock, reservedStock, from Product"
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
				product.setName(name);
				product.setMinStock(minStock);
				product.setReserveQty(reservedStock);
				product.setCaliber(caliber);
				product.setMaterial(material);
				end = product;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return end;
	}
	
	public List<Product> buildObjects(ResultSet rs) throws SQLException{
		List<Product> result = new ArrayList<>();
		while(rs.next()) {
			result.add(buildObject(rs));
		}
		return result;
	}
}
