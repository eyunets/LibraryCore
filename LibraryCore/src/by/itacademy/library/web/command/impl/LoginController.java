package by.itacademy.library.web.command.impl;

import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.ReaderService;
import by.itacademy.library.service.impl.ReaderServiceImpl;
import by.itacademy.library.web.auth.Encoder;
import by.itacademy.library.web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginController implements Controller {
    ReaderService readerService = ReaderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login == null || password == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
        Reader reader = readerService.getByLogin(login);
        if (reader != null && reader.getPassword().equals(Encoder.encode(password))) {
            //if (reader != null && password.equals(reader.getPassword())) {
            req.getSession().setAttribute("sreader", reader);
            req.getSession().setAttribute("errorMsg", "");
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=main");
            return;
        } else {
            req.getSession().setAttribute("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        }
    }
}
