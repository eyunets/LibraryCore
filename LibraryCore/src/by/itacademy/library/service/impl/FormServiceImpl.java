package by.itacademy.library.service.impl;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.VO.FormVO;
import by.itacademy.library.VO.transfer.FormTransfer;
import by.itacademy.library.dao.BookDAO;
import by.itacademy.library.dao.FormDAO;
import by.itacademy.library.dao.LibrarianDAO;
import by.itacademy.library.dao.ReaderDAO;
import by.itacademy.library.dao.impl.BookDAOImpl;
import by.itacademy.library.dao.impl.FormDAOImpl;
import by.itacademy.library.dao.impl.LibrarianDAOImpl;
import by.itacademy.library.dao.impl.ReaderDAOImpl;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;
import by.itacademy.library.service.BookService;
import by.itacademy.library.service.FormService;
import by.itacademy.library.service.ServiceException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FormServiceImpl extends AbstractService implements FormService {
    private static volatile FormService INSTANCE = null;

    private FormDAO formDAO = FormDAOImpl.getInstance();
    private BookDAO bookDAO = BookDAOImpl.getInstance();
    private ReaderDAO readerDAO = ReaderDAOImpl.getInstance();
    private LibrarianDAO librarianDAO = LibrarianDAOImpl.getInstance();
    private BookService bookService = BookServiceImpl.getInstance();

    private FormServiceImpl() {
    }

    @Override
    public Form save(Form form) {
        try {
            if (form != null) {
                startTransaction();
                form = formDAO.save(form);
                commit();
                return form;
            } else {
                throw new ServiceException("Form not defined");
            }
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating Form", e);
        }

    }

    @Override
    public Form get(Serializable id) {
        try {
            Form form;
            startTransaction();
            form = formDAO.get(id);
            commit();
            return form;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error getting Form", e);
        }
    }

    @Override
    public void update(Form form) {
        try {
            startTransaction();
            formDAO.update(form);
            commit();
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error updating Form", e);
        }
    }

    @Override
    public int delete(Serializable id) {
        try {
            startTransaction();
            int rows = formDAO.delete(id);
            commit();
            return rows;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error deleting Form", e);
        }
    }

    @Override
    public List<Form> getByReader(Reader reader) {
        ArrayList<Form> forms;
        try {
            startTransaction();
            forms = new ArrayList<>(formDAO.getByReader(reader));
            commit();
            return forms;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Form", e);
        }
    }

    @Override
    public List<Form> getByLibrarian(Librarian librarian) {
        ArrayList<Form> forms;
        try {
            startTransaction();
            forms = new ArrayList<>(formDAO.getByLibrarian(librarian));
            commit();
            return forms;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Form", e);
        }
    }

    @Override
    public List<Form> getByBook(Book book) {
        ArrayList<Form> forms;
        try {
            startTransaction();
            forms = new ArrayList<>(formDAO.getByBook(book));
            commit();
            return forms;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Form", e);
        }
    }

    @Override
    public List<Form> getByReceivalType(String receivalType) {
        ArrayList<Form> forms;
        try {
            startTransaction();
            forms = new ArrayList<>(formDAO.getByReceivalType(receivalType));
            commit();
            return forms;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Form", e);
        }
    }

    @Override
    public FormVO getFormVO(Form form) {
        try {
            startTransaction();
            FormVO formVO;
            Reader reader = readerDAO.get(form.getReaderID());
            Book book = bookDAO.get(form.getBookID());
            BookVO bookVO = bookService.getBookVO(book);
            Librarian librarian = librarianDAO.get(form.getLibrarianID());
            formVO = FormTransfer.toValueObject(form, bookVO, librarian, reader);
            commit();
            return formVO;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error creating formVO", e);
        }
    }

    @Override
    public List<Form> getAll() {
        ArrayList<Form> forms;
        try {
            startTransaction();
            forms = new ArrayList<>(formDAO.getAll());
            commit();
            return forms;
        } catch (SQLException e) {
            rollback();
            throw new ServiceException("Error finding Form", e);
        }
    }


    public static FormService getInstance() {
        FormService formService = INSTANCE;
        if (formService == null) {
            synchronized (FormServiceImpl.class) {
                formService = INSTANCE;
                if (formService == null) {
                    INSTANCE = formService = new FormServiceImpl();
                }
            }
        }

        return formService;
    }
}
