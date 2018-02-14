package by.itacademy.library.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

	private static DataSource datasource;
	static ConnectionPool pool = new ConnectionPool();

	/**
	 *
	 * @return an instance of DataSource
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = pool.getConnectionFromPool();
		return connection;
	}

	public static void returnConnection(Connection connection) {
		pool.returnConnectionToPool(connection);
	}

	public static synchronized DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new DataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

}
