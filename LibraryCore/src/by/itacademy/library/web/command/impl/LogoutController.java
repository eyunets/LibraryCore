package by.itacademy.library.web.command.impl;

import by.itacademy.library.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/frontController?command=main");
    }
}
