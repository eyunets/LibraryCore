package by.itacademy.library.service.impl;

import by.itacademy.library.entities.Book;
import by.itacademy.library.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookServiceImplTest {
    private BookService bookService;
    private Book book;

    @Before
    public void createBook() {
        bookService = BookServiceImpl.getInstance();
        book = new Book();
        book.setName("Книга");
        book.setIsbn("03293849310");
        book.setGenre("Роман");
        book.setYear(1996);
        book.setQuantity(42);
    }

    @Test
    public void saveAndGetByName() throws Exception {
        bookService.save(book);
        Book newBook = bookService.getByName("Книга").get(0);
        Assert.assertTrue(book.equals(newBook));
        bookService.delete(newBook.getBookID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        bookService.save(book);
        book = bookService.getByName("Книга").get(0);
        book.setName("Не книга");
        bookService.update(book);
        Book newBook = bookService.get(book.getBookID());
        Assert.assertTrue(book.equals(newBook));
        bookService.delete(book.getBookID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        bookService.save(book);
        List<Book> books = bookService.getAll();
        int oldSize = books.size();
        bookService.delete(book.getBookID());
        books = bookService.getAll();
        Assert.assertEquals(oldSize - 1, books.size());
    }

}