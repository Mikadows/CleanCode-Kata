package fr.esgi.library.model;

import fr.esgi.library.model.bookActions.AddBook;
import fr.esgi.library.model.bookActions.BorrowBook;
import fr.esgi.library.model.bookActions.SeeBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private final Map<String, BookAction> actions = new HashMap<>();

    public Library () {
        this.books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books = books;
    }

    public void loadUserActions(User user) {
        switch (user.type()) {
            case "guest":
                this.actions.put("see", new SeeBook());
                break;
            case "librarian":
                this.actions.put("see", new SeeBook());
                this.actions.put("add", new AddBook());
                break;
            case "member":
                this.actions.put("borrow", new BorrowBook());
                break;
            default:
                throw new RuntimeException("Invalid user type : " + user.type());
        }
    }

    public void doAction(String action, Book book) {
        try {
            this.books = this.actions.get(action)
                    .action(this, book).books();
        } catch (NullPointerException e) {
            throw new RuntimeException("Invalid action : " + action);
        }
    }

    public List<Book> books() {
        return books;
    }
}
