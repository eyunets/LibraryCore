package by.itacademy.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private int readerID;
    private String name;
    private String surname;
    private String secondName;
    private LocalDate birthday;
    private String password;
    private String email;
    private String gender;
    private String status;
}
