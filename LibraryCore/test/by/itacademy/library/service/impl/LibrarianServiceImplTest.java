package by.itacademy.library.service.impl;

import by.itacademy.library.entities.Librarian;
import by.itacademy.library.service.LibrarianService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class LibrarianServiceImplTest {
    private LibrarianService librarianService;
    private Librarian librarian;

    @Before
    public void createLibrarian() {
        librarianService = LibrarianServiceImpl.getInstance();
        librarian = new Librarian();
        librarian.setName("����");
        librarian.setSecondName("��������");
        librarian.setSurname("������");
        librarian.setEmail("ffr@ww");
        librarian.setPassword("fvfdcsdv");
    }

    @Test
    public void saveAndGetBySurname() throws Exception {
        librarian = librarianService.save(librarian);
        Librarian newLibrarian = librarianService.getBySurname("������").get(0);
        librarian.setPassword(librarian.getPassword());
        Assert.assertEquals(librarian.toString(), newLibrarian.toString());
        librarianService.delete(newLibrarian.getLibrarianID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        librarianService.save(librarian);
        String newSurname = "�������";
        librarian = librarianService.getBySurname("������").get(0);
        librarian.setSurname(newSurname);
        librarianService.update(librarian);
        Librarian newLibrarian = librarianService.get(librarian.getLibrarianID());
        Assert.assertTrue(librarian.equals(newLibrarian));
        librarianService.delete(librarian.getLibrarianID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        librarianService.save(librarian);
        List<Librarian> librarians = librarianService.getAll();
        int oldSize = librarians.size();
        librarianService.delete(librarian.getLibrarianID());
        librarians = librarianService.getAll();
        Assert.assertEquals(oldSize - 1, librarians.size());
    }


}