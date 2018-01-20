package by.itacademy.library.web.command.impl;

import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.ReaderService;
import by.itacademy.library.service.impl.ReaderServiceImpl;
import by.itacademy.library.web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BanReaderController implements Controller {
    private ReaderService readerService = ReaderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reader reader = readerService.get(Integer.parseInt(req.getParameter("readerID")));
        if (reader.getStatus().equals("BANNED")) {
            reader.setStatus("ACTIVE");
        } else {
            reader.setStatus("BANNED");
        }
        //System.out.println("Status of " + reader.getName() + ": " + reader.getStatus());
        readerService.update(reader);
        //Reader newReader = readerService.get(reader.getReaderID());
        //System.out.println("Status 2 " + newReader.getName() + ": " + newReader.getStatus());
    }
}
