package fr.esgi.library.model;

import java.util.List;

public interface IBookRepository {

    List<Book> loadBooks();

    void writeBooks(List<Book> books);
}
