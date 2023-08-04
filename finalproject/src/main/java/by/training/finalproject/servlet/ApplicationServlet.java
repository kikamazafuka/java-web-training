package by.training.finalproject.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/n")
public class ApplicationServlet extends HttpServlet {
    private static final long serialVersionUID = -898419077104540041L;
    private final static Logger LOG = Logger.getLogger(ApplicationServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* String commandName = req.getParameter("commandName");
        ServletCommand command = ApplicationContext.getInstance().getBean(commandName);
        if (command != null) {
            try {
                command.execute(req, resp);
            } catch (CommandException e) {
                throw new ServletException(e);
            }
        } else {
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        }*/
        String path = request.getServletPath();
        if (path.equals("/n")){
            request.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
        }
        else if (path.equals("/welcome")){
            request.getRequestDispatcher("/WEB-INF/view/customerinfo.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
