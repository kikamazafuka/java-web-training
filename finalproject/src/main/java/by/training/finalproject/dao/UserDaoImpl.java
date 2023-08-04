package by.training.finalproject.dao;

import by.training.finalproject.entity.UserEntity;
import by.training.finalproject.dto.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserDaoImpl implements UserDao {

    private static final String SELECT_ALL_QUERY = "SELECT user_account.id, user_account.login, user_account.password," +
            "user_role.role_name FROM user_account " +
            "INNER JOIN user_role ON user_account.user_role_id=user_role.id " +
            "WHERE user_role.role_name != 'ADMIN'";
    private static final String SELECT_BY_ID_QUERY = "SELECT user_account.login, user_account.password," +
            " user_role.role_name " +
            "FROM user_account " +
            "INNER JOIN user_role ON user_account.user_role_id=user_role.id " +
            "WHERE user_account.id = ?";
    private static final String SELECT_BY_LOGIN_QUERY = "SELECT user_account.id, user_account.login, user_account.password, user_role.role_name " +
            "FROM user_account " +
            "INNER JOIN user_role ON user_account.user_role_id=user_role.id " +
            "WHERE user_account.login = ?";
    private static final String INSERT_QUERY = "INSERT INTO user_account (login, password, user_role_id) " +
            "VALUES (?,?, (SELECT id FROM user_role WHERE role_name = ?))";
    private static final String UPDATE_QUERY = "UPDATE user_account SET login = ?, password = ?, user_role_id = " +
            "(SELECT id FROM user_role WHERE role_name = ?) WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM user_account WHERE id = ?";
    private final static AtomicLong COUNTER = new AtomicLong(1);

    private DataSource dataSource;

    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Long save(UserDto userDto) throws DAOException, SQLException, ClassNotFoundException {
        log.info("UserDaoImpl save");

        UserEntity entity = fromDto(userDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            int i = 0;
            //insertStmt.setLong(++i, COUNTER.getAndIncrement());
            insertStmt.setString(++i, entity.getLogin());
            insertStmt.setString(++i, entity.getPassword());
            insertStmt.setString(++i, entity.getRole().toString());
            insertStmt.executeUpdate();
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            while (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
            }
        }

        return entity.getId();
    }

    @Override
    public boolean update(UserDto userDto) throws DAOException, SQLException, ClassNotFoundException {
        log.info("UserDaoImpl update");

        UserEntity entity = fromDto(userDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(UPDATE_QUERY)) {
            int i = 0;
            updateStmt.setString(++i, entity.getLogin());
            updateStmt.setString(++i, entity.getPassword());
            updateStmt.setLong(++i, entity.getId());
            updateStmt.setString(++i, entity.getRole().toString());
            return updateStmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(UserDto userDto) throws  DAOException {
        log.info("UserDaoImpl delete");

        UserEntity entity = fromDto(userDto);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement updateStmt = connection.prepareStatement(DELETE_QUERY)) {
            updateStmt.setLong(1, entity.getId());
            return updateStmt.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, delete user");
            throw new DAOException("ERROR, delete user", e);
        }
    }

    @Override
    public UserDto getById(Long id) throws DAOException {
        log.info("UserDaoImpl getById");

        List<UserEntity> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            selectStmt.setLong(1, id);
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, get by user id ");
            throw new DAOException("ERROR, et by user id", e);

        }

        return result.stream().map(this::fromEntity).findFirst().orElseThrow(()
                -> new IllegalArgumentException("Entity not found with given id: " + id));
    }

    @Override
    public List<UserDto> findAll() throws DAOException {
        log.info("UserDaoImpl findAll");

        List<UserEntity> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, find all users ");
            throw new DAOException("ERROR, find all users", e);
        }
        return result.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findByLogin(String login) throws DAOException {
        log.info("UserDaoImpl findByLogin");

        List<UserEntity> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_BY_LOGIN_QUERY)) {
            selectStmt.setString(1, login);
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, find all users ");
            throw new DAOException("ERROR, find all users", e);
        }

        return result.stream().map(this::fromEntity).findFirst();
    }

    private UserEntity parseResultSet(ResultSet resultSet) throws SQLException {
        log.info("UserDaoImpl parseResultSet");

        long entityId = resultSet.getLong("id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        return UserEntity.builder()
                .id(entityId)
                .login(login)
                .password(password)
                .build();
    }

    private UserEntity fromDto(UserDto dto) {
        log.info("UserDaoImpl fromDto");

        UserEntity entity = new UserEntity();
        try {
            entity.setId(dto.getId());
            entity.setLogin(dto.getLogin());
            entity.setPassword(dto.getPassword());
            entity.setRole(dto.getRole());
        }catch (NullPointerException e){
            log.error("ERROR, null", e);
        }
        return entity;
    }

    private UserDto fromEntity(UserEntity entity) {
        log.info("UserDaoImpl fromEntity");

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());

        return dto;
    }
}
