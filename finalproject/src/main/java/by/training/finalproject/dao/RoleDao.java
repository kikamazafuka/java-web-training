package by.training.finalproject.dao;

import by.training.finalproject.dto.RoleDto;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao extends CRUDDao<RoleDto, Long> {

    void assignDefaultRoles(Long userId) throws SQLException;

    void assignRole(Long roleId, Long userId) throws SQLException;

    List<RoleDto> getUserRoles(Long userId);
}
