package by.training.finalproject.dao;

import by.training.finalproject.dto.UserDto;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao extends CRUDDao<UserDto, Long> {

    Optional<UserDto> findByLogin(String login) throws SQLException, DAOException;
}

