package by.itacademy.library.service;

import by.itacademy.library.entities.Author;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.BookAuthor;

import java.util.List;

public interface BookAuthorService extends Service<BookAuthor> {


    /**
     * @param author author
     * @return List of bookAuthors matching the input
     */
    List<BookAuthor> getByAuthorID(Author author);

    /**
     *
     * @param book book
     * @return List of bookAuthors matching the input
     */
    List<BookAuthor> getByBookID(Book book);


}
