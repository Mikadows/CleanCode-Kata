package fr.esgi.library;

import fr.esgi.library.model.Book;
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

        Library library = new Library();
        User user = new User(userType);
        Book book = Book.of(bookTitle, bookAuthor);

        System.out.println("Hello " + user.type());

        library.loadUserActions(user);
        library.doAction(action, book);

//        library.doAction("see", book);

    }

}
