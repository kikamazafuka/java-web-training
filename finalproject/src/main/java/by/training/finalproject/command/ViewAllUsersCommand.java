package by.training.finalproject.command;

import by.training.finalproject.dto.UserDto;
import by.training.finalproject.service.ServiceException;
import by.training.finalproject.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewAllUsersCommand implements ServletCommand {
    private UserServiceImpl userService;

    public ViewAllUsersCommand() {
        userService = new UserServiceImpl();
    }
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {

        List<UserDto> users = null;
        try {
            users = userService.getAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

            request.setAttribute("users", users);//It's now available as ${roles} in EL.
            request.getRequestDispatcher("jsp/views/viewAllUsers.jsp").forward(request, response);



    }
}
