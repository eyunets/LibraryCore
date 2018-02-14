package by.itacademy.library.web.command.impl;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Book;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.impl.BookServiceImpl;
import by.itacademy.library.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BookCommand implements Command {

    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int bookID = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.get(bookID);
        BookVO bookVO = bookService.getBookVO(book);
        req.getSession().setAttribute("bookVO", bookVO);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
