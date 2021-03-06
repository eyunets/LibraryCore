package by.itacademy.library.dao;

import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;

import java.sql.SQLException;
import java.util.List;


public interface FormDAO extends DAO<Form> {
    /**
     * @param reader reader
     * @return List of forms matching the input
     * @throws SQLException
     */
    List<Form> getByReader(Reader reader) throws SQLException;

    /**
     * @param librarian librarian
     * @return List of forms matching the input
     * @throws SQLException
     */
    List<Form> getByLibrarian(Librarian librarian) throws SQLException;

    /**
     * @param book book
     * @return List of forms matching the input
     * @throws SQLException
     */
    List<Form> getByBook(Book book) throws SQLException;

    /**
     * @param receivalType receivalType
     * @return List of forms matching the input
     * @throws SQLException
     */
    List<Form> getByReceivalType(String receivalType) throws SQLException;

}
