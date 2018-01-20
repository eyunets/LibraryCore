package by.itacademy.library.dao;

import by.itacademy.library.entities.Librarian;

import java.sql.SQLException;
import java.util.List;

public interface LibrarianDAO extends DAO<Librarian> {

    /**
     * @param surname surname
     * @return List of librarians matching the input
     * @throws SQLException
     */
    List<Librarian> getBySurname(String surname) throws SQLException;

    /**
     *
     * @param login login
     * @return List of librarians matching the input
     * @throws SQLException
     */
    List<Librarian> getByLogin(String login) throws SQLException;
}
