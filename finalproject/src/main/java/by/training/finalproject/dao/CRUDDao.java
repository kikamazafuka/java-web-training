package by.training.finalproject.dao;

import java.util.List;
import java.sql.SQLException;

public interface CRUDDao<ENTITY, KEY> {

    KEY save(ENTITY entity) throws  DAOException, ClassNotFoundException, SQLException;

    boolean update(ENTITY entity) throws  DAOException, ClassNotFoundException, SQLException;

    boolean delete(ENTITY entity) throws  ClassNotFoundException, DAOException;

    ENTITY getById(KEY id) throws  DAOException;

    List<ENTITY> findAll() throws  DAOException;
}