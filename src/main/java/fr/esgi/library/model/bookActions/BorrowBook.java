package fr.esgi.library.model.bookActions;

import fr.esgi.library.model.Book;
import fr.esgi.library.model.BookAction;
import fr.esgi.library.model.Library;

public class BorrowBook implements BookAction {

    @Override
    public Library action(Library library, Book book) {
        //TODO : Not implemented
        return library;
    }
}
