package javase10.t02.ConnectionPool;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectionPool implements PoolConnection {
    private static String URL;
    private static String LOGIN;
    private static String PASSWORD;
    private static Driver driver;

    private static PriorityQueue<Connection> readyToUse;
    private static ArrayList<Connection> alreadyInUse;

    ConnectionPool() {
         this.URL = "jdbc:mysql://localhost:3306/users";
         this.LOGIN = "root";
         this.PASSWORD = "root";
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            readyToUse = new PriorityQueue<Connection>();
            alreadyInUse = new ArrayList<>();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    @Override
    synchronized public Connection getConnection() {
        if(readyToUse.size()==0)
        {
            try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
                alreadyInUse.add(connection);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            Connection connection = readyToUse.poll();
            return connection;
    }

    @Override
    synchronized public void putConnection(Connection connection) {
        if(connection != null) {
            alreadyInUse.remove(connection);
            readyToUse.add(connection);
        }
    }

}
