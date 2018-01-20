package by.itacademy.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    private int librarianID;
    private String name;
    private String surname;
    private String secondName;
    private String password;
    private String email;
}
