package by.training.finalproject.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface ServletCommand {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException;
}