package by.itacademy.library.db;

import java.sql.Connection;

public class ConnectionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     * @return new Connection from DataSource
     * @throws DBException in case of connection obtaining exceptions
     */
    public static Connection getConnection() throws DBException {
        try {
            if (tl.get() == null) {
                tl.set(DataSource.getInstance().getConnection());
            }
            return tl.get();
        } catch (Exception e) {
            throw new DBException("Connection is not established " + e.getMessage());
        }
    }
}
