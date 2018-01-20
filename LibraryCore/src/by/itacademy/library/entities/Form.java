package by.itacademy.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    private int formID;
    private int bookID;
    private int readerID;
    private int librarianID;
    private String receivalType;
    private LocalDate receivalDate;
    private LocalDate returnDate;
}
