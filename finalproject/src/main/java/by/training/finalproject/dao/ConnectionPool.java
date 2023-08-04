package by.training.finalproject.dao;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
}
