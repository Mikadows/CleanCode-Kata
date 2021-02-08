package fr.esgi.library.model.bookActions;

import fr.esgi.library.model.Book;
import fr.esgi.library.model.BookAction;
import fr.esgi.library.model.Library;

public class SeeBook implements BookAction {

    @Override
    public Library action(Library library, Book book) {
        for (Book bookOfLibrary : library.books()) {
            System.out.println(bookOfLibrary);
        }
        return library;
    }
}
