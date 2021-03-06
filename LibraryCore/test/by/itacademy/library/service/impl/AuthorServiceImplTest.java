package by.itacademy.library.service.impl;

import by.itacademy.library.entities.Author;
import by.itacademy.library.service.AuthorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;


public class AuthorServiceImplTest {
    private AuthorService authorService;
    private Author author;

    @Before
    public void createAuthor() {
        authorService = AuthorServiceImpl.getInstance();
        author = new Author();
        author.setName("����");
        author.setSecondName("��������");
        author.setSurname("������");
        author.setBirthday(LocalDate.of(1996, 12, 1));
        author.setCountry("������");
    }

    @Test
    public void saveAndGetBySurname() throws Exception {
        author = authorService.save(author);
        Author newAuthor = authorService.getBySurname("������").get(0);
        Assert.assertEquals(author.toString(), newAuthor.toString());
        authorService.delete(author.getAuthorID());
    }


    @Test
    public void getAndUpdate() throws Exception {

        author = authorService.get(1);
        String oldSurname = author.getSurname();
        String newSurname = "�������";
        author.setSurname(newSurname);
        authorService.update(author);
        Author newAuthor = authorService.get(author.getAuthorID());
        Assert.assertEquals(author.getSurname(), newAuthor.getSurname());
        newAuthor.setSurname(oldSurname);
        authorService.update(newAuthor);
    }

    @Test
    public void getAllAndDelete() throws Exception {

        authorService.save(author);
        List<Author> authors = authorService.getAll();
        int oldSize = authors.size();
        authorService.delete(author.getAuthorID());
        authors = authorService.getAll();
        Assert.assertEquals(oldSize - 1, authors.size());
    }

}