package by.itacademy.library.dao;

import by.itacademy.library.entities.Reader;

import java.sql.SQLException;
import java.util.List;

public interface ReaderDAO extends DAO<Reader> {

    /**
     * @param surname surname
     * @return List of readers matching the input
     * @throws SQLException
     */
    List<Reader> getBySurname(String surname) throws SQLException;

    /**
     *
     * @param login login
     * @return List of readers matching the input
     * @throws SQLException
     */
    List<Reader> getByLogin(String login) throws SQLException;

    /**
     *
     * @param status status
     * @return List of readers matching the input
     * @throws SQLException
     */
    List<Reader> getByStatus(String status) throws SQLException;

}
