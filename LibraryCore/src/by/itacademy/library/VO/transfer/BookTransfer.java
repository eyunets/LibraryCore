package by.itacademy.library.VO.transfer;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.entities.Author;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Reader;

import java.util.ArrayList;
import java.util.List;


public class BookTransfer {
    public static BookVO toValueObject(Book book, List<Reader> readers, List<Author> authors) {
        BookVO bookVO = new BookVO();
        bookVO.setBook(book);
        bookVO.setAuthors(new ArrayList<>(authors));
        bookVO.setReaders(new ArrayList<>(readers));
        return bookVO;
    }

    public static Book toEntity(BookVO bookVO) {
        Book book = bookVO.getBook();
        return book;
    }
}
