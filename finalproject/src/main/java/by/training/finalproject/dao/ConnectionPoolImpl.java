package by.training.finalproject.dao;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPoolImpl implements ConnectionPool {
    List<Connection> availableConnections = new ArrayList<>();

    public ConnectionPoolImpl() {
        initializeConnectionPool();
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        if(availableConnections.size() > 0)
        {
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }
        return createProxyConnection(connection);
    }

    private Connection createNewConnectionForPool() {
        // get the configuration object to get the database configuration
        Configuration config = Configuration.getInstance();
        try {
            //load the Database driver using Class.forName
            //Class.forName(config.DB_DRIVER);                            isUnnecessary?
            // Create connection by using DriverManager
            Connection connection = (Connection) DriverManager.getConnection(
                    config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private void initializeConnectionPool()
    {
        while(!checkIfConnectionPoolIsFull())
        {
            availableConnections.add(createNewConnectionForPool());
        }
    }
    private synchronized boolean checkIfConnectionPoolIsFull() {
        final int MAX_POOL_SIZE = Configuration.getInstance().DB_MAX_CONNECTIONS;
        // check the connections size in the available connections
        if(availableConnections.size() < MAX_POOL_SIZE)
        {
            return false;
        }
        return true;
    }

    public synchronized void returnConnectionToPool(Connection connection) {
        availableConnections.add(connection);
    }

    private Connection createProxyConnection(Connection connection) {

        return (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> {
                    if ("close".equals(method.getName())) {
                        returnConnectionToPool(connection);
                        return null;
                    } else if ("hashCode".equals(method.getName())) {
                        return connection.hashCode();
                    } else {
                        return method.invoke(connection, args);
                    }
                });
    }
}
