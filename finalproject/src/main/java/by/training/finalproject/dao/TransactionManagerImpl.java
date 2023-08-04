package by.training.finalproject.dao;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j
public class TransactionManagerImpl implements TransactionManager {
    private Connection connection;
    private DataSource dataSource;

    public void beginTransaction() {
        try {
            if (this.connection == null) {
                connection = dataSource.getConnection();
                connection.setAutoCommit(false);
            } else {
                throw new IllegalStateException("Transaction had already started.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void commitTransaction() {
        try {
            if (connection != null) {
                connection.commit();
                connection.setAutoCommit(true);
                connection.close();
                connection = null;
            } else {
                throw new NullPointerException("Method endTransaction was used before this transaction's beginning");
            }

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void rollbackTransaction() {
        try {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
                connection.close();
                connection = null;
            } else {
                throw new NullPointerException("Method rollback was used before this transaction's beginning");
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
