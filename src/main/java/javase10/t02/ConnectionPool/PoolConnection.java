package javase10.t02.ConnectionPool;

import java.sql.Connection;

public interface PoolConnection {

    Connection getConnection();
    void putConnection(Connection c);
}
