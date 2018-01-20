package by.itacademy.library.service.impl;

import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.ReaderService;
import by.itacademy.library.web.auth.Encoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class ReaderServiceImplTest {
    private ReaderService readerService;
    private Reader reader;

    @Before
    public void createReader() {
        readerService = ReaderServiceImpl.getInstance();
        reader = new Reader();
        reader.setName("����");
        reader.setSecondName("��������");
        reader.setSurname("������");
        reader.setBirthday(LocalDate.of(1996, 12, 1));
        reader.setEmail("ffr@ww");
        reader.setPassword("fvfdcsdv");
        reader.setGender("�������");
        reader.setStatus("");
    }

    @Test
    public void saveAndGetBySurname() throws Exception {
        reader = readerService.save(reader);
        reader.setPassword(Encoder.encode(reader.getPassword()));
        Reader newReader = readerService.getBySurname("������").get(0);
        Assert.assertEquals(reader.toString(), newReader.toString());
        readerService.delete(reader.getReaderID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        readerService.save(reader);
        String newSurname = "�������";
        reader = readerService.getBySurname("������").get(0);
        reader.setSurname(newSurname);
        readerService.update(reader);
        Reader newReader = readerService.get(reader.getReaderID());
        Assert.assertEquals(reader.getSurname(), newReader.getSurname());
        readerService.delete(reader.getReaderID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        readerService.save(reader);
        List<Reader> readers = readerService.getAll();
        int oldSize = readers.size();
        readerService.delete(reader.getReaderID());
        readers = readerService.getAll();
        Assert.assertEquals(oldSize - 1, readers.size());
    }

}