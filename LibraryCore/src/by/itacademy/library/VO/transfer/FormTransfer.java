package by.itacademy.library.VO.transfer;

import by.itacademy.library.VO.BookVO;
import by.itacademy.library.VO.FormVO;
import by.itacademy.library.entities.Form;
import by.itacademy.library.entities.Librarian;
import by.itacademy.library.entities.Reader;

public class FormTransfer {
    public static FormVO toValueObject(Form form, BookVO bookVO, Librarian librarian, Reader reader) {
        FormVO formVO = new FormVO();
        formVO.setForm(form);
        formVO.setBookVO(bookVO);
        formVO.setLibrarian(librarian);
        formVO.setReader(reader);
        return formVO;
    }

    public static Form toEntity(FormVO formVO) {
        Form form = formVO.getForm();
        return form;
    }
}
