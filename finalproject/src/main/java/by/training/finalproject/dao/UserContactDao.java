package by.training.finalproject.dao;

import by.training.finalproject.dto.ContactDto;

public interface UserContactDao extends CRUDDao<ContactDto, Long> {
    ContactDto getContactByUserId(long userId) throws DAOException;
}
