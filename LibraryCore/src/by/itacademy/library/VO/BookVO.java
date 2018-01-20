package by.itacademy.library.VO;

import by.itacademy.library.entities.Author;
import by.itacademy.library.entities.Book;
import by.itacademy.library.entities.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookVO {
    private Book book;
    private List<Author> authors = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
}
