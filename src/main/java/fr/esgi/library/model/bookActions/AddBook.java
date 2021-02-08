package fr.esgi.library.model.bookActions;

import fr.esgi.library.model.Book;
import fr.esgi.library.model.BookAction;
import fr.esgi.library.model.Library;

import java.util.List;

public class AddBook implements BookAction {
    @Override
    public Library action(Library library, Book book) {
        List<Book> books = library.books();
        books.add(book);
        return new Library(books);
    }
}
