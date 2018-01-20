package by.itacademy.library.dao.impl;

import by.itacademy.library.dao.ReaderDAO;
import by.itacademy.library.entities.Reader;
import by.itacademy.library.web.auth.Encoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class ReaderDAOImplTest {
    private ReaderDAO readerDAO;
    private Reader reader;

    @Before
    public void createReader() {
        readerDAO = ReaderDAOImpl.getInstance();
        reader = new Reader();
        reader.setName("Иван");
        reader.setSecondName("Иванович");
        reader.setSurname("Козлов");
        reader.setBirthday(LocalDate.of(1996, 12, 1));
        reader.setEmail("ffr@ww");
        reader.setPassword("fvfdcsdv");
        reader.setGender("женский");
        reader.setStatus("");
    }

    @Test
    public void saveAndGetBySurname() throws Exception {
        reader = readerDAO.save(reader);
        reader.setPassword(Encoder.encode(reader.getPassword()));
        Reader newReader = readerDAO.getBySurname("Козлов").get(0);
        Assert.assertEquals(reader.toString(), newReader.toString());
        readerDAO.delete(reader.getReaderID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        readerDAO.save(reader);
        String newSurname = "Иванова";
        reader = readerDAO.getBySurname("Козлов").get(0);
        reader.setSurname(newSurname);
        readerDAO.update(reader);
        Reader newReader = readerDAO.get(reader.getReaderID());
        Assert.assertEquals(reader.getSurname(), newReader.getSurname());
        readerDAO.delete(reader.getReaderID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        readerDAO.save(reader);
        List<Reader> readers = readerDAO.getAll();
        int oldSize = readers.size();
        readerDAO.delete(reader.getReaderID());
        readers = readerDAO.getAll();
        Assert.assertEquals(oldSize - 1, readers.size());
    }
}