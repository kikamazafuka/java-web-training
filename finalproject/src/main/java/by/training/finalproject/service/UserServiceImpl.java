package by.training.finalproject.service;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.dto.UserDto;
import lombok.extern.log4j.Log4j;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Log4j
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public boolean loginUser(UserDto userDto) {
        Optional<UserDto> byLogin;
        try {
            byLogin = userDao.findByLogin(userDto.getLogin());
        } catch (SQLException | DAOException e) {
            log.error("ERROR, Failed to read user", e);
            byLogin = Optional.empty();
        }
        return byLogin.filter(dto -> dto.getPassword().equals(userDto.getPassword())).isPresent();
    }

    @Override
    public boolean registerUser(UserDto userDto) {
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() throws ServiceException{
        try {
            return userDao.findAll();
        } catch (DAOException e) {
            log.error("ERROR, Failed to get all users", e);
            throw new ServiceException("ERROR, Getting all user from db", e);
        }
    }
}
