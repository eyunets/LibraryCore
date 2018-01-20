package by.itacademy.library.dao;

import by.itacademy.library.entities.Author;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.BookAuthor;

import java.sql.SQLException;
import java.util.List;

public interface BookAuthorDAO extends DAO<BookAuthor> {

    /**
     * @param author author
     * @return List of bookAuthors matching the input
     * @throws SQLException
     */
    List<BookAuthor> getByAuthorID(Author author) throws SQLException;

    /**
     *
     * @param book book
     * @return List of bookAuthors matching the input
     * @throws SQLException
     */
    List<BookAuthor> getByBookID(Book book) throws SQLException;

}
