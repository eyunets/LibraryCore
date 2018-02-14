package by.itacademy.library.web.command.enums;

import by.itacademy.library.web.command.Command;
import by.itacademy.library.web.command.impl.*;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CommandType {

    ADD_BOOK("admin/addBook.jsp", "addbook", new AddBookCommand()),
    ADD_AUTHOR("", "addauthor", new AddAuthorCommand()),
    CATALOG("catalog/main.jsp", "catalog", new CatalogCommand()),
    SEARCH_CATALOG("catalog/main.jsp", "searchcatalog", new SearchCatalogCommand()),
    BAN_READER_AJAX("", "banReader", new BanReaderCommand()),
    BOOK("catalog/book.jsp", "book", new BookCommand()),
    EDIT_BOOK("admin/editBook.jsp", "editBook", new EditBookCommand()),
    DELETE_BOOK("catalog/book.jsp", "deleteBook", new DeleteBookCommand()),
    EDIT_READER("cabinet/editReader.jsp", "editreader", new EditReaderCommand()),
    ERROR("error/error.jsp", "error", new ErrorCommand()),
    LOGIN("login.jsp", "login", new LoginCommand()),
    LOGIN_LIB("login.jsp", "loginlib", new LoginLibCommand()),
    LOGOUT("", "logout", new LogoutCommand()),
    MAIN("main/main.jsp", "main", new MainCommand()),
    MY_BOOKS("cabinet/myBooks.jsp", "mybooks", new MyBooksCommand()),
    NOT_FOUND("error/404.jsp", "404", new ErrorCommand()),
    ABOUT("about/main.jsp", "about", new AboutCommand()),
    READERS("admin/readers.jsp", "readers", new ReadersCommand()),
    RESERVE_BOOK_AJAX("", "reserveBook", new ReserveBookCommand()),
    RETURN_BOOK_AJAX("", "returnBook", new ReturnBookCommand()),
    SIGN_UP("login.jsp", "signup", new SignUpCommand());



    private String pagePath;
    private String pageName;
    private Command controller;

    /**
     * @param page page name
     * @return matching command type or MAIN by default
     */
    public static CommandType getByPageName(String page) {
        for (CommandType type : CommandType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
        return MAIN;
    }
}
