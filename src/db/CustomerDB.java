package db;
/**
 * {@link CustomerDB} is a Database access class that retrieves customer data from the database and converts
 * the returned ResultSet into {@link Customer} objects.
 * 
 * Provides methods to find a {@link Customer} by email and 
 * retrieve all {@link Customer} from the database. 	
 * 
 * @author Aksel, Lau
 * @version 11-3-2026
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDB implements CustomerDBIF {

	private static final String FIND_ALL_Q = "select id, name, address, zipCode, city, mail, type from Customer";
	private PreparedStatement findAllCustomers;
	
	private static final String FIND_BY_EMAIL_Q = FIND_ALL_Q + " where mail = ?";
	private PreparedStatement findByEmail;
	
	public CustomerDB() throws DataAccessException{
		try {
			findAllCustomers = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_Q);
			findByEmail = DBConnection.getInstance().getConnection().prepareStatement(FIND_BY_EMAIL_Q);
		} catch (SQLException e) {
			throw new DataAccessException("Connection issue", e);
		}
	}
	
	@Override
	public Customer findCustomer(String mail) throws DataAccessException {
		ResultSet rs;
		try {
			findByEmail.setString(1, mail);
			rs = findByEmail.executeQuery();
			Customer c = null;
			if(rs.next()) {
				c = buildObject(rs);
			}
			return c;
		} catch(SQLException e) {
			throw new DataAccessException("Something went wrong finding customer", e);
		}
		
	}
	
	@Override
	public List<Customer> findAll() throws DataAccessException{
		ResultSet rs;
		try {
			rs = findAllCustomers.executeQuery();
			List<Customer> res = buildObjects(rs);
			return res;
		} catch(SQLException e) {
			throw new DataAccessException("Couldn't find all customers", e);
		}
	}
	
	
	private List<Customer> buildObjects(ResultSet rs) throws SQLException {
		List<Customer> foundCustomers = new ArrayList<Customer>();
		Customer tempCustomer = null;
		while(rs.next()) {
			tempCustomer = buildObject(rs);
			foundCustomers.add(tempCustomer);
		}
		return foundCustomers;
	}
	
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer foundCustomer = null;
		String name, address, city, mail, type;
		int zipcode;
		
		name = rs.getString("name");
		address = rs.getString("address");
		zipcode = rs.getInt("zipcode");
		city = rs.getString("city");
		mail = rs.getString("mail");
		type = rs.getString("type");
		
		foundCustomer = new Customer(name, address, zipcode, city, mail, type);
		return foundCustomer;
	}
}
