package fr.esgi.library.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book sut;

    @BeforeEach
    public void setup(){
        this.sut = new Book("TITLE", "Test");
    }

    @Test
    public void bookTestNominal() {
        Book book = Book.of("TITLE", "Test");
        Assertions.assertEquals(this.sut, book);
        Assertions.assertEquals(this.sut.author(), book.author());
        Assertions.assertEquals(this.sut.title(), book.title());
    }

}
