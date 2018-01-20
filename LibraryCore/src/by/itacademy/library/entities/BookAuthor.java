package by.itacademy.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor {
    private int bookAuthorID;
    private int authorID;
    private int bookID;
}
