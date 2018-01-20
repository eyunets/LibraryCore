package by.itacademy.library.dao;

import by.itacademy.library.entities.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDAO extends DAO<Author> {

    /**
     * @param surname surname
     * @return List of authors matching the input
     * @throws SQLException
     */
    List<Author> getBySurname(String surname) throws SQLException;

}
