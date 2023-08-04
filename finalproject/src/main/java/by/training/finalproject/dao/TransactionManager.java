package by.training.finalproject.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface TransactionManager {
    void beginTransaction() throws SQLException;

    void commitTransaction() throws SQLException;

    void rollbackTransaction() throws SQLException;

    Connection getConnection();
}
