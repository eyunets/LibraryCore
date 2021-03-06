package by.itacademy.library.dao.impl;

import by.itacademy.library.dao.BookDAO;
import by.itacademy.library.entities.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class BookDAOImplTest {
    private BookDAO bookDAO;
    private Book book;

    @Before
    public void createBook() {
        bookDAO = BookDAOImpl.getInstance();
        book = new Book();
        book.setName("�����");
        book.setIsbn("03293849310");
        book.setGenre("�����");
        book.setYear(1996);
        book.setQuantity(42);
    }

    @Test
    public void saveAndGetByName() throws Exception {
        bookDAO.save(book);
        Book newBook = bookDAO.getByName("�����").get(0);
        Assert.assertTrue(book.equals(newBook));
        bookDAO.delete(newBook.getBookID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        bookDAO.save(book);
        book = bookDAO.getByName("�����").get(0);
        book.setName("�� �����");
        bookDAO.update(book);
        Book newBook = bookDAO.get(book.getBookID());
        Assert.assertTrue(book.equals(newBook));
        bookDAO.delete(book.getBookID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        bookDAO.save(book);
        List<Book> books = bookDAO.getAll();
        int oldSize = books.size();
        bookDAO.delete(book.getBookID());
        books = bookDAO.getAll();
        Assert.assertEquals(oldSize - 1, books.size());
    }
}