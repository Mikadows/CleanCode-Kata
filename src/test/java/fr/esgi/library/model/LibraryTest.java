package fr.esgi.library.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library sut;

    @BeforeEach
    public void setup() {
        this.sut = new BookRepository(new FakeRepository()).getLibrary();
        final User user = new User("guest");
        this.sut.loadUserActions(user);
    }

    @Test
    public void libraryLoadAllBooksNominalTest() {
        List<Book> books = List.of(
                Book.of("Title1", "Author1"),
                Book.of("Title2", "Author2"),
                Book.of("Title3", "Author3"),
                Book.of("Title4", "Author4"),
                Book.of("Title5", "Author5")
        );

        Assertions.assertEquals(this.sut.books(), books);
    }

    @Test()
    public void addBookToLibraryInvalidActionUserGuestTest() {
        Book book = Book.of("TEST", "test");
        Assertions.assertThrows(RuntimeException.class, () -> this.sut.doAction("add", book));
    }

    @Test()
    public void addBookToLibraryInvalidActionUserMemberTest() {
        this.sut = new Library(this.sut.books());
        this.sut.loadUserActions(new User("member"));
        Book book = Book.of("TEST", "test");
        Assertions.assertThrows(RuntimeException.class, () -> this.sut.doAction("add", book));
    }

    @Test
    public void borrowBookInvalidActionTest() {
        Book book = Book.of("TEST", "test");
        Assertions.assertThrows(RuntimeException.class, () -> this.sut.doAction("borrow", book));
    }


    public static class FakeRepository implements IBookRepository {

        @Override
        public List<Book> loadBooks() {
            return List.of(
                    Book.of("Title1", "Author1"),
                    Book.of("Title2", "Author2"),
                    Book.of("Title3", "Author3"),
                    Book.of("Title4", "Author4"),
                    Book.of("Title5", "Author5")
            );
        }

        @Override
        public void writeBooks(List<Book> books) {

        }
    }
}
