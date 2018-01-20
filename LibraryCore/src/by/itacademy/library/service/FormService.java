package by.itacademy.library.service;

import by.itacademy.library.VO.FormVO;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;

import java.util.List;


public interface FormService extends Service<Form> {


    /**
     * @param reader reader
     * @return List of forms matching the input
     */
    List<Form> getByReader(Reader reader);

    /**
     * @param librarian librarian
     * @return List of forms matching the input
     */
    List<Form> getByLibrarian(Librarian librarian);

    /**
     * @param book book
     * @return List of forms matching the input
     */
    List<Form> getByBook(Book book);

    /**
     * @param receivalType receivalType
     * @return List of forms matching the input
     */
    List<Form> getByReceivalType(String receivalType);

    /**
     * @param form form
     * @return Value object of the form
     */
    FormVO getFormVO(Form form);

}
