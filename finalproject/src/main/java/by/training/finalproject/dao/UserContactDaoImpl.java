package by.training.finalproject.dao;

import by.training.finalproject.dto.ContactDto;
import by.training.finalproject.entity.UserContact;
import lombok.extern.log4j.Log4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Log4j
public class UserContactDaoImpl implements UserContactDao {

    private static final String SELECT_ALL_CONTACTS_QUERY = "SELECT id, first_name, last_name, email, phone, user_account_id FROM user_contact";
    private static final String SELECT_CONTACT_BY_ID_QUERY = "SELECT first_name, last_name, email, phone, user_account_id FROM user_contact WHERE id = ?";
    private static final String INSERT_CONTACT_QUERY = "INSERT INTO user_info (first_name, last_name, email, phone, user_account_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_CONTACT_QUERY = "UPDATE user_info SET first_name = ?, last_name = ?, email = ?, phone = ?, user_account_id = ? WHERE id = ?";
    private static final String DELETE_CONTACT_BY_ID_QUERY = "DELETE FROM user_contact WHERE id = ?";
    private static final String SELECT_CONTACT_BY_USER_ID_QUERY = "SELECT id, first_name, last_name, email, phone FROM user_contact WHERE user_account_id = ?";
    private static final String SELECT_CONTACT_BY_EMAIL_QUERY = "SELECT id, first_name, last_name, email, phone FROM user_contact WHERE email = ?";
    private final static AtomicLong COUNTER = new AtomicLong(1);

    private DataSource dataSource;

    public UserContactDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Long save(ContactDto contactDto) throws DAOException, ClassNotFoundException, SQLException {
        log.info("UserContactDaoImpl save");
        UserContact entity = fromDto(contactDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(INSERT_CONTACT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            int i = 0;
            insertStmt.setLong(++i, COUNTER.getAndIncrement());
            insertStmt.setString(++i, entity.getFirstName());
            insertStmt.setString(++i, entity.getLastName());
            insertStmt.setString(++i, entity.getEmail());
            insertStmt.setString(++i, entity.getPhone());
            insertStmt.setLong(++i, entity.getUserId());
            insertStmt.executeUpdate();
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            while (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
        }
        return entity.getId();
    }

    @Override
    public boolean update(ContactDto contactDto) throws DAOException, ClassNotFoundException, SQLException {
        log.info("UserContactDaoImpl update");

        UserContact entity = fromDto(contactDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(UPDATE_CONTACT_QUERY)) {
            int i = 0;
            updateStmt.setString(++i, entity.getFirstName());
            updateStmt.setString(++i, entity.getLastName());
            updateStmt.setString(++i, entity.getEmail());
            updateStmt.setString(++i, entity.getPhone());
            updateStmt.setLong(++i, entity.getUserId());
            return updateStmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(ContactDto contactDto) throws ClassNotFoundException, DAOException {
        log.info("UserContactDaoImpl delete");

        UserContact entity = fromDto(contactDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(DELETE_CONTACT_BY_ID_QUERY)) {
            updateStmt.setLong(1, entity.getId());
            return updateStmt.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, delete user");
            throw new DAOException("ERROR, delete user");
        }
    }

    @Override
    public ContactDto getById(Long id) throws DAOException {
        log.info("UserContactDaoImpl getById");

        List<UserContact> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_CONTACT_BY_ID_QUERY)) {
            selectStmt.setLong(1, id);
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                UserContact entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, get by user id ");
            throw new DAOException("ERROR, et by user id");

        }

        return result.stream().map(this::fromEntity).findFirst().orElseThrow(()
                -> new IllegalArgumentException("Entity not found with given id: " + id));
    }

    @Override
    public List<ContactDto> findAll() throws DAOException {
        log.info("UserContactDaoImpl findAll");

        List<UserContact> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_ALL_CONTACTS_QUERY)) {
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                UserContact entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, find all users ");
            throw new DAOException("ERROR, find all users");
        }
        return result.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    //TODO get contact by user id

    @Override
    public ContactDto getContactByUserId(long userId) throws DAOException {
        return null;
    }

    private UserContact parseResultSet(ResultSet resultSet) throws SQLException {
        log.info("UserContactDaoImpl parseResultSet");

        long entityId = resultSet.getLong("id");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        String email = resultSet.getString("email");
        String telephone = resultSet.getString("telephone");
        long userId = resultSet.getLong("user_account_id");
        return UserContact.builder()
                .id(entityId)
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .phone(telephone)
                .userId(userId)
                .build();
    }

    private UserContact fromDto(ContactDto dto) {
        log.info("UserContactDaoImpl fromDto");

        UserContact entity = new UserContact();
        try {
            entity.setId(dto.getId());
            entity.setFirstName(dto.getFirstName());
            entity.setLastName(dto.getLastName());
            entity.setEmail(dto.getEmail());
            entity.setPhone(dto.getPhone());
            entity.setUserId(dto.getUserId());
        }catch (NullPointerException e){
            log.error("ERROR, null");
        }
        return entity;
    }

    private ContactDto fromEntity(UserContact entity) {
        log.info("UserContactDaoImpl fromEntity");

        ContactDto dto = new ContactDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setUserId(entity.getUserId());

        return dto;
    }


}
