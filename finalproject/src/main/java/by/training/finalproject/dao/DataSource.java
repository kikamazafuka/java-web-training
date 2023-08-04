package by.training.finalproject.dao;

import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.sql.Connection;

@Log4j
public class DataSource {

    private ConnectionPoolImpl pool = new ConnectionPoolImpl();

    public  Connection getConnection() throws ClassNotFoundException, SQLException{
        log.info("DataSource get connection");
        Connection connection = pool.getConnection();
        return connection;
    }

    public void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}
