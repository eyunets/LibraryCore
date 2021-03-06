package by.itacademy.library.web.command.impl;

import by.itacademy.library.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/frontController?command=main");
    }
}
