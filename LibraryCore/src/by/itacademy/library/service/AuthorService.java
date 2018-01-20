package by.itacademy.library.service;

import by.itacademy.library.entities.Author;

import java.util.List;


public interface AuthorService extends Service<Author> {

    /**
     * @param surname surname
     * @return List of authors matching the input
     */
    List<Author> getBySurname(String surname);

}
