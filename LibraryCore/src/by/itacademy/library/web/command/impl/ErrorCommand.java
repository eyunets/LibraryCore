package by.itacademy.library.web.command.impl;

import by.itacademy.library.service.ReaderService;
import by.itacademy.library.service.impl.ReaderServiceImpl;
import by.itacademy.library.web.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ErrorCommand implements Command {
    ReaderService readerService = ReaderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        req.setAttribute("title", "error");
        dispatcher.forward(req, resp);
        return;
    }
}
