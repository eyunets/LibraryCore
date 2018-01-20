package by.itacademy.library.dao.impl;

import by.itacademy.library.dao.FormDAO;
import by.itacademy.library.entities.Form;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class FormDAOImplTest {
    private FormDAO formDAO;
    private Form form;

    @Before
    public void createForm() {
        formDAO = FormDAOImpl.getInstance();
        form = new Form();
        form.setBookID(5);
        form.setReaderID(3);
        form.setLibrarianID(2);
        form.setReceivalType("‘ормул€р");
        form.setReceivalDate(LocalDate.now());
        form.setReturnDate(LocalDate.now().plus(14, ChronoUnit.DAYS));
    }

    @Test
    public void saveAndGetByReceivalType() throws Exception {
        form = formDAO.save(form);
        Form newForm = formDAO.getByReceivalType("‘ормул€р").get(0);
        Assert.assertEquals(form.toString(), newForm.toString());
        formDAO.delete(newForm.getFormID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        form = formDAO.save(form);
        form.setReceivalType("‘ормул€рpp");
        formDAO.update(form);
        Form newForm = formDAO.get(form.getFormID());
        Assert.assertEquals(form.toString(), newForm.toString());
        formDAO.delete(form.getFormID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        form = formDAO.save(form);
        List<Form> forms = formDAO.getAll();
        int oldSize = forms.size();
        formDAO.delete(form.getFormID());
        forms = formDAO.getAll();
        Assert.assertEquals(oldSize - 1, forms.size());
    }

}