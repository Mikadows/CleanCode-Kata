package fr.esgi.library;

import fr.esgi.library.infra.BookRepositoryPersistence;
import fr.esgi.library.model.Book;
import fr.esgi.library.model.BookRepository;
import fr.esgi.library.model.Library;
import fr.esgi.library.model.User;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run(args);
    }

    public void run(String[] args) {
        final String userType = args[0];
        final String action = args[1];
        final String bookTitle = args.length >= 3 ? args[2] : "Default title";
        final String bookAuthor = args.length >= 4 ? args[3] : "Default author";
        final BookRepository bookRepository = new BookRepository(new BookRepositoryPersistence());

        final Library library = bookRepository.getLibrary();

        final User user = new User(userType);
        final Book book = Book.of(bookTitle, bookAuthor);

        library.loadUserActions(user);
        library.doAction(action, book);

        bookRepository.saveLibrary(library);
    }

}
