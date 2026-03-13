package db;
/**
 * Exception thrown when a data access operation fails.
 * 
 * @author Aksel
 * @version 11-3-2026
 */
public class DataAccessException extends Exception {
	private static final long serialVersionUID = 1L;

	public DataAccessException(String message, Throwable e) {
		super(message, e);
	}
}
