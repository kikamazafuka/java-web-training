package by.training.finalproject.service;

import by.training.finalproject.dto.UserDto;

import java.util.List;


public interface UserService {

    boolean loginUser(UserDto userDto);

    boolean registerUser(UserDto userDto);

    List<UserDto> getAllUsers() throws ServiceException;
}
