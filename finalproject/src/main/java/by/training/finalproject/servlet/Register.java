package by.training.finalproject.servlet;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.DataSource;
import by.training.finalproject.dao.UserDao;
import by.training.finalproject.dao.UserDaoImpl;
import by.training.finalproject.dto.ContactDto;
import by.training.finalproject.dto.UserDto;
import by.training.finalproject.entity.Role;
import by.training.finalproject.entity.RoleEnum;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name = "Register", urlPatterns = "/registrationUser")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DataSource dataSource = new DataSource();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

        Object roleParameter = request.getSession().getAttribute("currentUserRole");
        Role currentUserRole = null;
        if (roleParameter != null) {
            currentUserRole = (Role) roleParameter;
        }

        ContactDto contactDto = new ContactDto();
        contactDto.setFirstName(firstname);
        contactDto.setLastName(lastname);
        contactDto.setEmail(email);
        contactDto.setPhone(telephone);

        UserDto userDto = new UserDto();
        userDto.setLogin(login);
        userDto.setPassword(password);
        userDto.setRole(new Role());
        userDto.setContactDto(contactDto);

        UserDao userDao = new UserDaoImpl(dataSource);
        try {
            userDao.save(userDto);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("firstname", firstname);
        request.setAttribute("lastname", lastname);
        request.setAttribute("email", email);
        request.setAttribute("telephone", telephone);

        String url = "/jsp/views/customerinfo.jsp";
        request.getRequestDispatcher(url).forward(request, response);



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/views/registrationUser.jsp").forward(request, response);

    }
}