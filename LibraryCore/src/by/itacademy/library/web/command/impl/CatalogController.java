package by.itacademy.library.web.command.impl;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Book;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.impl.BookServiceImpl;
import by.itacademy.library.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class CatalogController implements Controller {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = new ArrayList<>(bookService.getAll());
        ArrayList<BookVO> bookVOS = new ArrayList<>();
        for (Book book : books) {
            BookVO bookVO = bookService.getBookVO(book);
            bookVOS.add(bookVO);
        }
        req.getSession().setAttribute("Msg", "");
        req.getSession().setAttribute("bookVOS", bookVOS);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
