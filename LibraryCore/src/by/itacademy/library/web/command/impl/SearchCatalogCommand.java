package by.itacademy.library.web.command.impl;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Book;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.impl.BookServiceImpl;
import by.itacademy.library.web.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class SearchCatalogCommand implements Command {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name.length() < 3 || name.length() > 30) {
            req.getSession().setAttribute("bookVOS", null);
            req.getSession().setAttribute("Msg", "Invalid input");
            RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
            dispatcher.forward(req, resp);
            return;
        } else {
            ArrayList<Book> books = new ArrayList<>(bookService.searchByName(name));
            if (books.isEmpty()) {
                req.getSession().setAttribute("bookVOS", null);
                req.getSession().setAttribute("Msg", "No books match your input");
                RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
                dispatcher.forward(req, resp);
                return;
            } else {
                ArrayList<BookVO> bookVOS = new ArrayList<>();
                for (Book book : books) {
                    BookVO bookVO = bookService.getBookVO(book);
                    bookVOS.add(bookVO);
                }

                req.getSession().setAttribute("bookVOS", bookVOS);
                req.getSession().setAttribute("Msg", "");
                RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
                dispatcher.forward(req, resp);
                return;
            }

        }
    }
}
