package by.training.finalproject.servlet;

import by.training.finalproject.dao.*;
import by.training.finalproject.dto.RoleDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowRoles", urlPatterns = "/viewAllRoles")
public class ShowRoles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataSource dataSource = new DataSource();
        RoleDaoImpl userDao = new RoleDaoImpl(dataSource);


        List<RoleDto> roles = null;
        try {
            roles = userDao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        request.setAttribute("roles", roles);//It's now available as ${roles} in EL.
        request.getRequestDispatcher("jsp/views/viewAllRoles.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("viewAllRoles.jsp").forward(request, response);

    }

}
