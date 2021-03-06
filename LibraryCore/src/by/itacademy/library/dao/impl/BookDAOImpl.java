package by.itacademy.library.dao.impl;

import by.itacademy.library.dao.BookDAO;
import by.itacademy.library.db.ConnectionManager;
import by.itacademy.library.entities.Book;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Log4j
public class BookDAOImpl implements BookDAO {
    private static final String saveBookQuery = "INSERT INTO BOOKS (NAME, ISBN, GENRE, YEAR, QUANTITY) VALUES (?, ?, ?, ?, ?)";
    private static final String updateBookQuery = "UPDATE BOOKS SET NAME=?, ISBN=?, GENRE=?, YEAR=? ,QUANTITY=? WHERE BOOK_ID=?";
    private static final String getBookQuery = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
    private static final String getAllBooksQuery = "SELECT * FROM BOOKS";
    private static final String getBookByNameQuery = "SELECT * FROM BOOKS WHERE NAME=?";
    private static final String getBookByIsbnQuery = "SELECT * FROM BOOKS WHERE ISBN=?";
    private static final String getBookByGenreQuery = "SELECT * FROM BOOKS WHERE GENRE=?";
    private static final String deleteBookQuery = "DELETE FROM BOOKS WHERE BOOK_ID=?";
    private static volatile BookDAO INSTANCE = null;
    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetByName;
    private PreparedStatement psGetByIsbn;
    private PreparedStatement psGetByGenre;
    private PreparedStatement psGetAll;
    private PreparedStatement psDelete;

    {
        try {
            psSave = ConnectionManager.getConnection().prepareStatement(saveBookQuery, Statement.RETURN_GENERATED_KEYS);
            psUpdate = ConnectionManager.getConnection().prepareStatement(updateBookQuery);
            psGet = ConnectionManager.getConnection().prepareStatement(getBookQuery);
            psGetByName = ConnectionManager.getConnection().prepareStatement(getBookByNameQuery);
            psGetByIsbn = ConnectionManager.getConnection().prepareStatement(getBookByIsbnQuery);
            psGetByGenre = ConnectionManager.getConnection().prepareStatement(getBookByGenreQuery);
            psGetAll = ConnectionManager.getConnection().prepareStatement(getAllBooksQuery);
            psDelete = ConnectionManager.getConnection().prepareStatement(deleteBookQuery);
        } catch (SQLException e) {
            log.error(e);
        }
    }

    private BookDAOImpl() {
    }

    public static BookDAO getInstance() {
        BookDAO bookDAO = INSTANCE;
        if (bookDAO == null) {
            synchronized (BookDAOImpl.class) {
                bookDAO = INSTANCE;
                if (bookDAO == null) {
                    INSTANCE = bookDAO = new BookDAOImpl();
                }
            }
        }

        return bookDAO;
    }

    private static void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> list = new ArrayList<>();
        psGetAll.execute();
        ResultSet rs = psGetAll.getResultSet();
        while (rs.next()) {
            list.add(populateBook(rs));
        }
        close(rs);
        return list;
    }

    @Override
    public List<Book> getByName(String name) throws SQLException {
        List<Book> list = new ArrayList<>();
        psGetByName.setString(1, name);
        psGetByName.execute();
        ResultSet rs = psGetByName.getResultSet();
        while (rs.next()) {
            list.add(populateBook(rs));
        }
        close(rs);

        return list;
    }

    @Override
    public List<Book> getByIsbn(String isbn) throws SQLException {
        List<Book> list = new ArrayList<>();
        psGetByIsbn.setString(1, isbn);
        psGetByIsbn.execute();
        ResultSet rs = psGetByIsbn.getResultSet();
        while (rs.next()) {
            list.add(populateBook(rs));
        }
        close(rs);

        return list;
    }

    @Override
    public List<Book> getByGenre(String genre) throws SQLException {
        List<Book> list = new ArrayList<>();
        psGetByGenre.setString(1, genre);
        psGetByGenre.execute();
        ResultSet rs = psGetByGenre.getResultSet();
        while (rs.next()) {
            list.add(populateBook(rs));
        }
        close(rs);

        return list;
    }

    @Override
    public Book save(Book book) throws SQLException {
        psSave.setString(1, book.getName());
        psSave.setString(2, book.getIsbn());
        psSave.setString(3, book.getGenre());
        psSave.setInt(4, book.getYear());
        psSave.setInt(5, book.getQuantity());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            book.setBookID(rs.getInt(1));
        }
        close(rs);
        return book;
    }

    @Override
    public Book get(Serializable id) throws SQLException {
        psGet.setInt(1, (int) id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateBook(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Book book) throws SQLException {
        psUpdate.setInt(6, book.getBookID());
        psUpdate.setString(1, book.getName());
        psUpdate.setString(2, book.getIsbn());
        psUpdate.setString(3, book.getGenre());
        psUpdate.setInt(4, book.getYear());
        psUpdate.setInt(5, book.getQuantity());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete.setInt(1, (int) id);
        return psDelete.executeUpdate();
    }

    private Book populateBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookID(rs.getInt(1));
        book.setName(rs.getString(2));
        book.setIsbn(rs.getString(3));
        book.setGenre(rs.getString(4));
        book.setYear(rs.getInt(5));
        book.setQuantity(rs.getInt(6));
        return book;
    }
}

