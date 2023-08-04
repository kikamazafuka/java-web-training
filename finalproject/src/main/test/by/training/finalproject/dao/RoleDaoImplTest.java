package by.training.finalproject.dao;

import by.training.finalproject.dto.RoleDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoleDaoImplTest {

    private DataSource dataSource = new DataSource();
    private RoleDaoImpl userDao = new RoleDaoImpl(dataSource);

    @Test
    public void findAll() {
        List<RoleDto> role = null;
        try {
            role = userDao.findAll();
            for (RoleDto r : role) {
                System.out.println(r.toString());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(3, role.size());


    }
}