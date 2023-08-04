package by.training.finalproject.servlet;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.DataSource;
import by.training.finalproject.dao.RoleDaoImpl;
import by.training.finalproject.dao.UserDaoImpl;
import by.training.finalproject.dto.RoleDto;
import by.training.finalproject.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewAllUsers", urlPatterns = "/viewAllUsers")
public class ViewAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataSource dataSource = new DataSource();
        UserDaoImpl userDao = new UserDaoImpl(dataSource);


        List<UserDto> users = null;
        try {
            users = userDao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);//It's now available as ${roles} in EL.
        request.getRequestDispatcher("jsp/views/viewAllUsers.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("viewAllRoles.jsp").forward(request, response);

    }

}
