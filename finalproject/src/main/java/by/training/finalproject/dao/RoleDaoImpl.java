package by.training.finalproject.dao;

import by.training.finalproject.dto.RoleDto;
import by.training.finalproject.entity.Role;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
public class RoleDaoImpl implements RoleDao {

    private static final String SELECT_ALL_ROLES_QUERY = "SELECT id, role_name FROM user_role";
    private DataSource dataSource;


    public RoleDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    @Override
    public List<RoleDto> findAll() throws DAOException {
        log.info("RoleDaoImpl findAll");

        List<Role> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(SELECT_ALL_ROLES_QUERY)) {
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                Role entity = parseResultSet(resultSet);
                result.add(entity);
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("ERROR, find all users ");
            throw new DAOException("ERROR, find all users", e);
        }
        return result.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void assignDefaultRoles(Long userId) throws SQLException {

    }

    @Override
    public void assignRole(Long roleId, Long userId) throws SQLException {

    }

    @Override
    public List<RoleDto> getUserRoles(Long userId) {
        return null;
    }

    @Override
    public Long save(RoleDto roleDto) throws DAOException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean update(RoleDto roleDto) throws DAOException, ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(RoleDto roleDto) throws ClassNotFoundException, DAOException {
        return false;
    }

    @Override
    public RoleDto getById(Long id) throws DAOException {
        return null;
    }

    private Role parseResultSet(ResultSet resultSet) throws SQLException {
        log.info("RoleDaoImpl parseResultSet");

        long entityId = resultSet.getLong("id");
        String name = resultSet.getString("role_name");
        return Role.builder()
                .id(entityId)
                .name(name)
                .build();
    }

    private RoleDto fromEntity(Role entity) {
        log.info("RoleDaoImpl fromEntity");

        RoleDto dto = new RoleDto();
        dto.setId(entity.getId());
        dto.setRoleName(entity.getName());

        return dto;
    }

}
