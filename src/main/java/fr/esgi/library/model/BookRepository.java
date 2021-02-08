package fr.esgi.library.model;

public class BookRepository {
    private final IBookRepository repository;

    public BookRepository(IBookRepository repository) {
        this.repository = repository;
    }

    public void saveLibrary(Library library) {
        this.repository.writeBooks(library.books());
    }

    public Library getLibrary() {
        return new Library(this.repository.loadBooks());
    }
}
