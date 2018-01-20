package by.itacademy.library.service;

import by.itacademy.library.entities.Librarian;

import java.util.List;


public interface LibrarianService extends Service<Librarian> {

    /**
     * @param surname surname
     * @return List of librarians matching the input
     */
    List<Librarian> getBySurname(String surname);

    /**
     *
     * @param login login
     * @return Librarian matching the input
     */
    Librarian getByLogin(String login);


}
