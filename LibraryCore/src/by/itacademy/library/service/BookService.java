package by.itacademy.library.service;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Book;

import java.util.List;


public interface BookService extends Service<Book> {

    /**
     * @param name
     * @return List of books matching the input
     */
    List<Book> getByName(String name);

    /**
     *
     * @param isbn isbn
     * @return List of books matching the input
     */
    List<Book> getByIsbn(String isbn);

    /**
     *
     * @param genre genre
     * @return List of books matching the input
     */
    List<Book> getByGenre(String genre);

    /**
     *
     * @param oldBook initial book
     * @param newBook updated info
     */
    void update(Book oldBook, Book newBook);

    /**
     * @param name book name or genre (case insensitive)
     * @return List of books matching the input
     */
    List<Book> searchByName(String name);

    /**
     * @param book book
     * @return Value object of the book
     */
    BookVO getBookVO(Book book);
}
