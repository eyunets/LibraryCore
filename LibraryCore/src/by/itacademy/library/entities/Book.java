package by.itacademy.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bookID;
    private String name;
    private String isbn;
    private String genre;
    private int year;
    private int quantity;
}
