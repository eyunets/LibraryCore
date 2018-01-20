package by.itacademy.library.web.command.impl;

import by.itacademy.library.VO.ReaderVO;
import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.ReaderService;
import by.itacademy.library.service.impl.ReaderServiceImpl;
import by.itacademy.library.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ReadersController implements Controller {
    private ReaderService readerService = ReaderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Reader> readers = new ArrayList<>(readerService.getAll());
        ArrayList<ReaderVO> readerVOS = new ArrayList<>();
        for (Reader reader : readers) {
            ReaderVO readerVO = readerService.getReaderVO(reader);
            readerVOS.add(readerVO);
        }

        req.getSession().setAttribute("readerVOS", readerVOS);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }
}
