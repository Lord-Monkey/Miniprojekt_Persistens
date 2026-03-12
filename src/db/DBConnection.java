package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection connection = null;
	private static DBConnection dbConnection;

	private static final String DBNAME = "DMA-CSD-S251_10632163";
	private static final String SERVERNAME = "hildur.ucn.dk";
	private static final int SERVERPORT = 1433;
	private static final String USERNAME = "DMA-CSD-S251_10632163";
	private static final String PASSWORD = "Password1!";
	
	private DBConnection() throws SQLException {
		this.connection = createConnection();
	}

	private Connection createConnection() throws SQLException {
		String urlString = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false", SERVERNAME, SERVERPORT,
				DBNAME);
		return DriverManager.getConnection(urlString, USERNAME, PASSWORD);
	}

	public static DBConnection getInstance() throws SQLException {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public void startTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}

	public void commitTransaction() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}

	public void rollbackTransaction() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}

	public Connection getConnection() throws SQLException {
		if (connection == null) {
			this.connection = createConnection();
		}
		return connection;
	}

	public void disconnect() throws SQLException {
		if (connection != null) {
			try {
				connection.close();
			} finally {
				connection = null;
			}
		}
	}

}
